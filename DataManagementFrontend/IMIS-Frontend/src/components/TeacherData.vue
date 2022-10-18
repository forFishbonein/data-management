<template>
  <div id="container">
    <div class="context">
      <div class="title">{{ title }}</div>
      <div class="introduction">{{ introduction }}</div>

    </div>
    <div class="img">
      <img
        src="https://img-blog.csdnimg.cn/51f3f7c487314ec2b3f5c3f526987009.png"
        alt="pic">
    </div>
    <span class="time">上传时间:{{ time }}&nbsp;</span>
    <span class="download" @click="dialogVisible = true" v-show="filePath.length">下载附件</span>

    <span class="download-box" v-show="dialogVisible">
        <div class="download-box-close" @click="dialogVisible = false">X</div>
        <p v-for="(file,index) in filePath" :key="index">{{ file }}</p>
      </span>
  </div>
</template>

<script>
export default {
  name: "TeacherData",

  methods: {
  },

  data() {
    return {
      dialogVisible: false
    }


  },
  props: {
    id: {
      type: Number,
      default: null
    },
    title: {
      type: String,
      default: "资料"
    },
    introduction: {
      type: String,
      default: "这里是中南民族大学这里是中南民族大学这里是中南民族大学这里是中南民族大学这里是中南民族大学这里是中南民族大学这里是中南民族大学这里是中南民族大学这里是中南民族大学这里是中南民族大学这里是中南民族大学这里是中南民族大学这里是中南民族大学这里是中南民族大学这里是中南民族大学这里是中南民族大学这里是中南民族大学这里是中南民族大学这里是中南民族大学这里是中南民族大学这里是中南民族大学这里是中南民族大学这里是中南民族大学这里是中南民族大学这里是中南民族大学这里是中南民族大学这里是中南民族大学这里是中南民族大学这里是中南民族大学这里是中南民族大学这里是中南民族大学这里是中南民族大学这里是中南民族大学"
    },
    name: {
      type: String,
      default: "张三，李四"
    },
    time: {
      type: String,
      default: "2022-10-9"
    },
    filePath: {
      type: Array
    }
  }
}
</script>

<style scoped>

#container {
  position: relative;
  width: 1100px;
  height: 200px;
  margin: 8px auto;
  padding: 8px;
  border-bottom: 1px solid #e5e5e5;
}

.context {
  float: left;
}

.img img{
  width: 200px;
  height: 150px;
  float: right;
}

.title {
  font-size: 18px;
  font-weight: bold;
  color: #3C85D7;
}

.introduction {
  display: flex;
  margin-top: 8px;
  width: 800px;
  font-size: 14px;
  color: #3C85D7;
}

.time {
  position: absolute;
  left: 0;
  bottom: 0;
  margin-top: 10px;
}

.download {
  position: absolute;
  left: 170px;
  bottom: 3px;
  font-size: 14px;
  color: #6ca6f5;
}

.download:hover {
  color: #3d80ce;
  cursor: pointer;
}

.download-box {
  float: left;
  position: absolute;
  z-index: 999;
  left: 50%;
  margin-left: -250px;
  width: 500px;
  background-color: #3d80ce;
}

.download-box-close {
  height: 30px;
  background-color: #3d80ce;
}

</style>
