(defproject eolang "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "https://github.com/stain/eolang-clj"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :main ^:skip-aot eolang.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
