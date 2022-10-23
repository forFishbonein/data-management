<template><div class="background">
    <TeacherNav/>
    <div class="main">
      <div class="title">资料上传</div>
      <div class="content">
        <form>
            <div><span>选择模板&emsp;</span>
                <select>
                <option value="a1">科研项目</option>
                <option value="a2">教研报告</option>
                <option value="a3">各类荣誉</option>
                <option value="a4">成果类</option>
                <option value="a5">学生竞赛</option>
                <option value="a6">交流访问</option>
                <option value="a6">党支部</option>
                <option value="a6">教研室</option>
                <option value="a6">论文/期刊</option>
                <option value="a6">其他</option>
                </select>
            </div>

            <div class="resources">
                <span>
资源名称&emsp;
                </span>
                <input type="text" placeholder="请输入文字">
            </div>
            <div class="resources">
                <span>
项目简介&emsp;
                </span>
                <textarea type="text" style="width:450px ;height:125px;" placeholder="请输入文字"/>
            </div>
            <div class="resources">
                <span>
项目来源&emsp;
                </span>
                <input type="text" placeholder="请输入文字">
            </div>
            <div class="resources">
                <span>
项目类型&emsp;
                </span>
                <input type="text" placeholder="请输入文字">
            </div>
            <div class="resources">
                <span>
项目级别&emsp;
                </span>
                <input type="text" placeholder="请输入文字">
            </div>
            <div class="resources">
                <span>
立项时间&emsp;
                </span>
                <input type="date" placeholder="请输入时间">
            </div>
            <div class="resources">
                <span>
结项时间&emsp;
                </span>
                <input type="date" placeholder="请输入时间">
            </div>
            <div class="resources">
                <span>
经&emsp;&emsp;费&emsp;
                </span>
                <input type="number" placeholder="请输入数字">
            </div>
            <div class="resources">
                 <span>
课题组成员
                </span>
                <input type="text" placeholder="请输入文字">
            </div>
            <button type="submit">立即上传</button>
        </form>
      </div>
    </div></div>
  </template>

  <script>
  import TeacherNav from '../components/TeacherNav.vue'
import TeacherNav from '../components/TeacherNav.vue';
  export default {
    name: 'TeacherUpload',

    data() {
        return {};
    },
    comments: {
        TeacherNav
    },
    components: { TeacherNav }
}
  </script>

  <!-- Add "scoped" attribute to limit CSS to this component only -->
  <style scoped>
  * {
    margin: 0;
    padding: 0;
  }
  .background{
    background-color: #EAF2FB;
    padding: 20px 30px;
  }
  .main{
    border-radius: 10px;
    width: 1200px;
    color: #3C85D7;
    margin:auto;
    padding: 30px 50px;
    background-color: #FDFDFD;
  }
  .title{
    font-size: 30px;
    font-weight: bold;
  }
  .content{
    font-size: 20px;
  }
  .content div{
    margin: 10px 5px;
  }
  button[type="submit"] {
    background-color: #2F51FF;
    color:white;
    width: 100px   ;
    height: 30px;
    font-size: 16px;
  }


  </style>
