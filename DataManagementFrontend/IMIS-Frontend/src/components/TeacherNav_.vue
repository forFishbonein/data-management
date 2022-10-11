<template>
  <nav>
    <div class="logo">logo</div>
    <div class="el-menu-resource" href="#">资源广场</div>
    <div class="el-menu-search" >
      <!-- <img src="../../static/img/img.png" id="img1"> -->
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
  color: #FFFFFF;
  padding: 15px 50px;
  margin-left:10px;
  margin-right:10px;
  position: relative;
  text-align: center;
  border-bottom: transparent;
  display: flex;
  transition: 0.4s;
  font-size: larger;
  font-weight: bold;
}
nav .el-menu-resource:hover {
  cursor: pointer; 
  color: #409EFF; 
}

nav .el-menu-search {
  color: #FFFFFF;
  width: 450px;
  padding: 15px 50px;
  margin-left:50px;
  margin-right:50px;
  position: relative;
  display: flex;
  transition: 0.4s;
  font-size: larger;
  font-weight: bold;
}
nav .searchInput {
  width: 450px;
  text-align: left;
  line-height: 1rem;
  border:#ccc 1px solid;
  text-align: center;
  font-size: 18px;
  border-radius: 10px;
}

nav .el-menu-center {
  color: #FFFFFF;
  padding: 15px 50px;
  margin-left:10px;
  margin-right:10px;
  position: relative;
  text-align: center;
  border-bottom: transparent;
  display: flex;
  transition: 0.4s;
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
}
nav .el-menu-push:hover {
  background-color: #7A91BC;
  /* height: 48px; */
  cursor: pointer;

}

</style>
