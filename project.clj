(defproject evilgiphy "0.1.0-SNAPSHOT"
  :description "Searches for evil giphys"
  :url "https://cryptic-hamlet-97529.herokuapp.com/"
  :license {:name "Creative Commons Attribution License"
            :url "http://creativecommons.org/licenses/by/3.0/"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [ring "1.6.1"]
                 [compojure "1.6.0"]
                 [cheshire "5.7.1"]
                 [hiccup "1.0.5"]
                 [clj-http "3.6.0"]]
  :plugins [[lein-ring "0.8.10"]]
  :min-lein-version "2.0.0"
  :ring {:handler evilgiphy.web/handler}
  :main ^:skip-aot evilgiphy.core
  :target-path "target/%s")
