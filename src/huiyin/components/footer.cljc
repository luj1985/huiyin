(ns huiyin.components.footer
  (:refer-clojure :exclude [rem])
  (:require
   [garden.color :refer [rgb rgba]]
   [garden.units :refer [px percent rem]]
   [huiyin.data :refer [infos messages]]
   [huiyin.variables :refer [headline-color-invert]]))

(defn render [state]
  [:footer
   [:div.container
    [:h2 (:links messages)]
    [:ul.links
     [:li
      [:a.underline {:target "_blank"
           :href "https://www.linkedin.com/company/10970209?trk=tyah&trkInfo=clickedVertical%3Acompany%2CentityType%3AentityHistoryName%2CclickedEntityId%3Acompany_company_company_10970209%2Cidx%3A0" }
       [:i.fa.fa-linkedin-square] (:title messages)]]
     [:li
      [:a.underline {:target "_blank" :href "mailto:woquan826@gmail.com"}
       [:i.fa.fa-envelope] "Contact Us"]]]

    [:ul.copyright
     (doall
      (map-indexed
       (fn [i m]
         ^{:key i} [:li {:dangerouslySetInnerHTML {:__html m}}])
       infos))]]])

(def css
  [[:footer {:background-color :black
             :color headline-color-invert}
    [:.container {:display :flex
                  :flex-direction :column}]
    [:a {:color (rgba 255 255 255 0.95)}]
    [:h2 {:color headline-color-invert
          :font-size (rem 1.5)
          :margin-top (rem 1.5)
          :line-height (rem 2)}]

    [:.links [:li {:margin [[(rem 0.75) 0]]}]]
    [:.copyright {:margin-top (rem 1)
                  :color (rgba 255 255 255 0.4)}
     [:li {:display :inline-block
           :padding [[0 (rem 1) (rem 1) 0]]}]]]])

