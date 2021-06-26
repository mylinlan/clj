;while
(def x (atom 1))
(while (< @x 5)
  (do
    (println @x)
    (swap! x inc)))

;序列
(doseq [n [1 2 3]]
  (println n))

;dotimes
(dotimes [n 5]
  (println n))

;loop
(loop [x 10]
  (when (> x 1)
    (println x)
    (recur (- x 2))))