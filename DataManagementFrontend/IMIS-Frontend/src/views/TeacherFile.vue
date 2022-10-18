<template>
<div class="container">
<div class="body">
<div class="title">项目名称</div>
<div class="detail">项目详细项目详细项目详细资料简介资料简介资料简介资料简介简介资料简介资料简介资料简介简介资料简介资料简介资料简介简介资料简介资料简介资料简介</div>
<div class="uploadSelect">
       上传者：xxx<p></p>
       上传时间：xxx<p></p>
       项目来源：xxx<p></p>
       项目类型：xxx<p></p>
       项目基本：xxx<p></p>
       立项时间：xxx<p></p>
       结项时间：xxx<p></p>
       项目经费：xxx<p></p>
       课题组成员：xxx xxx
</div>
  <div class="attachment">
  <div class="attachment1"><pre>    1&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;附件一名称&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;docx&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="../../static/img/img_1.png" alt="pic" id="img1">
    2&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;附件二名称&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;docx&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="../../static/img/img_1.png" alt="pic" id="img2">
    3&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;附件三名称&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;docx&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="../../static/img/img_1.png" alt="pic" id="img3"></pre></div>

    <div class="page-icon">
      <span class="page-disabled"><i></i>上一页</span>
      <span class="page-current">1</span>
      <a href="#">2</a>
      <a href="#">3</a>
      <a href="#">4</a>
      <a href="#">5</a>
      <a href="#">...</a>
      <a class="page-next" href="#">下一页<i></i></a>
    </div>


</div>
  <button class="edit">编辑</button>
  <button class="delete">删除</button>
</div>

</div>


</template>

<script>
export default {
  name: "TeacherFile"
}
</script>

<style scoped>
.container {
  width: 1440px;
  height: 1304px;
  margin-left: 50px;
  margin-top: 100px;
  padding-top: 15px;
  background-color: #EAF2FB;
  border-style: solid;
  border-color: black;
}
.body {
  width: 1200px;
  height: 1100px;
  margin-left: 120px;
  background-color: #FFFFFF;
  border-style: solid;
  border-color: black;
}
.title{
  font-size: 36px;
  padding-top: 28px;
  padding-left: 66px;
}
.detail{
  width: 1000px;
  height: 100px;
  margin-left: 70px;
  margin-top: 100px;
  text-align:center;
}
.uploadSelect{
  width: 1097px;
  height: 397px;
  margin-left: 70px;
  line-height: 50px;
}
.attachment{
  width: 1097px;
  height: 280px;
  line-height: 70px;
  margin-left:70px ;
  box-shadow:0px 0px 10px 5px #aaa;
}
.attachment1{
  width: 1097px;
  height: 25px;
  margin-top: 40px;
  margin-left: 70px;
  font-size: 15px;
}
#img1{
  width: 40px;
  height: 40px;
}
#img2{
  width: 40px;
  height: 40px;
}
#img3{
  width: 40px;
  height: 40px;
}
/*设置div样式的整体布局*/
.page-icon{
  margin:170px 40px 0 0;/*设置距离顶部20像素*/
  font-size:0;/*修复行内元素之间空隙间隔*/
  text-align:right; /*设置内容居中显示*/

}

/*设置共有的的样式布局，主要是进行代码优化，提高运行效率*/
.page-icon a,.page-disabled,.page-next{
  border:1px solid #ccc;
  border-radius:3px;
  padding:4px 10px 5px;
  font-size:14PX;/*修复行内元素之间空隙间隔*/
  margin-right:10px;
}

/*对 a 标签进行样式布局 */
.page-icon a{
  text-decoration:none;/*取消链接的下划线*/
  color:#005aa0;
}

.page-current{
  color:#ff6600;
  padding:4px 10px 5px;
  font-size:14PX;/*修复行内元素之间空隙间隔*/
}

.page-disabled{
  color:#ccc;
}

.page-next i,.page-disabled i{
  cursor:pointer;/*设置鼠标经过时的显示状态，这里设置的是显示状态为小手状态*/
  display:inline-block;/*设置显示的方式为行内块元素*/
  width:5px;
  height:9px;
  background-image:url(http://img.mukewang.com/547fdbc60001bab900880700.gif);/*获取图标的背景链接*/
}
.page-disabled i{
  background-position:-80px -608px;
  margin-right:3px;
}

.page-next i{
  background-position:-62px -608px;
  margin-left:3px;
}
.edit{
  left: 1074px;
  top: 1098px;
  width: 72px;
  height: 32px;
  background-color: #2F51FF;
  color:white ;
  size: 14px;
  opacity: 1;
  border-radius: 3px;
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
  align-items: center;
  padding: 5px 16px 5px 16px;
}
.delete{
  left: 1191px;
  top: 1098px;
  width: 72px;
  height: 32px;
  background-color: #ee9900;
  color:white ;
  size:14px;
  opacity: 1;
  border-radius: 3px;
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
  align-items: center;
  padding: 5px 16px 5px 16px;
}
</style>
