<template>
  <div class="container">
    <div class="body">
      <div class="menu">
        <el-menu
          active-text-color="#ffd04b"
          background-color="#545c64"
          class="el-menu-vertical-demo"
          default-active="1"
          text-color="#fff"
          @close="handleClose"
          @open="handleOpen">
          <el-submenu index="1">
            <template slot="title">
              <span>教师管理</span>
            </template>
            <el-menu-item-group>
              <el-menu-item index="1-1">
                <router-link to="/manage/filemanage">文件管理</router-link>
              </el-menu-item>
              <el-menu-item index="1-2">
                <router-link to="/manage/teachermanage">账号管理</router-link>
              </el-menu-item>
            </el-menu-item-group>
          </el-submenu>
          <el-submenu index="2">
            <template slot="title">
              <span>学生</span>
            </template>
            <el-menu-item-group>
              <el-menu-item index="2-1">
                <router-link to="#">账号管理</router-link>
              </el-menu-item>
            </el-menu-item-group>
          </el-submenu>
          <el-submenu index="3">
            <template slot="title">
              <span>竞赛</span>
            </template>
            <el-menu-item-group>
              <el-menu-item index="3-1">
                <router-link to="#">竞赛管理</router-link>
              </el-menu-item>
              <el-menu-item index="3-2">
                <router-link to="#">经验管理</router-link>
              </el-menu-item>
            </el-menu-item-group>
          </el-submenu>
          <el-submenu index="4">
            <template slot="title">
              <span>新闻</span>
            </template>
            <el-menu-item-group>
              <el-menu-item index="4-1">
                <router-link to="#">新闻管理</router-link>
              </el-menu-item>
              <el-menu-item index="4-2">
                <router-link to="#">新闻发布</router-link>
              </el-menu-item>
            </el-menu-item-group>
          </el-submenu>
        </el-menu>
      </div>
      <div class="context">
        <router-view></router-view>
      </div>
    </div>

  </div>
</template>

<script>

export default {
  name: 'Manage',

  methods: {
    handleOpen(key, keyPath) {
    },
    handleClose(key, keyPath) {
    }
  },

  components: {}
}
</script>

<style lang="scss" scoped>
.body {
  display: flex;
}

.body .menu {
  width: 201px;
  background-color: #545C64;
  min-height: 1000px;
}

.body .context {
  // height: 100%;
  // width: 100%;

}

.body .menu ul {
  // width: 201px;
  // height: 100%;
}


</style>
