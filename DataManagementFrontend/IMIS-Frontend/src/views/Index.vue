<template>
<!--   // <TeacherNav></TeacherNav>-->
    <div class="container">
    <TeacherHeader></TeacherHeader>
      <div>
        <div>
          <span>资料</span>
          <input placeholder="搜索"/>
          <TeacherData></TeacherData>
        </div>
      </div>
    </div>
</template>

<script>
//import TeacherNav from './components/TeacherNav.vue'
import TeacherHeader from '../components/TeacherHeader.vue'
import TeacherData from '../components/TeacherData.vue'
export default {
  data () {
    return {

    }
  },
  methods: {

  },
  components: {
   // TeacherNav,
    TeacherHeader,
    TeacherData
  }
}
</script>

<style scoped>

</style>
