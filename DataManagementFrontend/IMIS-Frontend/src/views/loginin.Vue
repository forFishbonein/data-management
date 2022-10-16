<<<<<<< HEAD
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
                    <div>
                        验证码登录
                    </div>
                    <div>
                        密码登录
                    </div>
                </div>
                <div class="email">
邮&emsp;箱<input type="email" placeholder="请输入邮箱">
                </div>
                <div class="yanzhengma">
验证码<input placeholder="请输入验证码"/><button>发送验证码</button>
                </div>
                <div class="others">
                  <input type="checkbox" name="remember">
                  <div>记住我</div>
                  <div>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<a>忘记密码</a></div>
                </div>
                <div>

                </div>
                <button type="submit">登录</button>
            </form>
        </div>
<div class="footer">
邮箱：{{email}}&emsp;大数据实验班版权所有
</div>
   </div>
</template>
  
<script>
  export default {
    data () {
      return {
        email:"256235478@qq.com"
      }
    }
  }
</script>
  
  <!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  *{
    margin: 0;
  }
.main{
    width: 1200px;
    height: 100vh;
    flex-direction: column;
    align-items: center;
    margin:auto
}
.header{
    background-color: antiquewhite;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100px;
}
.body{
background-color: azure;
height: 300px;
display: flex;
}
.footer{
    background-color: wheat;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100px;
}
.left{
    background-color: beige;
    height: 100%;
    width: 50%;
}
.right{
    background-color: bisque;
    height: 100%;
    width: 50%;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
}
.choice{
  display: flex;
  /* width: 250px; */
  justify-content: space-around;
}
input{
  /* width: 230px; */
  height: 30px;
  opacity: 1;
  /* border-radius: 15px; */
  background: rgba(255, 255, 255, 1);
  margin:10px 15px
  }

  .others{
    /* width: 250px; */
    height: 25px;
    display: flex;
  }
  /* p{
    width: 150px;
    display: flex;
  } */
  input[type="checkbox"]{
    width: 15px;
    height: 15px;
    margin: 5px 5px;
  }
  input[type="email"]{
  width: 260px;
  }

  form>div{
    width: 355px;
  }
  button{
  height: 30px;
  }
  button[type="submit"]{
    width: 150px;
    height: 30px;
    border-radius: 5px;
  }
</style>
=======
<template>
  <div class="main">
    <div class="header">
      统一身份认证
    </div>
    <div class="body">
      <div class="left">

      </div>
      <form class="right">
        <div>
          <div>
            验证码登录
          </div>
          <div>
            密码登录
          </div>

        </div>
        <div>

        </div>
        <div>

        </div>
        <div>

        </div>
        <div>

        </div>
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
  height: 300px;
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
  background-color: bisque;
  height: 100%;
  width: 50%;
  display: flex;
  justify-content: center;
  align-items: center;
}
</style>
>>>>>>> b65e3c842476f72e0c5d3c21bc913d7a4e9e2e0c
