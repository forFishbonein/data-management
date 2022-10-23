import Vue from "vue";
import VueRouter from "vue-router";
import App from "./App";
import router from "./router";
import "./assets/font/iconfont.css";


import store from "./store";
import { Pagination, Message, MessageBox, Tag,Input,Upload,Button,Autocomplete} from "element-ui";
Vue.use(Pagination);
Vue.prototype.$message = Message;
Vue.prototype.$prompt = MessageBox;

Vue.config.productionTip = false;

Vue.use(VueRouter);
Vue.use(Tag);
Vue.use(Input);
Vue.use(Upload);
Vue.use(Button);
Vue.use(Autocomplete)

new Vue({
  el: "#app",
  router,
  store,
  components: { App },
  template: "<App/>"
});
