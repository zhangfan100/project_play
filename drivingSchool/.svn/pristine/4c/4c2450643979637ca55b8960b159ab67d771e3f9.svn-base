<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/TagLib.jsp"%>
<body>
	<div class="easyui-layout" data-options="fit:true">
		<div data-options="region:'north',border:false" style="overflow:hidden;padding-bottom:18px;">
		<div id="roleSelect" class="centermenu">
			<div class="center-menu center-menu_active" onclick="loadRoleData(3)" >
				<div class="">
					<span>管理员角色</span>
				</div>
			</div>
			<div class="center-menu" onclick="loadRoleData(2)" >
				<div class="">
					<span>教师角色</span>
				</div>
			</div>
			<div class="center-menu" onclick="loadRoleData(1)" >
				<div class="">
					<span>学生角色</span>
				</div>
			</div>
		</div>
		</div>
		<div data-options="region:'center',border:false">
		<table id="roleManageTable" class="easyui-datagrid" title="" 
			data-options="nowrap:false,autoRowHeight:true,fit:true,fitColumns:true,rownumbers:true,singleSelect:false,pagination:true,
			url:'${path }/mag/queryRolePage',method:'POST',onBeforeLoad:loadRolePage">
			<thead>
				<tr>
				<th data-options="field:'id',checkbox:true"></th>
				<th data-options="field:'title',width:150,align:'center'">角色名称</th>
				<th data-options="field:'userCount',width:100,align:'center'">人数</th>
				<th data-options="field:'operation',width:120,align:'center',formatter:operationFormatter">操作</th>
				</tr>
			</thead>
		</table>
		</div>
	</div>
	<div id="roleTreeWindow"></div>
	<script type="text/javascript">
	$("#roleTreeWindow").dialog({
		title:"角色权限编辑",
	    width:600,    
	    height:400,    
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
	    		saveRolePrivilege();
	        }
	    },{
	    	text:"关闭",
	    	handler:function(){
	    		$("#roleTreeWindow").dialog("close");
	        }
	    }] 
	});
	var currRoleType=3;
	function loadRoleData(roleType){
		$($("#roleSelect .center-menu").removeClass("center-menu_active")[3-roleType]).addClass("center-menu_active");
		currRoleType=roleType;
		$("#roleManageTable").datagrid('reload');
	}
	function loadRolePage(param){
		if(!param.roleType){
			param.roleType=currRoleType;
		}
		return true;
	}
	function operationFormatter(value,row,index){
		return "<a class='edit_a_group' onclick='rolePrivilegeEdit("+row.id+")'  href='javascript:void(0)'>编辑</a>";
	}
	function rolePrivilegeEdit(id){
		$("#roleTreeWindow").dialog("open").dialog("refresh","${path}/mag/rolePrivilegeEdit?roleId="+id);
	}
	</script>
</body>
