(set-env!
 :source-paths #{"src"}
 :resource-paths #{"resources"}
 :dependencies '[[org.clojure/clojurescript "1.8.51"]
                 [reagent "0.6.0"]
                 [secretary "1.2.3"]
                 [weasel "0.7.0"]
                 [garden "1.3.2"]
                 [adzerk/boot-cljs "1.7.228-2" :scope "dev"]
                 [adzerk/boot-cljs-repl "0.3.0" :scope "dev"]
                 [adzerk/boot-reload "0.4.8" :scope "dev"]
                 [pandeiro/boot-http "0.7.2" :scope "dev"]
                 [com.cemerick/piggieback "0.2.1" :scope "dev"]
                 [org.clojure/tools.nrepl "0.2.12" :scope "dev"]
                 [org.martinklepsch/boot-garden "1.2.5-3" :scope "dev"]
                 [danielsz/boot-autoprefixer "0.0.8" :scope "dev"]])

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
  (comp (speak) (cljs) (garden) (autoprefixer)))

(deftask run []
  (comp (serve) (watch) (cljs-repl) (reload) (build)))

(deftask dist []
  (comp (production) (build) (target)))

(deftask dev []
  (comp (development) (run)))
