(require 'clojure.string)
(alias 'su 'clojure.string)
(refer 'clojure.string)
(use 'clojure.string)

(println (clojure.string/join "$" [1 2 3]))
(println (su/join "$" [1 2 3]))
(println (join "$" [1 2 3]))