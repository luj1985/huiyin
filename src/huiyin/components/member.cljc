(ns huiyin.components.member
  (:refer-clojure :exclude [> - + first not rem])
  (:require
   [huiyin.data :refer [members]])
  #?(:clj
     (:require
      [garden.def :refer [defstyles defrule defcssfn]]
      [garden.stylesheet :refer [at-media]]
      [garden.selectors :refer :all :exclude [map meta time empty]]
      [garden.color :refer [rgb rgba]]
      [garden.units :refer [px percent]]
      [huiyin.variables :refer :all]
      [huiyin.selectors :refer :all])))

#?(:cljs
   (do
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
            [:p {:dangerouslySetInnerHTML {:__html description}}]]]])))
   )

#?(:clj
   (defstyles component-style
     [:.resume {:display :flex
                :flex-direction :row
                :margin-top (px 40)}
      [img {:margin-right (px 32)}]
      [h2 :h3 {:color text-color}]
      [dt {:line-height 1.5}]]

     [:.member {:display :flex
                :flex-direction :row
                :margin [[(px 8) 0]]}

      [:.avatar {:display :inline-block
                 :flex-shrink 0
                 :width (px 60)
                 :height (px 60)
                 :margin-right (px 16)
                 :box-shadow "0 0 4px rgba(0, 0, 0, .8)"
                 :background-repeat :no-repeat
                 :background-position "50% 50%"
                 :background-size "100% auto"
                 :border-radius (percent 50)}]
      [:.contact {:padding [[0 (px 8)]]}
       [h4 {:margin "8px 0 0 0" :padding 0 :font-size (px 18)}]
       [h5 {:margin-top (px 8) :font-size (px 14)}]]]))
