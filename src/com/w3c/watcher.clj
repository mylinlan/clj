(def x (atom 0))

(add-watch x :watcher (fn [key atom old-state new-state]
                        (println "old " old-state)
                        (println "new " new-state)))

(reset! x 2)