<template>
  <div class="teacher-header">
    <div class="bgpicture">

    </div>
    <div class="teacher">
      <div class="teacher-pic">
        <img alt="头像"
             src="https://ts2.cn.mm.bing.net/th?id=OIP-C.19LPGfyiWw_LZodJOolXSAHaHa&w=250&h=250&c=8&rs=1&qlt=90&o=6&dpr=1.25&pid=3.1&rm=2"
        >
      </div>
      <div class="teacher-info">
        <div class="info1">
          <div class="teacher-name">{{ teacher.teacherName }}</div>
        </div>
        <table>
          <tr>
            <td height="30px" width="250px">教师职称：{{ teacher.teacherTitle }}</td>
            <td>电话：{{ teacher.teacherTele }}</td>
          </tr>
          <tr>
            <td>工号：{{ teacher.teacherSid }}</td>
            <td>邮箱：{{ teacher.teacherEmail }}</td>
          </tr>
        </table>
      </div>
    </div>
  </div>
</template>


<script>
// import {getByTeacherId} from '@/api'
// import store from "@/store";

export default {
  name: "TeacherHeader",
  data() {
    return {
      id: "",
      teacher: {
        teacherName: "",
        teacherEmail: "",
        teacherSid:"",
        teacherId:"",
        teacherTitle: "",
        teacherTele:""
      }
    }
  },
  methods: {
    getInfo() {
      this.teacher.teacherName = this.$store.state.teacherName
      this.teacher.teacherEmail = this.$store.state.teacherEmail
      this.teacher.teacherSid = this.$store.state.teacherSid
      this.teacher.teacherId = this.$store.state.teacherId
      this.teacher.teacherTitle = this.$store.state.teacherTitle
      this.teacher.teacherTele = this.$store.state.teacherTele
    }
  },
  created() {
    this.getInfo()
  }
}
</script>

<style scoped>

.teacher-header {
  display: flex;
  flex-direction: column;
  height: 250px;
  margin-top: 10px;
  border-bottom-left-radius: 12px;
  border-bottom-right-radius: 12px;
}

.bgpicture {
  width: 1200px;
  height: 120px;
  border-top-left-radius: 12px;
  border-top-right-radius: 12px;
  background: url("../../static/img/teacher1.jpg") no-repeat
}

.teacher {
  display: flex;
  flex-direction: row;
  height: 170px;
  margin-bottom: 8px;
  background-color: #FFFFFF;
  border-bottom-left-radius: 12px;
  border-bottom-right-radius: 12px;
}

.teacher .teacher-pic {
  width: 110px;
  height: 110px;
  border-radius: 100%;
  position: absolute;
  margin: -40px 0 0 30px;
}

.teacher-pic > img {
  width: 110px;
  height: 110px;
  border-radius: 100%;
}

.teacher .teacher-info {
  margin-top: 0;
  margin-left: 150px;
}

.teacher .teacher-info .info1 .teacher-name {
  color: #1A4D7F;
  font-size: 26px;
  line-height: 40px;
  font-weight: 550;
  margin-left: 20px;
  margin-bottom: 5px;
}

.teacher .teacher-info table {
  margin-left: 20px;
}


</style>
