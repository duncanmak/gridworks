(ns gridworks.advanced
  (use gridworks.grid))

(defn rule-1 [grid]
  (and (circle?   (grid 0))
       (cross?    (grid 2))
       (triangle? (grid 4))
       (cross?    (grid 6))
       (circle?   (grid 8))))

(defn rule-2 [grid]
  (and (yellow? (grid 1))
       (green?  (grid 3))
       (green?  (grid 5))
       (blue?   (grid 7))))

(defn rule-3 [grid]
  (letfn [(constraint [x] (and (triangle? (grid x))
                               (triangle? (grid (inc x)))))]
    (not (or (constraint 0) (constraint 1)
             (constraint 3) (constraint 4)
             (constraint 6) (constraint 7)))))

(defn rule-4 [grid]
  (letfn [(constraint [x] (and (yellow? (grid x))
                               (circle? (grid (+ x 3)))))]
    (not (or (constraint 0) (constraint 1) (constraint 2)
             (constraint 3) (constraint 4) (constraint 5)))))

(defn rule-5 [grid]
  (letfn [(constraint [x] (and (yellow? (grid x))
                               (blue?   (grid (inc x)))))]
    (not (or (constraint 0) (constraint 1)
             (constraint 3) (constraint 4)
             (constraint 6) (constraint 7)))))
