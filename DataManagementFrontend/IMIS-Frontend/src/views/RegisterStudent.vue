<template>
  <div class="main">
    <div class="container">
      <div class="context">
        <h1>创建账户</h1>
        <div class="login"><span>已有账户？</span>
          <a href="#"><span>登录</span></a>
        </div>
        <form action="">
          <table>
            <tr>
              <td width="20%"><span>邮箱地址</span></td>
              <td width="35%"><p class="underline"><input type="text"></p></td>
              <td width="35%"><p class="prompt">您的电子邮箱地址即为您的用户名</p></td>
            </tr>
            <tr>
              <td><span>密码</span></td>
              <td width="35%"><p class="underline"><input type="text"></p></td>
              <td><p class="prompt">密码不能少于6位</p></td>
            </tr>
            <tr>
              <td><span>确认密码</span></td>
              <td width="35%"><p class="underline"><input type="text"></p></td>
            </tr>
            <tr>
              <td><span>姓名</span></td>
              <td width="35%"><p class="underline"><input type="text"></p></td>
            </tr>
            <tr>
              <td><span>学号</span></td>
              <td width="35%"><p class="underline"><input type="text"></p></td>
            </tr>
            <tr>
              <td></td>
              <td><p class="warm"></p></td>
            </tr>
            <tr>
              <td></td>
              <td>
                <div class="bottom">创建账户</div>
              </td>
            </tr>

          </table>
        </form>
      </div>


    </div>


  </div>

</template>

<script>
import {postRegisterStudent} from "../api/register";

export default {
  data() {
    return {
      student: {
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
    regHandle(student) {
      if (
        this.student.mail === '' ||
        this.student.captcha === '' ||
        this.student.username === '' ||
        this.student.id === '' ||
        this.student.password === '' ||
        this.student.repassword === ''
      ) {
        alert('请您将信息填写完整')
      } else if (this.student.password !== this.student.repassword) {
        alert('两次输入的密码不一致')
      } else {
        postRegisterStudent(student).then(
          response => {
            alert('恭喜您注册成功')
          }
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
  padding: 0;
  box-sizing: border-box;
}

.main {
}

.container {
  margin: 60px auto;
  padding: 50px;
  width: 1070px;
  height: 600px;
  background-color: #fcfbfa;
  border-radius: 10px;
}
.context h1 {
  color: #0a3261;
  text-align: center;
}

.context .login {
  color: #0a3261;
  text-align: center;
  padding: 8px 8px 24px 8px;
}
.context .login a {
  color: #947519;
}


.context table {
  width: 100%;
}

.context table td {
  height: 40px;
}

.context table td span {
  display: block;
  text-align: right;
  color: #113355;
}

.context table td .prompt {
  margin: 16px;
  display: block;
  font-size: 12px;
  color: #525050;
}

.context table td span::after {
  content: "*";
  color: #BB501C;
  display: inline-block;
  font-size: 20px;
  margin-left: 2px;
}

.context table td .underline {
  margin: 0 8px;
  width: 100%;
  border-bottom: 2px solid #eee;
}

.context table td .underline input[type=text] {
  background-color: #fcfbfa;
  width: 100%;
  padding: 8px;
}

.context table td .underline input:hover,
.context table td .underline input:focus {
  width: 100%;
  border: 2px dashed #947519;
  background-color: white;
}

.warm {
  font-size: 10px;
  color: #6b6a6a;
}

.warm-box i {
  font-style: normal;
  font-size: 10px;
  color: #6b6a6a;
}

.bottom {
  padding: 8px 16px;
  background-color: #3d3d3d;
  font-size: 16px;
  color: white;
  text-align: center;
  letter-spacing: 1px;
  border-radius: 8px;
  font-weight: 800;
}

.bottom:hover {
  background-color: #312d2a;
  cursor: pointer;
}

</style>
