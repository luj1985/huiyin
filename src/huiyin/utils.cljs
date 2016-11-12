(ns huiyin.utils
  (:require [goog.dom :as dom]))

(defn scroll-to-element [selector & [offset]]
  (.setTimeout
   js/window
   (fn []
     (let [offset (or offset 0)
           el (.querySelector js/document selector)
           el-rect (.getBoundingClientRect el)
           scroll-y (.-y (dom/getDocumentScroll))
           will-scroll-to (+ scroll-y (.-top el-rect))]
       ;;; TODO: animate scroll to
       (.scrollTo js/window 0 (+ will-scroll-to offset))))) 100)
