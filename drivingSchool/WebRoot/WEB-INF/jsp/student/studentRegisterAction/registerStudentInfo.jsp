<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@include file="../../TagLib/JSLib.jsp"%>
<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author" content="">
	<title>${jx_chineseName }</title>
	<link href="${path }/static/front/css/bootstrap.min.css" rel="stylesheet">
	<link href="${path }/static/front/css/style.css" rel="stylesheet">
	<link href="${path }/static/front/css/common1.css" rel="stylesheet">
	<link href="${path }/static/front/css/homepage1.css" rel="stylesheet">
	<link href="${path }/static/front/css/register.css" rel="stylesheet">
	
	<link href="${path}/static/front/css/bootstrap-datetimepicker.css" rel="stylesheet" media="screen">
	

	<script type="text/javascript" src="${path}/static/front/js/jquery.min.js"></script>
	<script type="text/javascript"
		src="${path}/static/front/js/jquery.easyui.min.js"></script>
	<script type="text/javascript"
		src="${path}/static/front/js/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="${path }/static/front/js/bootstrap.min.js"></script>
	<!-- 引入 Lightbox (压缩文件) -->

	<script type="text/javascript" src="${path }/static/front/js/scripts.js"></script>
	<script type="text/javascript" src="${path }/static/front/js/homepage1.js"></script>
	<script type="text/javascript" src="${path }/static/scripts/hs_validate.js"></script>
	<script type="text/javascript" src="${path}/static/front/js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
	<script type="text/javascript" src="${path}/static/front/js/elective_online.js"></script>
	<%-- <link rel="Shortcut Icon" href="${path}${logoPath}" type="image/gif"> --%>
	<link rel="Shortcut Icon" href="<c:if test='${not empty jxlogo}'>${path}${logoPath}</c:if>" type="image/gif">
	</head>

