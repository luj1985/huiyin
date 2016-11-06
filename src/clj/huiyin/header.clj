(ns huiyin.header
  (:require
   [garden.def :refer [defstyles defrule defcssfn]]
   [garden.stylesheet :refer [at-media]]
   [garden.selectors :refer [&]]
   [huiyin.variables :refer :all])
  (:use [huiyin.selectors]
        [garden.color :refer [rgb rgba]]
        [garden.units :refer [px percent]]))

(defstyles header-logo-style
  [:#logo {:display :flex
           :flex-direction :row
           :align-items :center
           :margin-left (px 8)}

   [:svg {:transition [[:all transition-time]]
          :width (px logo-size)
          :height (px logo-size)
          :fill logo-color
          :transform (scale 1)}]

   [:h1 {:font-size (px 20)
         :transition [[:all transition-time]]
         :margin [[0 0 0 (px 16)]]
         :white-space :nowrap
         :color logo-color}]]

  [:.compact {:height (px 77)
              :background-color dimmer-color}
   [:#logo
    [:svg {:transform (scale 0.8)
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
                  :height (percent 100)
                  :padding [[0 (px 8)]]}]

   [:nav {:display :flex
          :flex-direction :row}]

   [:a {:margin [[0 (px 24)]]
        :font-size (px 22)
        :white-space :nowrap}]])

(defstyles mobile-header-logo-style
  [:header
   [:#logo
    [:svg {:transform (scale 1)}]
    [:h1 {:display :none}]]
   [:a {:font-size (px 16)
        :margin [[0 (px 12)]]}]]
  [:.compact
   [:#logo
    [:svg {:transform [[(scale 0.78) (translateX (px -16))]]}]]])

#_(defstyles mobile-header-logo-style
    [:header
     [:>.container {:flex-direction :column
                    :align-items :flex-start
                    :justify-content :center}
      [:nav {:opacity 0
             :transition [[:all transition-time]]}]]
     [:#logo
      [:h1 {:font-size (px 20)}]]
     [:a {:font-size (px 16)
          :margin [[0 (px 12)]]}]]
    [:header.compact {:height (px 90)}
     [:>.container
      [:nav {:opacity 1
             :transform (translateY (px -8))}]]
     [:#logo
      [:h1 {:transform (translateX (px -32))}]
      [:svg {:transform [[(scale 0.5) (translateX (px -32))]]}]]])

(defstyles mobile-header-style
  (at-media
   {:max-width (px 767)}
   mobile-header-logo-style))

(defstyles resizable-header-style
  header-style
  header-logo-style
  mobile-header-style)
