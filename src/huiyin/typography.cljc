(ns huiyin.typography
  (:refer-clojure :exclude [rem])
  (:require
   [garden.units :refer [px percent rem]]
   [huiyin.variables :refer [headline-color-invert
                             headline-color
                             text-color
                             max-content-width
                             transition-time]]))

(def ^:prviate link-hover-color "#db4437")

(def ^:private reset-style
  [[:html {:-moz-osx-font-smoothing :grayscale
           :-webkit-font-smoothing :antialiased}]

   [:html :body :#app {:margin 0
                 :padding 0
                 :height (percent 100)}]


   [:body {:font-family ["Helvetica Neue" "Helvetica" "Arial" "sans-serif"]
           :font-size (px 16)
           :line-height 1
           :color headline-color}]

   [:h1 {:font-size (rem 4.5)}] ;;; jumbotron font
   [:h2 {:font-size (rem 2)}  :margin [[(rem 1) 0]]]
   [:h3 {:font-size (rem 1.5) :margin [[(rem 1) 0]]}]
   [:h4 {:font-size (rem 1.1) :margin [[(px 8) 0 0 0]]}]
   [:h5 {:font-size (rem 0.9) :margin [[(px 8) 0]]}]

   [:p {:color text-color
        :line-height 1.4}]
   [:ul {:padding 0 :margin 0}]
   [:li {:list-style :none}]

   [:main {:display :block
           :margin-bottom (rem 2)}]])

(def ^:private container-style
  [[:.container {:position :relative
                 :padding-left (rem 1)
                 :padding-right (rem 1)
                 :max-width (px max-content-width)
                 :margin-left :auto
                 :margin-right :auto
                 :box-sizing :border-box}]
   [:.resume {:min-height (px 520)}]])

(def ^:private link-with-underline-style
  [[:a.underline {:color headline-color-invert
                  :position :relative
                  :padding [[(px 4) 0]]}
    [:&:hover {:color :white}]
    [:&:before {:content "\"\""
                :position :absolute
                :width (percent 100)
                :height (px 2)
                :bottom 0
                :background-color :white
                :transform "scaleX(0)"
                :transition [[:all transition-time]]}]
    [:&:hover:before {:transform "scaleX(1)"}]]])

(def ^:private link-style
  [[:a {:color text-color
        :text-decoration :none
        :font-weight 700
        :transition [[:all transition-time]]}
    [:&:hover {:color link-hover-color}]
    [:i {:padding-right (rem 0.5)}]]])

(def css
  [reset-style
   container-style
   link-style
   link-with-underline-style])
