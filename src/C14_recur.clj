(defn f1 [number]
 (loop [n number factorial 1]
  (if (zero? n)
   factorial
   (recur (dec n) (* factorial n)))))

(println (time (f1 5)))

(defn f2 [number] (reduce * (range 2 (inc number))))

(println (time (f2 5)))