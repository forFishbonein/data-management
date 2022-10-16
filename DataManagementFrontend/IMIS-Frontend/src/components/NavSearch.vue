<template>
    <div class="el-menu-search" >
      <div class="search-icon" @click="getSearchResults(keyword)"><span class="iconfont">&#xe651;</span></div>
      <input v-model="keyword" type="text" class="searchInput"
      placeholder="请输入搜索内容 ">
    </div>
</template>

<script>
import {getSearchResults} from '@/api'


export default {
  name: "NavSearch",

  data() {
    return {
      keyword: '',
      // searchResult:[]
    }
  },
  methods: {
    getSearchResults(keyword) {
      getSearchResults(keyword).then(
        response => {
          console.log(response.data)
          // this.$bus.$emit('searchResult',response.data.data)
          this.$bus.$emit('searchResult', response.data)
        },
        error => {
          console.log('请求失败了', error.message)
        }
      )
    }
  },
}


</script>

<style scoped>
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
  text-align: left;
  /* line-height: 1rem; */
  border:#ccc 1px solid;
  /* text-align: center; */
  font-size: 18px;
  border-radius: 0 10px 10px 0;
  padding-left: 10px;
}


</style>