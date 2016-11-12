// Compiled by ClojureScript 1.8.51 {:static-fns true, :optimize-constants true}
goog.provide('huiyin.components.sections');
goog.require('cljs.core');
goog.require('garden.stylesheet');
goog.require('garden.units');
goog.require('garden.color');
goog.require('huiyin.data');
goog.require('huiyin.utils');
goog.require('huiyin.components.jumbotron');
goog.require('huiyin.components.member');
huiyin.components.sections.render_intro = (function huiyin$components$sections$render_intro(){
return new cljs.core.PersistentVector(null, 3, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$section,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$h2,cljs.core.get_in.cljs$core$IFn$_invoke$arity$2(huiyin.data.messages,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$sections,cljs.core.cst$kw$intro], null))], null),cljs.core.doall.cljs$core$IFn$_invoke$arity$1(cljs.core.map_indexed.cljs$core$IFn$_invoke$arity$2((function (i,html){
return cljs.core.with_meta(new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$p,new cljs.core.PersistentArrayMap(null, 1, [cljs.core.cst$kw$dangerouslySetInnerHTML,new cljs.core.PersistentArrayMap(null, 1, [cljs.core.cst$kw$__html,html], null)], null)], null),new cljs.core.PersistentArrayMap(null, 1, [cljs.core.cst$kw$key,i], null));
}),huiyin.data.introductions))], null);
});
huiyin.components.sections.render_members = (function huiyin$components$sections$render_members(){
return new cljs.core.PersistentVector(null, 3, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$section,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$h2,cljs.core.get_in.cljs$core$IFn$_invoke$arity$2(huiyin.data.messages,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$sections,cljs.core.cst$kw$who_DASH_we_DASH_are], null))], null),new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$ul,(function (){var iter__7320__auto__ = (function huiyin$components$sections$render_members_$_iter__13250(s__13251){
return (new cljs.core.LazySeq(null,(function (){
var s__13251__$1 = s__13251;
while(true){
var temp__4657__auto__ = cljs.core.seq(s__13251__$1);
if(temp__4657__auto__){
var s__13251__$2 = temp__4657__auto__;
if(cljs.core.chunked_seq_QMARK_(s__13251__$2)){
var c__7318__auto__ = cljs.core.chunk_first(s__13251__$2);
var size__7319__auto__ = cljs.core.count(c__7318__auto__);
var b__13253 = cljs.core.chunk_buffer(size__7319__auto__);
if((function (){var i__13252 = (0);
while(true){
if((i__13252 < size__7319__auto__)){
var vec__13262 = cljs.core._nth.cljs$core$IFn$_invoke$arity$2(c__7318__auto__,i__13252);
var map__13263 = cljs.core.nth.cljs$core$IFn$_invoke$arity$3(vec__13262,(0),null);
var map__13263__$1 = ((((!((map__13263 == null)))?((((map__13263.cljs$lang$protocol_mask$partition0$ & (64))) || (map__13263.cljs$core$ISeq$))?true:false):false))?cljs.core.apply.cljs$core$IFn$_invoke$arity$2(cljs.core.hash_map,map__13263):map__13263);
var name = cljs.core.get.cljs$core$IFn$_invoke$arity$2(map__13263__$1,cljs.core.cst$kw$name);
var title = cljs.core.get.cljs$core$IFn$_invoke$arity$2(map__13263__$1,cljs.core.cst$kw$title);
var avatar = cljs.core.get.cljs$core$IFn$_invoke$arity$2(map__13263__$1,cljs.core.cst$kw$avatar);
var i = cljs.core.nth.cljs$core$IFn$_invoke$arity$3(vec__13262,(1),null);
cljs.core.chunk_append(b__13253,cljs.core.with_meta(new cljs.core.PersistentVector(null, 3, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$li$member,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$div$avatar,new cljs.core.PersistentArrayMap(null, 1, [cljs.core.cst$kw$style,new cljs.core.PersistentArrayMap(null, 1, [cljs.core.cst$kw$background_DASH_image,[cljs.core.str("url("),cljs.core.str(avatar),cljs.core.str(")")].join('')], null)], null)], null),new cljs.core.PersistentVector(null, 3, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$div$desc,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$h4,new cljs.core.PersistentVector(null, 3, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$a,new cljs.core.PersistentArrayMap(null, 1, [cljs.core.cst$kw$href,[cljs.core.str("#/member/"),cljs.core.str(i)].join('')], null),name], null)], null),new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$h5,title], null)], null)], null),new cljs.core.PersistentArrayMap(null, 1, [cljs.core.cst$kw$key,i], null)));

var G__13268 = (i__13252 + (1));
i__13252 = G__13268;
continue;
} else {
return true;
}
break;
}
})()){
return cljs.core.chunk_cons(cljs.core.chunk(b__13253),huiyin$components$sections$render_members_$_iter__13250(cljs.core.chunk_rest(s__13251__$2)));
} else {
return cljs.core.chunk_cons(cljs.core.chunk(b__13253),null);
}
} else {
var vec__13265 = cljs.core.first(s__13251__$2);
var map__13266 = cljs.core.nth.cljs$core$IFn$_invoke$arity$3(vec__13265,(0),null);
var map__13266__$1 = ((((!((map__13266 == null)))?((((map__13266.cljs$lang$protocol_mask$partition0$ & (64))) || (map__13266.cljs$core$ISeq$))?true:false):false))?cljs.core.apply.cljs$core$IFn$_invoke$arity$2(cljs.core.hash_map,map__13266):map__13266);
var name = cljs.core.get.cljs$core$IFn$_invoke$arity$2(map__13266__$1,cljs.core.cst$kw$name);
var title = cljs.core.get.cljs$core$IFn$_invoke$arity$2(map__13266__$1,cljs.core.cst$kw$title);
var avatar = cljs.core.get.cljs$core$IFn$_invoke$arity$2(map__13266__$1,cljs.core.cst$kw$avatar);
var i = cljs.core.nth.cljs$core$IFn$_invoke$arity$3(vec__13265,(1),null);
return cljs.core.cons(cljs.core.with_meta(new cljs.core.PersistentVector(null, 3, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$li$member,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$div$avatar,new cljs.core.PersistentArrayMap(null, 1, [cljs.core.cst$kw$style,new cljs.core.PersistentArrayMap(null, 1, [cljs.core.cst$kw$background_DASH_image,[cljs.core.str("url("),cljs.core.str(avatar),cljs.core.str(")")].join('')], null)], null)], null),new cljs.core.PersistentVector(null, 3, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$div$desc,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$h4,new cljs.core.PersistentVector(null, 3, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$a,new cljs.core.PersistentArrayMap(null, 1, [cljs.core.cst$kw$href,[cljs.core.str("#/member/"),cljs.core.str(i)].join('')], null),name], null)], null),new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$h5,title], null)], null)], null),new cljs.core.PersistentArrayMap(null, 1, [cljs.core.cst$kw$key,i], null)),huiyin$components$sections$render_members_$_iter__13250(cljs.core.rest(s__13251__$2)));
}
} else {
return null;
}
break;
}
}),null,null));
});
return iter__7320__auto__(cljs.core.zipmap(huiyin.data.members,cljs.core.range.cljs$core$IFn$_invoke$arity$0()));
})()], null)], null);
});
huiyin.components.sections.render_companies = (function huiyin$components$sections$render_companies(){
return new cljs.core.PersistentVector(null, 3, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$aside,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$h2,new cljs.core.PersistentVector(null, 3, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$a,new cljs.core.PersistentArrayMap(null, 1, [cljs.core.cst$kw$href,"https://angel.co/huiyin-blockchain-venture"], null),cljs.core.get_in.cljs$core$IFn$_invoke$arity$2(huiyin.data.messages,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$sections,cljs.core.cst$kw$angel], null))], null)], null),new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$ul,(function (){var iter__7320__auto__ = (function huiyin$components$sections$render_companies_$_iter__13283(s__13284){
return (new cljs.core.LazySeq(null,(function (){
var s__13284__$1 = s__13284;
while(true){
var temp__4657__auto__ = cljs.core.seq(s__13284__$1);
if(temp__4657__auto__){
var s__13284__$2 = temp__4657__auto__;
if(cljs.core.chunked_seq_QMARK_(s__13284__$2)){
var c__7318__auto__ = cljs.core.chunk_first(s__13284__$2);
var size__7319__auto__ = cljs.core.count(c__7318__auto__);
var b__13286 = cljs.core.chunk_buffer(size__7319__auto__);
if((function (){var i__13285 = (0);
while(true){
if((i__13285 < size__7319__auto__)){
var map__13293 = cljs.core._nth.cljs$core$IFn$_invoke$arity$2(c__7318__auto__,i__13285);
var map__13293__$1 = ((((!((map__13293 == null)))?((((map__13293.cljs$lang$protocol_mask$partition0$ & (64))) || (map__13293.cljs$core$ISeq$))?true:false):false))?cljs.core.apply.cljs$core$IFn$_invoke$arity$2(cljs.core.hash_map,map__13293):map__13293);
var name = cljs.core.get.cljs$core$IFn$_invoke$arity$2(map__13293__$1,cljs.core.cst$kw$name);
var url = cljs.core.get.cljs$core$IFn$_invoke$arity$2(map__13293__$1,cljs.core.cst$kw$url);
var logo = cljs.core.get.cljs$core$IFn$_invoke$arity$2(map__13293__$1,cljs.core.cst$kw$logo);
cljs.core.chunk_append(b__13286,cljs.core.with_meta(new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$li$company,new cljs.core.PersistentVector(null, 4, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$a,new cljs.core.PersistentArrayMap(null, 2, [cljs.core.cst$kw$href,url,cljs.core.cst$kw$target,"_blank"], null),new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$img,new cljs.core.PersistentArrayMap(null, 1, [cljs.core.cst$kw$src,logo], null)], null),name], null)], null),new cljs.core.PersistentArrayMap(null, 1, [cljs.core.cst$kw$key,url], null)));

var G__13297 = (i__13285 + (1));
i__13285 = G__13297;
continue;
} else {
return true;
}
break;
}
})()){
return cljs.core.chunk_cons(cljs.core.chunk(b__13286),huiyin$components$sections$render_companies_$_iter__13283(cljs.core.chunk_rest(s__13284__$2)));
} else {
return cljs.core.chunk_cons(cljs.core.chunk(b__13286),null);
}
} else {
var map__13295 = cljs.core.first(s__13284__$2);
var map__13295__$1 = ((((!((map__13295 == null)))?((((map__13295.cljs$lang$protocol_mask$partition0$ & (64))) || (map__13295.cljs$core$ISeq$))?true:false):false))?cljs.core.apply.cljs$core$IFn$_invoke$arity$2(cljs.core.hash_map,map__13295):map__13295);
var name = cljs.core.get.cljs$core$IFn$_invoke$arity$2(map__13295__$1,cljs.core.cst$kw$name);
var url = cljs.core.get.cljs$core$IFn$_invoke$arity$2(map__13295__$1,cljs.core.cst$kw$url);
var logo = cljs.core.get.cljs$core$IFn$_invoke$arity$2(map__13295__$1,cljs.core.cst$kw$logo);
return cljs.core.cons(cljs.core.with_meta(new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$li$company,new cljs.core.PersistentVector(null, 4, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$a,new cljs.core.PersistentArrayMap(null, 2, [cljs.core.cst$kw$href,url,cljs.core.cst$kw$target,"_blank"], null),new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$img,new cljs.core.PersistentArrayMap(null, 1, [cljs.core.cst$kw$src,logo], null)], null),name], null)], null),new cljs.core.PersistentArrayMap(null, 1, [cljs.core.cst$kw$key,url], null)),huiyin$components$sections$render_companies_$_iter__13283(cljs.core.rest(s__13284__$2)));
}
} else {
return null;
}
break;
}
}),null,null));
});
return iter__7320__auto__(huiyin.data.companies);
})()], null)], null);
});
if(typeof huiyin.components.sections.render !== 'undefined'){
} else {
huiyin.components.sections.render = (function (){var method_table__7465__auto__ = (function (){var G__13298 = cljs.core.PersistentArrayMap.EMPTY;
return (cljs.core.atom.cljs$core$IFn$_invoke$arity$1 ? cljs.core.atom.cljs$core$IFn$_invoke$arity$1(G__13298) : cljs.core.atom.call(null,G__13298));
})();
var prefer_table__7466__auto__ = (function (){var G__13299 = cljs.core.PersistentArrayMap.EMPTY;
return (cljs.core.atom.cljs$core$IFn$_invoke$arity$1 ? cljs.core.atom.cljs$core$IFn$_invoke$arity$1(G__13299) : cljs.core.atom.call(null,G__13299));
})();
var method_cache__7467__auto__ = (function (){var G__13300 = cljs.core.PersistentArrayMap.EMPTY;
return (cljs.core.atom.cljs$core$IFn$_invoke$arity$1 ? cljs.core.atom.cljs$core$IFn$_invoke$arity$1(G__13300) : cljs.core.atom.call(null,G__13300));
})();
var cached_hierarchy__7468__auto__ = (function (){var G__13301 = cljs.core.PersistentArrayMap.EMPTY;
return (cljs.core.atom.cljs$core$IFn$_invoke$arity$1 ? cljs.core.atom.cljs$core$IFn$_invoke$arity$1(G__13301) : cljs.core.atom.call(null,G__13301));
})();
var hierarchy__7469__auto__ = cljs.core.get.cljs$core$IFn$_invoke$arity$3(cljs.core.PersistentArrayMap.EMPTY,cljs.core.cst$kw$hierarchy,cljs.core.get_global_hierarchy());
return (new cljs.core.MultiFn(cljs.core.symbol.cljs$core$IFn$_invoke$arity$2("huiyin.components.sections","render"),((function (method_table__7465__auto__,prefer_table__7466__auto__,method_cache__7467__auto__,cached_hierarchy__7468__auto__,hierarchy__7469__auto__){
return (function (state){
return cljs.core.cst$kw$path.cljs$core$IFn$_invoke$arity$1((cljs.core.deref.cljs$core$IFn$_invoke$arity$1 ? cljs.core.deref.cljs$core$IFn$_invoke$arity$1(state) : cljs.core.deref.call(null,state)));
});})(method_table__7465__auto__,prefer_table__7466__auto__,method_cache__7467__auto__,cached_hierarchy__7468__auto__,hierarchy__7469__auto__))
,cljs.core.cst$kw$default,hierarchy__7469__auto__,method_table__7465__auto__,prefer_table__7466__auto__,method_cache__7467__auto__,cached_hierarchy__7468__auto__));
})();
}
huiyin.components.sections.render.cljs$core$IMultiFn$_add_method$arity$3(null,cljs.core.cst$kw$home,(function (state){
huiyin.utils.scroll_to_element("main");

return new cljs.core.PersistentVector(null, 3, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$main,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [huiyin.components.jumbotron.render,state], null),new cljs.core.PersistentVector(null, 3, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$div$container$columns,new cljs.core.PersistentVector(null, 3, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$div$content,new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [huiyin.components.sections.render_intro], null),new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [huiyin.components.sections.render_members,state], null)], null),new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [huiyin.components.sections.render_companies], null)], null)], null);
}));
huiyin.components.sections.render.cljs$core$IMultiFn$_add_method$arity$3(null,cljs.core.cst$kw$about,(function (state){
huiyin.utils.scroll_to_element.cljs$core$IFn$_invoke$arity$variadic(".content",cljs.core.array_seq([(-70)], 0));

return new cljs.core.PersistentVector(null, 3, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$main,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [huiyin.components.jumbotron.render,state], null),new cljs.core.PersistentVector(null, 3, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$div$container$columns,new cljs.core.PersistentVector(null, 3, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$div$content,new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [huiyin.components.sections.render_intro], null),new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [huiyin.components.sections.render_members,state], null)], null),new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [huiyin.components.sections.render_companies], null)], null)], null);
}));
huiyin.components.sections.render.cljs$core$IMultiFn$_add_method$arity$3(null,cljs.core.cst$kw$member,(function (state){
return huiyin.components.member.render(state);
}));
huiyin.components.sections.render.cljs$core$IMultiFn$_add_method$arity$3(null,cljs.core.cst$kw$default,(function (state){
return new cljs.core.PersistentVector(null, 4, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$main,new cljs.core.PersistentArrayMap(null, 1, [cljs.core.cst$kw$style,new cljs.core.PersistentArrayMap(null, 1, [cljs.core.cst$kw$min_DASH_height,"100%"], null)], null),new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$section$jumbotron,new cljs.core.PersistentArrayMap(null, 1, [cljs.core.cst$kw$style,new cljs.core.PersistentArrayMap(null, 1, [cljs.core.cst$kw$height,"300px"], null)], null)], null),new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$div$container$resume,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$h2,cljs.core.cst$kw$not_DASH_found.cljs$core$IFn$_invoke$arity$1(huiyin.data.messages)], null)], null)], null);
}));
huiyin.components.sections.member_card = new cljs.core.PersistentVector(null, 4, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$$member,new cljs.core.PersistentArrayMap(null, 3, [cljs.core.cst$kw$display,cljs.core.cst$kw$flex,cljs.core.cst$kw$flex_DASH_direction,cljs.core.cst$kw$row,cljs.core.cst$kw$margin,new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [(garden.units.rem.cljs$core$IFn$_invoke$arity$1 ? garden.units.rem.cljs$core$IFn$_invoke$arity$1(1.5) : garden.units.rem.call(null,1.5)),(0)], null)], null)], null),new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$$avatar,new cljs.core.PersistentArrayMap(null, 8, [cljs.core.cst$kw$flex_DASH_shrink,(0),cljs.core.cst$kw$width,(garden.units.rem.cljs$core$IFn$_invoke$arity$1 ? garden.units.rem.cljs$core$IFn$_invoke$arity$1((4)) : garden.units.rem.call(null,(4))),cljs.core.cst$kw$height,(garden.units.rem.cljs$core$IFn$_invoke$arity$1 ? garden.units.rem.cljs$core$IFn$_invoke$arity$1((4)) : garden.units.rem.call(null,(4))),cljs.core.cst$kw$box_DASH_shadow,new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.PersistentVector(null, 4, 5, cljs.core.PersistentVector.EMPTY_NODE, [(0),(0),(garden.units.px.cljs$core$IFn$_invoke$arity$1 ? garden.units.px.cljs$core$IFn$_invoke$arity$1((4)) : garden.units.px.call(null,(4))),garden.color.rgba.cljs$core$IFn$_invoke$arity$4((0),(0),(0),0.8)], null)], null),cljs.core.cst$kw$border_DASH_radius,(garden.units.percent.cljs$core$IFn$_invoke$arity$1 ? garden.units.percent.cljs$core$IFn$_invoke$arity$1((50)) : garden.units.percent.call(null,(50))),cljs.core.cst$kw$background_DASH_repeat,cljs.core.cst$kw$no_DASH_repeat,cljs.core.cst$kw$background_DASH_position,new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [(garden.units.percent.cljs$core$IFn$_invoke$arity$1 ? garden.units.percent.cljs$core$IFn$_invoke$arity$1((50)) : garden.units.percent.call(null,(50))),(garden.units.percent.cljs$core$IFn$_invoke$arity$1 ? garden.units.percent.cljs$core$IFn$_invoke$arity$1((50)) : garden.units.percent.call(null,(50)))], null)], null),cljs.core.cst$kw$background_DASH_size,new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [(garden.units.percent.cljs$core$IFn$_invoke$arity$1 ? garden.units.percent.cljs$core$IFn$_invoke$arity$1((100)) : garden.units.percent.call(null,(100))),cljs.core.cst$kw$auto], null)], null)], null)], null),new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$$desc,new cljs.core.PersistentArrayMap(null, 1, [cljs.core.cst$kw$padding,new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [(0),(garden.units.rem.cljs$core$IFn$_invoke$arity$1 ? garden.units.rem.cljs$core$IFn$_invoke$arity$1((1)) : garden.units.rem.call(null,(1)))], null)], null)], null)], null)], null);
huiyin.components.sections.company_style = new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.PersistentVector(null, 4, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$li$company,new cljs.core.PersistentArrayMap(null, 2, [cljs.core.cst$kw$display,cljs.core.cst$kw$block,cljs.core.cst$kw$margin,new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.PersistentVector(null, 4, 5, cljs.core.PersistentVector.EMPTY_NODE, [(garden.units.rem.cljs$core$IFn$_invoke$arity$1 ? garden.units.rem.cljs$core$IFn$_invoke$arity$1((1)) : garden.units.rem.call(null,(1))),(garden.units.rem.cljs$core$IFn$_invoke$arity$1 ? garden.units.rem.cljs$core$IFn$_invoke$arity$1((1)) : garden.units.rem.call(null,(1))),(garden.units.rem.cljs$core$IFn$_invoke$arity$1 ? garden.units.rem.cljs$core$IFn$_invoke$arity$1((1)) : garden.units.rem.call(null,(1))),(0)], null)], null)], null),new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$img,new cljs.core.PersistentArrayMap(null, 3, [cljs.core.cst$kw$height,(garden.units.rem.cljs$core$IFn$_invoke$arity$1 ? garden.units.rem.cljs$core$IFn$_invoke$arity$1((3)) : garden.units.rem.call(null,(3))),cljs.core.cst$kw$width,(garden.units.rem.cljs$core$IFn$_invoke$arity$1 ? garden.units.rem.cljs$core$IFn$_invoke$arity$1((3)) : garden.units.rem.call(null,(3))),cljs.core.cst$kw$margin_DASH_right,(garden.units.rem.cljs$core$IFn$_invoke$arity$1 ? garden.units.rem.cljs$core$IFn$_invoke$arity$1((1)) : garden.units.rem.call(null,(1)))], null)], null),new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$a,new cljs.core.PersistentArrayMap(null, 3, [cljs.core.cst$kw$display,cljs.core.cst$kw$flex,cljs.core.cst$kw$flex_DASH_direction,cljs.core.cst$kw$row,cljs.core.cst$kw$align_DASH_items,cljs.core.cst$kw$center], null)], null)], null)], null);
huiyin.components.sections.section_layout = new cljs.core.PersistentVector(null, 5, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.PersistentVector(null, 6, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$$columns,new cljs.core.PersistentArrayMap(null, 3, [cljs.core.cst$kw$display,cljs.core.cst$kw$flex,cljs.core.cst$kw$flex_DASH_direction,cljs.core.cst$kw$row,cljs.core.cst$kw$padding,(0)], null),new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$$content,new cljs.core.PersistentArrayMap(null, 1, [cljs.core.cst$kw$flex_DASH_grow,(9)], null)], null),new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$aside,new cljs.core.PersistentArrayMap(null, 1, [cljs.core.cst$kw$flex_DASH_grow,(0)], null)], null),new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$aside,new cljs.core.PersistentArrayMap(null, 1, [cljs.core.cst$kw$padding,(garden.units.rem.cljs$core$IFn$_invoke$arity$1 ? garden.units.rem.cljs$core$IFn$_invoke$arity$1((1)) : garden.units.rem.call(null,(1)))], null)], null),new cljs.core.PersistentVector(null, 4, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$section,new cljs.core.PersistentArrayMap(null, 1, [cljs.core.cst$kw$padding,(garden.units.rem.cljs$core$IFn$_invoke$arity$1 ? garden.units.rem.cljs$core$IFn$_invoke$arity$1((1)) : garden.units.rem.call(null,(1)))], null),new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$ul,new cljs.core.PersistentArrayMap(null, 1, [cljs.core.cst$kw$padding,(0)], null)], null),new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$li,new cljs.core.PersistentArrayMap(null, 2, [cljs.core.cst$kw$line_DASH_height,1.3,cljs.core.cst$kw$list_DASH_style,cljs.core.cst$kw$none], null)], null)], null)], null),garden.stylesheet.at_media.cljs$core$IFn$_invoke$arity$variadic(new cljs.core.PersistentArrayMap(null, 1, [cljs.core.cst$kw$max_DASH_width,(garden.units.px.cljs$core$IFn$_invoke$arity$1 ? garden.units.px.cljs$core$IFn$_invoke$arity$1((767)) : garden.units.px.call(null,(767)))], null),cljs.core.array_seq([new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$$jumbotron,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$h1,new cljs.core.PersistentArrayMap(null, 1, [cljs.core.cst$kw$font_DASH_size,(garden.units.rem.cljs$core$IFn$_invoke$arity$1 ? garden.units.rem.cljs$core$IFn$_invoke$arity$1(2.75) : garden.units.rem.call(null,2.75))], null)], null)], null)], 0)),garden.stylesheet.at_media.cljs$core$IFn$_invoke$arity$variadic(new cljs.core.PersistentArrayMap(null, 1, [cljs.core.cst$kw$max_DASH_width,(garden.units.px.cljs$core$IFn$_invoke$arity$1 ? garden.units.px.cljs$core$IFn$_invoke$arity$1((1023)) : garden.units.px.call(null,(1023)))], null),cljs.core.array_seq([new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$$columns,new cljs.core.PersistentArrayMap(null, 1, [cljs.core.cst$kw$flex_DASH_direction,cljs.core.cst$kw$column], null)], null)], 0)),garden.stylesheet.at_media.cljs$core$IFn$_invoke$arity$variadic(new cljs.core.PersistentArrayMap(null, 2, [cljs.core.cst$kw$min_DASH_width,(garden.units.px.cljs$core$IFn$_invoke$arity$1 ? garden.units.px.cljs$core$IFn$_invoke$arity$1((736)) : garden.units.px.call(null,(736))),cljs.core.cst$kw$max_DASH_width,(garden.units.px.cljs$core$IFn$_invoke$arity$1 ? garden.units.px.cljs$core$IFn$_invoke$arity$1((1023)) : garden.units.px.call(null,(1023)))], null),cljs.core.array_seq([new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$aside,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$li$company,new cljs.core.PersistentArrayMap(null, 2, [cljs.core.cst$kw$display,cljs.core.cst$kw$inline_DASH_block,cljs.core.cst$kw$margin_DASH_right,(garden.units.rem.cljs$core$IFn$_invoke$arity$1 ? garden.units.rem.cljs$core$IFn$_invoke$arity$1((3)) : garden.units.rem.call(null,(3)))], null)], null)], null)], 0)),garden.stylesheet.at_media.cljs$core$IFn$_invoke$arity$variadic(new cljs.core.PersistentArrayMap(null, 1, [cljs.core.cst$kw$min_DASH_width,(garden.units.px.cljs$core$IFn$_invoke$arity$1 ? garden.units.px.cljs$core$IFn$_invoke$arity$1((737)) : garden.units.px.call(null,(737)))], null),cljs.core.array_seq([new cljs.core.PersistentVector(null, 3, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$$content,new cljs.core.PersistentArrayMap(null, 2, [cljs.core.cst$kw$display,cljs.core.cst$kw$flex,cljs.core.cst$kw$flex_DASH_direction,cljs.core.cst$kw$row], null),new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$section,new cljs.core.PersistentArrayMap(null, 1, [cljs.core.cst$kw$flex,(1)], null)], null)], null)], 0))], null);
huiyin.components.sections.css = new cljs.core.PersistentVector(null, 5, 5, cljs.core.PersistentVector.EMPTY_NODE, [huiyin.components.sections.company_style,huiyin.components.sections.member_card,huiyin.components.sections.section_layout,huiyin.components.jumbotron.css,huiyin.components.member.css], null);
