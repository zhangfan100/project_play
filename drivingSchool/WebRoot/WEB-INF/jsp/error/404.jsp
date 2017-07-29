<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../TagLib/JSLib.jsp"%>
<html>
	<head>
		<title>404</title>
	</head>
	<body>
	<style type="text/css">
		#content{
			width: 600px;
			margin: auto;
			margin-top: 10%;
		}
		.p1,.p2{
			display: inline-block;
		}
		.p1{
		}
		.p2{
			margin-left: 76px;
		}
	</style>
	<div id="content" >
		<div class="p1"><img style="width:200px" src="${path }/static/img/p1.png"/></div>
		<div class="p2">
			<img style="width: 250px;" src="${path }/static/img/p2.png"/>
			<div class="desc" style="color:#4e4e4e;font-size:22px;">
				<br/>
				<br/>
				非常抱歉··· 您访问的页面不存在
			</div>
			<br/>
			<br/>
			<div style="text-align:right;"><a href="javascript:history.back(-1)">返回>></a></div>
		</div>
	</div>
  	
  </body>
</html>
