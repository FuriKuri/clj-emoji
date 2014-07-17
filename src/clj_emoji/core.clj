(ns clj-emoji.core)

(defmacro emoji
  "Create a new function for an existing function."
  [emoji-fn alias-fn]
  `(defn ~emoji-fn [& args#] (apply ~alias-fn args#)))
