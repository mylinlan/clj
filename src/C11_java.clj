(import
  '(java.util Calendar GregorianCalendar))

;访问类常量
(. Calendar APRIL)
(println (Calendar/APRIL))

;调用java方法
(println (. Math pow 2 4))
(println (Math/pow 2 4))

;创建java对象
(def calendar (new GregorianCalendar 2008 Calendar/APRIL 16)) ; April 16, 2008
(def c2 (GregorianCalendar. 2008 Calendar/APRIL 16))

(println calendar)

;调用对象方法
(println (. calendar get Calendar/MONTH) )
(.add calendar Calendar/MONTH 2)
(println (.get calendar Calendar/MONTH) )

;串联调动
(println (.. calendar getTimeZone getDisplayName))

;所有的Clojure方法都实现了 java.lang.Runnable 和 java.util.concurrent.Callable
(defn delayed-print [ms text]
  (Thread/sleep ms)
  (println text))

(.start (Thread. #(delayed-print 1000 ", world!")))
(print "Hello")

;异常处理




