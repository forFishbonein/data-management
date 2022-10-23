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
              <td width="35%">
                <p class="underline"><input type="text" v-model="teacher.teacherEmail" required
                                            oninvalid="setCustomValidity('请填写邮箱')" oninput="setCustomValidity('')">
                </p>
              </td>
              <td width="35%"><p class="prompt">您的电子邮箱地址即为您的用户名</p></td>
            </tr>
            <tr>
              <td width="20%"><span>验证码</span></td>
              <td width="35%"><p class="underline">
                <input type="text" v-model="teacher.code" required oninvalid="setCustomValidity('请填写验证码')"
                       oninput="setCustomValidity('')"></p>
              </td>
              <td width="35%">
                <p class="prompt">
                  <button class="button" @click="sendEmail({ email: teacher.teacherEmail })">获取验证码</button>
                </p>
              </td>
            </tr>
            <tr>
              <td><span>密码</span></td>
              <td width="35%"><p class="underline"><input type="text" v-model="teacher.teacherPass" required
                                                          oninvalid="setCustomValidity('请填写密码')"
                                                          oninput="setCustomValidity('')"></p></td>
              <td><p class="prompt">密码不能少于6位</p></td>
            </tr>
            <tr>
              <td><span>确认密码</span></td>
              <td width="35%"><p class="underline"><input type="text" v-model="teacher.teacherRePass" required
                                                          oninvalid="setCustomValidity('请再次输入密码')"
                                                          oninput="setCustomValidity('')"></p></td>
            </tr>
            <tr>
              <td><span>学号</span></td>
              <td width="35%"><p class="underline"><input type="text" v-model="teacher.teacherSid" required
                                                          oninvalid="setCustomValidity('请填写学号')"
                                                          oninput="setCustomValidity('')"></p></td>
            </tr>
            <tr>
              <td></td>
              <td>
                <input type="submit" value="创建账户" class="bottom" @click="regHandle(teacher)">
              </td>
            </tr>

          </table>
        </form>
      </div>


    </div>


  </div>
</template>

<script>
import {postCodeStudent} from "../api/register";

export default {
  name: 'RegisterStudent',

  data() {
    return {
      // userForm: {
      //   account: '',
      //   nickname: '',
      //   password: ''
      // },
      student: {
        studentEmail: "",
        code: "",
        studentPass: "",
        studentRePass: "",
        studentSid: "",
      },
    }
  },
  methods: {

    sendEmail(data) {
      postCodeStudent(data).then(
        response => {
          console.log(response.data.data);
        }
      )
    },
    regHandle(student) {
      if (this.student.studentPass !== '' && this.student.studentRePass !== '') {
        if (this.student.studentPass !== this.student.studentRePass) {
          alert("两次输入的密码不一致！")
        } else {
          // postRegisterTeacher(data).then(
          //   response => {
          //     alert('恭喜您注册成功')
          //   }
          // )

          this.$store.dispatch('studentRegister', student).then(() => {
            // alert('恭喜您注册成功')
            this.$message({message: '注册成功！', type: 'success', showClose: true});
            this.$router.push({path: '/'})
          }).catch((error) => {
            if (error !== 'error') {
              // alert('注册失败')
              this.$message({message: error, type: 'error', showClose: true});
            }
          })

        }

      }
    }
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
  height: 100vh;
  background: url("../../static/img/register1.jpg") no-repeat;
  background-size: 100%;
}

.container {
  position: absolute;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  margin: auto;
  padding: 50px;
  width: 1070px;
  height: 650px;
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

.button {
  padding: 4px 8px;
  background-color: #3d3d3d;
  font-size: 12px;
  color: white;
  text-align: center;
  letter-spacing: 1px;
  border-radius: 6px;
  font-weight: 800;
}

.bottom:hover {
  background-color: #312d2a;
  cursor: pointer;
}

</style>
