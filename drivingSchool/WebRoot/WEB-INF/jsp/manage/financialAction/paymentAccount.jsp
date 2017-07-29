<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/JSLib.jsp"%>

<body >

	<!-- 发放工资日志 -->
	<div class="easyui-layout" data-options="fit:true" >
		<div class="center-filter clearfix" data-options="region:'north',border:false">
			<!-- 标题 -->
			<span class="table-title">收入项目列表</span>
			<button class="filter_button" type="button" onclick="addIncomeItem()" >新增</button>
			<button class="filter_button" type="button" onclick="delSelectIncomeItem()" >删除</button>
			
			<form id="financialLog_form" class="filter_form">
						<span style="">从</span>
						<input class="easyui-datebox" editable="false" name="beginDate"></input>
						<span>至</span>
						<input class="easyui-datebox" editable="false"  name="endDate"></input>
						
						<input class="search_button" type="button" id="doSearchBtn"/>
			</form>
		</div>
		<div data-options="region:'center',border:false" >
		<!-- 表格 -->
		<table id="financialLog-Grid"></table>
		</div>
	</div>
	<script type="text/javascript">
	$("#financialLog-Grid").datagrid({    
	    url:"${path}/mag/paymentAccountLogPage",
	    method:'post',
		autoRowHeight:true,
		fit:true,
		fitColumns:true,
		rownumbers:true,
		collapsible:true,
		pagination:true,
		method:"POST",
	    columns:[[    
	        {field:'id',checkbox:true,width:100},
	        {field:'operateName',title:'操作人',width:80,align:'center'},
	        {field:'type',title:'发放类型',width:80,align:'center',formatter:typeFormatter},
	        {field:'name',title:'领薪人',width:100,align:'center'},
	        {field:'salaryTime',title:'工资周期',width:100,align:'center'},
	        {field:'cash',title:'应发工资',width:100,align:'center'},
	        {field:'realCash',title:'实发工资',width:100,align:'center'},
	        {field:'payWay',title:'发放方式',width:100,align:'center',formatter:payWayFormatter},
	        {field:'payTime',title:'发放日期',width:100,align:'center'},
	        {field:'content',title:'备注',width:100,align:'center'},
	    ]]    
	});
	
	function typeFormatter(value, row, index){
		return value==1?"教练薪资":"管理员薪资";
	}
	function payWayFormatter(value, row, index){
		return value==1?"现金":"银行";
	}
	
	//搜索
	$("#doSearchBtn").click(function(){
		queryLog();
	});
	
	function queryLog(){
		var param = formToJson("#financialLog_form");
		$("#financialLog-Grid").datagrid({
			queryParams:param//发送服务器的数据
		});
		$("#financialLog_form").form("reset");
	}
	
	$("#financialLog_form").form({
		submit:function(){
			queryLog();
			return false;
		}
	});
	</script>
</body>
