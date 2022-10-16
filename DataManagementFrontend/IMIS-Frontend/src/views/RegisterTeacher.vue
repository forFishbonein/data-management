<template>
  <div class="main">
    <div class="header">
      统一身份认证
    </div>
    <div class="body">
      <form class="right">
        <div class="rightheader">教师注册</div>
        <div class="box"><input class="containerfirst" type="text" placeholder="请输入邮箱" v-model="teacher.mail">
          <button class="buttonin">获取验证码</button>
        </div>
        <div class="box"><input class="container" type="text" placeholder="请输入验证码" v-model="teacher.captcha"></div>
        <div class="box"><input class="container" type="text" placeholder="请输入姓名" v-model="teacher.username"></div>
        <div class="box"><input class="container" type="text" placeholder="请输入教工号" v-model="teacher.id"></div>
        <div class="box"><input class="container" type="text" placeholder="请输入密码" v-model="teacher.password"></div>
        <div class="box"><input class="container" type="text" placeholder="请再次输入密码" v-model="teacher.repassword"></div>
        <div class="box">
          <button class="button" @click="regHandle($event,teacher)">注册</button>
        </div>
      </form>
    </div>
    <div class="footer">
      邮箱：256235478@qq.com&emsp;大数据实验班版权所有
    </div>
  </div>
</template>

<script>
import {postRegisterTeacher} from "../api/register";

export default {
  data() {
    return {
      teacher: {
        mail: "",
        captcha: "",
        username: "",
        id: "",
        password: "",
        repassword: ""
      }
    }
  },
  methods: {
    regHandle(teacher) {
      if (
        this.teacher.mail === '' ||
        this.teacher.captcha === '' ||
        this.teacher.username === '' ||
        this.teacher.id === '' ||
        this.teacher.password === '' ||
        this.teacher.repassword === ''
      ) {
        alert('请您将信息填写完整')
      } else if (this.teacher.password !== this.teacher.repassword) {
        alert('两次输入的密码不一致')
      } else {
        postRegisterTeacher(teacher).then(
          response => (

            alert('恭喜您注册成功')
          )
        )

      }
    },
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
* {
  margin: 0;
}

.main {
  width: 1200px;
  height: 100vh;
  flex-direction: column;
  align-items: center;
  margin: auto;
}

.header {
  background-color: cornflowerblue;
  color: white;
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100px;
}

.body {
  background-color: azure;
  height: 500px;
  display: flex;
  padding-top: 50px;
  padding-bottom: 50px;
}

.footer {
  background-color: cornflowerblue;
  color: white;
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100px;
}

.rightheader {
  background-color: white;
  font-size: 25px;
  height: 40px;
  width: 500px;
  display: flex;
  justify-content: center;
  flex-direction: column;
  align-items: center;
}

.right {
  background-color: white;
  height: 100%;
  width: 500px;
  margin-left: 650px;
  display: flex;
  justify-content: center;
  flex-direction: column;
  align-items: center;
}

.box {
  font-size: 16px;
  margin-top: 5px;
}

.containerfirst {
  width: 200px;
  height: 30px;
  padding: 0 2vh;
  margin-top: 15px;
  border: 1.5px solid #7A91BC;
  opacity: 1;
  border-radius: 8px;
  background: rgba(255, 255, 255, 1);
}

.buttonin {
  width: 95px;
  height: 30px;
  margin-left: 5px;
  margin-top: 15px;
}

.container {
  width: 300px;
  height: 30px;
  padding: 0 2vh;
  margin-top: 15px;
  border: 1.5px solid #7A91BC;
  opacity: 1;
  border-radius: 8px;
  background: rgba(255, 255, 255, 1);
}

.button {
  width: 300px;
  height: 40px;
  color: white;
  padding: 0 1vh;
  margin-top: 15px;
  border: 1.5px solid #7A91BC;
  opacity: 1;
  border-radius: 8px;
  background-color: cornflowerblue;
}

.button:hover {
  background-color: rgb(79, 134, 236);
}
</style>
