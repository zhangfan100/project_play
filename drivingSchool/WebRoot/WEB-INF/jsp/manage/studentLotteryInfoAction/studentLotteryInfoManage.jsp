<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/TagLib.jsp"%>
  <body>
  	
	<!--抽奖记录 -->
	<div id="studentLotteryInfo" class="easyui-layout" data-options="fit:true" >

		<div data-options="region:'center',border:false" style="">
			<div id="" class="easyui-layout" data-options="fit:true">
				<div class="center-filter clearfix" data-options="region:'north',border:false">
					<span class="table-title">抽奖记录</span>
					<form id="stuSearchForm" class="filter_form" method="post">
						<input class="search_input" name="keyWord" style="width:200px;" type="text" placeholder="姓名">
						<button class="search_button" type="button" id="doSearchBtn"></button>
					</form>
				</div>
				<div data-options="region:'center',border:false" >
					<table id="studentLotteryInfo_dg" class="easyui-datagrid"
							data-options="nowrap:false,autoRowHeight:true,fit:true,fitColumns:true,rownumbers:true,singleSelect:true,collapsible:true,pagination:true,
							url:'${path }/mag/querystudentLotteryInfoPage',method:'post'">
						<thead>
							<tr>
								<th data-options="field:'stuLotteryCode',width:80,align:'center'">抽奖编号</th>
								<th data-options="field:'name',width:80,align:'center'">姓名</th>
								<th data-options="field:'phone',width:80,align:'center'">手机号</th>
								<th data-options="field:'title',width:80,align:'center'">抽奖类别</th>
								<th data-options="field:'prizeName',width:80,align:'center'">奖品名称</th>
								<th data-options="field:'status',width:80,align:'center',formatter:formatType">是否兑奖</th>
								<th data-options="field:'createTime',width:80,align:'center'">抽奖时间</th>
								<th data-options="field:'xx',width:100,align:'center',formatter:operator">操作</th>
							</tr>
						</thead>
					</table>
				</div>
			</div>
		</div>

	</div>
	<script type="text/javascript">
	
	function formatType(value, row, index){
 		return value==1?"已兑奖":"未兑奖";
	}
	
	$("#doSearchBtn").click(function(){
		$("#stuSearchForm").submit();
	});
	
	
	$("#stuSearchForm input").keyup(function(event){
		  if(event.keyCode ==13){
			  $("#stuSearchForm").submit();
		  }
	});
	
	$("#stuSearchForm").submit(function(){
			var param = formToJson("#stuSearchForm");
			$("#studentLotteryInfo_dg").datagrid({
				queryParams:param
			});
			return false;
	});
 	
	function operator(value, row, index){
			var txt = row.status==0?'兑奖':'';
			return '<a href="javascript:void(0);" class="edit_a_group" onclick="enable('+index+')">'+txt+'</a>';
		}
		
		
	   //是否已兑奖
    function enable(index){
    	var row = $("#studentLotteryInfo_dg").datagrid("getData").rows[index];
    	var txt = row.status==1?'':'兑奖成功!';
    	$.post("${path}/mag/editStudentLotteryStatus",{id:row.id,status:row.status},function(data){
    		if(data==0){
    			ShowMessage(txt);
    			$("#studentLotteryInfo_dg").datagrid('updateRow',{
    				index: index,
    				row: {
    					status: row.status==1?0:1
    				}
    			});
    		}else{
    			AlterMessage(txt);
    		}
    	});
    }
		
	</script>
  </body>
