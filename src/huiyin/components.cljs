(ns huiyin.components
  (:require
   [clojure.string :refer [join]]
   [huiyin.components.footer :refer [hy-footer]]
   [huiyin.components.header :refer [hy-header]]
   [huiyin.data :refer [members companies introductions links infos messages]]
   [huiyin.variables :refer [logo-size logo-circle header-compact-threshold]]))

(defn- jumbotron [state]
  (let [height (get-in @state [:viewport :height])]
    [:section.jumbotron {:style {:height height}}
     [:h1 (:title messages)]]))

(defn- display-intro []
  [:section
   [:h2 (get-in messages [:sections :intro])]
   (doall
    (map-indexed
     (fn [i html]
       ^{:key i} [:p {:dangerouslySetInnerHTML {:__html html}}])
     introductions))])

(defn- display-attribute [{:keys [email twitter linked-in] :as attr}]
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

(defn- display-member [{:keys [index name title avatar attrs]} m]
  [:li.member
   [:div.avatar {:style {:background-image (str "url(" avatar ")")}}]
   [:div.contact
    [:h4
     [:a {:href (str "#/member/" index)}
      name]]
    [:h5 title]]])

(defn- display-members []
  [:section
   [:h2 (get-in messages [:sections :who-we-are])]
   [:ul
    (for [[m i] (zipmap members (range))]
      ^{:key i}
      [display-member (assoc m :index i)])]])

(defn- display-companies []
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

(defmulti hy-content (fn [state] (:page @state)))

(defmethod hy-content :home [state]
  [:main
   [jumbotron state]
   [:div.container.columns
    [display-intro]
    [display-members state]
    [display-companies]]])

(defmethod hy-content :member [state]
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
       [:p {:dangerouslySetInnerHTML {:__html description}}]]]]))

(defmethod hy-content :default [state]
  [:main.container
   (:not-found messages)])

;;; XXX: React fragment API is still in developing, an empty div container is required
;;; https://github.com/facebook/react/issues/2127
(defn render-pages [state]
  [:div
   [hy-header state]
   [hy-content state]
   [hy-footer state]])
