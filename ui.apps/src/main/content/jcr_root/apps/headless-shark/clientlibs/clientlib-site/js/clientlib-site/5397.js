(self.webpackChunkskyplus_container_app=self.webpackChunkskyplus_container_app||[]).push([[5397,4879,7502,8322,5571],{35397:function(n,t,e){"use strict";e.r(t),e.d(t,{logoutCurrentUser:function(){return _}});e(21703),e(41539),e(88674);var r=e(35571),o=r.default.BASE_API_URL,u=r.default.LOGOUT_SESSION_API_ENDPOINT,_=function(n){if(!n)throw new Error("logoutCurrentUser: Invalid token while trying to logout the current user.");return fetch(""+o+u,{headers:{Authorization:n,"Content-Type":"application/json"},method:"DELETE"})}},64879:function(n,t,e){"use strict";e.r(t),e.d(t,{AGENT_LOGOUT_OLD:function(){return A},BASE_API_URL_OLD:function(){return i},CONTENT_TYPE_HEADER:function(){return u},COOKIE_KEYS:function(){return L},ENDPOINT_HEADER:function(){return _},LOGIN_SUCCESS:function(){return r},MEMBER_LOGOUT_OLD:function(){return c},SUB_BASE_API_URL_OLD:function(){return O},SUB_DOMAIN:function(){return E},TOGGLE_LOGIN_POPUP:function(){return o},dotRezAgentroleCk:function(){return f},dotRezLoginCk:function(){return S},dotRezUserCurrencyCk:function(){return s}});e(19601);var r="loginSuccessEvent",o="toggleLoginPopupEvent",u={"Content-Type":"application/json","Access-Control-Allow-Origin":"*"},_=Object.assign({},u),i="https://comm-uat.goindigo.in",O="/IndiGo-Dev2",E=".goindigo.in",c="/Member/Logout",A="/Agent/Logout",S="aemLoginStatus",f="aemOrgRole",s="aemOrgCurrency",L={AUTH:"auth_token",ROLE:"aemLoginStatus",USER:"auth_user"};t.default={LOGIN_SUCCESS:r,ENDPOINT_HEADER:_,TOGGLE_LOGIN_POPUP:o,CONTENT_TYPE_HEADER:u,BASE_API_URL_OLD:i,SUB_BASE_API_URL_OLD:O,SUB_DOMAIN:E,MEMBER_LOGOUT_OLD:c,AGENT_LOGOUT_OLD:A,dotRezLoginCk:S,dotRezAgentroleCk:f,dotRezUserCurrencyCk:s}},7502:function(n,t,e){"use strict";e.r(t),e.d(t,{AGENT_LOGOUT_OLD:function(){return S},ANONYMOUS_USER_BODY:function(){return i},BASE_API_URL:function(){return r},BASE_API_URL_OLD:function(){return O},CREATE_SESSION_API_ENDPOINT:function(){return o},KEEP_ALIVE_AUTH_TOKEN:function(){return _},LOGOUT_SESSION_API_ENDPOINT:function(){return u},MEMBER_LOGOUT_OLD:function(){return A},SUB_BASE_API_URL_OLD:function(){return E},SUB_DOMAIN:function(){return c},dotRezAgentroleCk:function(){return s},dotRezLoginCk:function(){return f},dotRezUserCurrencyCk:function(){return L}});e(19755);var r="https://SkyPlus-dev.goindigo.in/Login_Skyplus",o="/v1/token/create",u="/v1/token/Delete",_="/v1/token/Refresh",i={strToken:"",subscriptionKey:"S9pIpbp4QxCTs98Nzrmy0A=="},O="https://comm-uat.goindigo.in",E="/IndiGo-Dev2",c=".goindigo.in",A="/Member/Logout",S="/Agent/Logout",f="aemLoginStatus",s="aemOrgRole",L="aemOrgCurrency";t.default={BASE_API_URL:r,ANONYMOUS_USER_BODY:i,KEEP_ALIVE_AUTH_TOKEN:_,CREATE_SESSION_API_ENDPOINT:o,LOGOUT_SESSION_API_ENDPOINT:u,BASE_API_URL_OLD:O,SUB_BASE_API_URL_OLD:E,SUB_DOMAIN:c,MEMBER_LOGOUT_OLD:A,AGENT_LOGOUT_OLD:S,dotRezLoginCk:f,dotRezAgentroleCk:s,dotRezUserCurrencyCk:L}},28322:function(n,t,e){"use strict";e.r(t),e.d(t,{ANONYMOUS_USER_BODY:function(){return i},BASE_API_URL:function(){return r},CREATE_SESSION_API_ENDPOINT:function(){return o},KEEP_ALIVE_AUTH_TOKEN:function(){return _},LOGOUT_SESSION_API_ENDPOINT:function(){return u}});var r="https://SkyPlus-dev.goindigo.in/Login_Skyplus",o="/v1/token/create",u="/v1/token/Delete",_="/v1/token/Refresh",i={strToken:"",subscriptionKey:"S9pIpbp4QxCTs98Nzrmy0A=="};t.default={BASE_API_URL:r,ANONYMOUS_USER_BODY:i,KEEP_ALIVE_AUTH_TOKEN:_,CREATE_SESSION_API_ENDPOINT:o,LOGOUT_SESSION_API_ENDPOINT:u}},35571:function(n,t,e){"use strict";e.r(t);var r=e(28322),o=e(7502),u=e(64879),_={qa:r.default,dev:o.default}.dev;for(var i in u.default)_[i]=u.default[i];t.default=_},21574:function(n,t,e){"use strict";var r=e(19781),o=e(1702),u=e(46916),_=e(47293),i=e(81956),O=e(25181),E=e(55296),c=e(47908),A=e(68361),S=Object.assign,f=Object.defineProperty,s=o([].concat);n.exports=!S||_((function(){if(r&&1!==S({b:1},S(f({},"a",{enumerable:!0,get:function(){f(this,"b",{value:3,enumerable:!1})}}),{b:2})).b)return!0;var n={},t={},e=Symbol(),o="abcdefghijklmnopqrst";return n[e]=7,o.split("").forEach((function(n){t[n]=n})),7!=S({},n)[e]||i(S({},t)).join("")!=o}))?function(n,t){for(var e=c(n),o=arguments.length,_=1,S=O.f,f=E.f;o>_;)for(var L,a=A(arguments[_++]),N=S?s(i(a),S(a)):i(a),I=N.length,U=0;I>U;)L=N[U++],r&&!u(f,a,L)||(e[L]=a[L]);return e}:S},19601:function(n,t,e){var r=e(82109),o=e(21574);r({target:"Object",stat:!0,arity:2,forced:Object.assign!==o},{assign:o})}}]);