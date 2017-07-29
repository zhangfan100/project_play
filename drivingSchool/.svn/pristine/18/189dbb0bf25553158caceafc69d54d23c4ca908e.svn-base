<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/TagLib.jsp"%>
<body>
	<form id="campuInfo-Form" method="post" >
	<div style="margin:40px 0 0 61px;">
	<input type="hidden" name="id" value="${campusInfo.id}" >
		<span>分校名称:</span>  
		<input id="title" name="title" class="easyui-validatebox" 
		data-options="required:true" value="${campusInfo.title}" type="text" style="margin:0;width: 200px;">
	</div>
	<div style="margin:40px 0 0 61px;">
		<span>分校地址:</span> 
		<input id="address" name="address" class="easyui-validatebox" 
		data-options="required:true" type="text" value="${campusInfo.address}"  style="margin:0;width: 200px;">
	</div>
	<div style="margin:40px 0 0 61px;">
		<span>分校代码:</span> 
		<input id="campusCode" name="campusCode" class="easyui-validatebox" 
		data-options="required:true" type="text" value="${campusInfo.campusCode}"  style="margin:0;width: 200px;">
	</div>
	<div style="margin:40px 0 0 61px;">
		<span>GPS地址:</span> 
		<input id="GPSAddress" name="GPSAddress" class="easyui-validatebox" 
		data-options="required:true" type="text" value="${campusInfo.GPSAddress}"  style="margin:0;width: 200px;">
	</div>
	<div style="margin:40px 0 0 61px;">
		<span>电&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;话:</span> 
		<input id="phone" name="phone" class="easyui-validatebox" 
		data-options="required:true" type="text" value="${campusInfo.phone}"  style="margin:0;width: 200px;">
	</div>
	</form>
	<script type="text/javascript">
	$("#campuInfo-Form").form({
		url:"${path}/mag/editCampusInfoSubmit",
		onSubmit: function(){
			if(!$("#campuInfo-Form").form("validate")){
				return false;
			}else{
				return true;
			}
	    },    
	    success:function(data){
	    	$("#system_setting_parasetting_dg").datagrid("reload");
	    	$.messager.confirm("","修改成功<br>是否退出编辑？",function(r){
				if(r){
					$("#edit_campusInfo_window").dialog("close");
				}
			});
	    }
	});
	</script>
</body>
