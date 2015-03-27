(ns orienteer.conversions)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Conversion factors
(def km-in-mi 0.621371192) ;; Conversion factor for km to miles
(def km-in-nm 0.539957) ;; Conversion factor for km to nautical miles
(def mi-in-km (/ 1 km-in-mi))
(def nm-in-km (/ 1 km-in-nm))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Conversions

(defn degs->rads
  "Convert degrees to radians"
  [degs]
  (Math/toRadians degs))

(defn rads->degs
  "Converts radians to degrees"
  [rads]
  (Math/toDegrees rads))

(defn km->mi
  "Converts kilometres to miles"
  [km]
  (* km km-in-mi))

(defn mi->km
  "Converts miles to kilometres"
  [mi]
  (* mi mi-in-km))

(defn km->nm
  "Converts kilometres to nautical miles"
  [km]
  (* km km-in-nm))

(defn nm->km
  "Converts nautical miles to kilometres"
  [nm]
  (* nm nm-in-km))
