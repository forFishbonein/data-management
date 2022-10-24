<template>
  <div id="app">
<!--     <router-view></router-view>-->
<!--  <Teaching></Teaching>-->
<!--    <TeacherStudying></TeacherStudying>-->
<!--<PartyUpload></PartyUpload>-->
    <AchievementUpload></AchievementUpload>
  </div>
</template>

<script>
import RegisterTeacher from './views/RegisterTeacher'
import TeacherStudying from "./views/upload/StudyingUpload";
import Teaching from "./views/upload/TeachingUpload";
import PartyUpload from "./views/upload/PartyUpload";
import OfficeUpload from "./views/upload/OfficeUpload";
import ContestUpload from "./views/upload/ContestUpload";
import CommunicationUpload from "./views/upload/CommunicationUpload";
import AchievementUpload from "./views/upload/AchievementUpload";

export default {
  name: 'App',
  components:{
    AchievementUpload,
    CommunicationUpload,
    Teaching,
    TeacherStudying,
    RegisterTeacher,
    PartyUpload,
    ContestUpload
}
}
</script>

<style>

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
