<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/TagLib.jsp"%>
  <body>
	<div id="infoCoach">
		<div id="info">
			<br/>
			<li class="form-item">
				<span class="title">学员姓名：</span>
				<span class="item">${record.name}</span>
			</li>
			<li class="form-item">
				<span class="title">教练证号：</span>
				<span class="item">${ record.coachCode}</span>
			</li>
			<li class="form-item">
				<span class="title">身份证件编号：</span>
				<span class="item">${record.licenceCode }</span>
			</li>
			<li class="form-item">
				<span class="title">证件类型：</span>
				<span class="item">${record.licenceType==1?'身份证':'驾驶证'}</span>
			</li>
			<li class="form-item">
				<span class="title">性别：</span>
				<span class="item">${record.sex==0?'女':'男' }</span>
			</li>
			<li class="form-item">
				<span class="title">生日：</span>
				<span class="item"><fmt:formatDate pattern="yyyy-MM-dd" value="${record.birthday}"/></span>
			</li>
			<li class="form-item">
				<span class="title">驾驶证档案编号：</span>
				<span class="item">${record.drivingLicenceCode}</span>
			</li>
			<li class="form-item">
				<span class="title">驾驶证准驾车型：</span>
				<span class="item">${record.allowCarType}</span>
			</li>
			<li class="form-item">
				<span class="title">驾驶证发证机关：</span>
				<span class="item">${record.licenceOrgan}</span>
			</li>
			<li class="form-item">
				<span class="title">车牌号：</span>
				<span class="item">${record.licenceNumber}</span>
			</li>
			<li class="form-item">
				<span class="title">教练证有效期止：</span>
				<span class="item"><fmt:formatDate value="${record.licenceLimitTime}" pattern="yyyy-MM-dd"/></span>
			</li>
			<li class="form-item">
				<span class="title">教练准驾车型范围：</span>
				<span class="item">${record.coachAllowCarType}</span>
			</li>
			<li class="form-item">
				<span class="title">联系地址：</span>
				<span class="item">${record.address}</span>
			</li>
			<li class="form-item">
				<span class="title">邮政编码：</span>
				<span class="item">${record.zipCode}</span>
			</li>
			<li class="form-item">
				<span class="title">联系电话：</span>
				<span class="item">${record.phone}</span>
			</li>
			<li class="form-item">
				<span class="title">教练员状态：</span>
				<span class="item">${record.status==1?'启用':'禁用'}</span>
			</li>
			<li class="form-item">
				<span class="title">教龄：</span>
				<span class="item">${record.coachAge}</span>
			</li>
			<li class="form-item">
				<span class="title">驾龄：</span>
				<span class="item">${record.drivingAge}</span>
			</li>
			<li class="form-item">
				<span class="title">所属分校：</span>
				<span class="item">${record.title}</span>
			</li>
			<li class="form-item">
				<span class="title">入职日期：</span>
				<span class="item"><fmt:formatDate value="${record.workDate}" pattern="yyyy-MM-dd"/></span>
			</li>
			<li class="form-item">
				<span class="title">资料录入日期：</span>
				<span class="item"><fmt:formatDate value="${record.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></span>
			</li>
			<li class="form-item">
				<span class="title">资料修改日期：</span>
				<span class="item"><fmt:formatDate value="${record.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/></span>
			</li>
			<li class="form-item">
				<span class="title" style="vertical-align: top;">教员简介：</span>
				<span class="item" style="width: 510px;height: 65px;">${record.content}</span>
			</li>
		</div>
		<div id="head"><img src="${path }/${record.path}"/></div>
	</div>
	<script type="text/javascript">
	
	</script>
  </body>
