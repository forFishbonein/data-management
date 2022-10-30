<template>
  <div class="footer">
    <div class="container">
      <div class="link">
        <div class="sublink">
          <ul>
            <li>指导老师：杨单</li>
            <li>邮箱：boinc@qq.com</li>
            <li>电话：027-67843646</li>
          </ul>
        </div>
        <div class="sublink">
          <ul>
            <li>开发人员：方菲、郭莹莹、何宇航、郝文海、刘璇、漆美霖、宋阳磊、王鑫、王亚东</li>
          </ul>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "LoginFooter"
}
</script>

<style scoped>
.footer {
  margin-top: 30px;
  width: 100%;
  height: 45px;
  background: #ffffff;
  position: absolute;
}

.container {
  width: 1200px;
  margin: 0 auto;
  z-index: 1;
}

.link {
  -webkit-box-flex: 1;
  -ms-flex: 1;
  flex: 1;
  overflow: hidden;
  margin-top: -15px;
  margin-right: 50px;
  display: flex;
  flex-direction: column;
}

.link ul {
  text-align: right;

}

.sublink {
  float: right;
}

.sublink li {
  font-size: 10px;
  display: inline-block;
  margin-right: 8px;
  color: #5c5c5c;
}

</style>
