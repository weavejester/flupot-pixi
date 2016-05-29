(ns flupot.pixi
  (:require [flupot.core :as core]))

(def functions
  '{stage         ReactPIXI.Stage
    sprite        ReactPIXI.Sprite
    sprite-batch  ReactPIXI.SpriteBatch
    tiling-sprite ReactPIXI.TilingSprite
    text          ReactPIXI.Text
    bitmap-text   ReactPIXI.BitmapText
    container     ReactPIXI.DisplayObjectContainer})

(defn- factory-fn [sym]
  (symbol "flupot.pixi" (str sym "-factory")))

(defmacro define-pixi-factories []
  `(do ~@(for [[sym elemf] functions]
           `(def ~(-> sym factory-fn name symbol)
              (React.createFactory ~elemf)))))

(defmacro define-pixi-fns []
  `(do ~@(for [[sym _] functions]
           `(core/defelement-fn ~sym
              :elemf ~(factory-fn sym)))))

(defmacro define-pixi-macros []
  `(do ~@(for [[sym _] functions]
           `(core/defelement-macro ~sym
              :elemf ~(factory-fn sym)))))

(define-pixi-macros)
