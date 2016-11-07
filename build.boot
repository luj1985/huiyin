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
                 [adzerk/boot-reload "0.4.13" :scope "dev"]
                 [pandeiro/boot-http "0.7.2" :scope "dev"]
                 [com.cemerick/piggieback "0.2.1" :scope "dev"]
                 [org.clojure/tools.nrepl "0.2.12" :scope "dev"]
                 [danielsz/boot-autoprefixer "0.0.8" :scope "dev"]])

(require
 '[adzerk.boot-cljs :refer [cljs]]
 '[adzerk.boot-cljs-repl :refer [cljs-repl start-repl]]
 '[adzerk.boot-reload :refer [reload]]
 '[pandeiro.boot-http :refer [serve]]
 '[danielsz.autoprefixer :refer [autoprefixer]]
 '[clojure.java.io :as io]
 '[boot.core :as boot]
 '[boot.pod :as pod]
 '[boot.util :as util])

;;; XXX: Garden styles are scattered in several cljc file, has to recompile them all
;;; below code is a variety of org.martinklepsch/boot-garden
(defn add-dep [env dep]
  (update-in env [:dependencies] (fnil conj []) dep))

(defn ns-tracker-pod []
  (pod/make-pod (assoc-in (boot/get-env) [:dependencies] '[[ns-tracker "0.2.2"]])))

(defn garden-pool []
  (pod/pod-pool (add-dep (boot/get-env) '[garden "1.3.2"])
                :init (fn [pod] (pod/require-in pod 'garden.core))))

(deftask garden
  [o output-to PATH      str   "The output css file path relative to docroot."
   s styles-var SYM      sym   "The var containing garden rules"
   p pretty-print        bool  "Pretty print compiled CSS"]

  (let [output-path (or output-to "main.css")
        css-var     styles-var
        ns-sym      (symbol (namespace css-var))
        tmp         (boot/tmp-dir!)
        out         (io/file tmp output-path)
        src-paths   (vec (boot/get-env :source-paths))
        garden-pods (garden-pool)
        ns-pod      (ns-tracker-pod)]
    (pod/with-eval-in ns-pod
      (require 'ns-tracker.core)
      (def cns (ns-tracker.core/ns-tracker ~src-paths)))
    (boot/with-pre-wrap fileset
      (let [c-pod (garden-pods :refresh)]
        (util/info "Compiling %s...\n" (.getName out))
        (io/make-parents out)
        (pod/with-eval-in c-pod
          (require '~ns-sym)
          (garden.core/css {:output-to ~(.getPath out)
                            :pretty-print ~pretty-print} ~css-var)))
      (-> fileset (boot/add-resource tmp) boot/commit!))))

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
