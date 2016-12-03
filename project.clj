(defproject eolang "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "https://github.com/stain/eolang-clj"
  :license {:name "The MIT License"
            :url "https://opensource.org/licenses/MIT"}
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :main ^:skip-aot eolang.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
