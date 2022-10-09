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
   justify-content: center;
   align-items: center;
}
 </style>
 