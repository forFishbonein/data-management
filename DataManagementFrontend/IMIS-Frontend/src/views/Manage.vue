<template>
  <div class="container">
    <div class="nav">
      <div>
        <img  src="../../static/img/logo.png"
          alt="logo">
      </div>
      <div>
        <div class="search">
          <div class="search-icon"><span class="iconfont">&#xe651;</span></div>
          <input placeholder="搜索" class="tsearch"/>
        </div>
      </div>
      <div>
        <i class="iconfont">&#xe656;</i>
        <span>管理员</span>
        <div class="manager-pic">
          <img  alt="头像"
              src="https://ts2.cn.mm.bing.net/th?id=OIP-C.19LPGfyiWw_LZodJOolXSAHaHa&w=250&h=250&c=8&rs=1&qlt=90&o=6&dpr=1.25&pid=3.1&rm=2"
              id=""
              >
        </div>
      </div>
    </div>
    <div class="body">
      <div class="body-left">
        <ul class="list">
          <li class="li1">
            <router-link to="/fileManage" active-class="active">
              <span>教师文件管理</span>
            </router-link>
          </li>
          <li class="li2">竞赛管理
            <button @click="displayInfo">
              <span class="iconfont">&#xe600;</span>
            </button>
          </li>
          <ul id="info">
            <li>竞赛信息
              <button @click="displayComInfo">
                <span class="iconfont">&#xe600;</span>
              </button>
            </li>
            <ul id="com-info">
              <li>
                <router-link to="/competitionManage" active-class="active">
                  <span>竞赛发布</span>
                </router-link>
              </li>
              <li>
                <router-link to="/competitionManage" active-class="active">
                  <span>竞赛更新</span>
                </router-link>
              </li>
            </ul>
            <li>获奖信息
              <button @click="displayAwaInfo">
                <span class="iconfont">&#xe600;</span>
              </button>
            </li>
            <ul id="awa-info">
              <li>
                <router-link to="/competitionManage" active-class="active">
                  <span>获奖发布</span>
                </router-link>
              </li>
              <li>
                <router-link to="/competitionManage" active-class="active">
                  <span>获奖更新</span>
                </router-link>
              </li>
            </ul>
          </ul>
          <li class="li3">新闻管理
            <button @click="displayNewsInfo">
              <span class="iconfont">&#xe600;</span>
            </button>
          </li>
          <ul id="news-info">
            <li>
              <router-link to="/competitionManage" active-class="active">
                <span>新闻发布</span>
              </router-link>
            </li>
            <li>
              <router-link to="/competitionManage" active-class="active">
                <span>新闻更新</span>
              </router-link>
            </li>
          </ul>
          <li class="li4">
            <router-link to="/competitionManage" active-class="active">
              <span>用户管理</span>
            </router-link>
          </li>
        </ul>
      </div>
      <div class="body-right">
        <!-- <FileManage></FileManage> -->
        <router-view></router-view>
      </div>
    </div>

  </div>
</template>

<script>
// import FileManage from '../components/manage/FileManage.vue'
  export default {
    methods:{
      displayInfo(){
        const status1 = document.getElementById('info').style.display === '' ? 'none' : document.getElementById('info').style.display
        document.getElementById('info').style.display = status1 == 'none'? 'block': 'none'
      },
      displayComInfo(){
        const status2 = document.getElementById('com-info').style.display === '' ? 'none' : document.getElementById('com-info').style.display
        document.getElementById('com-info').style.display = status2 == 'none'? 'block': 'none'
      },
      displayAwaInfo(){
        const status3 = document.getElementById('awa-info').style.display === '' ? 'none' : document.getElementById('awa-info').style.display
        document.getElementById('awa-info').style.display = status3 == 'none'? 'block': 'none'
      },
      displayNewsInfo(){
        const status4 = document.getElementById('news-info').style.display === '' ? 'none' : document.getElementById('news-info').style.display
        document.getElementById('news-info').style.display = status4 == 'none'? 'block': 'none'
      },
    },
    components: {
    }
  }
</script>

