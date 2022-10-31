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

          <FilePath>
          </FilePath>
          <div class="button">
            <button class="button button1" @click="deleteById(Achievement.id,Achievement.template_TYPE)">删除</button>
            <button class="button button2" @click="updateById">编辑</button>
            <button class="button button3" @click="exportExcel">导出Excel</button>
          </div>
        </div>
      </div>
    </div>
    <LoginFooter></LoginFooter>
  </div>
</template>

<script>
import TeacherNav from "../../components/TeacherNav";
import TeacherHeader from "../../components/TeacherHeader";
import TeacherData from "../../components/TeacherData";
import FilePath from "../../components/FilePath";

import {excelExport} from '@/api/file.js'
import LoginFooter from "../../components/LoginFooter";

import {deleteById} from '@/api/manage'
export default {
  name: "Achievement",
  components: {
    LoginFooter,
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
      },
      Delete: {
        id: "",
        TEMPLATE_TYPE: ""
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
  methods: {


    deleteById(id,type) {
      console.log(id)
      this.Delete.id =id;
      this.Delete.TEMPLATE_TYPE = type;
      deleteById(this.Delete).then(resp => {
        this.$router.replace(name = 'profile')

      });
    },
    exportExcel() {
      this.ExcelTitle = [];
      this.ExcelValue = [];
      this.ExcelTitle.push(
        "编号",
        "作者",
        "发表年",
        "论文或专著",
        "论文类型",
        "成果名称",
        "出版社/期刊名称",
        "期刊等级",
        "民大认定级别",
        "出版时间/卷期号",
        "作者排序");

      this.ExcelValue.push(
        this.Achievement.num,
        this.Achievement.author,
        this.Achievement.publicYear,
        this.Achievement.paper,
        this.Achievement.type,
        this.Achievement.name,
        this.Achievement.press,
        this.Achievement.journalGrade,
        this.Achievement.schoolGrade,
        this.Achievement.publicationTime,
      );

      let item = 0;
      let str = "";
      for (item in this.Achievement.authorRank) {
        str = str + this.Achievement.authorRank[item] + ",";
      }
      var reg = /,$/gi;
      str = str.replace(reg, "");

      this.ExcelValue.push(str);

      item = 0;
      for (item in this.Achievement.other) {
        this.ExcelTitle.push(this.Achievement.other[item].key);
        this.ExcelValue.push(this.Achievement.other[item].value);
      }

      console.log(this.ExcelTitle);
      console.log(this.ExcelValue)

      var lists = [];
      lists.push(this.ExcelTitle);
      lists.push(this.ExcelValue);

      console.log(lists)

      excelExport(lists).then(res => {
        console.log(res)
        const _res = res;
        let blob = new Blob([_res], {type: 'application/vnd.ms-excel;charset=utf-8'});
        let downloadElement = document.createElement("a");
        let href = window.URL.createObjectURL(blob);
        downloadElement.href = href;
        var dates = new Date();
        var times = dates.getTime();
        var fileName = this.Achievement.title
        downloadElement.download = times + fileName + '.xls';
        document.body.appendChild(downloadElement);
        downloadElement.click();
        document.body.removeChild(downloadElement);
        window.URL.revokeObjectURL(href);
      }).catch(error => {
        console.log(error)
      })

    },
    updateById() {
      console.log(this.Achievement)
      this.$router.push({
        path: "/upload/" + this.Achievement.template_TYPE,
      })
    }
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
  float: right;
  margin: 8px;
  padding: 8px 16px;
  text-align: center;
  color: #fff;
  border-radius: 8px;
}

.button3 {
  background: #26af00;
}

.button3:hover {
  background: #1e8000;
}

.button2 {
  background: #104A85;
}

.button2:hover {
  background: #08386a;
}

.button1 {
  background: #EB8C2D;
}

.button1:hover {
  background: #c6721f;
}


</style>
