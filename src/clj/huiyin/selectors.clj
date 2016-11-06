(ns huiyin.selectors
  (:require
   [garden.def :refer [defrule defstyles]]
   [garden.color :refer [rgb rgba]]
   [garden.units :refer [ms]]
   [garden.selectors :refer [defselector]]))

(def logo-color "#E00000")
(def text-color (rgb 101 107 111))
(def white (rgba 255 255 255 0.7))
(def black (rgba 0 0 0 0.7))
(def dimmer-color (rgba 0 0 0 0.82))

(def transition-time (ms 300))

(defselector app "#app")
(defselector container ".container")
(defselector jumbotron ".jumbotron")
(defselector main "main")

