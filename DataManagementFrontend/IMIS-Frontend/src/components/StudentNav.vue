<template>
  <div>
    <div class="nav1">
      <ul>
        <li><a>中南民族大学</a><span>|</span></li>
        <li><a>管理学院</a><span>|</span></li>
        <li><a>用户登录</a><span>|</span></li>
        <li><a>用户退出</a></li>
      </ul>
    </div>
    <div class="nav2">
      <div>
        <div class="logo">
          <img alt="logo"
               src="../../static/img/logo.png">
        </div>
      </div>
      <div>
        <ul>
          <li><a>新闻公告</a></li>
          <li><a>竞赛</a></li>
          <li><a>学分综测</a></li>
          <li><a>实验班</a></li>
        </ul>
      </div>
      <div>
        <span>EN</span>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "StudentNav",

}
</script>

<style lang="scss" scoped>
.nav1 {
  width: 100%;
  height: 45px;
  background-color: #DCE9F8;

  ul {
    display: flex;
    justify-content: space-around;
    width: 30%;
    align-items: center;
    float: right;
    margin-right: 10px;

    li {
      float: left;
      line-height: 45px;

      a {
        color: #3C85D7;
      }

      span {
        display: block;
        float: right;
        margin-left: 10px;
        color: #c0baba;
      }
    }
  }
}

.nav2 {
  display: flex;
  width: 100%;
  height: 85px;
  background-color: #f8f4f4;
  // border: 1px solid #3C85D7;
  // &>div{
  //   border: 1px solid #3C85D7;
  // }
  & > div:first-child {
    width: 25%;
  }

  .logo {
    width: 300px;
    height: 85px;
    float: right;

    img {
      width: 300px;
      height: 85px;
    }
  }

  & > div:nth-child(2) {
    width: 40%;

    ul {
      display: flex;
      justify-content: space-around;
      align-items: center;
      float: right;

      li {
        width: 130px;
        float: left;
        line-height: 85px;

        a {
          color: #3C85D7;
          font-size: 20px
        }
      }
    }
  }

  & > div:last-child {
    width: 35%;
    position: relative;

    span {
      display: block;
      width: 50px;
      height: 50px;
      float: right;
      border-radius: 50px;
      border: 1px solid #000000;
      color: #3C85D7;
      line-height: 50px;
      text-align: center;
      position: absolute;
      top: 50%;
      transform: translateY(-50%);
      right: 200px;
    }
  }
}
</style>
