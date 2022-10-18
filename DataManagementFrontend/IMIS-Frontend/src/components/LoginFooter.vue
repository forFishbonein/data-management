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
  width: 100%;
  height: 100px;
  background: #f4a018;
  position: absolute;
  bottom: 0;
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
  float: right;
  margin-top: 20px;
  margin-right: 50px;
}

.sublink {
  margin-bottom: 20px;
  float: right;
}

.sublink li {
  font-size: 16px;
  display: inline-block;
  margin-right: 2em;
  color: #fff;
}
</style>
