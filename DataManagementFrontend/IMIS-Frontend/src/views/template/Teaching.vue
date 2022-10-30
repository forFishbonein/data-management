<template>
  <div class="container">
    <TeacherNav></TeacherNav>
    <div class="context">
      <div class="Teaching">
        <div class="title">资源名称：{{ Teaching.title }}</div>
        <div v-show="this.Teaching.introduction" class="introduction">{{ Teaching.introduction }}</div>
        <div class="details">
          <div v-show="this.Teaching.name" class="name">项目名称：{{ Teaching.name }}</div>
          <div v-show="this.Teaching.uploaderId" class="uploader">上传者：{{ Teaching.uploaderId }}</div>
          <div v-show="this.Teaching.createTime" class="createTime">上传时间：{{ Teaching.createTime }}</div>
          <div v-show="this.Teaching.source" class="source">项目来源：{{ Teaching.source }}</div>
          <div v-show="this.Teaching.type" class="type">项目类型：{{ Teaching.type }}</div>
          <div v-show="this.Teaching.level" class="level">项目级别：{{ Teaching.level }}</div>
          <div v-show="this.Teaching.projectTime" class="project_time">立项时间：{{ Teaching.projectTime }}</div>
          <div v-show="this.Teaching.postProjectTime" class="post_project_time">结项时间：{{Teaching.postProjectTime}}</div>
          <div v-show="this.Teaching.fund" class="fund">项目经费：{{ Teaching.fund }}</div>
          <div v-show="this.Teaching.member.length" class="member">课题组成员：{{ Teaching.member.join(",") }}</div>
          <div class="add">
            <p v-for="item in Teaching.other">{{ item.key }} : {{ item.value }}</p>
          </div>


        </div>

      </div>
      <FilePath></FilePath>
      <div class="button">
        <button class="button1" @click="exportExcel">删除</button>
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

import { excelExport } from '@/api/file.js'

export default {
  name: "Teaching",
  data() {
    return {
      Teaching: {
        TEMPLATE_TYPE: "teaching",
        id: "",
        title: "",
        num: "",
        introduction: "",

        uploaderId: "",
        name: "",
        source: "",
        type: "",
        level: "",
        projectTime: "",
        postProjectTime: "",
        fund: "",
        member: [],

        other: [],
        filePath: [],
        createTime: "",
      },
      ExcelTitle: [],
      ExcelValue: [],
    }

  },
  props: ['templateType', 'id'],
  created() {
    let obj = {}
    obj.TEMPLATE_TYPE = this.templateType;
    obj.id = this.id;
    this.$store.dispatch('getDetails', obj).then(res => {
      // console.log(res)
      this.Teaching = res
    })
  },

  methods: {
    exportExcel() {
      this.ExcelTitle=[];
      this.ExcelValue=[];
      this.ExcelTitle.push(
        "编号",
        "立项时间",
        "项目来源",
        "项目类型",
        "项目名称",
        "结项时间",
        "经费（万元）",
        "课题组成员");

      this.ExcelValue.push(
        this.Teaching.num,
        this.Teaching.projectTime,
        this.Teaching.source,
        this.Teaching.type,
        this.Teaching.name,
        this.Teaching.postProjectTime,
        this.Teaching.fund,
      );

      let item = 0;
      let str = "";
      for (item in this.Teaching.member) {
        str = str + this.Teaching.member[item] + ",";
      }
      var reg=/,$/gi;
      str=str.replace(reg,"");

      this.ExcelValue.push(str);

      item = 0;
      for (item in this.Teaching.other) {
        this.ExcelTitle.push(this.Teaching.other[item].key);
        this.ExcelValue.push(this.Teaching.other[item].value);
      }

      console.log(this.ExcelTitle);
      console.log(this.ExcelValue)

      var lists = [];
      lists.push(this.ExcelTitle);
      lists.push(this.ExcelValue);

      console.log(lists)

      excelExport(lists).then(res => {
        // alert("成功了")
        console.log(res)
        // console.log(res.data)
        const _res = res;
        let blob = new Blob([_res], {type: 'application/vnd.ms-excel;charset=utf-8'});
        let downloadElement = document.createElement("a");
        let href = window.URL.createObjectURL(blob); //创建下载的链接
        downloadElement.href = href;
        var dates = new Date();
        var times = dates.getTime();
        var fileName = this.Teaching.title
        downloadElement.download = times + fileName + '.xls'; //下载后文件名
        // downloadElement.download = "导出表.xls"; //下载后文件名
        document.body.appendChild(downloadElement);
        downloadElement.click(); //点击下载
        document.body.removeChild(downloadElement); //下载完成移除元素
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
