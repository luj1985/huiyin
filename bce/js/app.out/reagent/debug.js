// Compiled by ClojureScript 1.8.51 {:static-fns true, :optimize-constants true}
goog.provide('reagent.debug');
goog.require('cljs.core');
reagent.debug.has_console = typeof console !== 'undefined';
reagent.debug.tracking = false;
if(typeof reagent.debug.warnings !== 'undefined'){
} else {
reagent.debug.warnings = (cljs.core.atom.cljs$core$IFn$_invoke$arity$1 ? cljs.core.atom.cljs$core$IFn$_invoke$arity$1(null) : cljs.core.atom.call(null,null));
}
if(typeof reagent.debug.track_console !== 'undefined'){
} else {
reagent.debug.track_console = (function (){var o = {};
o.warn = ((function (o){
return (function() { 
var G__13405__delegate = function (args){
return cljs.core.swap_BANG_.cljs$core$IFn$_invoke$arity$variadic(reagent.debug.warnings,cljs.core.update_in,new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$warn], null),cljs.core.conj,cljs.core.array_seq([cljs.core.apply.cljs$core$IFn$_invoke$arity$2(cljs.core.str,args)], 0));
};
var G__13405 = function (var_args){
var args = null;
if (arguments.length > 0) {
var G__13406__i = 0, G__13406__a = new Array(arguments.length -  0);
while (G__13406__i < G__13406__a.length) {G__13406__a[G__13406__i] = arguments[G__13406__i + 0]; ++G__13406__i;}
  args = new cljs.core.IndexedSeq(G__13406__a,0);
} 
return G__13405__delegate.call(this,args);};
G__13405.cljs$lang$maxFixedArity = 0;
G__13405.cljs$lang$applyTo = (function (arglist__13407){
var args = cljs.core.seq(arglist__13407);
return G__13405__delegate(args);
});
G__13405.cljs$core$IFn$_invoke$arity$variadic = G__13405__delegate;
return G__13405;
})()
;})(o))
;

o.error = ((function (o){
return (function() { 
var G__13408__delegate = function (args){
return cljs.core.swap_BANG_.cljs$core$IFn$_invoke$arity$variadic(reagent.debug.warnings,cljs.core.update_in,new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$error], null),cljs.core.conj,cljs.core.array_seq([cljs.core.apply.cljs$core$IFn$_invoke$arity$2(cljs.core.str,args)], 0));
};
var G__13408 = function (var_args){
var args = null;
if (arguments.length > 0) {
var G__13409__i = 0, G__13409__a = new Array(arguments.length -  0);
while (G__13409__i < G__13409__a.length) {G__13409__a[G__13409__i] = arguments[G__13409__i + 0]; ++G__13409__i;}
  args = new cljs.core.IndexedSeq(G__13409__a,0);
} 
return G__13408__delegate.call(this,args);};
G__13408.cljs$lang$maxFixedArity = 0;
G__13408.cljs$lang$applyTo = (function (arglist__13410){
var args = cljs.core.seq(arglist__13410);
return G__13408__delegate(args);
});
G__13408.cljs$core$IFn$_invoke$arity$variadic = G__13408__delegate;
return G__13408;
})()
;})(o))
;

return o;
})();
}
reagent.debug.track_warnings = (function reagent$debug$track_warnings(f){
reagent.debug.tracking = true;

(cljs.core.reset_BANG_.cljs$core$IFn$_invoke$arity$2 ? cljs.core.reset_BANG_.cljs$core$IFn$_invoke$arity$2(reagent.debug.warnings,null) : cljs.core.reset_BANG_.call(null,reagent.debug.warnings,null));

(f.cljs$core$IFn$_invoke$arity$0 ? f.cljs$core$IFn$_invoke$arity$0() : f.call(null));

var warns = (cljs.core.deref.cljs$core$IFn$_invoke$arity$1 ? cljs.core.deref.cljs$core$IFn$_invoke$arity$1(reagent.debug.warnings) : cljs.core.deref.call(null,reagent.debug.warnings));
(cljs.core.reset_BANG_.cljs$core$IFn$_invoke$arity$2 ? cljs.core.reset_BANG_.cljs$core$IFn$_invoke$arity$2(reagent.debug.warnings,null) : cljs.core.reset_BANG_.call(null,reagent.debug.warnings,null));

reagent.debug.tracking = false;

return warns;
});