<template>
  <div class="container">
    <TeacherNav></TeacherNav>
    <div class="context">
      <div class="Achievement">
        <div class="title">资源名称：{{ Achievement.title }}</div>
        <div v-show="this.Achievement.introduction" class="introduction">{{ Achievement.introduction }}</div>
        <div class="details">
          <div v-show="this.Achievement.name" class="name">成果名称：{{ Achievement.name }}</div>
          <div v-show="this.Achievement.uploader" class="uploader">上传者：{{ Achievement.uploaderId }}</div>
          <div v-show="this.Achievement.createTime" class="createTime">上传时间：{{ Achievement.createTime }}</div>
          <div v-show="this.Achievement.author" class="author">作者：{{ Achievement.author }}</div>
          <div v-show="this.Achievement.publicYear" class="publicYear">发表年：{{ Achievement.publicYear }}</div>
          <div v-show="this.Achievement.paper" class="paper">论文或专著：{{ Achievement.paper }}</div>
          <div v-show="this.Achievement.type" class="type">论文类型：{{ Achievement.type }}</div>
          <div v-show="this.Achievement.press" class="press">出版社/期刊名称：{{ Achievement.press }}</div>
          <div v-show="this.Achievement.journalGrade" class="journalGrade">期刊等级：{{ Achievement.journalGrade }}</div>
          <div v-show="this.Achievement.schoolGrade" class="schoolGrade">民大认定级别：{{ Achievement.schoolGrade }}</div>
          <div v-show="this.Achievement.publicationTime" class="publicationTime">出版时间/期卷号:{{
              Achievement.publicationTime
            }}
          </div>
          <div v-show="this.Achievement.authorRank.length" class="authorRank">作者排序：{{
              Achievement.authorRank.join(",")
            }}
          </div>
          <div class="add">
            <p v-for="item in Achievement.other">{{ item.key }} : {{ item.value }}</p>
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
  name: "Achievement",
  components: {
    TeacherNav,
    TeacherHeader,
    TeacherData,
    FilePath
  },
  data() {
    return {
      Achievement: {
        TEMPLATE_TYPE: "achievement",
        id: "",
        title: "",
        num: "",
        introduction: "",

        uploaderId: "",
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
      }

    }

  },
  props: ['templateType', 'id'],
  created() {
    let obj = {}
    obj.TEMPLATE_TYPE = this.templateType;
    obj.id = this.id;
    this.$store.dispatch('getDetails', obj).then(res => {
      // console.log(res)
      this.Achievement = res
    })
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
