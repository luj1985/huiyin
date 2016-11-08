(ns huiyin.components.sections
  (:refer-clojure :exclude [rem])
  (:require
   [huiyin.variables :refer [transition-time headline-color-invert]]
   [garden.stylesheet :refer [at-media]]
   [garden.units :refer [px percent rem]]
   [garden.color :refer [rgb rgba]]
   [huiyin.data :refer [members companies introductions messages]]
   [huiyin.components.member :as member]))

(defn- render-jumbotron [state]
  (let [height (get-in @state [:viewport :height])]
    [:section.jumbotron {:style {:height height}}
     [:h1 (:title messages)]]))

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
       [:div.contact
        [:h4
         [:a {:href (str "#/member/" i)}
          name]]
        [:h5 title]]])]])

(defn- render-companies []
  [:section
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
   [render-jumbotron state]
   [:div.container.columns
    [render-intro]
    [render-members state]
    [render-companies]]])

(defmethod render :about [state]
  ;;; TODO: scroll to positon
  [:main
   [render-jumbotron state]
   [:div.container.columns
    [render-intro]
    [render-members state]
    [render-companies]]])

(defmethod render :member [state]
  (member/render state))

(defmethod render :default [state]
  [:main.container
   (:not-found messages)])

(def ^:private jumbotron-style
  [[:.jumbotron {:display :flex
                 :padding [[0 (px 16)]]
                 :align-items :center
                 :justify-content :center
                 :background [["url(/images/home.jpg)" :no-repeat :center :bottom]]
                 :background-size :center
                 :max-height (px 1024)
                 :transition [[:all transition-time]]}

    [:h1 {:color headline-color-invert
          :font-family ["\"A2 60 Display Regular\"" "\"Arial Black\"" "Arial" "Helvetica" "Verdana" "sans-serif"]
          :transform "translateY(-50px)"
          :text-align :center}]]])

(def ^:private main-style
  [[:main {:display :block
           :margin-bottom (px 40)}]

   [:.member {:display :flex
              :flex-direction :row
              :margin [[(px 16) 0]]}

    [:.avatar {:display :inline-block
               :flex-shrink 0
               :width (px 60)
               :height (px 60)
               :margin-right (px 16)
               :box-shadow "0 0 4px rgba(0, 0, 0, .8)"
               :background-repeat :no-repeat
               :background-position "50% 50%"
               :background-size "100% auto"
               :border-radius (percent 50)}]
    [:.contact {:padding [[0 (px 8)]]}]]

   [:.columns {:display :flex
               :flex-direction :row
               :padding 0}

    [:section
     [:ul {:padding 0}]
     [:li {:line-height 1.3
           :list-style :none}]]]

   [".columns>*:nth-child(1)" {:flex 5}]
   [".columns>*:nth-child(2)" {:flex 5}]
   [".columns>*:nth-child(3)" {:flex 2}]
   [".columns>*" {:padding (rem 1)}]])

(def ^:private company-style
  [[:li.company
    [:img {:height (px 50)
           :width (px 50)
           :margin (px 8)
           :margin-left 0}]
    [:a {:display :flex
         :flex-direction :row
         :align-items :center}]]])

(def ^:private mobile-main-style
  [(at-media {:max-width (px 767)}
             [:main
              [:.columns {:flex-direction :column}]]
             [:.resume {:flex-direction :column}
              [:img {:margin 0}]]
             [:.jumbotron
              [:h1 {:font-size (px 45)}]])])

(def css
  [jumbotron-style
   main-style
   company-style
   mobile-main-style
   member/css])
