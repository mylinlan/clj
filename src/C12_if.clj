;在条件不成立的时候执行, 如果需要执行多个表达式，那么把多个表达式包在do里面
(import '(java.util Calendar GregorianCalendar))
(import '(java.io BufferedReader))

(let [gc (GregorianCalendar.)
      day-of-week (.get gc Calendar/DAY_OF_WEEK)
      is-weekend (or (= day-of-week Calendar/SATURDAY) (= day-of-week Calendar/SUNDAY))]
  (if is-weekend
    (println "play")
    (do (println "work")
        (println "sleep"))))

;宏 if-let 把一个值bind到一个变量，然后根据这个binding的值来决定到底执行哪个表达式
(defn process-next [waiting-line]
  (if-let [name (first waiting-line)]
    (println name "is next")
    (println "no waiting")))

(println (process-next '("a" "b" "c")))
(println (process-next '()))

;condp 宏跟其他语言里面的switch/case语句差不多
(println "Enter a number") (flush)
(let [reader (BufferedReader. *in*)
      line (.readLine reader)
      value (try
              (Integer/parseInt line)
              (catch NumberFormatException _ line))]
  (println
    (condp = value
      1 "one"
      2 "tow"
      3 "three"
      (str "unexpected value, \"" value "\"")))

  (println
    (condp instance? value
      Number (* value 2)
      String (* (count value) 2))))

;cond 宏接受任意个 谓词/结果表达式 的组合
(print "Enter water temperature in Celsius: ") (flush)
(let [reader (BufferedReader. *in*)
      line (.readLine reader)
      temperature (try
                    (Float/parseFloat line)
                    (catch NumberFormatException _ line))] ; use string value if not float
  (println
    (cond
      (instance? String temperature) "invalid temperature"
      (<= temperature 0) "freezing"
      (>= temperature 100) "boiling"
      true "neither")))