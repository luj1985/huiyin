(ns huiyin.components.member
  (:require
   [garden.color :refer [rgb rgba]]
   [garden.units :refer [px percent]]
   [garden.stylesheet :refer [at-media]]
   [huiyin.variables :refer [text-color]]
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
  (let [id (get-in @state [:params :id])
        {:keys [name title avatar attrs description] :as m} (get members id)]
    [:main {:style {:min-height "100%"}}
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
            ^{:key i}
            [render-attribute attr])
          attrs))]
       [:p {:dangerouslySetInnerHTML {:__html description}}]]]]))

(def css
  [[:.resume {:display :flex
              :flex-direction :row
              :margin-top (px 40)}
    [:img {:margin-right (px 32)}]
    [:h2 :h3 {:color text-color}]
    [:dt {:line-height 1.5}]]

   (at-media
    {:min-width (px 767)}
    [:.resume {:flex-direction :column}
     [:img {:margin 0}]])])
