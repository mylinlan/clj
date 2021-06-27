(ns com.w3c.struct)

(defstruct Employee :id :name)
(println Employee)

(def emp (struct Employee 1 "ljx"))
(println emp)
(println (:name emp))

;struct-map 此函数用于通过明确定义哪些值分配给结构中的哪些键来为键值指定值。
(def emp-map (struct-map Employee :id 2 :name "lank"))
(println emp-map)

;Immutable
(assoc emp :name "ljx2")
(println emp)
(def emp2 (assoc emp :name "ljx2"))
(println emp2)