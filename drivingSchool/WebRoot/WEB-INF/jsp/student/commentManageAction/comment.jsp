<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/TagLib.jsp"%>

<body style="overflow:hidden;">

	<div id="center-comment_manage"  class="easyui-layout" data-options="fit:true">
		<div data-options="region:'center',border:false" style="" >
			<div id="" class="easyui-layout" data-options="fit:true" >
				<div class="center-filter clearfix" data-options="region:'north',border:false" >
					<button class="filter_button" type="button" id="delChecked">删除所选</button>
					<button class="filter_button" type="button" id="delAll">删除全部</button>
					
					<form id="comment_manage_form" class="filter_form">
						<span style="">从</span>
						<input class="easyui-datebox" editable="false" name="beginDate"></input>
						<span>至</span>
						<input class="easyui-datebox" editable="false" name="endDate"></input>
						
						<input class="search_input" type="text" name="keyWord" placeholder="评论内容">
						<input class="search_button" type="button" id="doSearchBtn"/>
					</form>
				</div>
				<div data-options="region:'center',border:false" >
					<table id="comment_manage_dg" class="easyui-datagrid" title="" 
							data-options="nowrap:false,autoRowHeight:true,fit:true,fitColumns:true,rownumbers:true,singleSelect:false,pagination:true,
							url:'${path }/mag/queryCommentPage',method:'POST',onClickCell: onClickCell">
						<thead>
							<tr>
								<th data-options="field:'ck',checkbox:true,width:50"></th>
								<th data-options="field:'teaName',width:50,align:'center'">教练</th>
								<th data-options="field:'stuName',width:50,align:'center'">评论用户</th>
								<th data-options="field:'content',width:250,align:'left'">评论内容</th>
								<th data-options="field:'totalScore',width:50,align:'center'">评价分数</th>
								<th data-options="field:'reviewTime',width:90,align:'center'">评价时间</th>
								<th data-options="field:'xx',width:100,align:'center',formatter:formattrOperator">操作</th>
							</tr>
						</thead>
					</table>
				</div>
			</div>
			
			<div id="comment_window" class="easyui-window" title="评论回复" data-options="cache:false,modal:true,border:false,shadow:false,collapsible:false,minimizable:false,maximizable:false,closed:true,iconCls:'icon-save'" style="width:772px;height:315px;font-size:16px;font-weight:bold;color:#5d5c5c;">
				<form id="replySubmitForm">
					<input class="id" name="id" style="display:none;"/>
					<input name="reviewId" style="display:none;"/>
					<div style="height:26px"></div>
					<textarea id="reply_content" type="text" maxlength="200" name="replyContent" style="margin:20px 0 20px 40px;width:681px;height:114px"></textarea>
					<span style="margin-left:47px;margin-right:500px;">限200字</span>
					<button id="comment_reply_button" name="" type="button" onclick="submitCommentReply()">回复</button>
				</form>
			</div>
		</div>

	</div>
	<script type="text/javascript">
	
		
		
		//提交回复
		function submitCommentReply(){
			var param = formToJson("#replySubmitForm");
			$.post("${path}/mag/updateReply",param,function(data){
				if(data==0){
					$('#comment_window').window('close');
					ShowMessage("评论成功!");
				}else{
					AlterMessage("评论失败!");
				}
			});
		}
		
		function onClickCell(index, field){
			
		}
		
		//过滤列，操作
		function formattrOperator(value,row,index){
			var text = row.isDisplay==0?'隐藏':'显示';
			var hideComment = "<a class='comment_a_reply' rindex='"+index+"' href='javascript:void(0);' onclick='hideComment(this)'>"+text+"</a>";
			return hideComment+"&nbsp;&nbsp;<a class='comment_a_reply' href='javascript:reply("+row.id+")'>评论</a>";
		}
		
		function hideComment(obj){
			var _this = $(obj);
			var index = _this.attr("rindex");
			var data = $("#comment_manage_dg").datagrid("getRows");
			var row = data[index*1];
			row.isDisplay = row.isDisplay==1?0:1;
			var param = {"ids":row.id,"isDisplay":row.isDisplay};
			$.post("${path}/mag/hideComment",param,function(data){
				$("#comment_manage_dg").datagrid();
			});
		}
		
		$("#delChecked").click(function(){
			var rows = $("#comment_manage_dg").datagrid("getChecked");
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
			del();
		});
	
		function del(param){
			$.messager.confirm(GV.title, '确认删除?', function(r){
				if (r){
					$.post("${path}/mag/delComment",param,function(data){
						switch(data*1){
							case 0 :ShowMessage('删除成功!');$("#comment_manage_dg").datagrid("reload");break;
							case 1 :AlterMessage('删除失败!');break;
						}
					});
				}
			});
		}
		
	
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
		
		//回复操作
		function reply(reviewId){		 
			$('#comment_window').window('open');
			var _window = $("#replySubmitForm").form("reset");
			$.post("${path}/mag/queryReply",{"reviewId":reviewId},function(data){
				_window.find("[name='id']").val("");
				_window.find("[name='replyContent']").html("");
				_window.find("[name='reviewId']").val(reviewId);
				if(data){
					data = $.parseJSON(data);
					_window.find("[name='id']").val(data.id);
					_window.find("[name='replyContent']").focus().html(data.replyContent);
				}
				_window.find("[name='replyContent']").focus();
			});
				
        }
	</script>
</body>