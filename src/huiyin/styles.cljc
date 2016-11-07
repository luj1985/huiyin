(ns huiyin.styles
  (:require [garden.color :refer [rgb rgba]]
            [garden.units :refer [px percent ms]]
            [garden.stylesheet :refer [rule at-media]]
            [huiyin.variables :refer [white black text-color transition-time]]
            [huiyin.components.header :as h]
            [huiyin.components.footer :as f]
            [huiyin.components.sections :as c]))

(def reset-style
  (list
   [:html {:-moz-osx-font-smoothing :grayscale
           :-webkit-font-smoothing :antialiased
           :margin 0
           :padding 0}]

   [:body {:font-family ["Calibre" "Helvetica" "Arial" "sans-serif"]
           :font-size (px 16)
           :line-height 1
           :margin 0
           :padding 0}]

   [:h2 {:font-size (px 30)
         :color black}]

   [:h3 {:font-size (px 25)
         :color white
         :margin [[(px 20) 0]]}]

   [:p {:color text-color
        :font-size (px 16)
        :font-weight :normal
        :line-height 1.3}]

   [:#app {:position :relative
           :margin 0
           :padding 0}]))

(def container-style
  (list
   [:.container {:position :relative
                 :padding-left (px 16)
                 :padding-right (px 16)
                 :max-width (px 1170)
                 :margin-left :auto
                 :margin-right :auto}]))

(def hyper-link-style
  (list
   [:a {:color text-color
        :text-decoration :none
        :font-weight 700
        :transition [[:all transition-time]]}
    [:&:hover {:color "#db4437"}]
    [:i {:padding-right (px 10)}]]
   [:a.underline {:color white
                  :position :relative
                  :padding [[(px 4) 0]]}
    [:&:hover {:color :white}]
    [:&:before {:content "\"\""
                 :position :absolute
                 :width (percent 100)
                 :height (px 2)
                 :bottom 0
                 :left 0
                 :background-color :white
                 :visibility :hidden
                 :transform "scaleX(0)"
                 :transition [[:all transition-time :ease-in-out (ms 0)]]}]
    [:&:hover:before {:visibility :visible
                       :transform "scaleX(1)"}]])

  )

(def screen
  (list
   reset-style
   container-style
   hyper-link-style

   h/component-style
   f/component-style
   c/component-style))
