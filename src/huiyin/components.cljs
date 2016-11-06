(ns huiyin.components
  (:require
   [clojure.string :refer [join]]
   [huiyin.components.footer :refer [hy-footer]]
   [huiyin.components.header :refer [hy-header]]
   [huiyin.components.sections :refer [jumbotron display-intro display-members display-companies display-member-detail]]
   [huiyin.data :refer [members companies introductions links infos messages]]
   [huiyin.variables :refer [logo-size logo-circle header-compact-threshold]]))


(defmulti hy-content (fn [state] (:page @state)))

(defmethod hy-content :home [state]
  [:main
   [jumbotron state]
   [:div.container.columns
    [display-intro]
    [display-members state]
    [display-companies]]])

(defmethod hy-content :member [state]
  (display-member-detail state))

(defmethod hy-content :default [state]
  [:main.container
   (:not-found messages)])

;;; XXX: React fragment API is still in developing, an empty div container is required
;;; https://github.com/facebook/react/issues/2127
(defn render-pages [state]
  [:div
   [hy-header state]
   [hy-content state]
   [hy-footer state]])
