<template>
  <div class="body">
    <TeacherNav></TeacherNav>
    <div class="container">
      <div class="choose">
        <router-link to="/upload/teaching">科研项目</router-link>

        <router-link to="#">教研项目</router-link>

        <router-link to="#">各类荣誉</router-link>

        <router-link to="#">成果类</router-link>

        <router-link to="#">学生竞赛</router-link>

        <router-link to="#">交流访问</router-link>

        <router-link to="#">党支部</router-link>

        <router-link to="#">教研室</router-link>

        <router-link to="#">论文/期刊</router-link>

        <router-link class="ud" to="#">自定义</router-link>

      </div>
      <div class="context">
        <router-view></router-view>
      </div>

    </div>

  </div>


</template>

<script>
import TeacherNav from '../components/TeacherNav.vue'


export default {
  name: 'Upload',

  data() {
    return {}
  },
  methods: {},
  components: {
    TeacherNav
  },
  mounted() {


  }
}
</script>

<style lang="scss" scoped>

.body {
  background-color: #EAF2FB;

}

.choose {
  display: flex;
  width: 1200px;
  margin: 0 auto;
  margin-top: 10px;
  justify-content: space-evenly;
  border-bottom: #97a5c3 solid 0.5px;
  border-radius: 8px;
  background-color: #fdfdfd;
  box-shadow: rgba(50, 50, 93, 0.25) 0px 6px 12px -2px, rgba(0, 0, 0, 0.3) 0px 3px 7px -3px;
  transition: .3s;

  .active {
    color: #2d76cb;
  }

  .ud {
    color: #dccb00;
  }

  a {
    padding: 20px;
    height: 60px;
    transition: .3s;
    font-weight: bold;

  }

  a:hover {
    color: #2d76cb;
  }

}


</style>
