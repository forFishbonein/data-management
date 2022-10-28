import Vue from "vue";
import VueRouter from "vue-router";
import App from "./App";
import router from "./router";
import "./assets/font/iconfont.css";


import store from "./store";
import {
  Autocomplete,
  Button,
  Input,
  DatePicker,
  Link,
  Menu,
  MenuItem,
  MenuItemGroup,
  Message,
  MessageBox,
  Dialog,
  Pagination,
  Submenu,
  Table,
  TableColumn,
  Tag,
  Upload,
  Form,
  FormItem,
  Row,
} from "element-ui";

Vue.use(Pagination);
Vue.use(Submenu);
Vue.use(Menu);
Vue.use(MenuItem);
Vue.use(MenuItemGroup);
Vue.use(Table);
Vue.use(Link);
Vue.use(TableColumn);
Vue.use(Tag);
Vue.use(Input);
Vue.use(DatePicker);
Vue.use(Button);
Vue.use(Upload);
Vue.use(Autocomplete);
Vue.use(VueRouter);
Vue.use(Dialog);
Vue.use(Form);
Vue.use(FormItem);
Vue.use(Row);

Vue.prototype.$message = Message;
Vue.prototype.$confirm = MessageBox;




Vue.config.productionTip = false;


new Vue({
  el: "#app",
  router,
  store,
  components: {App},
  template: "<App/>"
});
