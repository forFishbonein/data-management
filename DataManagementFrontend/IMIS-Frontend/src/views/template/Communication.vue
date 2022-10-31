<template>
  <div class="container">
    <TeacherNav></TeacherNav>
    <div class="context">
      <div class="Communication">
        <div class="title">资源名称：{{ Communication.title }}</div>
        <div v-show="this.Communication.introduction" class="introduction">{{ Communication.introduction }}</div>
        <div class="details">
          <div v-show="this.Communication.name" class="name">活动/会议名称：{{ Communication.name }}</div>
          <div v-show="this.Communication.uploaderId" class="uploader">上传者:{{ Communication.uploaderId }}</div>
          <div v-show="this.Communication.createTime" class="createTime">上传时间：{{ Communication.createTime }}</div>
          <div v-show="this.Communication.startTime" class="startTime">起始时间：{{ Communication.startTime }}</div>
          <div v-show="this.Communication.lastTime" class="lastTime">终止时间：{{ Communication.lastTime }}</div>
          <div v-show="this.Communication.type" class="type">交流类型：{{ Communication.type }}</div>
          <div v-show="this.Communication.organizer" class="organizer">主办机构：{{ Communication.organizer }}</div>
          <div v-show="this.Communication.address" class="address">地点：{{ Communication.address }}</div>
          <div v-show="this.Communication.member.length" class="member">参会人员：{{ Communication.member.join(",") }}</div>
          <div v-show="this.Communication.whetherSpeak" class="whetherSpeak">是否发言：{{ Communication.whetherSpeak }}</div>
          <div v-show="this.Communication.whetherParticipate" class="whetherParticipate">
            学生是否参与：{{ Communication.whetherParticipate }}
          </div>
          <div class="add">
            <p v-for="item in Communication.other">{{ item.key }} : {{ item.value }}</p>
          </div>


        </div>

      </div>
      <FilePath></FilePath>
      <div class="button">
        <button class="button button1" @click="deleteById(Communication.id,Communication.template_TYPE)">删除</button>
        <button class="button button2" @click="updateById">编辑</button>
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
import {deleteById} from '@/api/manage'
export default {
  name: "Communication",
  data() {
    return {
      Communication: {
        TEMPLATE_TYPE: "communication",
        id: "",
        title: "",
        num: "",
        introduction: "",

        uploaderId: this.$store.state.teacherId,
        startTime: "",
        lastTime: "",
        type: "",
        name: "",
        organizer: "",
        address: "",
        member: [],
        whetherSpeak: "",
        whetherParticipate: "",

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
      this.Communication = res
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
        "起始时间",
        "终止时间",
        "交流类型",
        "活动（会议）名称",
        "主办机构",
        "地点",
        "参会人员",
        "是否发言",
        "学生是否参与");

      this.ExcelValue.push(
        this.Communication.num,
        this.Communication.startTime,
        this.Communication.lastTime,
        this.Communication.type,
        this.Communication.name,
        this.Communication.organizer,
        this.Communication.address,
      );

      let item = 0;
      let str = "";
      for (item in this.Communication.member) {
        str = str + this.Communication.member[item] + ",";
      }
      var reg = /,$/gi;
      str = str.replace(reg, "");

      this.ExcelValue.push(str);
      this.ExcelValue.push(this.Communication.whetherSpeak);
      this.ExcelValue.push(this.Communication.whetherParticipate);

      item = 0;
      for (item in this.Communication.other) {
        this.ExcelTitle.push(this.Communication.other[item].key);
        this.ExcelValue.push(this.Communication.other[item].value);
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
        var fileName = this.Communication.title
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
      console.log(this.Communication)
      this.$router.push({
        path: "/upload/" + this.Communication.template_TYPE,
        query: {
          obj: this.Communication,
        }
      })
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
