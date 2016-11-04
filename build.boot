(set-env!
 :source-paths #{"src/cljs" "src/clj"}
 :resource-paths #{"resources"}
 :dependencies '[[org.clojure/clojurescript "1.7.228"]
                 [reagent "0.5.0"]
                 [secretary "1.2.3"]
                 [weasel "0.7.0"]
                 [adzerk/boot-cljs "1.7.228-1"]
                 [adzerk/boot-cljs-repl "0.3.0"]
                 [adzerk/boot-reload "0.4.8"]
                 [pandeiro/boot-http "0.7.2"]
                 [com.cemerick/piggieback "0.2.1"]
                 [org.clojure/tools.nrepl "0.2.12"]
                 [org.martinklepsch/boot-garden "1.2.5-3"]
                 [danielsz/boot-autoprefixer "0.0.8"]])

(require
 '[adzerk.boot-cljs :refer [cljs]]
 '[adzerk.boot-cljs-repl :refer [cljs-repl start-repl]]
 '[adzerk.boot-reload :refer [reload]]
 '[pandeiro.boot-http :refer [serve]]
 '[org.martinklepsch.boot-garden :refer [garden]]
 '[danielsz.autoprefixer :refer [autoprefixer]])

(task-options! speak {:theme "woodblock"}
               garden {:styles-var 'huiyin.styles/screen
                       :pretty-print true
                       :output-to "css/style.css"}
               autoprefixer {:files ["style.css"]
                             :browsers "last 2 versions"})

(deftask production []
  (task-options! cljs {:optimizations :advanced}
                 garden {:pretty-print false})
  identity)

(deftask cider []
  (require 'boot.repl)
  (swap! boot.repl/*default-dependencies* conj
         '[org.clojure/tools.nrepl "0.2.12"]
         '[refactor-nrepl "2.3.0-SNAPSHOT"]
         '[cider/cider-nrepl "0.14.0-SNAPSHOT"])

  (swap! boot.repl/*default-middleware* conj
         'refactor-nrepl.middleware/wrap-refactor
         'cider.nrepl/cider-middleware)
  identity)

(deftask development []
  (task-options! cljs {:optimizations :none :source-map true}
                 reload {:on-jsload 'huiyin.app/init})
  (cider))

(deftask build []
  (comp (speak)
     (cljs)
     (garden)
     (autoprefixer)))

(deftask run []
  (comp (serve)
     (watch)
     (cljs-repl)
     (reload)
     (build)))

(deftask dist []
  (comp (production)
     (build)
     (target)))

(deftask dev []
  (comp (development)
     (run)))
