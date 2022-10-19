import VueRouter from "vue-router";
import FileManage from "../components/manage/FileManage.vue";
import CompetitionManage from "../components/manage/CompetitionManage.vue";
import store from "@/store";
import Vue from "vue";

Vue.use(VueRouter);

import { getToken } from "@/request/token";

const routes = [
    {
      path: "/fileManage",
      component: FileManage
    },
    {
      path: "/competitionManage",
      component: CompetitionManage
    },
    {
      path: "/login",
      component: (r) =>
        require.ensure([], () => r(require("@/views/LoginIna")), "login"),
    },
    {
      path: "/register",
      component: (r) =>
        require.ensure([], () => r(require("@/views/RegisterTeacher")), "register"),
    },
  ]

const router = new VueRouter({
  routes,
});

router.beforeEach((to, from, next) => {
  if (getToken()) {
    if (to.path === "/login") {
      next({ path: "/" });
    } else {
      if (store.state.account.length === 0) {
        store
          .dispatch("getUserInfo")
          .then((data) => {
            //获取用户信息
            next();
          })
          .catch(() => {
            Message({
              type: "warning",
              showClose: true,
              message: "登录已过期",
            });
            next({ path: "/" });
          });
      } else {
        next();
      }
    }
  } else {
    if (to.matched.some((r) => r.meta.requireLogin)) {
      Message({
        type: "warning",
        showClose: true,
        message: "请先登录哦",
      });
    } else {
      next();
    }
  }
});

export default router;