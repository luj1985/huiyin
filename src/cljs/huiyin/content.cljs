(ns huiyin.content
  (:require [huiyin.data :refer [members companies introductions]]))

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

(defn content []
  [:div.container.space-between
   [display-intro]
   [display-companies]])

(defn member [state id]
  (let [m (get members id)]
    [:main.container
     [jumbotron state]
     [:div.member "display member information here"]]))

(defmulti display-content (fn [state] (:page @state)))

(defmethod display-content :home [state]
  [:main
   [jumbotron state]
   [content state]
   [display-members state]])

(defmethod display-content :member [state]
  (let [id (:id @state)
        m (get members id)]
    [:main.container
     [jumbotron state]
     [:div.member "display member information here"]]))

(defmethod display-content :default [state]
  [:main.container
   "Page not found"])
