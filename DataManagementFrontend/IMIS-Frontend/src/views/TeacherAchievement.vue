<template>
  <div class="background">
    <TeacherNav/>
    <div class="main">
      <div class="title">各类荣誉</div>
      <div class="content">
        <form >
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
            </a>   <a href="">
              <button value="a6">党支部</button>
            </a>      <a href="">
              <button value="a6">教研室</button>
            </a>        <a href="">
              <button value="a6">论文/期刊</button>
            </a>          <a href="">
              <button value="a6">其他</button>
            </a>
          </div>

          <div class="resources">
                <span>
项目名称&emsp;
                </span>
            <input type="text" placeholder="请输入文字">
          </div>
          <div class="resources">
                <span>
项目简介&emsp;
                </span>
            <textarea type="text" style="width:450px ;height:125px;" placeholder="请输入文字"/>
          </div>
          <div class="resources">
                <span>
项目来源&emsp;
                </span>
            <input type="text" placeholder="请输入文字">
          </div>
          <div class="resources">
                <span>
项目类型&emsp;
                </span>
            <el-autocomplete
              popper-class="my-autocomplete"
              v-model="state"
              :fetch-suggestions="querySearch"
              placeholder="请输入文字"
              @select="handleSelect">
              <i
                class="el-icon-edit el-input__icon"
                slot="suffix"
                @click="handleIconClick">
              </i>
              <template slot-scope="{ item }">
                <div class="name">{{ item.value }}</div>
              </template>
            </el-autocomplete>
          </div>
          <div class="resources">
                <span>
项目级别&emsp;
                </span>
            <input type="text" placeholder="请输入文字">
          </div>
          <div class="resources">
                <span>
立项时间&emsp;
                </span>
            <input type="date" placeholder="请输入时间">
          </div>
          <div class="resources">
                <span>
结项时间&emsp;
                </span>
            <input type="date" placeholder="请输入时间">
          </div>
          <div class="resources">
                <span>
经&emsp;&emsp;费&emsp;
                </span>
            <input type="number" placeholder="请输入数字">
          </div>
          <div class="resources">
                <span>
成员
                </span>
            <!--                <div class="teammate">-->
            <el-tag
              :key="tag"
              v-for="tag in dynamicTags"
              closable
              :disable-transitions="false"
              @close="handleClose(tag)">
              {{tag}}
            </el-tag>
            <el-input
              class="input-new-tag"
              v-if="inputVisible"
              v-model="inputValue"
              ref="saveTagInput"
              size="small"
              @keyup.enter.native="handleInputConfirm"
              @blur="handleInputConfirm"
            >
            </el-input>
            <el-button v-else type="button" class="button-new-tag" size="small" @click="showInput">+ New Tag</el-button>
            <!--                </div>-->
          </div>
          <div class="resources">
                  <span>
附件上传
                  </span>
            <div class="upload">
              <el-upload
                class="upload-demo"
                action="https://jsonplaceholder.typicode.com/posts/"
                :on-preview="handlePreview"
                :on-remove="handleRemove"
                :before-remove="beforeRemove"
                multiple
                :limit="3"
                :on-exceed="handleExceed"
                :file-list="fileList">
                <el-button size="small" type="primary">点击选择</el-button>
              </el-upload>
            </div>
          </div>
          <span>

</span>
          <button type="submit">立即上传</button>

        </form>
      </div>
    </div></div>
</template>

<script>
import TeacherNav from "../components/TeacherNav";
export default {
  name: 'TeacherAchievement',
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
      return this.$confirm(`确定移除 ${ file.name }？`);
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
        { "value": "教研" },
        { "value": "" },
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

.el-autocomplete {
  height: 32px;
  position: relative;
  display: inline-block;
}

el-input--suffix .el-input__inner {
  padding-right: 30px;
  height:35px;
}

.background{
  background-color: #EAF2FB;
  /*padding: 20px 30px;*/
}
.main{
  border-radius: 10px;
  width: 1200px;
  color: #3C85D7;
  margin:auto;
  padding: 30px 50px;
  background-color: #FDFDFD;
}
.title{
  font-size: 30px;
  font-weight: bold;
  margin-bottom: 10px;
}
.content{
  font-size: 20px;
  background-color: #FDFDFD;

}
.content div{
  margin-bottom: 10px;
  margin-left: 15px;
}
.upload{
  /*float:right;*/
  margin-top: 2px;
  width: 950px;
  height: 200px;
}
button[type="submit"] {
  background-color: #104A85;
  color:white;
  width: 100px   ;
  height: 30px;
  font-size: 16px;
  margin-left: 1000px;

}
.title{
  color: #113355;
}
span{
  color: #1A4D7F;
}

input{
  height: 40px;
  padding: 12px 20px;
  margin: 1px 15px;
  box-sizing: border-box;
  border: 1px solid #DCDFE6;
  /*border: 1px solid #CACBCC;*/
  outline: none;
  border-radius: 5px;
}
input:focus {
  border: 2px solid #3C85D7;
}
textarea[type="text"]{
  padding: 12px 20px;
  margin: 8px 15px;
  box-sizing: border-box;
  border: 1px solid #DCDFE6;
  /*border: 1px solid #CACBCC;*/
  outline: none;
  border-radius: 5px;
}
textarea[type="text"]:focus {
  border: 2px solid #3C85D7;
}
.choose button{
  height: 38px;
  width: 80px;
  background-color: #FFFFFF;
  border: 1px solid #CACBCC;
  margin-right: 10px;
  border-radius: 5px;
}
.choose button:hover{
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
.resources{display: flex}
</style>
