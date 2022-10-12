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
                   <div class="abc">
                       验证码登录
                   </div>
                   <div>
                       密码登录
                   </div>
               </div>
               <div class="email">
<!-- 邮&emsp;箱 -->
<input type="email" placeholder="请输入邮箱">
               </div>
               <div class="yanzhengma">
<!-- 验证码 -->
<input placeholder="请输入验证码"/><button>发送验证码</button>
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
height: 500px;
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
   background-color: rgb(255, 255, 255);
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
 color: #0776f4;
 margin-bottom: 50px;
}
input{
 /* width: 230px; */
 height: 30px;
 opacity: 1;
 /* border-radius: 15px; */
 background: rgba(255, 255, 255, 1);
 margin:10px 15px;
 
border-radius: 10px;
background: rgba(255, 255, 255, 1);
padding-left: 10px;
border: 1.5px solid rgba(122, 145, 188, 1);  
 }

 .others{
   width: 355px;
   /* height: 25px; */
   display: flex;
   margin: 10px 15px;
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
   border: 0;
   background-color:#3C85D7 ;
   color:white;

 }
 .abc{
   border-bottom: #0776f4 solid 2px;
 }
 /* .others>div{
   width: 100px;
 } */
</style> 






