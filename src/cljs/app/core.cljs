(ns app.core
  (:require [app.components.home :refer [home]]
            [app.components.about :refer [about]]
            [helix.core :refer [defnc $]]
            [helix.dom :as d]
            ["react-dom" :as rdom]
            ["react-router-dom" :refer [BrowserRouter, Route, Switch]]))

(defnc app []
  ($ BrowserRouter
    (d/div
      (d/nav {:class '[flex justify-between items-center h-16 bg-white text-black relative shadow-sm font-mono]
              :role "navigation"}
        (d/h1 {:class '[pl-8]} "Navbar")
        (d/div {:class '[px-4 cursor-pointer md:hidden]}
         (d/i {:class '[w-6 h-6]
               :class-name "fas fa-bars"}))
        (d/div {:class '[pr-8 md:block hidden]}
          (d/a {:class '[p-4]
                :href "/"} "Home")
          (d/a {:class '[p-4]
                :href "/about"} "About")))
      ($ Switch
        ($ Route {:path "/about"} ($ about))
        ($ Route {:path "/"} ($ home))))))

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
