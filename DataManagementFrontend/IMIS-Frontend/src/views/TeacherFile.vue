<template>
  <div class="container">
    <TeacherNav></TeacherNav>
    <div class="context">
      <div class="title"></div>
      <div class="introduction"></div>
      <div class="createTime"></div>

    </div>




</div>
</template>

<script>


import TeacherNav from "../components/TeacherNav";
import TeacherHeader from "../components/TeacherHeader";
import TeacherData from "../components/TeacherData";

export default {
  name: "TeacherFile",
  data() {
    return {
      teacherFile : {
        id: "",
        title: "",
        other: {},
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
    TeacherData

  },
}


</script>

<style scoped>
.container {
  background-color: #eaf2fb;
}

</style>
