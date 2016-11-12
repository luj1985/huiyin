// Compiled by ClojureScript 1.8.51 {:static-fns true, :optimize-constants true}
goog.provide('huiyin.app');
goog.require('cljs.core');
goog.require('secretary.core');
goog.require('goog.history.Html5History');
goog.require('huiyin.components.sections');
goog.require('reagent.core');
goog.require('goog.history.EventType');
goog.require('goog.events.EventType');
goog.require('goog.events');
goog.require('huiyin.components.footer');
goog.require('huiyin.components.header');
cljs.core.enable_console_print_BANG_();
huiyin.app.get_viewport_size = (function huiyin$app$get_viewport_size(){
var w = window.innerWidth;
var h = window.innerHeight;
return new cljs.core.PersistentArrayMap(null, 2, [cljs.core.cst$kw$width,w,cljs.core.cst$kw$height,h], null);
});
if(typeof huiyin.app.state !== 'undefined'){
} else {
huiyin.app.state = reagent.core.atom.cljs$core$IFn$_invoke$arity$1(new cljs.core.PersistentArrayMap(null, 1, [cljs.core.cst$kw$path,"/"], null));
}
var action__14037__auto___14159 = (function (params__14038__auto__){
if(cljs.core.map_QMARK_(params__14038__auto__)){
var map__14155 = params__14038__auto__;
var map__14155__$1 = ((((!((map__14155 == null)))?((((map__14155.cljs$lang$protocol_mask$partition0$ & (64))) || (map__14155.cljs$core$ISeq$))?true:false):false))?cljs.core.apply.cljs$core$IFn$_invoke$arity$2(cljs.core.hash_map,map__14155):map__14155);
return new cljs.core.PersistentArrayMap(null, 1, [cljs.core.cst$kw$path,cljs.core.cst$kw$home], null);
} else {
if(cljs.core.vector_QMARK_(params__14038__auto__)){
var vec__14157 = params__14038__auto__;
return new cljs.core.PersistentArrayMap(null, 1, [cljs.core.cst$kw$path,cljs.core.cst$kw$home], null);
} else {
return null;
}
}
});
secretary.core.add_route_BANG_("/",action__14037__auto___14159);

huiyin.app.index = ((function (action__14037__auto___14159){
return (function huiyin$app$index(var_args){
var args__7617__auto__ = [];
var len__7610__auto___14160 = arguments.length;
var i__7611__auto___14161 = (0);
while(true){
if((i__7611__auto___14161 < len__7610__auto___14160)){
args__7617__auto__.push((arguments[i__7611__auto___14161]));

var G__14162 = (i__7611__auto___14161 + (1));
i__7611__auto___14161 = G__14162;
continue;
} else {
}
break;
}

var argseq__7618__auto__ = ((((0) < args__7617__auto__.length))?(new cljs.core.IndexedSeq(args__7617__auto__.slice((0)),(0),null)):null);
return huiyin.app.index.cljs$core$IFn$_invoke$arity$variadic(argseq__7618__auto__);
});})(action__14037__auto___14159))
;

huiyin.app.index.cljs$core$IFn$_invoke$arity$variadic = ((function (action__14037__auto___14159){
return (function (args__14036__auto__){
return cljs.core.apply.cljs$core$IFn$_invoke$arity$3(secretary.core.render_route_STAR_,"/",args__14036__auto__);
});})(action__14037__auto___14159))
;

huiyin.app.index.cljs$lang$maxFixedArity = (0);

