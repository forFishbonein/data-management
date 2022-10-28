<template>
  <div class="m-container">
    <!--Studying科研项目-->
    <el-table
      :data="Studying"
      stripe
      style="width: 100%">
      <el-table-column
        label="资源名称"
        prop="title"
        align="center"
      >
      </el-table-column>
      <el-table-column
        label="资源类型"
        width="180"
        align="center">
        科研项目
      </el-table-column>
      <el-table-column
        label="上传日期"
        prop="createTime"
        width="180"
        align="center"
      >
      </el-table-column>
      <el-table-column
        label="上传者"
        prop="uploaderId"
        width="180"
        align="center"
      >
      </el-table-column>
      <el-table-column
        type="expand"
        label="简介">
        <template slot-scope="props">
          <span>简介：{{ props.row.introduction }}</span>
        </template>
      </el-table-column>
      <el-table-column
        label="操作"
        width="240"
        align="center">
        <template slot-scope="scope">
          <el-row>
            <el-link type="primary" @click="getOneFile(scope.row)">查看详情</el-link>
            <el-link type="primary" @click="updateById(scope.row)">修改</el-link>
            <el-link type="primary" @click="deleteById(scope.row)">删除</el-link>
          </el-row>
        </template>
      </el-table-column>


    </el-table>
    <!--Teaching教研项目-->
    <el-table
      :data="Teaching"
      stripe
      style="width: 100%">
      <el-table-column
        label="资源名称"
        prop="title"
        align="center"
      >
      </el-table-column>
      <el-table-column
        label="资源类型"
        width="180"
        align="center">
        教研项目
      </el-table-column>
      <el-table-column
        label="上传日期"
        prop="createTime"
        width="180"
        align="center"
      >
      </el-table-column>
      <el-table-column
        label="上传者"
        prop="uploaderId"
        width="180"
        align="center"
      >
      </el-table-column>
      <el-table-column
        type="expand"
        label="简介">
        <template slot-scope="props">
          <span>简介：{{ props.row.introduction }}</span>
        </template>
      </el-table-column>
      <el-table-column
        label="操作"
        width="240"
        align="center">
        <template slot-scope="scope">
          <el-row>
            <el-link type="primary" @click="getOneFile(scope.row)">查看详情</el-link>
            <el-link type="primary" @click="updateById(scope.row)">修改</el-link>
            <el-link type="primary" @click="deleteById(scope.row)">删除</el-link>
          </el-row>
        </template>
      </el-table-column>


    </el-table>
    <!--Honor各类荣誉-->
    <el-table
      :data="Honor"
      stripe
      style="width: 100%">
      <el-table-column
        label="资源名称"
        prop="title"
        align="center"
      >
      </el-table-column>
      <el-table-column
        label="资源类型"
        width="180"
        align="center">
        各类荣誉
      </el-table-column>
      <el-table-column
        label="上传日期"
        prop="createTime"
        width="180"
        align="center"
      >
      </el-table-column>
      <el-table-column
        label="上传者"
        prop="uploaderId"
        width="180"
        align="center"
      >
      </el-table-column>
      <el-table-column
        type="expand"
        label="简介">
        <template slot-scope="props">
          <span>简介：{{ props.row.introduction }}</span>
        </template>
      </el-table-column>
      <el-table-column
        label="操作"
        width="240"
        align="center">
        <template slot-scope="scope">
          <el-row>
            <el-link type="primary" @click="getOneFile(scope.row)">查看详情</el-link>
            <el-link type="primary" @click="updateById(scope.row)">修改</el-link>
            <el-link type="primary" @click="deleteById(scope.row)">删除</el-link>
          </el-row>
        </template>
      </el-table-column>


    </el-table>
    <!--Achievement成果类-->
    <el-table
      :data="Achievement"
      stripe
      style="width: 100%">
      <el-table-column
        label="资源名称"
        prop="title"
        align="center"
      >
      </el-table-column>
      <el-table-column
        label="资源类型"
        width="180"
        align="center">
        成果类
      </el-table-column>
      <el-table-column
        label="上传日期"
        prop="createTime"
        width="180"
        align="center"
      >
      </el-table-column>
      <el-table-column
        label="上传者"
        prop="uploaderId"
        width="180"
        align="center"
      >
      </el-table-column>
      <el-table-column
        type="expand"
        label="简介">
        <template slot-scope="props">
          <span>简介：{{ props.row.introduction }}</span>
        </template>
      </el-table-column>
      <el-table-column
        label="操作"
        width="240"
        align="center">
        <template slot-scope="scope">
          <el-row>
            <el-link type="primary" @click="getOneFile(scope.row)">查看详情</el-link>
            <el-link type="primary" @click="updateById(scope.row)">修改</el-link>
            <el-link type="primary" @click="deleteById(scope.row)">删除</el-link>
          </el-row>
        </template>
      </el-table-column>


    </el-table>
    <!--Contest学生竞赛-->
    <el-table
      :data="Contest"
      stripe
      style="width: 100%">
      <el-table-column
        label="资源名称"
        prop="title"
        align="center"
      >
      </el-table-column>
      <el-table-column
        label="资源类型"
        width="180"
        align="center">
        学生竞赛
      </el-table-column>
      <el-table-column
        label="上传日期"
        prop="createTime"
        width="180"
        align="center"
      >
      </el-table-column>
      <el-table-column
        label="上传者"
        prop="uploaderId"
        width="180"
        align="center"
      >
      </el-table-column>
      <el-table-column
        type="expand"
        label="简介">
        <template slot-scope="props">
          <span>简介：{{ props.row.introduction }}</span>
        </template>
      </el-table-column>
      <el-table-column
        label="操作"
        width="240"
        align="center">
        <template slot-scope="scope">
          <el-row>
            <el-link type="primary" @click="getOneFile(scope.row)">查看详情</el-link>
            <el-link type="primary" @click="updateById(scope.row)">修改</el-link>
            <el-link type="primary" @click="deleteById(scope.row)">删除</el-link>
          </el-row>
        </template>
      </el-table-column>


    </el-table>
    <!--Communication交流访问-->
    <el-table
      :data="Communication"
      stripe
      style="width: 100%">
      <el-table-column
        label="资源名称"
        prop="title"
        align="center"
      >
      </el-table-column>
      <el-table-column
        label="资源类型"
        width="180"
        align="center">
        交流访问
      </el-table-column>
      <el-table-column
        label="上传日期"
        prop="createTime"
        width="180"
        align="center"
      >
      </el-table-column>
      <el-table-column
        label="上传者"
        prop="uploaderId"
        width="180"
        align="center"
      >
      </el-table-column>
      <el-table-column
        type="expand"
        label="简介">
        <template slot-scope="props">
          <span>简介：{{ props.row.introduction }}</span>
        </template>
      </el-table-column>
      <el-table-column
        label="操作"
        width="240"
        align="center">
        <template slot-scope="scope">
          <el-row>
            <el-link type="primary" @click="getOneFile(scope.row)">查看详情</el-link>
            <el-link type="primary" @click="updateById(scope.row)">修改</el-link>
            <el-link type="primary" @click="deleteById(scope.row)">删除</el-link>
          </el-row>
        </template>
      </el-table-column>


    </el-table>
    <!--Party党支部-->
    <el-table
      :data="Party"
      stripe
      style="width: 100%">
      <el-table-column
        label="资源名称"
        prop="title"
        align="center"
      >
      </el-table-column>
      <el-table-column
        label="资源类型"
        width="180"
        align="center">
        党支部
      </el-table-column>
      <el-table-column
        label="上传日期"
        prop="createTime"
        width="180"
        align="center"
      >
      </el-table-column>
      <el-table-column
        label="上传者"
        prop="uploaderId"
        width="180"
        align="center"
      >
      </el-table-column>
      <el-table-column
        type="expand"
        label="简介">
        <template slot-scope="props">
          <span>简介：{{ props.row.introduction }}</span>
        </template>
      </el-table-column>
      <el-table-column
        label="操作"
        width="240"
        align="center">
        <template slot-scope="scope">
          <el-row>
            <el-link type="primary" @click="getOneFile(scope.row)">查看详情</el-link>
            <el-link type="primary" @click="updateById(scope.row)">修改</el-link>
            <el-link type="primary" @click="deleteById(scope.row)">删除</el-link>
          </el-row>
        </template>
      </el-table-column>


    </el-table>
    <!--Office教研室-->
    <el-table
      :data="Office"
      stripe
      style="width: 100%">
      <el-table-column
        label="资源名称"
        prop="title"
        align="center"
      >
      </el-table-column>
      <el-table-column
        label="资源类型"
        width="180"
        align="center">
        教研室
      </el-table-column>
      <el-table-column
        label="上传日期"
        prop="createTime"
        width="180"
        align="center"
      >
      </el-table-column>
      <el-table-column
        label="上传者"
        prop="uploaderId"
        width="180"
        align="center"
      >
      </el-table-column>
      <el-table-column
        type="expand"
        label="简介">
        <template slot-scope="props">
          <span>简介：{{ props.row.introduction }}</span>
        </template>
      </el-table-column>
      <el-table-column
        label="操作"
        width="240"
        align="center">
        <template slot-scope="scope">
          <el-row>
            <el-link type="primary" @click="getOneFile(scope.row)">查看详情</el-link>
            <el-link type="primary" @click="updateById(scope.row)">修改</el-link>
            <el-link type="primary" @click="deleteById(scope.row)">删除</el-link>
          </el-row>
        </template>
      </el-table-column>


    </el-table>
    <!--Defined自定义-->
    <el-table
      :data="Defined"
      stripe
      style="width: 100%">
      <el-table-column
        label="资源名称"
        prop="title"
        align="center"
      >
      </el-table-column>
      <el-table-column
        label="资源类型"
        width="180"
        align="center">
        自定义
      </el-table-column>
      <el-table-column
        label="上传日期"
        prop="createTime"
        width="180"
        align="center"
      >
      </el-table-column>
      <el-table-column
        label="上传者"
        prop="uploaderId"
        width="180"
        align="center"
      >
      </el-table-column>
      <el-table-column
        type="expand"
        label="简介">
        <template slot-scope="props">
          <span>简介：{{ props.row.introduction }}</span>
        </template>
      </el-table-column>
      <el-table-column
        label="操作"
        width="240"
        align="center">
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
import { getAllResource } from '@/api/manage'
import { getOneFile } from '@/api/file'

export default {
  name: 'FileManage',

  methods: {
    getAllResource() {
      getAllResource().then(resp => {
        this.Studying = resp.data[0];
        this.Teaching = resp.data[1];
        this.Honor = resp.data[2];
        this.Achievement = resp.data[3];
        this.Contest = resp.data[4];
        this.Communication = resp.data[5];
        this.Party = resp.data[6];
        this.Office = resp.data[7];
        this.Defined = resp.data[8];
      });
    },

    getOneFile(row) {
      this.Query.TEMPLATE_TYPE = row.template_TYPE;
      this.Query.id = row.id;
      console.log("---")
      console.log(this.Query);
      console.log("---")
      getOneFile(this.Query).then(resp => {
        console.log(resp)
      });
    },

    updateById(row) {

    },

    deleteById(row) {

    },

  },

  mounted() {
    this.getAllResource();


  },

  data() {
    return {
      Studying: [],
      Teaching: [],
      Honor: [],
      Achievement: [],
      Contest: [],
      Communication: [],
      Party: [],
      Office: [],
      Defined: [],
      Query: {
        TEMPLATE_TYPE: "",
        id: ""
      }
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
