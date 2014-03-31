;;; positive
(ns gridworks.expert
  (:use gridworks.grid))

(defn rule-1 [grid]
  (or (circle? (grid 0))
      (circle? (grid 1))))

(defn rule-2 [grid]
  (letfn [(constraint [x]
            (and (green?    (grid x))
                 (triangle? (grid (+ 5 x)))))]
    (or (constraint 0)
        (constraint 3))))

(defn rule-3 [grid]
  (letfn [(constraint [x]
            (and (green? (grid x))
                 (green? (grid (+ x 6)))))]
    (or (constraint 0)
        (constraint 1)
        (constraint 2))))

(defn rule-4 [grid]
  (letfn [(constraint [x] (and (cross? x) (yellow? x)))]
    (or (constraint 2)
        (constraint 5)
        (constraint 8))))

;;; negative

(defn rule-5 [grid]
  (letfn [(constraint [x]
            (not (and (circle? (grid x))
                      (cross?  (grid (+ x 3))))))]
    (or (constraint 0)
        (constraint 1)
        (constraint 2)
        (constraint 3)
        (constraint 4)
        (constraint 5))))

(defn rule-6 [grid]
  (not (or (triangle? (grid 0))
           (triangle? (grid 1))
           (triangle? (grid 2))
           (triangle? (grid 5))
           (triangle? (grid 8)))))

(defn rule-7 [grid]
  (letfn [(constraint [x]
            (not (and (triangle? (grid x))
                      (triangle? (grid (+ x 3)))
                      (circle?   (grid (+ x 1))))))]
    (or (constraint 0)
        (constraint 1)
        (constraint 3)
        (constraint 4))))

(defn rule-8 [grid]
  (letfn [(constraint [x]
            (not (and (triangle? (grid x))
                      (yellow?   (grid (+ x 1))))))]
    (or (constraint 0)
        (constraint 1)
        (constraint 3)
        (constraint 4)
        (constraint 6)
        (constraint 7))))

(defn rule-9 [grid]
  (letfn [(constraint [x]
            (not (and (blue?   (grid x))
                      (yellow? (grid (+ x 3))))))]
    (or (constraint 0)
        (constraint 3)
        (constraint 6))))
