<template>
  <div id="container">
    <div class="context">
      <div class="title">{{ title }}</div>
      <div class="introduction">{{ introductionManage(introduction) }}</div>
    </div>
    <span class="time">上传时间:{{ createTime }}&nbsp;</span>
  </div>
</template>

<script>
export default {
  name: "TeacherData",
  mounted() {
  },

  methods: {
    introductionManage(str) {
      if (str.length > 250) {
        console.log(str)
        str = str.substr(0, 247) + "...";
      }
      return str;
    }
  },

  data() {
    return {
      dialogVisible: false
    }


  },
  props: {
    id: {
      type: Number,
    },
    title: {
      type: String,
    },
    introduction: {
      type: String,
    },
    name: {
      type: String,
    },
    createTime: {
      type: String,
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

#container:hover {
  cursor: pointer;
  background-color: #efefef;
  transition: .5s;
  box-shadow: 2px 1px 8px 0px rgba(23, 22, 22, 0.1);

}

.context {
  float: left;
}

.img img {
  width: 210px;
  height: 140px;
  float: right;
}

.title {
  font-size: 18px;
  font-weight: bold;
  color: #1a4d7f;
  margin-top: 8px;
  margin-left: 15px;
}

.introduction {
  display: flex;
  padding: 15px;
  width: 1100px;
  font-size: 16px;
  color: #666;
}

.time {
  position: absolute;
  left: 0;
  bottom: 0;
  margin-bottom: 10px;
  margin-left: 23px;
  font-size: 14px;
  color: #595959;

}

</style>
