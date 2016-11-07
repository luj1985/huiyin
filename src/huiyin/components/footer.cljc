(ns huiyin.components.footer
  (:require
   [garden.color :refer [rgb rgba]]
   [garden.units :refer [px percent]]
   [huiyin.data :refer [infos messages]]
   [huiyin.variables :refer [headline-color-invert]]))

(def css
  [[:footer {:position :relative
             :background-color :black
             :color headline-color-invert}
    [:h2 {:color headline-color-invert
          :font-size (px 24)
          :padding-top (px 32)}]
    [:.copyright {:margin-top (px 30)
                  :color (rgba 255 255 255 0.4)}]
    [:ul {:display :block
          :padding 0
          :margin 0}]
    [:li {:display :inline-block
          :list-style :none
          :padding (px 16)}]]])

(defn render [state]
  [:footer
   [:div.container
    [:h2 (:links messages)]
    [:a {:href "#" :style {:color "rgba(255,255,255,.95)"}}
     [:i.fa.fa-linkedin-square] "Place your Linkin URL"]
    [:ul.copyright
     (doall
      (map-indexed
       (fn [i m]
         ^{:key i}
         [:li {:dangerouslySetInnerHTML {:__html m}}])
       infos))]]])

