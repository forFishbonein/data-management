<template>
  <div class="main">
    <form action="" class="login-form">
      <div class="login-way-box">
        <div class="codeLogin">
          <router-link to="/codeLogin">验证码登录</router-link>
        </div>
        <div class="passLogin">
          <router-link to="/passLogin">密码登录</router-link>
        </div>
      </div>
      <div class="login-input-box">
        <input v-model="login.email" class="login-input-box-email" placeholder="请输入邮箱" type="text">
        <input v-model="login.code" class="login-input-box-code" placeholder="请输入验证码" type="text">
        <span class="login-input-box-send" @click="sendEmail({ email: login.email })">获取验证码</span>
      </div>
      <div class="login-check">
        <span><input type="checkbox">记住我</span>
        <router-link to="/register">注册账号</router-link>
        <router-link to="/register">忘记密码？</router-link>
      </div>
      <button class="login-button" @click="toLogin(login)">登 录</button>

    </form>

  </div>
</template>

<script>
// import {codeLogin} from "../api/login";


export default {
  name: 'CodeLogin',


  data() {
    return {
      login: {
        email: "",
        code: "",
      },
    }
  },

  methods: {
    turn() {
      this.$router.replace(
        name = 'person'
      )
    },
    codeLogin() {
      this.$router.replace(
        name = 'codelogin'
      )
    },
    passLogin() {
      this.$router.replace(
        name = 'passlogin'
      )
    },
    toRegister() {
      this.$router.replace(
        name = 'registerteacher')
    },
    sendEmail(data) {
      postCodeTeacher(data).then(
        response => {
          response.data.data;
        }
      )
    },
    toLogin(data) {
      codeLogin(data).then(
        response => {

        }
      )
    },
  }
}
</script>

<style scoped>
* {
  margin: 0;
  padding: 0;

}

.main {
  position: relative;
  height: 100vh;
  background: url(../../static/img/register2.jpg) no-repeat center;
  background-size: 100%;
}

.login-form {
  position: absolute;
  top: 120px;
  left: 50%;
  margin: 0 auto;
  margin-left: -180px;
  width: 360px;
  height: 480px;
  background-color: rgba(255, 255, 255, 0.3);
  box-shadow: rgba(100, 100, 111, 0.2) 0px 7px 29px 0px;
}

.login-way-box {
  display: flex;
  justify-content: space-around;
}

.codeLogin {
  display: inline-block;
  padding: 24px 40px;
  color: #113355;
  font-weight: bolder;
}

.passLogin {
  display: inline-block;
  padding: 24px 40px;
  color: #113355;
  font-weight: bolder;
}

.codeLogin a,
.passLogin a {
  position: relative;
}

.codeLogin a:before,
.passLogin a:before {
  content: '';
  height: 3px;
  background-color: #1a3f66;
  width: 100%;
  position: absolute;
  left: 0;
  bottom: -8px;
}

.passLogin a:before {
  transform: scaleX(0);
  transition: .3s;
}

.passLogin a:hover:before {
  background-color: #2464a7;
  transform: scaleX(1);
}

.login-input-box input {
  margin: 10px 20px;
  height: 40px;
  border-radius: 6px;
  padding-left: 10px;
  border: #97a5c3 solid 1px;
}

.login-input-box input:focus,
.login-input-box input:hover {
  border: #113355 solid 1.5px;
}

.login-input-box-email {
  width: 320px;
}

.login-input-box-code {
  width: 200px;
}

.login-input-box-send {
  display: inline-block;
  vertical-align: middle;
  width: 90px;
  height: 30px;
  font-size: 12px;
  text-align: center;
  color: white;
  line-height: 30px;
  background-color: #113355;
  border-radius: 6px;
}

.login-input-box-send:hover,
.login-button:hover {
  cursor: pointer;
  background-color: #1a3f66;
}

.login-check {
}

.login-check span,
.login-check a{
  float: left;
  color: #113355;
  font-size: 12px;
  margin-top: 20px;
}

.login-check span {
  margin-left: 20px;

}

.login-check a:nth-child(2) {
  margin-left: 140px;

}

.login-check a:nth-child(3) {
  margin-left: 20px;
}

.login-button {
  margin-top: 60px;
  margin-left: 20px;
  width: 320px;
  height: 50px;
  border-radius: 8px;
  background-color: #113355;
  color: white;
  font-size: 18px;
  letter-spacing: 1px;
  word-spacing: 20px;
  font-weight: 700;
}


</style>






