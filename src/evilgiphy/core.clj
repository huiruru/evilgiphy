(ns evilgiphy.core
  (:require [clj-http.client :as client]
            [cheshire.core :as json]))

(def api-key "dc6zaTOxFJmzC")

(def url "http://api.giphy.com")

(defn get-api 
  "searches giphy using search api given input path and search term"
  [path search-term]
  (let [search-url (str url path)
       query-params {:q search-term :api_key api-key :limit 10 :sort "relevant"}
       response (:body (client/get search-url {:query-params query-params}))
       data (:data (json/parse-string response true))]
    data))
