(ns example.core
  (:require [brutha.core :as br]
            [flupot.dom :as dom]))

(enable-console-print!)

(defn content []
  (dom/p "Hello World"))

(let [app (.getElementById js/document "app")]
  (br/mount (content) app))
