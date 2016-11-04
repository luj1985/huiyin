(set-env!
 :source-paths    #{"src/cljs" "src/clj"}
 :resource-paths  #{"resources"}
 :dependencies '[[org.clojure/clojurescript     "RELEASE"]
                 [reagent                       "RELEASE"]
                 [weasel                        "RELEASE" :scope "test"]
                 [adzerk/boot-cljs              "RELEASE" :scope "test"]
                 [adzerk/boot-cljs-repl         "RELEASE" :scope "test"]
                 [adzerk/boot-reload            "RELEASE" :scope "test"]
                 [pandeiro/boot-http            "RELEASE" :scope "test"]
                 [com.cemerick/piggieback       "RELEASE" :scope "test"]
                 [org.clojure/tools.nrepl       "RELEASE" :scope "test"]
                 [org.martinklepsch/boot-garden "RELEASE" :scope "test"]
                 [danielsz/boot-autoprefixer    "RELEASE" :scope "test"]])

(require
 '[adzerk.boot-cljs      :refer [cljs]]
 '[adzerk.boot-cljs-repl :refer [cljs-repl start-repl]]
 '[adzerk.boot-reload    :refer [reload]]
 '[pandeiro.boot-http    :refer [serve]]
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
     (target :dir #{"target"})))

(deftask dev []
  (comp (development)
     (run)))
