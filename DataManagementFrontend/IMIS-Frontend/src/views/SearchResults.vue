<template>
  <div>
    <TeacherNav></TeacherNav>
    <div class="container">
      <!-- <TeacherHeader></TeacherHeader> -->
      <div class="tbody">
        <div class="line"><h2>搜索结果</h2></div>
        <div class="check">
          <input type="checkbox" id="1" value="科研项目" v-model="picked" />科研项目
          <input type="checkbox" id="1" value="教研项目" v-model="picked" />教研项目
          <input type="checkbox" id="1" value="荣誉" v-model="picked" />荣誉
          <input type="checkbox" id="1" value="成果" v-model="picked" />成果
          <input type="checkbox" id="1" value="学生竞赛" v-model="picked" />学生竞赛
          <input type="checkbox" id="1" value="交流访问" v-model="picked" />交流访问
          <input type="checkbox" id="1" value="党支部" v-model="picked" />党支部
          <input type="checkbox" id="1" value="其他" v-model="picked" />其他

          <ul>
            <li v-for="(item, index) in picked" :key="index">{{item}}</li>
          </ul>
        </div>

        <!-- <TeacherSearch></TeacherSearch> -->
        <div v-for="(item, index) in result" :key="index">
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
// import TeacherHeader from '../components/TeacherHeader.vue'
// import TeacherSearch form '../components/TeacherSearch.vue'
import TeacherData from '../components/TeacherData.vue'

export default {
  name: 'SearchResult',

  data:{
    result:[],
    picked:[]
  },
  components: {
    TeacherNav,
    // TeacherHeader,
    TeacherData,
    // TeacherSearch
  },
  methods:{
    getResult(data){
      this.result = data
      console.log(data)
    }
  },
  mounted() {

    this.$bus.$on('searchResult',this.getResult)

    if(picked === null){

    }

  },
  beforeDestroy(){
    this.$bus.$off('searchResult')
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
      margin-top: 40px;
      margin-left: 30px;
      color: black;
      width: 1200px;
      height: 50px;
      display: flex;
      justify-content: space-between;
      align-items: center;
    }

    .check{
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
