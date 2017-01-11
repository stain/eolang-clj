(ns eolang.parser-test
  (:require [clojure.test :refer :all]
            [eolang.parser :refer :all]))


(deftest parser-test
  (testing "terminate-blocks"
    (is (= "\n" (terminate-blocks "")))
    (is (= "0\n" (terminate-blocks "0")))
    (is (= "0\n" (terminate-blocks "0\n")))
    (is (= "0\n0\n0\n" (terminate-blocks "0\n0\n0\n")))
    (is (= "0\n 1;\n" (terminate-blocks "0\n 1")))
    (is (= "0\n 1;\n0\n" (terminate-blocks "0\n 1\n0\n")))
    (is (= "0\n 1\n 1;\n0\n" (terminate-blocks "0\n 1\n 1\n0\n")))
    (is (= "0\n 1\n 1\n;\n" (terminate-blocks "0\n 1\n 1")))
    (is (= "0\n 1\n 2;\n1\n0;\n" (terminate-blocks "0\n 1\n   2\n 1\n0")))
    (is (= "0\n 1\n 2;\n1\n;\n" (terminate-blocks "0\n 1\n   2\n 1")))
))
