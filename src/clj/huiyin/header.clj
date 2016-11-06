(ns huiyin.header
  (:require
   [garden.def :refer [defstyles defrule defcssfn]]
   [garden.selectors :refer [&]])
  (:use [huiyin.selectors]
        [garden.color :refer [rgb rgba]]
        [garden.units :refer [px percent]]))

(defcssfn scale)

(defstyles header-logo-style
  [:#logo {:display :flex
           :flex-direction :row
           :align-items :center}

   [:svg {:transition [[:transform transition-time]
                       [:margin-right transition-time]]
          :margin-right (px 8)
          :width (px 80)
          :height (px 80)
          :fill logo-color
          :transform (scale 1)}]

   [:h1 {:font-size (px 20)
         :white-space :nowrap
         :color logo-color}]]

  [:.compact {:height (px 77)
                    :background-color dimmer-color}
   [:#logo
    [:svg {:transform (scale 0.6)
           :margin-right (px -8)}]]])

(defstyles header-style
  [:header {:position :fixed
            :width (percent 100)
            :height (px 140)
            :z-index 100
            :transition (for [attr [:height :background-color]]
                          [attr transition-time])
            :background-color (rgba 0 0 0 0)}

   [:>.container {:display :flex
                  :align-items :center
                  :justify-content :space-between
                  :height (percent 100)}]

   [:nav {:display :flex
          :flex-direction :row}]

   [:a {:margin [[0 (px 24)]]
        :font-size (px 22)}]])

(defstyles resizable-header-style
  header-style
  header-logo-style)
