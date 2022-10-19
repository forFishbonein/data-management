<template>
  <div class="main">
    <div class="header">
      统一身份认证
    </div>
    <div class="body">
      <div class="left">

      </div>
      <form class="right">
        <div class="choice">
          <div @click="turnloginina">
            验证码登录
          </div>
          <div class="abc">
            密码登录
          </div>
        </div>
        <div class="email">
          <!-- 邮&emsp;箱 -->
          <input type="email" placeholder="请输入账号">
        </div>
        <div class="yanzhengma">
          <!-- 验证码 -->
          <input placeholder="请输入密码" type="password">
        </div>
        <div class="others">&emsp;
          <input type="checkbox" name="remember">
          <div>记住我</div>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
          <div>忘记密码</div>
        </div>
        <div>

        </div>
        <button type="submit">登录</button>
      </form>
    </div>
    <div class="footer">
      邮箱：{{ email }}&emsp;大数据实验班版权所有
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      email: "256235478@qq.com"
    }
  },methods: {
        turnlogininb(){
          this.$router.replace(
            name='logininb'
          )
        },
        turnloginina(){
          this.$router.replace(
            name='loginina'
          )
        }
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
  margin: auto
}

.header {
  background-color: antiquewhite;
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100px;
}

.body {
  background-color: azure;
  height: 500px;
  display: flex;
}

.footer {
  background-color: wheat;
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100px;
}

.left {
  background-color: beige;
  height: 100%;
  width: 50%;
}

.right {
  background-color: rgb(255, 255, 255);
  height: 100%;
  width: 50%;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

.choice {
  display: flex;
  justify-content: space-around;
  color: #0776f4;
  margin-bottom: 50px;
}

input {
  height: 30px;
  opacity: 1;
  background: rgba(255, 255, 255, 1);
  margin: 10px 15px;
  border-radius: 10px;
  background: rgba(255, 255, 255, 1);
  padding-left: 10px;
  border: 1.5px solid rgba(122, 145, 188, 1);
}

.others {
  width: 355px;
  display: flex;
  margin: 10px 15px;
}

input[type="checkbox"] {
  width: 15px;
  height: 15px;
  margin: 5px 5px;
}

input {
  width: 260px;
}

form > div {
  width: 355px;
}

button {
  height: 30px;
}

button[type="submit"] {
  width: 150px;
  height: 30px;
  border-radius: 5px;
  border: 0;
  background-color: #3C85D7;
  color: white;

}

.abc {
  border-bottom: #0776f4 solid 2px;
}
</style>
