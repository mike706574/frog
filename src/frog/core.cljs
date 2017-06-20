(ns frog.core
  (:require [ajax.core :as ajax]
            [clojure.string :as str]
            [day8.re-frame.http-fx]
            [reagent.core :as reagent]
            [re-frame.core :as rf]))

;; -- Development --------------------------------------------------------------
(enable-console-print!)

;; -- Event Dispatch -----------------------------------------------------------


;; -- Event Handlers -----------------------------------------------------------

(rf/reg-event-fx
 :initialize
 (fn [_ _]
   {:db {:frog "bob"}}))


;; -- Query  -------------------------------------------------------------------

(rf/reg-sub
 :frog
 (fn [db _]
   (:frog db)))

;; -- View Functions -----------------------------------------------------------

(defn app
  []
  [:div
   [:p "Hello, " @(rf/subscribe [:frog]) "!"]])

;; -- Entry Point -------------------------------------------------------------

(defn ^:export run
  []
  (rf/dispatch-sync [:initialize])
  (reagent/render [app] (js/document.getElementById "app")))
