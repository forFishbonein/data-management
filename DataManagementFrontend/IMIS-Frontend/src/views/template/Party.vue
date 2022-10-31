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

          <FilePath>
          </FilePath>
          <div class="button">
            <button class="button button1" @click="deleteById(Party.id,Party.template_TYPE)">删除</button>
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
  name: "Party",
  data() {
    return {
      Party: {
        TEMPLATE_TYPE: "party",
        id: "",
        title: "",
        num: "",
        introduction: "",

        uploaderId: this.$store.state.teacherId,
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
      this.Party = res
    })
  },
  methods: {
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
        "时间（具体到日）",
        "活动类型",
        "活动主题",
        "学习内容",
        "学习地点",
        "参与人");

      this.ExcelValue.push(
        this.Party.num,
        this.Party.time,
        this.Party.type,
        this.Party.topic,
        this.Party.content,
        this.Party.address,
      );

      let item = 0;
      let str = "";
      for (item in this.Party.participant) {
        str = str + this.Party.participant[item] + ",";
      }
      var reg = /,$/gi;
      str = str.replace(reg, "");

      this.ExcelValue.push(str);

      item = 0;
      for (item in this.Party.other) {
        this.ExcelTitle.push(this.Party.other[item].key);
        this.ExcelValue.push(this.Party.other[item].value);
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
        var fileName = this.Party.title
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
      console.log(this.Party)
      this.$router.push({
        path: "/upload/" + this.Party.template_TYPE,
        query: {
          obj: this.Party,
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
