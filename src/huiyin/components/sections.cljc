(ns huiyin.components.sections
  (:refer-clojure :exclude [rem])
  (:require
   [garden.stylesheet :refer [at-media]]
   [garden.units :refer [px percent rem]]
   [garden.color :refer [rgb rgba]]
   [huiyin.data :refer [members companies introductions messages]]
   [huiyin.components.jumbotron :as jumbotron]
   [huiyin.components.member :as member]))

(defn- render-intro []
  [:section
   [:h2 (get-in messages [:sections :intro])]
   (doall
    (map-indexed
     (fn [i html]
       ^{:key i} [:p {:dangerouslySetInnerHTML {:__html html}}])
     introductions))])

(defn- render-members []
  [:section
   [:h2 (get-in messages [:sections :who-we-are])]
   [:ul
    (for [[{:keys [index name title avatar attrs]} i] (zipmap members (range))]
      ^{:key i}
      [:li.member
       [:div.avatar {:style {:background-image (str "url(" avatar ")")}}]
       [:div.desc
        [:h4
         [:a {:href (str "#/member/" i)}
          name]]
        [:h5 title]]])]])

(defn- render-companies []
  [:aside
   [:h2
    [:a {:href "https://angel.co/huiyin-blockchain-venture"} (get-in messages [:sections :angel])]]
   [:ul
    (for [{:keys [name url logo]} companies]
      ^{:key url}
      [:li.company
       [:a {:href url :target "_blank"}
        [:img {:src logo}]
        name]])]])

(defmulti render (fn [state] (:path @state)))

(defmethod render :home [state]
  [:main
   [jumbotron/render state]
   [:div.container.columns
    [:div.content
     [render-intro]
     [render-members state]]
    [render-companies]]])

;;; TODO: scroll to positon
(defmethod render :about [state]
  [:main
   [jumbotron/render state]
   [:div.container.columns
    [:div.content
     [render-intro]
     [render-members state]]
    [render-companies]]])

(defmethod render :member [state]
  (member/render state))

(defmethod render :default [state]
  [:main {:style {:min-height "100%"}}
   [:section.jumbotron {:style {:height "300px"}}]
   [:div.container.resume
    [:h2 (:not-found messages)]]])


(def ^:private member-card
  [:.member {:display :flex
             :flex-direction :row
             :margin [[(rem 1.5) 0]]}

   [:.avatar {:display :inline-block
              :flex-shrink 0
              :width (rem 4)
              :height (rem 4)
              :box-shadow [[0 0 (px 4) (rgba 0 0 0 0.8)]]
              :background-repeat :no-repeat
              :background-position [[(percent 50) (percent 50)]]
              :background-size [[(percent 100) :auto]]
              :border-radius (percent 50)}]
   [:.desc {:padding [[0 (rem 1)]]}]])

(def ^:private section-layout
  [[:.columns {:display :flex
               :flex-direction :row
               :padding 0}
    [:aside {:flex-shrink 0
             :padding (rem 1)}]
    [:section {:padding (rem 1)}
     [:ul {:padding 0}]
     [:li {:line-height 1.3
           :list-style :none}]]]

   (at-media
    {:max-width (px 736)}
    [:.company {:margin [[(rem 1) 0]]}]
    [:.content {:display :flex
                :flex-direction :column}])
   (at-media
    {:min-width (px 737)}
    [:.company {:margin [[(rem 1) 0]]}]
    [:.content {:display :flex
                :flex-direction :row}
     [:section {:flex 1}]])

   (at-media
    {:min-width (px 736)
     :max-width (px 1023)}
    [:.columns {:flex-direction :column}]
    [:.company {:display :inline-block
                :margin-right (rem 3)}])])

(def ^:private company-style
  [[:li.company
    [:img {:height (rem 3)
           :width (rem 3)
           :margin-right (rem 1)}]
    [:a {:display :flex
         :flex-direction :row
         :align-items :center}]]])

(def ^:private mobile-main-style
  [(at-media
    {:max-width (px 767)}
    [:main
     [:.columns {:flex-direction :column}]]
    [:.resume {:flex-direction :column}
     [:img {:margin 0}]]
    [:.jumbotron
     [:h1 {:font-size (rem 2.75)}]])])

(def css
  [company-style
   mobile-main-style
   member-card
   section-layout
   jumbotron/css
   member/css])
