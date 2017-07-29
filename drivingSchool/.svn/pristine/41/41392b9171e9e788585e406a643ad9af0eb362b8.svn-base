<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/JSLib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<title>${jx_chineseName }</title>
<link rel="Shortcut Icon" href="<c:if test='${not empty jxlogo}'>${path}${jxlogo}</c:if>" type="image/gif">
<link href="${path }/static/front/css/bootstrap.min.css" rel="stylesheet">
<link href="${path }/static/front/css/style.css" rel="stylesheet">
<link href="${path }/static/front/css/commonLogin.css" rel="stylesheet">
<link href="${path }/static/front/css/homepage.css" rel="stylesheet">
<link href="${path }/static/front/css/login.css" rel="stylesheet">
<link href="${path}/static/front/css/common.css" rel="stylesheet"> 

<!-- 引入 Lightbox (压缩文件) -->
<script type="text/javascript"
	src="${path}/static/front/js/stuLoginHomepage.js"></script>
</head>
<style type="text/css">
.main{
	background:url("${path}/static/front/images/background1.png") no-repeat left 300px;
}
.main_content{
	background:url("${path}/static/front/images/background2.png") no-repeat left bottom;
}
</style>
<body>
	<div class="header">
		<div class="row clearfix">
			<div class="col-md-3 column header_left">
				<img style="width:88px;height:88px;cursor:pointer;" src="<c:if test='${not empty jxlogo}'>${path}${jxlogo}</c:if>" onclick="javascript:window.location='${path}'">
				<div class="logo_letter">
				<span class="hanzi">${jx_chineseName }</span>
				<span class="pingyin">${jx_englishName }</span>
				</div>
			</div>
			<div class="col-md-9 column  header_right" style="width:400px">
				<div class="contact_phone">
					<ul>
						<li class="apply_img"><img
							src="${path}/static/front/images/phone.png"></li>
						<li class="contact_call f12" style="margin-left:20px;margin-top: 27px;">报名热线1：${phone1 }（仅限固话拨打） <br>
							报名热线2：${phone2 }
						</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<div class="line"></div>
	<div class="main">
		<div class="main_content">
			<form id="stuLoginForm" method="post" style="float:right;margin-top:70px;">
			<div class="login_table">
				<div class="l_title">
					<span><img src="${path}/static/front/images/label.png"></span> <span
						class="mt">学生中心登陆</span>
				</div>
				<div class="form-group" >
					<label for="exampleInputEmail1" class="text">账&nbsp;&nbsp;户</label><input
						type="text" class="form-control" id="userName" name="username" style="">
				</div>
				<div class="form-group" style="">
					<label for="exampleInputPassword1" class="text">密&nbsp;&nbsp;码</label><input
						type="password" class="form-control" id="password" name="password"
						style="">
				</div>
				<div class="form-group" style="">
						<label for="exampleInputPassword1" class="text">验证码</label>
						<input type="text" class="form-control"id="vcode" name="vcode" style="width:40%;float:left;">
						<span style="float:right;width:35%;padding:0 10px;">
						<img onclick="refreshVCode(this)" id="vcodeImg" src="${path }/getVerificationCode"></span>
				</div>
				
				<div class="l_button">
					<a href="javascript:void(0)"><img onclick="stuLoginSubmit();" src="${path}/static/front/images/login_button.png"></a>
				</div>
				<div class="forget">
					<span class="mt1"><a href="${path}/stu/registerStu">注册账户</a></span><span class="mt2">
						<a href="#">忘记密码？</a>
					</span>
				</div>
				<div style="clear:both"></div>
				<div class="wrong" id="msgDiv" hidden="hidden">
				</div>
			</div>
			</form>
		</div>
	</div>
	<div class="foot">
		<div class="foot_content">
			<div class="col-md-12 column ">
				<div class="row clearfix">
					<div class="col-md-6 column">
						 <ul class="footul">
							<li class="foot_li"><a class="" href="${path}/stu/login">个人中心</a></li>
							<li class="foot_gap">|</li>
							<li class="foot_li"><a class="" href="">我的课程</a></li>
							<li class="foot_gap">|</li>
							<li class="foot_li"><a class="" href="">帮助中心</a></li>
							<li class="foot_gap">|</li>
							<li class="foot_li"><a class="" href="">平台客服</a></li>

						</ul> 
					</div>
					<div class="col-md-3 column">
						<p class="m3">${filings_code }</p>
					</div>
					<div class="col-md-3 column">
						<p class="m3">${ copyRight_years}</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

<script type="text/javascript">
	$(function(){
		$("#userName").focus();
	});
	

	var sign = "${param.sign}";
	//刷新验证码
	function refreshVCode(obj){
		$(obj).attr("src","${path }/getVerificationCode?_"+new Date().getTime());
	}
	$("#stuLoginForm").form({
		url : "${path}/stu/loginSubmit",
		onSubmit : function() {
			if (!$("#userName").val()) {
				$("#msgDiv").show();
				$("#msgDiv").html('<img src="${path}/static/front/images/wrong.png">&nbsp;&nbsp;请填写<span class="rw">用户名</span>');
				return false;
			}
			if (!$("#password").val()) {
				$("#msgDiv").show();
				$("#msgDiv").html('<img src="${path}/static/front/images/wrong.png">&nbsp;&nbsp;请填写<span class="rw">密码</span>');
				return false;
			}
			if (!$("#vcode").val()) {
				$("#msgDiv").show();
				$("#msgDiv").html('<img src="${path}/static/front/images/wrong.png">&nbsp;&nbsp;请填写<span class="rw">验证码</span>');
				return false;
			}
			return true;
		},
		success : function(data) {
			if (data == '1') {
				$("#msgDiv").show();
				$("#msgDiv").html('<img src="${path}/static/front/images/wrong.png"><span class="rw">&nbsp;&nbsp;验证码</span>错误');
				refreshVCode("#vcodeImg");
			} else if (data == '2') {
				$("#msgDiv").show();
				$("#msgDiv").html('<img src="${path}/static/front/images/wrong.png"><span class="rw">&nbsp;&nbsp;用户名</span>或<span class="rw">密码</span>错误');
				refreshVCode("#vcodeImg");
			}else {
				var url = "${path}/stu/stuIndex";
				if(sign!=""){
					url += "?sign="+sign;
				}
				window.location.href = url;
			}
		}
	});
	function stuLoginSubmit() {
		$("#stuLoginForm").submit();
	}
	
	$("#stuLoginForm input").keyup(function(event){
		  if(event.keyCode ==13){
			  stuLoginSubmit();
		  }
	});
</script>
</html>