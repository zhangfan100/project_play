<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/TagLib.jsp"%>
  <body>
  	
	<!-- 学生缴费信息列表 -->
	<div id="stuPaymentInfo" class="easyui-layout" data-options="fit:true" >
				<div class="center-filter clearfix" data-options="region:'north',border:false">
					<span class="table-title">学生缴费信息列表</span>
					<button class="filter_button" type="button" onclick="addStuPaymentInfo()" >缴费</button>
					<form id="stuPaymentInfo_form" class="filter_form">
						<span style="">从</span>
						<input class="easyui-datebox" editable="false" name="beginDate"></input>
						<span>至</span>
						<input class="easyui-datebox" editable="false"  name="endDate"></input>
						
						<input class="search_button" type="button" id="doSearchBtn"/>
					</form>
				</div>
				
				<div data-options="region:'center',border:false" >
				  <!-- 表格 -->
				  <table id="stuPaymentInfo-Grid"></table>
		        </div>

	</div>
	
	<div id="add_stuPaymentInfo_Window"></div>
	
	<script type="text/javascript">
	$("#stuPaymentInfo-Grid").datagrid({    
	    url:"${path }/mag/queryStuPaymentInfo",
	    method:'post',
		autoRowHeight:true,
		fit:true,
		fitColumns:true,
		rownumbers:true,
		collapsible:true,
		pagination:true,
	    columns:[[    
	        {field:'stuName',title:'学生姓名',width:80,align:'center'},
	        {field:'paymentType',title:'缴费类型',width:80,align:'center',formatter:paymentTypeFormatter},
	        {field:'paymentItem',title:'项目名称',width:150,align:'center'},
	        {field:'cash',title:'应缴金额',width:80,align:'center'},
	        {field:'realCash',title:'实缴金额',width:80,align:'center'},
	        {field:'payTime',title:'缴费时间',width:80,align:'center'},
	        {field:'userName',title:'处理人',width:80,align:'center'}
	    ]]    
	});
	
	function paymentTypeFormatter(value, row, index){
        return value==1?"学费项目":"其他项目";
	 }
	
	//搜索
	function queryStuPaymentInfo(){
		var param = formToJson("#stuPaymentInfo_form");
		$("#stuPaymentInfo-Grid").datagrid({
			queryParams:param
		});
		$("#stuPaymentInfo_form").form("reset");
	}
	$("#doSearchBtn").click(function(){
		queryStuPaymentInfo();
	});
	
	$("#add_stuPaymentInfo_Window").dialog({
		title:"增加学生缴费信息",
		width:700,    
	    height:350,      
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
	   	      	    	text:"确认增加",
	   	      	    	handler:function(){
	   	      	    	$("#addStuPayment-form").submit();
   	      	    	    }
     	      	    },{
	   	      	    	text:"取消",
	   	      	    	handler:function(){
	   	      	    	  $("#add_stuPaymentInfo_Window").dialog("close");
	   	      	    	}
    	             }
     	      	] 
	});
    
    //增加
    function addStuPaymentInfo(){
		$("#add_stuPaymentInfo_Window").dialog("open").dialog("refresh","${path}/mag/addStuPaymentInfoPage");
	}
	</script>
  </body>
