<template>
  <div id="app">
<<<<<<< HEAD
    <TeacherIndex></TeacherIndex>
    <TeacherIndex></TeacherIndex>
=======
<<<<<<< HEAD
   <TeacherIndex></TeacherIndex>
<!--     <RegisterTeacher></RegisterTeacher>-->
<!--     <RegisterStudent></RegisterStudent>-->
<!--     <StudentIndex></StudentIndex>-->
<!--     <Manage></Manage>-->
    <!-- <Compete></Compete> -->
<!--     <SearchResults></SearchResults>-->
<!--    <test></test>-->
    <!-- <LoginFooter></LoginFooter> -->
=======
     <TeacherIndex></TeacherIndex>
>>>>>>> aa9f786e38ff4a8ce0f1854aa2aa4ba83a039e9e
    <!-- <RegisterTeacher></RegisterTeacher> -->
    <!-- <RegisterStudent></RegisterStudent> -->
    <!-- <StudentIndex></StudentIndex> -->
    <!-- <Manage></Manage> -->
    <!-- <Compete></Compete> -->
    <!-- <SearchResults></SearchResults> -->
    <!-- <test></test> -->
>>>>>>> 1eaf1926808391991ef216b01a46ce6d05f6a110
  </div>
</template>

<script>
import RegisterTeacher from './views/RegisterTeacher.vue'
import RegisterStudent from './views/RegisterStudent.vue'
import StudentIndex from './views/StudentIndex.vue'
import Manage from './views/Manage.vue'
import Compete from "./views/Compete"
import SearchResults from "./views/SearchResults"
import TeacherIndex from "./views/TeacherIndex";
import test from "./views/test.vue";
import LoginIna from "./views/LoginIna.vue"
export default {
  name: 'App',
  components: {
    Compete,
    RegisterTeacher,
    RegisterStudent,
    StudentIndex,
    Manage,
    SearchResults,
    TeacherIndex,
    test
  }
}
</script>

<style>
#app {
}

div, dl, dt, dd, ul, ol, li, h1, h2, h3, h4, h5, h6, pre, form, fieldset, legend, input, textarea, button, p, blockquote, th, td {
  margin: 0;
  padding: 0;
}

ul, ol, li {
  list-style: none;
}

a {
  text-decoration: none;
  color: #333;
  cursor: pointer;
}

input, button, img, select, textarea {
  border: none;
  vertical-align: middle;
  outline: none;
}

textarea {
  resize: none;
}

button {
  cursor: pointer;
}

label {
  cursor: pointer;
}

* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}
</style>
