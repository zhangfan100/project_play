<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/TagLib.jsp"%>
<body >
<div id="addCoachPaymentInfo" class="easyui-layout" data-options="fit:true,border:false" >
	    <div data-options="region:'center',border:false" style="padding:5px;padding-left:-50px;">
	    	<form method="POST" id="addCoachPaymentInfo-form">
	    		<input type="hidden" name="token" value="${token }"/>
	    		<input type="hidden" name="coachId"  id="coachId"/>
	    		<li class="form-item">
					<span class="title">教练姓名：</span>
					<span class="item">
					<input id="cohId" name="coachName" type="text" style="margin:0;width:376px;height:28px;">
					</span>
				</li>
	    		<li class="form-item">
					<span class="title">缴费项目：</span>
					<span class="item">
					  <input id="itemId" name="paymentItem" type="text" style="margin:0;width:200px;height:28px;">
					</span>
				</li>
	    		<li class="form-item">
					<span class="title">缴费项目：</span>
					<span class="item">
					  <input id="itemId1" name="paymentItem" type="text" style="margin:0;width:200px;height:28px;" placeholder="缴费项目任选一栏填写">
					</span>
				</li>
				<br>
	    		<li class="form-item">
					<span class="title">应缴金额：</span>
					<span class="item">878</span>
				</li>
	    		<li class="form-item">
					<span class="title">实缴金额：</span>
					<span class="item">
					  <input type="text" name="realCash" id="realCash" style="margin:0;width:200px;height:28px;" class="easyui-validatebox"  required="required"></input> 
					</span>
				</li>
	    		<li class="form-item">
					<span class="title">支付方式：</span>
					<span class="item">
					  <select type="text" name="payType" class="easyui-combobox" required="required" editable=false style="width:200px;height:28px;"  data-options="panelHeight:'auto'">
							<option value="1" >现金</option>
							<option value="2" >刷卡</option>
							<option value="3" >余额扣额</option>
					 </select>
					</span>
				</li>
	    	</form>
	    </div>
	</div>
	<script type="text/javascript">
	
	//搜索教练
	$("#cohId").combogrid({    
	    delay: 500,    
	    mode: 'remote',    
	    url: "${path}/mag/queryCoachByKeyWord",    
	    idField: 'name', 
	    textField: 'name',
	    fitColumns:true,
	    autoRowHeight:true,
	    rownumbers:true,
	    required:true,
	    fit:true,
	    columns: [[
					{field:'name',title:'姓名',width:60},
			        {field:'sex',title:'性别',width:40},
			        {field:'licenceCode',title:'身份证号',width:200},
			        {field:'phone',title:'电话',width:100}
			    ]],
	    onSelect:function(rowIndex, rowData){
	    	$("#coachId").val(rowData.id);
	    }
	});
	
	//搜索项目
	$("#itemId").combogrid({    
	    delay: 500,    
	    mode: 'remote',    
	    url: "${path}/mag/queryItemByKeyWord",    
	    idField: 'itemTag',    
	    textField: 'itemTag',
	    fitColumns:true,
	    rownumbers:true,
	    autoRowHeight:true,
	    fit:true,
	    columns: [[
					{field:'itemTag',title:'项目详细',width:200}
			    ]]
	});
	
	$("#realCash").numberbox({    
	    min:0,    
	    precision:2    
	}); 
	
	//表单提交
	$("#addCoachPaymentInfo-form").form({
		url:"${path}/mag/confirmAddCoachPayment",
		onSubmit: function(){
			if(!$("#addCoachPaymentInfo-form").form("validate")){
				return false;
			}else{
				var itemId = $("#itemId").combogrid("grid").datagrid("getSelected");	// 获取数据表格
				var itemId1 = $("#itemId1").val();
				if(itemId==null || itemId ==""){
					if(itemId1==null || itemId1==""){
						$.messager.alert("","请至少填写一个缴费项目框");
						return false;
					}
					$("#itemId").empty();
				}else{
					$("#itemId1").attr("name","paymentItem1");
				}
				return true;
			}
	    },
	    success:function(data){
	    	data=eval("("+data+")");
	    	if(data.status==1){
		    	$("#add_coachPaymentInfo_Window").dialog("close");
		    	$("#coachPaymentInfo-Grid").datagrid("reload");
		    	$.messager.show({
	        		title:'我的消息',
	        		msg:'添加成功！',
	        	});
	    	}else{
	    		$("#add_coachPaymentInfo_Window").dialog("close");
		    	$.messager.show({
	        		title:'我的消息',
	        		msg:'操作失败！',
	        	});
	    	}
	    }
	});
	</script>
</body>