<body>
	
	
	<div class="header">
		<div class="row clearfix">
			<div class="col-md-3 column header_left" style="width:800px;">
				<img style="width:88px;height:88px;cursor:pointer;" src="${path}${jxlogo}" onclick="javascript:window.location='${path}'">
				<div class="logo_letter" >
					<span class="hanzi">${jx_chineseName }</span> <span class="pingyin">${jx_englishName }</span>
				</div>
			</div>
			<div class="col-md-3 column header_left" style="display:none;">
				<div class="r1">
					<p>
						<a href="#">注册账号</a>
					</p>
				</div>
			</div>
			<div class="col-md-6 column  header_right">
				<div class="r2">
					<p>
						已有账号，请<span><a href="${path}/stu/login">登陆</a></span>
					</p>
				</div>

			</div>
		</div>
	</div>
	<div class="line"></div>
	<div class="main">
		<div class="main_content">
			<div class="register_table">
				<form id="registerStuSbmitInfo"  method="post">
				<input type="hidden" name="token" value="${token }">
				<div style="clear:both"></div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">用户名：</label>
						<div class="col-sm-7">
							<input type="text" class="form-control easyui-validatebox"
								id="shortName" name="username" />
						</div>
						<div class="col-sm-3" id="shortNameMsg"><p>例如:zhangsan</p></div>
					</div>
					<div style="clear:both"></div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">电子邮箱：</label>
						<div class="col-sm-7">
							<input type="email" class="form-control" id="email" name="email">
						</div>
						<div class="col-sm-3" id="emailMsg">
						<p>例如:yyyy@sina.com</p>
						</div>
					</div>
					<div style="clear:both"></div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">密码：</label>
						<div class="col-sm-7">
							<input type="password" class="form-control easyui-validatebox"
								id="schoolId" name="password" onblur="isPassword(this.value)"/>
						</div>
						<div class="col-sm-3" id="passMsg"><p>亲！牢记密码</p></div>
					</div>
					<div style="clear:both"></div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">确认密码：</label>
						<div class="col-sm-7">
							<input type="password" class="form-control easyui-validatebox"
								id="r_password"  onblur="isrPassword(this.value)"/>
						</div>
						<div class="col-sm-3" id="rpassMsg"></div>
					</div>
				<div style="clear:both"></div>
					<div class="form-group">
						<label for="inputEmail3" class="col-sm-2 control-label">真实姓名：</label>
						<div class="col-sm-7">
							<input type="text" class="form-control easyui-validatebox"
								id="stuName" onblur="isString(this.value)" name="name"  />
						</div>
						</div>
						<div class="col-sm-3" id="stuNameMsg">
						<p>例如:张三</p>
					</div>
					<div style="clear:both"></div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">身份证号：</label>
						<div class="col-sm-7">
							<input type="text" class="form-control easyui-validatebox"
								id="code" name="licenceCode" />
						</div>
						<div class="col-sm-3" id="idcardNoMsg">
						</div>
					</div>

					<div style="clear:both"></div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">性别：</label>
						<div class="col-sm-7">
						<select name="sex" class="form-control easyui-validatebox" id="sex" >
							<option value="1">男</option>
							<option value="0">女</option>
						</select>
						</div>
						<div class="col-sm-3"></div>
					</div>

					<div style="clear:both"></div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">出生日期：</label>
						<div class="col-sm-7">
							<input type="text" class="form-control form_datetime order_time" style="background-color: #ffffff;"  readonly name="birthday">
						</div>
						<div class="col-sm-3" id="birthdayMsg">
						<p>选填</p>
						</div>
						</div>
					<div style="clear:both"></div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">电话：</label>
						<div class="col-sm-7">
							<input type="text" class="form-control easyui-validatebox"
								id="phone" name="phone" onblur="isInteger(this.value)" />
						</div>
						<div class="col-sm-3" id="phoneMsg">
						<p>例如:135****5864</p>
						</div>
					</div>
					<div style="clear:both"></div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">住址：</label>
						<div class="col-sm-7">
							<input type="text" class="form-control easyui-validatebox"
								id="address" name="address" onblur="isAddress(this.value)" />
						</div>
						<div class="col-sm-3" id="addressMsg"><p>选填</p></div>
					</div>
					<div style="clear:both"></div>
				</form>
			</div>
		</div>
	</div>
	<div class="button">
	
		<div class="button_image">
			<h1 style="padding:20px;">
				<a href="javascript:void(0);" onclick="registerStuSbmit()"><img src="${path }/static/front/images/register_button.png"></a>
			</h1>
		</div>
	</div>

	<div class="foot">
		<div class="foot_content">
			<div class="col-md-12 column ">
				<div class="row clearfix">
					<div class="col-md-6 column">
						<ul class="footul">
							<li class="foot_li"><a class="" href="">个人中心</a></li>
							<li class="foot_gap">|</li>
							<li class="foot_li"><a class="" href="">我的课程</a></li>
							<li class="foot_gap">|</li>
							<li class="foot_li"><a class="" href="">帮助中心</a></li>
							<li class="foot_gap">|</li>
							<li class="foot_li"><a class="" href="">平台客服</a></li>

						</ul>
					</div>
					<div class="col-md-3 column">
						<p class="m3">备案编号：11010050100</p>
					</div>
					<div class="col-md-3 column">
						<p class="m3">Copyright @ 2006-2014</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
	var valid = false;
	 //真实姓名
	 function isString(obj){   
        reg=/^[\u2E80-\u9FFF]{2,8}$/; 
       if(reg.test(obj)){   
    	   $("#stuNameMsg").html('<img src="${path }/static/front/images/right1.png">');
			valid = true; 
           
       }else{   
        $("#stuNameMsg").html('<img src="${path }/static/front/images/wrong.png">&nbsp;<span style="font-size:10pt;color:red">至少输入2个字符真实姓名</span>');   
        valid = false;
        /*  $("#stuName").focus();  */
        }   
    }   
	 
	//真实住址
	 /* function isAddress(obj){   
        reg=/^[\u2E80-\u9FFF]+$/; 
       if(reg.test(obj)){   
    	   $("#addressMsg").html('<img src="${path }/static/front/images/right1.png">');
			valid = true; 
           
       }else{   
        $("#addressMsg").html('<img src="${path }/static/front/images/wrong.png">&nbsp;<span style="font-size:10pt;color:red">必须输入真实地址</span>');   
        valid = false;
        }   
    }   
	 */
	//密码
	 function isPassword(obj){   
		 reg=/^[a-z0-9_-]{6,18}$/; 
       if(reg.test(obj)){   
    	   $("#passMsg").html('<img src="${path }/static/front/images/right1.png">');
			valid = true; 
           
       }else{   
        $("#passMsg").html('<img src="${path }/static/front/images/wrong.png">&nbsp;<span style="font-size:10pt;color:red">6-18位英文字母+数字</span>');   
        valid = false;
           /* $("#schoolId").focus();  */
         }   
    }   
	//确认密码验证
	$("#r_password").blur(function() {
	$("#rpassMsg").html();
	var passwd = $("#schoolId").val();
	var passwd2 = $("#r_password").val();
		if($("#r_password").val()!=undefined || $.trim($("#r_password").val())!=''){
				if (passwd == passwd2) {
				 	$("#rpassMsg").html('<img src="${path }/static/front/images/right1.png">');
					valid = true; 
					} else {
					$("#rpassMsg").html('<img src="${path }/static/front/images/wrong.png">&nbsp;<span style="font-size:10pt;color:red">两次密码输入不一致</span>');
					valid = false;
					   $("#r_password").focus();   
					 return false; 
					}
	    }else{
	    	$("#rpassMsg").html('<img src="${path }/static/front/images/wrong.png">&nbsp;<span style="font-size:10pt;color:red">请输入密码</span>');
			valid = false;
	    }
		}); 
			//手机号码验证规则
	function isInteger(obj){   
	 isMobile=/^(?:13\d|15\d|18\d)\d{5}(\d{3}|\*{3})$/; //手机号码验证规则
	 isPhone=/^((0\d{2,3})-)?(\d{7,8})(-(\d{3,}))?$/;   //座机验证规则
		var phone = $("#phone").val();                   //获得用户填写的号码值 赋值给变量
		if(!isMobile.test(phone) && !isPhone.test(phone)){ //如果用户输入的值不同时满足手机号和座机号的正则
		  $("#phoneMsg").html('<img src="${path }/static/front/images/wrong.png">&nbsp;<span style="font-size:10pt;color:red">请正确填写电话号码</span>');   
		    valid = false;
			 /*  $("#phone").focus();   */     //输入框获得光标
			 return false;         //返回一个错误，不向下执行
	    }else{   
		  $("#phoneMsg").html('<img src="${path }/static/front/images/right1.png">');
			valid = true; 
			  }
		    }   
		
	$(function() {
		//身份证号码验证
		$("#code").blur(
		function() {
			$("#idcardNoMsg").html();
			if ($validate.validateIdcard($("#code").val())) {
			$.ajax({
				type : 'post',
				url : "${path}/stu/validateCode",
				data : {
				"licenceCode" : $("#code").val()
						},
				dataType : "json",
				success : function(data) {
			if (data == 0) {
				$("#idcardNoMsg").html('<img src="${path }/static/front/images/right1.png">');
				valid = true;
			} else {
				$("#idcardNoMsg").html('<img src="${path }/static/front/images/wrong.png">&nbsp;<span style="font-size:10pt;color:red">身份证号码已存在</span>');
				valid = false;
				  /* $("#code").focus();  */
				}
				}
				});
			} else {
				$("#idcardNoMsg").html('<img src="${path }/static/front/images/wrong.png"><span style="font-size:10pt;color:red">&nbsp;请输入正确的身份证号码</span>');
				valid = false;
			/*  $("#code").focus();  */
				}

		});
			 //用户名验证
			$("#shortName").blur(function() {
				$("#shortNameMsg").html();
				var reg= /^[a-z0-9_-]{3,10}$/;
				var name = $("#shortName").val();
				if(!reg.test(name)){
					$("#shortNameMsg").html('<img src="${path }/static/front/images/wrong.png">&nbsp;<span style="font-size:10pt;color:red">用户名3-10英文字母</span>');
					valid = false;
					return false;
				}else{
			       $.ajax({
					type : 'post',
					url : "${path}/stu/validateUserName",
					data : {"username" : $("#shortName").val()
							},
					dataType : "json",
					success : function(data) {
					if (data == 1) {
					   $("#shortNameMsg").html('<img src="${path }/static/front/images/wrong.png"><span style="font-size:10pt;color:red">用户名已存在</span>');
						valid = false;
					} else {
					$("#shortNameMsg").html('<img src="${path }/static/front/images/right1.png">');
					valid = true;
					        }
					      }
					   });
					  }
					});
						
			//邮箱验证
			$("#email").blur(function() {
			$("#emailMsg").html();
				if ($validate.emailCheck($("#email").val())) {
				$.ajax({
					type : 'post',
					url : '${path}/stu/validateEmail',
					data : {
					email : $("#email").val()
							},
					dataType : 'json',
					success : function(data) {
					if (data != 0) {
				    $("#emailMsg").html('<span style="font-size:10pt;color:red">邮箱已存在</span>');
					valid = false;
					/*  $("#email").focus(); */
					} else {
					$("#emailMsg").html('<img src="${path }/static/front/images/right1.png">');
					valid = true;
							}
											}
					  });
				} else {
					$("#emailMsg").html('<img src="${path }/static/front/images/wrong.png"><span style="font-size:10pt;color:red">邮箱格式不对</span>');
					valid = false;
					/*  $("#email").focus(); */
						}
				});
		     }); 
		$("#registerStuSbmitInfo").form({
			 type: "post",
			dataType: "json", 
			url : "${path}/stu/registerStuSbmitInfo",
			  onSubmit : function() {
				  if (!$("#shortName").val()) {
						$("#shortNameMsg").show();
						$("#shortNameMsg").html('<img src="${path}/static/front/images/wrong.png">&nbsp;&nbsp;请输入<span style="font-size:10pt;color:red">用户名</span>');
						return false;
					}
				  if (!$("#email").val()) {
						$("#emailMsg").show();
						$("#emailMsg").html('<img src="${path}/static/front/images/wrong.png">&nbsp;&nbsp;请输入<span style="font-size:10pt;color:red">邮箱</span>');
						return false;
					}
					
					if (!$("#schoolId").val()) {
						$("#passMsg").show();
						$("#passMsg").html('<img src="${path}/static/front/images/wrong.png">&nbsp;&nbsp;请输入<span style="font-size:10pt;color:red">密码</span>');
						return false;
					}
					
					if (!$("#r_password").val()) {
						$("#rpassMsg").show();
						$("#rpassMsg").html('<img src="${path}/static/front/images/wrong.png">&nbsp;&nbsp;请输入<span style="font-size:10pt;color:red">确认密码</span>');
						return false;
					}
				    if (!$("#stuName").val()) {
						$("#stuNameMsg").show();
						$("#stuNameMsg").html('<img src="${path}/static/front/images/wrong.png">&nbsp;&nbsp;请输入<span style="font-size:10pt;color:red">真实姓名</span>');
						return false;
					}
					if (!$("#code").val()) {
						$("#idcardNoMsg").show();
						$("#idcardNoMsg").html('<img src="${path}/static/front/images/wrong.png">&nbsp;&nbsp;请输入<span style="font-size:10pt;color:red">身份证号</span>');
						return false;
					}
					/* if (!$("#birthday").val()) {
						$("#birthdayMsg").show();
						$("#birthdayMsg").html('<img src="${path}/static/front/images/wrong.png">&nbsp;&nbsp;请输入<span style="font-size:10pt;color:red">出生日期</span>');
						return false;
					} */
					if (!$("#phone").val()) {
						$("#phoneMsg").show();
						$("#phoneMsg").html('<img src="${path}/static/front/images/wrong.png">&nbsp;&nbsp;请输入<span style="font-size:10pt;color:red">电话号码</span>');
						return false;
					}
					
					/* if (!$("#address").val()) {
						$("#addressMsg").show();
						$("#addressMsg").html('<img src="${path}/static/front/images/wrong.png">&nbsp;&nbsp;请输入<span style="font-size:10pt;color:red">住址</span>');
						return false;
					} */
					return true;
				},
			success : function(data) {
				if (data == 1) {
					alert('注册成功!')
					window.location.href = "${path}/stu/login";
				} else {
					alert('注册失败!');
				}
			}
		});
		
		function registerStuSbmit() {
			$("#registerStuSbmitInfo").submit();
		}
		
		$("#registerStuSbmitInfo").submit(function(){
			return false;
		});
	</script>
	
	<script type="text/javascript" language=JavaScript charset="UTF-8">
      document.onkeydown=function(event){
            var e = event || window.event || arguments.callee.caller.arguments[0];
             if(e && e.keyCode==13){ // enter 键
            	 registerStuSbmit();
            }
        }; 
</script>
<script type="text/javascript">
	
	
		/* 日历插件 */
		$(".form_datetime").datetimepicker({
			weekStart : 1,
			todayBtn : 1,
			autoclose : 1,
			todayHighlight : 1,
			startView : 2,
			minView : 'month',
			format : "yyyy-mm-dd",
			forceParse : 0
		});
		
	</script>
</body>
</html>


