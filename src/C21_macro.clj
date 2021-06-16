(println ((meta (var and)) :macro)) ; long way -> true

;下面语句报错
;(println (^#'and :macro)) ; short way -> true

(defmacro around-zero [number negative-expr zero-expr positive-expr]
  `(let [number# ~number] ; so number is only evaluated once
     (cond
       (< (Math/abs number#) 1e-15) ~zero-expr
       (pos? number#) ~positive-expr
       true ~negative-expr)))

(around-zero 0.1 (println "-") (println "0") (println "+"))
(println (around-zero 0.1 "-" "0" "+")) ; same thing