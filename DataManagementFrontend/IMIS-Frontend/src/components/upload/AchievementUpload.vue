<template>
  <div class="container">
    <div class="main">
      <div class="content">
        <table>
          <tr>
            <td class="template-title" colspan="3">
              成果项目模板
            </td>
          </tr>
          <tr>
            <td class="label required">编号</td>
            <td>
              <el-input
                v-model="Achievement.num"
                class="property"
                clearable
                placeholder="请输入项目编号">
              </el-input>
            </td>
          </tr>
          <tr>
            <td class="label required">资源名称</td>
            <td>
              <el-input
                v-model="Achievement.title"
                class="property"
                clearable
                placeholder="请输入资源名称">
              </el-input>
            </td>
          </tr>
          <tr>
            <td class="label required">项目简介</td>
            <td colspan="2">
              <el-input
                v-model="Achievement.introduction"
                :autosize="{ minRows: 6, maxRows: 8}"
                class="property"
                style="width: 500px"
                type="textarea"
              >
              </el-input>
            </td>
            <td class="required-prompt">!简介为必填信息</td>
          </tr>
        </table>
        <div class="prompt">以上内容用于区分不同项目，为必填字段</div>
        <div class="prompt-line"></div>
        <div class="prompt">以下为选填字段</div>
        <table>
          <tr>
            <td class="label">成果名称</td>
            <td>
              <el-input
                v-model="Achievement.name"
                class="property"
                clearable
                placeholder="请输入成果名称">
              </el-input>
            </td>
          </tr>
          <tr>
            <td class="label">作者</td>
            <td>
              <el-input
                v-model="Achievement.author"
                class="property"
                clearable
                placeholder="请输入作者姓名">
              </el-input>
            </td>
          </tr>
          <tr>
            <td class="label">出版社</td>
            <td>
              <el-input
                v-model="Achievement.press"
                class="property"
                clearable
                placeholder="请输入出版社名称">
              </el-input>
            </td>
          </tr>
          <tr>
            <td class="label">论文或专著</td>
            <td>
              <el-input
                v-model="Achievement.paper"
                class="property"
                clearable
                placeholder="请选择论文或专著">
              </el-input>
            </td>
          </tr>
          <tr>
            <td class="label">论文类型</td>
            <td>
              <el-autocomplete
                v-model="Achievement.type"
                :fetch-suggestions="querySearch"
                class="property"
                placeholder="请选择类型或直接输入"
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
            </td>
          </tr>
          <tr>
            <td class="label">期刊等级</td>
            <td>
              <el-input
                v-model="Achievement.journalGrade"
                class="property"
                clearable
                placeholder="请输入期刊级别">
              </el-input>
            </td>
          </tr>
          <tr>
            <td class="label">民大认定级别</td>
            <td>
              <el-input
                v-model="Achievement.schoolGrade"
                class="property"
                clearable
                placeholder="请输入认定级别">
              </el-input>
            </td>
          </tr>
          <tr>
            <td class="label">发表年</td>
            <td>
              <el-date-picker
                v-model="Achievement.publicYear"
                class="property"
                placeholder="选择发表年份"
                type="year">
              </el-date-picker>
            </td>
          </tr>
          <tr>
            <td class="label">出版时间/卷期号</td>
            <td>
              <el-date-picker
                v-model="Achievement.publicationTime"
                class="property"
                placeholder="选择出版时间"
                type="date">
              </el-date-picker>
            </td>
          </tr>
          <tr>
            <td class="label">作者排序</td>
            <td>
              <el-tag
                v-for="tag in Achievement.authorRank"
                :key="tag"
                v-model="Achievement.authorRank"
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
                @keyup.enter.native="handleInputConfirm">
              </el-input>
              <el-button v-else class="button-new-tag" size="small" @click="showInput">+添加成员</el-button>
            </td>
          </tr>
          <tr>
            <td class="label">上传文件</td>
            <td>
              <el-upload
                ref="upload"
                :auto-upload="false"
                :before-remove="beforeRemove"
                :file-list="this.fileList"
                :on-exceed="handleExceed"
                :on-preview="handlePreview"
                :on-remove="handleRemove"
                :on-success="onSuccess"
                action="http://localhost:8888/file/upload"
                class="upload-demo"
                multiple>
                <el-button size="small" type="primary">选择文件</el-button>
              </el-upload>
            </td>
          </tr>
        </table>
        <table id="change-table" class="other">
          <tr>
            <td class="label">自定义字段</td>
            <td>
              <el-input
                v-model="m.key"
                clearable
                placeholder="请输入key">
              </el-input>
            </td>
            <td>:</td>
            <td>
              <el-input
                v-model="m.value"
                clearable
                placeholder="请输入value">
              </el-input>
            </td>
            <td>
              <el-button size="small" type="primary" @click="addInput()">添加</el-button>
            </td>
            <td class="prompt2">
              此处可自定义需要的字段并输入其内容。
              <br>
              温馨提示：自定义字段一旦添加无法更改或删除
            </td>
          </tr>

        </table>

        <table>
          <tr>
            <td class="label">
              <el-button size="small" type="primary" id="insert" @click="submitUpload">提交</el-button>
            </td>

          </tr>
        </table>
      </div>
    </div>
    <LoginFooter></LoginFooter>
  </div>

