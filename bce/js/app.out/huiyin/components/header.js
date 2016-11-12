// Compiled by ClojureScript 1.8.51 {:static-fns true, :optimize-constants true}
goog.provide('huiyin.components.header');
goog.require('cljs.core');
goog.require('goog.dom');
goog.require('garden.units');
goog.require('reagent.core');
goog.require('goog.events.EventType');
goog.require('goog.events');
goog.require('huiyin.data');
goog.require('garden.stylesheet');
goog.require('garden.color');
goog.require('huiyin.variables');
goog.require('clojure.string');
huiyin.components.header.logo_size = (64);
huiyin.components.header.logo_circle = (3);
huiyin.components.header.logo_color = "#E00000";
huiyin.components.header.dimmer_color = garden.color.rgba.cljs$core$IFn$_invoke$arity$4((0),(0),(0),0.82);
huiyin.components.header.header_compact_threshold = (140);

/**
* @constructor
 * @implements {cljs.core.IRecord}
 * @implements {cljs.core.IEquiv}
 * @implements {cljs.core.IHash}
 * @implements {cljs.core.ICollection}
 * @implements {huiyin.components.header.Object}
 * @implements {cljs.core.ICounted}
 * @implements {cljs.core.ISeqable}
 * @implements {cljs.core.IMeta}
 * @implements {cljs.core.ICloneable}
 * @implements {cljs.core.IPrintWithWriter}
 * @implements {cljs.core.IIterable}
 * @implements {cljs.core.IWithMeta}
 * @implements {cljs.core.IAssociative}
 * @implements {cljs.core.IMap}
 * @implements {cljs.core.ILookup}
*/
huiyin.components.header.Point = (function (x,y,__meta,__extmap,__hash){
this.x = x;
this.y = y;
this.__meta = __meta;
this.__extmap = __extmap;
this.__hash = __hash;
this.cljs$lang$protocol_mask$partition0$ = 2229667594;
this.cljs$lang$protocol_mask$partition1$ = 8192;
})
huiyin.components.header.Point.prototype.toString = (function (){
var self__ = this;
var _ = this;
return clojure.string.join.cljs$core$IFn$_invoke$arity$2(",",new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [self__.x,self__.y], null));
});

huiyin.components.header.Point.prototype.cljs$core$ILookup$_lookup$arity$2 = (function (this__7162__auto__,k__7163__auto__){
var self__ = this;
var this__7162__auto____$1 = this;
return cljs.core._lookup.cljs$core$IFn$_invoke$arity$3(this__7162__auto____$1,k__7163__auto__,null);
});

huiyin.components.header.Point.prototype.cljs$core$ILookup$_lookup$arity$3 = (function (this__7164__auto__,k13977,else__7165__auto__){
var self__ = this;
var this__7164__auto____$1 = this;
var G__13979 = (((k13977 instanceof cljs.core.Keyword))?k13977.fqn:null);
switch (G__13979) {
case "x":
return self__.x;

break;
case "y":
return self__.y;

break;
default:
return cljs.core.get.cljs$core$IFn$_invoke$arity$3(self__.__extmap,k13977,else__7165__auto__);

}
});

huiyin.components.header.Point.prototype.cljs$core$IPrintWithWriter$_pr_writer$arity$3 = (function (this__7176__auto__,writer__7177__auto__,opts__7178__auto__){
var self__ = this;
var this__7176__auto____$1 = this;
var pr_pair__7179__auto__ = ((function (this__7176__auto____$1){
return (function (keyval__7180__auto__){
return cljs.core.pr_sequential_writer(writer__7177__auto__,cljs.core.pr_writer,""," ","",opts__7178__auto__,keyval__7180__auto__);
});})(this__7176__auto____$1))
;
return cljs.core.pr_sequential_writer(writer__7177__auto__,pr_pair__7179__auto__,"#huiyin.components.header.Point{",", ","}",opts__7178__auto__,cljs.core.concat.cljs$core$IFn$_invoke$arity$2(new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [(new cljs.core.PersistentVector(null,2,(5),cljs.core.PersistentVector.EMPTY_NODE,[cljs.core.cst$kw$x,self__.x],null)),(new cljs.core.PersistentVector(null,2,(5),cljs.core.PersistentVector.EMPTY_NODE,[cljs.core.cst$kw$y,self__.y],null))], null),self__.__extmap));
});

