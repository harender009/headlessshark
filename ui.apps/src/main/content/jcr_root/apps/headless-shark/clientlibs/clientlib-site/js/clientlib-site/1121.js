(self.webpackChunkskyplus_container_app=self.webpackChunkskyplus_container_app||[]).push([[1121,5397,4879,7502,8322,5571,5372,1093,1067],{8522:function(e,t){"use strict";const n={get:function(e="",t=!1){const n=`${e}=`,i=document.cookie.split(";");for(let e of i){let i=e;for(;" "==i.charAt(0);)i=i.substring(1,i.length);if(0===i.indexOf(n)){const e=i.substring(n.length,i.length);return t?JSON.parse(e):e}}},remove:function(e){const t=n.get(e);return document.cookie=`${e}=; path=/; expires=Thu, 01 Jan 1970 00:00:01 GMT;`,t},set:function(e,t,n,i){let o="",r="";if(i){const e=new Date;e.setTime(e.getTime()+i),o=`; expires=${e.toUTCString()}`}n&&(r=`; domain=${n}`),document.cookie=`${e}=${JSON.stringify(t)}${o}${r};path=/`}};t.Z=n},1121:function(e,t,n){"use strict";n.r(t),n.d(t,{default:function(){return L}});n(8862),n(1703);var i=n(8416),o=n.n(i),r=n(745),a=(n(9601),n(7852),n(8309),n(2526),n(1817),n(1539),n(2165),n(6992),n(8783),n(3948),n(7658),n(7042),n(1038),n(4916),n(7601),n(3210),n(1249),n(1067)),l=function(e){var t,n,r,l,u=e.labels,s=e.onClick,c=e.loggedIn,g=e.onClickButton,_=e.authUserCookie,f=e.handleLogoutClick,p=e.showLoggedInPopup,d=e.toggleLoggedInPopup,m=((null==_||null===(t=_.name)||void 0===t?void 0:t.first)+" "+(null==_||null===(n=_.name)||void 0===n?void 0:n.last)).trim();return c?o().createElement("div",{className:"skyplus6e-header__link-loggedin-container"},o().createElement("button",{onClick:d,className:"skyplus6e-header__link-loggedin-container__button"},o().createElement("span",{className:"skyplus6e-header__link-loggedin-container__button__text"},(null==m||null===(r=m.charAt(0))||void 0===r?void 0:r.toUpperCase())||""),o().createElement("i",{className:"skp-iconmoon-icon icon-arrow skyplus6e-header__link-loggedin-container__button__icon"})),p?o().createElement("div",{className:"skyplus6e-header__link-loggedin-container__options-list "+(p?"show":"")},o().createElement("ul",{className:"skyplus6e-header__link-loggedin-container__options-list__items"},o().createElement("li",{className:"skyplus6e-header__link-loggedin-container__options-list__items__item"},o().createElement("div",{className:"skyplus6e-header__link-loggedin-container__options-list__items__item__view-profile"},o().createElement("span",{className:"skyplus6e-header__link-loggedin-container__options-list__items__item__view-profile__initial"},(null==m?void 0:m.charAt(0).toUpperCase())||""),o().createElement("div",{className:"skyplus6e-header__link-loggedin-container__options-list__items__item__view-profile__inner"},o().createElement("p",{className:"user-name"},m||""),o().createElement("p",null,o().createElement("a",{className:"view-profile-link",href:"#"},u.viewProfileLabel||""))))),u.navigationAfterLoginItems&&Array.isArray(u.navigationAfterLoginItems)?u.navigationAfterLoginItems.map((function(e){return o().createElement("li",{key:e.navigationLoginItemPath||e.navigationLoginItemLabel,className:"skyplus6e-header__link-loggedin-container__options-list__items__item"},o().createElement("div",{className:"skyplus6e-header__link-loggedin-container__options-list__items__item__content"},o().createElement("a",{className:"content__link",href:e.navigationLoginItemPath||"#"},o().createElement("span",null,e.navigationLoginItemLabel||""))))})):null,o().createElement("li",{className:"skyplus6e-header__link-loggedin-container__options-list__items__item"},o().createElement("button",{onClick:f,className:"skyplus6e-header__link-loggedin-container__options-list__items__item__content logout-button"},o().createElement("span",{className:"content__link"},(null==u?void 0:u.logOutLabel)||""))))):null):"true"===u.loginPopup?o().createElement("button",{onClick:g,"data-login-type":"loginPopup",className:"skyplus6e-header__persona-login-button"},(null==u?void 0:u.navigationLoginLabel)||""):o().createElement(i.Fragment,null,o().createElement("a",{"data-noclick":"true",onClick:function(e){return e.preventDefault()},href:(null==u?void 0:u.navigationLoginPath)||"#",className:"skyplus6e-header__link-no-mobile"},o().createElement("span",null,(null==u?void 0:u.navigationLoginLabel)||""),o().createElement("i",{className:"icon-arrow"})),o().createElement("a",{onClick:s,"data-noclick":"true",className:"skyplus6e-header__link-mobile",href:(null==u?void 0:u.navigationLoginPath)||"#"},o().createElement("span",null,(null==u?void 0:u.navigationLoginLabel)||""),o().createElement("i",{className:"icon-arrow"})),o().createElement("div",{className:"skyplus6e-header__nav-inner-wrapper"},o().createElement("ul",{className:"skyplus6e-header__nav-items-inner"},null==u||null===(l=u.navigationLoginItems)||void 0===l?void 0:l.map((function(e,t){return o().createElement("li",{className:"skyplus6e-header__nav-item-inner",key:""+(null==e?void 0:e.navigationLoginItemLabel)+t},o().createElement("a",{onClick:s,"data-login-type":"true"===e.loginPopup?"loginPopup":null,href:(0,a.addHTMLExtension)(null==e?void 0:e.navigationLoginItemPath)||"#"},(null==e?void 0:e.navigationLoginItemLabel)||""))})))))},u=n(5397),s=n(1093),c=n(8522);function g(e,t){return function(e){if(Array.isArray(e))return e}(e)||function(e,t){var n=null==e?null:"undefined"!=typeof Symbol&&e[Symbol.iterator]||e["@@iterator"];if(null==n)return;var i,o,r=[],a=!0,l=!1;try{for(n=n.call(e);!(a=(i=n.next()).done)&&(r.push(i.value),!t||r.length!==t);a=!0);}catch(e){l=!0,o=e}finally{try{a||null==n.return||n.return()}finally{if(l)throw o}}return r}(e,t)||function(e,t){if(!e)return;if("string"==typeof e)return _(e,t);var n=Object.prototype.toString.call(e).slice(8,-1);"Object"===n&&e.constructor&&(n=e.constructor.name);if("Map"===n||"Set"===n)return Array.from(e);if("Arguments"===n||/^(?:Ui|I)nt(?:8|16|32)(?:Clamped)?Array$/.test(n))return _(e,t)}(e,t)||function(){throw new TypeError("Invalid attempt to destructure non-iterable instance.\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method.")}()}function _(e,t){(null==t||t>e.length)&&(t=e.length);for(var n=0,i=new Array(t);n<t;n++)i[n]=e[n];return i}var f=function(e){return new CustomEvent(s.events.TOGGLE_LOGIN_POPUP,e)},p=function(e){return new CustomEvent(s.events.LOGOUT_SUCCESS,e)},d=function(e){var t={},n=e.mfData,o=g((0,i.useState)(!1),2),r=o[0],a=o[1],_=g((0,i.useState)(!1),2),d=_[0],m=_[1];try{t=JSON.parse(n)}catch(e){t={}}var v=c.Z.get("auth_user")||null;if(v)try{v=JSON.parse(v)}catch(e){v={}}var E=function(e){return a((function(e){return!0}))},h=function(e){a((function(e){return!1}))};return(0,i.useEffect)((function(){return v&&v.name&&a((function(e){return!0})),document.addEventListener(s.events.LOGOUT_SUCCESS,h),document.addEventListener(s.events.LOGIN_SUCCESS,E),function(){document.removeEventListener(s.events.LOGOUT_SUCCESS,h),document.removeEventListener(s.events.LOGIN_SUCCESS,E)}}),[]),l({labels:t,onClick:function(e){var t;"true"===e.target.dataset.noclick?(e.target.dispatchEvent((t={bubbles:!0},new CustomEvent(s.events.LOGIN_BUTTON_DROPDOWN_TOGGLED,t))),e.target.classList.toggle("opened")):e.target.href.endsWith("#")&&(e.preventDefault(),e.target.dispatchEvent(f({bubbles:!0,detail:e.target.dataset})))},loggedIn:r,onClickButton:function(e){e.stopPropagation(),e.target.dispatchEvent(f({bubbles:!0,detail:e.target.dataset}))},authUserCookie:v,handleLogoutClick:function(e){var t,n=c.Z.get("auth_token");(0,u.logoutCurrentUser)(null===(t=JSON.parse(n))||void 0===t?void 0:t.token).then((function(e){200!=e.status&&440!=e.status||document.dispatchEvent(p({bubbles:!0}))})).catch((function(e){document.dispatchEvent(p({bubbles:!0}))}))},showLoggedInPopup:d,toggleLoggedInPopup:function(e){m((function(e){return!e}))}})},m=null;function v(e){var t=(0,i.useRef)(null);return(0,i.useEffect)((function(){t.current&&function(e,t){null!=e&&(null===m&&(m=(0,r.s)(e)),m.render(o().createElement(d,t)))}(t.current,Object.assign({},e))}),[]),o().createElement("div",{ref:t})}v.defaultProps={mfData:JSON.stringify({creditShellLabel:"Credit Shell",idLabel:"ID",indigoCashLabel:"Indigo Cash",loginPopup:"false",logOutLabel:"Log Out",navigationLoginItems:[{navigationLoginItemLabel:"Corp Connect Admin Login",navigationLoginItemPath:"/content/skyplus6e/language-masters/en/partner-page",loginPopup:"false"},{navigationLoginItemLabel:"Customer Login",navigationLoginItemPath:"",loginPopup:"true"},{navigationLoginItemLabel:"Partner Login",navigationLoginItemPath:"/content/skyplus6e/language-masters/en/home/homepage.html?logintype=loginPopup",loginPopup:"false"}],navigationLoginLabel:"Login",navigationLoginPath:"",navigationAfterLoginItems:[{navigationLoginItemLabel:"My Booking",navigationLoginItemPath:"https://www.goindigo.in/agent/agent-profile.html?linkNav=agent-profile_header#booking",loginPopup:"false"}],viewProfileLabel:"View Profile"})};var E=v;function h(e,t){for(var n=0;n<t.length;n++){var i=t[n];i.enumerable=i.enumerable||!1,i.configurable=!0,"value"in i&&(i.writable=!0),Object.defineProperty(e,i.key,i)}}var L=function(){function e(){!function(e,t){if(!(e instanceof t))throw new TypeError("Cannot call a class as a function")}(this,e)}var t,n,i;return t=e,i=[{key:"init",value:function(e){var t=JSON.parse(JSON.stringify(e.dataset));(0,r.s)(e).render(o().createElement(E,t))}}],(n=null)&&h(t.prototype,n),i&&h(t,i),Object.defineProperty(t,"prototype",{writable:!1}),e}()},5397:function(e,t,n){"use strict";n.r(t),n.d(t,{logoutCurrentUser:function(){return a}});n(1703),n(1539),n(8674);var i=n(5571),o=i.default.BASE_API_URL,r=i.default.LOGOUT_SESSION_API_ENDPOINT,a=function(e){if(!e)throw new Error("logoutCurrentUser: Invalid token while trying to logout the current user.");return fetch(""+o+r,{headers:{Authorization:e,"Content-Type":"application/json"},method:"DELETE"})}},4879:function(e,t,n){"use strict";n.r(t),n.d(t,{CONTENT_TYPE_HEADER:function(){return r},ENDPOINT_HEADER:function(){return a},LOGIN_SUCCESS:function(){return i},TOGGLE_LOGIN_POPUP:function(){return o}});n(9601);var i="loginSuccessEvent",o="toggleLoginPopupEvent",r={"Content-Type":"application/json","Access-Control-Allow-Origin":"*"},a=Object.assign({},r);t.default={LOGIN_SUCCESS:i,ENDPOINT_HEADER:a,TOGGLE_LOGIN_POPUP:o,CONTENT_TYPE_HEADER:r}},7502:function(e,t,n){"use strict";n.r(t),n.d(t,{ANONYMOUS_USER_BODY:function(){return l},BASE_API_URL:function(){return i},CREATE_SESSION_API_ENDPOINT:function(){return o},KEEP_ALIVE_AUTH_TOKEN:function(){return a},LOGOUT_SESSION_API_ENDPOINT:function(){return r}});var i="https://skyplus-dev.goindigo.in",o="/webdigitalapi/IndigoWeb/6esession/create",r="webdigitalapi/IndigoWeb/session/logout",a="/webdigitalapi/IndigoWeb/6esession/KeepAlive",l={strToken:"",subscriptionKey:"S9pIpbp4QxCTs98Nzrmy0A=="};t.default={BASE_API_URL:i,ANONYMOUS_USER_BODY:l,KEEP_ALIVE_AUTH_TOKEN:a,CREATE_SESSION_API_ENDPOINT:o}},8322:function(e,t,n){"use strict";n.r(t),n.d(t,{ANONYMOUS_USER_BODY:function(){return a},BASE_API_URL:function(){return i},CREATE_SESSION_API_ENDPOINT:function(){return o},KEEP_ALIVE_AUTH_TOKEN:function(){return r}});var i="https://ms-qa-skyplus6e.goindigo.in",o="/gettokentest?user_key=58a6d74aa080db2f8e06a52ca41ebb8f",r="/gettokentest?user_key=58a6d74aa080db2f8e06a52ca41ebb8f",a={strToken:"",subscriptionKey:"S9pIpbp4QxCTs98Nzrmy0A=="};t.default={BASE_API_URL:i,ANONYMOUS_USER_BODY:a,KEEP_ALIVE_AUTH_TOKEN:r,CREATE_SESSION_API_ENDPOINT:o}},5571:function(e,t,n){"use strict";n.r(t);var i=n(8322),o=n(7502),r=n(4879),a={qa:i.default,dev:o.default}.dev;for(var l in r.default)a[l]=r.default[l];t.default=a},5372:function(e,t,n){"use strict";n.r(t),t.default={LOGIN_SUCCESS:"loginSuccessEvent",LOGOUT_SUCCESS:"logoutSuccessEvent",TOGGLE_LOGIN_POPUP:"toggleLoginPopupEvent",LOGIN_BUTTON_DROPDOWN_TOGGLED:"loginItemToggledEvent"}},1093:function(e,t,n){"use strict";n.r(t),n.d(t,{customEvents:function(){return o.default},events:function(){return i.default}});var i=n(5372),o=n(8689)},1067:function(e,t,n){"use strict";n.r(t),n.d(t,{addHTMLExtension:function(){return o},getIconClass:function(){return i}});var i=function(e){return e&&e.length&&e.indexOf("/")>0?e.substring(e.lastIndexOf("/")+1):e},o=function(e){return e&&e.length?e.indexOf(".html")>=0?e:e+".html":e}},4964:function(e,t,n){var i=n(5112)("match");e.exports=function(e){var t=/./;try{"/./"[e](t)}catch(n){try{return t[i]=!1,"/./"[e](t)}catch(e){}}return!1}},7850:function(e,t,n){var i=n(111),o=n(4326),r=n(5112)("match");e.exports=function(e){var t;return i(e)&&(void 0!==(t=e[r])?!!t:"RegExp"==o(e))}},3929:function(e,t,n){var i=n(7850),o=TypeError;e.exports=function(e){if(i(e))throw o("The method doesn't accept regular expressions");return e}},1574:function(e,t,n){"use strict";var i=n(9781),o=n(1702),r=n(6916),a=n(7293),l=n(1956),u=n(5181),s=n(5296),c=n(7908),g=n(8361),_=Object.assign,f=Object.defineProperty,p=o([].concat);e.exports=!_||a((function(){if(i&&1!==_({b:1},_(f({},"a",{enumerable:!0,get:function(){f(this,"b",{value:3,enumerable:!1})}}),{b:2})).b)return!0;var e={},t={},n=Symbol(),o="abcdefghijklmnopqrst";return e[n]=7,o.split("").forEach((function(e){t[e]=e})),7!=_({},e)[n]||l(_({},t)).join("")!=o}))?function(e,t){for(var n=c(e),o=arguments.length,a=1,_=u.f,f=s.f;o>a;)for(var d,m=g(arguments[a++]),v=_?p(l(m),_(m)):l(m),E=v.length,h=0;E>h;)d=v[h++],i&&!r(f,m,d)||(n[d]=m[d]);return n}:_},6091:function(e,t,n){var i=n(6530).PROPER,o=n(7293),r=n(1361);e.exports=function(e){return o((function(){return!!r[e]()||"​᠎"!=="​᠎"[e]()||i&&r[e].name!==e}))}},3111:function(e,t,n){var i=n(1702),o=n(4488),r=n(1340),a=n(1361),l=i("".replace),u="["+a+"]",s=RegExp("^"+u+u+"*"),c=RegExp(u+u+"*$"),g=function(e){return function(t){var n=r(o(t));return 1&e&&(n=l(n,s,"")),2&e&&(n=l(n,c,"")),n}};e.exports={start:g(1),end:g(2),trim:g(3)}},1361:function(e){e.exports="\t\n\v\f\r                　\u2028\u2029\ufeff"},1249:function(e,t,n){"use strict";var i=n(2109),o=n(2092).map;i({target:"Array",proto:!0,forced:!n(1194)("map")},{map:function(e){return o(this,e,arguments.length>1?arguments[1]:void 0)}})},9601:function(e,t,n){var i=n(2109),o=n(1574);i({target:"Object",stat:!0,arity:2,forced:Object.assign!==o},{assign:o})},7852:function(e,t,n){"use strict";var i,o=n(2109),r=n(1702),a=n(1236).f,l=n(7466),u=n(1340),s=n(3929),c=n(4488),g=n(4964),_=n(1913),f=r("".endsWith),p=r("".slice),d=Math.min,m=g("endsWith");o({target:"String",proto:!0,forced:!!(_||m||(i=a(String.prototype,"endsWith"),!i||i.writable))&&!m},{endsWith:function(e){var t=u(c(this));s(e);var n=arguments.length>1?arguments[1]:void 0,i=t.length,o=void 0===n?i:d(l(n),i),r=u(e);return f?f(t,r,o):p(t,o-r.length,o)===r}})},3210:function(e,t,n){"use strict";var i=n(2109),o=n(3111).trim;i({target:"String",proto:!0,forced:n(6091)("trim")},{trim:function(){return o(this)}})},745:function(e,t,n){"use strict";var i=n(1051);t.s=i.createRoot,i.hydrateRoot}}]);