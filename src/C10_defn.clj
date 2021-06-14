;defn 定义函数
(defn parting
  "return a string parting"
  [name]
  (str "Goodbye, " name))

(println (parting "mark"))

;& 后面跟可选参数
(defn power [base & exponents]
  ;using java.lang.Math static method pow.
  (reduce #(Math/pow %1 %2) base exponents)
  )

(println (power 2 3 4  ))

;函数定义可包含多个参数列表和方法体, 每个方法的参数个数不能相同
(defn hello
  "hello"
  ([] (hello "word"))
  ([name] (hello name "en"))
  ([name language]
   (condp = language
     "en" (str "Goodbye, " name)
     "cn" (str "你好, " name)
     (throw (IllegalArgumentException. (str "Unsupported language: " language))))))

(println (hello))
(println (hello "ljx"))
(println (hello "ljx" "cn"))

;通过 fn 定义的匿名函数可以包含任意个数的表达式； 而通过 #(...) , 定义的匿名函数则只能包含一个表达式，
; 如果你想包含多个表达式，那么把它用 do 包起来
(def years [1940 1944 1961 1985 1987])
(println (filter (fn [year] (even? year)) years))
(println (filter #(even? %) years))


(defn pair-test [test-fn n1 n2]
  (if (test-fn n1 n2) "pass" "fail"))

(println (pair-test #(even? (+ %1 %2)) 3 5))

;Clojure里面的multimethod技术可以实现任意 类型的重载
;宏 defmulti 和 defmethod 经常被用在一起来定义 multimethod
(defmulti wai class)
(defmethod wai Number [arg] (println arg " is a number"))
(defmethod wai String [arg] (println arg " is a string"))
(defmethod wai :default [arg] (println arg " is a something else"))

(println (wai 19))
(println (wai "hello"))
(println (wai true))

;complement 函数接受一个函数作为参数，
; 如果这个参数返回值是true， 那么它就返回false, 相当于一个取反的操作
(defn teenager? [age] (and (>= age 13) (< age 20)))
(def non-teenager? (complement teenager?))
(println (non-teenager? 47))

;comp 把任意多个函数组合成一个，前面一个函数的返回值作为后面一个函数的参数。
; 调用的顺序是从右到左（注意不是从左到右）
(defn times2 [n] (* n 2))
(defn minus3 [n] (- n 3))
(def my-comp (comp minus3 times2))
(println (my-comp 4))

;partial 函数创建一个新的函数 — 通过给旧的函数制定一个初始值， 然后再调用原来的函数
;即所谓的 偏函数
(def pTimes2 (partial * 2))
(println (pTimes2 3 4))

;使用map和partial的例子
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

(println "f(2) = " (f 2))
(println "f'(2) = " (f-prime 2))

;memoize 缓存 (其实也只有函数式编程里面能用这个技术， 因为函数没有side-effect, 多次调用的结果保证是一样的)
(def memo-f (memoize f))
(println "priming call")
(time (f 2))

(println "without memorization")
(dotimes [_ 3] (time (f 2)))

(println "with memorization")
(dotimes [_ 3] (time (memo-f 2)))