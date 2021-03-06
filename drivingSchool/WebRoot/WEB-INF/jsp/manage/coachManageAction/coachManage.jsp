<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/TagLib.jsp"%>
  <body>
  	<script type="text/javascript" src="${path }/static/scripts/SWFUpload/swfupload.js"></script>
	<script type="text/javascript" src="${path }/static/scripts/SWFUpload/plugins/swfupload.queue.js"></script> 
	<script type="text/javascript" src="${path }/static/scripts/SWFUpload/js/fileprogress.js"></script>
	<script type="text/javascript" src="${path }/static/scripts/SWFUpload/js/handlers.js"></script>
	<!-- 教练管理 -->
	<div id="coachManage" class="easyui-layout" data-options="fit:true" >

		<div data-options="region:'center',border:false" style="">
			<div id="" class="easyui-layout" data-options="fit:true">
				<div class="center-filter clearfix" data-options="region:'north',border:false">
					<span class="table-title">教练列表</span>
					<button class="filter_button" id="addCohBtn" type="button">新增</button>
					<form id="cohSearchForm" class="filter_form" method="post">
						<input class="search_input" name="keyWords" style="width:200px;" type="text" placeholder="证件号/姓名/手机">
						<button class="search_button" type="button" id="doSearchBtn"></button>
					</form>
				</div>
				<div data-options="region:'center',border:false" >
					<table id="cohManage_dg" class="easyui-datagrid"
							data-options="nowrap:false,autoRowHeight:true,fit:true,fitColumns:true,rownumbers:true,singleSelect:true,collapsible:true,pagination:true,
							url:'${path }/mag/queryCoachsByPage',method:'post'">
						<thead>
							<tr>
								<th data-options="field:'coachCode',width:80,align:'center'">教练证号</th>
								<th data-options="field:'name',width:80,align:'center'">姓名</th>
								<th data-options="field:'sex',width:80,align:'center',formatter:forSex">性别</th>
								<th data-options="field:'phone',width:80,align:'center'">联系电话</th>
								<th data-options="field:'status',width:80,align:'center',formatter:forStatus">帐号状态</th>
								<th data-options="field:'workDate',width:80,align:'center'">入职日期</th>
								<th data-options="field:'op',width:150,align:'center',formatter:operator">操作</th>
								
							</tr>
						</thead>
					</table>
				</div>
			</div>
		</div>

	
	<div id="add_coh_window" class="easyui-dialog" title="添加教练"  style="color:#5d5c5c;width:1200px;height:540px;" 
				data-options="iconCls:'icon-save',resizable:true,closed:true,maxed:true,modal:true,buttons:[{
						text:'保存',
						handler:saveCoach
					},{
						text:'取消',
						handler:function(){$('.panel-tool-close').click();}
					}],onClose:function(){
						try{
	    					swfu.destroy();
	    				}catch(e){}
					}">
			</div>
	<div id="edit_coh_window" class="easyui-dialog" title="修改教练"  style="color:#5d5c5c;width:1200px;height:540px;" 
				data-options="iconCls:'icon-save',resizable:true,closed:true,maxed:true,modal:true,buttons:[{
						text:'保存',
						handler:editCoach
					},{
						text:'取消',
						handler:function(){$('.panel-tool-close').click();}
					}],onClose:function(){
						try{
	    					swfu.destroy();
	    				}catch(e){}
					}">
			</div>
	<div id="info_coh_window" class="easyui-dialog" title="教练详情"  style="color:#5d5c5c;width:900px;height:460px;" 
				data-options="iconCls:'icon-save',resizable:true,closed:true,maxed:true,modal:true,buttons:[{
						text:'确定',
						handler:function(){$('.panel-tool-close').click();}
					}]">
			</div>
	</div>
	
	
	<script type="text/javascript">
		function forSex(value, row, index){
			return value==0?'女':'男';	
		}
		function forStatus(value, row, index){
			return value==0?'禁用':'启用';	
		}
		
		function operator(value, row, index){
			var txt = row.status==0?'启用':'禁用';
			return	'<a href="javascript:void(0);" class="edit_a_group" onclick="infoCoh('+row.id+')">查看</a>'+
					'<a href="javascript:void(0);" class="edit_a_group" onclick="editCoh('+row.id+')">编辑</a>'+
					'<a href="javascript:void(0);" class="edit_a_group" onclick="enable('+index+')">'+txt+'</a>';
		}
		
		//保存修改
		function editCoach(){
			if(!$("#editCoach #editCoh-form").form("validate")){
	    		return;
	    	}
	    	
	    	var param = formToJson("#editCoach #editCoh-form");
	    	param['coachAllowCarType'] = $("#editCoach #coachAllowCarType").combobox("getValues").join(",");
	    	
	    	$.post("${path}/mag/editCoachSubmit",param,function(data){
	    		if(data==0){
	    			$('.panel-tool-close').click();
	    			$("#cohManage_dg").datagrid("reload");
	    			ShowMessage("保存成功！");
	    		}else{
	    			AlterMessage("保存异常！");
	    		}
	    	});
		}
		
		 //保存
	    function saveCoach(){
	    	/* if($("#addCoach #imgCode").val()==""){
	    		AlterMessage("无头像！");
	    		return;
	    	} */
	    	
	    	if(!$("#addCoach #addCoh-form").form("validate")){
	    		return;
	    	}
	    	var param = formToJson("#addCoach #addCoh-form");
	    	$.post("${path}/mag/addCoachSubmit",param,function(data){
	    		data = eval("("+data+")");
	    		if(data.status==0){
	    			ShowMessage("保存成功！");
	    			$("#cohManage_dg").datagrid("reload");
	    	    	$("#add_coh_window").dialog('close');
	    		}else{
	    			AlterMessage("保存异常！");
	    			$("#add_coh_window").dialog('close');
	    		}
	    	});
	    }
		
		
		
		$("#doSearchBtn").click(function(){
			$("#cohSearchForm").submit();
		});
		
		
		$("#cohSearchForm input").keyup(function(event){
			  if(event.keyCode ==13){
				  $("#stuSearchForm").submit();
			  }
		});
		
		$("#cohSearchForm").submit(function(){
				var param = formToJson("#cohSearchForm");
				$("#cohManage_dg").datagrid({
					queryParams:param
				});
				return false;
		});
		
		//添加页
		$("#addCohBtn").click(function(){
			$("#add_coh_window").dialog('open').dialog('refresh','${path }/mag/addCoach');
		});
		//修改页
		function editCoh(id){
			$("#edit_coh_window").dialog('open').dialog('refresh','${path }/mag/editCoach?id='+id);
		};
		 //查看页
	    function infoCoh(id){
	    	$("#info_coh_window").dialog('open').dialog('refresh','${path }/mag/queryCoachInfo?id='+id);
	    }
		 
	 	//启用、禁用帐号
	    function enable(index){
	    	var row = $("#cohManage_dg").datagrid("getData").rows[index];
	    	var txt = row.status==0?'启用成功！':'禁用成功！';
	    	$.post("${path}/mag/enableAccount",{id:row.loginId,status:row.status},function(data){
	    		if(data==0){
	    			ShowMessage(txt);
	    			$("#cohManage_dg").datagrid('updateRow',{
	    				index: index,
	    				row: {
	    					status: row.status==0?1:0
	    				}
	    			});
	    		}else{
	    			AlterMessage(txt);
	    		}
	    	});
	    }
	</script>
  </body>
