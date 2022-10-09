<template>
  <nav>
    <div><img src="./logo.png" class="logo"></div>
    <div class="el-menu-resource" href="#">资源广场</div>
    <div class="el-menu-search" >
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
  /* padding: 15px 50px; */
  /* margin-left:10px; */
  margin-right:50px;
  /* position: relative; */
  /* text-align: center; */
  /* border-bottom: transparent; */
  display: flex;
  height: 20px;
  width: 50px;

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
  /* background-color: darkgray; */
  border-bottom: solid 2px;
  border-bottom-color: rgb(18, 17, 17);
  height: 48px;
  cursor: pointer;
}

nav .el-menu-search {
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
nav .searchInput {
  width: 400px;
  margin-left: 4%;
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
  border-bottom: solid 2px;
  border-bottom-color: rgb(18, 17, 17);
  height: 48px;
  cursor: pointer;
}

nav .el-menu-push {
  color: #FFFFFF;
  padding: 15px 50px;
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
  background-color: darkgray;
  /* height: 48px; */
  cursor: pointer;

}

</style>
