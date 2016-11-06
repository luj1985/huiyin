(ns huiyin.selectors
  (:require
   [garden.def :refer [defrule defstyles defcssfn]]
   [garden.color :refer [rgb rgba]]
   [garden.units :refer [ms]]
   [garden.selectors :refer [defselector]]))

(defselector app "#app")
(defselector container ".container")
(defselector jumbotron ".jumbotron")
(defselector main "main")

(defcssfn url)
(defcssfn scale)
(defcssfn scaleX)
(defcssfn translateX)
(defcssfn translateY)
(defcssfn translate)

