(ns chch.util.flash
    (:refer-clojure :exclude [get])
    (:require [chch.middleware.session :as session-manager]))

(defn put!
  "Put key/value in flash."
  [key value]
  (session-manager/flash-put! key value))

(defn get
  "Retrieve a flash value."
  [key]
  (session-manager/flash-get key))
