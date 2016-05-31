(defproject flupot.pixi/example "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/clojurescript "1.7.228"]
                 [flupot "0.4.0"]
                 [flupot/pixi "0.1.0"]
                 [brutha "0.2.0"]
                 [ring "1.5.0-RC1"]]
  :plugins [[lein-cljsbuild "1.1.3"]]
  :cljsbuild
  {:builds {:main {:source-paths ["src"]
                   :compiler {:output-to "target/cljs/example/public/main.js"
                              :optimizations :whitespace
                              :main example.core}}}}
  :profiles
  {:dev {:resource-paths ["target/cljs"]
         :prep-tasks [["cljsbuild" "once"]]
         :main example.server}})
