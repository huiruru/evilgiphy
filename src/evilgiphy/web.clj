(ns evilgiphy.web
  (:require [evilgiphy.core :as api]
            [compojure.core :refer [defroutes GET]]
            [compojure.handler :refer [site]]
            [compojure.route :as route]
            [hiccup.core :as hiccup]
            [hiccup.page :as page]
            [hiccup.form :as form]))

(defn layout 
  "layout function"
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
        [:a.navbar-brand {:href "/"} "Clojurebridge Evil Giphy Fun"]]]]
     [:div.container
      content]]))

(defn rand-hello []
  (rand-nth ["Hello world!" "你好 世界!", "Bonjour le monde!", "Ciao mondo!"
             "안녕 세상!" "سلام دنیا" "Hola honua!" "Hei verden!" "Hallo welt!"]))

(defn evil-mode [term]
  (let [evil-search-term (str "evil " term)]
  evil-search-term))

(defn giphy-gif-src [gif]
    (get-in gif [:images :downsized :url]))

(defn giphy-img [gif]
    [:img {:src (giphy-gif-src gif)}])

(defn unordered-list
    [coll]
    [:ul
        (for [list-item coll]
               [:li list-item])])

(defn giphy-search
  "calls get-api to get giphy stuff"
  [search-term]
  (let [results (api/get-api "/v1/gifs/search" search-term)]
  (layout "giphy search"
          [:h1 "Results"]
          (unordered-list
            (map giphy-img results)))))

(defn main-page []
;;  (layout "poop" (rand-hello))
  (layout "Giphy Evil Search Page"
          [:h1 "Search Evil Giphy!"]
          (form/form-to {:role "form"} [:get "/results"]
                       [:div.row
                       [:div.form-group.col-md-5
                        (form/label "search-term" "Giphy Evil Search: ")
                        (form/text-field "search-term")
                        (form/submit-button "Submit")]]))
  )

(defroutes main-routes
  (route/resources "/")
  (GET "/" [] (main-page))
  (GET "/results" [search-term] (giphy-search (evil-mode search-term))))

(def handler (site main-routes))
