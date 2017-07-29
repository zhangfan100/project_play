<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/TagLib.jsp"%>
<body>
<div id="showTestDetail">
<style>	
#showTestDetail .detailTable td {
	text-align: center;
	font-size: 12px;
	height:10px;
	padding:10px
}
#showTestDetail .detailTable {
	border-collapse: collapse;
	margin:10px 30px;
	width:930px;
}
#showTestDetail .imgs >img{
	margin:10px 0px 10px 30px;
	width:100px;
	height:120px;
}
#showTestDetail .barCode{
	text-align: right;
	margin-right: 40;
}
#showTestDetail .barCode img{
	width: 200px;
	height: 40px;
}
#showTestDetail .title{
	clear:both;
	font-size: 32px;
	line-height: 45px;
	letter-spacing: 2px;
	font-family: '宋体';
	text-align: center;
}
</style>
<div><h2 class="title">XXXXX培训</h2></div>
<div class="barCode"><img src="${path }/getBarCode?code=510824199210207794&_<%=new Date().getTime()%>"/></div>
<table border="1" class="detailTable" >
<tr>
<td style="width: 150px;">姓名</td><td style="width: 250px;">${testDetail.stuName }</td>
<td style="width: 150px;">模拟代码</td><td style="width: 250px;">${testDetail.testCode }</td>
<td rowspan="4" style="width:120px;text-align:center;vertical-align: center;">
<c:if test="${stuPic ne null }">
<img src="${path }${stuPic}">
</c:if>
</td>
</tr>
<tr>
<td>身份证号码</td><td>${testDetail.stuCode }</td><td>驾照类型</td><td>${testDetail.title }</td>
</tr>
<tr>
<td>模拟驾校</td><td>${testDetail.schoolName }</td><td>业务类型</td><td>${testDetail.stuType }</td>
</tr>
<tr>
<td>考试日期</td><td>${testDetail.examDate }</td><td>预约次数</td><td>${testDetail.orderTimes }</td>
</tr>
<tr>
<td colspan="5">科目？考试</td>
</tr>
<tr>
<td>考试时间</td><td>${testDetail.examTime }</td>
<td>考试成绩</td><td colspan="2">${testDetail.examScore }</td>
</tr>
<tr>
<td>扣分项</td>
<td colspan="4" style="height:50px;text-align:left;vertical-align: top;">${testDetail.examMinusItem }</td>
</tr>
<tr>
<td>考试员签名</td><td></td>
<td>考生签名</td><td colspan="2"></td>
</tr>
<tr>
<td>考试视频照片（三张）</td>
<td colspan="4" style="text-align:left;" class="imgs">
<c:if test="${testDetail.pic1 ne '' }">
<img src="${path }${testDetail.pic1}">
</c:if>
<c:if test="${testDetail.pic2 ne '' }">
<img src="${path }${testDetail.pic2}">
</c:if>
<c:if test="${testDetail.pic3 ne '' }">
<img src="${path }${testDetail.pic3}">
</c:if>
</td>
</tr>
<tr>
<td colspan="5">科目？补考</td>
</tr>
<tr>
<td>考试时间</td><td>${testDetail.supExamTime }</td>
<td>考试成绩</td><td colspan="2">${testDetail.subExamScore }</td>
</tr>
<tr>
<td>扣分项</td>
<td colspan="4" style="height:50px;text-align:left;vertical-align: top;">${testDetail.supExamMinusItem }</td>
</tr>
<tr>
<td>考试员签名</td><td></td>
<td>考生签名</td><td colspan="2"></td>
</tr>
<tr>
<td>考试视频照片（三张）</td>
<td colspan="4" style="text-align:left;" class="imgs">
<c:if test="${testDetail.suppic1 ne '' }">
<img src="${path }${testDetail.pic1}">
</c:if>
<c:if test="${testDetail.suppic2 ne '' }">
<img src="${path }${testDetail.pic2}">
</c:if>
<c:if test="${testDetail.suppic3 ne '' }">
<img src="${path }${testDetail.pic3}">
</c:if>
</td>
</tr>
</table>
</div>
</body>