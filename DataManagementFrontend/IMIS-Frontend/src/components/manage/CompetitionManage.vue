<template>
  <div class="m-container">
    <div class="m-header">
      <ul>
        <li>比赛名</li>
        <li>比赛类型</li>
        <li>开赛时间</li>
        <li>比赛级别</li>
        <li>编辑</li>
        <li>删除</li>
      </ul>
    </div>
    <div class="m-body">
      <div class="m-item">
        <ul>
          <li>互联网+</li>
          <li>创新创业</li>
          <li>2022/10/15</li>
          <li>国家级</li>
          <li>
            <button>编辑</button>
          </li>
          <li>
            <button>删除</button>
          </li>
        </ul>
      </div>
    </div>
  </div>
</template>

<script>
export default {}
</script>

<style lang="scss" scoped>
.m-container {
  width: 100%;
  // height: 800px;
  // border: 1px solid red;
  background-color: white;
  padding: 20px 0;

  .m-header {
    width: 95%;
    margin: 0 auto;
    height: 40px;
    display: flex;
    align-items: center;
    background-color: #F5F5F5;
    border-radius: 15px;

    ul {
      float: left;
      display: flex;
      justify-content: space-around;
      padding: 0 24px;

      li {
        float: left;
        width: 153.5px;
        font-size: 20px;
        color: #3C85D7;
      }
    }
  }

  .m-body {
    width: 95%;
    margin: 0 auto;
    height: 700px;
    margin-top: 20px;
    background-color: #F5F5F5;
    display: flex;
    flex-direction: column;
    align-items: flex-start;
    border-radius: 15px;
    padding: 24px;

    .m-item {
      background-color: #efefef;
      width: 100%;
      border-radius: 10px;

      ul {
        float: left;
        display: flex;
        justify-content: space-around;
        align-items: center;
        height: 50px;

        li {
          float: left;
          width: 153.5px;
          font-size: 19px;
          color: #3C85D7;

          button {
            font-size: 15px;
            color: white;
            background-color: #ee0b0b;
            width: 3.5em;
            height: 2em;
            border-radius: 8px;
          }
        }
      }
    }
  }
}
</style>
