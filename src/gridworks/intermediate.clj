(ns gridworks.intermediate
  (require [clojure.set :refer [union]])
  (use gridworks.grid))

(defn rule-1 [grid]
  (letfn [(constraint [x]
            (and ((union yellow? triangle?) x)
                 ((union blue? cross?) (+ x 4))))]
    (or (constraint 0)
        (constraint 1)
        (constraint 3)
        (constraint 4))))

(defn rule-2 [grid]
  (letfn [(constraint [x]
            (and ((union blue? circle?) x)
                 ((union green? cross?) (+ x 4))))]
    (or (constraint 0)
        (constraint 1)
        (constraint 3)
        (constraint 4))))

(defn rule-3 [grid]
  (letfn [(constraint [x]
            (and ((union green? circle?) x)
                 ((union yellow? cross?) (+ x 4))))]
    (or (constraint 0)
        (constraint 1)
        (constraint 3)
        (constraint 4))))

(defn rule-4 [grid]
  (letfn [(constraint [x]
            (and ((union yellow? triangle?) x)
                 ((union blue? circle?) (+ x 2))))]
    (or (constraint 1)
        (constraint 2)
        (constraint 4)
        (constraint 5))))

(defn rule-5 [grid]
  (letfn [(constraint [x]
            (and ((union blue? triangle?) x)
                 ((union green? circle?) (+ x 2))))]
    (or (constraint 1)
        (constraint 2)
        (constraint 4)
        (constraint 5))))

(defn rule-6 [grid]
  (letfn [(constraint [x]
            (and ((union green? circle?) x)
                 ((union yellow? circle?) (+ x 2))))]
    (or (constraint 1)
        (constraint 2)
        (constraint 4)
        (constraint 5))))
