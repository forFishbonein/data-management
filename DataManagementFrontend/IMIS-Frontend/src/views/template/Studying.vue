<template>
  <div class="container">
    <TeacherNav></TeacherNav>
    <div class="context">
      <div class="Studying">
        <div class="title">资源名称：{{ Studying.title }}</div>
        <div class="introduction">{{ Studying.introduction }}</div>
        <div class="details">
          <div v-show="this.Studying.name" class="name">项目名称：{{ Studying.name }}</div>
          <div v-show="this.Studying.uploaderId" class="uploader">上传者：{{ Studying.uploaderId }}</div>
          <div v-show="this.Studying.createTime" class="createTime">上传时间：{{ Studying.createTime }}</div>
          <div v-show="this.Studying.source" class="source">项目来源：{{ Studying.source }}</div>
          <div v-show="this.Studying.type" class="type">项目类型：{{ Studying.type }}</div>
          <div v-show="this.Studying.level" class="level">项目级别：{{ Studying.level }}</div>
          <div v-show="this.Studying.projectTime" class="project_time">立项时间：{{ Studying.projectTime }}</div>
          <div v-show="this.Studying.postProjectTime" class="post_project_time">结项时间：{{
              Studying.postProjectTime
            }}
          </div>
          <div v-show="this.Studying.fund" class="fund">项目经费：{{ Studying.fund }}</div>
          <div v-show="this.Studying.member.length" class="member">课题组成员：{{ Studying.member.join(",") }}</div>
          <div class="add">
            <p v-for="item in Studying.other">{{ item.key }} : {{ item.value }}</p>
          </div>
          <el-link style="display:block;" v-for="val in Studying.filePath" :key="val" @click="download(val)">{{val.split('.').slice(-2)[0]+'.'+val.split('.').slice(-2)[1]}}</el-link>

          <div class="button">
            <button class="button button1" @click="deleteById(Studying.id,Studying.template_TYPE)">删除</button>
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
  name: "Studying",
  data() {
    return {
      Studying: {
        TEMPLATE_TYPE: "Studying",
        id: "",
        title: "",
        num: "",
        introduction: "",

        uploaderId: this.$store.state.teacherId,
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
      this.Studying = res
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
        "立项时间",
        "项目来源",
        "项目类型",
        "项目名称",
        "结项时间",
        "经费（万元）",
        "课题组成员");

      this.ExcelValue.push(
        this.Studying.num,
        this.Studying.projectTime,
        this.Studying.source,
        this.Studying.type,
        this.Studying.name,
        this.Studying.postProjectTime,
        this.Studying.fund,
      );

      let item = 0;
      let str = "";
      for (item in this.Studying.member) {
        str = str + this.Studying.member[item] + ",";
      }
      var reg = /,$/gi;
      str = str.replace(reg, "");

      this.ExcelValue.push(str);

      item = 0;
      for (item in this.Studying.other) {
        this.ExcelTitle.push(this.Studying.other[item].key);
        this.ExcelValue.push(this.Studying.other[item].value);
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
        var fileName = this.Studying.title
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
      console.log(this.Studying)
      this.$router.push({
        path: "/upload/" + this.Studying.template_TYPE,
        query: {
          obj: this.Studying,
        }
      })
    }
  },

  components: {
    TeacherNav,
    TeacherHeader,
    TeacherData,
    LoginFooter
}
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
  background-image: url("../../../static/img/temple.svg");
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
  background-color:rgba(253, 253, 253, 0.4);
  color: #113355;
}

.details {
  margin: 20px;
  padding: 20px;
  padding-left: 30px;
  background-color:rgba(253, 253, 253, 0.4);
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
