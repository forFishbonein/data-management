import VueRouter from "vue-router";
import FileManage from "../components/manage/FileManage.vue";
import CompetitionManage from "../components/manage/CompetitionManage.vue";
import LoginIna from "../views/LoginIna.vue";
import LoginInb from "../views/LoginInb.vue";
import TeacherIndex from "../views/TeacherIndex.vue";
import RegisterTeacher from "../views/RegisterTeacher.vue";
import TeacherUploadteaching from "../views/TeacherUploadteaching.vue";
import CodeLogin from "../views/CodeLogin.vue";
import PassLogin from "../views/PassLogin.vue";

export default new VueRouter({
  routes: [
    {
      path: "/",
      component: PassLogin
    },
    {
      path: "/loginina",
      component: LoginIna
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
      path: "/logininb",
      component:LoginInb
    },
    {
      path: "/resource",
      component: CompetitionManage
    },
    {
      path: "/upload",
      component: TeacherUploadteaching
    }
  ]
});
