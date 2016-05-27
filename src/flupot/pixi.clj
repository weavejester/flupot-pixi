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

(defmacro define-pixi-fns []
  `(do ~@(for [[sym elemf] functions]
           `(core/defelement-fn ~sym
              :elemf ~elemf))))

(defmacro define-pixi-macros []
  `(do ~@(for [[sym elemf] functions]
           `(core/defelement-macro ~sym
              :elemf ~elemf))))

(define-pixi-macros)
