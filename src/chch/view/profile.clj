(ns chch.view.profile
  (:require [compojure.core :refer [defroutes GET]]
            [stencil.core :as stencil]
            [chch.view.common :refer [restricted authenticated? wrap-layout]]))

(defn- page-body []
  (stencil/render-file
   "chch/view/templates/profile"
   {}))

(defn- render-page [request]
  (wrap-layout "Profile"
               (page-body)))

(defroutes profile-routes
  (GET "/profile" request (restricted authenticated? render-page request)))
