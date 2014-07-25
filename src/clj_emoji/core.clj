(ns clj-emoji.core)

(def mapping (atom {}))

(defn add-value [x y]
  (swap! mapping assoc x y))

(defn get-value [x]
  (if (contains? @mapping x)
    (@mapping x)
    x))

(defn map-it [x]
  (map get-value x))

(defmacro emoji
  "Create a new function for an existing function."
  [emoji-fn alias-fn]
  (try
    (if (not (nil? (resolve alias-fn)))
      (let [emoji-sym (symbol emoji-fn)]
        `(defn ~emoji-sym [& args#] (apply ~alias-fn (map-it args#))))
      (add-value alias-fn emoji-fn))
    (catch ClassCastException e (add-value alias-fn emoji-fn))))

(defmacro init
  "Maps some functions."
  []
  `(do
    (emoji "🐙" println)
    (emoji "🎅" +)
    (emoji "⌚" -)))
