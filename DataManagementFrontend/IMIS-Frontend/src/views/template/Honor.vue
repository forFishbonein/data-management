<template>
  <div class="container">
    <TeacherNav></TeacherNav>
    <div class="context">
      <div class="Honor">
        <div class="title">资源名称：{{ Honor.title }}</div>
        <div v-show="this.Honor.introduction" class="introduction">{{ Honor.introduction }}</div>
        <div class="details">
          <div v-show="this.Honor.award_name" class="name">奖励名称：{{ Honor.award_name }}</div>
          <div v-show="this.Honor.uploaderId" class="uploader">上传者：{{Honor.uploaderId}}</div>
          <div v-show="this.Honor.createTime" class="createTime">上传时间：{{ Honor.createTime }}</div>
          <div v-show="this.Honor.time" class="time">奖励时间：{{ Honor.time }}</div>
          <div v-show="this.Honor.type" class="type">奖励类型：{{ Honor.type }}</div>
          <div v-show="this.Honor.level" class="level">奖励级别：{{ Honor.level }}</div>
          <div v-show="this.Honor.approval_num" class="approval_num">批文号：{{ Honor.approval_num }}</div>
          <div v-show="this.Honor.member.length" class="member">成员：{{ Honor.member.join(",") }}</div>
          <div class="add">
            <p v-for="item in Honor.other">{{ item.key }} : {{ item.value }}</p>
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
    }

  },
  props:['templateType','id'],
    created(){
      let obj = {}
      obj.TEMPLATE_TYPE = this.templateType;
      obj.id = this.id;
      this.$store.dispatch('getDetails', obj).then(res => {
        // console.log(res)
        this.Honor = res
      })
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