huiyin.components.header.Point.prototype.cljs$core$IIterable$ = true;

huiyin.components.header.Point.prototype.cljs$core$IIterable$_iterator$arity$1 = (function (G__13976){
var self__ = this;
var G__13976__$1 = this;
return (new cljs.core.RecordIter((0),G__13976__$1,2,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$x,cljs.core.cst$kw$y], null),cljs.core._iterator(self__.__extmap)));
});

huiyin.components.header.Point.prototype.cljs$core$IMeta$_meta$arity$1 = (function (this__7160__auto__){
var self__ = this;
var this__7160__auto____$1 = this;
return self__.__meta;
});

huiyin.components.header.Point.prototype.cljs$core$ICloneable$_clone$arity$1 = (function (this__7156__auto__){
var self__ = this;
var this__7156__auto____$1 = this;
return (new huiyin.components.header.Point(self__.x,self__.y,self__.__meta,self__.__extmap,self__.__hash));
});

huiyin.components.header.Point.prototype.cljs$core$ICounted$_count$arity$1 = (function (this__7166__auto__){
var self__ = this;
var this__7166__auto____$1 = this;
return (2 + cljs.core.count(self__.__extmap));
});

huiyin.components.header.Point.prototype.cljs$core$IHash$_hash$arity$1 = (function (this__7157__auto__){
var self__ = this;
var this__7157__auto____$1 = this;
var h__6975__auto__ = self__.__hash;
if(!((h__6975__auto__ == null))){
return h__6975__auto__;
} else {
var h__6975__auto____$1 = cljs.core.hash_imap(this__7157__auto____$1);
self__.__hash = h__6975__auto____$1;

return h__6975__auto____$1;
}
});

huiyin.components.header.Point.prototype.cljs$core$IEquiv$_equiv$arity$2 = (function (this__7158__auto__,other__7159__auto__){
var self__ = this;
var this__7158__auto____$1 = this;
if(cljs.core.truth_((function (){var and__6528__auto__ = other__7159__auto__;
if(cljs.core.truth_(and__6528__auto__)){
var and__6528__auto____$1 = (this__7158__auto____$1.constructor === other__7159__auto__.constructor);
if(and__6528__auto____$1){
return cljs.core.equiv_map(this__7158__auto____$1,other__7159__auto__);
} else {
return and__6528__auto____$1;
}
} else {
return and__6528__auto__;
}
})())){
return true;
} else {
return false;
}
});

huiyin.components.header.Point.prototype.cljs$core$IMap$_dissoc$arity$2 = (function (this__7171__auto__,k__7172__auto__){
var self__ = this;
var this__7171__auto____$1 = this;
if(cljs.core.contains_QMARK_(new cljs.core.PersistentHashSet(null, new cljs.core.PersistentArrayMap(null, 2, [cljs.core.cst$kw$y,null,cljs.core.cst$kw$x,null], null), null),k__7172__auto__)){
return cljs.core.dissoc.cljs$core$IFn$_invoke$arity$2(cljs.core.with_meta(cljs.core.into.cljs$core$IFn$_invoke$arity$2(cljs.core.PersistentArrayMap.EMPTY,this__7171__auto____$1),self__.__meta),k__7172__auto__);
} else {
return (new huiyin.components.header.Point(self__.x,self__.y,self__.__meta,cljs.core.not_empty(cljs.core.dissoc.cljs$core$IFn$_invoke$arity$2(self__.__extmap,k__7172__auto__)),null));
}
});

huiyin.components.header.Point.prototype.cljs$core$IAssociative$_assoc$arity$3 = (function (this__7169__auto__,k__7170__auto__,G__13976){
var self__ = this;
var this__7169__auto____$1 = this;
var pred__13980 = cljs.core.keyword_identical_QMARK_;
var expr__13981 = k__7170__auto__;
if(cljs.core.truth_((pred__13980.cljs$core$IFn$_invoke$arity$2 ? pred__13980.cljs$core$IFn$_invoke$arity$2(cljs.core.cst$kw$x,expr__13981) : pred__13980.call(null,cljs.core.cst$kw$x,expr__13981)))){
return (new huiyin.components.header.Point(G__13976,self__.y,self__.__meta,self__.__extmap,null));
} else {
if(cljs.core.truth_((pred__13980.cljs$core$IFn$_invoke$arity$2 ? pred__13980.cljs$core$IFn$_invoke$arity$2(cljs.core.cst$kw$y,expr__13981) : pred__13980.call(null,cljs.core.cst$kw$y,expr__13981)))){
return (new huiyin.components.header.Point(self__.x,G__13976,self__.__meta,self__.__extmap,null));
} else {
return (new huiyin.components.header.Point(self__.x,self__.y,self__.__meta,cljs.core.assoc.cljs$core$IFn$_invoke$arity$3(self__.__extmap,k__7170__auto__,G__13976),null));
}
}
});

