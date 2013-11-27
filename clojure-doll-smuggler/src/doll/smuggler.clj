(ns doll.smuggler
  (:gen-class))

(require '[clojure.java.io :as io])
(require '[clojure.string :as str])
(defn to-int [s] (Integer/parseInt s))

;; change and make-doll help parce
;; parts of the input file to make a map
(defn change [s]
	(let [v (str/split s #" ")]
		  v [(v 0) (to-int (v 1)) (to-int (v 2))]))
(defn make-doll [s]
	(reduce conj (map hash-map [:name :weight :value] (change s))))

;; pack-map selects the dolls that fit the
;; available weight and tracks the total weight
(def max-weight 400)
(def cur-weight 0)
(defn pack-map [coll]
	(when-let [s (seq coll)]
		(def cur-weight (+ (:weight (first s)) cur-weight))
		(cons (:name (first s))
			(pack-map (filter #(<= (:weight %) (- max-weight cur-weight)) (rest s))))))


(defn -main [& args]
;; work around dangerous default behaviour in Clojure
	(alter-var-root #'*read-eval* (constantly false))

;; get input file
	(def in-str (slurp (io/resource "inputfile.txt")))

 	(def head-body (str/split in-str #"available dolls:\r\n\r\n"))
	(def header (first head-body))
;; max-weight is the ammount that can be carried
	(def max-weight (to-int (str/trim 
		(second (str/split header #"max weight: ")))))

	(def body (str/split-lines (fnext head-body)))
	(def avail-dolls-str (next body))

;; parce doll info, sort by weight and decrease sort by greed (value/weight)
	(def avail-dolls (map make-doll avail-dolls-str))
	(def by-weight (sort-by :weight avail-dolls))
	(def by-greed (sort-by #(/ (:value %) (:weight %)) > avail-dolls))

;; use by-greed sort for selecting dolls
	(def cur-weight 0)
	(def packed-dolls (pack-map by-greed))

;; write output file
	(spit "outputfile.txt" "packed dolls:\r\n\r\n")
	(spit "outputfile.txt" "    name\tweight\t\tvalue\r\n" :append true)
;; for every doll packed look up in original collection
;; and format the values, append to file
	(doseq [doll packed-dolls]
  		(let [v (some #(if (-> % :name (= doll)) %) avail-dolls)]
  			(spit "outputfile.txt" (format "%8s\t%6d\t\t%5d\r\n" doll (v :weight) (v :value)) :append true)))
)