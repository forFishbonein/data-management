<template>
  <div class="main">
    <TeacherNav></TeacherNav>
    <div class="container">
      <!-- <TeacherHeader></TeacherHeader> -->
      <div class="tbody">
        <div class="line"><h2>搜索结果</h2></div>
        <div class="check">
          <div><input v-model="picked" type="checkbox" value="科研项目"/>&ensp;科研项目</div>
          <div><input v-model="picked" type="checkbox" value="教研项目"/>&ensp;教研项目</div>
          <div><input v-model="picked" type="checkbox" value="荣誉"/>&ensp;荣誉</div>
          <div><input v-model="picked" type="checkbox" value="成果"/>&ensp;成果</div>
          <div><input v-model="picked" type="checkbox" value="学生竞赛"/>&ensp;学生竞赛</div>
          <div><input v-model="picked" type="checkbox" value="交流访问"/>&ensp;交流访问</div>
          <div><input v-model="picked" type="checkbox" value="党支部"/>&ensp;党支部</div>
          <div><input v-model="picked" type="checkbox" value="其他"/>&ensp;其他</div>

          <ul>
            <li v-for="(item, index) in picked" :key="index">{{ item }}</li>
          </ul>
        </div>

        <!-- <TeacherSearch></TeacherSearch> -->
        <div v-for="(item, index) in materials" :key="index">
          <TeacherData :id="item.id" :desc="item.desc" :name="item.name" :time="item.time"
                       :title="item.title"></TeacherData>
        </div>
      </div>
      <el-pagination
        :total="1000"
        background
        class="apage"
        layout="prev, pager, next">
      </el-pagination>
    </div>
  </div>
</template>

<script>
import TeacherNav from '../components/TeacherNav.vue'
// import TeacherHeader from '../components/TeacherHeader.vue'
// import TeacherSearch form '../components/TeacherSearch.vue'
import TeacherData from '../components/TeacherData.vue'
import {getMaterials} from '@/api'

export default {
  name: 'Search',

  data() {
    return {
      materials: []
    }
  },
  methods: {
    getMaterials() {
      getMaterials().then(
        response => {
          this.materials = response.data
        },
        error => {
          console.log('请求失败了', error.message)
        }
      )
    }
  },
  components: {
    TeacherNav,
    // TeacherHeader,
    TeacherData,
    // TeacherSearch
  },
  mounted() {
    this.getMaterials();
  },


}
</script>

<style lang="scss" scoped>

.main {
  background-color: #f5f9ff;
}

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
    background-color: white;
    min-height: 800px;

    .line {
      margin-top: 20px;
      margin-left: 30px;
      color: black;
      width: 1200px;
      height: 50px;
      display: flex;
      justify-content: space-between;
      align-items: center;
    }

    .check {
      margin-left: 30px;
      margin-top: 5px;
      color: black;
      width: 1000px;
      height: 50px;
      display: flex;
      justify-content: space-between;
      align-items: center;

    }
  }

  .apage {
    margin-top: 30px;
  }
}


</style>
