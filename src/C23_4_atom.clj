(def my-atom (atom 1))
(reset! my-atom 2)
(println @my-atom)

(defn update-atom []
  (let [cur-val @my-atom]
    (println "当前值" cur-val)
    (Thread/sleep 50)
    (println
      (compare-and-set! my-atom cur-val (inc cur-val)))))

(let [thread (Thread. #(update-atom))]
  (.start thread)
  (Thread/sleep 25)
  (reset! my-atom 3)
  (.join thread))

(println @my-atom)