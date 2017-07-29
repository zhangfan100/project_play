<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@include file="../../TagLib/TagLib.jsp"%>
  <body>
	<!-- 参数设置 -->
	<div id="center-system_setting_parasetting" class="easyui-layout" data-options="fit:true" >

		<div data-options="region:'center',border:false" style="">
			<div id="" class="easyui-layout" data-options="fit:true">
				<div class="center-filter clearfix" data-options="region:'north',border:false" style="">
				<button id="btn-upload_image" class="filter_button" type="button" onclick="javascript:addCampusInfo();">添加分校</button>
				<button class="filter_button" type="button" onclick="campusInfoEditClick()" >编辑分校</button>
					
				</div>
				<div data-options="region:'center',border:false" >
					<table id="system_setting_parasetting_dg" class="easyui-datagrid" title="" 
							data-options="nowrap:false,autoRowHeight:true,fit:true,fitColumns:true,rownumbers:true,singleSelect:true,collapsible:true,pagination:true,checkOnSelect:true,
							selectOnCheck:true,
							url:'${path }/mag/queryCampusInfo',method:'post'">
						<thead>
							<tr>
								<th data-options="field:'ck',checkbox:true"></th>
								<th data-options="field:'title',width:70,align:'center'">分校名称</th>
								<th data-options="field:'campusCode',width:80,align:'center'">分校代码</th>
								<th data-options="field:'address',width:120,align:'center'">分校地址</th>
								<th data-options="field:'GPSAddress',width:70,align:'center'">GPS地址</th>
								<th data-options="field:'phone',width:70,align:'center'">电话</th>
								<th data-options="field:'xx',width:100,align:'center',formatter:editordel">操作</th>
							</tr>
						</thead>
					</table>
				</div>
			</div>
			
			<div id="edit_campus_window" class="easyui-dialog" title="参数编辑"  style="width:955px;height:450px;color:#5d5c5c;" 
				data-options="iconCls:'icon-save',resizable:true,closed:true,modal:true,buttons:[{
						text:'保存',
						handler:saveProperties
					},{
						text:'取消',
						handler:function(){$('.panel-tool-close').click();}
					}]">
					<div id="para_kv">
			<span>驾校名称:</span>
			<input id="web_para_id" type="hidden"> 
			<input id="web_para_title" class="easyui-validatebox" data-options="required:true" type="text">
			<span>驾校地址: </span>
			<input id="web_para_address" class="easyui-validatebox" data-options="required:true" type="text"> <br>
			<br> <span>驾校代码:</span>
			<input id="web_para_campusCode" class="easyui-validatebox" data-options="required:true" type="text">
			<span>GPS地址: </span>
			<input id="web_para_GPSAddress"  type="text"class="easyui-validatebox" data-options="required:true"> <br>
			<br> <span>电&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;话: </span>
			<input id="web_para_phone" class="easyui-validatebox" data-options="required:true" type="text">
		</div>
			</div>
			
			<div id="showaddCampusInfo" class="easyui-dialog" title="添加分校"  style="width:955px;height:300px;color:#5d5c5c;" 
				data-options="iconCls:'icon-save',resizable:true,closed:true,modal:true,buttons:[{
						text:'保存',
						handler:CampusInfo
					},{
						text:'取消',
						handler:function(){$('.panel-tool-close').click();}
					}]">
			<form id="addCampusInfo" method="post">
			 <div id="para_kv">
				<span>驾校名称:</span> 
				<input id="web_para_id" type="hidden"> 
				<input id="web_para_title" type="text" class="easyui-validatebox" data-options="required:true" name="title" style="margin:0;">
				<span>驾校地址: </span>
				<input id="web_para_address" class="easyui-validatebox" data-options="required:true" type="text" name="address" style="margin:0;"> <br>
				<br> <span>驾校代码:</span>
				<input id="web_para_campusCode" class="easyui-validatebox" data-options="required:true" type="text" name="campusCode" style="margin:0;">
			   <span>电&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;话: </span>
				<input id="web_para_phone" class="easyui-validatebox" data-options="required:true" type="text" name="phone" style="margin:0;">
			   <!-- <br><br> 
			    <span>搜索城市: </span><input id="txtCity" type="text" placeholder="如:成都市"/>
				<span>地名关键词: </span><input id="txtSearch" type="text" placeholder="必填详细地址以便准确定位地图"/>  --><br><br>
			    <span>GPS地址: </span>
			    <input id="web_para_GPSAddress" type="text" class="easyui-validatebox" data-options="required:true" name="GPSAddress" style="margin:0;"> 
			 </div>
		</form>
			</div>
		</div>
	</div>
	<div id="edit_campusInfo_window"></div>
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
    function campusInfoEdit(id){
		$("#edit_campusInfo_window").dialog('open').dialog('refresh','${path}/mag/editCampusInfoId?campusInfoId='+id);
	}
    $("#edit_campusInfo_window").dialog({
		title:"分校编辑",
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
	    		$("#campuInfo-Form").submit();
	        }
	    },{
	    	text:"关闭",
	    	handler:function(){
	    		$("#edit_campusInfo_window").dialog("close");
	        }
	    }] 
	});
    
    function editItem(index){		 
		var rows = $('#system_setting_parasetting_dg').datagrid('getRows');
		var row = rows[index];
		if (row){
			$("#web_para_title").val(row.title);
			$("#web_para_address").val(row.address);
			$("#web_para_campusCode").val(row.campusCode);
			$("#web_para_GPSAddress").val(row.GPSAddress);
			$("#web_para_phone").val(row.phone);
			$("#web_para_id").val(row.id);
			$('#edit_campus_window').window('open');
		}
    };
    function saveProperties(){
    	$.ajax({
    		type:'post',
    		url:'${path}/mag/editCampusInfoSubmit',
    		data:{
    			id:$("#web_para_id").val(),
    			title:$("#web_para_title").val(),
    			phone:$("#web_para_phone").val(),
    			campusCode:$("#web_para_campusCode").val(),
    			address:$("#web_para_address").val(),
    			GPSAddress:$("#web_para_GPSAddress").val(),
    		},
    		dataType:'json',
    		success:function(data){
    			if(data==1){
    				ShowMessage("修改成功！");
    				$('#edit_campus_window').window('close');
    				$('#system_setting_parasetting_dg').datagrid("reload");
    			}else{
    				$.messager.alert("操作提示", "操作失败！","error");
    			}
    		}
    	});
    }
    
  //添加
	function addCampusInfo(){
		$("#showaddCampusInfo").window("open");
	}
  
	$("#addCampusInfo").form({
		 type: "post",
		dataType: "json", 
		url : "${path}/mag/addCampusInfo",
		success : function(data) {
			if (data == 1) {
				ShowMessage('添加成功!');
				$('#showaddCampusInfo').window('close');
				$('#system_setting_parasetting_dg').datagrid("reload");
			} else {
				ShowMessage('添加失败!');
			}
		}
	});

	function CampusInfo() {
		$("#addCampusInfo").submit();
	}
	//编辑
	function campusInfoEditClick(){
		var data = $("#system_setting_parasetting_dg").datagrid("getSelected");
		if(data==null){
			$.messager.alert("","请选择要编辑的信息！");
		}else{
			campusInfoEdit(data.id);
		}
		
	}
	</script>
  </body>
