(ns orienteer.core
  (:require [orienteer.conversions :refer [degs->rads]]))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Formula constants
(def earth-radius 6372.8) ;; Earths radius in kms


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Haversine method for calculating distances

(defn dlat
  "Returns the delta latitude between two points"
  [[lat1 _] [lat2 _]]
  (- lat2 lat1))

(defn dlon
  "Returns the delta longitude between two points"
  [[_ lon1] [_ lon2]]
  (- lon2 lon1))

(defn haversine-a
  [lat1 lat2 dlat dlon]
  (+ (* (Math/sin (/ dlat 2))
        (Math/sin (/ dlat 2)))
     (* (Math/sin (/ dlon 2))
        (Math/sin (/ dlon 2))
        (Math/cos lat1)
        (Math/cos lat2))))

(defn haversine
  "Haversine method for calculating distance between two points on a sphere"
  [pt1 pt2]
  (let [lat1 (degs->rads (first pt1))
        lat2 (degs->rads (first pt2))
        dlat (degs->rads (dlat pt1 pt2))
        dlon (degs->rads (dlon pt1 pt2))]
    (* earth-radius
       2
       (Math/asin (Math/sqrt (haversine-a lat1 lat2 dlat dlon))))))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Public functions

(defn distance-between
  "Calculate the distance between two points"
  [pt1 pt2]
  (if (= pt1 pt2)
    0
    (haversine pt1 pt2)))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Bearing functions
