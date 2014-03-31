(ns gridworks.core
  (:require [gridworks.grid :refer [grids]])
  (:require [gridworks advanced expert]))

(defn -main [& args]
  (let [constraints (vals (ns-publics (symbol (first args))))
        success?    (apply every-pred constraints)]
    (println (first (filter success? grids)))))

