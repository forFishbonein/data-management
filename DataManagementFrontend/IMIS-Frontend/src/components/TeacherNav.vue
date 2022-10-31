<template>
  <div class="con">
    <nav>
      <div class="logo">
        <img alt="logo" src="../../static/img/logo.png">
      </div>
      <div class="resource">
        <router-link to="/resource">资源广场</router-link>
      </div>
      <div class="search">
        <NavSearch></NavSearch>
      </div>
      <div class="profile">
        <el-dropdown>
          <router-link to="/profile">个人中心</router-link>
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item @click="logout">退出登录</el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
      </div>
      <div class="upload">

        <router-link class="upload" to="/upload/studying"><span style="text-align: center">上传</span></router-link>
      </div>
    </nav>
  </div>
</template>
<script>
import NavSearch from '../components/NavSearch.vue'

export default {
  name: "TeacherNav",
  methods:{
    logout(){
      this.$store.dispatch('logout').then(res => {
        this.$message({message: '登出成功！', type: 'success', showClose: true});
        this.$router.push({path: '/'})
      }).catch((error) => {
        if (error !== 'error') {
          this.$message({message: error, type: 'error', showClose: true});
        }
      })
    }
  },
  components: {
    NavSearch
  },
}
</script>

<style scoped>
.con {
  position: sticky;
  top: 0;
  z-index: 999;

  width: 100%;
  height: 45px;
  background-color: #FFFFFF;
  box-shadow: rgba(149, 157, 165, 0.2) 0 8px 24px;
}

nav {
  display: flex;
  justify-content: space-between;
  width: 1200px;
  height: 45px;
  margin: 0 auto;
  font-size: 16px;
  line-height: 45px;
}

nav .resource a:before,
nav .profile a:before {
  content: '';
  height: 2px;
  background-color: #7dc5e7;
  width: 100%;
  position: absolute;
  left: 0;
  bottom: 2px;
  transform: scaleX(0);
  transition: .3s;
}

nav .resource a:hover:before,
nav .profile a:hover:before {
  transform: scaleX(1);
}

nav .logo {
  display: flex;
  margin-top: 5px;
}

nav .logo img {
  width: 120px;
  height: 35px;
}

nav .resource {
  position: relative;
  text-align: center;
  display: flex;
  cursor: pointer;
}

nav .profile {
  color: #3C85D7;
  position: relative;
  text-align: center;
  display: flex;
  cursor: pointer;
}

.el-dropdown-link {
  cursor: pointer;
  color: #409EFF;
}
.el-icon-arrow-down {
  font-size: 12px;
}

nav .upload {
  display: flex;
  width: 80px;
  height: 36px;
  color: #FFFFFF;
  line-height: 36px;
  letter-spacing: 3px;
  border-radius: 8px;
  transition: 0.25s;
  background-color: #3C85D7;
  margin-top: 3px;
}

nav .upload:hover {
  background-color: #1E5594;
  cursor: pointer;
}

nav .upload span {
  width: 100px;
  text-align: center;
}


</style>
