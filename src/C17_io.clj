(import [java.io FileWriter])

(binding [*out* (FileWriter. "my.log")]
  (println "This goes to the file my.log.")
  (flush))

(let [obj1 "foo"
      obj2 {:letter \a :number (Math/PI)}]
  (println "Output from print")
  (println obj1 obj2)

  (println "Output from println:")
  (println obj1 obj2)

  (println "Output from pr")
  (pr obj1 obj2)


  (println "Output from prn")
  (prn obj1 obj2)
  )