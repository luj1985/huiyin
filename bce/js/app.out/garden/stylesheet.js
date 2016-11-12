// Compiled by ClojureScript 1.8.51 {:static-fns true, :optimize-constants true}
goog.provide('garden.stylesheet');
goog.require('cljs.core');
goog.require('garden.util');
goog.require('garden.color');
goog.require('garden.types');
/**
 * Create a rule function for the given selector. The `selector`
 *   argument must be valid selector (ie. a keyword, string, or symbol).
 *   Additional arguments may consist of extra selectors or
 *   declarations.
 * 
 *   The returned function accepts any number of arguments which represent
 *   the rule's children.
 * 
 *   Ex.
 *    (let [text-field (rule "[type="text"])]
 *     (text-field {:border ["1px" :solid "black"]}))
 *    ;; => ["[type="text"] {:boder ["1px" :solid "black"]}]
 */
garden.stylesheet.rule = (function garden$stylesheet$rule(var_args){
var args__7617__auto__ = [];
var len__7610__auto___13178 = arguments.length;
var i__7611__auto___13179 = (0);
while(true){
if((i__7611__auto___13179 < len__7610__auto___13178)){
args__7617__auto__.push((arguments[i__7611__auto___13179]));

var G__13180 = (i__7611__auto___13179 + (1));
i__7611__auto___13179 = G__13180;
continue;
} else {
}
break;
}

var argseq__7618__auto__ = ((((1) < args__7617__auto__.length))?(new cljs.core.IndexedSeq(args__7617__auto__.slice((1)),(0),null)):null);
return garden.stylesheet.rule.cljs$core$IFn$_invoke$arity$variadic((arguments[(0)]),argseq__7618__auto__);
});

garden.stylesheet.rule.cljs$core$IFn$_invoke$arity$variadic = (function (selector,more){
if(!(((selector instanceof cljs.core.Keyword)) || (typeof selector === 'string') || ((selector instanceof cljs.core.Symbol)))){
throw cljs.core.ex_info.cljs$core$IFn$_invoke$arity$2("Selector must be either a keyword, string, or symbol.",cljs.core.PersistentArrayMap.EMPTY);
} else {
return (function() { 
var G__13181__delegate = function (children){
return cljs.core.into.cljs$core$IFn$_invoke$arity$2(cljs.core.apply.cljs$core$IFn$_invoke$arity$3(cljs.core.vector,selector,more),children);
};
var G__13181 = function (var_args){
var children = null;
if (arguments.length > 0) {
var G__13182__i = 0, G__13182__a = new Array(arguments.length -  0);
while (G__13182__i < G__13182__a.length) {G__13182__a[G__13182__i] = arguments[G__13182__i + 0]; ++G__13182__i;}
  children = new cljs.core.IndexedSeq(G__13182__a,0);
} 
return G__13181__delegate.call(this,children);};
G__13181.cljs$lang$maxFixedArity = 0;
G__13181.cljs$lang$applyTo = (function (arglist__13183){
var children = cljs.core.seq(arglist__13183);
return G__13181__delegate(children);
});
G__13181.cljs$core$IFn$_invoke$arity$variadic = G__13181__delegate;
return G__13181;
})()
;
}
});

garden.stylesheet.rule.cljs$lang$maxFixedArity = (1);

garden.stylesheet.rule.cljs$lang$applyTo = (function (seq13176){
var G__13177 = cljs.core.first(seq13176);
var seq13176__$1 = cljs.core.next(seq13176);
return garden.stylesheet.rule.cljs$core$IFn$_invoke$arity$variadic(G__13177,seq13176__$1);
});
garden.stylesheet.cssfn = (function garden$stylesheet$cssfn(fn_name){
return (function() { 
var G__13184__delegate = function (args){
return (new garden.types.CSSFunction(fn_name,args,null,null,null));
};
var G__13184 = function (var_args){
var args = null;
if (arguments.length > 0) {
var G__13185__i = 0, G__13185__a = new Array(arguments.length -  0);
while (G__13185__i < G__13185__a.length) {G__13185__a[G__13185__i] = arguments[G__13185__i + 0]; ++G__13185__i;}
  args = new cljs.core.IndexedSeq(G__13185__a,0);
} 
return G__13184__delegate.call(this,args);};
G__13184.cljs$lang$maxFixedArity = 0;
G__13184.cljs$lang$applyTo = (function (arglist__13186){
var args = cljs.core.seq(arglist__13186);
return G__13184__delegate(args);
});
G__13184.cljs$core$IFn$_invoke$arity$variadic = G__13184__delegate;
return G__13184;
})()
;
});
garden.stylesheet.at_rule = (function garden$stylesheet$at_rule(identifier,value){
return (new garden.types.CSSAtRule(identifier,value,null,null,null));
});
/**
 * Create a CSS @font-face rule.
 */
