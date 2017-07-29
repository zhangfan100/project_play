<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/TagLib.jsp"%>
<body>
<div class="easyui-tabs" data-options="fit:true">
		<div title="抽奖信息" data-options="selected:true">
		<form id="editLottery-Form" method="post">
			<input type="hidden" name="token" value="${token }">
			<input type="hidden" name="id"  value="${record.id }" />
		<div style="margin-top: 30px;" class="form_Table">
		<div class="form_Group_Title">抽奖信息</div>
					<div class="form_Table_Row">
						<div class="form_Attr_Title">抽奖标题：</div>
						<div class="form_Attr_Input">
							<input type="text"  class="easyui-validatebox" id="fromAttrInput"
								value="${record.title }" required="true" name="title"/>
						</div>
						<div class="form_Attr_Title">状态：</div>
						<div class="form_Attr_Input">
							<input type="text" value="${record.status }" class="easyui-combobox"
								 required="true" name="status" id="fromdatebox"
								data-options="
									valueField: 'value',
									textField: 'text',
									editable:false,
									data: [{
										text: '启用',
										value: '1'
									},{
										text: '禁用',
										value: '0'
									}]"
								/>
						</div>
					</div>
					
					<div class="form_Table_Row">
						<div class="form_Attr_Title">开始时间：</div>
						<div class="form_Attr_Input">
							<input type="text"  class="easyui-datetimebox" id="fromdatebox"
								value="${record.beginTime }" required="true" name="beginTime"/>
						</div>
						<div class="form_Attr_Title">结束时间：</div>
						<div class="form_Attr_Input">
							<input type="text"  class="easyui-datetimebox" id="fromdatebox"
								value="${record.endTime }" required="true" name="endTime"/>
						</div>
					</div>
					
					<!-- <div class="form_Table_Row">
					<div class="form_Attr_Title">角色：</div>
						<div class="form_Attr_Input">
							<input type="text" class="easyui-combobox"
								 required="true" name="roleId" id="fromdatebox"
								 data-options="
									valueField: 'value',
									textField: 'text',
									editable:false,
									data: [{
										text: '激活学生',
										value: '6'
									},{
										text: '未激活学生',
										value: '1'
									}]"
								/>
						</div>
					</div> -->
		</div>
		<div style="width: 100%;height: 30px;resize: none;text-align: center;margin-top: 20px;">
			<a class="easyui-linkbutton" onclick="editLotterySubmit()" data-options="iconCls:'icon-save'" style="margin-right: 20px;">保存</a>
		</div>
		</form>
		</div>
		<div title="奖品信息">
		
		<div class="easyui-layout" data-options="fit:true">   
		   <div class="center-filter clearfix" data-options="region:'north',border:false">
					<button class="filter_button" onclick="addPrize()" type="button">新增奖品</button>
					<button class="filter_button" onclick="editPrizeInfo()" type="button">编辑奖品</button>
					<form id="prizeInfoSearchForm" class="filter_form" method="post">
						<input class="search_input" name="keyWord" style="width:200px;" type="text" placeholder="奖品名称">
						<button class="search_button" type="button" id="doSearchButton"></button>
					</form>
				</div> 
		    <div data-options="region:'center',border:false">
		   <table id="prizeInfoManageTable" class="easyui-datagrid"
						data-options="
						nowrap:false,
						autoRowHeight:true,
						fit:true,
						fitColumns:true,
						rownumbers:true,
						singleSelect:true,
						pagination:true,
						checkOnSelect:true,
						selectOnCheck:true,
						url:'${path}/mag/queryPrizeInfo',method:'POST'">
						<thead>
							<tr>
								<th data-options="field:'id',checkbox:true"></th>
								<th data-options="field:'prizeName',width:150,align:'center'">奖品名称</th>
								<th data-options="field:'title',width:100,align:'center'">所属活动</th>
								<th data-options="field:'type',width:100,align:'center',formatter:formatType">类型</th>
								<th data-options="field:'prizeCount',width:100,align:'center'">份数</th>
								
								<th data-options="field:'operation',width:120,align:'center',formatter:operationPrize">操作</th>
							</tr>
						</thead>
					</table>
		    </div>  
		     
		</div> 
		</div>
		
	</div>

<div id="editPrizeInfo"></div>
<div id="addPrizeInfo"></div>
<script type="text/javascript">

$("#editPrizeInfo").dialog({
			title:"编辑奖品 ",
		    width:900,    
		    height:450,    
		    modal:true,
		    maximizable:false,
		    minimizable:false,
		    draggable:false,
		    resizable:false,
		    cache:true,
		    closed:true,
		    buttons:[{	
		    	text:'保存',
		    	handler:function(){
		    		$("#editPrizeInfo-from").submit();
		    	}
		    	},{
		    	text:'关闭',
		    	handler:function(){
		    		$("#editPrizeInfo").dialog('close')
		    		}
		    }]
		})
		
		
$("#addPrizeInfo").dialog({
			title:"添加奖品 ",
		    width:900,    
		    height:450,    
		    modal:true,
		    maximizable:false,
		    minimizable:false,
		    draggable:false,
		    resizable:false,
		    cache:true,
		    closed:true,
		    buttons:[{	
		    	text:'保存',
		    	handler:function(){
		    		$("#addPrizeInfo-from").submit();
		    	}
		    	},{
		    	text:'关闭',
		    	handler:function(){
		    		$("#addPrizeInfo").dialog('close')
		    		}
		    }]
		})

	function addPrize(){
			$("#addPrizeInfo").dialog('open').dialog('refresh','${path}/mag/addPrizeInfo');
		}
		

	function operationPrize(value,row,index){
			var text = "<a class='edit_a_group' onclick='editPrizeInfo("+row.id+")' href='javascript:void(0)'>编辑</a>"
			return text;
		}
	function formatType(value, row, index){
 		return value==1?"正常奖品":"轮空奖品";
	}
	
	function editPrizeInfo(id){
			if(!id){
				var r = $("#prizeInfoManageTable").datagrid("getSelected");
				if(r){
					id = r.id;
				}else{
					$.messager.alert("","请选择需要编辑的奖品！");
					return ;
				}
			}
			$("#editPrizeInfo").dialog('open').dialog('refresh','${path}/mag/editPrizeInfo?id='+id);
		}
		
	
$("#editLottery-Form").form({
			url : "${path}/mag/editLotterySubmit",
			onSubmit : function() {
				var isValid = $("#editLottery-Form").form('validate');
				 return isValid;	// 返回false终止表单提交
			},
			success : function(data) {
					ShowMessage("编辑成功");
					$("#edit_Lottery_window").dialog('close');
					$("#LotteryInfo_dg").datagrid("reload");
			}
		});
		function editLotterySubmit() {
			$("#editLottery-Form").submit();
		}	
		
		
	$("#doSearchButton").click(function(){
		$("#prizeInfoSearchForm").submit();
	});
	
	
	$("#prizeInfoSearchForm input").keyup(function(event){
		  if(event.keyCode ==13){
			  $("#prizeInfoSearchForm").submit();
		  }
	});
	
	$("#prizeInfoSearchForm").submit(function(){
			var param = formToJson("#prizeInfoSearchForm");
			$("#prizeInfoManageTable").datagrid({
				queryParams:param
			});
			return false;
	});
</script>

</body>