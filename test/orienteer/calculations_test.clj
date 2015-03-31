(ns orienteer.calculations-test
  (:require [clojure.test :refer :all]
            [orienteer.calculations :refer :all]))

;; Data
(def dublin [53.3498053 -6.260309699999993])
(def paris  [48.87390323741283 2.2841262817382812])
(def radians 0.174532925)
(def degrees 9.999999988573334)
(def km 1.0)
(def mi 0.621371192)
(def nm 0.539957)

(deftest calculations
  (testing "Get the delta latitude between two points"
    (is (= -4.475902062587167 (dlat dublin paris))))
  (testing "Get the delta longitude between two points"
    (is (= 8.544435981738275 (dlon dublin paris))))
  (testing "Calculate the distance between two points"
    (is (= 0 (distance-between dublin dublin)))
    (is (= 776.1499686326972 (distance-between dublin paris)))
    (is (= 776.1499686326972 (distance-between dublin paris))))
  (testing "Calculate the linear bearing between two points"
    (is (= 117.64726514103779 (bearing-between dublin paris :linear)))
    (is (= 126.45182997277647 (bearing-between dublin paris :spherical))))
  (testing "Calculate the compass bearing between two points"
    (is (= "SE" (bearing->compass (bearing-between dublin paris :linear))))
    (is (= "SE" (bearing->compass (bearing-between dublin paris :spherical))))))
