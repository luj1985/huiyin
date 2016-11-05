(ns huiyin.master
  (:require [huiyin.data :refer [links infos]]))

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

