(ns huiyin.app
  (:require
   [secretary.core :as secretary :refer-macros [defroute]]
   [reagent.core :as r :refer [atom]]
   [goog.events :as events]
   [goog.history.EventType :refer [NAVIGATE]]
   [goog.events.EventType :refer [SCROLL RESIZE]]
   [goog.dom :as dom]
   [huiyin.master :refer [display-header display-footer]]
   [huiyin.content :refer [display-content]])
  (:import goog.history.Html5History))

(enable-console-print!)

(defn- viewport-size []
  (let [w (.-innerWidth js/window)
        h (.-innerHeight js/window)]
    {:width w :height h}))

(defn- scroll-offset []
  (let [offset (dom/getDocumentScroll)]
    {:x (.-x offset) :y (.-y offset)}))

(defonce state
  (atom {:offset (scroll-offset)
         :viewport (viewport-size)}))

(defroute index "/" [] {:page :home})
(defroute home "/home" []  {:page :home})
(defroute about "/about" [] {:page :about})
(defroute member "/member/:id" [id]
  (let [id (js/parseInt id)]
    {:page :member :params {:id id}}))

(defonce history
  (do
    (secretary/set-config! :prefix "#")
    (doto (Html5History.)
      (events/listen
       NAVIGATE
       (fn [event]
         (let [{:keys [page params]} (secretary/dispatch! (.-token event))]
           (swap! state assoc :page page :params params))))
      (.setEnabled true))))

(defonce events-setup
  (do
    (events/listen js/window SCROLL #(swap! state assoc :offset (scroll-offset)))
    (events/listen js/window RESIZE #(swap! state assoc :viewport (viewport-size)))))

;;; XXX: React fragment API is still in developing, an empty div container is required
;;; https://github.com/facebook/react/issues/2127
(defn- render-pages [state]
  [:div
   [display-header state]
   [display-content state]
   [display-footer state]])

(defn init []
  ;;; Always render the full page
  ;;; because of the virtual DOM, most of the render work can be skipped
  ;;; only apply delta when `state` changed
  (r/render [render-pages state]
            (.getElementById js/document "app")))