garden.stylesheet.at_font_face = (function garden$stylesheet$at_font_face(var_args){
var args__7617__auto__ = [];
var len__7610__auto___13188 = arguments.length;
var i__7611__auto___13189 = (0);
while(true){
if((i__7611__auto___13189 < len__7610__auto___13188)){
args__7617__auto__.push((arguments[i__7611__auto___13189]));

var G__13190 = (i__7611__auto___13189 + (1));
i__7611__auto___13189 = G__13190;
continue;
} else {
}
break;
}

var argseq__7618__auto__ = ((((0) < args__7617__auto__.length))?(new cljs.core.IndexedSeq(args__7617__auto__.slice((0)),(0),null)):null);
return garden.stylesheet.at_font_face.cljs$core$IFn$_invoke$arity$variadic(argseq__7618__auto__);
});

garden.stylesheet.at_font_face.cljs$core$IFn$_invoke$arity$variadic = (function (font_properties){
return new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, ["@font-face",font_properties], null);
});

garden.stylesheet.at_font_face.cljs$lang$maxFixedArity = (0);

garden.stylesheet.at_font_face.cljs$lang$applyTo = (function (seq13187){
return garden.stylesheet.at_font_face.cljs$core$IFn$_invoke$arity$variadic(cljs.core.seq(seq13187));
});
/**
 * Create a CSS @import rule.
 */
garden.stylesheet.at_import = (function garden$stylesheet$at_import(var_args){
var args13191 = [];
var len__7610__auto___13196 = arguments.length;
var i__7611__auto___13197 = (0);
while(true){
if((i__7611__auto___13197 < len__7610__auto___13196)){
args13191.push((arguments[i__7611__auto___13197]));

var G__13198 = (i__7611__auto___13197 + (1));
i__7611__auto___13197 = G__13198;
continue;
} else {
}
break;
}

var G__13195 = args13191.length;
switch (G__13195) {
case 1:
return garden.stylesheet.at_import.cljs$core$IFn$_invoke$arity$1((arguments[(0)]));

break;
default:
var argseq__7629__auto__ = (new cljs.core.IndexedSeq(args13191.slice((1)),(0),null));
return garden.stylesheet.at_import.cljs$core$IFn$_invoke$arity$variadic((arguments[(0)]),argseq__7629__auto__);

}
});

garden.stylesheet.at_import.cljs$core$IFn$_invoke$arity$1 = (function (url){
return garden.stylesheet.at_rule(cljs.core.cst$kw$import,new cljs.core.PersistentArrayMap(null, 2, [cljs.core.cst$kw$url,url,cljs.core.cst$kw$media_DASH_queries,null], null));
});

garden.stylesheet.at_import.cljs$core$IFn$_invoke$arity$variadic = (function (url,media_queries){
return garden.stylesheet.at_rule(cljs.core.cst$kw$import,new cljs.core.PersistentArrayMap(null, 2, [cljs.core.cst$kw$url,url,cljs.core.cst$kw$media_DASH_queries,media_queries], null));
});

garden.stylesheet.at_import.cljs$lang$applyTo = (function (seq13192){
var G__13193 = cljs.core.first(seq13192);
var seq13192__$1 = cljs.core.next(seq13192);
return garden.stylesheet.at_import.cljs$core$IFn$_invoke$arity$variadic(G__13193,seq13192__$1);
});

