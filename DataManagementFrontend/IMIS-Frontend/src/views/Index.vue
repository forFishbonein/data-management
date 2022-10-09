<template>
  <div>
     <!-- <TeacherNav></TeacherNav> -->
      <div class="container">
       <!-- <TeacherHeader></TeacherHeader> -->
        <div class="tbody">
          <div class="line">
            <span>资料</span>
            <input placeholder="搜索"/>
          </div>
          <div v-for="(item,index) in tdata" :key="index">
            <TeacherData :id="item.id" :title="item.title" :name="item.name" :desc="item.desc" :time="item.time"></TeacherData>
          </div>
        </div>
      </div>
    </div>
  </template>

  <script>
  //import TeacherNav from './components/TeacherNav.vue'
  //import TeacherHeader from './components/TeacherHeader.vue'
  import TeacherData from '../components/TeacherData.vue'
  export default {
    data () {
      return {
        tdata : [
          {
            "id":1,
            "title":"哈哈",
            "desc" :"中南民大",
            "name" :"张三",
            "time" :"2022/09/01"
          },
          {
            "id":2,
            "title":"哈哈咯咯咯",
            "desc" :"中南民大管理学院",
            "name" :"李四",
            "time" :"2022/09/02"
          }
        ]
      }
    },
    methods: {

    },
    components: {
     // TeacherNav,
      //TeacherHeader,
      TeacherData
    }
  }
  </script>

  <style scoped>
    .container{
      width: 1200px;
      margin: 0 auto;
      display: flex;
      /* height: 200px; */
      /* background-color: brown; */
    }
    .tbody{
      display: flex;
      flex-direction: column;
      /* justify-content: center; */
      background-color: #efefef;
      min-height: 800px;
    }
    .line{
      width: 1200px;
      height: 50px;
      background-color: #3c85d7;
      line-height: 50px;
    }
    .line > span{
      float: left;
      margin-left: 50px;
      font-size: 20px;
    }
    .line > input{
      float: right;
      width: 390px;
      height: 20px;
      position: relative;
      top: 50%;
      transform: translateY(-50%);
      margin-right: 20px;
    }
  </style>
