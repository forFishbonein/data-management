<template>
<div id="content1" >
  <div id="h">
  <h1 id="title">{{Title}}</h1>
  <div id="desc">{{desc}}</div><span></span>
  <div id="item"><pre>参赛时间:{{time}}&nbsp;<img src="../../static/img/img.png" id="img1">&nbsp;&nbsp;&nbsp;参赛人：{{name}}</pre></div>
</div>
  <img src="https://ts1.cn.mm.bing.net/th/id/R-C.fd6ff4fca56855c555d7761d446d8b91?rik=iw0S4On4zglJGw&riu=http%3a%2f%2fimg2.sycdn.imooc.com%2f5e2130420001fd6f08270861.jpg&ehk=gEjGSjUa9UoafPxT%2bqfctt32dutGeLo848S3gJNlbdk%3d&risl=&pid=ImgRaw&r=0" id="img2">
</div>
</template>

<script>
export default {
  name:"TeacherData",
  data(){

    return{
      Title:'张三',
      desc:'这里是中南民族大学',
      name:'张三，李四',
      time:'2022-10-9'
    }
  },
}
</script>

<style scoped>
      #h{
        float: left;
      }
      #content1{
        width: 1114px;
        height: 137px;
        margin-left: 165px;
        margin-top: 395px;
        background-color: grey;
      }
      #img1{
        width: 20px;
        height: 20px;
        vertical-align: middle;
      }
      #img2{
        width: 130px;
        height: 117px;
        float: right;
        margin-top: 10px;
        margin-right: 5px;
      }

      #title{
        text-align: left;
        margin-left: 31px;
        margin-top: 5px;
      }
      #desc{
        text-align: left;
        margin-left: 31px;
      }
      #item{
        text-align:left;
        margin-left: 31px;
      }
</style>
