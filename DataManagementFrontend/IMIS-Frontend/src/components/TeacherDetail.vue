<template>
<div class="container">
  <div class="context">
    <div class="id"><a href="">{{ id }}</a> </div>
    <div class="name">{{name}}</div>
    <div class="type">{{type}}</div>
  </div>
</div>
</template>

<script>
export default {
  name: "TeacherDetail",
  data(){


  },
  props:{
    id: {
      type: Number,
      default: 1
    },
    name:{
      type:String,
      default: "名称"
    },
    type:{
      type:String,
      default:"docx"
    }
  }
}
</script>

<style scoped>
.container{
  height: 50px;
  font-size: 16px;
  background-color: #f5e3e3;
  margin: -35px -40px;
  border-radius: 16px;
}
.context{
  float: left;
  width: 800px;

}
.id{
  width: 100px;
  float: left;
  text-align: center;


}
.name{
  width: 400px;
  float: left;
  text-align: center;
  cursor: pointer;
}
.type{
  width: 95px;
  float: right;

}
.img img{
  margin-left: 90px;
  width: 40px;
height: 40px;
  margin-top: -2px;
}
</style>
