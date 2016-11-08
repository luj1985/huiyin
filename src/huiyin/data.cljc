(ns huiyin.data)

;;; These data can also be loaded from a web server
;;; TODO: use macro to read data from external file

(def ^:const messages
  {:title "Huiyin Blockchain Venture"
   :links "Links"
   :not-found "Page Not Found"
   :sections {:intro "Introduction"
              :who-we-are "Who we are"
              :angel "Angel list"}})

(def ^:const lorem "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.")

(def ^:const members
  [{:name "James Wo"
    :title "CEO, Huiyin Blockchain Venture"
    :avatar "/images/avatar.jpg"
    :description "James Wo is the founder and the CEO of Huiyin Blockchain Venture. As a 2th entrepreneur, James inherits many merits from his father. Diligent, modest and forward-looking, James endeavors to make his own contributions in the Blockchain and Bitcoin areas. James founded HBV when he studied Applied Statistics at Columbia University. From then, he devoted himself to promoting the applications of Blockchain and Bitcoin worldwide. Now as a promising venture capital, HBV steadily stimulates the advancement of the Blockchain industry under the lead of James Wo."
    :attrs [{:email "woquan826@gmail.com"}
            {:email "woquan826@163.com"}
            {:email "woquan@huiyin.com"}
            {:twitter {:name "@woquan826" :value "https://twitter.com/woquan826"}}
            {:linked-in {:name "james-wo-272904114" :value "https://www.linkedin.com/in/james-wo-272904114"}}]}

   {:name "Freddy Zheng"
    :title "Director, Management Huiyin Blockchain Venture"
    :avatar "/images/avatar.jpg"
    :description lorem
    :attrs [{:email "zhengbing@huiyin.com"}]}

   {:name "Shang Zhang"
    :title "Senior Associate, Huiyin Blockchain Venture"
    :avatar "/images/avatar.jpg"
    :description lorem
    :attrs [{:email "zhanghong@huiyin.com"}]}

   {:name "Andrew Lee"
    :title "CEO at Purse, Advisor at Huiyin Blockchain Venture"
    :avatar "/images/avatar2.jpg"
    :description "Andrew is CEO of  Purse , the world’s largest marketplace for Bitcoin. Purse’s mission is to make Bitcoin and blockchain technology useful. Purse is also the developer of b  coin,  an open source fullnode bitcoin implementation.
Previously, Andrew covered emerging payments at Bank of America Merrill Lynch and founded a payment processor that was acquired by Sage Payments. He is a proud Georgia Tech and University of Florida alumni.
Andrew is an advisor at HBV to help find and evaluate promising startups."
    :attrs [{:email "andrew@purse.io"}]}])

(def ^:const companies
  [{:name "Purse.io" :url "https://purse.io" :logo "/images/logos/purse.jpg"}
   {:name "Yours network" :url "https://www.yours.network" :logo "/images/logos/yours-network.png"}
   {:name "Unocoin" :url "https://www.unocoin.com" :logo "/images/logos/unocoin.jpg"}])

(def ^:const introductions
  ["Huiyin Blockchain Venture is a premier firm that partners with innovative start-ups and entrepreneurs to help them grow and define the future of the blockchain economy.
We provide strategic investment to bring pioneering blockchain technology ideas to life and to scale in a number of areas, including infrastructure, exchange, payment, remittance or use cases.
We are a trusted partner with the global expertise and network to make the most of the exciting opportunities that blockchain technology presents."
   "Huiyin Blockchain Venture builds upon the strength of its parent company, the Huiyin Group (<a href=\"http://www.huiyin.com\">www.huiyin.com</a>), which was established in 2001.
Huiyin Group manages diversified investments in commerce, energy, medicine, agriculture, tourism, electronics, chemicals, commerce and food and beverages.
Huiyin Group has more than 20 subsidiaries, assets of over $2 billion and more than 1,000 employees."])

(def ^:private ^:const company-url
  "https://www.linkedin.com/company/10970209?trk=tyah&trkInfo=clickedVertical%3Acompany%2CentityType%3AentityHistoryName%2CclickedEntityId%3Acompany_company_company_10970209%2Cidx%3A0")

(def ^:const navigation
  [{:text "Home" :href "#/home"}
   {:text "About" :href "#/about"}
   {:text "Join Us" :target "_blank" :href company-url}])

(def ^:const infos
  ["&copy; Copyright Huiyin Group 2016"
   "沪ICP备15051469号"
   "沪公网安备 31010602000185号"])

(def ^:const footer-links
  [{:name (:title messages) :href company-url :icon "linkedin-square"}
   {:name "Contact Us" :href "mailto:woquan826@gmail.com" :icon "envelope"}])
