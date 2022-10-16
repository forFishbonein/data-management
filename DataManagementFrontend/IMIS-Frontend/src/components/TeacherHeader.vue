<template>
  <div class="teacher-header">
    <div class="bgpicture">
      <img  alt="背景"
              src="https://img.tukuppt.com/bg_grid/00/09/63/Si1rs8A7Di.jpg!/fh/350"
              id=""
              >
    </div>
    <div class="teacher">
      <div class="teacher-pic">
        <img  alt="头像"
              src="https://ts2.cn.mm.bing.net/th?id=OIP-C.19LPGfyiWw_LZodJOolXSAHaHa&w=250&h=250&c=8&rs=1&qlt=90&o=6&dpr=1.25&pid=3.1&rm=2"
              id=""
              >
      </div>
      <div class="teacher-info">
        <div class ="info1">
          <div class="teacher-name">{{ name }}</div>
          <div class="teacher-title">教师职称：{{ title }}</div>
        </div>
        <div class="info2">
          <div class="file">资料总数：{{ total }}</div>
          <div class="phone-number">电话：{{ telNumber }}</div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      name: "AAA",
      title: "副教授",
      telNumber: "12345678901",
      total: "5"
    }
  }
}
</script>

<style scoped>

.teacher-header{
  margin-top: 40px;
  display: flex;
  flex-direction: column;
  height:200px;
}

.bgpicture {
  border:-1;
  background-color: gainsboro;
  width: 1200px;
  height: 120px;
}

.bgpicture>img{
  width: 1200px;
  height: 153px;
}

.teacher {
  display: flex;
  flex-direction: row;
  height: 70px;
  margin-bottom: 8px;
}

.teacher .teacher-pic {
  width: 110px;
  height: 110px;
  border-radius: 100%;
  position: absolute;
  margin: -40px 0 0 30px;
  background-color: rgb(167, 59, 59);
}

.teacher-pic>img{
  width: 110px;
  height: 110px;
  border-radius: 100%;
}

.teacher .teacher-info {
  margin-left:150px;
}

.teacher .teacher-info .info1 {

  display: flex;
  flex-direction: row;

}
.teacher .teacher-info .info1 .teacher-name {
  color: #3C85D7;
  font-size: 28px;
  line-height: 40px;
  font-weight: 550;
  margin-left: 20px;
}

.teacher .teacher-info .info1 .teacher-title {
  color: #3C85D7;
  font-size: normal;
  line-height:35px;
  font-weight: 400;
  margin-left: 100px;
  margin-top: 8px;

}

.teacher .teacher-info .info2 {
  display: flex;
  flex-direction: row;
}
.teacher .teacher-info .info2 .file {
  color: #3C85D7;
  font-size: normal;
  line-height:35px;
  font-weight: 400;
  margin-left: 20px;
}

.teacher .teacher-info .info2 .phone-number {
  color: #3C85D7;
  font-size: normal;
  line-height:35px;
  font-weight: 400;
  margin-left: 75.5px;
}

</style>
