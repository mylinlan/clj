(ns com.w3c.map)

(def m {:a :b :c "123"})
(println m)
(println (:a m))
(println (:b m))
(println (contains? m :b))
(println (contains? m :a))
(println (= (:a m) :b))
(println (m :a))

;lookup by value
(def hm {:foo "bar"})
(println
  (keep #(when (= (val %) "bar")
           (key %)) hm))