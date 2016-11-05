(ns huiyin.styles
  (:refer-clojure :exclude [> - + first not rem])
  (:require [garden.def :refer [defrule defstyles]]
            [garden.color :refer [rgb rgba]]
            [garden.units :refer [px percent rem ms]]
            [garden.stylesheet :refer [rule at-media]]
            [garden.selectors :refer :all :exclude [map meta time empty]]))

(def text-color (rgb 101 107 111))

(def white (rgba 255 255 255 0.7))
(def black (rgba 0 0 0 0.7))
(def base-bg-color "#0683c9")
(def base-fg-color white)
(def base-text-color text-color)

(def default-transition-time (ms 300))
(def dimmer-color (rgba 0 0 0 0.9))

(defselector app "#app")
(defselector logo "#logo")
(defselector compact ".compact")
(defselector container ".container")
(defselector resizable ".resizable")

(defstyles container-style
  [container {:position :relative
              :padding-left (px 16)
              :padding-right (px 16)
              :max-width (px 1170)
              :margin-left :auto
              :margin-right :auto}
   [:.column {:width (percent 48)}]])

(defstyles reset-style
  [html {:-moz-osx-font-smoothing "grayscale"
         :-webkit-font-smoothing "antialiased"
         :margin 0
         :padding 0}]

  [body {:font-family ["Calibre" "Helvetica" "Arial" "sans-serif"]
         :font-size (px 16)
         :line-height 1
         :margin 0
         :padding 0}]

  [app {:position :relative
        :margin 0
        :padding 0}])

(defstyles hyper-link-style
  [a {:color white
      :text-decoration :none
      :font-weight 700
      :transition [[:all default-transition-time]]}
   [i {:padding-right (px 10)}]]

  [:a.underline {:position :relative
                 :padding [[(px 4) 0]]}
   [(& hover) {:color "white"}]
   [(& before) {:content "\"\""
                :position :absolute
                :width (percent 100)
                :height (px 2)
                :bottom 0
                :left 0
                :background-color :white
                :visibility :hidden
                :transform "scaleX(0)"
                :transition [[:all default-transition-time :ease-in-out (ms 0)]]}]
   [(& hover before) {:visibility :visible
                      :transform "scaleX(1)"}]])

(defstyles resizable-header-style
  [resizable {:position :fixed
              :width (percent 100)
              :height (px 140)
              :z-index 1
              :transition (for [attr [:height :background-color]]
                            [attr default-transition-time])
              :background-color :transparent}

   [(> container) {:display :flex
                   :align-items :center
                   :justify-content :space-between
                   :height (percent 100)}]

   [logo {:transition [[:width default-transition-time]]
          :width (px 300)}]

   [nav {:display
         :flex :flex-direction :row}]

   [a {:margin [[0 (px 24)]]
       :font-size (px 22)}]]

  [(& resizable compact) {:height (px 77)
                          :background-color dimmer-color}
   [logo {:width (px 250)}]])

(defstyles jumbotron-style
  [:.jumbotron {:display :flex
                :align-items :center
                :justify-content :center
                :background "url(/images/home.jpg) no-repeat center center fixed"
                :background-size :center
                :max-height (px 1024)}

   [h1 {:color white
        :font-size (px 70)
        :font-family ["\"A2 60 Display Regular\"" "\"Arial Black\"" "Arial" "Helvetica" "Verdana" "sans-serif"]
        :transform "translateY(-50px)"
        :text-align :center}]])

(defstyles footer-style
  [:footer {:position :relative
            :background-color :black
            :color white}
   [:ul {:margin 0}]
   [:li {:display :inline-block
         :padding [[(px 16) (px 16) (px 16) 0]]}]])

(defstyles screen
  reset-style
  container-style
  hyper-link-style

  resizable-header-style
  jumbotron-style
  footer-style

  [h2 {:font-size (px 30)
       :color black}]
  [h3 {:font-size (px 25)
       :color white
       :margin "20px 0"}]

  [p {:color base-text-color
      :font-size (px 16)
      :font-weight :normal
      :line-height 1.3}]

  [ul {:padding 0}
   [li {:list-style :none}]] [:.container.space-between {:display :flex
                                                         :flex-direction :row
                                                         :justify-content :space-between}]

  [:main {:margin-bottom (px 40)}
   [a {:color base-text-color}
    [(& hover) {:color "#db4437"}]]])
