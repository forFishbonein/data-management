<template>
  <nav>
    <!-- <div class="logo"><img src="../logo.png"></div> -->
    <div class="logo"><img src="./logo.png"></div>
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

<style lang="css">
nav {
  display: flex;
  align-items: center;
  justify-content: center;
}

nav .logo {
  padding: 15px 50px;
  margin-left:10px;
  margin-right:10px;
  position: relative;
  text-align: center;
  border-bottom: transparent;
  display: flex;
  height: 48px;
  width: 80px;

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
nav.searchInput {
  width: 100px;
  margin-top: .5rem;
  margin-left: 4%;
  margin-right: 4%;
  line-height: 2rem;
  border:#ccc 1px solid;
  text-align: center;
  font-size: 18px;
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
  /* background-color: darkgray; */
  border-bottom: solid 2px;
  border-bottom-color: rgb(18, 17, 17); 
  height: 48px;
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
   /*  border-bottom: solid 2px;
  border-bottom-color: rgb(18, 17, 17); */
  height: 48px;
}

</style>
