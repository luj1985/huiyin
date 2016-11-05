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

(def default-transition-time (ms 300))
(def dimmer-color (rgba 0 0 0 0.9))

(defselector app "#app")
(defselector logo "#logo")
(defselector compact ".compact")
(defselector container ".container")
(defselector resizable ".resizable")
(defselector jumbotron ".jumbotron")
(defselector main "main")

(defstyles container-style
  [container {:position :relative
              :padding-left (px 16)
              :padding-right (px 16)
              :max-width (px 1170)
              :margin-left :auto
              :margin-right :auto}])

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

  [h2 {:font-size (px 30)
       :color black}]

  [h3 {:font-size (px 25)
       :color white
       :margin [[(px 20) 0]]}]

  [p {:color text-color
      :font-size (px 16)
      :font-weight :normal
      :line-height 1.3}]

  [app {:position :relative
        :margin 0
        :padding 0}])

(defstyles hyper-link-style
  [a {:color text-color
      :text-decoration :none
      :font-weight 700
      :transition [[:all default-transition-time]]}
   [(& hover) {:color "#db4437"}]
   [i {:padding-right (px 10)}]]

  [:a.underline {:color white
                 :position :relative
                 :padding [[(px 4) 0]]}
   [(& hover) {:color :white}]
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
  [jumbotron {:display :flex
                :align-items :center
                :justify-content :center
                :background "url(/images/home.jpg) no-repeat center bottom fixed"
                :background-size :center
                :max-height (px 800)}

   [h1 {:color white
        :font-size (px 70)
        :font-family ["\"A2 60 Display Regular\"" "\"Arial Black\"" "Arial" "Helvetica" "Verdana" "sans-serif"]
        :transform "translateY(-50px)"
        :text-align :center}]])

(defstyles footer-style
  [footer {:position :relative
            :background-color :black
            :color white}
   [ul {:display :block
        :padding 0
        :margin 0}]
   [li {:display :inline-block
        :list-style :none
        :padding (px 16)}]])

(defstyles main-style
  [main {:margin-bottom (px 40)}]

  [:.columns {:display :flex
              :flex-direction :row}
   [section
    [ul {:padding 0}]
    [li {:line-height 1.3
         :list-style :none}]]]

  [(> :.columns :*) {:flex 1
                     :padding (px 16)}])

(defstyles company-style
  [:ul.companies
   [:img {:height (px 50)
          :width (px 50)
          :margin (px 8)
          :margin-left 0}]
   [a {:display :flex
       :flex-direction :row
       :align-items :center}]])

(defstyles member-style
  [:.member {:display :flex
             :flex-direction :row
             :margin [[(px 16) 0]]}
   [:.avatar {:display :inline-block
              :width (px 60)
              :height (px 60)
              :margin-right (px 16)
              :box-shadow "0 0 4px rgba(0, 0, 0, .8)"
              :background-repeat :no-repeat
              :background-position "50% 50%"
              :background-size "100% auto"
              :border-radius (percent 50)}]
   [:.contact {:padding [[0 (px 8)]]}
    [h4 {:margin 0 :padding 0}]
    [h5 {:margin 0 :padding 0}]]])



(defstyles mobile-style
  (at-media
   {:max-width (px 767)}
   [jumbotron
    [h1 {:font-size (px 45)}]]
   [:.container [:section {:padding 0}]]
   [:.columns {:flex-direction :column}]))

(defstyles screen
  reset-style
  container-style
  hyper-link-style

  resizable-header-style
  jumbotron-style
  footer-style
  main-style
  member-style
  company-style

  mobile-style
  )
