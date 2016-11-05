(ns huiyin.master)

(def ^:const company-url
  "https://www.linkedin.com/company/10970209?trk=tyah&trkInfo=clickedVertical%3Acompany%2CentityType%3AentityHistoryName%2CclickedEntityId%3Acompany_company_company_10970209%2Cidx%3A0")

(def ^:const links
  [{:text "Home" :href "#/home"}
   {:text "About" :href "#/about"}
   {:text "Join Us" :target "_blank" :href company-url}])

(defn header [state]
  (let [offset-y (get-in @state [:offset :y])
        style (if (> offset-y 300) :compact)]
    [:header.resizable {:class-name style}
     [:div.container.space-between
      [:h1#logo]
      [:nav
       (for [{:keys [href text target]} links]
         ^{:key href} [:a {:href href :target target} text])]]]))

(defn footer [state]
  [:footer.container
   [:ul
    [:li {:dangerouslySetInnerHTML {:__html "&copy; Copyright Huiyin Group 2016"}}]
    [:li "沪ICP备15051469号"]
    [:li "沪公网安备 31010602000185号"]]])

