(ns huiyin.master)

(defn header [state]
  [:header
   [:div.container.space-between
    [:h1#logo (:y (:offset @state))]
    [:nav
     [:a {:href "#/home"} "Home"]
     [:a {:href "#/about"} "About"]
     [:a {:target "_blank" :href "https://www.linkedin.com/company/10970209?trk=tyah&trkInfo=clickedVertical%3Acompany%2CentityType%3AentityHistoryName%2CclickedEntityId%3Acompany_company_company_10970209%2Cidx%3A0"} "Join Us"]]]])

(defn footer [state]
  [:footer
   [:div.container
    [:h3 "Leadership"]
    [:div.wrapper
     [:div.info
      [:img.avatar {:src "images/avatar.jpg"}]
      [:div.contact
       [:h4 "James Wo"]
       [:h5 "CEO, Huiyin Blockchain Venture"]
       [:ul
        [:li
         [:a {:href "mailto:woquan826@gmail.com"}
          [:i.fa.fa-envelope {:aria-hidden true} "woquan826@gmail.com"]]]
        [:li
         [:a {:href "mailto:woquan826@163.com"}
          [:i.fa.fa-envelope {:aria-hidden true} "woquan826@163.com"]]]
        [:li
         [:a {:href "https://twitter.com/woquan826"}
          [:i.fa.fa-twitter {:aria-hidden true} "@woquan826"]]]
        [:li
         [:a {:href "https://www.linkedin.com/in/james-wo-272904114"}
          [:i.fa.fa-linkedin-square {:aria-hidden true} "james-wo-272904114"]]]]]]
     [:div.info
      [:img.avatar {:src "images/avatar2.jpg"}]
      [:div.contact
       [:h4 "Andrew Lee"]
       [:h5 "CEO at Purse, Advisor at Huiyin Blockchain Venture"]
       [:ul
        [:li
         [:a {:href "mailto:andrew@purse.io"}
          [:i.fa.fa-envelope {:aria-hidden true} "andrew@purse.io"]]]]]]]]
   [:div.container
    [:ul.subfooter
     [:li {:dangerouslySetInnerHTML {:__html "&copy; Copyright Huiyin Group 2016"}}]
     [:li "沪ICP备15051469号"]
     [:li "沪公网安备 31010602000185号"]]]])
