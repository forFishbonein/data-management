<template>
  <div class="main">
    <form action="" @submit.prevent class="login-form">
      <div class="login-way-box">
        <div class="codeLogin">
          <router-link to="/codeLogin">验证码登录</router-link>
        </div>
        <div class="passLogin">
          <router-link to="/passLogin">密码登录</router-link>
        </div>
      </div>
      <div class="login-input-box">
        <input v-model="login.email" class="login-input-box-email"
               placeholder="请输入邮箱" type="text">
        <input v-model="login.code" class="login-input-box-code"
               placeholder="请输入验证码" type="text">
        <input class="login-input-box-send" value="获取验证码" type="button"
               @click="sendEmail({ email: login.email })"/>
      </div>
      <div class="login-check">
        <span><input type="checkbox">&nbsp;记住我</span>
        <router-link to="/register">注册账号</router-link>
        <router-link to="/register">忘记密码？</router-link>
      </div>
      <button class="login-button" @click="codeLogin(login)">登 录</button>

    </form>

  </div>
</template>

<script>
// import {codeLogin} from "../api/login";


import {postCodeTeacher} from "../api/register";

export default {
  name: 'CodeLogin',


  data() {
    return {
      a: '',
      count: 30,
      curCount: 0,
      InterValObj: '',
      login: {
        email: "",
        code: "",
      },
    }
  },

  methods: {
    turn() {
      this.$router.replace(
        name = 'profile'
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
    setRemainTime() {
      if (this.curCount == 0) {
        console.log('停止')
        window.clearInterval(this.InterValObj);
        this.a[0].disabled = false;
        this.a[0].style.backgroundColor = "#114879";


        this.a[0].setAttribute('value', '重新发送验证码');
      } else {
        this.curCount--;
        this.a[0].setAttribute('value', this.curCount + "秒后可重新发送");
      }
    },
    sendEmail(data) {

      this.a = document.getElementsByClassName('login-input-box-send');
      this.a[0].disabled = true;
      this.a[0].style.backgroundColor = "#113355";

      postCodeTeacher(data).then(
        response => {
          if (response.code == 0) {
            const h = this.$createElement;
            this.$notify({
              title: '验证码已发送！',
              message: h('i', { style: 'color: teal'},)
            });
          }

        }
      ).catch(error => {
        console.log(error)
      })

      this.curCount = this.count
      this.InterValObj = window.setInterval(this.setRemainTime, 1000);

    },
    codeLogin(login) {

      this.$store.dispatch('codeLogin', login).then(res => {
        console.log(res.code != 0)
        if (res.code != 0) {
          const h = this.$createElement;
          this.$notify({
            title: '错误！',
            message: h('i', { style: 'color: red'}, res.msg)
          });
        } else {
          const h = this.$createElement;
          this.$notify({
            title: '登录成功！',
            message: h('i', { style: 'color: teal'},)
          });
          this.$router.push({path: '/profile'})
        }
      }).catch((error) => {
        if (error !== 'error') {
          const h = this.$createElement;
          this.$notify({
            title: '错误！',
            message: h('i', { style: 'color: red'}, error)
          });
        }
      })
    },

  },
  beforeRouteEnter (to, from, next) {
      next(
        vm => {
          vm.$store.dispatch('fedLogOut');
        }
      );
  },
}
</script>

<style scoped>
* {
  margin: 0;
  padding: 0;

}

.hide {
  disabled: true;
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
  width: 400px;
  height: 480px;
  background-color: #fdfdfd;
  background-image: url("../../static/img/temple.svg");
  border-radius: 10px;
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
  margin-top: 30px;
  margin-left:27px;
  height: 40px;
  border-radius: 6px;
  border: #97a5c3 solid 1px;

}

.login-input-box input:focus,
.login-input-box input:hover {
  border: #113355 solid 1.5px;
}

.login-input-box-email {
  width: 343px;
  padding-left: 10px;
}

.login-input-box-code {
  width: 180px;
  padding-left: 10px;
}

.login-input-box-send{
  width: 130px;
  color:#FFFFFF;
  padding-left: 3px;
  background-color: #3d3d3d;
}
.login-input-box-send:hover,
.login-button:hover {
  cursor: pointer;
  background-color: #061931;
}

.login-check {
}

.login-check span,
.login-check a {
  float: left;
  color: #113355;
  font-size: 12px;
  margin-top: 30px;
}

.login-check span {
  margin-left: 30px;

}

.login-check a:nth-child(2) {
  margin-left: 165px;

}

.login-check a:nth-child(3) {
  margin-left: 20px;
}

.login-button {
  margin-top: 60px;
  margin-left: 37px;
  width: 320px;
  height: 45px;
  border-radius: 8px;
  background-color: #3d3d3d;
  color: white;
  font-size: 18px;
  letter-spacing: 1px;
  word-spacing: 20px;
  font-weight: 700;
}


</style>






