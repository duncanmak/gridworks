(ns gridworks.grid
  (:require [clojure.math.combinatorics :refer [permutations]]))

(def grids (permutations (range 0 9)))

(def triangle? #{0 1 2})
(def cross?    #{3 4 5})
(def circle?   #{6 7 8})

(def yellow?   #{0 3 6})
(def green?    #{1 4 7})
(def blue?     #{2 5 8})


