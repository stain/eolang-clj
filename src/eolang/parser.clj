(ns eolang.parser
  (:require
      [clojure.string :as str]
      [instaparse.core :as insta])
)

; Consistent newline after processing
(def NEWLINE "\n")
; Block termiantor after processing
(def ENDBLOCK ";")

(defn terminate-blocks [eo-src]
    (str/join
      (loop [processed-lines [] ; finished lines in order
             lines (str/split-lines eo-src)
             line# 0
             ; previous line we indented
             last-indent# 0
             ; stack of indent strings
             indents '()]
        (if (empty? lines) ; finished
          (concat processed-lines
            ; let's just add those trailing ;
            ; for each remaining unindent
            (map #(str % ENDBLOCK NEWLINE) indents))
          (let ; process current line
            [line (first lines)
             prev-indent (or (peek indents) "")
             curr-indent (or (re-find #"\s+" line) "")]
             (cond
               (= prev-indent curr-indent)
                ; same indentation, do next line
                  (recur (conj processed-lines (str NEWLINE line))
                         (rest lines)
                         (inc line#)
                         last-indent#
                         indents)
               (str/starts-with? curr-indent prev-indent)
                ; increased indentation level
                  (recur (conj processed-lines (str NEWLINE line))
                         (rest lines)
                         (inc line#)
                         ; Current line is now last indentation increase
                         line#
                         (conj indents curr-indent)) ; new level added to stack
               :else
                ; decreased indentation level (or indentation error)
                ; ..so we'll insert just ENDBLOCK and let the line
                ; be handled inside recursion
                ; (it might need multiple unindents)
                (recur (conj processed-lines
                          ; For debugging we'll re-use the last indentation
                          (str (peek indents) ENDBLOCK))
                       ; no change of lines
                       lines
                       line#
                       last-indent#
                       (try (pop indents)
                       (catch IllegalStateException e
                          ; might fail if going below indent 0, e.g.
                          ; because of earlier mixed indentation
                          (throw (Exception.
                            ; Generate poor man's parser error..
                            (str "Indentation error at line "
                              (inc line#) ; Offset by 1 for humans..
                              ":\n" line
                              (if (< 0 last-indent# line#) (str
                                "\nLast indentation (line :"
                                (inc last-indent#)
                                "):\n"
                                ; We're very kind and even show them that line
                                (nth processed-lines last-indent#)))))))))))))))

(def grammar
 (insta/parser (clojure.java.io/resource "eolang/grammar.bnf")))

(defn parse [eo-src]
 (grammar (terminate-blocks eo-src)))
