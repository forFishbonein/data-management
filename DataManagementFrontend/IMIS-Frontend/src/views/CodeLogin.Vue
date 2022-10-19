<template>
  <div class="main">
    <form class="login-form" action="">
      <div class="login-way-box">
        <div class="login-way">验证码登录</div>
        <div class="login-way">密码登录</div>
      </div>
      <div class="login-input-box">
        <input type="text" class="login-input-box-email" placeholder="请输入邮箱">
        <input type="text" class="login-input-box-code" placeholder="请输入验证码">
        <span class="login-input-box-send">获取验证码</span>
      </div>
      <div class="login-check">
        <span><input type="checkbox">记住我</span>
        <span>注册账号</span>
        <span>忘记密码？</span>
      </div>
      <button class="login-button">登录</button>

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
  background-color: #d38cef;
}

.login-form {
  margin: 0 auto;
  width: 360px;
  height: 480px;
  background-color: rgba(255, 255, 255, 0.1);
}

.login-way-box {
  display: flex;
  justify-content: space-around;
}

.login-way {
  display: inline-block;
  padding: 24px 40px;
  color: #3C85D7;
}

.login-input-box input {
  margin: 10px 20px;
  height: 30px;
  border-radius: 6px;
  padding-left: 10px;
}

.login-input-box-email {
  width: 320px;
}

.login-input-box-code {
  width: 200px;
}

.login-input-box-send {
  vertical-align: baseline;

}

.login-check {
}

.login-check span {
  float: left;
  color: #6b6a6a;
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
  width: 320px;
  height: 30px;
  margin-top: 60px;
  margin-left: 20px;
  border-radius: 8px;
}


</style>






