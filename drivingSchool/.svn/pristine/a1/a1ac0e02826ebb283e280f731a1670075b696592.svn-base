<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/TagLib.jsp"%>
<body>
	<div class="easyui-layout" data-options="fit:true">
		<div data-options="region:'center',border:false" style="">
			<div id="" class="easyui-layout" data-options="fit:true">
				<div class="center-filter clearfix" data-options="region:'north',border:false" style="">
					<button class="filter_button" type="button" onclick="carInfoAdd()" >新增车辆</button>
					<button class="filter_button" type="button" onclick="carBrandInfoEditClick()" >编辑车辆</button>
				</div>
				<div data-options="region:'center',border:false" >
					<table id="carInfoManageGrid" class="easyui-datagrid" title="" 
							data-options="
							nowrap:false,
							autoRowHeight:true,
							fit:true,
							fitColumns:true,
							rownumbers:true,
							singleSelect:true,
							checkOnSelect:true,
							selectOnCheck:true,
							pagination:true,
							url:'${path }/mag/queryCarInfoPage',method:'POST'">
						<thead>
							<tr>
								<th data-options="field:'carCode',width:100,align:'center'">车辆编号</th>
								<th data-options="field:'licenceCode',width:100,align:'center'">车辆牌号</th>
								<th data-options="field:'carType',width:100,align:'center',formatter:typeFormatter">车辆类型</th>
								<th data-options="field:'title',width:100,align:'center'">品牌名称</th>
								<th data-options="field:'carIP',width:100,align:'center'">车辆IP</th>
								<th data-options="field:'status',width:100,align:'center',formatter:statusFormatter">车辆状态</th>
								<th data-options="field:'operation',width:100,align:'center',formatter:operationFormatter">操作</th>
							</tr>
						</thead>
					</table>
				</div>
			</div>
		</div>
	</div>
	<div id="editCarInfoWindow"></div>
	<script type="text/javascript">
	function operationFormatter(value,row,index){
		var returnStr=
			"<a class='edit_a_group' onclick='carInfoEdit("
			+row.id
			+")'  href='javascript:void(0)'>编辑</a>"
		return returnStr;
	}
	function typeFormatter(value,row,index){
		switch (value) {
		case 0:
			return "教练训练车型";
		case 1:
			return "场地训练车型";
		case 2:
			return "场地模拟车型";
		}
		return null;
	}
	function statusFormatter(value,row,index){
		switch (value) {
		case 0:
			return "停用";
		case 1:
			return "启用";
		}
		return null;
	}
	
	function carInfoEdit(id){
		$("#editCarInfoWindow").dialog('open').dialog('refresh','${path}/mag/editCarInfo?id='+id);
	}
	function carInfoAdd(){
		$("#editCarInfoWindow").dialog('open').dialog('refresh','${path}/mag/addCarInfo');
	}
	$("#editCarInfoWindow").dialog({
		title:"车辆信息编辑",
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
	    		$("#carInfo-Form").submit();
	        }
	    },{
	    	text:"关闭",
	    	handler:function(){
	    		$("#editCarInfoWindow").dialog("close");
	        }
	    }] 
	});      
	function carBrandInfoEditClick(){
		var data = $("#carInfoManageGrid").datagrid("getSelected");
		if(data==null){
			$.messager.alert("","请选择要编辑的信息！");
		}else{
			carInfoEdit(data.id);
		}
		
	}
	</script>
</body>
