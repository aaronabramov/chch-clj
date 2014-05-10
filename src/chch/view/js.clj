(ns chch.view.js
  (:require [clojure.java.io :as io]
            [compojure.core :refer [defroutes GET]]
            [org.httpkit.client :as http]
            [chch.view.common :refer [wrap-layout]]))

(defn- page-body [request]
  (slurp (io/resource "chch/view/templates/about.html")))

(defn- render-page [request]
  (wrap-layout "About"
               (page-body request)))

(defn proxy-request [path]
  (:body @(http/get (str "http://localhost:6969/" path) {:as :text})))

(defroutes js-routes
  (GET "/js/:path" [path]
       {:status 200
        :headers {"Content-Type" "application/javascript"}
        :body (proxy-request path)}))
