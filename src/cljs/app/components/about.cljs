(ns app.components.about
  (:require [helix.core :refer [defnc]]
            [helix.dom :as d]))

(defnc about []
  (d/div {:class '[py-32 text-center]}
    (d/h2 {:class '[font-extrabold text-4xl]} "About")))
