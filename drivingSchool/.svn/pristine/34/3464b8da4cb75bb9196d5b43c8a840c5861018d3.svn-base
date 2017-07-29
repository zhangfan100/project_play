<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/JSLib.jsp"%>

<body style="overflow:hidden;">
	<!-- 异常日志 -->
	<div id="center-log_manage_exception" class="easyui-layout" data-options="fit:true">
		<div data-options="region:'center',border:false" style="">
			<div id="" class="easyui-layout" data-options="fit:true">
				<div class="center-filter clearfix" data-options="region:'north',border:false" style="">
					<button class="filter_button" type="button" id="delChecked">删除所选</button>
					<button class="filter_button" type="button" id="delAll">删除全部</button>
					
					<form id="log_manage_exception_form" class="filter_form">
						<span style="">从</span>
						<input class="easyui-datebox" editable="false" name="beginDate"></input>
						<span>至</span>
						<input class="easyui-datebox" editable="false"  name="endDate"></input>
						
						<input class="search_button" type="button" id="doSearchBtn"/>
					</form>
				</div>
				<div data-options="region:'center',border:false" >
					<table id="log_manage_exception_dg" class="easyui-datagrid" title="" 
							data-options="onDblClickRow:dbExcRow,singleSelect:false,fit:true,rownumbers:true,pagination:true,fitColumns:true,url:'${path }/mag/queryExceptionLogPage',method:'POST'">
						<thead>
							<tr>
								<th data-options="field:'ck',checkbox:true"></th>
								<th data-options="field:'exceptionTitle',width:300">异常名称</th>
								<th data-options="field:'userName',width:40,align:'left'">操作用户</th>
								<th data-options="field:'userFlag',width:40,align:'left',formatter:userFlag">用户类型</th>
								<th data-options="field:'exceptionTime',width:100,align:'left'">操作时间</th>
							</tr>
						</thead>
					</table>
				</div>
			</div>
			
		</div>
	</div>
	<div id="showExcInfo" class="easyui-dialog" title="详细信息" style="width:900px;height:400px;color:#333333;"
	        data-options="iconCls:'icon-tip',resizable:true,modal:true,closed: true,maximizable:true,minimizable:true">
	    <div class="showTitle" style="padding:10px;padding: 10px;margin-top: 10px;">
	    	<span class="name"></span><span class="time" style="margin-left: 50px;"></span>
	    </div>
	    <div class="showContent" style="padding:5px 10px 10px 10px;line-height:20px;font-size:12px;"></div>
	</div>
<script type="text/javascript">
<!--

	//双击行显示
	function dbExcRow(rowIndex, rowData){
		$.post("${path}/mag/queryExceptionLogById",{id:rowData.id},function(data){
			data = $.parseJSON(data);
			$("#showExcInfo .name").html(data.userName+"("+userFlag(data.userFlag)+")");
			$("#showExcInfo .time").html(data.exceptionTime);
			$("#showExcInfo .showContent").html(data.exceptionContent.replace(/\r\n/gi,"</br>"));
			$("#showExcInfo").dialog("open");
		});
	}

	function queryExc(){
		var param = formToJson("#log_manage_exception_form");
		$("#log_manage_exception_dg").datagrid({
			queryParams:param
		});
		$("#log_manage_exception_form").form("reset");
	}
	$("#doSearchBtn").click(function(){
		queryExc();
	});
	
	$("#log_manage_exception_form").form({
		submit:function(){
			queryExc();
			return false;
		}
	});
	
	
	
	$("#delChecked").click(function(){
		var rows = $("#log_manage_exception_dg").datagrid("getChecked");
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
	
	$("#delAll").click(function(){
		var rows = $("#log_manage_exception_dg").datagrid("getChecked");
		del();
	});

	function userFlag(value,row,index){
		return userType[value];
	}
	
	function del(param){
		$.messager.confirm(GV.title, '确认删除?', function(r){
			if (r){
				$.post("${path}/mag/delExceptionLog",param,function(data){
					switch(data*1){
						case 0 :ShowMessage('删除成功!');$("#log_manage_exception_dg").datagrid("reload");break;
						case 1 :AlterMessage('删除失败!');break;
					}
				});
			}
		});
	}
//-->
</script>
</body>
<%-- <body>
	<table id="exc_table" class="easyui-datagrid"
		title="系统异常日志" style="width:700px;height:250px"
		data-options="fit:true,onDblClickRow:dbExcRow,rownumbers:true,singleSelect:false,pagination:true,fitColumns:true,url:'${path }/mag/queryExceptionLogPage',method:'POST'">
		<thead>
			<tr>

				<th data-options="field:'exceptionTitle',width:120">异常名称</th>
				<th data-options="field:'exceptionContent',width:300">异常内容</th>
				<th data-options="field:'userName',width:30,align:'right'">操作用户</th>
				<th data-options="field:'userFlag',width:20">用户类型</th>
				<th data-options="field:'exceptionTime',width:60,align:'right'">操作时间</th>
			</tr>
		</thead>
	</table>
	<div id="showExcInfo" class="easyui-dialog" title="详细信息" style="width:800px;height:400px;"
	        data-options="iconCls:'icon-tip',resizable:true,modal:true,closed: true">
	    <div class="showTitle"></div>
	    <div class="showContent"></div>
	</div>
	<script type="text/javascript">
		//双击行显示
		function dbExcRow(rowIndex, rowData){
			$("#showExcInfo .showContent").html(rowData.exceptionContent);
			$("#showExcInfo .showTitle").html(rowData.exceptionTitle);
			$("#showExcInfo").dialog("open");
		}
		
		function del(id){
			$.messager.confirm(GV.title, '确认删除?', function(r){
				if (r){
					$.post("${path}/mag/delExceptionLog",{id:id},function(data){
						switch(data*1){
							case 0 :ShowMessage('删除成功!');$("#exc_table").datagrid("reload");break;
							case 1 :AlterMessage('删除失败!');break;
						}
					});
				}
			});
		}
		function delExceptionLog(value, row, index) {
			return "<a href='javascript:del("+row.id+")'>删除</a>";
		}
	</script>
</body> --%>