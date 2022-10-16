<template>
  <div class="m-container">
    <div class="m-header">
      <ul>
        <li>文件名</li>
        <li>文件类型</li>
        <li>上传日期</li>
        <li>上传者</li>
        <li>编辑</li>
        <li>删除</li>
      </ul>
    </div>
    <div class="m-body">
      <div class="m-item">
        <ul>
          <li>资料1</li>
          <li>项目</li>
          <li>2022/10/16</li>
          <li>张三</li>
          <li><button>编辑</button></li>
          <li><button>删除</button></li>
        </ul>
      </div>
    </div>
  </div>
</template>

<script>
  export default {

  }
</script>

<style lang="scss" scoped>
  .m-container{
    width: 100%;
    // height: 800px;
    // border: 1px solid red;
    background-color: white;
    padding: 20px 0;
    .m-header{
      width: 95%;
      margin: 0 auto;
      height: 50px;
      display: flex;
      align-items: center;
      background-color: #F5F5F5;
      border-radius: 15px;
      ul{
        float: left;
        display: flex;
        justify-content: space-around;
        padding: 0 24px;
        li{
          float: left;
          width: 144.5px;
          font-size: 17px;
          text-align: center;
          color: #3C85D7;
        }
      }
    }
    .m-body{
      width: 95%;
      margin: 0 auto;
      height: 700px;
      margin-top: 20px;
      // background-color: #F5F5F5;
      display: flex;
      flex-direction: column;
      align-items: flex-start;
      border-radius: 15px;
      padding: 24px;
      .m-item{
        background-color: #FDFDFD;
        width: 100%;
        border-bottom: 3px solid #efefef;
        ul{
          float: left;
          display: flex;
          justify-content: space-around;
          align-items: center;
          height: 50px;
          li{
            float: left;
            width: 144.5px;
            font-size: 17px;
            color: #3C85D7;
            text-align: center;
          }
          &>li:nth-last-child(2){
            button{
              font-size: 15px;
              color: white;
              background-color: #0E4687;
              width: 3.5em;
              height: 2em;
              border-radius: 8px;
            }
          }
          &>li:last-child{
            button{
              font-size: 15px;
              color: white;
              background-color: #DF2060;
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
