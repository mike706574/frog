(defproject org.clojars.mike706574/frog "0.0.1-SNAPSHOT"
  :description "A frog."
  :url "https://github.com/mike706574/frog"
  :license {:name "Eclipse Public License - v 1.0"
            :url "http://www.eclipse.org/legal/epl-v10.html"
            :distribution :repo
            :comments "same as Clojure"}
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [com.stuartsierra/component "0.3.2"]
                 [com.taoensso/timbre "4.10.0"]
                 [org.clojure/clojurescript "1.9.562"]
                 [reagent "0.6.2"]
                 [re-frame "0.9.4"]
                 [day8.re-frame/http-fx "0.1.3"]
                 [cljs-ajax "0.6.0"]]
  :plugins [[lein-cljsbuild "1.1.5"]
            [cider/cider-nrepl "0.14.0"]
            [org.clojure/tools.nrepl "0.2.12"]
            [lein-figwheel "0.5.10"]]
  :source-paths ["src/cljs"]
  :hooks [leiningen.cljsbuild]
  :profiles {:dev {:source-paths ["dev"]
                   :target-path "target/dev"
                   :dependencies [[org.clojure/tools.namespace "0.2.11"]
                                  [com.cemerick/piggieback "0.2.2"]
                                  [figwheel-sidecar "0.5.10"]]
                   :repl-options {:nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}}}
  :cljsbuild {:test {:source-paths ["src" "test"]
                     :compiler {:output-to     "target/testable.js"
                                :main          'frog.runner
                                :optimizations :simple}}
              :builds {:dev {:source-paths ["src"]
                             :figwheel {:on-jsload "frog.core/run"}
                             :compiler {:output-to "resources/public/js/client.js"
                                        :main "frog.core"
                                        :asset-path "js"
                                        :optimizations :none
                                        :source-map true
                                        :source-map-timestamp true}}}}
  :doo {:build "test"
        :paths {:slimer "./node_modules/.bin/slimerjs"}
        :alias {:default [:slimer]
                :browsers [:chrome :firefox]
                :all [:browsers :headless]}}
  :clean-targets ^{:protect false} ["resources/public/js"]})
