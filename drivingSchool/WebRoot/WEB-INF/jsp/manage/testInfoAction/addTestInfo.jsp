<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/TagLib.jsp"%>
<body>
	<style type="text/css">
		#testInfo-Form .form-item{
			margin-top:25px;
		}
	</style>
	<form id="testInfo-Form" method="post" >
	<div style="margin:20px 0 0 20px;">
		
		<li class="form-item">
			<span class="title">选择学员：</span>
			<span class="item">
				<input id="stuId" name="stuId" type="text" style="margin:0;width: 400px;height:28px;">
			</span>
		</li>
		
		<li class="form-item">
			<span class="title">选择科目：</span>
			<span class="item">
				<select id="subject" name="subject" class="easyui-combobox" style="margin:0;width: 150px;height:28px;" data-options="panelHeight:'auto'">
					<option value="0" >请选择</option>
					<option value="1" >科目二</option>
					<option value="2" >科目三</option>
				</select>
			</span>
		</li>
	
		<li class="form-item">
			<span class="title" style="width:82px;">考试日期：</span>
			<span class="item">
				<input id="studyDate" class="easyui-datebox" name="studyDate" type="text" style="margin:0;width: 150px;height:28px;">
			</span>
		</li>
		
		<li class="form-item">
			<span class="title">联系电话：</span>
			<span class="item">
				<input id="stuPhone" name="stuPhone" class="easyui-validatebox" 
		data-options="required:true" type="text" style="margin:0;width: 400px;">
			</span>
		</li>
		
	</div>
	</form>
	<script type="text/javascript">
	$("#testInfo-Form").form({
		url:"${path}/mag/addTestInfoSubmit",
		onSubmit: function(){
			if(!$("#testInfo-Form").form("validate")){
				return false;
			}else{
				return true;
			}
	    },    
	    success:function(data){
	    	$("#testInfo-DataGrid").datagrid("reload");
	    	$.messager.alert("","添加成功");
	    	$("#editTestInfoWindow").dialog("close");
	    }
	});
	$("#testInfo-Form #stuId").combogrid({    
	    delay: 500,    
	    mode: 'remote',    
	    url: "${path}/mag/queryStudentsByKeyWord",    
	    idField: 'id',    
	    textField: 'name',
	    fitColumns:true,
	    autoRowHeight:true,
	    rownumbers:true,
	    required:true,
	    panelWidth:500,
	    columns: [[
			{field:'name',title:'姓名',width:80},
	        {field:'licenceCode',title:'身份证号',width:200},
	        {field:'title',title:'驾照',width:40},
	        {field:'phone',title:'电话',width:100}
	    ]]    
	});
	</script>
</body>
