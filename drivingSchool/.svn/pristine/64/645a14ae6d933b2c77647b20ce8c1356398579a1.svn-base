<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/TagLib.jsp"%>
  <body>
	
	<!-- 参数设置 -->
	<div id="center-system_setting_parasetting" class="easyui-layout" data-options="fit:true" >

		<div data-options="region:'center',border:false" style="">
			<div id="" class="easyui-layout" data-options="fit:true">
				<div class="center-filter clearfix" data-options="region:'north',border:false">
					<form id="system_setting_parasetting_form" class="filter_form" method="post">
						<input class="search_input" name="keyWords" style="width:200px;" type="text" placeholder="key/参数说明">
						<button class="search_button" type="button" id="doSearchBtn"></button>
					</form>
				</div>
				<div data-options="region:'center',border:false" >
					<table id="system_setting_parasetting_dg" class="easyui-datagrid" title="" 
							data-options="nowrap:false,autoRowHeight:true,fit:true,fitColumns:true,rownumbers:true,singleSelect:false,collapsible:true,pagination:true,
							url:'${path }/mag/queryBasicPropeInfoPage',method:'post'">
						<thead>
							<tr>
								<th data-options="field:'key',checkbox:true"></th>
								<th data-options="field:'title',width:100,align:'left'">参数说明</th>
								<th data-options="field:'value',width:100,align:'left'">参数值</th>
								<th data-options="field:'para_operate',width:100,align:'center',formatter:editordel">操作</th>
								
							</tr>
						</thead>
					</table>
				</div>
			</div>
			
			<div id="edit_para_window" class="easyui-dialog" title="参数编辑"  style="width:895px;height:250px;color:#5d5c5c;" 
				data-options="iconCls:'icon-save',resizable:true,closed:true,modal:true,buttons:[{
						text:'保存',
						handler:saveProperties
					},{
						text:'取消',
						handler:function(){$('.panel-tool-close').click();}
					}]">
					<div style="margin:40px 0 0 61px;">
						<span>参数说明:</span>
						<input id="web_para_id" type="hidden" >
						<input id="web_para_name" type="text" value="" style="margin:0;">
					</div>
					<div id="para_kv">
						<span >参数键:</span><input id="web_para_key" disabled="disabled" type="text" style="margin:0;">
						<span >参数值: </span><input id="web_para_value" type="text" style="margin:0;">
					</div>
			</div>
			
		</div>

	</div>
	
	<script type="text/javascript">
	function queryExc(){
		var param = formToJson("#system_setting_parasetting_form");
			$("#system_setting_parasetting_dg").datagrid({
				queryParams:param
			});
			$("#system_setting_parasetting_form").form("reset");
	}
	$("#doSearchBtn").click(function(){
		queryExc();
	});
	
	
	$("#system_setting_parasetting_form input").keyup(function(event){
		  if(event.keyCode ==13){
			  queryExc();
		  }
	});
	
	function submitForm(){
		$("#system_setting_parasetting_form").submit();
	}
	
	$("#system_setting_parasetting_form").form({
		submit:function (){
			var keyWords = $(this).find("#keyWords").val().trim();
			alert(keyWords);
			if(keyWords!="")
				$("#system_setting_parasetting_dg").datagrid({
					queryParams:{"keyWords":keyWords}
				});
			return false;
		}
	});
	
	function editordel(value, row, index){		 
		var fieldValueStr = '<a href="javascript:void(0);" class="edit_a_group" onclick="editItem('+index+')">编辑</a>';
		value=fieldValueStr;
		return value;
    };
    function editItem(index){		 
		var rows = $('#system_setting_parasetting_dg').datagrid('getRows');
		var row = rows[index];
		if (row){console.log($("#web_para_name")[0]);
			$("#web_para_name").val(row.title);
			$("#web_para_key").val(row.key);
			$("#web_para_value").val(row.value);
			$("#web_para_id").val(row.id);
		}
			
		$('#edit_para_window').window('open');
    };
    function saveProperties(){
    	$.ajax({
    		type:'post',
    		url:'${path}/mag/updateSbmitBasicPropeInfo',
    		data:{
    			title:$("#web_para_name").val(),
    			key:$("#web_para_key").val(),
    			value:$("#web_para_value").val(),
    			id:$("#web_para_id").val()
    		},
    		dataType:'json',
    		success:function(data){
    			if(data==1){
    				ShowMessage("修改成功！");
    				$('#edit_para_window').window('close');
    				$('#system_setting_parasetting_dg').datagrid("reload");
    			}else{
    				$.messager.alert("操作提示", "操作失败！","error");
    			}
    		}
    	});
    }
	</script>
  </body>
