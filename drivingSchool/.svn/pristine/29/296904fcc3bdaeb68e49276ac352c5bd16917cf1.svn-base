<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/TagLib.jsp"%>
  <body>
	<div id="infoStudent">
		<div id="info">
			<br/>
			<li class="form-item">
				<span class="title">学员姓名：</span>
				<span class="item">${record.name }</span>
			</li>
			<li class="form-item">
				<span class="title">身份证号：</span>
				<span class="item">${ record.licenceCode}</span>
			</li>
			<li class="form-item">
				<span class="title">学员卡号：</span>
				<span class="item">${record.stuCode }</span>
			</li>
			<li class="form-item">
				<span class="title">性别：</span>
				<span class="item">${record.sex?'男':'女' }</span>
			</li>
			<li class="form-item">
				<span class="title">学员帐号：</span>
				<span class="item">${record.username }</span>
			</li>
			<li class="form-item">
				<span class="title">邮箱：</span>
				<span class="item">${record.email }</span>
			</li>
			<li class="form-item">
				<span class="title">出生日期：</span>
				<span class="item">${record.birthday }</span>
			</li>
			<li class="form-item">
				<span class="title">报名日期：</span>
				<span class="item">${record.createDate }</span>
			</li>
			<li class="form-item">
				<span class="title">联系电话：</span>
				<span class="item">${record.phone }</span>
			</li>
			<li class="form-item">
				<span class="title">业务类型：</span>
				<span class="item">${ record.stuType==0?'初次申领':'增驾申领'}</span>
			</li>
			<li class="form-item">
				<span class="title">所属教员：</span>
				<span class="item">${record.coachName }</span>
			</li>
			<li class="form-item">
				<span class="title">住址：</span>
				<span class="item">${record.address }</span>
			</li>
			<li class="form-item">
					<span class="title">学习进度：</span>
					<span class="item">${record.lessonStep==1?"通过科目一":record.lessonStep==2?"通过科目二":record.lessonStep==3?"通过科目三":通过科目四}</span>
				</li>
		</div>
		<div id="head"><img src="${path }/${record.path}"/></div>
	</div>
	<script type="text/javascript">
	
	</script>
  </body>
