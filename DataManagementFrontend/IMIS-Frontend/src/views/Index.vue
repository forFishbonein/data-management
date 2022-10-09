<template>
<<<<<<< HEAD
<!--   // <TeacherNav></TeacherNav>-->
    <div class="container">
    <TeacherHeader></TeacherHeader>
=======
  <div>
<<<<<<< HEAD
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
=======
    <TeacherNav></TeacherNav>
    <div class="container">
      <!-- <TeacherHeader></TeacherHeader> -->
>>>>>>> 74803a7dc83a334dd0b9d02482cbf6859ecb95c3
      <div>
        <div>
          <span>资料</span>
          <input placeholder="搜索"/>
<<<<<<< HEAD
          <TeacherData></TeacherData>
        </div>
      </div>
    </div>
</template>

<script>
//import TeacherNav from './components/TeacherNav.vue'
import TeacherHeader from '../components/TeacherHeader.vue'
=======
          <!-- <TeacherData></TeacherData> -->
>>>>>>> 9c2b76bd6bc95fab3ffbf23527b54596263b2c22
        </div>
      </div>
    </div>
  </div>
</template>

<<<<<<< HEAD
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
=======
<script>
import TeacherNav from '../components/TeacherNav.vue'
// import TeacherHeader from './components/TeacherHeader.vue'
>>>>>>> 74803a7dc83a334dd0b9d02482cbf6859ecb95c3
import TeacherData from '../components/TeacherData.vue'
export default {
  data () {
    return {
>>>>>>> 9c2b76bd6bc95fab3ffbf23527b54596263b2c22

    }
  },
  methods: {

  },
  components: {
<<<<<<< HEAD
   // TeacherNav,
    TeacherHeader,
    TeacherData
=======
    TeacherNav,
    // TeacherHeader,
     TeacherData
>>>>>>> 74803a7dc83a334dd0b9d02482cbf6859ecb95c3
  }
}
</script>

<<<<<<< HEAD
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
=======
<style scoped>

</style>
>>>>>>> 9c2b76bd6bc95fab3ffbf23527b54596263b2c22
