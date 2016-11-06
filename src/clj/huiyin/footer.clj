(ns huiyin.footer
  (:refer-clojure :exclude [> - + first not rem])
  (:require
   [garden.def :refer [defstyles defrule defcssfn]]
   [garden.stylesheet :refer [at-media]]
   [garden.selectors :refer :all :exclude [map meta time empty]]
   [garden.color :refer [rgb rgba]]
   [garden.units :refer [px percent]]
   [huiyin.variables :refer :all]
   [huiyin.selectors :refer :all]))

(defstyles footer-style
  [footer {:position :relative
           :background-color :black
           :color white}
   [h2 {:color white
        :font-size (px 24)
        :padding-top (px 32)}]
   [:.copyright {:margin-top (px 30)
                 :color (rgba 255 255 255 0.4)}]
   [ul {:display :block
        :padding 0
        :margin 0}]
   [li {:display :inline-block
        :list-style :none
        :padding (px 16)}]])
