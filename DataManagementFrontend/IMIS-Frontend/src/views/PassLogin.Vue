<template>
  <div class="main">
    <form action="" @submit.prevent class="login-form">
      <div class="login-way-box">
        <div class="codeLogin">
          <router-link to="/login">验证码登录</router-link>
        </div>
        <div class="passLogin">
          <router-link to="/passLogin">密码登录</router-link>
        </div>
      </div>
      <div class="login-input-box">
        <input v-model="login.email" placeholder="请输入邮箱" type="text">
        <input v-model="login.password" placeholder="请输入密码" type="password">
      </div>
      <div class="login-check">
        <span><input type="checkbox">&nbsp;记住我</span>
        <router-link to="/register">注册账号</router-link>
        <router-link to="/register">忘记密码？</router-link>
      </div>
      <button class="login-button" @click="passLogin(login)">登 录</button>
    </form>
  </div>
</template>

<script>


export default {
  name: 'PassLogin',


  data() {
    return {
      login: {
        email: "",
        password: "",
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
    passLogin(login) {

      this.$store.dispatch('passLogin', login).then(res => {
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
    toRegister() {
      this.$router.replace(
        name = 'registerteacher')
    }
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

.main {
  position: relative;
  height: 100vh;
  background: url(../../static/img/login.jpg) no-repeat center;
  background-size: 100%;
}

.login-form {
  position: absolute;
  top: 120px;
  left: 50%;
  margin: 0 auto;
  margin-left: -203px;
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

.codeLogin a:before {
  transform: scaleX(0);
  transition: .3s;
}

.codeLogin a:hover:before {
  background-color: #113355;
  transform: scaleX(1);
}

.login-input-box input {
  margin-top: 30px;
  margin-left:27px;
  width: 340px;
  height: 40px;
  border-radius: 6px;
  padding-left: 10px;
  border: #97a5c3 solid 1px;
}

.login-input-box input:focus,
.login-input-box input:hover {
  border: #113355 solid 1.5px;
}


.login-button:hover {
  cursor: pointer;
  background-color: #1a3f66;
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






