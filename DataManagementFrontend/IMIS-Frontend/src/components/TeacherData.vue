<template>
<div id="content1">
  <h2>{{Title}}</h2>
  <h2>{{desc}}</h2>

</div>
</template>

<script>
export default {
  name:"TeacherData",
  data(){
    return{
      Title:'张三',
      desc:'这里是中南民族大学'
    }
  },


}
</script>

<style scoped>
      #content1{
        width: 1114px;
        height: 137px;
        margin: auto;
      }
</style>
