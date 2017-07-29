<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/JSLib.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <title>${jx_chineseName }</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	<link href="${path }/static/front/css/bootstrap.min.css" rel="stylesheet">
	<link href="${path }/static/front/css/style.css" rel="stylesheet">
	<link href="${path }/static/front/css/common.css" rel="stylesheet">
	<link href="${path }/static/front/css/homepage.css" rel="stylesheet">
	<link href="${path }/static/front/css/jy_login.css" rel="stylesheet">
  <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
  <!--[if lt IE 9]>
    <script src="${path}/static/scripts/html5shiv.js"></script>
  <![endif]-->

  <!-- Fav and touch icons -->
  <link rel="Shortcut Icon" href="<c:if test='${not empty jxlogo}'>${path}${jxlogo}</c:if>" type="image/gif">
  
	<!-- 引入 Lightbox (压缩文件) -->
	<script type="text/javascript" src="${path }/static/scripts/scripts.js"></script>
</head>

<body id="maglogin">
	<div class="header" style="margin-top:0">
		<div class="row clearfix">
			<div class="col-md-3 column header_left" style="padding-top: 16px;">
				<img style="width:88px;height:88px;cursor:pointer;" src="<c:if test='${not empty jxlogo}'>${path}${jxlogo}</c:if>" onclick="javascript:window.location='${path}'">
				<div class="logo_letter" style="padding-top: 5px;">
				<span class="hanzi">${jx_chineseName }</span>
				<span class="pingyin">${jx_englishName }</span>
			</div>
			</div>
			<div class="column">
				<div class="r1 jy1">
					<p>管理员管理中心</p>
				</div>
			</div>
			<div class="col-md-3 column  header_right">
				
					
				
			</div>
		</div>
	</div>
	<div class="line"></div>
	<div class="main">
	<div class="main_content">
	
	 <div class="main_left">
	 <div class="items">
	 <div class="item"></div>
	 <div class="item"><img src="${path }/static/front/images/item1.png" style=" margin: -2px 0 0 -3px; "></div>
	 <div class="item"><p class="jyr2">规范教学</p></div>
	 <div class="item"><img src="${path }/static/front/images/item2.png" style=" margin:  -1px -2px; "></div>
	 <div class="item"><img src="${path }/static/front/images/item3.png" style=" margin: 0 -3px; "></div>
	 <div class="item"><p class="jyr2">科技创新</p></div>
	 <div class="item"><img src="${path }/static/front/images/item4.png" style=" margin: 0 -4px; "></div>
	 <div class="item"><p class="jyr2">求真务实</p></div>
	 </div>
	 </div> 
	<div class="login_table">
		<form id="loginForm" method="POST" action="xx">
		<div style="clear:both"></div>
		<div class="wrong" style="visibility:hidden;" id="errMsg">
			<img src="${path }/static/front/images/wrong.png">&nbsp;<span ></span>
		</div>
		<div class="form-group" >
		<label for="exampleInputEmail1" class="text">账&nbsp;&nbsp;户</label><input type="text" name="username" class="form-control" id="exampleInputEmail1" style="">
		</div>
		<div class="form-group" style="">
		<label for="exampleInputPassword1" class="text">密&nbsp;&nbsp;码</label><input type="password" name="password" class="form-control" id="exampleInputPassword1" style="">
		</div>
		<div class="form-group" style="">
		<label for="exampleInputPassword1" class="text">验证码</label><input type="text" class="form-control" name="vcode" id="exampleInputPassword1" style="width:40%;float:left;"><span style="float:right;width:35%;padding:0 10px;"><img onclick="refreshVCode(this)" id="vcodeImg" src="${path }/getVerificationCode"></span>
		</div>
		<div style="clear:both"></div>
		<div class="l_button"><a href="javascript:void(0);"><img onclick="submitLogin();" src="${path }/static/front/images/jydl_button.png"></a></div>
		
		</form>
	</div>
	</div>
	</div>

	<div class="foot">
		<div class="foot_content">
		<div class="col-md-12 column ">
			<div class="row clearfix">
						<div class="col-md-6 column">
							<!-- <ul class="footul">
								<li class="foot_li" ><a class=""  href="">个人中心</a></li>
								<li class="foot_gap">|</li>
								<li class="foot_li" ><a class=""  href="">我的课程</a></li>
								<li class="foot_gap">|</li>
								<li class="foot_li" ><a class=""  href="">帮助中心</a></li>
								<li class="foot_gap">|</li>
								<li class="foot_li" ><a class=""  href="">平台客服</a></li>
								
							</ul> -->
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
	<script type="text/javascript">
		var forwardFlag = 1;
		/* var teacherUrl = "${path}/coh/loginSubmit"; */
		var magUrl = "${path}/mag/loginSubmit";
		
		/* $("#optionsRadios3").click(function(){
			forwardFlag = 0;
		}); */
		
		$("#optionsRadios4").click(function(){
			forwardFlag = 1;
		});
	
		function submitLogin(){
			var formData = formToJson("#loginForm");
			if(formData.username.trim()=="" || formData.password.trim()==""){
				$("#errMsg").css("visibility","visible").children("span").html('请输入<span class="rw">用户名</span>或<span class="rw">密码</span>');
				refreshVCode("#vcodeImg");
				return false;
			}
			if(formData.vcode.trim()==""){
				$("#errMsg").css("visibility","visible").children("span").html('请输入<span class="rw">验证码</span>');
				refreshVCode("#vcodeImg");
				return false;
			}
			$.post(forwardFlag==0?teacherUrl:magUrl,formData,function(data){
				if(forwardFlag==0){
					if(data=='1'){
						window.location.href= "${path}/mag/magIndex";
					}else if(data=='2'){
						$("#errMsg").css("visibility","visible").children("span").html('输入的<span class="rw">验证码</span>错误');
						refreshVCode("#vcodeImg");
					}else{
						$("#errMsg").css("visibility","visible").children("span").html('<span class="rw">用户名</span>或<span class="rw">密码</span>错误');
						refreshVCode("#vcodeImg");
					}
				}else{
					switch(data*1){
						case 1 :$("#errMsg").css("visibility","visible").children("span").html('输入的<span class="rw">验证码</span>错误');refreshVCode("#vcodeImg");break;
						case 2 :$("#errMsg").css("visibility","visible").children("span").html('<span class="rw">用户名</span>或<span class="rw">密码</span>错误');refreshVCode("#vcodeImg");break;
						case 0 :window.location.href="${path}/mag/magIndex";
					}
				}
			});
		}
		
		$("#loginForm input").keyup(function(event){
			  if(event.keyCode ==13){
				  submitLogin();
			  }
		});
		
		//刷新验证码
		function refreshVCode(obj){
			$(obj).attr("src","${path }/getVerificationCode?_"+new Date().getTime());
		}
		$(function(){
			$("input[name='username']").focus();
		});
	</script>
</body>
</html>
