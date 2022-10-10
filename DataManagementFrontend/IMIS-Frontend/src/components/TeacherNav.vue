<template>
  <div>
    <div class="header">
      <TeacherNav_/>
    </div>
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

<style scoped>
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

/* body {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
}
*/
.header {
  background: #3c85d7;
  width: 100%;
  height: 60px;
  display: flex;
}
</style>
