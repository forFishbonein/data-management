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

<!--          <tr v-for="(key,value) in Teaching.other">{{ key }}-->
<!--            <td>-->
<!--              <el-input-->
<!--                v-model="key"-->
<!--                clearable>-->
<!--              </el-input>-->
<!--            </td>-->
<!--            <td>-->
<!--              <el-input-->
<!--                v-model="value"-->
<!--                clearable>-->
<!--              </el-input>-->
<!--            </td>-->
<!--          </tr>-->
          <tr>
            <td>
              <el-input
                v-model="otherKey"
                clearable>
              </el-input>
            </td>
            <td>
              <el-input
                v-model="otherValue"
                clearable>
              </el-input>
            </td>
          </tr>
          <tr>
            <td align="right">
              <el-button type="primary" plain @click="addInput()">主要按钮</el-button>
            </td>
            <td></td>
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

        other: {
          "k1":"v1",
          "k2":"v2",
        },

        filePath: "",
        createTime: "",
      },

      otherKey: "请输入标签",
      otherValue: "请输入属性",

      inputVisible: false,
      inputValue: ''
    };

  },
  methods: {
    dayin() {
      console.log(this.Teaching)
    },

    addInput(){
      var m = new Map();   //声明构造函数
      m.set(name , '张三');  //赋值
      this.Teaching.other


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

  .content {
    padding: 10px;
    border-radius: 8px;
    background-color: #fdfdfd;
    box-shadow: rgba(50, 50, 93, 0.25) 0px 6px 12px -2px, rgba(0, 0, 0, 0.3) 0px 3px 7px -3px;

  }

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
