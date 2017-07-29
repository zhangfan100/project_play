<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/TagLib.jsp"%>
  <body>
  	
	<!--抽奖信息 -->
	<div class="easyui-layout" data-options="fit:true" >

		<div data-options="region:'center',border:false">
			<div id="" class="easyui-layout" data-options="fit:true">
				<div class="center-filter clearfix" data-options="region:'north',border:false">
					<span class="table-title">抽奖信息</span>
					<button class="filter_button" onclick="addLottery()" type="button">新增</button>
					<form id="lotterySearchForm" class="filter_form" method="post">
						<input class="search_input" name="keyWord" style="width:200px;" type="text" placeholder="姓名">
						<button class="search_button" type="button" id="doSearchBtn"></button>
					</form>
				</div>
				<div data-options="region:'center',border:false" >
					<table id="LotteryInfo_dg" class="easyui-datagrid"
							data-options="nowrap:false,
							autoRowHeight:true,
							fit:true,
							fitColumns:true,
							rownumbers:true,
							singleSelect:true,
							collapsible:true,
							pagination:true,
							url:'${path }/mag/queryLotteryInfoPage',method:'post'">
						<thead>
							<tr>
							
								<th data-options="field:'title',width:80,align:'center'">抽奖标题</th>
								<th data-options="field:'createDate',width:80,align:'center'">创建时间</th>
								<th data-options="field:'beginTime',width:80,align:'center'">开始时间</th>
								<th data-options="field:'endTime',width:80,align:'center'">结束时间</th>
								<th data-options="field:'status',width:80,align:'center',formatter:formatType">状态</th>
								<th data-options="field:'xx',width:100,align:'center',formatter:operator">操作</th>
							</tr>
						</thead>
					</table>
				</div>
			</div>
		</div>

	</div>
	
	<div id="edit_Lottery_window"></div>
	<div id="add_Lottery_window"></div>
	<script type="text/javascript">
	
	$("#edit_Lottery_window").dialog({
		title:"抽奖信息编辑",
	    width:1000,    
	    height:620,    
	    modal:true,
	    maximizable:false,
	    minimizable:false,
	    collapsible:false,
	    draggable:false,
	    resizable:false,
	    cache:false,
	    closed:true,
	});
	
		
		
$("#add_Lottery_window").dialog({
			title:"添加抽奖信息 ",
		    width:800,    
		    height:350,    
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
		    		$("#addLottery-from").submit();
		    	}
		    	},{
		    	text:'关闭',
		    	handler:function(){
		    		$("#add_Lottery_window").dialog('close')
		    		}
		    }]
		});
	
	function formatType(value, row, index){
 		return value==1?"启用":"未启用";
	}
	
	$("#doSearchBtn").click(function(){
		$("#lotterySearchForm").submit();
	});
	
	
	$("#lotterySearchForm input").keyup(function(event){
		  if(event.keyCode ==13){
			  $("#lotterySearchForm").submit();
		  }
	});
	
	$("#lotterySearchForm").submit(function(){
			var param = formToJson("#lotterySearchForm");
			$("#LotteryInfo_dg").datagrid({
				queryParams:param
			});
			return false;
	});
			
	function operator(value, row, index){
			var txt = row.status==0?'启用':'禁用';
			return	'<a href="javascript:void(0);" class="edit_a_group" onclick="editLotteryInfo('+row.id+')">编辑</a>'+
					'<a href="javascript:void(0);" class="edit_a_group" onclick="enable('+index+')">'+txt+'</a>';
		}
		
		//添加页
		function addLottery(){
			$("#add_Lottery_window").dialog('open').dialog('refresh','${path }/mag/addLottery');
		};
		//修改页
		function editLotteryInfo(id){
			$("#edit_Lottery_window").dialog('open').dialog('refresh','${path }/mag/editLottery?id='+id);
		};
 
	   //启用、禁用抽奖信息
    function enable(index){
    	var row = $("#LotteryInfo_dg").datagrid("getData").rows[index];
    	var txt = row.status==0?'启用成功！':'禁用成功！';
    	$.post("${path}/mag/editLotteryStatus",{id:row.id,status:row.status},function(data){
    		if(data==0){
    			ShowMessage(txt);
    			$("#LotteryInfo_dg").datagrid("reload");
    			$("#LotteryInfo_dg").datagrid('updateRow',{
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
