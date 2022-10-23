<template>
  <div class="search">
    <input v-model="keyword" class="searchInput" placeholder="请输入搜索内容 " type="text">
    <div class="search-icon" @click="getSearchResults(keyword)"><span class="iconfont">&#xe651;</span></div>

  </div>

</template>

<script>
import {getSearchResults} from '@/api'


export default {
  name: "NavSearch",

  data() {
    return {
      keyword: '',
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
.search {
  color: #FFFFFF;
  width: 550px;
  position: relative;
  display: flex;
  margin-top: 5px;
}

.iconfont {
  font-family: "iconfont" !important;
  font-size: 22px;
  font-style: normal;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #FFFFFF
}

nav .search-icon {
  width: 60px;
  height: 36px;
  background-color: #dce9f8;
  border-radius: 0px 8px 8px 0px;
  border-right: #ccc 1.5px solid;
  display: flex;
  align-items: center;
  justify-content: center;
  cursor: pointer;
}


nav .searchInput {
  width: 550px;
  position: relative;
  display: flex;
  height: 36px;
  border-left: #ccc 1.5px solid;
  border-radius: 8px 0px 0px 8px;
  font-size: 16px;
  padding-left: 10px;
}

nav .search-icon,
nav .searchInput {
  border-top: #ccc 1.5px solid;
  border-bottom: #ccc 1.5px solid;
}

.search-icon:hover,
.searchInput:hover,
.search-icon:hover ~ .searchInput,
.searchInput:hover ~ .search-icon,
.searchInput:focus,
.searchInput:focus ~ .search-icon {
  border-top: #3c85d7 2px solid;
  border-bottom: #3c85d7 2px solid;
}

.search-icon:hover {
  background-color: #3c85d7
}

.search .searchInput:hover ~ .search-icon,
.search .searchInput:focus ~ .search-icon,
.search .search-icon:hover {
  border-right: #3c85d7 2px solid;
}

.search .search-icon:hover ~ .searchInput,
.search .searchInput:focus,
.search .searchInput:hover {
  border-left: #3c85d7 2px solid;
}

</style>
