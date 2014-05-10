(ns chch.app
  (:require [clojure.core.cache :as cache]
            [compojure.core :refer [defroutes routes]]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [stencil.loader :as stencil]
            [ring.middleware.reload :refer [wrap-reload]]
            [chch.middleware.session :as session-manager]
            [chch.middleware.context :as context-manager]))

;;; Initialization
;; Add required code here (database, etc.)
(stencil/set-cache (cache/ttl-cache-factory {}))
;;(stencil/set-cache (cache/lru-cache-factory {}))

;; Assets
(require '[chch.view.js :refer [js-routes]])

;;; Load public routes
(require '[chch.view.home :refer [home-routes]])

;;; Load website routes
;; Add your routes here

;; Ring handler definition
(defroutes site-handler
  (-> (routes js-routes
              home-routes
              (route/resources "/")
              (route/not-found "<h1>Page not found.</h1>"))
      ;; (session-manager/wrap-session)
      ;; (context-manager/wrap-context-root)
      (wrap-reload)
      (handler/site)))
