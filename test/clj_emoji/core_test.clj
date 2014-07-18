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

(deftest fn-or-macro-fn
  (testing "println is a function"
    (is (fn-or-macro? println)))
  (testing "if-not is a macro"
    (is (fn-or-macro? if-not)))
  (testing "my-fn is not a funtion or a macro"
    (is (not (fn-or-macro? my-fn))))
  (testing "a string is not a funtion or a macro"
    (is (not (fn-or-macro? "hello"))))
  (testing "a number is not a funtion or a macro"
    (is (not (fn-or-macro? 42)))))
