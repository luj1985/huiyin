// Compiled by ClojureScript 1.8.51 {:static-fns true, :optimize-constants true}
goog.provide('reagent.dom');
goog.require('cljs.core');
goog.require('reagent.impl.util');
goog.require('reagent.interop');
goog.require('reagent.ratom');
goog.require('reagent.impl.template');
goog.require('reagent.impl.batching');
goog.require('reagent.debug');
if(typeof reagent.dom.imported !== 'undefined'){
} else {
reagent.dom.imported = null;
}
reagent.dom.module = (function reagent$dom$module(){
if(cljs.core.some_QMARK_(reagent.dom.imported)){
return reagent.dom.imported;
} else {
if(typeof ReactDOM !== 'undefined'){
return reagent.dom.imported = ReactDOM;
} else {
if(typeof require !== 'undefined'){
var or__6540__auto__ = reagent.dom.imported = require("react-dom");
if(cljs.core.truth_(or__6540__auto__)){
return or__6540__auto__;
} else {
throw (new Error("require('react-dom') failed"));
}
} else {
throw (new Error("js/ReactDOM is missing"));

}
}
}
});
if(typeof reagent.dom.roots !== 'undefined'){
} else {
reagent.dom.roots = (function (){var G__13837 = cljs.core.PersistentArrayMap.EMPTY;
return (cljs.core.atom.cljs$core$IFn$_invoke$arity$1 ? cljs.core.atom.cljs$core$IFn$_invoke$arity$1(G__13837) : cljs.core.atom.call(null,G__13837));
})();
}
reagent.dom.unmount_comp = (function reagent$dom$unmount_comp(container){
cljs.core.swap_BANG_.cljs$core$IFn$_invoke$arity$3(reagent.dom.roots,cljs.core.dissoc,container);

return (reagent.dom.module()["unmountComponentAtNode"])(container);
});
reagent.dom.render_comp = (function reagent$dom$render_comp(comp,container,callback){
var _STAR_always_update_STAR_13840 = reagent.impl.util._STAR_always_update_STAR_;
reagent.impl.util._STAR_always_update_STAR_ = true;

try{return (reagent.dom.module()["render"])((comp.cljs$core$IFn$_invoke$arity$0 ? comp.cljs$core$IFn$_invoke$arity$0() : comp.call(null)),container,((function (_STAR_always_update_STAR_13840){
return (function (){
var _STAR_always_update_STAR_13841 = reagent.impl.util._STAR_always_update_STAR_;
reagent.impl.util._STAR_always_update_STAR_ = false;

try{cljs.core.swap_BANG_.cljs$core$IFn$_invoke$arity$4(reagent.dom.roots,cljs.core.assoc,container,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [comp,container], null));

reagent.impl.batching.flush_after_render();

if(cljs.core.some_QMARK_(callback)){
return (callback.cljs$core$IFn$_invoke$arity$0 ? callback.cljs$core$IFn$_invoke$arity$0() : callback.call(null));
} else {
return null;
}
}finally {reagent.impl.util._STAR_always_update_STAR_ = _STAR_always_update_STAR_13841;
}});})(_STAR_always_update_STAR_13840))
);
}finally {reagent.impl.util._STAR_always_update_STAR_ = _STAR_always_update_STAR_13840;
}});
reagent.dom.re_render_component = (function reagent$dom$re_render_component(comp,container){
return reagent.dom.render_comp(comp,container,null);
});
/**
 * Render a Reagent component into the DOM. The first argument may be
 *   either a vector (using Reagent's Hiccup syntax), or a React element. The second argument should be a DOM node.
 * 
 *   Optionally takes a callback that is called when the component is in place.
 * 
 *   Returns the mounted component instance.
 */
reagent.dom.render = (function reagent$dom$render(var_args){
var args13842 = [];
var len__7610__auto___13845 = arguments.length;
var i__7611__auto___13846 = (0);
while(true){
if((i__7611__auto___13846 < len__7610__auto___13845)){
args13842.push((arguments[i__7611__auto___13846]));

var G__13847 = (i__7611__auto___13846 + (1));
i__7611__auto___13846 = G__13847;
continue;
} else {
}
break;
}

var G__13844 = args13842.length;
switch (G__13844) {
case 2:
return reagent.dom.render.cljs$core$IFn$_invoke$arity$2((arguments[(0)]),(arguments[(1)]));

break;
case 3:
return reagent.dom.render.cljs$core$IFn$_invoke$arity$3((arguments[(0)]),(arguments[(1)]),(arguments[(2)]));

break;
default:
throw (new Error([cljs.core.str("Invalid arity: "),cljs.core.str(args13842.length)].join('')));

}
});

