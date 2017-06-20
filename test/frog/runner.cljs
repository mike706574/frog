(ns frog.runner
    (:require [doo.runner :refer-macros [doo-tests]]
              [frog.core-test]))

(doo-tests 'frog.core-test)
