<template>
    <div class="container">
      <TeacherNav></TeacherNav>
      <div class="context">
        <div class="StudentContest">
          <div class="title">资源名称：{{StudentContest.title}}</div>
          <div class="introduction">{{StudentContest.introduction}}</div>
          <div class="details">
            <div v-show="this.StudentContest.name" class="name">项目名称：{{StudentContest.name}}</div>
            <div class="uploader">上传者：</div>
            <div class="createTime">上传时间：{{StudentContest.createTime}}</div>
            <div class="gameName">竞赛名称：{{StudentContest.gameName}}</div>
            <div class="grade">获奖级别：{{StudentContest.grade}}</div>
            <div class="instructor">指导老师：{{StudentContest.instructor}}</div>
            <div class="time">获奖时间：{{StudentContest.time}}</div>
            <div class="add">
              <p v-for="(val, key) in StudentContest.other">{{ key }} : {{val}}</p>
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
    name: "StudentContest",
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
        Search: {
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
  
          other: {
            "条目1": "内容1",
          "条目2": "内容2"
          },
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
  
  .details{
    margin: 20px;
    padding: 20px;
    padding-left: 30px;
    background-color: #FDFDFD;
    color: #113355; 
    line-height:35px;
  }
  
  .button{
    height: 80px;
  
  }
  
  .button2{
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
  
  .button1{
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
  