(defproject doll-smuggler "0.1.0-SNAPSHOT"
  :description "doll-smuggler: choose the right combination of dolls packed with drugs that won't exceed the weight restriction of the lady who will carry them."
  :url "http://www.kenward.org/doll-smuggler"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
  				[org.apache.lucene/lucene-core "4.3.1"]
  				[clj-http "0.7.3"]]
  :test-selectors {:default (complement :integration)
  					:integration :integration
  					:all (fn [_] true)}
  :main doll.smuggler
  :aot [doll.smuggler]
  :resource-paths ["resources"] ; Non-code files included in classpath/jar.
)
