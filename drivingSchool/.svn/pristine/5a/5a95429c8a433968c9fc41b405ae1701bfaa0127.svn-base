<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/JSLib.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html >
<head>
<title>${jx_chineseName }后台管理系统</title>
<link rel="Shortcut Icon" href="${path}${logoPath}" type="image/gif">
<link href="${path }/static/css/admin/admin.css" rel="stylesheet">
<script type="text/javascript" src="${path }/static/scripts/admin.js"></script>
<script src="${path }/static/scripts/bootstrap.min.js" type="text/javascript"></script>
<script type="text/javascript" src="${path }/static/scripts/idCard.js"></script>
<script type="text/javascript" src="${path }/static/scripts/ajax-pushlet-client.js"></script>
 
  <style>
  	::-webkit-scrollbar {  
	  width: 0px;  
	  height: 0px;  
	} 
	.accordion-toggle img{
		margin-top:12px;
	}
	.menu_img{
		height: 29px;
		width: 29px;
		background-repeat: no-repeat;
	}
	.datagrid-cell-check{
		padding-top:4px;
	}
  </style>
</head>

<body id="body" class="easyui-layout" >
		<div data-options="region:'north'" id="admin_header">
			<img class="logo" style="width:50px;height:49px;cursor:pointer;" src="${path}${logoPath}" onclick="javascript:window.location='${path}'">
			<div id="header_name">
				<div id="header_name_han">${jx_chineseName }后台管理系统</div>
				<div id="header_name_pin">The backstage management system of ${jx_englishName }</div>
			</div>
			<div id="header-menu_group">
				<div class="header-menu" id="user_center" onclick="jumpPage('${path}/mag/editMagInfo')">
					<img style="height:23px;width:23px;margin-top:-5px;" src="${path }/static/img/admin/user_center.png">
					<div class="header-menu_font">个人中心</div>
				</div>
				<div class="header-menu" id="account_setting" onclick="jumpPage('${path}/mag/editMagPassword')">
					<img style="height:23px;width:17px;margin-top:-5px;" src="${path }/static/img/admin/account_setting.png">
					<span class="header-menu_font">用户设置</span>
				</div>
				<div class="header-menu" id="logout">
					<img style="height:28px;width:27px;margin-top:-5px;" src="${path }/static/img/admin/logout.png">
					<span class="header-menu_font">退出</span>
				</div>
			</div>
			<div style="clear:both;"></div>
		</div>
		
		
		<div data-options="region:'west',border:false" id="left" style="width:203px;box-shadow: inset 0 0px 5px rgba(0,0,0,.24);">
			<div id="cLeft" onselectstart="return false" class="no-select">
			<c:forEach items="${menu }" var="item" varStatus="status">
				<li class="${item.iconClass }">
					<span <c:if test="${not empty item.url }">url="${path }/${item.url }"</c:if> class="title">
						${item.title }
						<c:if test="${fn:length(item.childrens)>0 }"><span class="sub"></span></c:if>
					</span>
					<c:if test="${fn:length(item.childrens)>0 }">
						<ul>
							<c:forEach var="item1" items="${item.childrens }" varStatus="status1">
								<li class="item" <c:if test="${not empty item1.url }">url="${path }/${item1.url }"</c:if>>${item1.title }</li>
							</c:forEach>
						</ul>
					</c:if>
				</li>
			</c:forEach>
		</div>
		</div>
		
		<div data-options="region:'center',border:false" id="right" style="padding:20px 17px 0 23px;">
				
		</div>
		<div data-options="region:'south',border:false" style="height:37px;background-color:#dcdcd9;" >
			<div class="footer" style="clear:both;text-align:center">
				<span style="font-size: 14px; color:gray;line-height:37px;">
				© 2014-2020 四川慧莘科技有限公司 版权所有
				</span>
			</div>
		</div>
		
	<!-- template -->
	<div id="messageKindTemplate" style="display:none" class="accordion-inner"></div>
	<!-- 身份证读取控件 -->
	 <object classid="clsid:4B3CB088-9A00-4D24-87AA-F65C58531039" id="SynCardOcx1" codeBase="SynCardOcx.CAB#version=1,0,0,1" width="0" height="0" >
	</object>
</body>
<script type="text/javascript">
	$("#logout").click(function(){
		$.post("${path}/logout",function(){
			window.location = "${path}/mag/login";
		});
	});
</script>

</html>
