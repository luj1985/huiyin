(ns huiyin.styles
  (:refer-clojure :exclude [> - + first not rem])
  (:require [garden.def :refer [defrule defstyles]]
            [garden.color :refer [rgb rgba]]
            [garden.units :refer [px percent rem]]
            [garden.stylesheet :refer [rule at-media]]
            [garden.selectors :refer :all :exclude [map meta time empty]]))

(def text-color (rgb 101 107 111))

(def white (rgba 255 255 255 0.7))
(def black (rgba 0 0 0 0.7))
(def base-bg-color "#0683c9")
(def base-fg-color white)
(def base-text-color text-color)

(defstyles container-style
  [:.container {:position :relative
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

  [:#app {:position :relative
          :margin 0
          :padding 0}])

(defstyles hyper-link-style
  [a {:color white
      :text-decoration :none
      :font-weight 700
      :transition "all 0.3s"}
   [:&:hover {:color "white"}]
   [:i {:padding-right (px 10)}]])

(def a-style [:a {:position :relative
                  :padding [[(px 4) 0]]}
              [:&:before {:content ""
                          :position :absolute
                          :width (percent 100)
                          :height (px 2)
                          :bottom 0
                          :left 0
                          :background-color :white
                          :visibility :hidden
                          :transform "scaleX(0)"
                          :transition "all 0.3s ease-in-out 0s"}]
              [:&:hover:before {:visibility :visible
                                :transform "scaleX(1)"}]])

(defstyles resizable-header-style
  (let [header-height (px 140)
        header-height' (px 77)
        logo-width (px 300)
        logo-width' (px 250)]
    [:.resizable {:position :fixed
                  :width (percent 100)
                  :height header-height
                  :z-index 1
                  :transition "all 0.3s"
                  :background-color :transparent}
     [:#logo {:transition "all 0.3s"
              :width logo-width}]

     [(> :.container) {:display :flex
                       :align-items :center
                       :height (percent 100)}]
     [nav {:display :flex
           :flex-direction :row}
      [a {:margin [[0 (px 16)]]
          :padding (px 16)
          :font-size (px 22)}]]

     [:&.compact {:height header-height'
                  :background-color (rgba 0 0 0 0.9)}
      [:#logo {:width logo-width'}]]]))

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

(defstyles screen
  reset-style
  container-style
  hyper-link-style

  resizable-header-style
  jumbotron-style

  [:header a-style]
  [:footer a-style]
  [:h2 {:font-size (px 30)
        :color black}]
  [:h3 {:font-size (px 25)
        :color white
        :margin "20px 0"}]

  [:p {:color base-text-color
       :font-size (px 16)
       :font-weight :normal
       :line-height 1.3}]

  [:ul {:padding 0}
   [:li {:list-style :none}]] [:.container.space-between {:display :flex
                                                          :flex-direction :row
                                                          :justify-content :space-between}]

  

  [:main {:margin-bottom (px 40)}
   [:a {:color base-text-color}
    ["&:hover" {:color "#db4437"}]]])
