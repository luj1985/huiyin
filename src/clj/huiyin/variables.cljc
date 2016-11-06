(ns huiyin.variables
  (:require [garden.units :refer [px]]
            [garden.color :refer [rgb rgba]]
            [garden.units :refer [ms]]))

(def ^:const logo-color "#E00000")
(def ^:const text-color (rgb 101 107 111))
(def ^:const white (rgba 255 255 255 0.7))
(def ^:const black (rgba 0 0 0 0.7))
(def ^:const dimmer-color (rgba 0 0 0 0.82))
(def ^:const transition-time (ms 300))
(def ^:const logo-size 70)


