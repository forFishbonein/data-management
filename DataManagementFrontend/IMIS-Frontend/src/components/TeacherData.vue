<template>
  <div id="container">
    <div class="context">
      <div class="title">{{ title }}</div>
      <div class="introduction">{{ introduction }}</div>
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
  mounted() {
  },


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
  height: 160px;
  margin: 0 auto;
  margin-bottom: 16px;
  padding: 8px;
  background-color: #fafafa;
  box-shadow: 2px 1px 8px 0px rgba(0, 0, 0, 0.10);
  border-radius: 5px;
  /* border-bottom: 1px solid #e5e5e5; */
}

.context {
  float: left;
}

.img img{
  width: 210px;
  height: 140px;
  float: right;
}

.title {
  font-size: 18px;
  font-weight: bold;
  color: #1a4d7f;
  margin-top:8px;
  margin-left:15px;
}

.introduction {
  display: flex;
  padding: 15px;
  width: 1100px;
  font-size: 16px;
  color: #3C85D7;
}

.time {
  position: absolute;
  left: 0;
  bottom: 0;
  margin-bottom: 10px;
  margin-left:23px;
  font-size: 14px;
  color:#595959;

}

.download {
  position: absolute;
  left: 170px;
  bottom: 1px;
  font-size: 14px;
  color: #6ca6f5;
  margin-bottom: 10px;
  margin-left:30px;
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
