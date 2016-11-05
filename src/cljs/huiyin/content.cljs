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

(def companies
  [{:name "Purse.io" :url "https://purse.io"}
   {:name "Yours network" :url "https://www.yours.network"}
   {:name "Unocoin" :url "https://www.unocoin.com"}])


(defn jumbotron [state]
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
     [:p "Huiyin Blockchain Venture is a premier firm that partners with innovative start-ups and entrepreneurs to help them grow and define the future of the blockchain economy.
We provide strategic investment to bring pioneering blockchain technology ideas to life and to scale in a number of areas, including infrastructure, exchange, payment, remittance or use cases.
We are a trusted partner with the global expertise and network to make the most of the exciting opportunities that blockchain technology presents."]
     [:p {:dangerouslySetInnerHTML {:__html "Huiyin Blockchain Venture builds upon the strength of its parent company, the Huiyin Group (<a href=\"http://www.huiyin.com\">www.huiyin.com</a>), which was established in 2001.
Huiyin Group manages diversified investments in commerce, energy, medicine, agriculture, tourism, electronics, chemicals, commerce and food and beverages.
Huiyin Group has more than 20 subsidiaries, assets of over $2 billion and more than 1,000 employees."}}]])

(defn content []
  [:div.container.space-between
   [display-intro]
   [display-companies]])

(defn main [state]
  [:main
   [jumbotron state]
   [content state]
   [display-members state]])

(defn member [state id]
  (let [m (get members id)]
    [:main.container
     [jumbotron state]
     [:div.member "display member information here"]]))
