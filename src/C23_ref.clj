;vars
(def v 1)

(defn change-it []
  (println "2) v=" v)

  (def v 2)
  (println "3) v=" v)

  (binding [v 3]
    (println "4) v=" v)
    (set! v 4)
    (println "5) v=" v)
    )

  (println "6) v=" v)
  )

(println "1) v=" v)

(let [thread (Thread. #(change-it))]
  (.start thread)
  (.join thread))

(println "7) v=" v)

