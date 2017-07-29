<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/JSLib.jsp"%>

<body>
	<!-- 模拟信息 -->
	<div id="center-log_manage_operate" class="easyui-layout"
		data-options="fit:true">
		<div data-options="region:'center',border:false" style="">
			<div id="" class="easyui-layout" data-options="fit:true">
				<div class="center-filter clearfix"
					data-options="region:'north',border:false" style="">
					<button class="filter_button" type="button"
						onclick="carBrandInfoAdd()">添加预约</button>
					<button class="filter_button" onclick="cancelSelectedTestInfo()" type="button">取消预约</button>
				</div>
				<div data-options="region:'center',border:false">
					<table id="testInfo-DataGrid" class="easyui-datagrid" title=""
						data-options="
								nowrap:false,
								autoRowHeight:true,
								fit:true,
								fitColumns:true,
								rownumbers:true,
								singleSelect:false,
								pagination:true,
								url:'${path }/mag/queryTestInfoPage'
								,method:'POST'">
						<thead>
							<tr>
								<th data-options="field:'id',checkbox:true"></th>
								<th data-options="field:'testCode',width:100,align:'center'">模拟编号</th>
								<th data-options="field:'studyDate',width:100,align:'center'">模拟时间</th>
								<th data-options="field:'stuName',width:150,align:'center'">学生姓名</th>
								<th data-options="field:'subject',width:100,align:'center'">科目</th>
								<th
									data-options="field:'status',width:120,align:'center',formatter:statusFormatter">状态</th>
								<th
									data-options="field:'operation',width:120,align:'center',formatter:operationFormatter">操作</th>
							</tr>
						</thead>
					</table>
				</div>
			</div>
		</div>
	</div>
	<span style="color: red;"></span>
	<div id="editTestInfoWindow"></div>
	<div id="showTestDetailWindow"></div>
	<script type="text/javascript">
	$("#editTestInfoWindow").dialog({
		title:"模拟考试信息编辑",
	    width:600,    
	    height:300,    
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
	    		$("#testInfo-Form").submit();
	        }
	    },{
	    	text:"关闭",
	    	handler:function(){
	    		$("#editTestInfoWindow").dialog("close");
	        }
	    }] 
	});
	function carBrandInfoAdd(){
		$("#editTestInfoWindow").dialog('open').dialog('refresh','${path}/mag/addTestInfo');
	}
	function statusFormatter(value,row,index){
		switch (value) {
		case 0:
			return "<span style='color: red;' >未开始</span>";
		case 1:
			return "<span style='color: red;' >正在进行</span>";
		case 2:
			return "<span style='color: green;' >已完成</span>";
		default:
			return "<span style='color: red;' >培训异常</span>";
		}
	}
	function operationFormatter(value,row,index){
		var returnStr ="";
		if(row.status==2){
			returnStr="<a class='edit_a_group' onclick='showTestInfo("+row.id+")'  href='javascript:void(0)'>查看详情</a>";
		}else{
			returnStr="<a class='edit_a_group' onclick='cancelTestInfo("+row.id+")'  href='javascript:void(0)'>取消约考</a>";

		}
		return returnStr;
	}
	function showTestInfo(id){
		$("#showTestDetailWindow").dialog('open').dialog('refresh','${path}/mag/showTestDetail?testInfoId='+id);
	}
	function cancelTestInfo(ids){
		$.ajax({
            type: "post",
            url: "${path}/mag/cancelTestInfo",
            data: {
            	ids:ids
            },
            success: function(data){
            	$.messager.alert("","取消选课成功！");
            	$("#testInfo-DataGrid").datagrid("reload");
            }
        });
	}
	function cancelSelectedTestInfo(){
		var selects = $("#testInfo-DataGrid").datagrid("getChecked");
		if(selects.length==0){
			$.messager.alert("","请选择需要取消的模拟预约！");
			return;
		}
		var ids = "";
		$(selects).each(function(index,element){
			if(element.status!=0){
				$.messager.alert("","所选模拟中有无法取消的模拟，请重新选择！");
				return;
			}else{
				ids+=element.id+",";
			}
		})
		cancelTestInfo(ids);
	}
	$("#showTestDetailWindow").dialog({
		title:"考试成绩详情",
	    width:1000,    
	    height:600,    
	    modal:true,
	    maximizable:false,
	    minimizable:false,
	    collapsible:false,
	    draggable:false,
	    resizable:false,
	    cache:false,
	    closed:true,
	    buttons: [{
		    text:"打印",
		    handler:function(){
		    	$("#showTestDetail").jqprint({debug:true});
		    }
		},{
		    text:"关闭",
		    handler:function(){
		    	$("#showTestDetailWindow").dialog("close");
		 }
		}]
	});
	</script>
</body>
