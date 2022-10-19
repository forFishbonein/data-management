<template>
  <div class="container">
    <TeacherNav></TeacherNav>
    <div class="context">
      <div class="title">测试标题</div>
      <div class="createTime">2022-10-16 11:25:30</div>
      <div class="introduction">测试简介</div>
      <FilePath></FilePath>
    </div>





</div>
</template>

<script>


import TeacherNav from "../components/TeacherNav";
import TeacherHeader from "../components/TeacherHeader";
import TeacherData from "../components/TeacherData";
import FilePath from "../components/FilePath";
export default {
  name: "TeacherFile",
  data() {
    return {

      honor : {
        id: "",
        title: "",
        other: {

        },
        filePath: "",
        createTime: "",
        num: "",
        introduction: ""
      }

    }

  },
  components: {
    TeacherNav,
    TeacherHeader,
    TeacherData,
    FilePath
  },
}


</script>

<style scoped>
.container {
  height: 100vh;
  background-color: #eaf2fb;
}

.context {
  width: 1200px;
  margin: 20px auto;
  padding: 20px;

  background-color: white;
  border-radius: 16px;
}

.title {
  padding: 40px;
  color: #113355;
  font-size: 28px;

}

.createTime {
  padding-left: 40px;
}

.introduction {
  margin: 40px;
  padding: 40px;
  background-color: #f5e3e3;
  color: #113355;
  border-radius: 16px;
}

</style>
