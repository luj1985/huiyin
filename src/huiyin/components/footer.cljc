(ns huiyin.components.footer
  (:refer-clojure :exclude [rem])
  (:require
   [garden.color :refer [rgb rgba]]
   [garden.units :refer [px percent rem]]
   [huiyin.data :refer [infos messages footer-links]]
   [huiyin.variables :refer [headline-color-invert]]))

(defn- render-links []
  [:ul.links
   (doall
    (map-indexed
     (fn [i {:keys [name href icon]}]
       ^{:key i} [:li
                  [:a.underline {:href href}
                   [:i.fa {:class-name (str "fa-" icon)}]
                   name]])
     footer-links))])

(defn- render-copyright []
  [:ul.copyright
   (doall
    (map-indexed
     (fn [i html]
       ^{:key i} [:li {:dangerouslySetInnerHTML {:__html html}}])
     infos))])

(defn render [state]
  [:footer
   [:div.container
    [:h2 (:links messages)]
    [render-links]
    [render-copyright]]])

(def css
  [[:footer {:background-color :black
             :color headline-color-invert}
    [:.container {:display :flex
                  :flex-direction :column}]
    [:a {:color (rgba 255 255 255 0.95)
         :line-height (rem 1.8)}]
    [:h2 {:color headline-color-invert
          :font-size (rem 1.75)
          :margin-top (rem 1.5)
          :line-height (rem 2)}]
    [:.copyright {:padding [[(rem 1) 0]]
                  :margin-top (rem 0.5)
                  :color (rgba 255 255 255 0.4)}
     [:li {:display :inline-block
           :margin-right (rem 1.5)}]]]])
