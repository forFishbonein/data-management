import Vue from "vue";
import App from "./App";
import router from "./router";
import VueRouter from "vue-router";
import "./assets/font/iconfont.css";

// import ElementUI from "element-ui";
// import "element-ui/lib/theme-chalk/index.css";
// Vue.use(ElementUI);
import store from "./store";
import { Pagination, Message } from "element-ui";
Vue.use(Pagination);
Vue.use(Message);

Vue.config.productionTip = false;

new Vue({
  el: "#app",
  // axios,
  router,
  store,
  components: { App },
  template: "<App/>"
  // beforeCreate() {
  //   Vue.prototype.$bus = this;
  // }
});
