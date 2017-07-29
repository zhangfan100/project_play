<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/TagLib.jsp"%>
<body >
<div id="addIncomeItem" class="easyui-layout" data-options="fit:true,border:false" >
	    <div data-options="region:'center',border:false" style="padding:5px;padding-left:-50px;">
	    	<form method="POST" id="addIncomeItem-form">
	    		<input type="hidden" name="token" value="${token }"/>
	    		<li class="form-item">
					<span class="title">收入标签：</span>
					<span class="item">
					<textarea  name="itemTag" class="easyui-validateBox" required="required" cols="25" style="width:200px;height:28px;"/></span>
				</li>
				<li class="form-item">
					<span class="title">收入类型：</span>
					<span class="item">
						<select type="text" name="itemType" class="easyui-combobox" required="required" editable=false style="width:200px;height:28px;"  data-options="panelHeight:'auto'">
							<option value="3" >公用</option>
							<option value="1" >用于学生</option>
							<option value="2" >用于教师</option>
					</select></span>
				</li>
	    	</form>
	    </div>
	</div>
	<script type="text/javascript">
	$("#addIncomeItem-form").form({
		url:"${path}/mag/confirmAddIncomeItem",
		onSubmit: function(){
			if(!$("#addIncomeItem-form").form("validate")){
				return false;
			}else{
				return true;
			}
	    },
	    success:function(data){
	    	$("#add_incomeItem_Window").dialog("close");
	    	$("#incomeItemManage-Grid").datagrid("reload");
	    	$.messager.show({
        		title:'我的消息',
        		msg:'添加成功！',
        	});
	    }
	});
	</script>
</body>
