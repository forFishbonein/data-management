import Vue from "vue";
import VueRouter from "vue-router";
import App from "./App";
import router from "./router";
import "./assets/font/iconfont.css";


import store from "./store";
import { Pagination, Message, MessageBox, Submenu, Menu, MenuItem, MenuItemGroup, Table, Link, TableColumn} from "element-ui";
Vue.use(Pagination);
Vue.use(Submenu);
Vue.use(Menu);
Vue.use(MenuItem);
Vue.use(MenuItemGroup);
Vue.use(Table);
Vue.use(Link);
Vue.use(TableColumn)

Vue.use(VueRouter);
Vue.use(Message);

Vue.prototype.$message = Message;
Vue.prototype.$prompt = MessageBox;
Vue.config.productionTip = false;



new Vue({
  el: "#app",
  router,
  store,
  components: { App },
  template: "<App/>"
});
