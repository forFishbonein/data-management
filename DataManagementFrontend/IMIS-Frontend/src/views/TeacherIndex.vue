<template>
  <div class="body">
    <TeacherNav></TeacherNav>
    <div class="container">
      <TeacherHeader></TeacherHeader>
      <div class="tbody">
        <div class="line">
          <div class="decoration1"></div>
          <span class="title">资料</span>
        </div>
        <div class="data">
          <div v-show="!materials.length" class="notify">您还没有上传资源</div>
          <div v-for="(item, index) in materials" :key="index" class="data-container" @click="getOneFile(item)">
            <TeacherData :id="item.id"
                         :createTime="item.createTime"
                         :filePath="item.filePath"
                         :introduction="item.introduction"
                         :name="item.name"
                         :title="item.title"
            >
            </TeacherData>
          </div>

        </div>

      </div>
      <el-pagination
        :total="1000"
        align="center"
        background
        class="apage"
        layout="prev, pager, next">
      </el-pagination>


    </div>
    <LoginFooter></LoginFooter>
  </div>

</template>

<script>
import TeacherNav from '../components/TeacherNav.vue'
import TeacherHeader from '../components/TeacherHeader.vue'
import TeacherData from '../components/TeacherData.vue'
import LoginFooter from '../components/LoginFooter.vue'
import {getProfile} from '@/api/teacher.js'

export default {
  name: 'TeacherIndex',

  data() {
    return {
      materials: []
    }
  },
  methods: {
    getProfile() {
      getProfile(this.$store.state.teacherId).then(res => {
        // console.log(res.data[1])
        for (var i = 0; i < res.data.length; i++) {
          for (var j = 0; j < res.data[i].length; j++) {
            this.materials.push(res.data[i][j]);
          }
        }
      }).catch((error) => {
        if (error !== 'error') {
          this.$message({message: error, type: 'error', showClose: true});
        }
      });
    },
    getOneFile(item) {
      this.$router.push({
        name: item.template_TYPE,
        query: {
          templateType: item.template_TYPE,
          id: item.id
        }
      })
    },
  },
  components: {
    TeacherNav,
    TeacherHeader,
    TeacherData,
    LoginFooter
  },
  mounted() {
    // this.getMaterials();
    this.getProfile();
  }
}
</script>

<style lang="scss" scoped>

.body {
  background-color: #eaf2fb;
}

.container {
  width: 1200px;
  margin: 10px auto;
  display: flex;
  flex-direction: column;
  padding-bottom: 50px;


  .tbody {
    display: flex;
    flex-direction: column;
    background-color: #F5F9FF;
    border-radius: 12px;
    margin-top: 10px;


    .line {
      width: 1200px;
      height: 50px;
      background-color: #FFFFFF;
      display: flex;
      align-items: center;
      border-top-left-radius: 12px;
      border-top-right-radius: 12px;
    }

    .decoration1 {
      width: 3px;
      height: 25px;
      background-color: #1E5594;
      margin-left: 50px;
      margin-top: 1px;
    }

    .line > span {
      float: left;
      margin-left: 8px;
      font-size: 20px;
      color: #113355;
      font-weight: 550;
      margin-right: 0;
    }


  }


  .apage {
    margin-top: 30px;
  }

  .data {
    min-height: 35vh;
    background-color: white;
    border-radius: 12px;

    .notify {
      text-align: center;
    }

  }

  .data-container {
    background-color: #FFFFFF;
  }
}


</style>
