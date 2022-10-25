import VueRouter from "vue-router";
import Vue from "vue";
import CompetitionManage from "../components/manage/CompetitionManage.vue";
import TeacherIndex from "../views/TeacherIndex.vue";
import RegisterTeacher from "../views/RegisterTeacher.vue";
import CodeLogin from "../views/CodeLogin.vue";
import PassLogin from "../views/PassLogin.vue";

//manage
import Manage from "../views/Manage.vue";
import AccountManage from "../components/manage/AccountManage.vue";
import FileManage from "../components/manage/FileManage.vue";

//template
import Achievement from "../views/template/Achievement.vue";
import Teaching from "../views/template/Teaching.vue";

//upload
import Upload from "../views/Upload.vue";
import AchievementUpload from "../components/upload/AchievementUpload";
import CommunicationUpload from "../components/upload/CommunicationUpload";
import ContestUpload from "../components/upload/ContestUpload";
import HonorUpload from "../components/upload/HonorUpload";
import OfficeUpload from "../components/upload/OfficeUpload";
import PartyUpload from "../components/upload/PartyUpload";
import StudyingUpload from "../components/upload/StudyingUpload";
import TeachingUpload from "../components/upload/TeachingUpload";

Vue.use(VueRouter);

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
      path: "/competitionManage",
      component: CompetitionManage
    },
    {
      path: "/profile",
      component: TeacherIndex
    },

    {
      path: "/resource",
      component: CompetitionManage
    },
  {
    path: "/teaching",
    component: Teaching
  },
    {
      path: "/achievement",
      component: Achievement
    },
    {
      path: "/manage",
      component: Manage,
      children: [
        {
          path: 'filemange',
          component: FileManage
        },
        {
          path: 'accountmange',
          component: AccountManage
        }
      ]
    },
  {
    path: "/upload",
    component: Upload,
    children: [
      {
        path: 'teaching',
        component: TeachingUpload
      },
      {
        path: 'achievementupload',
        component: AchievementUpload
      },
      {
        path: 'communicationupload',
        component: CommunicationUpload
      },
      {
        path: 'contestupload',
        component: ContestUpload
      },
      {
        path: 'honorupload',
        component: HonorUpload
      },
      {
        path: 'officeupload',
        component: OfficeUpload
      },
      {
        path: 'partyupload',
        component: PartyUpload
      },
      {
        path: 'studyingupload',
        component: StudyingUpload
      }
    ]
  }
  ]
;

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
