(defproject giphycb "0.1.0-SNAPSHOT"
  :description "Demonstrates the use of the World Bank API"
  :url "https://github.com/clojurebridge/global-growth"
  :license {:name "Creative Commons Attribution License"
            :url "http://creativecommons.org/licenses/by/3.0/"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [ring "1.6.1"]
                 [compojure "1.6.0"]]
  :plugins [[lein-ring "0.8.10"]]
  :ring {:handler giphycb.web/handler}
  :main ^:skip-aot giphycb.core
  :target-path "target/%s")
