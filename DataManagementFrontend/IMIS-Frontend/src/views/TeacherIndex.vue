<template>
  <div class="body">
    <TeacherNav></TeacherNav>
    <div class="container">
      <TeacherHeader></TeacherHeader>
      <div class="tbody">
        <div class="line">
          <div class="decoration1"></div>
          <span class="title">资料</span>
        </div>
        <div class="data">
          <div class="notify" v-show="!materials.length">您还没有上传资源</div>
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

      </div>
      <el-pagination
        background
        layout="prev, pager, next"
        :total="1000"
        align="center"
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
      materials: []
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
  padding-bottom: 50px;


  .tbody {
    display: flex;
    flex-direction: column;
    background-color: #F5F9FF;
    border-radius: 12px;
    margin-top: 10px;


    .line {
      width: 1200px;
      height: 50px;
      background-color: #FFFFFF;
      display: flex;
      align-items: center;
      border-top-left-radius: 12px;
      border-top-right-radius: 12px;
    }

    .decoration1 {
      width: 3px;
      height: 25px;
      background-color: #1E5594;
      margin-left: 50px;
      margin-top: 1px;
    }

    .line > span {
      float: left;
      margin-left: 8px;
      font-size: 20px;
      color: #113355;
      font-weight: 550;
      margin-right: 0;
    }
  }


  .apage {
    margin-top: 30px;
  }
  .data {
    min-height: 35vh;
    background-color: white;
    border-radius: 12px;

    .notify {
      text-align: center;
    }

  }

  .data-container {
    background-color: #FFFFFF;
  }
}


</style>
