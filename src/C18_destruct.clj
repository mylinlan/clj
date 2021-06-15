(defn f1 [numbers]
  (let [n1 (first numbers) n3 (nth numbers 2)]
    (+ n1 n3)))

;解构
(defn f2 [[n1 _ n3]] (+ n1 n3))

(println (f1 [4 5 6 7]))
(println (f2 [4 5 6 7]))

(defn name-summary [[name1 name2 & others]]
  (println (str name1 ", " name2) " and " (count others) " others"))

(name-summary ["A" "B" "C" "D"])

;:as 代表被解构集合
(defn percentage [[n1 _ n3 :as coll]]
  (println (/ (+ n1 n3) (apply + coll))))

(percentage [4 5 6 7])

