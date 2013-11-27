(ns doll.smuggler-test
  (:require [clojure.test :refer :all]
            [doll.smuggler :refer :all]))

(deftest to-int-test
  (testing "Should return integer"
    (is (= (to-int "52") 52))))

(deftest change-test
	(testing "should return vector of string and 2 ints"
		(is (= (change "luke 9 50") ["luke" 9 50]))))

(deftest make-doll-test
	(testing "should return map containing key value pairs for doll"
		(is (= (make-doll "luke 9 50") {:name "luke", :weight 9, :value 50}))))

; (deftest pack-map-test
; 	(testing "should make map containing sally"
; 		(-main)
; 		(is (contains? (pack-map by-greed) "sally"))))