huiyin.components.header.Point.prototype.cljs$core$ISeqable$_seq$arity$1 = (function (this__7174__auto__){
var self__ = this;
var this__7174__auto____$1 = this;
return cljs.core.seq(cljs.core.concat.cljs$core$IFn$_invoke$arity$2(new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [(new cljs.core.PersistentVector(null,2,(5),cljs.core.PersistentVector.EMPTY_NODE,[cljs.core.cst$kw$x,self__.x],null)),(new cljs.core.PersistentVector(null,2,(5),cljs.core.PersistentVector.EMPTY_NODE,[cljs.core.cst$kw$y,self__.y],null))], null),self__.__extmap));
});

huiyin.components.header.Point.prototype.cljs$core$IWithMeta$_with_meta$arity$2 = (function (this__7161__auto__,G__13976){
var self__ = this;
var this__7161__auto____$1 = this;
return (new huiyin.components.header.Point(self__.x,self__.y,G__13976,self__.__extmap,self__.__hash));
});

huiyin.components.header.Point.prototype.cljs$core$ICollection$_conj$arity$2 = (function (this__7167__auto__,entry__7168__auto__){
var self__ = this;
var this__7167__auto____$1 = this;
if(cljs.core.vector_QMARK_(entry__7168__auto__)){
return cljs.core._assoc(this__7167__auto____$1,cljs.core._nth.cljs$core$IFn$_invoke$arity$2(entry__7168__auto__,(0)),cljs.core._nth.cljs$core$IFn$_invoke$arity$2(entry__7168__auto__,(1)));
} else {
return cljs.core.reduce.cljs$core$IFn$_invoke$arity$3(cljs.core._conj,this__7167__auto____$1,entry__7168__auto__);
}
});

huiyin.components.header.Point.getBasis = (function (){
return new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$sym$x,cljs.core.cst$sym$y], null);
});

huiyin.components.header.Point.cljs$lang$type = true;

huiyin.components.header.Point.cljs$lang$ctorPrSeq = (function (this__7196__auto__){
return cljs.core._conj(cljs.core.List.EMPTY,"huiyin.components.header/Point");
});

huiyin.components.header.Point.cljs$lang$ctorPrWriter = (function (this__7196__auto__,writer__7197__auto__){
return cljs.core._write(writer__7197__auto__,"huiyin.components.header/Point");
});

huiyin.components.header.__GT_Point = (function huiyin$components$header$__GT_Point(x,y){
return (new huiyin.components.header.Point(x,y,null,null,null));
});

huiyin.components.header.map__GT_Point = (function huiyin$components$header$map__GT_Point(G__13978){
return (new huiyin.components.header.Point(cljs.core.cst$kw$x.cljs$core$IFn$_invoke$arity$1(G__13978),cljs.core.cst$kw$y.cljs$core$IFn$_invoke$arity$1(G__13978),null,cljs.core.dissoc.cljs$core$IFn$_invoke$arity$variadic(G__13978,cljs.core.cst$kw$x,cljs.core.array_seq([cljs.core.cst$kw$y], 0)),null));
});

huiyin.components.header.render_logo = (function huiyin$components$header$render_logo(diameter,border){
var radius = (diameter / (2));
var inner = (radius - border);
var offset = (inner / Math.sqrt((2)));
var c1 = huiyin.components.header.__GT_Point(radius,radius);
var c2 = huiyin.components.header.__GT_Point(inner,inner);
var r1 = huiyin.components.header.__GT_Point(radius,(0));
var r2 = huiyin.components.header.__GT_Point(radius,diameter);
var p1 = huiyin.components.header.__GT_Point(radius,border);
var p2 = huiyin.components.header.__GT_Point((radius + offset),(radius + offset));
var p3 = huiyin.components.header.__GT_Point((radius - offset),(radius + offset));
var p4 = huiyin.components.header.__GT_Point(radius,(radius + (offset / (2))));
return clojure.string.join.cljs$core$IFn$_invoke$arity$2(" ",cljs.core.PersistentVector.fromArray(["M",r1,"A",c1,"0 0 1",r2,"A",c1,"0 0 1",r1,"Z","M",p2,"A",c2,"0 0 0",p1,"Z","M",p1,"A",c2,"0 0 0",p3,"Z","M",p3,"A",c2,"0 0 0",p2,"L",p4,"Z"], true));
});
huiyin.components.header.get_scroll_offset = (function huiyin$components$header$get_scroll_offset(){
var offset = goog.dom.getDocumentScroll();
return new cljs.core.PersistentArrayMap(null, 2, [cljs.core.cst$kw$x,offset.x,cljs.core.cst$kw$y,offset.y], null);
});

