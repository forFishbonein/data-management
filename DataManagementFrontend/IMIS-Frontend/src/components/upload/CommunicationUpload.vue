<template>
  <div class="container">
    <div class="main">
      <div class="content">
        <table>
          <tr>
            <td class="template-title" colspan="3">
              交流访问模板
            </td>
          </tr>
          <tr>
            <td class="label required">编号</td>
            <td>
              <el-input
                class="property"
                placeholder="请输入项目编号"
                v-model="Communication.id"
                clearable>
              </el-input>
            </td>
          </tr>
          <tr>
            <td class="label required">资源名称</td>
            <td>
              <el-input
                class="property"
                placeholder="请输入资源名称"
                v-model="Communication.title"
                clearable>
              </el-input>
            </td>
          </tr>
          <tr>
            <td class="label required">项目简介</td>
            <td>
              <el-input
                class="property"
                type="textarea"
                v-model="Communication.introduction"
                :autosize="{ minRows: 6, maxRows: 8}"
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
            <td class="label">活动名称</td>
            <td>
              <el-input
                class="property"
                placeholder="请输入活动名称"
                v-model="Communication.name"
                clearable>
              </el-input>
            </td>
          </tr>
          <tr>
            <td class="label">主办机构</td>
            <td>
              <el-input
                class="property"
                placeholder="请输入主办机构名称"
                v-model="Communication.organizer"
                clearable>
              </el-input>
            </td>
          </tr>
          <tr>
            <td class="label">交流类型</td>
            <td>
              <el-autocomplete
                class="property"
                v-model="Communication.type"
                :fetch-suggestions="querySearch"
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
            <td class="label">地点</td>
            <td>
              <el-input
                class="property"
                v-model="Communication.address"
                placeholder="请输入地点"
                clearable>
              </el-input>
            </td>
          </tr>
          <tr>
            <td class="label">起始时间</td>
            <td>
              <el-date-picker
                class="property"
                v-model="Communication.startTime"
                type="date"
                placeholder="选择起始时间">
              </el-date-picker>
            </td>
          </tr>
          <tr>
            <td class="label">终止时间</td>
            <td>
              <el-date-picker
                v-model="Communication.lastTime"
                class="property"
                type="date"
                placeholder="选择终止时间">
              </el-date-picker>
            </td>
          </tr>
          <tr>
            <td class="label">是否发言</td>
            <td>
              <el-input
                v-model="Communication.whetherSpeak"
                class="property"
                placeholder="请选择是否"
                clearable>
              </el-input>
            </td>
          </tr>
          <tr>
            <td class="label">学生是否参与</td>
            <td>
              <el-input
                v-model="Communication.whetherParticipate"
                class="property"
                placeholder="请选择是否"
                clearable>
              </el-input>
            </td>
          </tr>
          <tr>
            <td class="label">参会人员</td>
            <td>
              <el-tag
                v-model="Communication.member"
                :key="tag"
                v-for="tag in Communication.member"
                closable
                :disable-transitions="false"
                @close="handleClose(tag)">
                {{ tag }}
              </el-tag>
              <el-input
                class="input-new-tag"
                v-if="inputVisible"
                v-model="inputValue"
                ref="saveTagInput"
                size="small"
                @keyup.enter.native="handleInputConfirm"
                @blur="handleInputConfirm">
              </el-input>
              <el-button v-else class="button-new-tag" size="small" @click="showInput">+添加成员</el-button>
            </td>
          </tr>
          <tr>
            <td class="label">上传文件</td>
            <td>
              <el-upload
                class="upload-demo"
                ref="upload"
                action="http://localhost:8888/file/upload"
                :on-preview="handlePreview"
                :on-remove="handleRemove"
                :auto-upload="false"
                :before-remove="beforeRemove"
                multiple
                :on-exceed="handleExceed"
                :file-list="this.fileList">
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
              <el-button type="primary" size="small" @click="addInput()">添加</el-button>
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
              <el-button size="small" type="success" @click="submitUpload">提交</el-button>
            </td>

          </tr>
        </table>


        <div @click="dayin()">123456789</div>


      </div>
    </div>
  </div>

</template>

<script>
import TeacherNav from "../TeacherNav";

export default {
  name: 'CommunicationUpload',
  components: {TeacherNav},
  data() {
    return {
      Communication: {
        TEMPLATE_TYPE: "communication",
        id: "",
        title: "",
        num: "",
        introduction: "",

        startTime: "",
        lastTime: "",
        type: "",
        name: "",
        organizer: "",
        address: "",
        member: "",
        whetherSpeak: "",
        whetherParticipate: "",

        other: [],
        filePath: [],
        createTime: "",
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
    };

  },
  methods: {
    dayin() {
      console.log(this.Communication)
    },
    Template(key, value) {
      this.key = key;
      this.value = value
    },
    addInput() {
      let kv = new this.Template(this.m.key, this.m.value);
      this.Communication.other.push(kv)
      console.log(this.Communication.other)
      var trHtml = `<td></td>
                    <td align="center">${this.Communication.other[this.Communication.other.length - 1].key}</td>
                    <td>:</td>
                    <td align="center">${this.Communication.other[this.Communication.other.length - 1].value}</td>`
      var tr = document.createElement('tr');
      tr.innerHTML = trHtml
      document.getElementById("change-table").appendChild(tr)
      this.m.key = ""
      this.m.value = ""
      console.log(this.m)
    },

    handleClose(tag) {
      this.Communication.member.splice(this.Communication.member.indexOf(tag), 1);
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
        this.Communication.member.push(inputValue);
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
        {"value": "学术会议"},
        {"value": "师资教培"},
        {"value": "教学研讨"},
        {"value": "参观调研"}
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
    submitUpload() {
      this.$refs.upload.submit();
    },
    handleExceed(files, fileList) {
      this.$message.warning(`当前限制选择 3 个文件，本次选择了 ${files.length} 个文件，共选择了 ${files.length + fileList.length} 个文件`);
    },
    beforeRemove(file, fileList) {
      return this.$confirm(`确定移除 ${file.name}？`);
    }
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
