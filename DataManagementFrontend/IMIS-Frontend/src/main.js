import Vue from "vue";
import VueRouter from "vue-router";
import App from "./App";
import router from "./router";
import "./assets/font/iconfont.css";


import store from "./store";
import { Pagination, Message, MessageBox } from "element-ui";
Vue.use(Pagination);
Vue.prototype.$message = Message;
Vue.prototype.$prompt = MessageBox;

Vue.config.productionTip = false;

Vue.use(VueRouter);

new Vue({
  el: "#app",
  router,
  store,
  components: { App },
  template: "<App/>"
});
