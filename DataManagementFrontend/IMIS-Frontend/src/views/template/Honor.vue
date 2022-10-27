<template>
  <div class="container">
    <TeacherNav></TeacherNav>
    <div class="context">
      <div class="Honor">
        <div class="title">资源名称：{{ Honor.title }}</div>
        <div class="introduction">{{ Honor.introduction }}</div>
        <div class="details">
          <div v-show="this.Honor.award_name" class="name">奖励名称：{{ Honor.award_name }}</div>
          <div class="uploader">上传者：</div>
          <div class="createTime">上传时间：{{ Honor.createTime }}</div>
          <div class="time">奖励时间：{{ Honor.time }}</div>
          <div class="type">奖励类型：{{ Honor.type }}</div>
          <div class="level">奖励级别：{{ Honor.level }}</div>
          <div class="approval_num">批文号：{{ Honor.approval_num }}</div>
          <div class="member">成员：{{ Honor.member }}</div>
          <div class="add">
            <p v-for="(val, key) in Honor.other">{{ key }} : {{ val }}</p>
          </div>


        </div>

      </div>
      <FilePath></FilePath>
      <div class="button">
        <button class="button1">删除</button>
        <button class="button2">编辑</button>
      </div>
    </div>
  </div>
</template>

<script>
import TeacherNav from "../../components/TeacherNav";
import TeacherHeader from "../../components/TeacherHeader";
import TeacherData from "../../components/TeacherData";
import FilePath from "../../components/FilePath";

export default {
  name: "Honor",
  data() {
    return {

      Achievement: {
        TEMPLATE_TYPE: "achievement",
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
      Research: {
        TEMPLATE_TYPE: "research",
        id: "",
        title: "",
        num: "",
        introduction: "料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资",

        name: "",
        source: "",
        type: "",
        level: "",
        projectTime: "",
        postprojectTime: "",
        fund: "",
        member: "",

        other: {
          "条目1": "内容1",
          "条目2": "内容2"
        },

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
        introduction: "料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资",

        name: "",
        source: "",
        type: "",
        level: "",
        projectTime: "",
        postprojectTime: "",
        fund: "",
        member: "",

        other: {
          "条目1": "内容1",
          "条目2": "内容2"
        },

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
  /* height: 100vh; */
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
  padding: 10px;
  color: #113355;
  font-size: 28px;
  padding-left: 30px;

}

.introduction {
  margin: 20px;
  padding: 20px;
  padding-left: 30px;
  background-color: #FDFDFD;
  color: #113355;
  /* border-radius: 16px; */
}

.details {
  margin: 20px;
  padding: 20px;
  padding-left: 30px;
  background-color: #FDFDFD;
  color: #113355;
  line-height: 35px;
}

.button {
  height: 80px;

}

.button2 {
  margin: 20px;
  padding: 20px;
  float: right;
  padding-right: 30px;
  width: 100px;
  height: 70px;
  background: #104A85;
  text-align: center;
  color: #fff;
}

.button1 {
  margin: 20px;
  padding: 20px;
  float: right;
  padding-right: 30px;
  width: 100px;
  height: 70px;
  background: #EB8C2D;
  text-align: center;
  color: #fff;
}


</style>
