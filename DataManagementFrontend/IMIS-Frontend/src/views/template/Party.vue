<template>
  <div class="container">
    <TeacherNav></TeacherNav>
    <div class="context">
      <div class="Party">
        <div class="title">资源名称：{{ Party.title }}</div>
        <div v-show="this.Party.introduction" class="introduction">{{ Party.introduction }}</div>
        <div class="details">
          <div v-show="this.Party.topic" class="topic">活动主题：{{ Party.topic }}</div>
          <div v-show="this.Party.uploaderId" class="uploader">上传者：{{ Party.uploaderId }}</div>
          <div v-show="this.Party.createTime" class="createTime">上传时间：{{ Party.createTime }}</div>
          <div v-show="this.Party.time" class="time">活动时间：{{ Party.time }}</div>
          <div v-show="this.Party.type" class="type">活动类型：{{ Party.type }}</div>
          <div v-show="this.Party.content" class="content">学习内容：{{ Party.content }}</div>
          <div v-show="this.Party.address" class="address">学习地点：{{ Party.address }}</div>
          <div v-show="this.Party.participant" class="participant">参与人：{{ Party.participant.join(",") }}</div>
          <div class="add">
            <p v-for="item in Party.other">{{ item.key }} : {{ item.value }}</p>
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
  name: "Party",
  data() {
    return {
      Party: {
        TEMPLATE_TYPE: "party",
        id: "",
        title: "",
        num: "",
        introduction: "",

        uploaderId: "",
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
    }

  },
  props: ['templateType', 'id'],
  created() {
    let obj = {}
    obj.TEMPLATE_TYPE = this.templateType;
    obj.id = this.id;
    this.$store.dispatch('getDetails', obj).then(res => {
      // console.log(res)
      this.Party = res
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
