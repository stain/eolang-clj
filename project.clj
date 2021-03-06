(defproject eolang "0.0.1-SNAPSHOT"
  :description "Experimental eolang parser for Clojure"
  :url "https://github.com/stain/eolang-clj"
  :license {:name "The MIT License"
            :url "https://opensource.org/licenses/MIT"}
  :dependencies [
    [org.clojure/clojure "1.8.0"]
    [instaparse "1.4.10"]
  ]
  :main ^:skip-aot eolang.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
