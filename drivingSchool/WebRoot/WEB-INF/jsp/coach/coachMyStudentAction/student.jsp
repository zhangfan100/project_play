<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/JSLib.jsp"%>

<body style="overflow:hidden;">

	<div id="center-comment_manage"  class="easyui-layout" data-options="fit:true">
		<div data-options="region:'center',border:false" style="" >
			<div id="" class="easyui-layout" data-options="fit:true" >
				<div class="center-filter clearfix" data-options="region:'north',border:false" >
					<form id="comment_manage_form" class="filter_form">
						<span style="">从</span>
						<input class="easyui-datebox" editable="false" name="beginDate"></input>
						<span>至</span>
						<input class="easyui-datebox" editable="false" name="endDate"></input>
						
						<input class="search_input" type="text" name="keyWord" placeholder="输入学员姓名或编号">
						<input class="search_button" type="button" id="doSearchBtn"/>
					</form>
				</div>
				<div data-options="region:'center',border:false" >
					<table id="comment_manage_dg" class="easyui-datagrid" title="" 
							data-options="nowrap:false,autoRowHeight:true,fit:true,fitColumns:true,rownumbers:true,singleSelect:false,pagination:true,
							url:'${path }/coh/queryMyStudentPage',method:'POST'">
						<thead>
							<tr>
								<th data-options="field:'id',width:40,align:'center'">编号</th>
								<th data-options="field:'name',width:50,align:'left'">姓名</th>
								<th data-options="field:'sex',width:40,align:'center',formatter:formatSex">性别</th>
								<th data-options="field:'phone',width:80,align:'left'">电话</th>
								<th data-options="field:'licenceCode',width:80,align:'left'">身份证号码</th>
								<th data-options="field:'address',width:150,align:'left'">住址</th>
								<th data-options="field:'createDate',width:80,align:'center'">报名日期</th>
							</tr>
						</thead>
					</table>
				</div>
			</div>
			
		</div>

	</div>
	<script type="text/javascript">
		
	function formatSex(value, row, index){
		return value?"男":"女";
	}
		//过滤列，操作
		function formattrOperator(value,row,index){
			var text = row.isDisplay==0?'隐藏':'显示';
			var hideComment = "<a class='comment_a_reply' rindex='"+index+"' href='javascript:void(0);' onclick='hideComment(this)'>"+text+"</a>";
			return hideComment+"&nbsp;&nbsp;<a class='comment_a_reply' href='javascript:reply("+row.id+")'>评论</a>";
		}
	
		
		
		$("#doSearchBtn").click(function(){
			$("#comment_manage_form").submit();
		});
		
		
		$("#comment_manage_form input").keyup(function(event){
			  if(event.keyCode ==13){
				  $("#comment_manage_form").submit();
			  }
		});
		
		$("#comment_manage_form").submit(function(){
				var param = formToJson("#comment_manage_form");
				$("#comment_manage_dg").datagrid({
					queryParams:param
				});
				return false;
		});
		
	</script>
</body>