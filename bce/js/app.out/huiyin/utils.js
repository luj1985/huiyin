// Compiled by ClojureScript 1.8.51 {:static-fns true, :optimize-constants true}
goog.provide('huiyin.utils');
goog.require('cljs.core');
goog.require('goog.dom');
huiyin.utils.scroll_to_element = (function huiyin$utils$scroll_to_element(var_args){
var args__7617__auto__ = [];
var len__7610__auto___13216 = arguments.length;
var i__7611__auto___13217 = (0);
while(true){
if((i__7611__auto___13217 < len__7610__auto___13216)){
args__7617__auto__.push((arguments[i__7611__auto___13217]));

var G__13218 = (i__7611__auto___13217 + (1));
i__7611__auto___13217 = G__13218;
continue;
} else {
}
break;
}

var argseq__7618__auto__ = ((((1) < args__7617__auto__.length))?(new cljs.core.IndexedSeq(args__7617__auto__.slice((1)),(0),null)):null);
return huiyin.utils.scroll_to_element.cljs$core$IFn$_invoke$arity$variadic((arguments[(0)]),argseq__7618__auto__);
});

huiyin.utils.scroll_to_element.cljs$core$IFn$_invoke$arity$variadic = (function (selector,p__13214){
var vec__13215 = p__13214;
var offset = cljs.core.nth.cljs$core$IFn$_invoke$arity$3(vec__13215,(0),null);
window.setTimeout(((function (vec__13215,offset){
return (function (){
var offset__$1 = (function (){var or__6540__auto__ = offset;
if(cljs.core.truth_(or__6540__auto__)){
return or__6540__auto__;
} else {
return (0);
}
})();
var el = document.querySelector(selector);
var el_rect = el.getBoundingClientRect();
var scroll_y = goog.dom.getDocumentScroll().y;
var will_scroll_to = (scroll_y + el_rect.top);
return window.scrollTo((0),(will_scroll_to + offset__$1));
});})(vec__13215,offset))
);

return (100);
});

huiyin.utils.scroll_to_element.cljs$lang$maxFixedArity = (1);

huiyin.utils.scroll_to_element.cljs$lang$applyTo = (function (seq13212){
var G__13213 = cljs.core.first(seq13212);
var seq13212__$1 = cljs.core.next(seq13212);
return huiyin.utils.scroll_to_element.cljs$core$IFn$_invoke$arity$variadic(G__13213,seq13212__$1);
});
