import VueRouter from "vue-router";
import Vue from "vue";
import FileManage from "../components/manage/FileManage.vue";
import CompetitionManage from "../components/manage/CompetitionManage.vue";
import TeacherIndex from "../views/TeacherIndex.vue";
import RegisterTeacher from "../views/RegisterTeacher.vue";
import TeacherUploadteaching from "../views/TeacherUploadteaching.vue";
import CodeLogin from "../views/CodeLogin.vue";
import PassLogin from "../views/PassLogin.vue";

Vue.use(VueRouter);

import store from "@/store";

import { getToken } from "@/request/token";

const routes = [
  {
    path: "/",
    component: CodeLogin
  },
  {
    path: "/codelogin",
    component: CodeLogin
  },

  {
    path: "/passlogin",
    component: PassLogin
  },
  {
    path: "/registerteacher",
    component: RegisterTeacher
  },
  {
    path: "/fileManage",
    component: FileManage
  },
  {
    path: "/competitionManage",
    component: CompetitionManage
  },
  {
    path: "/person",
    component: TeacherIndex
  },

  {
    path: "/resource",
    component: CompetitionManage
  },
  {
    path: "/upload",
    component: TeacherUploadteaching
  }
];

const router = new VueRouter({
  routes
});

// router.beforeEach((to, from, next) => {
//   if (getToken()) {
//     if (to.path === "/login") {
//       next({ path: "/" });
//     } else {
//       //如果不是跳转到登录页面！那么获取用户信息！
//       if (store.state.userEmail.length === 0) {
//         //如果还没有用户信息
//         store
//           .dispatch("getUserInfo") //这里调用了获取用户信息
//           .then(data => {
//             //获取用户信息
//             next();
//           })
//           .catch(() => {
//             Message({
//               type: "warning",
//               showClose: true,
//               message: "登录已过期"
//             });
//             next({ path: "/" });
//           });
//       } else {
//         next();
//       }
//     }
//   } else {
//     if (to.matched.some(r => r.meta.requireLogin)) {
//       Message({
//         type: "warning",
//         showClose: true,
//         message: "请先登录哦"
//       });
//     } else {
//       next();
//     }
//   }
// });

export default router;