huiyin.app.index.cljs$lang$applyTo = ((function (action__14037__auto___14159){
return (function (seq14158){
return huiyin.app.index.cljs$core$IFn$_invoke$arity$variadic(cljs.core.seq(seq14158));
});})(action__14037__auto___14159))
;
var action__14037__auto___14167 = (function (params__14038__auto__){
if(cljs.core.map_QMARK_(params__14038__auto__)){
var map__14163 = params__14038__auto__;
var map__14163__$1 = ((((!((map__14163 == null)))?((((map__14163.cljs$lang$protocol_mask$partition0$ & (64))) || (map__14163.cljs$core$ISeq$))?true:false):false))?cljs.core.apply.cljs$core$IFn$_invoke$arity$2(cljs.core.hash_map,map__14163):map__14163);
return new cljs.core.PersistentArrayMap(null, 1, [cljs.core.cst$kw$path,cljs.core.cst$kw$home], null);
} else {
if(cljs.core.vector_QMARK_(params__14038__auto__)){
var vec__14165 = params__14038__auto__;
return new cljs.core.PersistentArrayMap(null, 1, [cljs.core.cst$kw$path,cljs.core.cst$kw$home], null);
} else {
return null;
}
}
});
secretary.core.add_route_BANG_("/home",action__14037__auto___14167);

huiyin.app.home = ((function (action__14037__auto___14167){
return (function huiyin$app$home(var_args){
var args__7617__auto__ = [];
var len__7610__auto___14168 = arguments.length;
var i__7611__auto___14169 = (0);
while(true){
if((i__7611__auto___14169 < len__7610__auto___14168)){
args__7617__auto__.push((arguments[i__7611__auto___14169]));

var G__14170 = (i__7611__auto___14169 + (1));
i__7611__auto___14169 = G__14170;
continue;
} else {
}
break;
}

var argseq__7618__auto__ = ((((0) < args__7617__auto__.length))?(new cljs.core.IndexedSeq(args__7617__auto__.slice((0)),(0),null)):null);
return huiyin.app.home.cljs$core$IFn$_invoke$arity$variadic(argseq__7618__auto__);
});})(action__14037__auto___14167))
;

huiyin.app.home.cljs$core$IFn$_invoke$arity$variadic = ((function (action__14037__auto___14167){
return (function (args__14036__auto__){
return cljs.core.apply.cljs$core$IFn$_invoke$arity$3(secretary.core.render_route_STAR_,"/home",args__14036__auto__);
});})(action__14037__auto___14167))
;

huiyin.app.home.cljs$lang$maxFixedArity = (0);

huiyin.app.home.cljs$lang$applyTo = ((function (action__14037__auto___14167){
return (function (seq14166){
return huiyin.app.home.cljs$core$IFn$_invoke$arity$variadic(cljs.core.seq(seq14166));
});})(action__14037__auto___14167))
;
var action__14037__auto___14175 = (function (params__14038__auto__){
if(cljs.core.map_QMARK_(params__14038__auto__)){
var map__14171 = params__14038__auto__;
var map__14171__$1 = ((((!((map__14171 == null)))?((((map__14171.cljs$lang$protocol_mask$partition0$ & (64))) || (map__14171.cljs$core$ISeq$))?true:false):false))?cljs.core.apply.cljs$core$IFn$_invoke$arity$2(cljs.core.hash_map,map__14171):map__14171);
return new cljs.core.PersistentArrayMap(null, 1, [cljs.core.cst$kw$path,cljs.core.cst$kw$about], null);
} else {
if(cljs.core.vector_QMARK_(params__14038__auto__)){
var vec__14173 = params__14038__auto__;
return new cljs.core.PersistentArrayMap(null, 1, [cljs.core.cst$kw$path,cljs.core.cst$kw$about], null);
} else {
return null;
}
}
});
secretary.core.add_route_BANG_("/about",action__14037__auto___14175);

huiyin.app.about = ((function (action__14037__auto___14175){
return (function huiyin$app$about(var_args){
var args__7617__auto__ = [];
var len__7610__auto___14176 = arguments.length;
var i__7611__auto___14177 = (0);
while(true){
if((i__7611__auto___14177 < len__7610__auto___14176)){
args__7617__auto__.push((arguments[i__7611__auto___14177]));

var G__14178 = (i__7611__auto___14177 + (1));
i__7611__auto___14177 = G__14178;
continue;
} else {
}
break;
}

var argseq__7618__auto__ = ((((0) < args__7617__auto__.length))?(new cljs.core.IndexedSeq(args__7617__auto__.slice((0)),(0),null)):null);
return huiyin.app.about.cljs$core$IFn$_invoke$arity$variadic(argseq__7618__auto__);
});})(action__14037__auto___14175))
;

