<template>
  <div id="app">
    <!-- <Index></Index> -->
    <!-- <RegisterTeacher></RegisterTeacher> -->
    <!-- <RegisterStudent></RegisterStudent> -->
    <Search></Search>
    <!-- <Resource_></Resource_> -->

  </div>
</template>

<script>
import Index from './views/Index.vue'
import RegisterTeacher from './views/RegisterTeacher.vue'
import RegisterStudent from './views/RegisterStudent.vue'
import Search from './views/Search.vue'
import Resource_ from './views/Resource_.vue'

export default {
  name: 'App',
  components: {
    Index,
    RegisterTeacher,
    RegisterStudent,
    Search,
    Resource_
}
}
</script>

<style>
#app {
  text-align: center;
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
