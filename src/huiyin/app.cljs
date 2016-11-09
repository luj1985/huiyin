(ns huiyin.app
  (:require
   [secretary.core :as secretary :refer-macros [defroute]]
   [reagent.core :as r :refer [atom]]
   [goog.dom :as dom]
   [goog.events :as events]
   [goog.events.EventType :refer [SCROLL RESIZE]]
   [goog.history.EventType :refer [NAVIGATE]]
   [huiyin.components.header :as h]
   [huiyin.components.footer :as f]
   [huiyin.components.sections :as s])
  (:import goog.history.Html5History))

(enable-console-print!)

(defn- document-size []
  (let [h (dom/getDocumentHeight)]
    {:height h}))

(defn- viewport-size []
  (let [w (.-innerWidth js/window)
        h (.-innerHeight js/window)]
    {:width w :height h}))

(defn- scroll-offset []
  (let [offset (dom/getDocumentScroll)]
    {:x (.-x offset) :y (.-y offset)}))

(defn- footer-size []
  (let [footer (.querySelector js/document "footer")]
    {:width (.-clientWidth footer)
     :height (.-clientHeight footer)}))

(defonce state
  (atom {:path "/"
         :offset (scroll-offset)}))

(defroute index "/" [] {:path :home})
(defroute home "/home" []  {:path :home})
(defroute about "/about" [] {:path :about})
(defroute member "/member/:id" [id]
  (let [id (js/parseInt id)]
    {:path :member :params {:id id}}))

(defonce history
  (do
    (secretary/set-config! :prefix "#")
    (doto (Html5History.)
      (events/listen
       NAVIGATE
       (fn [event]
         (let [{:keys [path params]} (secretary/dispatch! (.-token event))]
           (swap! state assoc :path path :params params))))
      (.setEnabled true))))

;;; XXX: React fragment API is still in developing, an empty div container is required
;;; https://github.com/facebook/react/issues/2127
(defn render-pages [state]
  [:div
   [h/render state]
   [s/render state]
   [f/render state]])

;;; XXX: for iOS device, the viewport size can change when scroll up/down
(defn caculate-sizes! []
  (let [old-viewport-size (get @state :viewport-size)
        viewport-size (viewport-size)
        resized? (not= (:width viewport-size) (:width old-viewport-size))]
    (swap! state assoc
           :jumbotron-height (:height (if resized? viewport-size old-viewport-size))
           :footer-size (footer-size)
           :document-size (document-size)
           :viewport-size viewport-size)))

(defonce events-setup
  (do
    (events/listen js/window SCROLL #(swap! state assoc :offset (scroll-offset)))
    (events/listen js/window RESIZE caculate-sizes!)))

(defn init []
  ;;; Always render the full page
  ;;; because of the virtual DOM, most of the render work can be skipped
  ;;; only apply delta when `state` changed
  (r/render [render-pages state]
            (.getElementById js/document "app"))

  (caculate-sizes!))
