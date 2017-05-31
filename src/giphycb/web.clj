(ns giphycb.web
  (:require [giphycb.core :as api]
            [compojure.core :refer [defroutes GET]]
            [compojure.handler :refer [site]]
            [compojure.route :as route]
            [hiccup.core :as hiccup]
            [hiccup.page :as page]
            [hiccup.form :as form]))

(defn layout
  [title & content]
  (page/html5
   [:head
    [:title title]
    (page/include-css "//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css")
    (page/include-css "//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap-theme.min.css")
    [:meta {:name "viewport" :content "width=device-width, initial-scale=1"}]]
   [:body
    [:nav.navbar.navbar-default {:role "navigation"}
     [:div.container-fluid
      [:div.navbar-header
       [:a.navbar-brand {:href "/"} "ClojureBridge Giphy Fun"]]]]
    [:div.container
     content]]))

(defn main-page []
  (layout "Giphy Fun"
          [:h1 "Giphy Fun"]
          [:p "你好，世界!"]))

(defroutes main-routes
  (route/resources "/")
  (GET "/" [] (main-page)))

(def handler (site main-routes))
