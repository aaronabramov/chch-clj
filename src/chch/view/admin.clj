(ns chch.view.admin
  (:require [compojure.core :refer [defroutes GET]]
            [stencil.core :as stencil]
            [chch.view.common :refer [restricted admin? wrap-layout]]))

(defn- page-body []
  (stencil/render-file
   "chch/view/templates/admin"
   {}))

(defn- render-page [request]
  (wrap-layout "Admin"
               (page-body)))

(defroutes admin-routes
  (GET "/admin" request (restricted admin? render-page request)))
