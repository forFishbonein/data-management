<template>
  <div class="m-container">
    <el-table
      :data="tableData"
      stripe
      style="width: 100%">
      <el-table-column
        prop="name"
        label="姓名">
      </el-table-column>
      <el-table-column
        prop="date"
        label="创建时间"
        width="180">
      </el-table-column>
        <el-table-column
        prop="email"
        label="邮箱"
        width="180">
        </el-table-column>

      <el-table-column
        prop="detail"
        label="操作"  width="240">
        <el-link type="primary">查看详情</el-link>
        <el-link type="primary">编辑</el-link>
        <el-link type="primary">删除</el-link>
      </el-table-column>

    </el-table>
  </div>
</template>

<script>
export default {
  name: 'AccountManage',

  data() {
    return {
      tableData: [
        {
          name: '2016-05-02',
          date: '王小虎',
          email: '上海市普陀区金沙江路 1518 弄'

        },{
          name: '2016-05-02',
          date: '王小虎',
          email: '上海市普陀区金沙江路 1518 弄'

        },{
          name: '2016-05-02',
          date: '王小虎',
          email: '上海市普陀区金沙江路 1518 弄'

        }
      ]
    }
  }

}
</script>

<style lang="scss" scoped>
.m-container{
  width: 100%;
  // height: 800px;
  // border: 1px solid red;
  background-color: white;
  padding: 0;
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
      li{
        float: left;
        width: 126px;
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
    //margin-top: 20px;
    // background-color: #F5F5F5;
    display: flex;
    flex-direction: column;
    align-items: flex-start;
    border-radius: 15px;
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
          width: 126px;
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
