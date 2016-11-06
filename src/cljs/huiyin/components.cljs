(ns huiyin.components
  (:require
   [clojure.string :refer [join]]
   [huiyin.data :refer [members companies introductions links infos]]))

(defrecord Point [x y]
  Object
  (toString [_]
    (str x "," y)))

(defn- generate-logo [diameter border]
  (let [radius (/ diameter 2)
        top (->Point radius 0)
        bottom (->Point radius diameter)

        inner (- radius border)
        c1 (->Point radius radius)
        c2 (->Point inner inner)

        offset (/ inner (Math/sqrt 2))
        p1 (->Point radius border)
        p2 (->Point (+ radius offset) (+ radius offset))
        p3 (->Point (- inner offset) (+ inner offset))
        p4 (->Point radius (+ radius (/ offset 2)))]

    (join
     " "
     ["M" top "A" c1 "0 0 1" bottom "A" c1 "0 0 1" top "Z"
      "M" p2 "A" c2 "0 0 0" p1 "Z"
      "M" p1 "A" c2 "0 0 0" p3 "Z"
      "M" p3 "A" c2 "0 0 0" p2 "L" p4 "Z"])))

(defn- hy-header [state]
  (let [offset-y (get-in @state [:offset :y])
        compact?  (> offset-y 140)]
    [:header.resizable {:class-name (if compact? :compact)}
     [:div.container
      [:div#logo
       [:svg
        [:path {:d (generate-logo 80 3)}]]
       [:h1 "Huiyin Blockchain Venture"]]
      [:nav
       (for [{:keys [href text target]} links]
         ^{:key href} [:a {:class-name :underline :href href :target target} text])]]]))

(defn- hy-footer [state]
  [:footer
   [:div.container
    [:h2 "Links"]
    [:a {:href "#" :style {:color "rgba(255,255,255,.95)"}}
     [:i.fa.fa-linkedin-square]
     "Place your Linkin URL"     ]
    [:ul.copyright
     (doall
      (map-indexed
       (fn [i m]
         ^{:key i}
         [:li {:dangerouslySetInnerHTML {:__html m}}])
       infos))]]])

(defn- jumbotron [state]
  (let [height (get-in @state [:viewport :height])]
    [:section.jumbotron {:style {:height height}}
     [:h1 "Huiyin Blockchain Venture"]]))

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
                [:i.fa.fa-linkedin]
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
   [:h2 "Who we are"]
   [:ul
    (for [[m i] (zipmap members (range))]
      ^{:key i}
      [display-member (assoc m :index i)])]])

(defn- display-companies []
  [:section
   [:h2
    [:a {:href "https://angel.co/huiyin-blockchain-venture"} "Angel list"]]
   [:ul.companies
    (for [{:keys [name url logo]} companies]
      ^{:key url}
      [:li
       [:a {:href url :target "_blank"}
        [:img {:src logo}]
        name]])]])

(defn- display-intro []
  [:section
   [:h2 "Introduction"]
   (doall
    (map-indexed
     (fn [i html]
       ^{:key i} [:p {:dangerouslySetInnerHTML {:__html html}}])
     introductions))])

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
   "Page not found"])

;;; XXX: React fragment API is still in developing, an empty div container is required
;;; https://github.com/facebook/react/issues/2127
(defn render-pages [state]
  [:div
   [hy-header state]
   [hy-content state]
   [hy-footer state]])

