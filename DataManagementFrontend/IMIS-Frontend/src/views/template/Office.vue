<template>
  <div class="container">
    <TeacherNav></TeacherNav>
    <div class="context">
      <div class="Office">
        <div class="title">资源名称：{{ Office.title }}</div>
        <div v-show="this.Office.introduction" class="introduction">{{ Office.introduction }}</div>
        <div class="details">
          <div v-show="this.Office.topic" class="topic">活动主题：{{ Office.topic }}</div>
          <div v-show="this.Office.uploaderId" class="uploader">上传者：{{ Office.uploaderId }}</div>
          <div v-show="this.Office.createTime" class="createTime">上传时间：{{ Office.createTime }}</div>
          <div v-show="this.Office.time" class="time">活动时间：{{ Office.time }}</div>
          <div v-show="this.Office.type" class="type">活动类型：{{ Office.type }}</div>
          <div v-show="this.Office.content" class="content">学习内容：{{ Office.content }}</div>
          <div v-show="this.Office.address" class="address">学习地点：{{ Office.address }}</div>
          <div v-show="this.Office.participant.length" class="participant">参与人：{{ Office.participant.join(",") }}</div>
          <div class="add">
            <p v-for="item in Office.other">{{ item.key }} : {{ item.value }}</p>
          </div>


        </div>

      </div>
      <FilePath></FilePath>
      <div class="button">
        <button class="button button1">删除</button>
        <button class="button button2">编辑</button>
        <button class="button button3" @click="exportExcel">导出Excel</button>
      </div>
    </div>
  </div>
</template>

<script>
import TeacherNav from "../../components/TeacherNav";
import TeacherHeader from "../../components/TeacherHeader";
import TeacherData from "../../components/TeacherData";
import FilePath from "../../components/FilePath";

import {excelExport} from '@/api/file.js'

export default {
  name: "Office",
  data() {
    return {
      Office: {
        TEMPLATE_TYPE: "office",
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
        participant: [],

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
      this.Office = res
    })
  },
  methods: {
    exportExcel() {
      this.ExcelTitle = [];
      this.ExcelValue = [];
      this.ExcelTitle.push(
        "编号",
        "时间（具体到日）",
        "活动类型",
        "活动内容",
        "地点",
        "参与人）");

      this.ExcelValue.push(
        this.Office.num,
        this.Office.time,
        this.Office.type,
        this.Office.content,
        this.Office.address,
      );

      let item = 0;
      let str = "";
      for (item in this.Office.participant) {
        str = str + this.Office.participant[item] + ",";
      }
      var reg = /,$/gi;
      str = str.replace(reg, "");

      this.ExcelValue.push(str);

      item = 0;
      for (item in this.Office.other) {
        this.ExcelTitle.push(this.Office.other[item].key);
        this.ExcelValue.push(this.Office.other[item].value);
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
        var fileName = this.Office.title
        downloadElement.download = times + fileName + '.xls';
        document.body.appendChild(downloadElement);
        downloadElement.click();
        document.body.removeChild(downloadElement);
        window.URL.revokeObjectURL(href);
      }).catch(error => {
        console.log(error)
      })

    },
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
