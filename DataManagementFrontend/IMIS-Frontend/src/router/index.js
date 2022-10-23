import VueRouter from "vue-router";
import FileManage from "../components/manage/FileManage.vue";
import CompetitionManage from "../components/manage/CompetitionManage.vue";
import TeacherIndex from "../views/TeacherIndex.vue";
import RegisterTeacher from "../views/RegisterTeacher.vue";
import TeacherUploadteaching from "../views/TeacherUploadteaching.vue";
import CodeLogin from "../views/CodeLogin.vue";
import PassLogin from "../views/PassLogin.vue";

export default new VueRouter({
  routes: [
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

  ]
});
