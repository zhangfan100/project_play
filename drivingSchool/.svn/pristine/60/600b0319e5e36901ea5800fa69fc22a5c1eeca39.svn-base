<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/TagLib.jsp"%>
<body >
	<div class="easyui-layout" data-options="fit:true">
		<div data-options="region:'center',border:false" style="">
			<div id="" class="easyui-layout" data-options="fit:true">
				<div class="center-filter clearfix" data-options="region:'north',border:false" style="">
					<button class="filter_button" type="button">新增人员</button>
					<button class="filter_button" type="button" onclick="setSelectedStatus(1)" >启用人员</button>
					<button class="filter_button" type="button" onclick="setSelectedStatus(0)">停用人员</button>
				</div>
				<div data-options="region:'center',border:false" >
					<table id="adminManageGrid" class="easyui-datagrid" title="" 
							data-options="nowrap:false,autoRowHeight:true,fit:true,fitColumns:true,rownumbers:true,singleSelect:false,pagination:true,
							url:'${path }/mag/querySysAdminPage',method:'POST'">
						<thead>
							<tr>
								<th data-options="field:'id',checkbox:true"></th>
								<th data-options="field:'name',width:100,align:'center'">管理员姓名</th>
								<th data-options="field:'title',width:100,align:'center'">管理员角色</th>
								<th data-options="field:'lastLoginIP',width:100,align:'center'">上次登陆IP</th>
								<th data-options="field:'status',width:100,align:'center',formatter:statusFormatter">账号状态</th>
								<th data-options="field:'operation',width:100,align:'center',formatter:operationFormatter">操作</th>
							</tr>
						</thead>
					</table>
				</div>
			</div>
			<span style="color: green;" ></span>
		</div>
	</div>
	<script type="text/javascript">
	function statusFormatter(value,row,index){
		if(value==1){
			return '<span style="color: green;" >已启用</span>'
		}else{
			return '<span style="color:red;" >已停用</span>'
		}
	}
	function operationFormatter(value,row,index){
		var returnStr=
			"<a class='edit_a_group' onclick='SysAdminInfoEdit("
			+row.id
			+")'  href='javascript:void(0)'>编辑</a>"
			+"&nbsp;&nbsp;&nbsp;";
		if(row.status==1){
			returnStr+="<a class='edit_a_group' onclick='setAdminStatus("
			+row.id
			+","
			+"0"
			+")'  href='javascript:void(0)'>";
			returnStr+="停用";
		}else{
			returnStr+="<a class='edit_a_group' onclick='setAdminStatus("
			+row.id
			+","
			+"1"
			+")'  href='javascript:void(0)'>";
			returnStr+="启用";
		}
		returnStr+="</a>"
		return returnStr;

	}
	function SysAdminInfoEdit(id){
		alert(id);
	}
	function setAdminStatus(idStr,changeStatus){
		$.ajax({
			type:"post",
			url :"${path}/mag/setAdminStatus",
			data:{
				'idStr':idStr,
				'status':changeStatus
			},
			success:function(data){
				$.messager.show({
					msg:'修改成功！',
					showType:'slide'
				});
				$('#adminManageGrid').datagrid('reload');
			}
		});
	}
	function setSelectedStatus(changeStatus){
		var datas=$('#adminManageGrid').datagrid('getChecked');
		if(datas.length==0){
			$.messager.show({
				msg:'请选择要修改的用户！',
				showType:'slide'
			});
			return;
		}
		var idStr="";
		$(datas).each(function(index,element){
			idStr+=element.id+",";
		});
		setAdminStatus(idStr,changeStatus);
		
	}
	</script>
</body>
