(ns clj-emoji.core-test
  (:require [clojure.test :refer :all]
            [clj-emoji.core :refer :all]))

(deftest emoji-fn
  (testing "Map plus-fn to own function"
    (do
      (emoji my-plus +)
      (is (= (+ 1 2) (my-plus 1 2)))))
  (testing "Map str-fn to own function"
    (do
      (emoji my-str str)
      (is (=
           (str "a" "bc" "def")
           (my-str "a" "bc" "def"))))))