huiyin.components.header.scroll_state = reagent.core.atom.cljs$core$IFn$_invoke$arity$1(new cljs.core.PersistentArrayMap(null, 1, [cljs.core.cst$kw$offset,huiyin.components.header.get_scroll_offset()], null));

var G__13984_13987 = window;
var G__13985_13988 = goog.events.EventType.SCROLL;
var G__13986_13989 = ((function (G__13984_13987,G__13985_13988){
return (function (){
return cljs.core.swap_BANG_.cljs$core$IFn$_invoke$arity$4(huiyin.components.header.scroll_state,cljs.core.assoc,cljs.core.cst$kw$offset,huiyin.components.header.get_scroll_offset());
});})(G__13984_13987,G__13985_13988))
;
goog.events.listen(G__13984_13987,G__13985_13988,G__13986_13989);
huiyin.components.header.render = (function huiyin$components$header$render(state){
var offset_y = cljs.core.get_in.cljs$core$IFn$_invoke$arity$2((cljs.core.deref.cljs$core$IFn$_invoke$arity$1 ? cljs.core.deref.cljs$core$IFn$_invoke$arity$1(huiyin.components.header.scroll_state) : cljs.core.deref.call(null,huiyin.components.header.scroll_state)),new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$offset,cljs.core.cst$kw$y], null));
var compact_QMARK_ = (offset_y > huiyin.components.header.header_compact_threshold);
return new cljs.core.PersistentVector(null, 3, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$header,new cljs.core.PersistentArrayMap(null, 1, [cljs.core.cst$kw$class_DASH_name,((compact_QMARK_)?cljs.core.cst$kw$compact:null)], null),new cljs.core.PersistentVector(null, 3, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$div$container,new cljs.core.PersistentVector(null, 3, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$div_SHARP_logo,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$svg,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$path,new cljs.core.PersistentArrayMap(null, 1, [cljs.core.cst$kw$d,huiyin.components.header.render_logo(huiyin.components.header.logo_size,huiyin.components.header.logo_circle)], null)], null)], null),new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$h1,cljs.core.cst$kw$title.cljs$core$IFn$_invoke$arity$1(huiyin.data.messages)], null)], null),new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$nav,(function (){var iter__7320__auto__ = ((function (offset_y,compact_QMARK_){
return (function huiyin$components$header$render_$_iter__14004(s__14005){
return (new cljs.core.LazySeq(null,((function (offset_y,compact_QMARK_){
return (function (){
var s__14005__$1 = s__14005;
while(true){
var temp__4657__auto__ = cljs.core.seq(s__14005__$1);
if(temp__4657__auto__){
var s__14005__$2 = temp__4657__auto__;
if(cljs.core.chunked_seq_QMARK_(s__14005__$2)){
var c__7318__auto__ = cljs.core.chunk_first(s__14005__$2);
var size__7319__auto__ = cljs.core.count(c__7318__auto__);
var b__14007 = cljs.core.chunk_buffer(size__7319__auto__);
if((function (){var i__14006 = (0);
while(true){
if((i__14006 < size__7319__auto__)){
var map__14014 = cljs.core._nth.cljs$core$IFn$_invoke$arity$2(c__7318__auto__,i__14006);
var map__14014__$1 = ((((!((map__14014 == null)))?((((map__14014.cljs$lang$protocol_mask$partition0$ & (64))) || (map__14014.cljs$core$ISeq$))?true:false):false))?cljs.core.apply.cljs$core$IFn$_invoke$arity$2(cljs.core.hash_map,map__14014):map__14014);
var href = cljs.core.get.cljs$core$IFn$_invoke$arity$2(map__14014__$1,cljs.core.cst$kw$href);
var text = cljs.core.get.cljs$core$IFn$_invoke$arity$2(map__14014__$1,cljs.core.cst$kw$text);
var target = cljs.core.get.cljs$core$IFn$_invoke$arity$2(map__14014__$1,cljs.core.cst$kw$target);
cljs.core.chunk_append(b__14007,cljs.core.with_meta(new cljs.core.PersistentVector(null, 3, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$a$underline,new cljs.core.PersistentArrayMap(null, 2, [cljs.core.cst$kw$href,href,cljs.core.cst$kw$target,target], null),text], null),new cljs.core.PersistentArrayMap(null, 1, [cljs.core.cst$kw$key,href], null)));

var G__14018 = (i__14006 + (1));
i__14006 = G__14018;
continue;
} else {
return true;
}
break;
}
})()){
return cljs.core.chunk_cons(cljs.core.chunk(b__14007),huiyin$components$header$render_$_iter__14004(cljs.core.chunk_rest(s__14005__$2)));
} else {
return cljs.core.chunk_cons(cljs.core.chunk(b__14007),null);
}
} else {
var map__14016 = cljs.core.first(s__14005__$2);
var map__14016__$1 = ((((!((map__14016 == null)))?((((map__14016.cljs$lang$protocol_mask$partition0$ & (64))) || (map__14016.cljs$core$ISeq$))?true:false):false))?cljs.core.apply.cljs$core$IFn$_invoke$arity$2(cljs.core.hash_map,map__14016):map__14016);
var href = cljs.core.get.cljs$core$IFn$_invoke$arity$2(map__14016__$1,cljs.core.cst$kw$href);
var text = cljs.core.get.cljs$core$IFn$_invoke$arity$2(map__14016__$1,cljs.core.cst$kw$text);
var target = cljs.core.get.cljs$core$IFn$_invoke$arity$2(map__14016__$1,cljs.core.cst$kw$target);
return cljs.core.cons(cljs.core.with_meta(new cljs.core.PersistentVector(null, 3, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$a$underline,new cljs.core.PersistentArrayMap(null, 2, [cljs.core.cst$kw$href,href,cljs.core.cst$kw$target,target], null),text], null),new cljs.core.PersistentArrayMap(null, 1, [cljs.core.cst$kw$key,href], null)),huiyin$components$header$render_$_iter__14004(cljs.core.rest(s__14005__$2)));
}
} else {
return null;
}
break;
}
});})(offset_y,compact_QMARK_))
,null,null));
});})(offset_y,compact_QMARK_))
;
return iter__7320__auto__(huiyin.data.navigation);
})()], null)], null)], null);
});
huiyin.components.header.tiny_device_style = new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [garden.stylesheet.at_media.cljs$core$IFn$_invoke$arity$variadic(new cljs.core.PersistentArrayMap(null, 1, [cljs.core.cst$kw$max_DASH_width,(garden.units.px.cljs$core$IFn$_invoke$arity$1 ? garden.units.px.cljs$core$IFn$_invoke$arity$1((480)) : garden.units.px.call(null,(480)))], null),cljs.core.array_seq([new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$header,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$a,new cljs.core.PersistentArrayMap(null, 1, [cljs.core.cst$kw$font_DASH_size,(garden.units.px.cljs$core$IFn$_invoke$arity$1 ? garden.units.px.cljs$core$IFn$_invoke$arity$1((16)) : garden.units.px.call(null,(16)))], null)], null)], null),new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$$compact,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$_SHARP_logo,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$svg,new cljs.core.PersistentArrayMap(null, 1, [cljs.core.cst$kw$transform,new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, ["scale(0.78)","translateX(-16px)"], null)], null)], null)], null)], null)], null)], null)], 0))], null);
huiyin.components.header.small_device_style = new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [garden.stylesheet.at_media.cljs$core$IFn$_invoke$arity$variadic(new cljs.core.PersistentArrayMap(null, 1, [cljs.core.cst$kw$max_DASH_width,(garden.units.px.cljs$core$IFn$_invoke$arity$1 ? garden.units.px.cljs$core$IFn$_invoke$arity$1((735)) : garden.units.px.call(null,(735)))], null),cljs.core.array_seq([new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$header,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$h1,new cljs.core.PersistentArrayMap(null, 1, [cljs.core.cst$kw$display,cljs.core.cst$kw$none], null)], null)], null)], null)], 0))], null);
huiyin.components.header.large_device_style = new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [garden.stylesheet.at_media.cljs$core$IFn$_invoke$arity$variadic(new cljs.core.PersistentArrayMap(null, 1, [cljs.core.cst$kw$min_DASH_width,(garden.units.px.cljs$core$IFn$_invoke$arity$1 ? garden.units.px.cljs$core$IFn$_invoke$arity$1((736)) : garden.units.px.call(null,(736)))], null),cljs.core.array_seq([new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$header,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$a,new cljs.core.PersistentArrayMap(null, 2, [cljs.core.cst$kw$font_DASH_size,(garden.units.rem.cljs$core$IFn$_invoke$arity$1 ? garden.units.rem.cljs$core$IFn$_invoke$arity$1(1.1) : garden.units.rem.call(null,1.1)),cljs.core.cst$kw$margin_DASH_right,(garden.units.rem.cljs$core$IFn$_invoke$arity$1 ? garden.units.rem.cljs$core$IFn$_invoke$arity$1(2.5) : garden.units.rem.call(null,2.5))], null)], null)], null)], 0))], null);
huiyin.components.header.normal_style = new cljs.core.PersistentVector(null, 3, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.PersistentVector(null, 5, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$header,new cljs.core.PersistentArrayMap(null, 5, [cljs.core.cst$kw$position,cljs.core.cst$kw$fixed,cljs.core.cst$kw$width,(garden.units.percent.cljs$core$IFn$_invoke$arity$1 ? garden.units.percent.cljs$core$IFn$_invoke$arity$1((100)) : garden.units.percent.call(null,(100))),cljs.core.cst$kw$height,(garden.units.px.cljs$core$IFn$_invoke$arity$1 ? garden.units.px.cljs$core$IFn$_invoke$arity$1((140)) : garden.units.px.call(null,(140))),cljs.core.cst$kw$z_DASH_index,(100),cljs.core.cst$kw$transition,(function (){var iter__7320__auto__ = (function huiyin$components$header$iter__14019(s__14020){
return (new cljs.core.LazySeq(null,(function (){
var s__14020__$1 = s__14020;
while(true){
var temp__4657__auto__ = cljs.core.seq(s__14020__$1);
if(temp__4657__auto__){
var s__14020__$2 = temp__4657__auto__;
if(cljs.core.chunked_seq_QMARK_(s__14020__$2)){
var c__7318__auto__ = cljs.core.chunk_first(s__14020__$2);
var size__7319__auto__ = cljs.core.count(c__7318__auto__);
var b__14022 = cljs.core.chunk_buffer(size__7319__auto__);
if((function (){var i__14021 = (0);
while(true){
if((i__14021 < size__7319__auto__)){
var attr = cljs.core._nth.cljs$core$IFn$_invoke$arity$2(c__7318__auto__,i__14021);
cljs.core.chunk_append(b__14022,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [attr,huiyin.variables.transition_time], null));

var G__14025 = (i__14021 + (1));
i__14021 = G__14025;
continue;
} else {
return true;
}
break;
}
})()){
return cljs.core.chunk_cons(cljs.core.chunk(b__14022),huiyin$components$header$iter__14019(cljs.core.chunk_rest(s__14020__$2)));
} else {
return cljs.core.chunk_cons(cljs.core.chunk(b__14022),null);
}
} else {
var attr = cljs.core.first(s__14020__$2);
return cljs.core.cons(new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [attr,huiyin.variables.transition_time], null),huiyin$components$header$iter__14019(cljs.core.rest(s__14020__$2)));
}
} else {
return null;
}
break;
}
}),null,null));
});
return iter__7320__auto__(new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$height,cljs.core.cst$kw$background_DASH_color], null));
})()], null),new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$$container,new cljs.core.PersistentArrayMap(null, 5, [cljs.core.cst$kw$display,cljs.core.cst$kw$flex,cljs.core.cst$kw$align_DASH_items,cljs.core.cst$kw$center,cljs.core.cst$kw$justify_DASH_content,cljs.core.cst$kw$space_DASH_between,cljs.core.cst$kw$height,(garden.units.percent.cljs$core$IFn$_invoke$arity$1 ? garden.units.percent.cljs$core$IFn$_invoke$arity$1((100)) : garden.units.percent.call(null,(100))),cljs.core.cst$kw$padding,new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.PersistentVector(null, 4, 5, cljs.core.PersistentVector.EMPTY_NODE, [(0),(0),(0),(garden.units.rem.cljs$core$IFn$_invoke$arity$1 ? garden.units.rem.cljs$core$IFn$_invoke$arity$1((1)) : garden.units.rem.call(null,(1)))], null)], null)], null)], null),new cljs.core.PersistentVector(null, 3, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$nav,cljs.core.cst$kw$_SHARP_logo,new cljs.core.PersistentArrayMap(null, 3, [cljs.core.cst$kw$display,cljs.core.cst$kw$flex,cljs.core.cst$kw$flex_DASH_direction,cljs.core.cst$kw$row,cljs.core.cst$kw$align_DASH_items,cljs.core.cst$kw$center], null)], null),new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$a,new cljs.core.PersistentArrayMap(null, 2, [cljs.core.cst$kw$margin_DASH_right,(garden.units.rem.cljs$core$IFn$_invoke$arity$1 ? garden.units.rem.cljs$core$IFn$_invoke$arity$1(1.25) : garden.units.rem.call(null,1.25)),cljs.core.cst$kw$white_DASH_space,cljs.core.cst$kw$nowrap], null)], null)], null),new cljs.core.PersistentVector(null, 3, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$_SHARP_logo,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$svg,new cljs.core.PersistentArrayMap(null, 5, [cljs.core.cst$kw$transition,new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$all,huiyin.variables.transition_time], null)], null),cljs.core.cst$kw$width,(garden.units.px.cljs$core$IFn$_invoke$arity$1 ? garden.units.px.cljs$core$IFn$_invoke$arity$1(huiyin.components.header.logo_size) : garden.units.px.call(null,huiyin.components.header.logo_size)),cljs.core.cst$kw$height,(garden.units.px.cljs$core$IFn$_invoke$arity$1 ? garden.units.px.cljs$core$IFn$_invoke$arity$1(huiyin.components.header.logo_size) : garden.units.px.call(null,huiyin.components.header.logo_size)),cljs.core.cst$kw$fill,huiyin.components.header.logo_color,cljs.core.cst$kw$transform,"scale(1)"], null)], null),new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$h1,new cljs.core.PersistentArrayMap(null, 5, [cljs.core.cst$kw$font_DASH_size,(garden.units.rem.cljs$core$IFn$_invoke$arity$1 ? garden.units.rem.cljs$core$IFn$_invoke$arity$1(1.25) : garden.units.rem.call(null,1.25)),cljs.core.cst$kw$transition,new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$all,huiyin.variables.transition_time], null)], null),cljs.core.cst$kw$margin,new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.PersistentVector(null, 4, 5, cljs.core.PersistentVector.EMPTY_NODE, [(0),(0),(0),(garden.units.px.cljs$core$IFn$_invoke$arity$1 ? garden.units.px.cljs$core$IFn$_invoke$arity$1((16)) : garden.units.px.call(null,(16)))], null)], null),cljs.core.cst$kw$white_DASH_space,cljs.core.cst$kw$nowrap,cljs.core.cst$kw$color,huiyin.components.header.logo_color], null)], null)], null),new cljs.core.PersistentVector(null, 3, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$$compact,new cljs.core.PersistentArrayMap(null, 2, [cljs.core.cst$kw$height,(garden.units.rem.cljs$core$IFn$_invoke$arity$1 ? garden.units.rem.cljs$core$IFn$_invoke$arity$1((4)) : garden.units.rem.call(null,(4))),cljs.core.cst$kw$background_DASH_color,huiyin.components.header.dimmer_color], null),new cljs.core.PersistentVector(null, 3, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$_SHARP_logo,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$svg,new cljs.core.PersistentArrayMap(null, 1, [cljs.core.cst$kw$transform,"scale(0.8) translateX(-8px)"], null)], null),new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$h1,new cljs.core.PersistentArrayMap(null, 1, [cljs.core.cst$kw$transform,"translateX(-16px)"], null)], null)], null)], null)], null);
huiyin.components.header.css = new cljs.core.PersistentVector(null, 4, 5, cljs.core.PersistentVector.EMPTY_NODE, [huiyin.components.header.normal_style,huiyin.components.header.tiny_device_style,huiyin.components.header.small_device_style,huiyin.components.header.large_device_style], null);
