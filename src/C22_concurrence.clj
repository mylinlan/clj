(defn- polynomial
  "多项式"
  [cf x]
  (let [exponents (reverse (range (count cf)))]
    (apply + (map #(* %1 (Math/pow x %2)) cf exponents))))

(defn- derivative
  "多项式求导"
  [cf x]
  (let [exponents (reverse (range (count cf)))
        derivative-cf (map #(* %1 %2) (butlast cf) exponents)]
    (polynomial derivative-cf x)))

(def f (partial polynomial [2 1 3]))
(def f-prime (partial derivative [2 1 3]))

(println "creating future")
(def my-future (future (f-prime 2))) ; f-prime is called in another thread
(println "created future")
(println "result is" @my-future)
(shutdown-agents)