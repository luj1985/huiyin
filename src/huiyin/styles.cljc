(ns huiyin.styles
  (:require
   [huiyin.typography :as t]
   [huiyin.components.header :as h]
   [huiyin.components.footer :as f]
   [huiyin.components.sections :as c]))

(def screen
  [t/css
   h/css
   f/css
   c/css])
