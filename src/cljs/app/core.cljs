(ns app.core
  (:require [app.components.home :refer [home]]
            [app.components.about :refer [about]]
            [app.components.projects :refer [projects]]
            [app.components.contact :refer [contact]]
            [app.components.resume :refer [resume]]
            [helix.core :refer [defnc $]]
            [helix.hooks :as hooks]
            [helix.dom :as d]
            ["react-dom" :as rdom]
            ["react-router-dom" :refer [BrowserRouter, Route, Switch]]))

(defnc app []
  (let [[mobile toggle-mobile] (hooks/use-state false)]
    ($ BrowserRouter
      (d/div {:class '[h-full flex flex-col overflow-hidden]}
        ;navbar
        (d/nav {:class '[bg-yellow-300]}
          (d/div {:class '[max-w-6xl mx-auto]}
            (d/div {:class '[flex justify-between]}
              ;logo
              (d/div {:class '[flex items-center space-x-1]}
                (d/a {:class '[py-5 px-6 font-bold text-xl md:text-3xl]
                      :href "/"} "Elias Hauksson"))
              ;navbar items
              (d/div {:class '[hidden md:flex flex items-center space-x-1 mr-2]}
                (d/a {:class '[py-5 px-3]
                      :href "/"} "Home")
                (d/a {:class '[py-5 px-3]
                      :href "/about"} "About")
                (d/a {:class '[py-5 px-3]
                      :href "/projects"} "Projects")
                (d/a {:class '[py-5 px-3]
                      :href "/contact"} "Contact")
                (d/a {:class '[py-3 px-3 bg-black rounded text-white]
                      :href "/resume"} "Resume"))
              ;mobile button
              (d/div {:class '[md:hidden flex items-center]}
                (d/button {:class '[focus:outline-none]
                           :on-click #(toggle-mobile (not mobile))}
                  (d/i {:class (conj '[h-6 w-6 text-xl mx-3] (if mobile "fas fa-times" "fas fa-bars"))}))))
            ;mobile menu
            (d/div {:class (conj '[md:hidden] (if mobile "" "hidden"))}
              (d/a {:class '[block py-2 px-4 text-sm hover:bg-yellow-200]
                    :href "/"} "Home")
              (d/a {:class '[block py-2 px-4 text-sm hover:bg-yellow-200]
                    :href "/about"} "About")
              (d/a {:class '[block py-2 px-4 text-sm hover:bg-yellow-200]
                    :href "#"} "Projects")
              (d/a {:class '[block py-2 px-4 text-sm hover:bg-yellow-200]
                    :href "#"} "Contact")
              (d/a {:class '[block py-2 px-4 text-sm hover:bg-yellow-200]
                    :href "#"} "Resume"))))
        ($ Switch
          ($ Route {:path "/about"} ($ about))
          ($ Route {:path "/projects"} ($ projects))
          ($ Route {:path "/contact"} ($ contact))
          ($ Route {:path "/resume"} ($ resume))
          ($ Route {:path "/"} ($ home)))))))

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
