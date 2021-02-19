(ns app.components.navbarstyles)

(def navbar-items {:background-color "#6E5EFE"
                   :height "80px"
                   :display "flex"
                   :justify-content "center"
                   :align-items "center"
                   :font-size "1.2rem"})

(def navbar-items-desktop navbar-items)

(def navbar-items-mobile (merge navbar-items
                                {:position "relative"}))

(def navbar-logo {:color "#FFF"
                  :justify-self "start"
                  :margin-left "20px"
                  :cursor "pointer"})

(def navbar-logo-desktop navbar-logo)

(def navbar-logo-mobile (merge navbar-logo
                               {:position "absolute"
                                :top 0
                                :left 0
                                :transform "translate(10%, 50%)"}))

(def nav-menu {:display "grid"
               :grid-template-columns "repeat(5, auto)" 
               :grid-gap "10px"
               :list-style "none"
               :text-align "center"
               :width "65vw"
               :justify-content "end"
               :margin-right "2rem"})

(def nav-menu-desktop nav-menu)

(def nav-menu-mobile (merge nav-menu
                            {:display "flex"
                             :flex-direction "column"
                             :width "100%"
                             :height "320px"
                             :position "absolute"
                             :top "80px"
                             :left "-100%"
                             :opacity 1
                             :transition "all 0.5s ease"}))

(def nav-menu-mobile-active (merge nav-menu-mobile
                                   {:background "#6E5EFE"
                                    :left 0
                                    :opacity 1
                                    :transition "all 0.5s ease"
                                    :z-Index 1}))

(def nav-links {:color "white"
                :text-decoration "none"
                :padding "0.5rem 1rem"})

(def nav-links-desktop nav-links)

(def nav-links-mobile (merge nav-links
                             {:text-align "center"
                              :padding "1.5rem 0"
                              :width "100%"
                              :display "table"}))

(def burger {:color "white"})

(def menu-icon {:display "block"
                :position "absolute"
                :top 0
                :right 0
                :transform "translate(-100%, 60%)"
                :font-size "1.8rem"
                :cursor "pointer"})

(def menu-icon-desktop (merge menu-icon
                              {:display "none"}))

(def menu-icon-mobile menu-icon)
