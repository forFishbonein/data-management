<template>
  <div class="container">
    <TeacherNav></TeacherNav>
    <div class="context">
      <div class="Honor">
        <div class="title">{{ Honor.title }}</div>
        <div v-show="this.Honor.introduction" class="introduction">{{ Honor.introduction }}</div>
        <div class="details">
          <div v-show="this.Honor.award_name" class="name">获奖名称：{{ Honor.award_name }}</div>
          <div v-show="this.Honor.uploaderId" class="uploader">上传者：{{ Honor.uploaderId }}</div>
          <div v-show="this.Honor.createTime" class="createTime">上传时间：{{ Honor.createTime }}</div>
          <div v-show="this.Honor.time" class="time">获奖时间：{{ Honor.time }}</div>
          <div v-show="this.Honor.type" class="type">获奖类型：{{ Honor.type }}</div>
          <div v-show="this.Honor.level" class="level">获奖级别：{{ Honor.level }}</div>
          <div v-show="this.Honor.name" class="level">项目名称：{{ Honor.name }}</div>
          <div v-show="this.Honor.approval_num" class="approval_num">批文号：{{ Honor.approval_num }}</div>
          <div v-show="this.Honor.member.length" class="member">成员：{{ Honor.member.join(",") }}</div>
          <div class="add">
            <p v-for="item in Honor.other">{{ item.key }} : {{ item.value }}</p>
          </div>

          <el-link style="display:block;" v-for="val in Honor.filePath" :key="val" @click="download(val)">{{val.split('.').slice(-2)[0]+'.'+val.split('.').slice(-2)[1]}}</el-link>

          <div class="button">

            <button class="button button1" @click="deleteById(Honor.id,Honor.template_TYPE)">删除</button>
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
import LoginFooter from "../../components/LoginFooter.vue";

import {deleteById} from '@/api/manage'
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

        uploaderId: this.$store.state.teacherId,
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
      this.Honor = res
    })
  },
  methods: {
    download(url){
      // console.log(url.split('.').slice(-2)[0])
      window.open(url)
    },
    deleteById(id,type) {
      console.log(id)
      console.log(type)
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
        "时间",
        "获奖名称",
        "获奖类型",
        "获奖级别",
        "项目名称",
        "批文号",
        "成员");

      this.ExcelValue.push(
        this.Honor.num,
        this.Honor.time,
        this.Honor.award_name,
        this.Honor.type,
        this.Honor.grade,
        this.Honor.name,
        this.Honor.approval_num,

      );

      let item = 0;
      let str = "";
      for (item in this.Honor.member) {
        str = str + this.Honor.member[item] + ",";
      }
      var reg = /,$/gi;
      str = str.replace(reg, "");

      this.ExcelValue.push(str);

      item = 0;
      for (item in this.Honor.other) {
        this.ExcelTitle.push(this.Honor.other[item].key);
        this.ExcelValue.push(this.Honor.other[item].value);
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
        var fileName = this.Honor.title
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
      console.log(this.Honor)
      this.$router.push({
        path: "/upload/" + this.Honor.template_TYPE,
        query: {
          obj: this.Honor,
        }
      })
    }
  },

  components: {
    TeacherNav,
    TeacherHeader,
    TeacherData,
    FilePath,
    LoginFooter
},
beforeRouteEnter (to, from, next) {
    console.log(to, from)
    next(
      vm => {
        vm.$store.dispatch('changePageFrom',"")
      })
  },
}


</script>

<style scoped>
.container {
  /* height: 100vh; */
  background-color: #eaf2fb;
  padding-bottom: 10px;
}

.context {
  width: 1200px;
  margin: 20px auto;
  padding: 20px;
  background-color: white;
  background-image: url("../../../static/img/temple.svg");
  border-radius: 16px;
}

.title {
  padding: 10px;
  color: #113355;
  font-size: 28px;
  padding-left: 50px;

}

.introduction {
  margin: 20px;
  padding: 20px;
  padding-left: 30px;
  background-color:rgba(253, 253, 253, 0.4);
  color: #113355;
  word-wrap: break-word;
  word-break: break-all;
}

.details {
  margin: 5px 20px 20px 20px;
  padding: 5px 20px 20px 20px;
  padding-left: 30px;
  background-color:rgba(253, 253, 253, 0.4);
  color: #113355;
  line-height: 35px;
  font-size:16px;
}

.button {
  float: right;
  margin-left: 15px;
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
