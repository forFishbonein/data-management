import VueRouter from "vue-router";


import TeacherIndex from "../views/TeacherIndex.vue";
import RegisterTeacher from "../views/RegisterTeacher.vue";
import TeacherUploadteaching from "../views/TeacherUploadteaching.vue";
import CodeLogin from "../views/CodeLogin.vue";
import PassLogin from "../views/PassLogin.vue";

import Manage from "../views/Manage.vue";
import FileManage from "../components/manage/FileManage.vue";
import AccountManage from "../components/manage/AccountManage.vue";
import CompetitionManage from "../components/manage/CompetitionManage.vue";

export default new VueRouter({
  routes: [
    {
      path: "/",
      component: TeacherIndex
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
      component:TeacherIndex
    },

    {
      path: "/resource",
      component: CompetitionManage
    },
    {
      path: "/upload",
      component: TeacherUploadteaching
    },
    {
      path: "/manage",
      component: Manage,
      children:[{
        path:'filemange',
        component:FileManage
      },{
        path:'accountmange',
        component:AccountManage
      }]
    }
  ]
});
