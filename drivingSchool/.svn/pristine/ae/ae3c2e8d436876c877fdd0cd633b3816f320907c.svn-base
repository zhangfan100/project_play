<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/TagLib.jsp"%>
<body style="overflow:hidden;">
	<div id="center-comment_manage"  class="easyui-layout" data-options="fit:true">
			<div class="center-filter clearfix" data-options="region:'north',border:false" style="overflow: hidden;">
				<form id="comment_manage_form" class="filter_form">
					<span style="">从</span>
					<input class="easyui-datebox" editable="false" name="beginDate"></input>
					<span>至</span>
					<input class="easyui-datebox" editable="false" name="endDate"></input>
					<input class="search_input" type="text" name="keyWord" placeholder="输入关键字">
					<input class="search_button" type="button" id="doSearchBtn"/>
				</form>
			</div>
			<div data-options="region:'center',border:false" >
				<table id="comment_manage_dg" class="easyui-datagrid" title="" 
						data-options="nowrap:false,autoRowHeight:true,fit:true,fitColumns:true,rownumbers:true,singleSelect:false,pagination:true,
						url:'${path }/coh/queryCohLessonInfo?mode=2',method:'POST'">
					<thead>
						<tr>
							<th data-options="field:'lessonCode',width:100,align:'center'">课程编号</th>
							<th data-options="field:'stuName',width:50,align:'center'">学员姓名</th>
							<th data-options="field:'stuPhone',width:100,align:'center'">联系电话</th>
							<th data-options="field:'studyDate',width:100,align:'center'">上课日期</th>
							<th data-options="field:'time',width:90,align:'center'">上课时间</th>
						</tr>
					</thead>
				</table>
			</div>
	</div>
	<script type="text/javascript">
		
		function queryExc(){
			var param = formToJson("#comment_manage_form");
				$("#comment_manage_dg").datagrid({
					queryParams:param
				});
				$("#comment_manage_form").form("reset");
		}
		$("#doSearchBtn").click(function(){
			queryExc();
		});
		
		
		$("#comment_manage_form input").keyup(function(event){
			  if(event.keyCode ==13){
				  queryExc();
			  }
		});
		
	</script>
</body>

