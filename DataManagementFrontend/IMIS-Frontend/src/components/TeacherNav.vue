<template>
 <div>
   <header>
     <TeacherNav_ />
   </header>
 </div>
</template>

<script>
import TeacherNav_ from './TeacherNav_'
export default {
  name: 'TeacherNav',
  components: {
    TeacherNav_
  }
}
</script>

<style>
  * {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
  }
  body {
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
  }
  header {
    background: dimgrey;
    width: auto;
    height: 48px;
  }
</style>
