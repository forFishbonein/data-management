<template>
  <div>
    <StudentNav></StudentNav>
    <div class="hasBg">
      <div class="container">
        <div class="competitionSort">
          <div class="competitionSearch el-input el-input--medium el-input-group el-input-group--append el-input--suffix">
            <input type="text" autocomplete="off" placeholder="搜索竞赛名称" maxlength="20" class="el-input__inner">
            <div class="el-input-group__append">
              <button type="button" class="el-button el-button--default el-button--small">
                <i class="el-icon-search"></i>
              </button>
            </div>
          </div>
        </div>
        <div class="competitionList">
          <div class="hd mt30">
            <ul>
              <li v-for="(item,index) in classify" :key="item.index"
                  @click="addClass(index)" :class="{'active':position === index}">{{item}}</li>
            </ul>
          </div>
          <div class="bd mt30">
            <ul class="competitionListUl">
              <li class="status">
                <div class="img">
                  <img src="">
                </div>
                <div class="content">
                  <div class="tit">
                    <h2>第三届“大湾区杯”粤港澳金融数学建模竞赛</h2>
                  </div>
                  <div class="intro">
                    <p>品牌：“大湾区杯”粤港澳金融数学建模竞赛</p>
                    <p>组织单位：浙江核新同花顺网络信息股份有限公司、深圳点宽网络科技有限公司、广东聚智诚科技有限公司</p>
                  </div>
                  <div class="info">
                    <span class="dateTime"><i class="el-icon-time"></i>时间：2022-10-12 ~ 2022-11-08</span>
                  </div>
                </div>
              </li>
              <li class="status">
                <div class="img">
                  <img src="">
                </div>
                <div class="content">
                  <div class="tit">
                    <h2>第五届“泰迪杯”数据分析技能赛</h2>
                  </div>
                  <div class="intro">
                    <p>品牌：“泰迪杯”数据分析技能赛</p>
                    <p>组织单位：泰迪杯数据分析技能赛组织委员会、广东泰迪智能科技股份有限公司、广东省工业与应用数学学会、人民邮电出版社、北京泰迪云智信息技术研究院、网宿科技股份有限公司</p>
                  </div>
                  <div class="info">
                    <span class="dateTime"><i class="el-icon-time"></i>时间：2022-09-05 ~ 2022-11-13</span>
                  </div>
                </div>
              </li>
            </ul>
            <div class="pageSize">
              <div class="el-pagination is-background">
                <button type="button" disabled="disabled" class="btn-prev"><i class="el-icon el-icon-arrow-left"></i>
                </button>
                <ul class="el-pager">
                  <li class="number active">1</li>
                  <li class="number">2</li>
                  <li class="number">3</li>
                  <li class="number">4</li>
                  <li class="number">5</li>
                  <li class="number">6</li>
                  <li class="el-icon more btn-quicknext el-icon-more"></li>
                  <li class="number">8</li>
                </ul>
                <button type="button" class="btn-next"><i class="el-icon el-icon-arrow-right"></i></button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import StudentNav from "../components/StudentNav";

export default {
  data() {
    return {
      classify: ['全部分类','分类一','分类二','分类三','分类四'],
      position: ''
    }
  },
  methods: {
    addClass(index) {
      this.position = index
    }
  },
  components: {StudentNav}
}
</script>

<style scoped>
.hasBg {
  background: #3C85D7;
  position: relative;
  padding: 30px 0;
  -webkit-box-sizing: border-box;
  box-sizing: border-box;
}

.container {
  width: 1200px;
  margin: 0 auto;
  z-index: 1;
}

.competitionSort {
  border-radius: 6px;
  padding: 25px;
  position: relative;
  min-height: 70px;
}

.competitionSort .competitionSearch {
  position: absolute;
  width: 300px;
  right: 0px;
  top: 25px;
}

.competitionList .hd ul {
  width: 100%;
  display: -webkit-box;
  display: -ms-flexbox;
  display: flex;
}

.mt30 {
  margin-top: 30px;
}

.competitionList .hd li.active {
  background-color: #0065ff;
  border-color: #0065ff;
  color: #fff;
}

.competitionList .hd li {
  text-align: center;
  height: 44px;
  line-height: 43px;
  background: #fff;
  border: 1px solid #e1e3ed;
  color: #5b6065;
  border-radius: 5px;
  margin-right: 10px;
  font-size: 15px;
  -webkit-box-flex: 1;
  -ms-flex: 1;
  flex: 1;
  white-space: nowrap;
  overflow: hidden;
  text-overflow: ellipsis;
}

.competitionListUl li {
  background: #fff;
  padding: 30px;
  height: 270px;
  border-radius: 6px;
  margin-bottom: 25px;
  border: 1px solid #e4e9f1;
  display: -webkit-box;
  display: -ms-flexbox;
  display: flex;
  font-size: 16px;
  position: relative;
}

.competitionListUl li .img {
  width: 320px;
  height: 180px;
  margin-right: 35px;
  border-radius: 6px;
  overflow: hidden;
}

.competitionListUl li .content {
  -webkit-box-flex: 1;
  flex: 1 1 0%;
  overflow: hidden;
}

.competitionListUl li .content .tit {
  display: -ms-inline-flexbox;
  display: inline-flex;
  max-width: 90%;
  -webkit-box-align: baseline;
  -ms-flex-align: baseline;
  align-items: baseline;
  margin-bottom: 25px;
}

.competitionListUl li .content .intro {
  line-height: 35px;
  height: 90px;
  margin-bottom: 30px;
  color: rgb(91, 96, 101);
}

.competitionListUl li .content .info {
  color: rgb(91, 96, 101);
  display: inline-flex;
  -webkit-box-pack: justify;
  justify-content: space-between;
  width: 100%;
  -webkit-box-align: center;
  align-items: center;
}

.competitionListUl li .content .info span.dateTime {
  width: 280px;
}

.status::before {
  content: "";
  border-width: 40px;
  border-style: solid;
  border-image: initial;
  border-color: rgb(153, 156, 162) rgb(153, 156, 162) transparent transparent;
  border-radius: 0px 6px 0px 0px;
  right: 0px;
  top: 0px;
}

.status::after {
  color: rgb(255, 255, 255);
  transform: rotate(45deg);
  right: 2px;
  top: 21px;
  font-size: 15px;
  letter-spacing: 1px;
}

.status::after, .status::before {
  position: absolute;
  display: none;
}

.pageSize {
  text-align: center;
  padding: 30px 0;
}
</style>
