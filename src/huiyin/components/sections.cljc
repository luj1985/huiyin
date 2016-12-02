(ns huiyin.components.sections
  (:refer-clojure :exclude [rem])
  (:require
   [garden.stylesheet :refer [at-media]]
   [garden.units :refer [px percent rem]]
   [garden.color :refer [rgb rgba]]
   [huiyin.data :refer [members companies introductions messages presses]]
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
    (for [[{:keys [name thumb title avatar]} i] (zipmap members (range))]
      ^{:key i}
      [:li.member
       [:img.avatar {:src thumb}]
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
        [:img {:src logo}] name]])]])

(defmulti render (fn [state] (:path @state)))

(defmethod render :home [state]
  [:main
   [jumbotron/render state]
   [:div.container.columns
    [:div.content
     [render-intro]
     [render-members state]]
    [render-companies]]])

(defmethod render :about [state]
  [:main
   [jumbotron/render state]
   [:div.container.columns
    [:div.content
     [render-intro]
     [render-members state]]
    [render-companies]]])

(defn render-press [{:keys [title links]}]
  [:div.column
   [:h3 title]
   [:ul
    (for [{:keys [title from href date]} links]
      ^{:key href}
      [:li
       [:div.from
        [:img {:src from}]
        [:span.date date]]
       [:a {:href href :target "_blank"} title]])]])

(defmethod render :press [state]
  [:main
   [:section.jumbotron {:style {:height "300px"}}]
   [:div.container.presses
    [render-press (:en presses)]
    [render-press (:zh presses)]]])

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
   [:.avatar {:flex-shrink 0
              :width (rem 4)
              :height (rem 4)
              :box-shadow [[0 0 (px 4) (rgba 0 0 0 0.8)]]
              :border-radius (percent 50)}]
   [:.desc {:padding [[0 (rem 1)]]}]])

(def ^:private company-style
  [[:li.company {:display :block
                 :margin [[(rem 1) (rem 1) (rem 1) 0]]}
    [:img {:height (rem 3)
           :width (rem 3)
           :margin-right (rem 1)}]
    [:a {:display :flex
         :flex-direction :row
         :align-items :center}]]])

(def ^:private section-layout
  [[:.columns {:display :flex
               :flex-direction :row
               :padding 0}
    [:.content {:flex-grow 9}]
    [:aside {:flex-grow 0}]
    [:aside {:padding (rem 1)}]
    [:section {:padding (rem 1)}
     [:ul {:padding 0}]
     [:li {:line-height 1.3
           :list-style :none}]]]

   (at-media
    {:max-width (px 767)}
    [:.jumbotron
     [:h1 {:font-size (rem 2.75)}]])

   (at-media
    {:max-width (px 1023)}
    [:.columns {:flex-direction :column}])

   (at-media
    {:min-width (px 736)
     :max-width (px 1023)}
    [:aside
     [:li.company {:display :inline-block
                   :margin-right (rem 3)}]])

   (at-media
    {:min-width (px 737)}
    [:.content {:display :flex :flex-direction :row}
     [:section {:flex 1}]])])

(def ^:private presses-layout
  [[:.presses {:display :flex
               :margin-bottom (rem 10)}
    [:h3 {:margin-top (rem 3)}]
    [:.column {:flex-grow 5}]
    [:.from {:display :flex
             :align-items :center
             :margin [[(rem 2) 0 (rem 1) 0]]
             :flex-direction :row}
     [:img {:height (rem 1.5)
            :margin-right (rem 3)}]]
    [:a {:line-height (rem 1.75)}]]

   (at-media
    {:max-width (px 736)}
    [:.presses {:flex-direction :column}])

   (at-media
    {:min-width (px 737)}
    [:.presses {:flex-direction :row}])])

(def css
  [company-style
   member-card
   section-layout
   presses-layout
   jumbotron/css
   member/css])
