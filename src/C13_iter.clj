;宏 dotimes 会执行给定的表达式一定次数
(dotimes [card-number 3]
  (println "deal card number" card-number))

;宏 while 会一直执行一个表达式只要指定的条件为true
(defn my-fn [ms]
  (println "enter my-fn")
  (Thread/sleep ms)
  (println "leaving my-fn"))

(let [thread (Thread. #(my-fn 1))]
  (.start thread)
  (println "started thread")
  (while (.isAlive thread)
    (print ".")
    (flush))
  (println "thread stopped"))

;列表推导式
(def cols "ABCD")
(def rows (range 1 4))

(println "for demo")
(dorun
  (for [col cols :when (not= col \B)
        row rows :while (< row 3)]
    (println (str col row))))

(println "\n doseq demo")
(doseq [col cols :when (not= col \B)
        row rows :while (< row 3)]
  (println (str col row)))
