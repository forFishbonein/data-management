<template>
  <div class="container">
    <div class="main">
      <div class="content">
        <table>
          <tr>
            <td class="template-title" colspan="3">
              自定义模板
            </td>
          </tr>
          <tr>
            <td class="page-prompt" colspan="3">
              本页面用于上传已给类别之外，暂无上传模板可用的资料。
              <br>
              其中资料名称与简介为必填的公共字段，用于识别该资料。
              <br>
              您可以添加自定义的字段并填充其信息，自定义字段的字数、个数不限。
            </td>
          </tr>
          <tr>
            <td class="label required">编号</td>
            <td>
              <el-input
                v-model="UserDefined.num"
                class="property"
                clearable
                placeholder="请输入项目编号">
              </el-input>
            </td>
          </tr>
          <tr>
            <td class="label required">项目名称</td>
            <td>
              <el-input
                v-model="UserDefined.title"
                class="property"
                clearable
                placeholder="请输入项目名称">
              </el-input>
            </td>
          </tr>
          <tr>
            <td class="label required">项目简介</td>
            <td colspan="2">
              <el-input
                v-model="UserDefined.introduction"
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
        <div class="prompt"></div>
        <div class="prompt-line"></div>
        <div class="prompt">以下为自定义字段</div>
        <table>

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
              温馨提示：自定义字段一旦添加无法更改或删除。
              <br>
              请谨慎填写。
            </td>
          </tr>

        </table>

        <table>
          <tr>
            <td class="label">
              <el-button size="small" type="primary" @click="submitUpload">提交</el-button>
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

export default {
  name: "Defined",
  components: {LoginFooter, TeacherNav},
  data() {
    return {
      UserDefined: {
        TEMPLATE_TYPE: "userdefined",
        id: "",
        title: "",
        num: "",
        introduction: "",

        other: [],
        filePath: [],
        createTime: "",
        uploaderId: this.$store.state.teacherId
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
      this.UserDefined.other.push(kv)
      console.log(this.UserDefined.other)
      var trHtml = `<td></td>
                    <td align="center">${this.UserDefined.other[this.UserDefined.other.length - 1].key}</td>
                    <td>:</td>
                    <td align="center">${this.UserDefined.other[this.UserDefined.other.length - 1].value}</td>`
      var tr = document.createElement('tr');
      tr.innerHTML = trHtml
      document.getElementById("change-table").appendChild(tr)
      this.m.key = ""
      this.m.value = ""
      console.log(this.m)
    },

    handleClose(tag) {
      this.UserDefined.member.splice(this.UserDefined.member.indexOf(tag), 1);
    },

    showInput() {
      this.inputVisible = true;
      this.$nextTick(_ => {
        this.$refs.saveTagInput.$refs.input.focus();
      });
    },
    mounted() {
      this.restaurants = this.loadAll();
    },
    handleInputConfirm() {
      let inputValue = this.inputValue;
      if (inputValue) {
        this.UserDefined.member.push(inputValue);
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
        {"value": "一般项目"},
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
      this.UserDefined.filePath.push(response.data.name)
      console.log(this.UserDefined)
      if (this.UserDefined.filePath.length < fileList.length) {
        return
      }
      insertTeacherFile(this.UserDefined).then(resp => {
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
        insertTeacherFile(this.UserDefined).then(resp => {
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
      var _this = this
      this.$store.dispatch('changeFlag',1)
      this.$store.dispatch('changePageFrom', path)
      console.log(this.$store.state.flag)
      console.log(this.$store.state.pageFrom)
      this.onSuccess = function (response, file, fileList){
        _this.UserDefined.filePath.push(response.data.name)
        if (_this.UserDefined.filePath.length < fileList.length) {
          return
        }
        updateTeacherFile(_this.UserDefined).then(resp => {
          const h = _this.$createElement;
          _this.$notify({
            title: '提示',
            message: h('i', { style: 'color: green'}, "更新成功")
          });
          console.log(resp.data)
          _this.$router.replace(_this.$store.state.pageFrom)
        });
      }
      this.submitUpload = function () {
        if (document.getElementsByClassName('el-upload-list__item')[0] == null) {
          console.log(_this)
          updateTeacherFile(_this.UserDefined).then(resp => {
            console.log(resp)
            const h = _this.$createElement;
            _this.$notify({
              title: '提示',
              message: h('i', { style: 'color: green'}, "更新成功")
            });
            _this.$router.replace(_this.$store.state.pageFrom)
            console.log(resp.data)
          });
        } else {
          _this.$refs.upload.submit();
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

          if(from.fullPath == "/manage/filemanage" || from.path == "/userDefined"){
            vm.UserDefined = vm.obj;
            vm.UserDefined.TEMPLATE_TYPE = vm.obj.template_TYPE;
            console.log(vm)
            console.log(from.fullPath)
            vm.changeMethod(from.fullPath)
          }
        }else{
          vm.$store.dispatch('changeFlag',0)
          // alert(vm.$store.state.pageFrom)
          if(vm.$store.state.pageFrom != ""){
            vm.$router.push(vm.$store.state.pageFrom)
          }
        }
      }
    ); // err 与 12134 是随便传的值， 可忽略
  },

  mounted() {
    this.restaurants = this.loadAll();

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

  .page-prompt {
    padding: 8px 0;
    padding-left: 115px;
    font-size: 14px;
    color: #949393;
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
  }

  .el-input {
    padding: 4px;
    width: 140px;
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


