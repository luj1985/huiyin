(ns huiyin.utils)

(defn scroll-to-element [selector & [offset]]
  (.setTimeout
   js/window
   (fn []
     (let [offset (or offset 0)
           el (.querySelector js/document selector)
           el-rect (.getBoundingClientRect el)
           will-scroll-to (+ (.-scrollY js/window) (.-top el-rect))]
       ;;; TODO: animate scroll to
       (.scrollTo js/window 0 (+ will-scroll-to offset))))) 0)
