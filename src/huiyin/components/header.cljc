(ns huiyin.components.header
  #?(:clj
     (:refer-clojure :exclude [> - + first not rem]))
  #?(:clj
     (:require
      [garden.def :refer [defstyles]]
      [garden.stylesheet :refer [at-media]]
      [garden.selectors :refer :all :exclude [map meta time empty]]
      [garden.color :refer [rgb rgba]]
      [garden.units :refer [px percent]]
      [huiyin.variables :refer :all]
      [huiyin.selectors :refer :all])
     :cljs
     (:require
      [clojure.string :refer [join]]
      [huiyin.data :refer [navigation messages]]
      [huiyin.variables :refer [logo-size logo-circle header-compact-threshold]])))

#?(:cljs
   (do
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
             p3 (->Point (- inner offset) (+ inner offset))
             p4 (->Point radius (+ radius (/ offset 2)))]
         (join
          " "
          ["M" r1 "A" c1 "0 0 1" r2 "A" c1 "0 0 1" r1 "Z"
           "M" p2 "A" c2 "0 0 0" p1 "Z"
           "M" p1 "A" c2 "0 0 0" p3 "Z"
           "M" p3 "A" c2 "0 0 0" p2 "L" p4 "Z"])))

     (defn render [state]
       (let [offset-y (get-in @state [:offset :y])
             compact?  (> offset-y header-compact-threshold)]
         [:header.resizable {:class-name (if compact? :compact)}
          [:div.container
           [:div#logo
            [:svg
             [:path {:d (render-logo logo-size logo-circle)}]]
            [:h1 (:title messages)]]
           [:nav
            (for [{:keys [href text target]} navigation]
              ^{:key href} [:a {:class-name :underline :href href :target target} text])]]]))))

#?(:clj
   (do
     (defselector logo "#logo")
     (defselector compact ".compact")

     (defstyles header-logo-style
       [logo {:display :flex
              :flex-direction :row
              :align-items :center
              :margin-left (px 8)}

        [svg {:transition [[:all transition-time]]
              :width (px logo-size)
              :height (px logo-size)
              :fill logo-color
              :transform (scale 1)}]

        [h1 {:font-size (px 20)
             :transition [[:all transition-time]]
             :margin [[0 0 0 (px 16)]]
             :white-space :nowrap
             :color logo-color}]]

       [compact {:height (px 77)
                 :background-color dimmer-color}
        [logo
         [svg {:transform (scale 0.8)
               :margin-right (px -8)}]]])

     (defstyles normal-header-style
       [header {:position :fixed
                :width (percent 100)
                :height (px 140)
                :z-index 100
                :transition (for [attr [:height :background-color]]
                              [attr transition-time])
                :background-color (rgba 0 0 0 0)}

        [(> container) {:display :flex
                        :align-items :center
                        :justify-content :space-between
                        :height (percent 100)
                        :padding [[0 (px 8)]]}]

        [nav {:display :flex
              :flex-direction :row}]

        [a {:margin [[0 (px 24)]]
            :font-size (px 22)
            :white-space :nowrap}]])

     (defstyles mobile-header-logo-style
       [header
        [logo
         [svg {:transform (scale 1)}]
         [h1 {:display :none}]]
        [a {:font-size (px 16)
            :margin [[0 (px 12)]]}]]
       [compact
        [logo
         [svg {:transform [[(scale 0.78) (translateX (px -16))]]}]]])

     #_(defstyles mobile-header-logo-style
         [:header
          [:>.container {:flex-direction :column
                         :align-items :flex-start
                         :justify-content :center}
           [:nav {:opacity 0
                  :transition [[:all transition-time]]}]]
          [:#logo
           [:h1 {:font-size (px 20)}]]
          [:a {:font-size (px 16)
               :margin [[0 (px 12)]]}]]
         [:header.compact {:height (px 90)}
          [:>.container
           [:nav {:opacity 1
                  :transform (translateY (px -8))}]]
          [:#logo
           [:h1 {:transform (translateX (px -32))}]
           [:svg {:transform [[(scale 0.5) (translateX (px -32))]]}]]])

     (defstyles mobile-header-style
       (at-media
        {:max-width (px 767)}
        mobile-header-logo-style))

     (defstyles component-style
       normal-header-style
       header-logo-style
       mobile-header-style)))