</template>

<script>
import TeacherNav from "../TeacherNav";
import {insertTeacherFile, updateTeacherFile} from '@/api/file.js'
import LoginFooter from "../LoginFooter";
import Vue from "vue";

window.onbeforeunload = function (event) {
  window.location.href="/upload"
}

export default {
  name: 'AchievementUpload',
  components: {LoginFooter, TeacherNav},
  data() {
    return {
      Achievement: {
        TEMPLATE_TYPE: "achievement",
        num: "",
        id: "",
        title: "",
        introduction: "",

        name: "",
        author: "",
        publicYear: "",
        paper: "",
        type: "",
        press: "",
        journalGrade: "",
        schoolGrade: "",
        publicationTime: "",
        authorRank: [],

        other: [],
        filePath: [],
        createTime: "",
        uploaderId: this.$store.state.userId
      },

      fileList: [],

      inputVisible: false,
      inputValue: '',
      m: {
        key: "",
        value: "",
      },
      // key: "",
      // value: "",
      number: [0],
      pageFrom: ""

    };

  },
  props: ["obj"],
  methods: {
    Template(key, value) {
      this.key = key;
      this.value = value
    },
    addInput() {
      let kv = new this.Template(this.m.key, this.m.value);
      this.Achievement.other.push(kv)
      console.log(this.Achievement.other)
      var trHtml = `<td></td>
                    <td align="center">${this.Achievement.other[this.Achievement.other.length - 1].key}</td>
                    <td>:</td>
                    <td align="center">${this.Achievement.other[this.Achievement.other.length - 1].value}</td>`
      var tr = document.createElement('tr');
      tr.innerHTML = trHtml
      document.getElementById("change-table").appendChild(tr)
      this.m.key = ""
      this.m.value = ""
      console.log(this.m)
    },

    handleClose(tag) {
      this.Achievement.authorRank.splice(this.Achievement.authorRank.indexOf(tag), 1);
    },

    showInput() {
      this.inputVisible = true;
      this.$nextTick(_ => {
        this.$refs.saveTagInput.$refs.input.focus();
      });
    },

    handleInputConfirm() {
      let inputValue = this.inputValue;
      if (inputValue) {
        this.Achievement.authorRank.push(inputValue);
      }
      this.inputVisible = false;
      this.inputValue = '';
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
      ];
    },
    handleSelect(item) {
    },
    handleIconClick(ev) {
    },
    handleRemove(file, fileList) {
      console.log(file, fileList);
    },
    handlePreview(file) {
      console.log(file);
    },
    onSuccess:function (response, file, fileList) {
      // alert("trtrt")
      this.Achievement.filePath.push(response.data.name)
      console.log(this.Achievement)
      insertTeacherFile(this.Achievement).then(resp => {
        const h = this.$createElement;
        this.$notify({
          title: '提示',
          message: h('i', { style: 'color: green'}, resp.data)
        });
        console.log(resp.data)
        this.$router.push({path: "/profile"});
      });
    },
    submitUpload:function () {
      if (document.getElementsByClassName('el-upload-list__item')[0] == null) {
        insertTeacherFile(this.Achievement).then(resp => {
          const h = this.$createElement;
          this.$notify({
            title: '提示',
            message: h('i', { style: 'color: green'}, resp.data)
          });
          console.log(resp.data)
          this.$router.push({path: "/profile"});
        });
      } else {
        this.$refs.upload.submit();
      }
    },
    handleExceed(files, fileList) {
      this.$message.warning(`当前限制选择 3 个文件，本次选择了 ${files.length} 个文件，共选择了 ${files.length + fileList.length} 个文件`);
    },
    beforeRemove(file, fileList) {
      return this.$confirm(`确定移除 ${file.name}？`);
    },

  changeMethod(path){
    this.$store.dispatch('changeFlag',1)
    this.$store.dispatch('changePageFrom', path)
    console.log(this.$store.state.flag)
    console.log(this.$store.state.pageFrom)
    this.onSuccess = function (){
      this.StudentContest.filePath.push(response.data.name)
      console.log(this.Achievement)
      updateTeacherFile(this.Achievement).then(resp => {
        const h = this.Achievement;
        this.$notify({
          title: '提示',
          message: h('i', { style: 'color: green'}, resp.data)
        });
        console.log(resp.data)
        this.$router.replace(this.$store.state.pageFrom)
      });
    }
      this.submitUpload = function () {
        if (document.getElementsByClassName('el-upload-list__item')[0] == null) {
          updateTeacherFile(this.Achievement).then(resp => {
            const h = this.$createElement;
            this.$notify({
              title: '提示',
              message: h('i', { style: 'color: green'}, resp.data)
            });
            console.log(resp.data)
            this.$router.replace(this.$store.state.pageFrom)
          });
        } else {
          this.$refs.upload.submit();
        }
      }
    },
  },

  beforeRouteEnter (to, from, next) {
    // console.log("123123")
    console.log(to, from) // 可以拿到 from， 知道上一个路由是什么，从而进行判断
    //在next中写处理函数
    next(
      vm => {
        if(vm.$store.state.flag != 1){

          if(from.fullPath == "/manage/filemanage" || from.path == "/achievement"){

            console.log(vm)
            console.log(from.fullPath)
            vm.changeMethod(from.fullPath)
          }
        }else{
          vm.$store.dispatch('changeFlag',0)
          // alert(vm.$store.state.pageFrom)
          vm.$router.push(vm.$store.state.pageFrom)
          // vm.$router.push('/manage')
        }
      }
      // a = document.getElementById("insert");
      // a[0].style.display = "none"
      // a = document.getElementById("update");
      // a[0].style.display = "block"

      // }
    ); // err 与 12134 是随便传的值， 可忽略
  },
  // beforeRouteLeave(to, from){
  //   alert(3132131)
  //   console.log(to ,from)
  //   vm => {}
  //
  // },
  mounted() {
    // if (window.performance.navigation.type == 1) {
    //   console.log("页面被刷新")
    //   console.log(this.pageFrom)
    //   this.$router.push(this.pageFrom)
    // }
    this.restaurants = this.loadAll();
    this.Achievement = this.obj;
  }
}