reagent.dom.render.cljs$core$IFn$_invoke$arity$2 = (function (comp,container){
return reagent.dom.render.cljs$core$IFn$_invoke$arity$3(comp,container,null);
});

reagent.dom.render.cljs$core$IFn$_invoke$arity$3 = (function (comp,container,callback){
reagent.ratom.flush_BANG_();

var f = (function (){
return reagent.impl.template.as_element(((cljs.core.fn_QMARK_(comp))?(comp.cljs$core$IFn$_invoke$arity$0 ? comp.cljs$core$IFn$_invoke$arity$0() : comp.call(null)):comp));
});
return reagent.dom.render_comp(f,container,callback);
});

reagent.dom.render.cljs$lang$maxFixedArity = 3;
reagent.dom.unmount_component_at_node = (function reagent$dom$unmount_component_at_node(container){
return reagent.dom.unmount_comp(container);
});
/**
 * Returns the root DOM node of a mounted component.
 */
reagent.dom.dom_node = (function reagent$dom$dom_node(this$){
return (reagent.dom.module()["findDOMNode"])(this$);
});
/**
 * Force re-rendering of all mounted Reagent components. This is
 *   probably only useful in a development environment, when you want to
 *   update components in response to some dynamic changes to code.
 * 
 *   Note that force-update-all may not update root components. This
 *   happens if a component 'foo' is mounted with `(render [foo])` (since
 *   functions are passed by value, and not by reference, in
 *   ClojureScript). To get around this you'll have to introduce a layer
 *   of indirection, for example by using `(render [#'foo])` instead.
 */
reagent.dom.force_update_all = (function reagent$dom$force_update_all(){
reagent.ratom.flush_BANG_();

var seq__13853_13857 = cljs.core.seq(cljs.core.vals((cljs.core.deref.cljs$core$IFn$_invoke$arity$1 ? cljs.core.deref.cljs$core$IFn$_invoke$arity$1(reagent.dom.roots) : cljs.core.deref.call(null,reagent.dom.roots))));
var chunk__13854_13858 = null;
var count__13855_13859 = (0);
var i__13856_13860 = (0);
while(true){
if((i__13856_13860 < count__13855_13859)){
var v_13861 = chunk__13854_13858.cljs$core$IIndexed$_nth$arity$2(null,i__13856_13860);
cljs.core.apply.cljs$core$IFn$_invoke$arity$2(reagent.dom.re_render_component,v_13861);

var G__13862 = seq__13853_13857;
var G__13863 = chunk__13854_13858;
var G__13864 = count__13855_13859;
var G__13865 = (i__13856_13860 + (1));
seq__13853_13857 = G__13862;
chunk__13854_13858 = G__13863;
count__13855_13859 = G__13864;
i__13856_13860 = G__13865;
continue;
} else {
var temp__4657__auto___13866 = cljs.core.seq(seq__13853_13857);
if(temp__4657__auto___13866){
var seq__13853_13867__$1 = temp__4657__auto___13866;
if(cljs.core.chunked_seq_QMARK_(seq__13853_13867__$1)){
var c__7351__auto___13868 = cljs.core.chunk_first(seq__13853_13867__$1);
var G__13869 = cljs.core.chunk_rest(seq__13853_13867__$1);
var G__13870 = c__7351__auto___13868;
var G__13871 = cljs.core.count(c__7351__auto___13868);
var G__13872 = (0);
seq__13853_13857 = G__13869;
chunk__13854_13858 = G__13870;
count__13855_13859 = G__13871;
i__13856_13860 = G__13872;
continue;
} else {
var v_13873 = cljs.core.first(seq__13853_13867__$1);
cljs.core.apply.cljs$core$IFn$_invoke$arity$2(reagent.dom.re_render_component,v_13873);

var G__13874 = cljs.core.next(seq__13853_13867__$1);
var G__13875 = null;
var G__13876 = (0);
var G__13877 = (0);
seq__13853_13857 = G__13874;
chunk__13854_13858 = G__13875;
count__13855_13859 = G__13876;
i__13856_13860 = G__13877;
continue;
}
} else {
}
}
break;
}

return "Updated";
});
