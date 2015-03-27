(ns orienteer.conversions-test
  (:require [orienteer.conversions :refer :all]
            [clojure.test :refer :all]))

;; Data
(def dublin [53.3498053 -6.260309699999993])
(def paris  [48.87390323741283 2.2841262817382812])
(def radians 0.174532925)
(def degrees 9.999999988573334)
(def km 1.0)
(def mi 0.621371192)
(def nm 0.539957)

(deftest conversions
  (testing "Convert degrees -> radians"
    (is (= radians (degs->rads degrees))))
  (testing "Convert radians -> degrees"
    (is (= degrees (rads->degs radians))))
  (testing "Convert km -> mi"
    (is (= mi (km->mi km))))
  (testing "Convert mi -> km"
    (is (= km (mi->km mi))))
  (testing "Convert km -> nm"
    (is (= nm (km->nm km))))
  (testing "Convert nm -> km"
    (is (= km (nm->km nm)))))
