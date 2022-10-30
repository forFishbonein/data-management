<template>
  <div class="main">
    <div class="container">
      <div class="context">
        <h1>创建账户</h1>
        <div class="login"><span>已有账户？</span>
          <router-link to="/login"><span>登录</span></router-link>
        </div>
        <form action="">
          <table>
            <tr>
              <td width="20%"><span>邮箱地址</span></td>
              <td width="35%">
                <p class="underline"><input v-model="teacher.teacherEmail" oninput="setCustomValidity('')"
                                            oninvalid="setCustomValidity('请填写邮箱')"
                                            required type="text">
                </p>
              </td>
              <td width="35%"><p class="prompt">您的电子邮箱地址即为您的用户名</p></td>
            </tr>
            <tr>
              <td width="20%"><span>验证码</span></td>
              <td width="35%"><p class="underline">
                <input v-model="teacher.code" oninput="setCustomValidity('')" oninvalid="setCustomValidity('请填写验证码')"
                       required
                       type="text"></p>
              </td>
              <td width="35%">
                <p class="prompt">
                  <input class="button" value="获取验证码" type="button" @click="sendEmail({ email: teacher.teacherEmail })">
                </p>
              </td>
            </tr>
            <tr>
              <td><span>密码</span></td>
              <td width="35%">
                <p class="underline">
                  <input v-model="teacher.teacherPass" oninput="setCustomValidity('')"
                         oninvalid="setCustomValidity('请填写密码')"
                         required
                         type="text">
                </p>
              </td>
              <td><p class="prompt">密码不能少于6位</p></td>
            </tr>
            <tr>
              <td><span>确认密码</span></td>
              <td width="35%"><p class="underline"><input v-model="teacher.teacherRePass"
                                                          oninput="setCustomValidity('')"
                                                          oninvalid="setCustomValidity('请再次输入密码')"
                                                          required
                                                          type="text"></p></td>
            </tr>
            <tr>
              <td><span>姓名</span></td>
              <td width="35%"><p class="underline"><input v-model="teacher.teacherName" oninput="setCustomValidity('')"
                                                          oninvalid="setCustomValidity('请填写姓名')"
                                                          required
                                                          type="text"></p></td>
            </tr>
            <tr>
              <td><span>职位</span></td>
              <td width="35%"><p class="underline"><input v-model="teacher.teacherTittle"
                                                          oninput="setCustomValidity('')"
                                                          oninvalid="setCustomValidity('请填写职位')"
                                                          required
                                                          type="text"></p></td>
            </tr>
            <tr>
              <td><span>教工号</span></td>
              <td width="35%"><p class="underline"><input v-model="teacher.teacherSid" oninput="setCustomValidity('')"
                                                          oninvalid="setCustomValidity('请填写教工号')"
                                                          required
                                                          type="text"></p></td>
            </tr>
            <tr>
              <td><span>电话</span></td>
              <td width="35%"><p class="underline"><input v-model="teacher.teacherTele" oninput="setCustomValidity('')"
                                                          oninvalid="setCustomValidity('请填写电话')"
                                                          required
                                                          type="text"></p></td>
            </tr>
            <tr>
              <td></td>
              <td>
                <p class="warm">温馨提示：普通教师用户登录仅可查看属于本人的资料，经授权后方可查看所有资料
                所有个人信息仅供本系统使用
                </p>
              </td>
            </tr>
            <tr class="know">
              <td></td>
              <td>
                <div class="warm-box"><input class="warm-check" required type="checkbox"><i>我已知晓</i></div>
              </td>
            </tr>
            <tr>
              <td></td>
              <td>
                <input class="bottom" type="submit" value="创建账户" @click="regHandle(teacher)">
              </td>
            </tr>

          </table>
        </form>
      </div>


    </div>


  </div>
</template>

<script>
import {postCodeTeacher} from "../api/register";

export default {
  name: 'RegisterTeacher',

  data() {
    return {
      a: '',
      count: 30,
      curCount: 0,
      InterValObj: '',
      teacher: {
        teacherEmail: "",
        code: "",
        teacherPass: "",
        teacherRePass: "",
        teacherSid: "",
        teacherName: "",
        teacherTittle: "",
        teacherTele: "",
      },
    }
  },
  methods: {
    setRemainTime() {
      console.log('1')
      if (this.curCount == 0) {
        console.log('停止')
        window.clearInterval(this.InterValObj);
        this.a[0].disabled = false;
        this.a[0].style.backgroundColor = "#3d3d3d";


        this.a[0].setAttribute('value', '重新发送验证码');
      } else {
        this.curCount--;
        console.log(this.curCount);
        this.a[0].setAttribute('value', this.curCount + "秒后可重新发送");
      }
    },
    sendEmail(data) {
      this.a=document.getElementsByClassName('button');
      this.a[0].disabled =true;
      this.a[0].style.backgroundColor = "#585858";

      postCodeTeacher(data).then(
        response => {
          console.log(response.data.data);
        }
      )

      this.curCount = this.count
      this.a[0].setAttribute('value',this.curCount + "秒后可重新发送");
      this.InterValObj = window.setInterval(this.setRemainTime,1000);
    },
    regHandle(teacher) {
      if (this.teacher.teacherPass !== '' && this.teacher.teacherRePass !== '') {
        if (this.teacher.teacherPass !== this.teacher.teacherRePass) {
          this.$message({message: '两次输入的密码不一致！', type: 'error', showClose: true});
        } else {
          this.$store.dispatch('teacherRegister', teacher).then(() => {
            this.$message({message: '注册成功！', type: 'success', showClose: true});
            this.$router.push({path: '/'})
          }).catch((error) => {
            if (error !== 'error') {
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

.know {
  transform: translateY(-5px);
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
  padding: 30px 50px;
  width: 1070px;
  height: 650px;
  background-color: #fdfdfd;
  background-image: url("../../static/img/temple.svg");
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

.context table td .underline input {
  background-color: #fdfdfd;
  background-image: url("../../static/img/temple.svg");
  width: 100%;
  padding: 8px;
}

.context table td .underline input:hover,
.context table td .underline input:focus {
  width: 100%;
  border: 2px dashed #947519;
  background-color: white;
  background-image: none;
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
  padding: 6px 16px;
  background-color: #3d3d3d;
  font-size: 12px;
  color: white;
  text-align: center;
  letter-spacing: 1px;
  border-radius: 6px;
  font-weight: 800;
}

.bottom:hover,
.button:hover {
  background-color: #312d2a;
  cursor: pointer;
}

</style>
