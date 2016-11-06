(ns huiyin.components.sections
  (:refer-clojure :exclude [> - + first not rem])
  #?(:cljs
     (:require
      [huiyin.data :refer [members companies introductions links infos messages]]))
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
     (defn jumbotron [state]
       (let [height (get-in @state [:viewport :height])]
         [:section.jumbotron {:style {:height height}}
          [:h1 (:title messages)]]))

     (defn display-intro []
       [:section
        [:h2 (get-in messages [:sections :intro])]
        (doall
         (map-indexed
          (fn [i html]
            ^{:key i} [:p {:dangerouslySetInnerHTML {:__html html}}])
          introductions))])

     (defn display-attribute [{:keys [email twitter linked-in] :as attr}]
       [:dt
        (cond
          email [:a {:href (str "mailto:" email)}
                 [:i.fa.fa-envelope]
                 email]
          twitter [:a {:href (:value twitter)}
                   [:i.fa.fa-twitter]
                   (:name twitter)]
          linked-in [:a {:href (:value linked-in)}
                     [:i.fa.fa-linkedin-square]
                     (:name linked-in)])])

     (defn display-member [{:keys [index name title avatar attrs]} m]
       [:li.member
        [:div.avatar {:style {:background-image (str "url(" avatar ")")}}]
        [:div.contact
         [:h4
          [:a {:href (str "#/member/" index)}
           name]]
         [:h5 title]]])

     (defn display-members []
       [:section
        [:h2 (get-in messages [:sections :who-we-are])]
        [:ul
         (for [[m i] (zipmap members (range))]
           ^{:key i}
           [display-member (assoc m :index i)])]])

     (defn display-companies []
       [:section
        [:h2
         [:a {:href "https://angel.co/huiyin-blockchain-venture"} (get-in messages [:sections :angel])]]
        [:ul.companies
         (for [{:keys [name url logo]} companies]
           ^{:key url}
           [:li
            [:a {:href url :target "_blank"}
             [:img {:src logo}]
             name]])]])

     (defn display-member-detail [state]
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
                 [display-attribute attr])
               attrs))]
            [:p {:dangerouslySetInnerHTML {:__html description}}]]]]))))

#?(:clj
   (do

     (defstyles jumbotron-style
       [jumbotron {:display :flex
                   :padding [[0 (px 16)]]
                   :align-items :center
                   :justify-content :center
                   :background [[(url "/images/home.jpg") :no-repeat :center :bottom]]
                   :background-size :center
                   :max-height (px 1024)
                   :transition [[:all transition-time]]}

        [h1 {:color white
             :font-size (px 70)
             :font-family ["\"A2 60 Display Regular\"" "\"Arial Black\"" "Arial" "Helvetica" "Verdana" "sans-serif"]
             :transform "translateY(-50px)"
             :text-align :center}]])

     (defstyles main-style
       [main {:display :block
              :margin-bottom (px 40)}]

       [:.columns {:display :flex
                   :flex-direction :row}
        [section
         [ul {:padding 0}]
         [li {:line-height 1.3
              :list-style :none}]]]

       [".columns>*:nth-child(1)" {:flex 5}]
       [".columns>*:nth-child(2)" {:flex 5}]
       [".columns>*:nth-child(3)" {:flex 2}]
       [(> :.columns :*) {:padding (px 16)}])

     (defstyles company-style
       [:ul.companies
        [:img {:height (px 50)
               :width (px 50)
               :margin (px 8)
               :margin-left 0}]
        [a {:display :flex
            :flex-direction :row
            :align-items :center}]])

     (defstyles member-style
       [:.resume {:display :flex
                  :flex-direction :row
                  :margin-top (px 40)}
        [:img {:margin-right (px 32)}]
        [:h2 :h3 {:color text-color}]
        [:dt {:line-height 1.5}]]

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
         [h5 {:margin-top (px 8) :font-size (px 14)}]]])

     (defstyles component-style
       jumbotron-style
       main-style
       member-style
       company-style)))
