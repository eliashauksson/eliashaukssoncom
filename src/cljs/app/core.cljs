(ns app.core
  (:require [app.components.navbar :refer [navbar]]
            [helix.core :refer [defnc $]]
            [helix.dom :as d]
            ["react-dom" :as rdom]))

(def app-style {:box-sizing "border-box"
                :margin 0
                :padding 0
                :font-family "Montserrat, sans-serif"})

(defnc app []
  (d/div {:style app-style}
    ($ navbar)))

(defn render []
  (rdom/render ($ app) (js/document.getElementById "root")))

(defn ^:dev/after-load start []
  (js/console.log "Start")
  (render))

(defn ^:export init []
  (js/console.log "Init")
  (start))

(defn ^:dev/before-load stop []
  (js/console.log "Stop"))
