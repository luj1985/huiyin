(ns huiyin.app
  (:require
   [clojure.string :refer [blank?]]
   [secretary.core :as secretary :refer-macros [defroute]]
   [reagent.core :as r :refer [atom]]
   [goog.events :as events]
   [goog.history.EventType :refer [NAVIGATE]]
   [goog.events.EventType :refer [SCROLL RESIZE]]
   [goog.dom :as dom]
   [huiyin.content :refer [main]]
   [huiyin.master :refer [header footer]])
  (:import goog.history.Html5History))

(enable-console-print!)

(defn- viewport-size []
  (let [w (.-innerWidth js/window)
        h (.-innerHeight js/window)]
    {:width w :height h}))

(defn- scroll-offset []
  (let [offset (dom/getDocumentScroll)]
    {:x (.-x offset) :y (.-y offset)}))

(defonce state (atom {:offset (scroll-offset)
                      :viewport (viewport-size)}))

(defroute home "/home" []
  (js/console.log "home"))

(defroute about "/about" []
  (js/console.log "scroll to speicifc position"))

;;; XXX: React fragment API is still in developing, an empty div container is required
;;; https://github.com/facebook/react/issues/2127
(defn home-page []
  [:div
   [header state]
   [main state]
   [footer state]])

(defroute index "/" []
  (r/render [home-page] (.getElementById js/document "app")))

(defonce history
  (do
    (secretary/set-config! :prefix "#")
    (doto (Html5History.)
      (events/listen NAVIGATE #(secretary/dispatch! (.-token %)))
      (.setEnabled true))))

(defonce events-setup
  (do
    (events/listen js/window SCROLL #(swap! state assoc :offset (scroll-offset)))
    (events/listen js/window RESIZE #(swap! state assoc :viewport (viewport-size)))))

(defn init []
  ;;; XXX: For reagent component change, it only refresh its definition
  ;;; doesn't have router event, page still show old version
  ;;; manually restart history to route pages
  ;;; can be disabled in release version

  ;;; TODO: setup debug profile
  (doto history
    (.setEnabled false)
    (.setEnabled true)))


