<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/TagLib.jsp"%>
  <body>
  	
	<!-- 教练缴费信息列表 -->
	<div id="coachPaymentInfo" class="easyui-layout" data-options="fit:true" >
				<div class="center-filter clearfix" data-options="region:'north',border:false">
					<span class="table-title">教练缴费信息列表</span>
					<button class="filter_button" type="button" onclick="addCoachPaymentInfo()" >缴费</button>
					<form id="coachPaymentInfo_form" class="filter_form">
						<span style="">从</span>
						<input class="easyui-datebox" editable="false" name="beginDate"></input>
						<span>至</span>
						<input class="easyui-datebox" editable="false"  name="endDate"></input>
						
						<input class="search_button" type="button" id="doSearchBtn"/>
					</form>
				</div>
				
				<div data-options="region:'center',border:false" >
				  <!-- 表格 -->
				  <table id="coachPaymentInfo-Grid"></table>
		        </div>

	</div>
	
	<div id="add_coachPaymentInfo_Window"></div>
	
	<script type="text/javascript">
	$("#coachPaymentInfo-Grid").datagrid({    
	    url:"${path }/mag/querycoachPaymentInfo",
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
	        {field:'coachName',title:'教练姓名',width:100,align:'center'},
	        {field:'paymentItem',title:'缴费项目',width:100,align:'center'},
	        {field:'cash',title:'应缴金额',width:80,align:'center'},
	        {field:'realCash',title:'实缴金额',width:80,align:'center'},
	        {field:'payTime',title:'缴费时间',width:80,align:'center'},
	        {field:'userName',title:'处理人',width:80,align:'center'}
	    ]]    
	});
	
	//搜索
	function querycoachPaymentInfo(){
		var param = formToJson("#coachPaymentInfo_form");
		$("#coachPaymentInfo-Grid").datagrid({
			queryParams:param
		});
		$("#coachPaymentInfo_form").form("reset");
	}
	$("#doSearchBtn").click(function(){
		querycoachPaymentInfo();
	});
	
	
	$("#add_coachPaymentInfo_Window").dialog({
		title:"增加教练缴费信息",
		width:800,    
	    height:600,      
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
	   	      	    	$("#addCoachPaymentInfo-form").submit();
   	      	    	    }
     	      	    },{
	   	      	    	text:"取消",
	   	      	    	handler:function(){
	   	      	    	  $("#add_coachPaymentInfo_Window").dialog("close");
	   	      	    	}
    	             }
     	      	] 
	});
    
    //增加
    function addCoachPaymentInfo(){
		$("#add_coachPaymentInfo_Window").dialog("open").dialog("refresh","${path}/mag/addCoachPaymentInfoPage");
	}
	</script>
  </body>
