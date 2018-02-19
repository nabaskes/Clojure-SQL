(ns cljsql.core
  (:gen-class))


(defn handle-create
  [q]
  (println "create is not yet implemented"))


(defn handle-show
  [q]
  (println "show is not yet implemented"))

(defn handle-delete
  [q]
  (println "delete is not yet implemented"))

(defn handle-alter
  [q]
  (println "alter is not yet implemented"))

(defn handle-insert
  [q]
  (println "insert is not yet implemented"))

(defn handle-update
  [q]
  (println "update is not yet implemented"))

(defn handle-select
  [q]
  (println "select is not yet implemented"))

(defn process-query
  [q]
  (cond
    (= (first (clojure.string/split
               " "
               (clojure.string/lower-case q)))
       "select")
    (handle-select q)
    (= (first (clojure.string/split
               " "
               (clojure.string/lower-case q)))
       "update")
    (handle-update q)
    (= (first (clojure.string/split
               " "
               (clojure.string/lower-case q)))
       "insert")
    (handle-insert q)
    (= (first (clojure.string/split
               " "
               (clojure.string/lower-case q)))
       "alter")
    (handle-alter q)
    (= (first (clojure.string/split
               " "
               (clojure.string/lower-case q)))
       "delete")
    (handle-delete)
    (= (first (clojure.string/split
               " "
               (clojure.string/lower-case q)))
       "show")
    (handle-show)
    (= (first (clojure.string/split
               " "
               (clojure.string/lower-case q)))
       "create")
    (handle-create)
  ))

(defn input-loop
  "Repeatedly prompt user for queries"
  [cond]
  (if cond
    ;; (println "Query your database")
    (process-query (read-line))))


(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (input-loop true))
