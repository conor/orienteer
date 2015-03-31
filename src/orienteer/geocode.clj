(ns orienteer.geocode
  (:require [clojure.core.match :refer [match]]))

(defn search
  "Geolocate a place from its address, place name, ip or geolocation"
  [data]
  (match [data]
    [[(_ :guard #(float? %)) (_ :guard #(float? %))]] "Vector"
    [(_ :guard #(string? %))] "String"
    :else "Sorry I we don't support the data format"))

(defn result->formatted-address
  "Take a geolocation result and extracts formatted address"
  [result]
  "Not implemented")

(defn result->location
  "Take a geolocation result and transform into a vector [lat,lng]"
  [result]
  "Not implemented")
