<template>
    <div class="container">
      <TeacherNav></TeacherNav>
      <div class="context">
        <div class="Studying">
          <div class="title">资源名称：{{ Studying.title }}</div>
          <div v-show="this.Studying.introduction" class="introduction">{{ Studying.introduction }}</div>
          <div class="details">
            <div v-show="this.Studying.name" class="name">项目名称：{{ Studying.name }}</div>
            <div v-show="this.Studying.uploaderId" class="uploader">上传者：{{Studying.uploaderId}}</div>
            <div v-show="this.Studying.createTime" class="createTime">上传时间：{{ Studying.createTime }}</div>
            <div v-show="this.Studying.source" class="source">项目来源：{{ Studying.source }}</div>
            <div v-show="this.Studying.type" class="type">项目类型：{{ Studying.type }}</div>
            <div v-show="this.Studying.level" class="level">项目级别：{{ Studying.level }}</div>
            <div v-show="this.Studying.projectTime" class="project_time">立项时间：{{ Studying.projectTime }}</div>
            <div v-show="this.Studying.postprojectTime" class="post_project_time">结项时间：{{ Studying.postprojectTime }}</div>
            <div v-show="this.Studying.fund" class="fund">项目经费：{{ Studying.fund }}</div>
            <div v-show="this.Studying.member.length" class="member">课题组成员：{{ Studying.member }}</div>
            <div class="add">
              <p v-for="item in Studying.other">{{ item.key }} : {{ item.value }}</p>
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
    name: "ReStudying",
    data() {
    return {
      Achievement: {
        TEMPLATE_TYPE: "achievement",
        id: "",
        title: "",
        num: "",
        introduction: "",

        uploaderId:"",
        name: "",
        author: "",
        publicYear: "",
        paper: "",
        type: "",
        press: "",
        journalGrade: "",
        schoolGrade: "",
        publicationTime: "",
        authorRank: [],

        other: [],
        filePath: [],
        createTime: "",
      },
      Communication: {
        TEMPLATE_TYPE: "communication",
        id: "",
        title: "",
        num: "",
        introduction: "",

        uploaderId:"",
        startTime: "",
        lastTime: "",
        type: "",
        name: "",
        organizer: "",
        address: "",
        member: "",
        whetherSpeak: "",
        whetherParticipate: "",

        other: [],
        filePath: [],
        createTime: "",
      },
      Honor: {
        TEMPLATE_TYPE: "honor",
        id: "",
        title: "",
        num: "",
        introduction: "",

        uploaderId:"",
        award_name: "",
        time: "",
        type: "",
        garde: "",
        level: "",
        name: "",
        approval_num: "",
        member: [],

        other: [],
        filePath: [],
        createTime: "",
      },
      Office: {
        TEMPLATE_TYPE: "office",
        id: "",
        title: "",
        num: "",
        introduction: "",

        uploaderId:"",
        time: "",
        type: "",
        topic: "",
        content: "",
        address: "",
        participant: [],

        other: [],
        filePath: [],
        createTime: "",
      },
      Party: {
        TEMPLATE_TYPE: "party",
        id: "",
        title: "",
        num: "",
        introduction: "",

        uploaderId:"",
        time: "",
        type: "",
        topic: "",
        content: "",
        address: "",
        participant: "",

        other: [],
        filePath: [],
        createTime: "",
      },
      Studying: {
        TEMPLATE_TYPE: "Studying",
        id: "",
        title: "",
        num: "",
        introduction: "料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资",

        uploaderId:"",
        name: "",
        source: "",
        type: "",
        level: "",
        projectTime: "",
        postprojectTime: "",
        fund: "",
        member: [],

        other: [],
        filePath: [],
        createTime: "",
      },
      StudentContest: {
        TEMPLATE_TYPE: "studentcontest",
        id: "",
        title: "",
        num: "",
        introduction: "",
 
        uploaderId:"",
        name: "",
        gameName: "",
        grade: "",
        instructor: [],
        time: "",

        other: [],
        filePath: [],
        createTime: "",
      },
      Teaching: {
        TEMPLATE_TYPE: "teaching",
        id: "",
        title: "",
        num: "",
        introduction: "料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资料简介资",
 
        uploaderId:"",
        name: "",
        source: "",
        type: "",
        level: "",
        projectTime: "",
        postprojectTime: "",
        fund: "",
        member: [],

        other: [],
        filePath: [],
        createTime: "",
      },
      UserDefined: {
        TEMPLATE_TYPE: "userdefined",
        id: "",
        title: "",
        num: "",
        introduction: "",
 
        uploaderId:"",
        other: [],
        filePath: [],
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
