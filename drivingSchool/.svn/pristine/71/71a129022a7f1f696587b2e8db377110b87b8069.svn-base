<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/TagLib.jsp"%>
  <body>
	<div id="infoStudent">
		<div id="info">
		 <ul>
			<li class="form-item">
				<span class="title">学员姓名：</span>
				<span class="item">${record.stuName }</span>
			</li>
			<li class="form-item">
				<span class="title">身份证号：</span>
				<span class="item">${record.stuLicence}</span>
			</li>
			<li class="form-item">
				<span class="title">课程编号：</span>
				<span class="item">${record.lessonCode }</span>
			</li>
			<li class="form-item">
				<span class="title">科目：</span>
				<span class="item">${record.subject==1?"科目二":"科目三" }</span>
			</li>
			<li class="form-item">
				<span class="title">上课日期：</span>
				<span class="item">${fn:substring(record.beginTime,0,10)}</span>
			</li>
			<li class="form-item">
				<span class="title">上课时段：</span>
				<span class="item">${fn:substring(record.beginTime,11,16)}-${fn:substring(record.endTime,11,16)}</span>
			</li>
			<li class="form-item">
				<span class="title">预约方式：</span>
				<span class="item">${record.planWay==0?"网站预约":record.planWay==1?"手机预约":"管理员后台预约"}</span>
			</li>
			<li class="form-item">
				<span class="title">状态：</span>
				<span class="item">${record.lessonStatus==0?"未分配车辆":record.lessonStatus==1?"已分配车辆":record.lessonStatus==2?"培训完成":"培训异常"}</span>
			</li>
			<li class="form-item">
				<span class="title">联系电话：</span>
				<span class="item">${record.stuPhone }</span>
			</li>
			<li class="form-item">
				<span class="title">业务类型：</span>
				<span class="item">${record.stuType==0?"初次申领":"增驾申领"}</span>
			</li>
			<li class="form-item">
				<span class="title">所属教员：</span>
				<span class="item">${record.cohName }</span>
			</li>
			<li class="form-item">
				<span class="title">应缴金额：</span>
				<span class="item">${record.cash }</span>
			</li>
			<li class="form-item">
				<span class="title">实缴金额：</span>
				<span class="item">${record.realCash }</span>
			</li>
			<li class="form-item">
				<span class="title">收费人：</span>
				<span class="item">${record.name }</span>
			</li>
			<li class="form-item">
				<span class="title">缴费时间：</span>
				<span class="item">${fn:substring(record.payTime,0,16)}</span>
			</li>
			<br>
			<li class="form-item">
				<span class="title">缴费备注：</span>
				<span class="item">${record.cashContent }</span>
			</li>
		  </ul>
		</div>
	</div>
  </body>
