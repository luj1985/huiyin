(ns huiyin.components.footer
  (:refer-clojure :exclude [> - + first not rem])
  #?(:clj
     (:require
      [garden.def :refer [defstyles]]
      [garden.selectors :refer :all :exclude [map meta time empty]]
      [garden.color :refer [rgb rgba]]
      [garden.units :refer [px percent]]
      [huiyin.variables :refer :all]
      [huiyin.selectors :refer :all])
     :cljs
     (:require
      [huiyin.data :refer [links infos messages]])))

#?(:clj
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
           :padding (px 16)}]]))

#?(:cljs
   (defn hy-footer [state]
     [:footer
      [:div.container
       [:h2 (:links messages)]
       [:a {:href "#" :style {:color "rgba(255,255,255,.95)"}}
        [:i.fa.fa-linkedin-square] "Place your Linkin URL"     ]
       [:ul.copyright
        (doall
         (map-indexed
          (fn [i m]
            ^{:key i}
            [:li {:dangerouslySetInnerHTML {:__html m}}])
          infos))]]]))


