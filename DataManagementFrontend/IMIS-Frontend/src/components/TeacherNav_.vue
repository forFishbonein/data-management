<template>
  <nav>
    <div class="logo">
      <img  src="../../static/img/logo.png"
            alt="logo">
    </div>
    <div class="el-menu-resource" href="#">
      <div class="aword1">资源广场</div>
    <span class="aline"></span>
    <!-- <span class="bline"></span> -->
  </div>
    <div class="el-menu-search" >
      <NavSearch></NavSearch>
    </div>
    <div class="el-menu-center" href="#">
      <div class="aword2">个人中心</div>
      <span class="bline"></span>
    </div>
    <div class="el-menu-push" href="#">上传</div>
  </nav>
</template>
<script>
import NavSearch from '../components/NavSearch.vue'
export default {
  name: "TeacherNav_",
  components:{
    NavSearch
  }
}
</script>

<style scoped>
nav {
  display: flex;
  align-items: center;
  justify-content: center;
  width: 100%;
  background-color: #FFFFFF;
  box-shadow: 0px 0px 4px 0px #353333 ;
  height: 70px;
  /* margin-bottom: 20px; */
  position: fixed;
  top: 0px;
  z-index: 999;
}

nav .logo {
  background-color: #FFFFFF;
  margin-right:10px;
  display: flex;
  height: 35px;
  width: 120px;
  border-radius: 10px;

}
nav .logo>img{
  width: 120px;
  height:35px;
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
  cursor: pointer;
}
.aword1{
  height:30px;
  width:100px;
  position: relative;
}
.aline{
  border-bottom: 3px solid #409EFF;
  height: 0px;
  /* width:100px; */
  position: absolute;
  top:50px;

}
.el-menu-resource:hover .aline{
  animation:lineChange1 1s;
  /* animation-direction: alternate; */
  animation-fill-mode: forwards;
}
@keyframes lineChange1{
    from{
      width:0px
    }
    to{
      width:100px
    }
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
  cursor: pointer;
}

.aword2{
  height:30px;
  width:100px;
  position: relative;
}
.bline{
  border-bottom: 3px solid #409EFF;
  height: 0px;
  /* width:100px; */
  position: absolute;
  top:50px;

}
.el-menu-center:hover .bline{
  animation:lineChange2 1s;
  /* animation-direction: alternate; */
  animation-fill-mode: forwards;
}

@keyframes lineChange2{
    from{
      width:0px
    }
    to{
      width:100px
    }
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
