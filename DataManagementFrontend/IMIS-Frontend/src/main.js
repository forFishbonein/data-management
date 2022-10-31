import Vue from "vue";
import VueRouter from "vue-router";
import App from "./App";
import router from "./router";
import "./assets/font/iconfont.css";

import store from "./store";
import {
  Autocomplete,
  Button,
  DatePicker,
  Dialog,
  Form,
  FormItem,
  Input,
  Link,
  Menu,
  MenuItem,
  MenuItemGroup,
  Message,
  MessageBox,
  Pagination,
  Row,
  Submenu,
  Table,
  TableColumn,
  Tag,
  Upload,
  Dropdown,
  DropdownItem,
  DropdownMenu,
  Notification
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
Vue.use(Dropdown);
Vue.use(DropdownItem);
Vue.use(DropdownMenu);

Vue.prototype.$message = Message;
Vue.prototype.$confirm = MessageBox;
Vue.prototype.$notify = Notification;


Vue.config.productionTip = false;


new Vue({
  el: "#app",
  router,
  store,
  components: {App},
  template: "<App/>"
});
