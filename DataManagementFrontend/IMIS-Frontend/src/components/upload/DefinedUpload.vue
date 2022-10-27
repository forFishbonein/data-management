<template>
  <div class="container">
    <div class="main">
      <div class="content">
        <table>

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
                :on-success="onSuccess"
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
      </div>
    </div>
  </div>

</template>

<script>
import TeacherNav from "../TeacherNav";

export default {
  name: "Defined",
  components: {TeacherNav},
  data() {
    return {
      UserDefined: {
        TEMPLATE_TYPE: "teaching",
        id: "",
        title: "",
        num: "",
        introduction: "",

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
    Template(key, value) {
      this.key = key;
      this.value = value
    },
    addInput() {
      let kv = new this.Template(this.m.key, this.m.value);
      this.Teaching.other.push(kv)
      console.log(this.Teaching.other)
      var trHtml = `<td></td>
                    <td align="center">${this.Teaching.other[this.Teaching.other.length - 1].key}</td>
                    <td>:</td>
                    <td align="center">${this.Teaching.other[this.Teaching.other.length - 1].value}</td>`
      var tr = document.createElement('tr');
      tr.innerHTML = trHtml
      document.getElementById("change-table").appendChild(tr)
      this.m.key = ""
      this.m.value = ""
      console.log(this.m)
    },

    handleClose(tag) {
      this.Teaching.member.splice(this.Teaching.member.indexOf(tag), 1);
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
        this.Teaching.member.push(inputValue);
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
    onSuccess(response, file, fileList) {
      this.Teaching.filePath.push(response.data.name)
    },
    submitUpload() {
      this.$refs.upload.submit();

      insertTeacherFile(this.Teaching).then(resp => {
        console.log(resp.data)

      });

    },
    handleExceed(files, fileList) {
      this.$message.warning(`当前限制选择 3 个文件，本次选择了 ${files.length} 个文件，共选择了 ${files.length + fileList.length} 个文件`);
    },
    beforeRemove(file, fileList) {
      return this.$confirm(`确定移除 ${file.name}？`);
    },
  }

}
</script>

<style scoped>
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

</style>
