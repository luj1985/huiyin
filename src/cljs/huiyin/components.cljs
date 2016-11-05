(ns huiyin.components
  (:require [huiyin.data :refer [members companies introductions links infos]]))

(defn- hy-header [state]
  (let [offset-y (get-in @state [:offset :y])
        style (if (> offset-y 140) :compact)]
    [:header.resizable {:class-name style}
     [:div.container.space-between
      [:img#logo {:src "/images/logo.png"}]
      [:nav
       #_offset-y
       (for [{:keys [href text target]} links]
         ^{:key href} [:a {:class-name :underline :href href :target target} text])]]]))

(defn- hy-footer [state]
  [:footer.container
   [:ul
    (doall
     (map-indexed
      (fn [i m]
        ^{:key i}
        [:li {:dangerouslySetInnerHTML {:__html m}}])
      infos))]])

(defn- jumbotron [state]
  (let [height (get-in @state [:viewport :height])]
    [:section.jumbotron {:style {:height height}}
     [:h1 "Huiyin Blockchain Venture"]]))

(defn- display-members []
  [:ul.container
   (for [[m i] (zipmap members (range))]
     ^{:key i} [:li [:a {:href (str "#/member/" i)} (:name m)]])])

(defn- display-companies []
  [:article.column
   [:h2
    [:a {:href "https://angel.co/huiyin-blockchain-venture"} "Angel list"]]
   [:ul
    (for [{:keys [name url]} companies]
      ^{:key url} [:li [:a {:href url} name]])]])

(defn- display-intro []
  [:article.column
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
   [:div.container.space-between
    [display-intro]
    [display-companies]]
   [display-members state]])

(defmethod hy-content :member [state]
  (let [id (:id @state)
        m (get members id)]
    [:main
     [jumbotron state]
     [:div.member "display member information here"]]))

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

