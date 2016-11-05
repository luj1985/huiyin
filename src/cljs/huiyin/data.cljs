(ns huiyin.data)

;;; These data can also be loaded from a web server
;;; TODO: use macro to read data from external file

(def ^:const members
  [{:name "James Wo"
    :title "CEO, Huiyin Blockchain Venture"
    :avatar "/images/avatar.jpg"
    :attrs [{:email "woquan826@gmail.com"}
            {:email "woquan826@163.com"}
            {:email "woquan@huiyin.com"}
            {:twitter {:name "@woquan826" :value "https://twitter.com/woquan826"}}
            {:linked-in {:name "james-wo-272904114" :value "https://www.linkedin.com/in/james-wo-272904114"}}]}

   {:name "Freddy Zheng"
    :title "Director, Management Huiyin Blockchain Venture"
    :avatar "/images/avatar.jpg"
    :attrs [{:email "zhengbing@huiyin.com"}]}

   {:name "Shang Zhang"
    :title "Senior Associate, Huiyin Blockchain Venture"
    :avatar "/images/avatar.jpg"
    :attrs [{:email "zhanghong@huiyin.com"}]}

   {:name "Andrew Lee"
    :title "Board Advisor"
    :avatar "/images/avatar2.jpg"
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

(def ^:const links
  [{:text "Home" :href "#/home"}
   {:text "About" :href "#/about"}
   {:text "Join Us" :target "_blank" :href company-url}])

(def ^:const infos
  ["&copy; Copyright Huiyin Group 2016"
   "沪ICP备15051469号"
   "沪公网安备 31010602000185号"])
