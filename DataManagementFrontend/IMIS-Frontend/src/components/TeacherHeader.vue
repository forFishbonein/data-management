<template>
  <div class="teacher-header">
    <div class="bgpicture">
      <img  alt="背景"
              src="https://img.tukuppt.com/bg_grid/00/09/63/Si1rs8A7Di.jpg!/fh/350"
              >
    </div>
    <div class="teacher">
      <div class="teacher-pic">
        <img  alt="头像"
              src="https://ts2.cn.mm.bing.net/th?id=OIP-C.19LPGfyiWw_LZodJOolXSAHaHa&w=250&h=250&c=8&rs=1&qlt=90&o=6&dpr=1.25&pid=3.1&rm=2"
              >
      </div>
      <div class="teacher-info">
        <div class ="info1">
          <div class="teacher-name">{{teacher.teacherName}}</div>
        </div>
        <div class="info2">
          <div class="teacher-title">教师职称：{{ teacher.teacherTitle }}</div>
          <div class="teacher-tele">电话：{{ teacher.teacherTele }}</div>
        </div>
        <div class="info3">
          <div class="teacher-sid">工号：{{ teacher.teacherSid }}</div>
          <div class="teacher-email">邮箱：{{ teacher.teacherEmail }}</div>
        </div>
      </div>
    </div>
  </div>
</template>


<script>
import {getByTeacherId} from '@/api'

export default {
  mounted() {
    console.log(this)
    this.getById(this.id);
  },
  methods: {
    getById(id) {
      getByTeacherId(id).then(resp => {
        this.teacher = resp.data.data;
        console.log(resp.data.data);
      });
    }
  },

  data() {
    return {
      id: "1581923146833891329",

      teacher: {
        teacherName: "BBB",
        teacherEmail: "w@w.ww",
        teacherSid: "20202107",
        teacherTitle: "副教授",
        teacherTele: "12345678901"
      }

    }
  }
}
</script>

<style scoped>

.teacher-header{
  display: flex;
  flex-direction: column;
  height:250px;
  border-radius: 12px;
}

.bgpicture {
  /* background-color: gainsboro; */
  width: 1200px;
  height: 120px;
  border-top-left-radius: 12px;
  border-top-right-radius: 12px;

}

.bgpicture>img{
  width: 1200px;
  height: 153px;
  border-top-left-radius: 12px;
  border-top-right-radius: 12px
}

.teacher {
  display: flex;
  flex-direction: row;
  height: 300px;
  margin-bottom: 8px;
  background-color: #FFFFFF;
  border-radius: 12px;
}

.teacher .teacher-pic {
  width: 110px;
  height: 110px;
  border-radius: 100%;
  position: absolute;
  margin: -40px 0 0 30px;
}

.teacher-pic>img{
  width: 110px;
  height: 110px;
  border-radius: 100%;
}

.teacher .teacher-info {
  margin-top: -10px;
  margin-left:150px;
}

.teacher .teacher-info .info1 {
  display: flex;
  flex-direction: row;

}

.teacher .teacher-info .info1 .teacher-name {
  color: #1A4D7F;
  font-size: 26px;
  line-height: 40px;
  font-weight: 550;
  margin-left: 20px;
  margin-bottom: 5px;
}

.teacher .teacher-info .info2 {
  display: flex;
  flex-direction: row;
}

.teacher .teacher-info .info2 .teacher-title {
  font-size: 16px;
  color: #1A4D7F;
  line-height:35px;
  font-weight: 400;
  margin-left: 20px;

  /* margin-top: 8px; */
}

.teacher .teacher-info .info2 .teacher-tele {
  font-size: 16px;
  color: #1A4D7F;
  line-height:35px;
  font-weight: 400;
  margin-left: 118.5px;
}

.teacher .teacher-info .info3 {
  display: flex;
  flex-direction: row;
}

.teacher .teacher-info .info3 .teacher-sid {
  font-size: 16px;
  color: #1A4D7F;
  line-height:35px;
  font-weight: 400;
  margin-left: 20px;
}


.teacher .teacher-info .info3 .teacher-email {
  font-size: 16px;
  color: #1A4D7F;
  line-height:35px;
  font-weight: 400;
  margin-left: 75px;
}


</style>
