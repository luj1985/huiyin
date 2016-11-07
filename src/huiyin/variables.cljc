(ns huiyin.variables
  (:require [garden.units :refer [px ms]]
            [garden.color :refer [rgb rgba]]))

(def ^:const max-content-width (px 1170))

(def ^:const transition-time (ms 300))

(def ^:const headline-color (rgba 0 0 0 0.7))
(def ^:const headline-color-invert (rgba 255 255 255 0.7))

(def ^:const text-color (rgb 101 107 111))
(def ^:const dimmer-color (rgba 0 0 0 0.82))

