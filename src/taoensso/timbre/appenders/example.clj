(ns taoensso.timbre.appenders.example
  "You can copy this namespace if you'd like a starting template for
  writing your own Timbre appender. PRs for new appenders welcome!

  TODO Please document any dependency GitHub links here, e.g.:
  Requires https://github.com/clojure/java.jdbc,
           https://github.com/swaldman/c3p0"
  {:author "TODO Your Name (@your-github-username)"}
  (:require
   [taoensso.encore :as enc]
   [taoensso.timbre :as timbre]))

;; TODO If you add any special ns imports above, please remember to update
;; Timbre's `project.clj` to include the necessary dependencies under
;; the `:test` profile

;; TODO Please mark any implementation vars as ^:private

(defn example-appender ; Appender constructor
  "Docstring to explain any special opts to influence appender construction,
  etc. Returns the appender map."

  [{:as appender-opts :keys []}] ; Always take an opts map, even if unused

  (let []

    ;; We'll return a new appender (just a map),
    ;; see `timbre/example-config` for info on all available keys:

    {:enabled?     true  ; Please enable new appenders by default
     ;; :async?    true  ; Use agent for appender dispatch? Useful for slow dispatch
     ;; :min-level :info ; Optional minimum logging level

     ;; Provide any default rate limits?
     ;; :rate-limit [[5   (enc/ms :mins  1)] ;   5 calls/min
     ;;              [100 (enc/ms :hours 1)] ; 100 calls/hour
     ;;              ]

     ;; :output-fn ; A custom (fn [data]) -> final output appropriate
     ;;            ; for use by this appender (e.g. string, map, etc.).
     ;;            ;
     ;;            ; The fn may use (:output-opts data) for configurable
     ;;            ; behaviour.

     :fn ; The actual appender (fn [data]) -> possible side effects
     (fn [data]
       (let [{:keys
              [instant level output_
               ;; ... lots more stuff, see `timbre/example-config`
               ]} data

             ;; Final output, in a format appropriate for this
             ;; appender (string, map, etc.).
             output (force output_)]

         ;; This is where we produce our logging side effects using `output`.
         ;; In this case we'll just call `println`:
         (println (str output))))}))

(comment
  ;; Create an example appender with default options:
  (example-appender)

  ;; Create an example appender with default options, but override `:min-level`:
  (merge (example-appender) {:min-level :debug}))
