(self.webpackChunkskyplus_container_app=self.webpackChunkskyplus_container_app||[]).push([[7139],{47139:function(e,a,n){"use strict";n.r(a);n(74916),n(15306);var r=n(19755);n.n(r)()((function(e){var a,n,r,t,i,o,l;o="data-lang-nav-processed",null!=(l=e(i=".cmp-languagenavigation--header").not("["+o+"='true']"))&&1==l.length&&(e(l).attr(o,!0),n=void 0!==(n=e(i+" .cmp-languagenavigation__item--active > .cmp-languagenavigation__item-link").attr("lang"))?n:"Language",r='<div class="cmp-languagenavigation--langnavtoggle"><a id="langNavToggleHeader" style="background-image:'+(a=void 0!==(a=e(i+" .cmp-languagenavigation__item--level-0.cmp-languagenavigation__item--active").css("background-image"))?a.replace('"',"'").replace('"',"'"):"none")+'" href="#langNavToggle" aria-label="Toggle Language">'+n+"</a></div>",e(l).prepend(r),e("#langNavToggleHeader").click((function(){t=e(this).position().left-240,e(i+" .cmp-languagenavigation").css({left:t}),e(i+" .cmp-languagenavigation").toggleClass("showMenu"),e("#langNavToggleHeader").toggleClass("open")})),window.onclick=function(a){!a.target.matches("#langNavToggleHeader")&&e("#langNavToggleHeader").hasClass("open")&&(e(i+" .cmp-languagenavigation").removeClass("showMenu"),e("#langNavToggleHeader").removeClass("open"))})}))},31530:function(e,a,n){"use strict";var r=n(28710).charAt;e.exports=function(e,a,n){return a+(n?r(e,a).length:1)}},27007:function(e,a,n){"use strict";n(74916);var r=n(1702),t=n(98052),i=n(22261),o=n(47293),l=n(5112),c=n(68880),g=l("species"),u=RegExp.prototype;e.exports=function(e,a,n,v){var s=l(e),p=!o((function(){var a={};return a[s]=function(){return 7},7!=""[e](a)})),f=p&&!o((function(){var a=!1,n=/a/;return"split"===e&&((n={}).constructor={},n.constructor[g]=function(){return n},n.flags="",n[s]=/./[s]),n.exec=function(){return a=!0,null},n[s](""),!a}));if(!p||!f||n){var d=r(/./[s]),h=a(s,""[e],(function(e,a,n,t,o){var l=r(e),c=a.exec;return c===i||c===u.exec?p&&!o?{done:!0,value:d(a,n,t)}:{done:!0,value:l(n,a,t)}:{done:!1}}));t(String.prototype,e,h[0]),t(u,s,h[1])}v&&c(u[s],"sham",!0)}},10647:function(e,a,n){var r=n(1702),t=n(47908),i=Math.floor,o=r("".charAt),l=r("".replace),c=r("".slice),g=/\$([$&'`]|\d{1,2}|<[^>]*>)/g,u=/\$([$&'`]|\d{1,2})/g;e.exports=function(e,a,n,r,v,s){var p=n+e.length,f=r.length,d=u;return void 0!==v&&(v=t(v),d=g),l(s,d,(function(t,l){var g;switch(o(l,0)){case"$":return"$";case"&":return e;case"`":return c(a,0,n);case"'":return c(a,p);case"<":g=v[c(l,1,-1)];break;default:var u=+l;if(0===u)return t;if(u>f){var s=i(u/10);return 0===s?t:s<=f?void 0===r[s-1]?o(l,1):r[s-1]+o(l,1):t}g=r[u-1]}return void 0===g?"":g}))}},97651:function(e,a,n){var r=n(46916),t=n(19670),i=n(60614),o=n(84326),l=n(22261),c=TypeError;e.exports=function(e,a){var n=e.exec;if(i(n)){var g=r(n,e,a);return null!==g&&t(g),g}if("RegExp"===o(e))return r(l,e,a);throw c("RegExp#exec called on incompatible receiver")}},15306:function(e,a,n){"use strict";var r=n(22104),t=n(46916),i=n(1702),o=n(27007),l=n(47293),c=n(19670),g=n(60614),u=n(68554),v=n(19303),s=n(17466),p=n(41340),f=n(84488),d=n(31530),h=n(58173),m=n(10647),x=n(97651),k=n(5112)("replace"),$=Math.max,_=Math.min,b=i([].concat),T=i([].push),w=i("".indexOf),y=i("".slice),C="$0"==="a".replace(/./,"$0"),N=!!/./[k]&&""===/./[k]("a","$0");o("replace",(function(e,a,n){var i=N?"$":"$0";return[function(e,n){var r=f(this),i=u(e)?void 0:h(e,k);return i?t(i,e,r,n):t(a,p(r),e,n)},function(e,t){var o=c(this),l=p(e);if("string"==typeof t&&-1===w(t,i)&&-1===w(t,"$<")){var u=n(a,o,l,t);if(u.done)return u.value}var f=g(t);f||(t=p(t));var h=o.global;if(h){var k=o.unicode;o.lastIndex=0}for(var C=[];;){var N=x(o,l);if(null===N)break;if(T(C,N),!h)break;""===p(N[0])&&(o.lastIndex=d(l,s(o.lastIndex),k))}for(var H,M="",E=0,I=0;I<C.length;I++){for(var R=p((N=C[I])[0]),A=$(_(v(N.index),l.length),0),L=[],S=1;S<N.length;S++)T(L,void 0===(H=N[S])?H:String(H));var O=N.groups;if(f){var j=b([R],L,A,l);void 0!==O&&T(j,O);var q=p(r(t,void 0,j))}else q=m(R,l,A,L,O,t);A>=E&&(M+=y(l,E,A)+q,E=A+R.length)}return M+y(l,E)}]}),!!l((function(){var e=/./;return e.exec=function(){var e=[];return e.groups={a:"7"},e},"7"!=="".replace(e,"$<a>")}))||!C||N)}}]);