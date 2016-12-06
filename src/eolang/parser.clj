(ns eolang.parser
  (:require
      [instaparse.core :as insta])
)

(def as-and-bs
  (insta/parser
    "S = AB*
     AB = A B
     A = 'a'+
     B = 'b'+"))

(def grammar
 (insta/parser (clojure.java.io/resource "eolang/grammar.bnf")))

(println grammar)


(println
  (as-and-bs "aaaaabbbaaaabb")
)
