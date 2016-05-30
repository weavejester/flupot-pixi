(ns example.server
  (:require [ring.adapter.jetty :refer [run-jetty]]
            [ring.middleware.resource :refer [wrap-resource]]))

(defn handler [request]
  {:status 404
   :headers {"Content-Type" "text/plain; charset=UTF-8"}
   :body "Not found"})

(defn -main
  ([] (-main "4000"))
  ([port]
   (println (str "Running test server at: http://localhost:" port "/example.html"))
   (run-jetty
    (wrap-resource handler "example/public")
    {:port (Integer/parseInt port)})))
