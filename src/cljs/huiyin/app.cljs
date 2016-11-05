(ns huiyin.app
  (:require
   [clojure.string :refer [blank?]]
   [secretary.core :as secretary :refer-macros [defroute]]
   [reagent.core :as reagent :refer [atom]]
   [goog.events :as events]
   [goog.history.EventType :refer [NAVIGATE]]
   [goog.events.EventType :refer [SCROLL]]
   [goog.dom :as dom]
   [huiyin.content :refer [main]]
   [huiyin.master :refer [header footer]])
  (:import goog.history.Html5History))

(def state (atom {:offset-y 0}))

(secretary/set-config! :prefix "#")

(defroute home "/home" []
  (js/console.log "home"))

(defroute about "/about" []
  (js/console.log "scroll to speicifc position"))

;;; XXX: React fragment API is still under development, container is required
;;; https://github.com/facebook/react/issues/2127
(defn home-page []
  [:div
   (header state)
   [main state]
   [footer state]])

(defroute index "/" []
  (reagent/render-component [home-page] (.getElementById js/document "app")))

(defn- update-scroll-state []
  (let [offset (dom/getDocumentScroll)]
    (swap! state assoc :offset-y (.-y offset))))

(defonce initialize
  (do
    (events/listen js/window SCROLL update-scroll-state)
    (doto (Html5History.)
      (events/listen NAVIGATE #(secretary/dispatch! (.-token %)))
      (.setEnabled true))))

(defn init []
  (enable-console-print!))


