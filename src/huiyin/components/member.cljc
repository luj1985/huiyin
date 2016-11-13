(ns huiyin.components.member
  (:refer-clojure :exclude [rem])
  (:require
   [garden.color :refer [rgb rgba]]
   [garden.units :refer [px percent rem]]
   [garden.stylesheet :refer [at-media]]
   [huiyin.variables :refer [text-color]]
   #?(:cljs [huiyin.utils :refer [scroll-to-element]])
   [huiyin.data :refer [members]]))

(defn- render-attribute [{:keys [email twitter linked-in] :as attr}]
  [:dt
   (cond
     email [:a {:href (str "mailto:" email)}
            [:i.fa.fa-envelope] email]
     twitter [:a {:href (:value twitter)}
              [:i.fa.fa-twitter] (:name twitter)]
     linked-in [:a {:href (:value linked-in)}
                [:i.fa.fa-linkedin-square] (:name linked-in)])])

(defn render [state]
  #?(:cljs (scroll-to-element ".resume" -100))
  (let [id (get-in @state [:params :id])
        {:keys [name title avatar attrs description] :as m} (get members id)]
    [:main
     [:section.jumbotron {:style {:height "300px"}}]
     [:div.container.resume
      [:img {:src avatar}]
      [:div
       [:h2 name]
       [:h3 title]
       [:dl
        (doall
         (map-indexed
          (fn [i attr]
            ^{:key i} [render-attribute attr])
          attrs))]]]
     [:div.container {:style {:min-height "190px"}}
      [:p {:dangerouslySetInnerHTML {:__html description}}]]]))

(def css
  [[:.resume {:display :flex
              :flex-direction :row
              :margin-top (rem 1)}
    [:img {:margin-right (rem 2)}]
    [:h2 :h3 {:color text-color}]
    [:dt {:line-height 1.5}]]

   (at-media
    {:max-width (px 766)}
    [:.resume {:flex-direction :column}
     [:img {:max-width (px 220)}]])

   (at-media
    {:min-width (px 767)}
    [:.resume {:flex-direction :row}
     [:img {:margin-top (rem 2)
            :height (rem 13)
            :max-width (px 300)}]])])
