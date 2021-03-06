<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/TagLib.jsp"%>
  <body>
  	<!-- 收入项目管理 -->
	<div class="easyui-layout" data-options="fit:true" >
		<div class="center-filter clearfix" data-options="region:'north',border:false">
			<!-- 标题 -->
			<span class="table-title">收入项目列表</span>
			<button class="filter_button" type="button" onclick="addIncomeItem()" >新增</button>
			<button class="filter_button" type="button" onclick="delSelectIncomeItem()" >删除</button>
		</div>
		<div data-options="region:'center',border:false" >
		<!-- 表格 -->
		<table id="incomeItemManage-Grid"></table>
		</div>
	</div>
	
	<div id="add_incomeItem_Window"></div>
	
	<div id="edit_incomeItem_Window"></div>
	
	<script type="text/javascript">
	$("#incomeItemManage-Grid").datagrid({    
	    url:"${path }/mag/queryIncomeItemByPage",
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
	        {field:'itemTag',title:'收入具体项目',width:200,align:'center'},
	        {field:'itemType',title:'收入类型',width:80,align:'center',formatter:itemTypeFormatter},
	        {field:'operation',title:'操作',width:100,align:'center',formatter:operationFormatter}
	    ]]    
	});
	
	function itemTypeFormatter(value, row, index){
		return value==1?"学生用":value==2?"教师用":"公用";
	}
	
	function operationFormatter(value, row, index){
		return  '<a href="javascript:void(0);" class="edit_a_group" onclick="editIncomeItem('+row.id+')">编辑</a>'+
				'<a href="javascript:void(0);" class="edit_a_group other" onclick="delIncomeItem('+row.id+')">删除</a>';
	}
	
    $("#add_incomeItem_Window").dialog({
		title:"增加收入项目",
	    width:350,    
	    height:200,    
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
	   	      	    	  $("#addIncomeItem-form").submit();
   	      	    	    }
     	      	    },{
	   	      	    	text:"取消",
	   	      	    	handler:function(){
	   	      	    	  $("#add_incomeItem_Window").dialog("close");
	   	      	    	}
    	             }
     	      	] 
	});
    
    //增加
    function addIncomeItem(){
		$("#add_incomeItem_Window").dialog("open").dialog("refresh","${path}/mag/addIncomeItem");
	}
    
    //批量 删除
    function delSelectIncomeItem(){
    	var idStr="";
		var count = 0;//用来记录选择的个数
		$($("#incomeItemManage-Grid").datagrid("getChecked")).each(function(index,element){
			idStr+=element.id+",";
			count++;
		});
		if(count<1){
			AlterMessage("请选择ff","");
			return;
		}
		common(idStr.substring(0,idStr.length-1));
	}
    
    //删除
    function delIncomeItem(id){
    	common(id);
    }
    
    function common(id){
    	$.messager.confirm('确认消息框','您确认要删除吗？',function(r){
			if(r){
				$.ajax({
			        type: "post",
			        url: "${path}/mag/delIncomeItem",
			        data: {
			        	idStr:id
			        },
			        success: function(data){
			        	$("#incomeItemManage-Grid").datagrid("reload");
			        	$.messager.show({
			        		title:'我的消息',
			        		msg:'111删除成功！',
			        	});
			        }
			    });
			}
		});
    }
    
    $("#edit_incomeItem_Window").dialog({
		title:"收入项目编辑",
	    width:350,    
	    height:200,    
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
	   	      	    	text:"确认修改",
	   	      	    	handler:function(){
	   	      	    	  $("#editIncomeItem-form").submit();
   	      	    	    }
     	      	    },{
	   	      	    	text:"取消",
	   	      	    	handler:function(){
	   	      	    	  $("#edit_incomeItem_Window").dialog("close");
	   	      	    	}
    	             }
     	      	] 
	});
    
    //编辑
    function editIncomeItem(id){
		$("#edit_incomeItem_Window").dialog("open").dialog("refresh","${path}/mag/editIncomeItem?id="+id);
	}
	</script>
  </body>
