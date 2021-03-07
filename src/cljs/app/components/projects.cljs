(ns app.components.projects
  (:require [helix.core :refer [defnc]]
            [helix.dom :as d]))

(defnc projects []
  (d/div {:class '[py-32 text-center]}
    (d/h2 {:class '[font-extrabold text-4xl]} "Projects")))