garden.stylesheet.at_import.cljs$lang$maxFixedArity = (1);
/**
 * Create a CSS @media rule.
 */
garden.stylesheet.at_media = (function garden$stylesheet$at_media(var_args){
var args__7617__auto__ = [];
var len__7610__auto___13202 = arguments.length;
var i__7611__auto___13203 = (0);
while(true){
if((i__7611__auto___13203 < len__7610__auto___13202)){
args__7617__auto__.push((arguments[i__7611__auto___13203]));

var G__13204 = (i__7611__auto___13203 + (1));
i__7611__auto___13203 = G__13204;
continue;
} else {
}
break;
}

var argseq__7618__auto__ = ((((1) < args__7617__auto__.length))?(new cljs.core.IndexedSeq(args__7617__auto__.slice((1)),(0),null)):null);
return garden.stylesheet.at_media.cljs$core$IFn$_invoke$arity$variadic((arguments[(0)]),argseq__7618__auto__);
});

garden.stylesheet.at_media.cljs$core$IFn$_invoke$arity$variadic = (function (media_queries,rules){
return garden.stylesheet.at_rule(cljs.core.cst$kw$media,new cljs.core.PersistentArrayMap(null, 2, [cljs.core.cst$kw$media_DASH_queries,media_queries,cljs.core.cst$kw$rules,rules], null));
});

garden.stylesheet.at_media.cljs$lang$maxFixedArity = (1);

garden.stylesheet.at_media.cljs$lang$applyTo = (function (seq13200){
var G__13201 = cljs.core.first(seq13200);
var seq13200__$1 = cljs.core.next(seq13200);
return garden.stylesheet.at_media.cljs$core$IFn$_invoke$arity$variadic(G__13201,seq13200__$1);
});
/**
 * Create a CSS @keyframes rule.
 */
garden.stylesheet.at_keyframes = (function garden$stylesheet$at_keyframes(var_args){
var args__7617__auto__ = [];
var len__7610__auto___13207 = arguments.length;
var i__7611__auto___13208 = (0);
while(true){
if((i__7611__auto___13208 < len__7610__auto___13207)){
args__7617__auto__.push((arguments[i__7611__auto___13208]));

var G__13209 = (i__7611__auto___13208 + (1));
i__7611__auto___13208 = G__13209;
continue;
} else {
}
break;
}

var argseq__7618__auto__ = ((((1) < args__7617__auto__.length))?(new cljs.core.IndexedSeq(args__7617__auto__.slice((1)),(0),null)):null);
return garden.stylesheet.at_keyframes.cljs$core$IFn$_invoke$arity$variadic((arguments[(0)]),argseq__7618__auto__);
});

garden.stylesheet.at_keyframes.cljs$core$IFn$_invoke$arity$variadic = (function (identifier,frames){
return garden.stylesheet.at_rule(cljs.core.cst$kw$keyframes,new cljs.core.PersistentArrayMap(null, 2, [cljs.core.cst$kw$identifier,identifier,cljs.core.cst$kw$frames,frames], null));
});

garden.stylesheet.at_keyframes.cljs$lang$maxFixedArity = (1);

garden.stylesheet.at_keyframes.cljs$lang$applyTo = (function (seq13205){
var G__13206 = cljs.core.first(seq13205);
var seq13205__$1 = cljs.core.next(seq13205);
return garden.stylesheet.at_keyframes.cljs$core$IFn$_invoke$arity$variadic(G__13206,seq13205__$1);
});
/**
 * Create a color from RGB values.
 */
garden.stylesheet.rgb = (function garden$stylesheet$rgb(r,g,b){
return garden.color.rgb.cljs$core$IFn$_invoke$arity$1(new cljs.core.PersistentVector(null, 3, 5, cljs.core.PersistentVector.EMPTY_NODE, [r,g,b], null));
});
/**
 * Create a color from HSL values.
 */
garden.stylesheet.hsl = (function garden$stylesheet$hsl(h,s,l){
return garden.color.hsl.cljs$core$IFn$_invoke$arity$1(new cljs.core.PersistentVector(null, 3, 5, cljs.core.PersistentVector.EMPTY_NODE, [h,s,l], null));
});
