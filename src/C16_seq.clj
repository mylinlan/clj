;脚本内LazySeq 不执行
(map #(println %) [1 2 3])

;doseq 和 dorun 执行LazySeq
(dorun (map #(println %) [1 2 4]))
(doseq [i [1 2 3]] (println i))

;LazySeq使得创建无限序列成为可能
(defn f
  [x]
  (println "calculating f of " x)
  (/ (* x x) 2))

(def f-seq (map f (iterate inc 0)))

(println "first is" (first f-seq))

;force evaluation of the first three times in infinite sequence
(doall (take 3 f-seq))

;use cached result
(println (nth f-seq 2))