(ns huiyin.styles
  (:refer-clojure :exclude [> - + first not rem])
  (:require [garden.def :refer [defrule defstyles defcssfn]]
            [garden.color :refer [rgb rgba]]
            [garden.units :refer [px percent rem ms]]
            [garden.stylesheet :refer [rule at-media]]
            [garden.selectors :refer :all :exclude [map meta time empty]]
            [huiyin.variables :refer :all]
            [huiyin.selectors :refer :all]
            [huiyin.components.header :refer [header-style]]
            [huiyin.components.footer :refer [footer-style]]
            [huiyin.content :refer [content-style]]))

(defstyles reset-style
  [html {:-moz-osx-font-smoothing :grayscale
         :-webkit-font-smoothing :antialiased
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

(defstyles container-style
  [container {:position :relative
              :padding-left (px 16)
              :padding-right (px 16)
              :max-width (px 1170)
              :margin-left :auto
              :margin-right :auto}])

(defstyles hyper-link-style
  [a {:color text-color
      :text-decoration :none
      :font-weight 700
      :transition [[:all transition-time]]}
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
                :transform (scaleX 0)
                :transition [[:all transition-time :ease-in-out (ms 0)]]}]
   [(& hover before) {:visibility :visible
                      :transform (scaleX 1)}]])



;;; @media(min-width:576px){}
;;; @media(min-width:768px){}
;;; @media(min-width:992px){}
;;; @media(min-width:1200px){}

(defstyles large-desktop-style
  (at-media {:min-width (px 1200)}))

(defstyles landscape-tablets-&-medium-desktop
  (at-media {:min-width (px 992)
             :max-width (px 1199)}))

(defstyles portrait-tablets-and-small-desktop
  (at-media {:min-width (px 768)
             :max-width (px 991)}))

(defstyles landscape-phones-&-portrait-tablets
  (at-media {:max-width (px 767)}
            [:.resume {:flex-direction :column}
             [:img {:margin 0}]]
            [jumbotron
             [h1 {:font-size (px 45)}]]
            [:.container [:section {:padding 0}]]
            [:.columns {:flex-direction :column}]))

(defstyles portrait-phones-&-smaller
  (at-media {:max-width (px 480)}))

(defstyles responsive-style
  large-desktop-style
  landscape-tablets-&-medium-desktop
  portrait-tablets-and-small-desktop
  landscape-phones-&-portrait-tablets
  portrait-phones-&-smaller)

(defstyles screen
  reset-style
  container-style
  hyper-link-style

  header-style
  content-style
  footer-style

  responsive-style)
