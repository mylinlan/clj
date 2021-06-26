(def counter (agent 0))

(println @counter)

(send counter + 100)

(println @counter)

(shutdown-agents)

