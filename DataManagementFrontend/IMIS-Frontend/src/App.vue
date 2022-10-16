<template>
  <div id="app">
   <TeacherIndex></TeacherIndex>
    <!-- <RegisterTeacher></RegisterTeacher> -->
    <!-- <RegisterStudent></RegisterStudent> -->
<<<<<<< HEAD
    <!-- <StudentIndex></StudentIndex> -->
    <Manage></Manage>
=======
    <!-- <Compete></Compete> -->
    <!-- <SearchResults></SearchResults> -->
>>>>>>> bf0ed64ff7d02e2ba711d579b44686735fa42b82
  </div>
</template>

<script>
import RegisterTeacher from './views/RegisterTeacher.vue'
import RegisterStudent from './views/RegisterStudent.vue'
<<<<<<< HEAD
import StudentIndex from './views/StudentIndex.vue'
import Manage from './views/Manage.vue'

=======
import Compete from "./views/Compete"
import SearchResults from "./views/SearchResults"
import TeacherIndex from "./views/TeacherIndex";
>>>>>>> bf0ed64ff7d02e2ba711d579b44686735fa42b82
export default {
  name: 'App',
  components: {
    Compete,
    RegisterTeacher,
    RegisterStudent,
<<<<<<< HEAD
    StudentIndex,
    Manage
=======
    SearchResults,
    TeacherIndex,
>>>>>>> bf0ed64ff7d02e2ba711d579b44686735fa42b82
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
