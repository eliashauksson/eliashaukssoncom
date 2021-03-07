(ns app.components.home
  (:require [helix.core :refer [defnc]]
            [helix.dom :as d]))

(defnc home []
  (d/div {:class '[relative bg-yellow-300 flex-grow]}
    (d/div {:class '[absolute w-full h-96 bg-white inset-x-0 bottom-10 transform-gpu -skew-y-6 xl:-skew-y-3 -translate-y-36 z-0 pointer-events-none]})
    (d/div {:class '[absolute w-full h-96 bg-white inset-x-0 bottom-0 z-0]})
    (d/div {:class '[relative py-32 text-center]}
      (d/h2 {:class '[font-extrabold text-4xl]} "Home"))))
