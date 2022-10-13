import Vue from "vue";
import App from "./App";
import router from "./router";
import "./assets/font-search/iconfont.css";

// import ElementUI from "element-ui";
// import "element-ui/lib/theme-chalk/index.css";
// Vue.use(ElementUI);
import { Pagination } from 'element-ui';
Vue.use(Pagination);

Vue.config.productionTip = false;

new Vue({
  el: "#app",
  // axios,
  router,
  components: { App },
  template: "<App/>"
});
