<template>
  <div class="container">
    <div class="main">
      <div class="content">
        <table>
          <tr>
            <td class="label">资源名称</td>
            <td>
              <el-input
                class="property"
                placeholder="请输入资源名称"
                v-model="Teaching.title"
                clearable>
              </el-input>
            </td>
          </tr>
          <tr>
            <td class="label">项目简介</td>
            <td>
              <el-input
                class="property"
                type="textarea"
                v-model="Teaching.introduction"
                :autosize="{ minRows: 2, maxRows: 4}"
              >
              </el-input>
            </td>
          </tr>
          <tr>
            <td class="label">项目来源</td>
            <td>
              <el-input
                class="property"
                placeholder="请输入项目来源"
                v-model="Teaching.source"
                clearable>
              </el-input>
            </td>
          </tr>
          <tr>
            <td class="label">项目类型</td>
            <td>
              <el-autocomplete
                class="property"
                v-model="Teaching.type"
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
            <td class="label">项目级别</td>
            <td>
              <el-input
                class="property"
                v-model="Teaching.level"
                placeholder="请输入项目级别"
                clearable>
              </el-input>
            </td>
          </tr>
          <tr>
            <td class="label">立项时间</td>
            <td>
              <el-date-picker
                class="property"
                v-model="Teaching.projectTime"
                type="date"
                placeholder="选择立项时间">
              </el-date-picker>
            </td>
          </tr>
          <tr>
            <td class="label">结项时间</td>
            <td>
              <el-date-picker
                v-model="Teaching.postprojectTime"
                class="property"
                type="date"
                placeholder="选择结项时间">
              </el-date-picker>
            </td>
          </tr>
          <tr>
            <td class="label">项目经费</td>
            <td>
              <el-input
                v-model="Teaching.fund"
                class="property"
                placeholder="请输入项目经费"
                clearable>
              </el-input>
            </td>
          </tr>
          <tr>
            <td class="label">课题组成员</td>
            <td>
              <el-tag
                v-model="Teaching.member"
                :key="tag"
                v-for="tag in Teaching.member"
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
                action="https://jsonplaceholder.typicode.com/posts/"
                :on-preview="handlePreview"
                :on-remove="handleRemove"
                :before-remove="beforeRemove"
                multiple
                :on-exceed="handleExceed"
                :file-list="this.Teaching.filePath">
                <el-button size="small" type="primary">点击上传</el-button>
              </el-upload>
            </td>
          </tr>



        </table>

          <div style="width:300px">
            <table id="change-table">
              <tr>
                <td>
                  <el-input
                    v-model="m.key"
                    clearable>
                  </el-input>
                </td>
                <td>
                  <el-input
                    v-model="m.value"
                    clearable>
                  </el-input>
                </td>
                <td style="align:'right'">
                  <el-button type="primary" plain @click="addInput()">主要按钮</el-button>
                </td>
              </tr>
            </table>
          </div>


         <div @click="dayin()">123456789</div>


      </div>
    </div>
  </div>

</template>

<script>
import TeacherNav from "../TeacherNav";

export default {
  name: 'TeachingUpload',
  components: {TeacherNav},
  data() {
    return {
      Teaching: {
        TEMPLATE_TYPE: "teaching",
        id: "",
        title: "",
        num: "",
        introduction: "",
        name: "",
        source: "",
        type: "",
        level: "",
        projectTime: "",
        postprojectTime: "",
        fund: "",
        member: [],
        other: []
          // "k1":"v1",
          // "k2":"v2",
        ,
        filePath: [],
        createTime: "",
      },

      otherKey: "请输入标签",
      otherValue: "请输入属性",

      inputVisible: false,
      inputValue: '',
      m:{
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
      console.log(this.Teaching)
    },
    Template(key , value){
      this.key = key;
      this.value = value
    },
    addInput(){
      // document.getElementById("change-table").style.display = "none"
      // var trHtml = '<td>' + '你好啊啊啊' + '</td>'

      // this.number.push(0);
      let kv = new this.Template(this.m.key , this.m.value);
      this.Teaching.other.push(kv)
      console.log(this.Teaching.other)
      var trHtml = `<td>${this.Teaching.other[this.Teaching.other.length-1].key}</td> <td>${this.Teaching.other[this.Teaching.other.length-1].value}</td>`
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
        {"value": "教研"},
      ];
    },
    handleSelect(item) {
    },
    handleIconClick(ev) {
    },
    handleRemove(file, filePath) {
      console.log(file, filePath);
    },
    handlePreview(file) {
      console.log(file);
    },
    handleExceed(files, filePath) {
      this.$message.warning(`当前限制选择 3 个文件，本次选择了 ${files.length} 个文件，共选择了 ${files.length + fileList.length} 个文件`);
    },
    beforeRemove(file, filePath) {
      return this.$confirm(`确定移除 ${ file.name }？`);
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
  background-color: white;

  table {

    .label {
      padding: 16px;
      width: 200px;
      text-align: right;
      font-size: 18px;

    }

    .property {
      width: 400px;
    }

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
