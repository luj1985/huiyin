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
    (for [[{:keys [name title avatar]} i] (zipmap members (range))]
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
        [:img {:src logo}] name]])]])

#?(:cljs
   (defn- scroll-to-element [selector & [offset]]
     (let [offset (or offset 0)
           el (.querySelector js/document selector)
           el-rect (.getBoundingClientRect el)
           will-scroll-to (+ (.-scrollY js/window) (.-top el-rect))]
       ;;; TODO: animate scroll to
       #_(.scrollTo js/window 0 (+ will-scroll-to offset)))))

(defmulti render (fn [state] (:path @state)))

(defmethod render :home [state]
  #?(:cljs (.requestAnimationFrame js/window #(scroll-to-element "main")))
  [:main
   [jumbotron/render state]
   [:div.container.columns
    [:div.content
     [render-intro]
     [render-members state]]
    [render-companies]]])

(defmethod render :about [state]
  ;;; there is 70 px header, has to add some offset
  #?(:cljs (.requestAnimationFrame js/window #(scroll-to-element ".content" -70)))
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
   [:.avatar {:flex-shrink 0
              :width (rem 4)
              :height (rem 4)
              :box-shadow [[0 0 (px 4) (rgba 0 0 0 0.8)]]
              :border-radius (percent 50)
              :background-repeat :no-repeat
              :background-position [[(percent 50) (percent 50)]]
              :background-size [[(percent 100) :auto]]}]
   [:.desc {:padding [[0 (rem 1)]]}]])

(def ^:private company-style
  [[:li.company {:display :inline-block
                 :margin [[(rem 1) (rem 3) (rem 1) 0]]}
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
    {:min-width (px 737)}
    [:.content {:display :flex :flex-direction :row}
     [:section {:flex 1}]])])

(def css
  [company-style
   member-card
   section-layout
   jumbotron/css
   member/css])
