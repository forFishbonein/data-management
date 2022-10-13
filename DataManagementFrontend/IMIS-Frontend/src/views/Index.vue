<template>
  <div>
    <TeacherNav></TeacherNav>
    <div class="container">
      <TeacherHeader></TeacherHeader>
      <div class="tbody">
        <div class="line">
          <span>资料</span>
          <div class="right-search">
            <div class="search-icon"><span class="iconfont">&#xe651;</span></div>
            <input placeholder="搜索" class="tsearch"/>
          </div>
        </div>
        <div v-for="(item,index) in tdata" :key="index">
          <TeacherData :id="item.id" :title="item.title" :name="item.name" :desc="item.desc"
                       :time="item.time"></TeacherData>
        </div>
      </div>
      <el-pagination
      background
      layout="prev, pager, next"
      :total="1000"
      class="apage">
      </el-pagination>
    </div>
  </div>
</template>

<script>
import TeacherNav from '../components/TeacherNav.vue'
import TeacherHeader from '../components/TeacherHeader.vue'
import TeacherData from '../components/TeacherData.vue'

export default {
  data() {
    return {
      tdata: [
        {
          "id": 1,
          "title": "哈哈",
          "desc": "中南民大",
          "name": "张三",
          "time": "2022/09/01"
        },
        {
          "id": 2,
          "title": "哈哈咯咯咯",
          "desc": "中南民大管理学院",
          "name": "李四",
          "time": "2022/09/02"
        },
        {
          "id": 3,
          "title": "哈哈咯咯咯",
          "desc": "中南民大管理学院",
          "name": "李四",
          "time": "2022/09/02"
        },
        {
          "id": 4,
          "title": "哈哈咯咯咯",
          "desc": "中南民大管理学院",
          "name": "李四",
          "time": "2022/09/02"
        },
        {
          "id": 5,
          "title": "哈哈咯咯咯",
          "desc": "中南民大管理学院",
          "name": "李四",
          "time": "2022/09/02"
        }
      ]
    }
  },
  methods: {},
  components: {
    TeacherNav,
    TeacherHeader,
    TeacherData
  }
}
</script>

<style lang="scss" scoped>
.container {
  width: 1200px;
  margin: 0 auto;
  display: flex;
  flex-direction: column;
  /* height: 200px; */
  /* background-color: brown; */
  // margin-top: 50px;
  padding-bottom: 50px;
  .tbody {
    display: flex;
    flex-direction: column;
    /* justify-content: center; */
    background-color: #f5f9ff;
    min-height: 800px;

    .line {
      width: 1200px;
      height: 50px;
      background-color: #7a91bc;
      display: flex;
      justify-content: space-between;
      align-items: center;
      background-color: #DCE9F8;
      .right-search{
        // width:390px;
        margin-right: 30px;
      }
      .search-icon{
        width: 40px;
        height: 35px;
        background-color: #DCE9F8;
        border-radius: 10px 0 0 10px ;
        float: left;
        display: flex;
        align-items: center;
        justify-content: center;
        cursor: pointer;
        border: 1px #7A91BC solid;
        border-right:none;
      }
      .search-icon:hover{
        background-color: #679cd1
      }
      .iconfont{
        font-family: "iconfont" !important;
        font-size: 22px;
        font-style: normal;
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale;
        color: #FFFFFF
      }
      .tsearch{
        width: 350px;
        height: 35px;
        border-radius: 0 10px 10px 0;
        padding-left: 10px;
        // float: right;
        background-color: #DCE9F8;
        border: 1px #7A91BC solid;
        border-left:none;
        font-size:18px;
      }
    }

    .line > span {
      float: left;
      margin-left: 50px;
      font-size: 20px;
    }

    .line > input {
      float: right;
      width: 390px;
      height: 20px;
      position: relative;
      top: 50%;
      transform: translateY(-50%);
      margin-right: 20px;
      padding-left: 20px;
      border-radius: 10px;
    }
  }
  .apage{
    margin-top: 30px;
  }
}


</style>
