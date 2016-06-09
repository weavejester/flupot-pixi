(ns example.core
  (:require [brutha.core :as br]
            [flupot.pixi :as pixi]
            [flupot.dom :as dom]))

(enable-console-print!)

(defn- blur-filter [blur]
  (let [filter (PIXI.filters.BlurFilter.)]
    (set! (.-blur filter) blur)
    filter))

(def canvas
  (let [filter (blur-filter 15)]
    (.log js/console filter)
    (br/component
     (fn [{:keys [rotation]}]
       (pixi/stage
        {:width 400, :height 300}
        (pixi/text {:x 100, :y 100, :rotation rotation, :text "Hello World"})
        (pixi/sprite {:x 300, :y 100
                      :rotation rotation
                      :image "bunny.png"
                      :filters [filter]}))))))

(def content
  (br/component
   (fn [state]
     (dom/div
      (dom/p "Example")
      (canvas state)))))

(defn bind [state component root]
  (br/mount (component @state) root)
  (add-watch state ::bind (fn [_ _ _ s] (br/mount (component s) root))))

(defn animate [state]
  (swap! state update :rotation + 0.01)
  (js/setTimeout #(animate state) 16))

(let [state (atom {:rotation 0})
      app   (.getElementById js/document "app")]
  (bind state content app)
  (animate state))
