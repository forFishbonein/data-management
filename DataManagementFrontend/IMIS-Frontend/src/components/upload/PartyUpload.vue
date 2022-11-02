<template>
  <div class="container">
    <div class="main">
      <div class="content">
        <table>
          <tr>
            <td class="template-title" colspan="3">
              党支部模板
            </td>
          </tr>
          <tr>
            <td class="label required">编号</td>
            <td>
              <el-input
                v-model="Party.num"
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
                v-model="Party.title"
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
                v-model="Party.introduction"
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
            <td class="label">活动主题</td>
            <td>
              <el-input
                v-model="Party.topic"
                class="property"
                clearable
                placeholder="请输入活动主题">
              </el-input>
            </td>
          </tr>
          <tr>
            <td class="label">学习内容</td>
            <td>
              <el-input
                v-model="Party.content"
                :autosize="{ minRows: 6, maxRows: 8}"
                class="property"
                type="textarea"
              >
              </el-input>
            </td>
          </tr>
          <tr>
            <td class="label">活动类型</td>
            <td>
              <el-autocomplete
                v-model="Party.type"
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
            <td class="label">学习地点</td>
            <td>
              <el-input
                v-model="Party.address"
                class="property"
                clearable
                placeholder="请输入活动地点">
              </el-input>
            </td>
          </tr>
          <tr>
            <td class="label">时间</td>
            <td>
              <el-date-picker
                v-model="Party.time"
                class="property"
                placeholder="选择时间"
                type="date">
              </el-date-picker>
            </td>
          </tr>
          <tr>
            <td class="label">参与人</td>
            <td>
              <el-tag
                v-for="tag in Party.participant"
                :key="tag"
                v-model="Party.participant"
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
  name: 'PartyUpload',
  components: {LoginFooter, TeacherNav},
  data() {
    return {
      Party: {
        TEMPLATE_TYPE: "party",
        id: "",
        title: "",
        num: "",
        introduction: "",

        time: "",
        type: "",
        topic: "",
        content: "",
        address: "",
        participant: [],

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
      this.Party.other.push(kv)
      console.log(this.Party.other)
      var trHtml = `<td></td>
                    <td align="center">${this.Party.other[this.Party.other.length - 1].key}</td>
                    <td>:</td>
                    <td align="center">${this.Party.other[this.Party.other.length - 1].value}</td>`
      var tr = document.createElement('tr');
      tr.innerHTML = trHtml
      document.getElementById("change-table").appendChild(tr)
      this.m.key = ""
      this.m.value = ""
      console.log(this.m)
    },

    handleClose(tag) {
      this.Party.participant.splice(this.Party.participant.indexOf(tag), 1);
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
        this.Party.participant.push(inputValue);
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
        {"value": "主题党日"},
        {"value": "集体活动"},
        {"value": "书记讲党课"},
        {"value": "党员讲党课"}
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
      this.Party.filePath.push(response.data.name)
      console.log(this.Party)
      if (this.Party.filePath.length < fileList.length) {
        return
      }
      insertTeacherFile(this.Party).then(resp => {
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
        const h = this.$createElement;
        this.$notify({
          title: '提示',
          message: h('i', { style: 'color: green'}, resp.data)
        });
        console.log(resp.data)
        this.$router.push({path: "/profile"});
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
        _this.Party.filePath.push(response.data.name)
        if (_this.Party.filePath.length < fileList.length) {
          return
        }
        updateTeacherFile(_this.Party).then(resp => {
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
          updateTeacherFile(_this.Party).then(resp => {
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

          if(from.fullPath == "/manage/filemanage" || from.path == "/party"){
            vm.Party = vm.obj;
            vm.Party.TEMPLATE_TYPE = vm.obj.template_TYPE;
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
