(ns huiyin.components.header
  (:refer-clojure :exclude [rem])
  (:require
   #?(:cljs [reagent.core :as r :refer [atom]])
   #?(:cljs [goog.events :as events])
   #?(:cljs [goog.dom :as dom])
   #?(:cljs [goog.events.EventType :refer [SCROLL]])
   [clojure.string :refer [join]]
   [garden.color :refer [rgb rgba]]
   [garden.units :refer [px percent rem]]
   [garden.stylesheet :refer [at-media]]
   [huiyin.variables :refer [transition-time]]
   [huiyin.data :refer [navigation messages]]))

(def ^:private ^:const logo-size 64)
(def ^:private ^:const logo-circle 3)
(def ^:private ^:const logo-color "#E00000")
(def ^:private ^:const dimmer-color (rgba 0 0 0 0.82))

(defrecord Point [x y]
  Object
  (toString [_]
    (join "," [x y])))

(defn- render-logo [diameter border]
  (let [radius (/ diameter 2)
        inner (- radius border)
        offset (/ inner (Math/sqrt 2))

        c1 (->Point radius radius)
        c2 (->Point inner inner)

        r1 (->Point radius 0)
        r2 (->Point radius diameter)

        p1 (->Point radius border)
        p2 (->Point (+ radius offset) (+ radius offset))
        p3 (->Point (- radius offset) (+ radius offset))
        p4 (->Point radius (+ radius (/ offset 2)))]
    (join
     " "
     ["M" r1 "A" c1 "0 0 1" r2 "A" c1 "0 0 1" r1 "Z"
      "M" p2 "A" c2 "0 0 0" p1 "Z"
      "M" p1 "A" c2 "0 0 0" p3 "Z"
      "M" p3 "A" c2 "0 0 0" p2 "L" p4 "Z"])))


#?(:cljs
   (do
     (defn- get-scroll-offset []
       (let [offset (dom/getDocumentScroll)]
         {:x (.-x offset) :y (.-y offset)}))

     (def scroll-state (atom {:offset (get-scroll-offset)}))

     (events/listen js/window SCROLL #(swap! scroll-state assoc :offset (get-scroll-offset)))))

(defn render [state]
  (let [offset-y #?(:clj 140
                    :cljs (get-in @scroll-state [:offset :y]))
        compact?  (> offset-y 64)]

    [:header {:class-name (if compact? :compact)}
     [:div.container
      [:div#logo
       [:svg
        [:path {:d (render-logo logo-size logo-circle)}]]
       [:h1 (:title messages)]]
      (into [:nav]
            (for [{:keys [href text target children]} navigation]
              ^{:key text}
              [:a.underline.lmenu {:href href :target target :class (if (:menu-actived @state) "active")
                                   :on-click (fn []
                                               (if children
                                                 (swap! state update-in [:menu-actived] not)))} text
               (if children
                 [:ul.submenu
                  (for [{:keys [href text target]} children]
                    ^{:key href} [:li
                                  [:a {:href href :target target} text]])])]))]]))

(def ^:private tiny-device-style
  [(at-media
    {:max-width (px 480)}
    [[:header
      [:a {:font-size (px 16)}]]
     [:.compact
      [:#logo
       [:svg {:transform [["scale(0.78)" "translateX(-16px)"]]}]]]])])

(def ^:private small-device-style
  [(at-media
    {:max-width (px 735)}
    [[:header
      [:h1 {:display :none}]]])])


(def ^:private large-device-style
  [(at-media
    {:min-width (px 736)}
    [:header
     [:a {:font-size (rem 1.1)
          :margin-right (rem 2.5)}]])])

(def ^:private normal-style
  [[:.submenu {:position :absolute
               :z-index 10
               :margin-top (rem 1)
               :padding-left (rem 1)
               :padding-right (rem 1)
               :transform "translateX(1rem)"
               :right 0
               :background-color :black
               :display :none}
    [:a {:margin 0
         :color (rgba 255 255 255 0.85)}]
    [:li {:line-height (rem 3)}]]

   [:header {:position :fixed
             :width (percent 100)
             :height (px 140)
             :z-index 100
             :transition (for [attr [:height :background-color]]
                           [attr transition-time])}

    [:a.active
     [:.submenu {:display :block}]]

    [:.container {:display :flex
                  :align-items :center
                  :justify-content :space-between
                  :height (percent 100)
                  :padding [[0 0 0 (rem 1)]]}]

    [:nav :#logo {:display :flex
           :flex-direction :row
           :align-items :center}]

    [:a {:margin-right (rem 1.25)
         :white-space :nowrap}]]

   [:#logo
    [:svg {:transition [[:all transition-time]]
           :width (px logo-size)
           :height (px logo-size)
           :fill logo-color
           :transform "scale(1)"}]

    [:h1 {:font-size (rem 1.25)
          :transition [[:all transition-time]]
          :margin [[0 0 0 (px 16)]]
          :white-space :nowrap
          :color logo-color}]]

   [:.compact {:height (rem 4)
               :background-color dimmer-color}
    [:#logo
     [:svg {:transform "scale(0.8) translateX(-8px)"}]
     [:h1 {:transform "translateX(-16px)"}]]]])

(def css
  [normal-style
   tiny-device-style
   small-device-style
   large-device-style])
