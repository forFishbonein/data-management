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
  name: 'TeacherFile',

  components: {
    TeacherNav,
    TeacherHeader,
    TeacherData,
    FilePath
  },

  data() {
    return {

      Achievememnt: {
        TEMPLATE_TYPE: "achievememnt",
        id: "",
        title: "",
        num: "",
        introduction: "",

        name: "",
        author: "",
        publicYear: "",
        paper: "",
        type: "",
        press: "",
        journalGrade: "",
        schoolGrade: "",
        publicationTime: "",
        authorRank: "",

        other: {},
        filePath: "",
        createTime: "",
      },
      Communication: {
        TEMPLATE_TYPE: "communication",
        id: "",
        title: "",
        num: "",
        introduction: "",

        startTime: "",
        lastTime: "",
        type: "",
        name: "",
        organizer: "",
        address: "",
        member: "",
        whetherSpeak: "",
        whetherParticipate: "",

        other: {},
        filePath: "",
        createTime: "",
      },
      Honor: {
        TEMPLATE_TYPE: "honor",
        id: "",
        title: "",
        num: "",
        introduction: "",

        award_name: "",
        time: "",
        type: "",
        garde: "",
        level: "",
        name: "",
        approval_num: "",
        member: "",

        other: {},
        filePath: "",
        createTime: "",
      },
      Office: {
        TEMPLATE_TYPE: "office",
        id: "",
        title: "",
        num: "",
        introduction: "",

        time: "",
        type: "",
        topic: "",
        content: "",
        address: "",
        participant: "",

        other: {},
        filePath: "",
        createTime: "",
      },
      Paper: {
        TEMPLATE_TYPE: "paper",
        id: "",
        title: "",
        num: "",
        introduction: "",

        other: {},
        filePath: "",
        createTime: "",
      },
      Party: {
        TEMPLATE_TYPE: "party",
        id: "",
        title: "",
        num: "",
        introduction: "",

        time: "",
        type: "",
        topic: "",
        content: "",
        address: "",
        participant: "",

        other: {},
        filePath: "",
        createTime: "",
      },
      StudentContest: {
        TEMPLATE_TYPE: "studentContest",
        id: "",
        title: "",
        num: "",
        introduction: "",

        name: "",
        gameName: "",
        grade: "",
        instructor: "",
        time: "",

        other: {},
        filePath: "",
        createTime: "",
      },
      Teaching: {
        TEMPLATE_TYPE: "teaching",
        id: "",
        title: "",
        num: "",
        introduction: "",

        name: "",
        source: "",
        type: "",
        level: "",
        projectTime: "",
        fund: "",
        member: "",

        other: {},
        filePath: "",
        createTime: "",
      },
      UserDefined: {
        TEMPLATE_TYPE: "teaching",
        id: "",
        title: "",
        num: "",
        introduction: "",

        other: {},
        filePath: "",
        createTime: "",
      },

    }

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
