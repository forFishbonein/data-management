<template>
  <div class="body">
    <TeacherNav></TeacherNav>
    <div class="container">
      <TeacherHeader></TeacherHeader>
        <div class="tbody">
          <div class="line">
            <div class="decoration1"></div>
            <span class="title">资料</span>
            <!-- <div class="right-search">
              <div class="search-icon"><span class="iconfont">&#xe651;</span></div>
              <input placeholder="搜索" class="tsearch"/>
            </div> -->
          </div>
          <div class="data-container" v-for="(item, index) in materials" :key="index">
            <TeacherData :id="item.id"
                        :title="item.title"
                        :name="item.name"
                        :introduction="item.introduction"
                        :createTime="item.createTime"
                        :filePath="item.filePath">
            </TeacherData>
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
import {getMaterials} from '@/api'

export default {
  data() {
    return {
      materials: [
      ]
    }
  },
  methods: {
    getMaterials() {
      getMaterials().then(resp => {
        this.materials = resp.data.data;
      });
    }
  },
  components: {
    TeacherNav,
    TeacherHeader,
    TeacherData
  },
  mounted() {
    this.getMaterials();
  }
}
</script>

<style lang="scss" scoped>

.body {
  background-color: #eaf2fb;
}

.container {
  width: 1200px;
  margin: 10px auto;
  display: flex;
  flex-direction: column;
  /* height: 200px; */
  /* background-color: brown; */
  // margin-top: 50px;
  padding-bottom: 50px;

  // .sub-container {
  //   margin-top:10px;
  //   width: 1200px;
  // }

  .tbody {
    display: flex;
    flex-direction: column;
    /* justify-content: center; */
    background-color: #F5F9FF;
    min-height: 800px;
    border-radius: 12px;
    margin-top: 10px;


    .line {
      // color: #3C85D7;
      width: 1200px;
      height: 50px;
      background-color: #FFFFFF;
      display: flex;
      // justify-content: space-between;
      align-items: center;
      border-top-left-radius: 12px;
      border-top-right-radius: 12px;
    }
    
    .decoration1 {
      width: 3px;
      height: 25px;
      background-color: #1E5594;
      margin-left: 50px;
      margin-top:1px;
    }

    .line > span {
      float: left;
      margin-left: 8px;
      font-size: 20px;
      color:#113355;
      font-size: 20px;
      font-weight: 550;
      margin-right:0;
    }
  }

  
  .apage {
    margin-top: 30px;
  }

  .data-container {
    background-color: #FFFFFF;
  }
}


</style>
