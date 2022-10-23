<template><div class="background">
    <div class="main">
      <div class="title">资料上传</div>
      <div class="content">
        <form >
            <div class="choose"><span>选择模板&emsp;</span>

                <button value="a1">科研项目</button>
                <button value="a2">教研报告</button>
                <button value="a3">各类荣誉</button>
                <button value="a4">成果类</button>
                <button value="a5">学生竞赛</button>
                <button value="a6">交流访问</button>
                <button value="a6">党支部</button>
                <button value="a6">教研室</button>
                <button value="a6">论文/期刊</button>
                <button value="a6">其他</button>

            </div>

            <div class="resources">
                <span>
资源名称&emsp;
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
                <input type="text" placeholder="请输入文字">
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
课题组成员
                </span>
                <div>
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
                </div>
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

            <button type="submit">立即上传</button>

        </form>
      </div>
    </div></div>
  </template>

  <script>
  export default {
    data() {
      return {
        dynamicTags: [],
        inputVisible: true,
        inputValue: '',
        fileList: []
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
      }
    }
  }

  </script>

  <!-- Add "scoped" attribute to limit CSS to this component only -->
  <style scoped>
  /* * {
    margin: 0;
    padding: 0;
  } */
  .background{
    background-color: #EAF2FB;
    padding: 20px 30px;
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
  }
  .content{
    font-size: 20px;
    background-color: #FDFDFD;
  }
  .content div{
    margin: 10px 5px;
  }
  .upload{
   width: 1100px;
    height: 200px;
  }
  button[type="submit"] {
    background-color: #2F51FF;
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
  </style>
