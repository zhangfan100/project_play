<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/TagLib.jsp"%>

<body style="overflow:hidden;">
	<style>
		form#addMes_Form input,form#editMes_Form input {
			border-radius: 5px;
			border-width: 1px;
			height:25px;
		}
		form#addMes_Form .combo,form#editMes_Form .combo{
			border-radius: 3px;
		}
	</style>
	<!-- 参数设置 -->
	<div id="center-message_manage_company" class="easyui-layout" data-options="fit:true" >
		<div data-options="region:'center',border:false" style="">
			<div id="" class="easyui-layout" data-options="fit:true">
				<div class="center-filter clearfix" data-options="region:'north',border:false" style="">
					<button class="filter_button" type="button" id="add_message_btn" onclick="showAddMsgDialog()">添加消息</button>
					<button class="filter_button" type="button" id="delChecked">删除所选</button>
					<button class="filter_button" type="button" id="delAll">删除全部</button>
					
					<form id="message_manage_company_form" class="filter_form" method="post">
						<span style="">从</span>
						<input class="easyui-datebox" editable="false" name="beginDate"></input>
						<span>至</span>
						<input class="easyui-datebox" editable="false" name="endDate"></input>
						
						<input class="search_input" type="text" name="keyWord" placeholder="标题/训练场地">
						<button class="search_button" type="button" id="doSearchBtn"></button>
					</form>
				</div>
				<div data-options="region:'center',border:false" >
					<table id="message_manage_dg" class="easyui-datagrid" title="" 
							data-options="nowrap:false,autoRowHeight:true,fit:true,fitColumns:true,rownumbers:true,singleSelect:false,collapsible:true,pagination:true,
							url:'${path }/mag/queryMessagePage?kindKey=${param.kindKey }',method:'POST'">
						<thead>
							<tr>
								<th data-options="field:'ck',checkbox:true"></th>
								<th data-options="field:'title',width:250,align:'left'">标题</th>
								<c:if test="${param.kindKey!='6' && param.kindKey!='7' }">
									<th data-options="field:'traiName',width:80,align:'center'">分校名称</th>
								</c:if>
								<th data-options="field:'messageDate',width:120,align:'center'">时间</th>
								<th data-options="field:'username',width:70,align:'center'">创建人</th>
								<th data-options="field:'xx',width:70,align:'center',formatter:formatterOperator">操作</th>
							</tr>
						</thead>
					</table>
				</div>
			</div>
			
		</div>

	</div>
	
	<div id="showAddMsg" class="easyui-dialog" title="添加消息" style="width:1000px;height:550px;overflow: hidden;overflow-y: scroll;"
			data-options="iconCls:'icon-tip',resizable:true,collapsible: true,minimizable: true,
            maximizable: true,modal:true,closed: true,cache:false,buttons:[{
						text:'保存',
						handler:function(){$('#addMes_Form').submit();}
					},{
						text:'取消',
						handler:function(){$('.panel-tool-close').click();}
					}]">
	</div>
	
	<div id="showEditMsg" class="easyui-dialog" title="编辑消息" style="width:1000px;height:550px;overflow: hidden;"
			data-options="iconCls:'icon-edit',resizable:true,collapsible: true,minimizable: true,
            maximizable: true,modal:true,closed: true,cache:false,buttons:[{
						text:'保存',
						handler:function(){$('#editMes_Form').submit();}
					},{
						text:'取消',
						handler:function(){$('.panel-tool-close').click();}
					}]">
	</div>
	
	<script type="text/javascript">
		var currMessageKind = "${param.kindKey}";
		var editData = null;
		
		
		function queryExc(){
			var param = formToJson("#message_manage_company_form");
				$("#message_manage_dg").datagrid({
					queryParams:param
				});
				$("#message_manage_company_form").form("reset");
		}
		$("#doSearchBtn").click(function(){
			queryExc();
		});
		
		
		$("#message_manage_company_form input").keyup(function(event){
			  if(event.keyCode ==13){
				  queryExc();
			  }
		});
		
		
		
		//删除所选 
		$("#delChecked").click(function(){
			var rows = $("#message_manage_dg").datagrid("getChecked");
			var ids = [];
			$.each(rows,function(index,item){
				ids.push(item.id);
			});
			
			if(ids.length==0){
				AlterMessage('请选择!');
				return;			
			}
			del({"ids":ids.join(",")});
		});
		
		//删除全部
		$("#delAll").click(function(){
			del({"kindKey":currMessageKind});
		});
		
		
		//删除操作
		function del(param){
			$.messager.confirm(GV.title, '确认删除?', function(r){
				if (r){
					$.post("${path}/mag/deleteMessageByID",param,function(data){
						switch(data*1){
							case 0 :ShowMessage('删除成功!');$("#message_manage_dg").datagrid("reload");break;
							case 1 :AlterMessage('删除失败!');break;
						}
					});
				}
			});
		}
		
		//编辑消息
		function edit(id){
			$("#showEditMsg").dialog({
				href:"${path}/mag/editMessage?flag=${param.kindKey=='6' || param.kindKey=='7'?'true':'false'}&id="+id
			}).dialog("open");
		}
		
		//格式化编辑列
		function formatterOperator(value, row, index) {
			return "<a class='edit_a_group' href='javascript:edit("+row.id+")'>编辑</a>";
		}
		
		//显示添加消息对话框
		function showAddMsgDialog(){
			$("#showAddMsg").dialog({
				href:"${path}/mag/addMessage?flag=${param.kindKey=='6' || param.kindKey=='7'?'true':'false'}"
			}).dialog("open");
		}
		
		//关闭显示的添加消息对话框
		function closeAddMsgDialog(){
			$("#showAddMsg").window("close");
			$("#message_manage_dg").datagrid("reload");
		}
		
		//关闭显示的修改消息对话框
		function closeEditMsgDialog(){
			$("#showEditMsg").window("close");
			$("#message_manage_dg").datagrid("reload");
		}
	</script>
</body>
