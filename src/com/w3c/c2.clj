(ns com.w3c.c2
  (:gen-class))

(defn hello [username]
  (println (format "hello, %s" username)))

(hello "word")