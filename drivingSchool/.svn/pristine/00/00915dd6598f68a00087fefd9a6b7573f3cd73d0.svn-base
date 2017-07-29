<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/TagLib.jsp"%>
  <body>
  	<div id="infoStudent">
		<div id="info">
			<form id="editIncomeItem-form" method="post" >
	    	<input type="hidden" value="${data.id}" name="id"/>
	    	<input type="hidden" name="token" value="${token }"/>
			<li class="form-item">
				<span class="title">收入项目标签：</span>
				<span class="item"><textarea type="text" cols="25" name="itemTag"  class="easyui-validateBox" required="required">${data.itemTag}</textarea></span>
			</li>
			<li class="form-item">
				<span class="title">收入所用类型：</span>
				<span class="item">
				   <select type="text" name="itemType" class="easyui-combobox" editable=false style="width:200px;height:28px;"  data-options="panelHeight:'auto'">
							<option value="1" ${data.itemType==1?'selected=selected':'' }>用于学生</option>
							<option value="2" ${data.itemType==2?'selected=selected':'' }>用于教师</option>
							<option value="3" ${data.itemType==3?'selected=selected':'' }>公用</option>
					</select>
			   </span>
			</li>
			</form>
		</div>
	</div>
	
	<script type="text/javascript">
	$("#editIncomeItem-form").form({
		url:"${path}/mag/submitEditIncomeItem",
		onSubmit: function(){
			if(!$("#editIncomeItem-form").form("validate")){
				return false;
			}else{
				return true;
			}
	    },
	    success:function(data){
	    	$("#edit_incomeItem_Window").dialog("close");
	    	$("#incomeItemManage-Grid").datagrid("reload");
	    	$.messager.show({
        		title:'我的消息',
        		msg:'修改成功！',
        	});
	    }
	});
	</script>
  </body>
