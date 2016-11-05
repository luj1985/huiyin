(ns huiyin.components
  (:require [huiyin.data :refer [members companies introductions links infos]]))

(defn display-header [state]
  (let [offset-y (get-in @state [:offset :y])
        style (if (> offset-y 300) :compact)]
    [:header.resizable {:class-name style}
     [:div.container.space-between
      [:h1#logo]
      [:nav
       (for [{:keys [href text target]} links]
         ^{:key href} [:a {:href href :target target} text])]]]))

(defn display-footer [state]
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

(defmulti display-content (fn [state] (:page @state)))

(defmethod display-content :home [state]
  [:main
   [jumbotron state]
   [:div.container.space-between
    [display-intro]
    [display-companies]]
   [display-members state]])

(defmethod display-content :member [state]
  (let [id (:id @state)
        m (get members id)]
    [:main
     [jumbotron state]
     [:div.member "display member information here"]]))

(defmethod display-content :default [state]
  [:main.container
   "Page not found"])
