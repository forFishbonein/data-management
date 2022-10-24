<template>
  <div class="background">
    <TeacherNav/>
    <div class="main">
      <div class="title">科研项目</div>
      <div class="content">
        <form>
          <div class="choose"><span>选择模板&emsp;</span>
            <a href="">
              <button value="a1">科研项目</button>
            </a>
            <button value="a2">教研项目</button>
            <a href="">
              <button value="a3">各类荣誉</button>
            </a>
            <a href="">
              <button value="a4">成果类</button>
            </a><a href="">
              <button value="a5">学生竞赛</button>
            </a><a href="">
              <button value="a6">交流访问</button>
            </a> <a href="">
              <button value="a6">党支部</button>
            </a> <a href="">
              <button value="a6">教研室</button>
            </a> <a href="">
              <button value="a6">论文/期刊</button>
            </a> <a href="">
              <button value="a6">其他</button>
            </a>
          </div>

          <div class="resources">
            <span>资源名称</span>
            <input placeholder="请输入文字" type="text">
          </div>
          <div class="resources">
            <span>项目简介</span>
            <textarea placeholder="请输入文字" style="width:450px ;height:125px;" type="text"/>
          </div>
          <div class="resources">
            <span>项目来源</span>
            <input placeholder="请输入文字" type="text">
          </div>
          <div class="resources">
            <span>项目类型</span>
            <el-autocomplete
              v-model="state"
              :fetch-suggestions="querySearch"
              placeholder="请输入文字"
              popper-class="my-autocomplete"
              @select="handleSelect">
              <i
                slot="suffix"
                class="el-icon-edit el-input__icon"
                @click="handleIconClick">
              </i>
              <template slot-scope="{ item }">
                <div class="name">{{ item.value }}</div>
              </template>
            </el-autocomplete>
          </div>
          <div class="resources">
            <span>项目级别</span>
            <input placeholder="请输入文字" type="text">
          </div>
          <div class="resources">
            <span>立项时间</span>
            <input placeholder="请输入时间" type="date">
          </div>
          <div class="resources">
            <span>结项时间</span>
            <input placeholder="请输入时间" type="date">
          </div>
          <div class="resources">
            <span>项目经费</span>
            <input placeholder="请输入数字" type="number">
          </div>
          <div class="resources">
            <span>课题组成员</span>
            <el-tag
              v-for="tag in dynamicTags"
              :key="tag"
              :disable-transitions="false"
              closable
              @close="handleClose(tag)">
              {{ tag }}
            </el-tag>
            <el-input
              v-if="inputVisible"
              ref="saveTagInput"
              v-model="inputValue"
              class="input-new-tag"
              size="small"
              @blur="handleInputConfirm"
              @keyup.enter.native="handleInputConfirm"
            >
            </el-input>
            <el-button v-else class="button-new-tag" size="small" type="button" @click="showInput">+ New Tag</el-button>
            <!--                </div>-->
          </div>
          <div class="resources">
            <span>附件上传</span>
            <div class="upload">
              <el-upload
                :before-remove="beforeRemove"
                :file-list="fileList"
                :limit="3"
                :on-exceed="handleExceed"
                :on-preview="handlePreview"
                :on-remove="handleRemove"
                action="https://jsonplaceholder.typicode.com/posts/"
                class="upload-demo"
                multiple>
                <el-button size="small" type="primary">点击选择</el-button>
              </el-upload>
            </div>
          </div>
          <button type="submit">立即上传</button>

        </form>
      </div>
    </div>
  </div>
</template>

<script>
import TeacherNav from "../TeacherNav";

