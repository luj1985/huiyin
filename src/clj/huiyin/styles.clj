(ns huiyin.styles
  (:require [garden.def :refer [defrule defstyles]]
            [garden.color :refer [rgba]]
            [garden.units :refer [px percent]]
            [garden.stylesheet :refer [rule]]))

(def white (rgba 255 255 255 0.7))
(def black (rgba 0 0 0 0.7))
(def base-bg-color "#0683c9")
(def base-fg-color white)
(def base-text-color "#656b6f")
(def resizable-header-height (px 140))
(def resizable-header-height-small (px 75))
(def logo-width (px 300))
(def logo-width-small (px 250))

(def a-style [:a {:position :relative
                  :padding "4px 0"}
              ["&:before" {:content ""
                           :position :absolute
                           :width (percent 100)
                           :height (px 2)
                           :bottom 0
                           :left 0
                           :background-color :white
                           :visibility :hidden
                           :transform "scaleX(0)"
                           :transition "all 0.3s ease-in-out 0s"}]
              ["&:hover:before" {:visibility :visible
                                 :transform "scaleX(1)"}]])
(defstyles screen
  [:html {:-moz-osx-font-smoothing "grayscale"
          :-webkit-font-smoothing "antialiased"
          :margin 0
          :padding 0}]

  [:#app {:position :relative
          :margin 0
          :padding 0}]

  [:body {:font-family "Calibre, Helvetica, Arial, sans-serif"
          :font-size (px 16)
          :line-height 1
          :margin 0
          :padding 0}]

  [:a {:color white
       :text-decoration :none
       :font-weight 700
       :transition "all 0.3s"}
   ["&:hover" {:color "white"}]
   [:i {:padding-right (px 10)}]]

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
   [:li {:list-style :none}]]


  [:.container.space-between {:display :flex
                              :flex-direction :row
                              :justify-content :space-between}]

  [:header {:position :fixed
            :width (percent 100)
            :height resizable-header-height
            :z-index 1}
   [:nav {:margin 0
          :display :inline-block}]
   [:#logo {:margin 0
            :display :inline-block}]

   [:#logo {:background-image "url(/images/logo.png)"
            :background-repeat :no-repeat
            :background-position "center center"}]
   [:nav {:white-space :nowrap}
    [:a {:margin "0 20px"
         :font-size (px 22)}]]]

  [:main {:margin-top (px 70)
          :margin-bottom (px 40)}
   [:a {:color base-text-color}
    ["&:hover" {:color "#db4437"}]]]


  [:.container {:position :relative
                :padding-left (px 16)
                :padding-right (px 16)
                :max-width (px 1170)
                :margin-left :auto
                :margin-right :auto}
   [:.column {:width (percent 48)}]]

  [:header {:transition "all 0.3s"
            :background-color :transparent}
   [:#logo {:transition "all 0.3s"}]
   [:nav [:a {:transition "all 0.3s"}]]


   [:#logo {:height resizable-header-height
            :line-height resizable-header-height
            :width logo-width
            :background-size (str logo-width " auto")}]

   [:nav [:a {:line-height resizable-header-height}]]


   ["&.smaller" {:height resizable-header-height-small
                 :background-color (rgba 0 0 0 0.9)}]

   ]



  [:.jumbotron {:display :flex
                :align-items :center
                :justify-content :center
                :background "url(/images/home.jpg) no-repeat center center fixed"
                :background-size :center
                :max-height (px 1024)}
   [:h1 {:color white
         :font-size (px 70)
         :font-family "'A2 60 Display Regular', 'Arial Black', Arial, Helvetica, Verdana, sans-serif"
         :transform "translateY(-50px)"
         :text-align :center}]]



  )
