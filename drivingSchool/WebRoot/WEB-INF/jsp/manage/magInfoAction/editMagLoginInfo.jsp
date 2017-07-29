<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/TagLib.jsp"%>

<body style="overflow:hidden;">
	<style>
		.list-item{width:150px;text-align:right;display: inline-block;padding-right:25px;}
	</style>
	<div id="header-account_setting" class="easyui-layout" data-options="fit:true" >

		<div data-options="region:'center',border:false">
			
			<form id="account_setting_form" class="" method="post">
				&nbsp;&nbsp;
				<input type="hidden" name="id" value="${loginInfo.id}"><br/>
				
				<li class="form-item">
					<span class="title">账号：</span>
					<span class="item">${loginInfo.username}</span>
				</li><br/>
				<li class="form-item">
					<span class="title">旧密码：</span>
					<span class="item"><input name="formerPassword" class="easyui-validatebox" data-options="required:true" id="" class="" type="password" ></span>
				</li><br/>
				<li class="form-item">
					<span class="title">新密码：</span>
					<span class="item"><input name="newPassword" class="easyui-validatebox" data-options="required:true" id="newPassword" type="password"></span>
				</li><br/>
				<li class="form-item">
					<span class="title">确认密码：</span>
					<span class="item"><input name="confirmPassword" class="easyui-validatebox" data-options="required:true" id="confirmPassword" type="password" ></span>
				</li>
				<br/>
				<li class="form-item">
					<span class="title">验证码：</span>
					<span class="item">
						<input name="verfi_code" id="verfi_code" class="easyui-validatebox" data-options="required:true" class="" type="text">
					</span>
					<img id="vcodeImg" onclick="refreshVCode(this)" src="${path }/getVerificationCode" style="position:absolute;margin-top: -29px;margin-left: 270px;height: 28px;"/>
				</li><br/>
				<li class="form-item">
					<span class="title"></span>
					<span class="item">
						<a href="javascript:submitForm();" disabled=true id="save-btn" class="easyui-linkButton">保  存</a>
						<input type="submit" style="display:none;"/>
					</span>
				</li>
			</form>
			
		</div>

	</div>
	<script type="text/javascript">
		
		//刷新验证码
		function refreshVCode(obj){
			$(obj).attr("src","${path }/getVerificationCode?_"+new Date().getTime());
		}
		
		$("#account_setting_form input").change(function(){
			$("#account_setting_form #save-btn").linkbutton('enable');
		});
	
		function submitForm(){
			$("#account_setting_form").submit();
		}
		$("#account_setting_form").form({
			url : "${path}/mag/editMagPasswordSubmit",
			onSubmit : function() {
				if($(this).form('validate')){
					if ($("#newPassword").val() != $("#confirmPassword").val()) {
						ShowMessage("请核对新密码！");
						return false;
					}
					$.messager.progress();
					return true;
				}
				return false;
			},
			success : function(data) {
				switch(data*1){
					case 0 :ShowMessage("更改密码成功!");$("#account_setting_form #save-btn").linkbutton('disable');break;
					case 1 :ShowMessage("密码不匹配!");break;
					case 2 :ShowMessage("更新密码失败!");break;
					case 3 :ShowMessage("验证码错误!");break;
				}
				refreshVCode("#vcodeImg");
				$.messager.progress("close");
			}
		});
	</script>
</body>
