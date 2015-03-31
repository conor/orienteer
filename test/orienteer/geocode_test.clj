(ns orienteer.geocode-test
  (:require [orienteer.geocode :refer :all]
            [clojure.test :refer :all]))

(def pearl-st-address "7 Pearl St. San Francisco, CA")
(def pearl-st-geo [37.771089, -122.423977])
(def pearl-st-ip "102.000.122.000")
(def duboce-triangle [34.420000, -119.700000])
(def statue-of-liberty [40.689249, -74.044500])

(deftest geocode
  (testing "Find geolocation data for an address"
    (is (= "String" (search pearl-st-address))))
  (testing "Find geolocation data for an place name"
    (is (= "String" (search "Statue of Liberty"))))
  (testing "Find geolocation data for a lat/lng"
    (is (= "Vector" (search pearl-st-geo)))))
