(ns clj.app.handler
  (:require [compojure.core :refer [defroutes GET]]
            [compojure.route :as route]
            [ring.middleware.resource :refer [wrap-resource]]
            [ring.util.response :refer [resource-response]])
  (:gen-class))


(defroutes app-routes
  (GET "/" [] 
    (resource-response "public/index.html"))
  (route/not-found "Not Found"))

(def app
  (-> app-routes
      (wrap-resource "public")))
