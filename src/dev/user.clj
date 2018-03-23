(ns user)
;; === SHADOW REPL ===

(comment
  ;; evaluate any one of these in your nREPL to
  ;; choose a (running and connected) shadown-CLJS nREPL
  (do
    (require '[shadow.cljs.devtools.api :as shadow])
    (shadow/nrepl-select :main))


  (do
    (require '[shadow.cljs.devtools.api :as shadow])
    (shadow/nrepl-select :test))

  (do
    (require '[shadow.cljs.devtools.api :as shadow])
    (shadow/nrepl-select :cards)))


