(ns giphycb.web
  (:require [giphycb.core :as api]
            [compojure.core :refer [defroutes GET]]
            [compojure.handler :refer [site]]
            [compojure.route :as route]))

(defn rand-hello []
  (rand-nth ["Hello world!" "你好 世界!", "Bonjour le monde!", "Ciao mondo!"
             "안녕 세상!" "سلام دنیا" "Hola honua!" "Hei verden!" "Hallo welt!"]))

(defn main-page []
  (rand-hello))

(defroutes main-routes
  (route/resources "/")
  (GET "/" [] (main-page)))

(def handler (site main-routes))
