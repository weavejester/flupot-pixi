(defproject flupot/pixi "0.1.0"
  :description "A ClojureScript wrapper around the react-pixi library"
  :url "https://github.com/weavejester/flupot-pixi"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/clojurescript "1.7.228"]
                 [flupot "0.4.0"]
                 [cljsjs/react-pixi "0.8.1-0"]]
  :plugins [[lein-cljsbuild "1.1.3"]]
  :cljsbuild
  {:builds {:main {:source-paths ["src"]
                   :compiler {:output-to "target/main.js"
                              :optimizations :whitespace
                              :main example.core}}}})
