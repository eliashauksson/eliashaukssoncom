(ns app.components.contact
  (:require [helix.core :refer [defnc]]
            [helix.dom :as d]))

(defnc contact []
  (d/div {:class '[py-32 text-center]}
    (d/h2 {:class '[font-extrabold text-4xl]} "Contact")))
