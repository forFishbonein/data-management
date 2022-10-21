<template>
  <div class="main">
    <form class="login-form" action="">
      <div class="login-way-box">
        <div class="login-way">验证码登录</div>
        <div class="login-way">密码登录</div>
      </div>
      <div class="login-input-box">
        <input type="text" placeholder="请输入邮箱">
        <input type="password" placeholder="请输入密码">
      </div>
      <div class="login-check">
        <span><input type="checkbox">记住我</span>
        <span>注册账号</span>
        <span>忘记密码？</span>
      </div>
      <button class="login-button">登 录</button>

    </form>

  </div>
</template>

<script>
export default {
  data() {
    return {}
  },
  methods: {
    turn() {
      this.$router.replace(
        name = 'person'
      )
    }, turnlogininb() {
      this.$router.replace(
        name = 'logininb'
      )
    },
    turnregisterteacher() {
      this.$router.replace(
        name = 'registerteacher')
    }
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

.login-way {
  display: inline-block;
  padding: 24px 40px;
  color: #113355;
}

.login-input-box input {
  margin: 10px 20px;
  width: 320px;
  height: 40px;
  border-radius: 6px;
  padding-left: 10px;
  border: #97a5c3 solid 1px;
}

.login-input-box input:focus,
.login-input-box input:hover {
  border: #113355 solid 1.5px;
}




.login-button:hover{
  cursor: pointer;
  background-color: #1a3f66;
}

.login-check {
}

.login-check span {
  float: left;
  color: #113355;
  font-size: 12px;
  margin-top: 20px;
}

.login-check span:nth-child(1) {
  margin-left: 20px;

}

.login-check span:nth-child(2) {
  margin-left: 140px;

}

.login-check span:nth-child(3) {
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






