<template>
  <nav>
    <div class="logo">logo</div>
    <div class="el-menu-resource" href="#"><span class="line">资源广场</span></div>
    <div class="el-menu-search" >
      <div class="search-icon"><span class="iconfont">&#xe651;</span></div>
      <input v-model="keyword" type="text" class="searchInput"
      placeholder="请输入搜索内容 ">
    </div>
    <div class="el-menu-center" href="#">个人中心</div>
    <div class="el-menu-push" href="#">上传</div>
  </nav>
</template>
<script>
export default {
  name: "TeacherNav_"
}
</script>

<style scoped>
nav {
  display: flex;
  align-items: center;
  justify-content: center;
  width: 100%;
  background-color: #FFFFFF;
}

nav .logo {
  background-color: #FFFFFF;
  margin-right:10px;
  display: flex;
  height: 35px;
  width: 120px;
  border-radius: 10px;

}

nav .el-menu-resource {
  color: #3C85D7;
  padding: 15px 50px;
  margin-left:10px;
  margin-right:10px;
  position: relative;
  text-align: center;
  display: flex;
  font-size: larger;
  font-weight: bold;
}

.line:hover{
  border-bottom: 1px dashed #3C85D7;
}

nav .el-menu-resource:hover {
  /* text-decoration-line: underline;  */
  cursor: pointer; 
  color: #409EFF;
  cursor: pointer;
  color: #409EFF;
}

nav .el-menu-search {
  color: #FFFFFF;
  width: 450px;
  /* height: 35px; */
  padding: 15px 50px;
  margin-left:50px;
  margin-right:50px;
  position: relative;
  display: flex;
  font-size: larger;
  font-weight: bold;
}
.iconfont{
  font-family: "iconfont" !important;
  font-size: 22px;
  font-style: normal;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #FFFFFF
}
nav .search-icon{
  width: 70px;
  height: 40px;
  background-color: #DCE9F8;
  border-radius: 10px 0 0 10px ;
  display: flex;
  align-items: center;
  justify-content: center;
  cursor: pointer;
}
nav .search-icon:hover{
  background-color: #679cd1
}
nav .searchInput {
  width: 450px;
  height: 35px;
  border:#ccc 1px solid;
  text-align: center;
  position: relative;
  display: flex;
  height: 40px;
  border:#ccc 1px solid;
  font-size: 18px;
  border-radius: 0 10px 10px 0;
  padding-left: 10px;
}

nav .el-menu-center {
  color: #3C85D7;
  padding: 15px 50px;
  margin-left:10px;
  margin-right:10px;
  position: relative;
  text-align: center;
  display: flex;
  font-size: larger;
  font-weight: bold;
}

nav .el-menu-center:hover {
  cursor: pointer;
  color: #409EFF;
}

nav .el-menu-push {
  color: #FFFFFF;
  padding: 15px 50px;
  float: right;
  margin-left:10px;
  margin-right:10px;
  border-radius: 30px;
  position: relative;
  text-align: center;
  border-bottom: transparent;
  display: flex;
  transition: 0.4s;
  font-size: larger;
  font-weight: bold;
  background-color: #3C85D7;
}
nav .el-menu-push:hover {
  background-color: #1E5594;
  /* height: 48px; */
  cursor: pointer;

}

</style>
