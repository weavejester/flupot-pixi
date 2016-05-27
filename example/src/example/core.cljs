(ns example.core
  (:require [brutha.core :as br]
            [flupot.pixi :as pixi]))

(enable-console-print!)

(defn content []
  (pixi/stage
   {:width 400, :height 300}
   (pixi/text {:x 100, :y 100, :text "Hello World"})))

(let [app (.getElementById js/document "app")]
  (br/mount (content) app))
