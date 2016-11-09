(ns huiyin.components.jumbotron
  (:refer-clojure :exclude [rem])
  (:require
   [garden.units :refer [px rem]]
   [huiyin.variables :refer [transition-time headline-color-invert]]
   [huiyin.data :refer [messages]]))

(defn render [state]
  (let [height (get @state :jumbotron-height)]
    [:section.jumbotron {:style {:height height}}
     [:h1 (:title messages)]]))

(def ^:private jumbotron-style
  [[:.jumbotron {:display :flex
                 :padding [[0 (rem 1)]]
                 :align-items :center
                 :justify-content :center
                 :background [["url(/images/home.jpg)" :no-repeat :center :bottom]]
                 :background-size :center
                 :max-height (px 1024)
                 :transition [[:all transition-time]]}

    [:h1 {:color headline-color-invert
          :font-family ["\"A2 60 Display Regular\"" "\"Arial Black\"" "Arial" "Helvetica" "Verdana" "sans-serif"]
          :transform "translateY(-50px)"
          :text-align :center}]]])
(def css
  [jumbotron-style])
