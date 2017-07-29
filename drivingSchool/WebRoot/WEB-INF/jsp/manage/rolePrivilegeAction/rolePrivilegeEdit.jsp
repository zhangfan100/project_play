<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/TagLib.jsp"%>
<body>
	<link rel="stylesheet"
		href="${path}/static/scripts/ztree/css/zTreeStyle/zTreeStyle.css"
		type="text/css">
	<script type="text/javascript"
		src="${path}/static/scripts/ztree/jquery.ztree.all-3.5.min.js"></script>
	<ul id="roleTree" class="ztree"></ul>
	<script type="text/javascript">
		var setting = {
			view : {
				showIcon : false
			},
			data : {
				simpleData : {
					enable : true,
					idKey : "id",
					pIdKey : "pid",
					rootPId : 0,
				},
				key: {
					checked: "checked",
					name: "title",
					title: "title"
				}
			},
			//开启选中
			check : {
				enable : true,
				chkStyle : "checkbox"
			},
			callback : {
				//禁止折叠
				beforeCollapse : function() {
					return true;
				}
			}
		};
		var zNodes =<c:if test="${rolePrivilege eq null}">[]</c:if><c:if test="${rolePrivilege ne null}">${rolePrivilege}</c:if>;
		$(document).ready(function(){
			$.fn.zTree.init($("#roleTree"), setting, zNodes);
		});
		function saveRolePrivilege(){
			var treeObj = $.fn.zTree.getZTreeObj("roleTree");
			var nodes = treeObj.getChangeCheckedNodes();
			$.ajax({
				type:"post",
				url :"${path}/mag/rolePrivilegeEditSubmit",
				data:{
					rolePrivilege:JSON.stringify(nodes),
					roleId:${roleId}
				},
				success:function(data){
					if(data==1){
						$.messager.confirm("","修改成功<br>是否退出编辑？",function(r){
							if(r){
								$("#roleTreeWindow").dialog("close");
							}
						});
					}
				}
			});
		}
	</script>
</body>