</script>

<style lang="scss" scoped>

.container {

}

.main {
  margin: 0 auto;
  margin-top: 10px;
  width: 1200px;
  border-radius: 8px;
  background-color: #fdfdfd;
  background-image: url("../../../static/img/temple.svg");
  box-shadow: rgba(50, 50, 93, 0.25) 0px 6px 12px -2px, rgba(0, 0, 0, 0.3) 0px 3px 7px -3px;

  .template-title {
    padding: 16px;
    padding-left: 115px;
    font-size: 22px;
    font-weight: bold;
    color: #0E4687;

  }

  table {

    .label {
      padding: 16px;
      width: 200px;
      text-align: right;
      font-size: 18px;
      vertical-align: top;
    }


    .required {
      position: relative;
    }

    .required-prompt {
      padding-left: 8px;
      vertical-align: bottom;
      font-size: 12px;
      color: #BB501C;
    }

    .required::after {
      position: absolute;
      right: 5px;
      content: "*";
      color: #BB501C;
      display: inline-block;
      font-size: 20px;
    }

    .property {
      width: 400px;
    }
  }

  .other {

    .el-input {
      padding: 4px;
      width: 140px;
    }

  }

  .prompt {
    padding: 8px 0;
    padding-left: 115px;
    font-size: 12px;
    color: #949393;
  }

  .prompt2 {
    padding: 8px;
    font-size: 12px;
    color: #949393;
  }

  .prompt-line {
    display: block;
    margin-left: 115px;
    width: 970px;
    height: 2px;
    border-bottom: 2px dashed #949393;
  }
}

.el-tag + .el-tag {
  margin-left: 10px;
}

.button-new-tag {

  height: 32px;
  line-height: 30px;
  padding-top: 0;
  padding-bottom: 0;
}

.input-new-tag {
  width: 90px;

  vertical-align: bottom;
}


</style>