huiyin.app.about.cljs$core$IFn$_invoke$arity$variadic = ((function (action__14037__auto___14175){
return (function (args__14036__auto__){
return cljs.core.apply.cljs$core$IFn$_invoke$arity$3(secretary.core.render_route_STAR_,"/about",args__14036__auto__);
});})(action__14037__auto___14175))
;

huiyin.app.about.cljs$lang$maxFixedArity = (0);

huiyin.app.about.cljs$lang$applyTo = ((function (action__14037__auto___14175){
return (function (seq14174){
return huiyin.app.about.cljs$core$IFn$_invoke$arity$variadic(cljs.core.seq(seq14174));
});})(action__14037__auto___14175))
;
var action__14037__auto___14183 = (function (params__14038__auto__){
if(cljs.core.map_QMARK_(params__14038__auto__)){
var map__14179 = params__14038__auto__;
var map__14179__$1 = ((((!((map__14179 == null)))?((((map__14179.cljs$lang$protocol_mask$partition0$ & (64))) || (map__14179.cljs$core$ISeq$))?true:false):false))?cljs.core.apply.cljs$core$IFn$_invoke$arity$2(cljs.core.hash_map,map__14179):map__14179);
var id = cljs.core.get.cljs$core$IFn$_invoke$arity$2(map__14179__$1,cljs.core.cst$kw$id);
var id__$1 = parseInt(id);
return new cljs.core.PersistentArrayMap(null, 2, [cljs.core.cst$kw$path,cljs.core.cst$kw$member,cljs.core.cst$kw$params,new cljs.core.PersistentArrayMap(null, 1, [cljs.core.cst$kw$id,id__$1], null)], null);
} else {
if(cljs.core.vector_QMARK_(params__14038__auto__)){
var vec__14181 = params__14038__auto__;
var id = cljs.core.nth.cljs$core$IFn$_invoke$arity$3(vec__14181,(0),null);
var id__$1 = parseInt(id);
return new cljs.core.PersistentArrayMap(null, 2, [cljs.core.cst$kw$path,cljs.core.cst$kw$member,cljs.core.cst$kw$params,new cljs.core.PersistentArrayMap(null, 1, [cljs.core.cst$kw$id,id__$1], null)], null);
} else {
return null;
}
}
});
secretary.core.add_route_BANG_("/member/:id",action__14037__auto___14183);

huiyin.app.member = ((function (action__14037__auto___14183){
return (function huiyin$app$member(var_args){
var args__7617__auto__ = [];
var len__7610__auto___14184 = arguments.length;
var i__7611__auto___14185 = (0);
while(true){
if((i__7611__auto___14185 < len__7610__auto___14184)){
args__7617__auto__.push((arguments[i__7611__auto___14185]));

var G__14186 = (i__7611__auto___14185 + (1));
i__7611__auto___14185 = G__14186;
continue;
} else {
}
break;
}

var argseq__7618__auto__ = ((((0) < args__7617__auto__.length))?(new cljs.core.IndexedSeq(args__7617__auto__.slice((0)),(0),null)):null);
return huiyin.app.member.cljs$core$IFn$_invoke$arity$variadic(argseq__7618__auto__);
});})(action__14037__auto___14183))
;

huiyin.app.member.cljs$core$IFn$_invoke$arity$variadic = ((function (action__14037__auto___14183){
return (function (args__14036__auto__){
return cljs.core.apply.cljs$core$IFn$_invoke$arity$3(secretary.core.render_route_STAR_,"/member/:id",args__14036__auto__);
});})(action__14037__auto___14183))
;

huiyin.app.member.cljs$lang$maxFixedArity = (0);

