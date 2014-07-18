(ns clj-emoji.core)

(defmacro emoji
  "Create a new function for an existing function."
  [emoji-fn alias-fn]
  `(defn ~emoji-fn [& args#] (apply ~alias-fn args#)))

(defmacro fn-or-macro?
  "Return true if x is a function or a macro."
  [x]
  (let [result (resolve (symbol x))]
    (if (nil? result)
      false
      true)))
