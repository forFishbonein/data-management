<template>
  <div class="m-container">
    <!-- 教师账号管理 -->
    <el-table
      :data="tableData"
      stripe
      style="width: 100%">
      <el-table-column
        align="center"
        label="教师邮箱"
        prop="teacherEmail"
      >
      </el-table-column>
      <el-table-column
        align="center"
        label="教师姓名"
        prop="teacherName"
        width="180"
      >
      </el-table-column>

      <el-table-column
        label="简介"
        type="expand">
        <template slot-scope="props">
          <span>账号ID：{{ props.row.teacherId }}</span>
          <span>教工号：{{ props.row.teacherSid }}</span>
          <span>密码：{{ props.row.teacherPass }}</span>
        </template>
      </el-table-column>
      <el-table-column
        align="center"
        label="操作"
        width="240">
        <template slot-scope="scope">
          <el-row>
            <el-link type="primary" @click="getOneFile(scope.row)">查看详情</el-link>
            <el-link type="primary" @click="updateById(scope.row)">修改</el-link>
            <el-link type="primary" @click="deleteById(scope.row)">删除</el-link>
          </el-row>
        </template>
      </el-table-column>


    </el-table>

  </div>
</template>

<script>
import {getAllTeacher} from '@/api/teacher'

export default {
  name: 'TeacherManage',

  methods: {
    getAllTeacher() {
      getAllTeacher().then(resp => {
        this.tableData = resp.data
        console.log(resp.data)
      })
    }
  },

  mounted() {
    this.getAllTeacher();
  },

  data() {
    return {
      tableData: []
    }
  }


}
</script>

<style lang="scss" scoped>
.m-container {
  width: 100%;
  background-color: white;
  padding: 0;

  .m-header {
    width: 95%;
    margin: 0 auto;
    height: 50px;
    display: flex;
    align-items: center;
    background-color: #F5F5F5;
    border-radius: 15px;

    ul {
      float: left;
      display: flex;
      justify-content: space-around;

      li {
        float: left;
        width: 126px;
        font-size: 17px;
        text-align: center;
        color: #3C85D7;
      }
    }
  }

  .m-body {
    width: 95%;
    margin: 0 auto;
    height: 700px;
    display: flex;
    flex-direction: column;
    align-items: flex-start;
    border-radius: 15px;

    .m-item {
      background-color: #FDFDFD;
      width: 100%;
      border-bottom: 3px solid #efefef;

      ul {
        float: left;
        display: flex;
        justify-content: space-around;
        align-items: center;
        height: 50px;

        li {
          float: left;
          width: 126px;
          font-size: 17px;
          color: #3C85D7;
          text-align: center;
        }

        & > li:nth-last-child(2) {
          button {
            font-size: 15px;
            color: white;
            background-color: #0E4687;
            width: 3.5em;
            height: 2em;
            border-radius: 8px;
          }
        }

        & > li:last-child {
          button {
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
