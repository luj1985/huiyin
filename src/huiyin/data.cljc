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

(def ^:const members
  [{:name "James Wo"
    :title "CEO, Huiyin Blockchain Venture"
    :thumb "/images/thumbs/James_Wo.jpg"
    :avatar "/images/avatars/James_Wo.jpg"
    :description "James Wo is the founder and the CEO of Huiyin Blockchain Venture. As a 2nd entrepreneur, James inherits many merits from his father. Diligent, modest and forward-looking, James endeavors to make his own contributions in the Blockchain and Bitcoin areas. James founded HBV when he studied Applied Statistics at Columbia University. From then, he devoted himself to promoting the applications of Blockchain and Bitcoin worldwide. Now as a promising venture capital, HBV steadily stimulates the advancement of the Blockchain industry under the lead of James Wo."
    :attrs [{:email "woquan826@gmail.com"}
            {:email "woquan826@163.com"}
            {:email "woquan@huiyin.com"}
            {:twitter {:name "@woquan826" :value "https://twitter.com/woquan826"}}
            {:linked-in {:name "james-wo-272904114" :value "https://www.linkedin.com/in/james-wo-272904114"}}]}

   {:name "Freddy Zheng"
    :title "Director, Management Huiyin Blockchain Venture"
    :thumb "/images/thumbs/Freddy_Zhang.jpg"
    :avatar  "/images/avatars/Freddy_Zhang.jpg"
    :description "Zheng Bing as a financial advisor to Huiyin Blockchain Venture team, assist James Wo to carry out the venture project of financial due diligence and financial management in greater China region. As a graduate of Shanghai University of Finance and Economics, and a non-practicing member of the Chinese Institute of certified public accountants, efforts in the financial field to do a good job of value analysis and risk control."
    :attrs [{:email "zhengbing@huiyin.com"}]}

   {:name "Shang Zhang"
    :title "Senior Associate, Huiyin Blockchain Venture"
    :thumb "/images/thumbs/Shang_Zhang.jpg"
    :avatar  "/images/avatars/Shang_Zhang.jpg"
    :description "Shang Zhang is the senior advisor of Huiyin Blockchain Venture. Originated in decentralized cryptocurrency - bitcoin, blockchain technologies face many interesting and challenging problems when applied in finance, the Internet of things, and other enterprise environments.The Blockchain research team at HBV Research - China is dedicated to exploratory research and continuous innovations. We are committed to solve practical problems with enterprise-grade solutions and to push extensive adoption of blockchain technologies across areas of finance and the Internet of things."
    :attrs [{:email "zhanghong@huiyin.com"}]}

   {:name "Amy Zhu"
    :title "HR, Huiyin Blockchain Venture"
    :thumb "/images/thumbs/Amy_Zhu.jpg"
    :avatar "/images/avatars/Amy_Zhu.jpg"
    :description "Zhu Xiaojie as a Human Resource manager to Huiyin Blockchain Venture team, assist James Wo to carry out the Human Resource Strategic planning and management in greater China region. As a graduate of Southern Cross University with the major of Supply Chain Management, have years of foreign company management work experiences in HR field. Amy devoted her professional experiences to the HBV future HR management."
    :attrs [{:email "zhuxiaojie@huiyin.com"}
            {:linked-in {:name "amy-zhu-800a65129" :value "https://www.linkedin.com/in/amy-zhu-800a65129"}}]}

   {:name "Andrew Lee"
    :title "CEO at Purse, Advisor at Huiyin Blockchain Venture"
    :thumb "/images/thumbs/Andrew_Lee.jpg"
    :avatar  "/images/avatars/Andrew_Lee.jpg"
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
   {:text "Join Us" :target "_blank" :href company-url}
   {:text "Links" :children [{:text "Company" :href company-url :target "_blank"}
                             {:text "Press" :href "#/press"}]}])

(def ^:const infos
  ["&copy; Copyright Huiyin Group 2016"
   "沪ICP备15051469号"
   "沪公网安备 31010602000185号"])

(def ^:const footer-links
  [{:name (:title messages) :href company-url :icon "linkedin-square"}
   {:name "Contact Us" :href "mailto:woquan826@gmail.com" :icon "envelope"}
   {:name "Press" :href "#/press" :icon "external-link-square"}])


(def ^:const presses
  {:en {:title "Press"
        :links [{:title "China's Huiyin Group Launches $20 Million Bitcoin Fund"
                 :from "/images/logos/yours.png"
                 :date "DEC 1, 2016 "
                 :href "http://www.coindesk.com/chinas-huiyin-group-bitcoin-blockchain-venture-fund-20-million/"}
                {:title "Yours Raises Angel Round to Fix Reddit with Bitcoin"
                 :from "/images/logos/coindesk.png"
                 :date "NOV 15, 2016"
                 :href "https://stories.yours.network/yours-raises-angel-round-to-fix-reddit-with-bitcoin-ffdd8b90f192#.jf55mhuzp"}]}
   :zh {:title "新闻"
        :links [{:title "汇银集团推出2000万美元比特币基金，专注投资比特币区块链"
                 :from "/images/logos/8btc.svg"
                 :date "2016-12-02"
                 :href "http://www.8btc.com/huiyin-group-bitcoin-blockchain-venture"}
                {:title "Yours网络获天使轮融资，有望明年初面世"
                 :from "/images/logos/8btc.svg"
                 :date "2016-11-17"
                 :href "http://www.8btc.com/yours-raises-angel-round"}]}})
