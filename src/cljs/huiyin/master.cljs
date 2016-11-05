(ns huiyin.master
  "header & footer is fixed, doesn't change once it was shown")

(def ^:private ^:const company-url
  "https://www.linkedin.com/company/10970209?trk=tyah&trkInfo=clickedVertical%3Acompany%2CentityType%3AentityHistoryName%2CclickedEntityId%3Acompany_company_company_10970209%2Cidx%3A0")

(def ^:private ^:const links
  [{:text "Home" :href "#/home"}
   {:text "About" :href "#/about"}
   {:text "Join Us" :target "_blank" :href company-url}])

(def ^:private ^:const infos
  ["&copy; Copyright Huiyin Group 2016"
   "沪ICP备15051469号"
   "沪公网安备 31010602000185号"])

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

