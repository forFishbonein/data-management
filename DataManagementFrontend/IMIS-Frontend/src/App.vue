<template>
  <div id="app">
    <Index></Index>
  </div>
</template>

<script>
import Index from './views/Index.vue'
export default {
  name: 'App',
  components: {
    Index
  }
}
</script>

<style>
#app {
  text-align: center;
}
div,dl,dt,dd,ul,ol,li,h1,h2,h3,h4,h5,h6,pre,form,fieldset,legend,input,textarea,button
,p,blockquote,th,td{
    margin: 0;
    padding: 0;
}
ul,ol,li{
    list-style: none;
}
a{
    text-decoration: none;
    color: #333;
    cursor: pointer;
}
input,button,img,select,textarea{
    border: none;
    vertical-align: middle;
    outline: none;
}
textarea{
    resize:none;
}
button{
    cursor: pointer;
}
label{
    cursor: pointer;
}
</style>
