(ns lyzeromq.core-test
  (:require [clojure.test :refer :all]
            [lyzeromq.core :refer :all]
            [zeromq.zmq :as zmq]
            [zeromq.sendable :as s]))

(defonce context (zmq/context 1))

(deftest push-pull-test
  (with-open [socket (doto (zmq/socket context :req)
                     (zmq/connect "tcp://127.0.0.1:5555"))]
    (zmq/send-str socket "hello")
    (println (zmq/receive-str socket))))
