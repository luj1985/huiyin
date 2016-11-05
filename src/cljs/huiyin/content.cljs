(ns huiyin.content)

(def members
  [{:name "James Wo"
    :title "CEO, Huiyin Blockchain Venture"
    :avator "/images/avatar.jpg"
    :attrs [{:email "woquan826@gmail.com"}
            {:email "woquan826@163.com"}
            {:email "woquan@huiyin.com"}
            {:twitter {:name "@woquan826" :value "https://twitter.com/woquan826"}}
            {:linked-in {:name "james-wo-272904114" :value "https://www.linkedin.com/in/james-wo-272904114"}}]}

   {:name "Freddy Zheng"
    :title "Director, Management Huiyin Blockchain Venture"
    :avatar ""
    :attrs [{:email "zhengbing@huiyin.com"}]}

   {:name "Shang Zhang"
    :title "Senior Associate, Huiyin Blockchain Venture"
    :avatar ""
    :attrs [{:email "zhanghong@huiyin.com"}]}

   {:name "Andrew Lee"
    :title "Board Advisor"
    :avatar "/images/avatar2.jpg"
    :attrs [{:email "andrew@purse.io"}]}])

(defn jumbotron [state]
  (let [height (get-in @state [:viewport :height])]
    [:section.jumbotron {:style {:height height}}
     [:h1 "Huiyin Blockchain Venture"]]))

(defn content []
  [:div
   [:main.container.space-between
    [:article.column
     [:h2 "Introduction"]
     [:p "Huiyin Blockchain Venture is a premier firm that partners with innovative start-ups and entrepreneurs to help them grow and define the future of the blockchain economy.
We provide strategic investment to bring pioneering blockchain technology ideas to life and to scale in a number of areas, including infrastructure, exchange, payment, remittance or use cases.
We are a trusted partner with the global expertise and network to make the most of the exciting opportunities that blockchain technology presents."]
     [:p {:dangerouslySetInnerHTML {:__html "Huiyin Blockchain Venture builds upon the strength of its parent company, the Huiyin Group (<a href=\"http://www.huiyin.com\">www.huiyin.com</a>), which was established in 2001.
Huiyin Group manages diversified investments in commerce, energy, medicine, agriculture, tourism, electronics, chemicals, commerce and food and beverages.
Huiyin Group has more than 20 subsidiaries, assets of over $2 billion and more than 1,000 employees."}}]]
    [:article.column
     [:h2
      [:a {:href "https://angel.co/huiyin-blockchain-venture"} "Angel list"]]
     [:ul
      [:li
       [:a {:href "https://purse.io"} "Purse.io"]]
      [:li
       [:a {:href "https://www.yours.network"} "Yours network"]]
      [:li
       [:a {:href "https://www.unocoin.com"} "Unocoin"]]]]]

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
          [:i.fa.fa-envelope {:aria-hidden true} "andrew@purse.io"]]]]]]]]])

(defn main [state]
  [:main
   [jumbotron state]
   [content]])

(defn member []
  [:div.member "display member information here"])