huiyin.app.member.cljs$lang$applyTo = ((function (action__14037__auto___14183){
return (function (seq14182){
return huiyin.app.member.cljs$core$IFn$_invoke$arity$variadic(cljs.core.seq(seq14182));
});})(action__14037__auto___14183))
;
if(typeof huiyin.app.history !== 'undefined'){
} else {
huiyin.app.history = (function (){
secretary.core.set_config_BANG_(cljs.core.cst$kw$prefix,"#");

var G__14187 = (new goog.history.Html5History());
var G__14190_14195 = G__14187;
var G__14191_14196 = goog.history.EventType.NAVIGATE;
var G__14192_14197 = ((function (G__14190_14195,G__14191_14196,G__14187){
return (function (event){
var map__14193 = secretary.core.dispatch_BANG_(event.token);
var map__14193__$1 = ((((!((map__14193 == null)))?((((map__14193.cljs$lang$protocol_mask$partition0$ & (64))) || (map__14193.cljs$core$ISeq$))?true:false):false))?cljs.core.apply.cljs$core$IFn$_invoke$arity$2(cljs.core.hash_map,map__14193):map__14193);
var path = cljs.core.get.cljs$core$IFn$_invoke$arity$2(map__14193__$1,cljs.core.cst$kw$path);
var params = cljs.core.get.cljs$core$IFn$_invoke$arity$2(map__14193__$1,cljs.core.cst$kw$params);
return cljs.core.swap_BANG_.cljs$core$IFn$_invoke$arity$variadic(huiyin.app.state,cljs.core.assoc,cljs.core.cst$kw$path,path,cljs.core.array_seq([cljs.core.cst$kw$params,params], 0));
});})(G__14190_14195,G__14191_14196,G__14187))
;
goog.events.listen(G__14190_14195,G__14191_14196,G__14192_14197);

G__14187.setEnabled(true);

return G__14187;
})()
;
}
huiyin.app.render_pages = (function huiyin$app$render_pages(state){
return new cljs.core.PersistentVector(null, 4, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$div,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [huiyin.components.header.render,state], null),new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [huiyin.components.sections.render,state], null),new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [huiyin.components.footer.render,state], null)], null);
});
huiyin.app.caculate_sizes_BANG_ = (function huiyin$app$caculate_sizes_BANG_(){
return cljs.core.swap_BANG_.cljs$core$IFn$_invoke$arity$2(huiyin.app.state,(function (p__14201){
var map__14202 = p__14201;
var map__14202__$1 = ((((!((map__14202 == null)))?((((map__14202.cljs$lang$protocol_mask$partition0$ & (64))) || (map__14202.cljs$core$ISeq$))?true:false):false))?cljs.core.apply.cljs$core$IFn$_invoke$arity$2(cljs.core.hash_map,map__14202):map__14202);
var state = map__14202__$1;
var viewport_size = cljs.core.get.cljs$core$IFn$_invoke$arity$2(map__14202__$1,cljs.core.cst$kw$viewport_DASH_size);
var new_viewport_size = huiyin.app.get_viewport_size();
var resized_QMARK_ = cljs.core.not_EQ_.cljs$core$IFn$_invoke$arity$2(cljs.core.cst$kw$width.cljs$core$IFn$_invoke$arity$1(viewport_size),cljs.core.cst$kw$width.cljs$core$IFn$_invoke$arity$1(new_viewport_size));
return cljs.core.assoc.cljs$core$IFn$_invoke$arity$3(state,cljs.core.cst$kw$viewport_DASH_size,((resized_QMARK_)?new_viewport_size:viewport_size));
}));
});
if(typeof huiyin.app.events_setup !== 'undefined'){
} else {
huiyin.app.events_setup = goog.events.listen(window,goog.events.EventType.RESIZE,huiyin.app.caculate_sizes_BANG_);
}
huiyin.app.init = (function huiyin$app$init(){
reagent.core.render.cljs$core$IFn$_invoke$arity$2(new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [huiyin.app.render_pages,huiyin.app.state], null),document.getElementById("app"));

return huiyin.app.caculate_sizes_BANG_();
});
