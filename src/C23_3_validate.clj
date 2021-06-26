(def my-ref (ref 0))
(try
  (dosync
    (ref-set my-ref 1)
    (ref-set my-ref "foo"))
  (catch IllegalStateException e
    (println (.toString e))))

(println "my-ref" @my-ref)