<style lang="scss" scoped>
.container{
  width: 1200px;
  margin: 0 auto;
  display: flex;
  flex-direction: column;
  min-height: 900x;
  // border: 1px solid red;
  background-color: #FAFAFA;
  margin-bottom: 30px;
  padding-left: 10px;
  padding-right: 10px;
  padding-top: 10px;
  // border-radius: 30px;
  // margin-top: 30px;
  // box-shadow: 1px 1px 2px 2px;
  .nav{
    background-color: white;
    width: 100%;
    height: 100px;
    display: flex;
    align-items:center;
    justify-content: space-around;
    border-radius: 20px;
    box-shadow: 1px 1px 2px 2px #efefef;
    &>div:first-child{
      width: 20%;
      height: 85px;
      float: left;
      img{
        width: 200px;
        height: 85px;
      }
    }
    &>div:nth-child(2){
      width: 60%;
      float: left;
      display: flex;
      justify-content: center;
      .search{
        .search-icon {
        width: 40px;
        height: 30px;
        background-color: #DCE9F8;
        border-radius: 10px 0 0 10px;
        float: left;
        display: flex;
        align-items: center;
        justify-content: center;
        cursor: pointer;
        border: 1px #7A91BC solid;
        border-right: none;
      }

        .search-icon:hover {
          background-color: #679cd1
        }
        .iconfont {
          font-family: "iconfont" !important;
          font-size: 22px;
          font-style: normal;
          -webkit-font-smoothing: antialiased;
          -moz-osx-font-smoothing: grayscale;
          color: #FFFFFF
        }
        .tsearch {
          width: 550px;
          height: 30px;
          border-radius: 0 10px 10px 0;
          padding-left: 10px;
          // float: right;
          background-color: #DCE9F8;
          border: 1px #7A91BC solid;
          border-left: none;
          font-size: 20px;
          float: left;
        }
      }
    }
    &>div:last-child{
      width: 20%;
      float: right;
      position: relative;
      padding-right: 50px;
      .iconfont {
          font-family: "iconfont" !important;
          font-size: 22px;
          font-style: normal;
          -webkit-font-smoothing: antialiased;
          -moz-osx-font-smoothing: grayscale;
          color: #000000;
          margin-right:15px
      }
      span{
        font-size: 20px;
        line-height: 100px;
        margin-right: 15px;
      }
      .manager-pic{
        float: right;
        position: absolute;
        top: 50%;
        transform: translateY(-50%);
        right: 40px;
        img{
          width: 30px;
          height: 30px;
        }
      }
    }
  }
  .iconfont {
    font-family: "iconfont" !important;
    font-size: 22px;
    font-style: normal;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    color: #000000
  }
  .body{
    width: 100%;
    display: flex;
    min-height: 830px;
    padding-bottom: 30px;
    .body-left{
      width: 15%;
      height: 800px;
      // border: 1px solid red;
      float: left;
      // display: flex;
      // flex-direction: column;
      // align-items: center;
      .list{
        display: flex;
        flex-direction: column;
        justify-content: start;
        align-items: center;
        li{
          width: 130px;
          height: 50px;
          line-height: 50px;
          background-color: white;
          border-bottom: 4px solid #efefef;
          text-align: center;
          color:#1A59A1;
          border-radius: 10px;
        }
        .li1{
          margin-top: 20px;
          span{
            color:#1A59A1;
          }
        }
        .li2{
          text-align: left;
          padding-left: 20px;
          &>button{
            margin-left: 10px;
            background-color: white;
          }
        }
        #info{
          display: none;
          margin-left:20px;
          button{
            margin-left: 5px;
            background-color: white;
          }
          &>li{
            color: #3C85D7;
          }
        }
        #com-info{
          display: none;
          span{
            color:#7A91BC;
          }
        }
        #awa-info{
          display: none;
          span{
            color:#7A91BC;
          }
        }
        .li3{
          text-align: left;
          padding-left: 20px;
          &>button{
            margin-left: 10px;
            background-color: white;
          }
        }
        #news-info{
          display: none;
          margin-left: 10px;
          span{
            color: #3C85D7;
          }
        }
        .li4{
          text-align: left;
          padding-left: 20px;
          span{
            color:#1A59A1
          }
        }
      }
    }
    .body-right{
      width: 85%;
      height: 800px;
      // border: 1px solid red;
      float: right;
      padding: 20px;
    }
  }
  .active{
    font-weight: 600;
    text-shadow: 0.5px 0.5px 0.5px #175fb1;
  }
}
</style>
