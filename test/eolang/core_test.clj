(ns eolang.core-test
  (:require [clojure.test :refer :all]
            [eolang.core :refer :all]))


; Below are some EO examples transformed to LISP structures.
;
; Note that newlines and indentation in LISP are
; considered whitespace, so we need sometimes
; use () to group nested structures, however this
; structure tries to stay close to the EO syntax
; rather than be a typical Clojure structure.
;
; We can't use ":" as in EO,
;
; The next step would then be to group structures logically,
; e.g the flattened
; (type Car extends Vehicle Money cost () Car moveTo (Coordinates coords))
; becomes more Clojuer-like
; (type 'Car (:extends [Vehicle]
;     { :cost [Money]
;        :picture [Bytes]
;        :moveTo [Car [:coords Coordinate]]
;    }
; ))


; Adapted from
; https://github.com/yegor256/eo#quick-start
(def helloworld
  '(
    import org.eolang.cli
    import org.eolang.printed
    import org.eolang.string
    cli (
      printed (
        string (
          "Hello, world!"
        )
      )
    )
  )
)


; Adapted from
; https://github.com/yegor256/eo#types
(def types
  '(
      (type Book
        (String asText ())
      )
      (type Car
          Money cost ()
          Bytes picture ()
          Car moveTo (Coordinates coords)
      )
      (type Pixel extends Point
        Pixel moveTo (Int x, Int y)
        Bytes drawTo (Canvas canvas)
      )
    )
)

; Adapted from
; https://github.com/yegor256/eo#objects
(def objects
  '(
    (object alphabet("978-1-51916-691-3", "The Alphabet") as Book (
            String @isbn
            String @title
            (ctor (String i, String t)
              (@isbn = 1)
              (@title = t)
            )
            (String asText
              (sprintf
                "ISBN is %s, title is '%s'",
                @isbn,
                @title
                )
            )
        )
    )
    (ot "978-0-73561-965-4", "Object Thinking")
    (ot
      "978-0-73561-965-4",
      "Object Thinking")
  )
)


; Object Copyright

(deftest a-test
  (testing "FIXME, I fail."
    (println helloworld)
    (is (= 0 1))))
