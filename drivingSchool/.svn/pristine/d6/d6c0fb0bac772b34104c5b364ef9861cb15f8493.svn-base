<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/TagLib.jsp"%>

<body style="overflow:hidden;">
	<style>
		.form-item{margin:10px;}
	</style>
	<div id="header-user_center" class="easyui-layout" data-options="fit:true" >

		<div data-options="region:'center',border:false">
			<form id="user_center_form" class="" method="post">
				<input type="hidden" name="id" value="${userInfo.id}">
				
				<li class="form-item">
					<span class="title">姓名：</span>
					<span class="item">${userInfo.name}</span>
				</li>
				<br/>
				<li class="form-item">
					<span class="title">性别：</span>
					<span class="item">${userInfo.sex?'男':'女'}</span>
				</li><br/>
				<li class="form-item">
					<span class="title">出生日期：</span>
					<span class="item"><fmt:formatDate value="${userInfo.birthday }" pattern="yyyy-MM-dd"/></span>
				</li>
				<br/>
				<li class="form-item">
					<span class="title">联系电话:</span>
					<span class="item"><input name="phone" class="easyui-validatebox" value="${userInfo.phone }" type="text" style="border-radius:5px;width:330px;height:25px;"></span>
				</li>
				<br/>
				<li class="form-item">
					<span class="title">联系地址:</span>
					<span class="item"><input name="address" class="" type="text" value="${userInfo.address}" style="border-radius:5px;width:330px;height:25px;"></span>
				</li>
				<br/>
				<li class="form-item">
					<span class="title"></span>
					<span class="item">
						<a href="javascript:submitForm1();" disabled=true id="save-btn" class="easyui-linkButton">保  存</a>
						<input type="submit" style="display:none;"/>
					</span>
				</li>
				<br/>
				
			</form>
			
		</div>

	</div>
	
	<script type="text/javascript">
	
	function submitForm1(){
		$("#user_center_form").submit();
	}
	
	$("#user_center_form input").change(function(){
		$("#user_center_form #save-btn").linkbutton('enable');
	});
	
	
		$("#user_center_form").form({
			url : "${path}/mag/editMagInfoSubmit",
			onSubmit : function() {
				if($(this).form('validate')){
					$.messager.progress();
					return true;
				}
				return false;
			},
			success : function(data) {
				if(data == 0){
					ShowMessage("修改成功!");
					$("#user_center_form #save-btn").linkbutton('disable');
				}
				$.messager.progress("close");
			}
		});
	</script>
</body>