export default {
  name: 'PartyUpload',
  components: {TeacherNav},
  data() {
    return {
      dynamicTags: [],
      inputVisible: true,
      inputValue: '',
      fileList: [],
      restaurants: [],
      state: ''
    };
  },
  methods: {
    handleClose(tag) {
      this.dynamicTags.splice(this.dynamicTags.indexOf(tag), 1);
    },

    showInput() {
      this.inputVisible = true;
      this.$nextTick(_ => {
        // this.dynamicTags.push(_);
        this.$refs.saveTagInput.$refs.input.focus();
        // this.$refs.saveTagInput.$refs.input.focus();
        console.log(_);

      });
    },

    handleInputConfirm() {
      let inputValue = this.inputValue;
      if (inputValue) {
        this.dynamicTags.push(inputValue);

      }
      this.inputVisible = false;
      this.inputValue = '';
      this.dynamicTags.push(_);
    },
    handleRemove(file, fileList) {
      console.log(file, fileList);
    },
    handlePreview(file) {
      console.log(file);
    },
    handleExceed(files, fileList) {
      this.$message.warning(`当前限制选择 3 个文件，本次选择了 ${files.length} 个文件，共选择了 ${files.length + fileList.length} 个文件`);
    },
    beforeRemove(file, fileList) {
      return this.$confirm(`确定移除 ${file.name}？`);
    },
    querySearch(queryString, cb) {
      var restaurants = this.restaurants;
      var results = queryString ? restaurants.filter(this.createFilter(queryString)) : restaurants;
      // 调用 callback 返回建议列表的数据
      cb(results);
    },
    createFilter(queryString) {
      return (restaurant) => {
        return (restaurant.value.toLowerCase().indexOf(queryString.toLowerCase()) === 0);
      };
    },
    loadAll() {
      return [
        {"value": "教研"},
        {"value": ""},
      ];
    },
    handleSelect(item) {
      console.log(item);
    },
    handleIconClick(ev) {
      console.log(ev);
    }
  },
  mounted() {
    this.restaurants = this.loadAll();
  }
}


</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
/* * {
  margin: 0;
  padding: 0;
} */
.my-autocomplete {
}

li {
  line-height: normal;
  padding: 7px;
}

.name {
  text-overflow: ellipsis;
  overflow: hidden;
}

.el-autocomplete[data-v-065c4f1a]{
  height: 32px;
  position: relative;
  display: inline-block;
  margin-left: 30px;
}

el-input--suffix .el-input__inner {
  padding-right: 30px;
  height: 35px;
}
.choose button[data-v-221be311] {
  height: 38px;
  width: 80px;
  background-color: #FFFFFF;
  border: 1px solid #CACBCC;
  margin-left: 22px;
  margin-right: -15px;
  border-radius: 5px;
}

.background {
  background-color: #EAF2FB;
  /*padding: 20px 30px;*/
}

.main {
  border-radius: 10px;
  width: 1200px;
  color: #3C85D7;
  margin: auto;
  padding: 30px 50px;
  background-color: #FDFDFD;
}

.title {
  font-size: 30px;
  font-weight: bold;
  margin-bottom: 10px;
}

.content {
  font-size: 20px;
  background-color: #FDFDFD;

}

.content div {
  margin-bottom: 10px;
  margin-left: 15px;
}

.upload {
  /*float:right;*/
  margin-top: 2px;
  width: 950px;
  height: 200px;
}

button[type="submit"] {
  background-color: #104A85;
  color: white;
  width: 100px;
  height: 30px;
  font-size: 16px;
  margin-left: 1000px;

}

.title {
  color: #113355;
}

span {
  color: #1A4D7F;
}

input {
  height: 40px;
  padding: 12px 20px;
  margin: 1px 30px;
  box-sizing: border-box;
  border: 1px solid #DCDFE6;
  /*border: 1px solid #CACBCC;*/
  outline: none;
  border-radius: 5px;
}

input:focus {
  border: 2px solid #3C85D7;
}

textarea[type="text"] {
  padding: 12px 20px;
  margin: 8px 30px;
  box-sizing: border-box;
  border: 1px solid #DCDFE6;
  /*border: 1px solid #CACBCC;*/
  outline: none;
  border-radius: 5px;
}

textarea[type="text"]:focus {
  border: 2px solid #3C85D7;
}

.choose button {
  height: 38px;
  width: 80px;
  background-color: #FFFFFF;
  border: 1px solid #CACBCC;
  margin-right: 10px;
  border-radius: 5px;
}

.choose button:hover {
  border: 1px solid #3C85D7;
}

.el-tag {
  background-color: #ecf5ff;
  border-color: #d9ecff;
  display: inline-block;
  height: 32px;
  padding: 0 10px;
  line-height: 30px;
  font-size: 12px;
  color: #409EFF;
  margin-left: 10px;
  border-width: 1px;
  border-style: solid;
  border-radius: 4px;
  -webkit-box-sizing: border-box;
  box-sizing: border-box;
  white-space: nowrap;
}

.el-tag + .el-tag {
  margin-left: 10px;
}

.button-new-tag {
  margin-left: 10px;
  height: 32px;
  line-height: 30px;
  padding-top: 0;
  padding-bottom: 0;
}

.input-new-tag {
  width: 90px;
  margin-left: 10px;
  vertical-align: bottom;
}

.resources {
  display: flex
}
</style>
