(ns app.components.navbar
  (:require [app.components.navbarstyles :as style]
            [helix.core :refer [defnc]]
            [helix.hooks :as hooks]
            [helix.dom :as d]))

(def max-screensize 800)

(def menu-items [["Home" "#"]
                 ["About" "#"]
                 ["Projects" "#"]
                 ["Contact" "#"]])

(defnc navbar []
  (js/console.log (str "screensize: " js/window.innerWidth))
  (let [[state set-state] (hooks/use-state false)]
    (d/nav {:style (if (> js/window.innerWidth max-screensize)
                     style/navbar-items-desktop
                     style/navbar-items-mobile)}
      (d/h1 {:style (if (> js/window.innerWidth max-screensize)
                      style/navbar-logo-desktop
                      style/navbar-logo-mobile)} 
            "Elias Hauksson")
      (d/div {:on-click #(set-state (not state))
              :style (if (> js/window.innerWidth max-screensize)
                       style/menu-icon-desktop
                       style/menu-icon-mobile)}
        (d/i {:class-name (if state "fas fa-times" "fas fa-bars")
              :style style/burger}))
      (d/ul {:style (if (> js/window.innerWidth max-screensize)
                      style/nav-menu-desktop
                      (if state
                        style/nav-menu-mobile-active
                        style/nav-menu-mobile))}
        (map-indexed (fn [idx item]
                       (d/li {:key idx}
                             (d/a {:style (if (> js/window.innerWidth max-screensize)
                                            style/nav-links-desktop
                                            style/nav-links-mobile)
                                   :href (nth item 1)}
                                  (nth item 0))))
                     menu-items)))))
