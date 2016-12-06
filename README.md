# eolang

This is an **experimental** attempt to map the
experimental [EO](https://github.com/yegor256/eo) programming
language to [Clojure](http://clojure.org/), using LISP forms
as a kind of abstract syntax tree.  

This is **not** meant as a compiler of EO.

Note: This code **could change at any point** - or (perhaps more likely)
not at all.

## Building and running

You need [Leiningen](http://leiningen.org/) and Java/OpenJDK 8 or later.

While developing you can run directly using:

    lein run

To build an executable JAR:

    lein uberjar
    java -jar target/uberjar/eolang-0.0.1-SNAPSHOT-standalone.jar


## License

Copyright © 2016 Stian Soiland-Reyes [orcid.org/0000-0001-9842-9718](http://orcid.org/0000-0001-9842-9718/)
Copyright © 2016 [University of Manchester](http://www.esciencelab.org.uk/)

Distributed under the [MIT license](https://opensource.org/licenses/MIT)
See the file [LICENSE](LICENSE) for details.

The `test/` folder includes examples adapted from https://github.com/yegor256/eo
which are © 2016 Yegor Bugayenko and
[contributors](https://github.com/yegor256/eo/graphs/contributors).
`TODO`: [Clarify open source license of the eo spec](https://github.com/yegor256/eo/issues/64).

Dependencies include [Clojure](http://clojure.org/) and
[instaparse](https://github.com/engelberg/instaparse) which are distributed
under the [Eclipse Public License](www.eclipse.org/legal/epl-v10.html).
