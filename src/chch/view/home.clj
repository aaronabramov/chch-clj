(ns chch.view.home
    (:require [compojure.core :refer [defroutes GET]]
              [stencil.core :as stencil]
              [chch.view.common :refer [wrap-layout authenticated?]]))

(defn- render-index [request]
  (stencil/render-file
   "chch/view/templates/index"
   {}))

(defroutes home-routes
  (GET "/" request (render-index request)))
