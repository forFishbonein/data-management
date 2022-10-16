import VueRouter from "vue-router";
import FileManage from "../components/manage/FileManage.vue";
import CompetitionManage from "../components/manage/CompetitionManage.vue";

export default new VueRouter({
  routes: [
    {
      path: "/fileManage",
      component: FileManage
    },
    {
      path: "/competitionManage",
      component: CompetitionManage
    }
  ]
});
