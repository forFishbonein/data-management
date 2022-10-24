<template>
  <div class="container">
    <div class="context">
      <div class="id">{{ id }}</div>
      <div class="name">{{ name }}</div>
      <div class="type">{{ type }}</div>
    </div>
    <div></div>
  </div>
</template>

<script>
export default {
  name: "FilePath",
  data() {
  },
}
</script>

<style scoped>
.container {
  width: 1097px;
  height: 50px;
  font-size: 16px;
  background-color: #FFFFFF;
  margin-left: 0px;
}

.context {
  float: left;
  width: 800px;

}

.id {
  width: 100px;
  float: left;
  text-align: center;


}

.name {
  width: 400px;
  float: left;
  text-align: center;
}

.type {
  width: 95px;

  float: right;

}

.img img {

  margin-left: 90px;
  width: 50px;
  height: 48px;

  margin-top: -15px;
}
</style>
