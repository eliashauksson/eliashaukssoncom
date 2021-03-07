(ns app.components.resume
  (:require [helix.core :refer [defnc]]
            [helix.dom :as d]))

(defnc resume []
  (d/div {:class '[py-32 text-center]}
    (d/h2 {:class '[font-extrabold text-4xl]} "Resume")))
