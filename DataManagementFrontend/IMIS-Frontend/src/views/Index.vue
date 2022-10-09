<template>
    <!-- <TeacherNav></TeacherNav> -->
    <div class="container">
      <!-- <TeacherHeader></TeacherHeader> -->
      <div>
        <div>
          <span>资料</span>
          <input placeholder="搜索"/>
          <!-- <TeacherData></TeacherData> -->
        </div>
      </div>
    </div>
</template>

<script>
// import TeacherNav from './components/TeacherNav.vue'
// import TeacherHeader from './components/TeacherHeader.vue'
// import TeacherData from './components/TeacherData.vue'
export default {
  data () {
    return {

    }
  },
  methods: {

  }
  // components: {
  //   TeacherNav,
  //   TeacherHeader,
  //   TeacherData
  // }
}
</script>

<style lang="scss" scoped>
  .container{
    width:1200px;
    margin: 0 auto;
    display: flex;
    background-color: red($color: #000000);
    height: 500px;
  }
</style>
