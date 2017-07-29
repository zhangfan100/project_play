<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/TagLib.jsp"%>


<body style="overflow:hidden;">
	<style>
		.list-item{width:150px;text-align:right;display: inline-block;padding-right:25px;}
	</style>
	<div id="center-instrctor_profile_password" class="easyui-layout" data-options="fit:true" >

		<div data-options="region:'center',border:false" style="font-size:16px;">
			<span>密码修改</span>
			<form id="instrctor_profile_password_form" class="" method="post">
			<input type="hidden" name="id" value="${loginInfo.id}">
				<span class="list-item" style="margin-left:2px;">账号:</span>${loginInfo.username}
				<br/>
				<br/>
				<span class="list-item">旧密码:</span><input name="formerPassword" id=""   class="easyui-validatebox" data-options="required:true" type="password" placeholder="" style="border-radius:5px;width:320px;height:25px;">
				<br/>
				<br/>
				
				<span class="list-item">新密码:</span><input name="newPassword" id="newPassword"  class="easyui-validatebox" data-options="required:true" type="password" placeholder="" style="border-radius:5px;width:320px;height:25px;">
				<br/>
				<br/>
				<span class="list-item">确认密码:</span><input name="confirmPassword" id="confirmPassword" class="easyui-validatebox" data-options="required:true" type="password" placeholder="" style="border-radius:5px;width:320px;height:25px;">
				<br/>
				<br/>
				<span class="list-item">验证码:</span><input name="vCode" id=""  class="easyui-validatebox" data-options="required:true" type="text" placeholder="" style="border-radius:5px;width:220px;height:25px;">
				<img onclick="refreshVCode(this)" id="vcodeImg" src="${path }/getVerificationCode"/>
				<div style="margin:40px 0 0 120px;">
					<button id="instrctor_profile_password_button" class="" name="" type="button" value="" onclick='$("#instrctor_profile_password_form").submit();'>保  存</button>
				</div>
			</form>
			
		</div>

	</div>
	
<script type="text/javascript">
	
	//情空input的值 除开hidden的input
	function cancelInput(){
		$("input[type!='hidden']").val("");
	}
	
	$("#instrctor_profile_password_form input").keyup(function(event){
		  if(event.keyCode ==13){
			  $("#instrctor_profile_password_form").submit();
		  }
	});

	$("#instrctor_profile_password_form").form({
		url : "${path}/coh/editLogInfoSubmit",
		onSubmit : function() {
			if(!$(this).form('validate'))return false;
			
			if ($("#newPassword").val() != $("#confirmPassword").val()) {
				ShowMessage("请核对确认密码！");
				refreshVCode("#vcodeImg");
				return false;
			}
			return true;
		},
		success : function(data) {
			if (data == '1') {
				cancelInput();
				ShowMessage('密码修改成功!');
				$($(".accordion-inner")[0]).click();
			}else if(data=='2'){
				ShowMessage("验证码错误!");
				refreshVCode("#vcodeImg");
			}else if(data=='3'){       //说明修改的原密码和新密码一样
				ShowMessage("新密码与原密码相同","修改失败");
				refreshVCode("#vcodeImg");
			}else if(data=='0'){
				ShowMessage("密码不匹配!");
				refreshVCode("#vcodeImg");
			}
		}
	});
	//刷新验证码
	function refreshVCode(obj){
		$(obj).attr("src","${path }/getVerificationCode?_"+new Date().getTime());
	}
</script>
</body>
