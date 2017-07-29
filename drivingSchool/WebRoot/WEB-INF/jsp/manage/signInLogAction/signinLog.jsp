<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/JSLib.jsp"%>


<body style="overflow:hidden;">
	<!-- 登录日志 -->
	<div id="center-log_manage_signin" class="easyui-layout" data-options="fit:true">
		<div class="" data-options="region:'north',border:false" style="overflow:hidden;padding-bottom:18px;">
			
			<div class="centermenu">
				<div class="center-menu center-menu_active" id="teacherSearch">
					<div class=""> 
						<span>教师登陆日志 </span>
					</div>
				</div>
	
			
				<div class="center-menu" id="studentSearch">
					<div class=""> 
						<span>学生登陆日志 </span>
					</div>
				</div>
			</div>
			
		</div>
		<div data-options="region:'center',border:false" style="">
			<div id="" class="easyui-layout" data-options="fit:true">
				<div class="center-filter clearfix" data-options="region:'north',border:false" style="">
					<button class="filter_button" type="button" id="delChecked">删除所选</button>
					<button class="filter_button" type="button" id="delAll">删除全部</button>
					
					<form id="log_manage_signin_form" class="filter_form" method="post">
						<span style="">从</span>
						<input class="easyui-datebox" editable="false" name="beginDate"></input>
						<span>至</span>
						<input class="easyui-datebox" editable="false" name="endDate"></input>
						
						<input class="search_button" type="button" id="doSearchBtn"/>
					</form>
				</div>
				<div data-options="region:'center',border:false" >
					<table id="log_manage_signin_dg"  title="" 
							data-options="nowrap:false,autoRowHeight:true,fit:true,fitColumns:true,rownumbers:true,singleSelect:false,pagination:true,
							method:'POST'">
						<thead>
							<tr>
								<th data-options="field:'ck',checkbox:true"></th>
	 							<th data-options="field:'userName',width:80,formatter:userText">用户名</th>
					            <th data-options="field:'loginIP',width:80,align:'left'">登录IP</th>
					            <th data-options="field:'loginTime',width:80,align:'left'">登录时间</th>
							</tr>
						</thead>
					</table>
				</div>
			</div>
		</div>
		
	</div>
	
	<script type="text/javascript">
		var currUserFlag = 2;
		function querySignIn(){
			var params = formToJson("#log_manage_signin_form");
			params['userFlag']=currUserFlag;
			refresh(params);
			$("#log_manage_signin_form").form("reset");
		}
		$("#doSearchBtn").click(function(){
			querySignIn();
		});
		
		$("#log_manage_exception_form").form({
			submit:function(){
				queryExc();
				return false;
			}
		});
		
		function userText(value,row,index){
			return value+"("+userType[row.roleType]+")";
		}
	
		
		function refresh(params){
			currUserFlag = params.userFlag;
			params['page'] = 1;
			params['rows'] = 10;
			console.log(params);
			$("#log_manage_signin_dg").datagrid({
				url:'${path }/mag/querySignInLogPage',
				queryParams:params
			});
		}
		
		//显示老师登录日志
		$("#teacherSearch").click(function(){
			refresh({"userFlag":2});
		});
		//显示学生登录日志
		$("#studentSearch").click(function(){
			refresh({"userFlag":1});
		});
		$("#teacherSearch").click();
		
		$("#delChecked").click(function(){
			var rows = $("#log_manage_signin_dg").datagrid("getChecked");
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
			var rows = $("#log_manage_signin_dg").datagrid("getChecked");
			del();
		});

		function del(param){
			$.messager.confirm(GV.title, '确认删除?', function(r){
				if (r){
					$.post("${path}/mag/delSignInLog",param,function(data){
						switch(data*1){
							case 0 :ShowMessage('删除成功!');$("#log_manage_signin_dg").datagrid("reload");break;
							case 1 :AlterMessage('删除失败!');break;
						}
					});
				}
			});
		}
	</script>
	
</body>
