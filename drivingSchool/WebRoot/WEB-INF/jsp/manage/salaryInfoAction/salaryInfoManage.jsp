<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/TagLib.jsp"%>
  <body>
  	<!-- 收入项目管理 -->
	<div class="easyui-layout" data-options="fit:true" >
		<div class="center-filter clearfix" data-options="region:'north',border:false">
			<!-- 标题 -->
			<span class="table-title">人员工资记录</span>
			<button class="filter_button" type="button" onclick="editSalaryInfo()" >修改工资</button>
		</div>
		<div data-options="region:'center',border:false" >
		<!-- 表格 -->
		<table id="salaryInfoManage-Grid"></table>
		</div>
	</div>
	<div id="editSalaryInfoWindow"></div>
	
	<script type="text/javascript">
	$("#salaryInfoManage-Grid").datagrid({    
	    url:"${path }/mag/querySalaryInfoPage",
	    method:'post',
		autoRowHeight:true,
		fit:true,
		fitColumns:true,
		rownumbers:true,
		collapsible:true,
		singleSelect:true,
		pagination:true,
		method:"POST",
	    columns:[[    
	        {field:'id',checkbox:true,width:100},
	        {field:'name',title:'姓名',width:200,align:'center'},
	        {field:'salaryType',title:'角色身份',width:200,align:'center',formatter:salaryTypeFormatter},
	        {field:'cash',title:'薪金',width:80,align:'center'},
	        {field:'inuseTime',title:'薪金生效时间',width:80,align:'center'},
	        {field:'status',title:'状态',width:80,align:'center',formatter:statusFormatter},
	    ]]    
	});
	
	function salaryTypeFormatter(value, row, index){
		if(value=="1"){
			return "教练";
		}else{
			return "管理员";
		}
	}
	function statusFormatter(value, row, index){
		if(value=="1"){
			return "<span style='color: green;'>生效</span>";
		}else{
			return "<span style='color: red;'>失效</span>";
		}
	}
	function editSalaryInfo(){
		var selected =$("#salaryInfoManage-Grid").datagrid("getSelected");
		var url="${path}/mag/editSalaryInfo";
		if(selected!=null){
			url+="?infoType="+selected.salaryType;
			url+="&id="+selected.id;
		}
		$("#editSalaryInfoWindow").dialog('open').dialog('refresh',url);

	}
	$("#editSalaryInfoWindow").dialog({
		title:"人员工资信息编辑",
	    width:600,    
	    height:340,    
	    modal:true,
	    maximizable:false,
	    minimizable:false,
	    collapsible:false,
	    draggable:false,
	    resizable:false,
	    cache:false,
	    closed:true,
	    buttons: [
	    {
	    	text:"保存",
	    	handler:function(){
	    		$("#salaryInfo-Form").submit();
	        }
	    },{
	    	text:"关闭",
	    	handler:function(){
	    		$("#editSalaryInfoWindow").dialog("close");
	        }
	    }] 
	});
	</script>
  </body>
