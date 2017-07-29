<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/JSLib.jsp"%>
<body>
<style>
.common_title_Tag{
	background-color: #6e8acc;
	height: 46px;
}
.common_title_Tag>div{
	height: 46px;
	line-height: 46px;
	overflow:hidden;
}
.common_title_Tag>.left_Attr{
	float: left;
}
.common_title_Tag>.right_Attr{
	float: right;
}
.common_title_Tag>.common_title_text{
	color: white;
	font-weight: bold;
	font-size: 15px;
	margin: auto 30px ;
}
.common_title_Tag>.common_param_text{
	color: white;
	font-size: 15px;
	margin: auto 30px auto 0px;
}
.common_title_Tag>.common_param_input>*{
	height: 26px;
	margin: 10px auto auto auto;
}
.search_button{
	margin: 8px 20px auto auto;
}
.form-item{
	width: 400px;
	margin-top: 20px;
}
.curr-box{
	width: 200px;
}
.curr_btn{
	margin-top: 50px;
	width: 120px;
	height: 50px;
	font-size: 20px;
	font-weight: bold;
}
.curr_submit_btn{
	color: white;
	background-color: #FF9039;
}
</style>
<div class="easyui-layout" data-options="fit:true" >
	<div class="common_title_Tag" data-options="region:'north',border:false">
		<div class="common_title_text left_Attr">薪资结算</div>
		<div class="common_param_text left_Attr">人员类型：</div>
		<div class="common_param_input left_Attr">
			<select style="width: 100px;" id="type">
				<option value=2>管理员</option>
				<option value=1>教练</option>
			</select>
		</div>
		<div class="right_Attr" >
			<input type="button" class="search_button">
		</div>
		<div style="margin-right: 10px;" class="common_param_input right_Attr">
			<input type="text" class="easyui_validatebox" placeholder="姓名/编号" id="search" >
		</div>
		<div style="margin-right: 15px;" class="common_param_text right_Attr">人员姓名：</div>
	</div>
	<script type="text/javascript">
	
	$("#type").change(function(){
		if(this.value==2){
		  $("#search").combogrid({url:"${path}/mag/querySysByKeyWord"});
		}else{
		  $("#search").combogrid({url:"${path}/mag/queryCoachByKeyWord"});
		}
	});
	
	$("#search").combogrid({    
		delay: 500,    
	    mode: 'remote',    
	    url: "${path}/mag/querySysByKeyWord",    
	    idField: 'id', 
	    textField: 'name',
	    fitColumns:true,
	    autoRowHeight:true,
	    rownumbers:true,
	    required:true,
	    fit:true,
	    columns:[[    
	        {field:'name',title:'姓名',width:60}  
	    ]],
	    onSelect:function(rowIndex, rowData){
	    	var param;
	    	if($("#type").val()==1){
		    	param={
		    		type:$("#type").val(),
		    		coachId:rowData.id
		    	};
	    	}else{
	    		param={
			    		type:$("#type").val(),
			    		adminId:rowData.id
			    	};
	    	}
	    	
	    	cancel();
	    	
	    	$("#personInfoTable").datagrid({
	    		queryParams: param,
	    		url:"${path}/mag/fillFinancialDetail"
	    	});
	    }
	});  

	function cancel(){
		$("#userId").val("");
		$("#name").val("");
		$("#code").val("");
		$("#type1").val("");
		$("#cash").val("");
		$("#realCash").val("");
		$("#personInfoTable").datagrid('loadData', { total: 0, rows: [] });
    	$("#salaryBeginTime").datebox('setValue', "");
    	$("#salaryEndTime").datebox('setValue', "");
	}
	
	</script>
	<div data-options="region:'center',border:false" >
		<div class="easyui-layout" data-options="fit:true" >
			<div  data-options="region:'north',border:true" style="height: 500px;">
				<div class="easyui-layout" data-options="fit:true" >
					<div data-options="region:'north',border:true" style="height: 100px;">
					<table id="personInfoTable"></table>
					</div>
					<div data-options="region:'center',border:true" style="text-align: center;" >
					<form id="paymentCash-form" method="post">
					  <input type="hidden" name="userId" id="userId"/>
					  <input type="hidden" name="name" id="name"/>
					  <input type="hidden" name="lastPayTime" id="lastPayTime"/>
					  <input type="hidden" name="code" id="code"/>
					  <input type="hidden" name="type" id="type1"/>
					  <input type="hidden" name="cash" id="cash"/>
						<li class="form-item">
							<span class="title">计薪开始时间：</span>
							<span class="item">
								<input type="text" name="salaryBeginTime" data-options="required:true" disabled=true class="easyui-datebox curr-box" id="salaryBeginTime"/>
							</span>
						</li>
			    		<li class="form-item">
							<span class="title">计薪结束时间：</span>
							<span class="item">
								<input type="text" name="salaryEndTime" data-options="required:true" disabled=true class="easyui-datebox curr-box" id="salaryEndTime"/>
							</span>
						</li>
			    		<li class="form-item">
						</li>
						<br>
			    		<li class="form-item">
							<span class="title">实发工资：</span>
							<span class="item">
								<input type="text" name="realCash" id="realCash" class="easyui-numberbox" style="width: 200px;height: 20px;" data-options="min:0,precision:2,required:true"></input>  
							</span>
						</li>
			    		<li class="form-item">
							<span class="title">发放状态：</span>
							<span class="item">
								<select style="width: 100px;" name="status" id="status1">
									<option value="1">已发放</option>
									<option value="0">未发放</option>
								</select>
							</span>
						</li>
			    		<li class="form-item">
			    			<span class="title">结算方式：</span>
							<span class="item">
								<select style="width: 100px;" name="payWay" id="payWay">
									<option value="2">银行</option>
									<option value="1">现金</option>
								</select>
							</span>
						</li>
					</form>
					</div>
				</div>
			</div>
			<div data-options="region:'center',border:false" style="text-align: center;" >
				<input class="curr_btn curr_submit_btn" style="margin-right: 100px;" type="button" value="确      定"  id="confirm">
				<input class="curr_btn" type="button" value="重      置" id="cancel">
			</div>
		</div>
	</div>
</div>
<div id="showInfo"></div>
<script type="text/javascript">
$("#personInfoTable").datagrid({    
    method:'post',
	autoRowHeight:true,
	fit:true,
	fitColumns:true,
	collapsible:true,
	method:"POST",
    columns:[[    
        {field:'coachCode',title:'编号',width:60,align:'center'},
        {field:'name',title:'姓名',width:60,align:'center'},
        {field:'salaryType',title:'职务',width:80,align:'center',formatter:salaryTypeFormatter},
        {field:'payTime',title:'上次结薪时间',width:60,align:'center'},
        {field:'cash',title:'应发工资',width:60,align:'center'}
    ]]
});

function salaryTypeFormatter(value, row, index){
	if(row.salaryStatus==0){//未领取
		$("#status1 option").eq(1).attr("selected","selected");
	}else{
		$("#status1 option").eq(0).attr("selected","selected");
	}
	$("#userId").val(row.userId);
	$("#lastPayTime").val(row.payTime);
	$("#name").val(row.name);
	if(row.salaryType==1){//教练
	  $("#code").val(row.coachCode);
	}
	$("#type1").val(value);
	$("#cash").val(row.cash);
	
	$("#salaryBeginTime").datebox('setValue', row.salaryBeginTime);
	$("#salaryEndTime").datebox('setValue', row.salaryEndTime);
	return value==1?"教练":"管理员";
}

$("#cancel").bind("click",function(){
	cancel();
});

$("#confirm").bind("click",function(){
	$("#showInfo").dialog('open').dialog('refresh','${path}/mag/queryFinancialInfo');
});

$("#paymentCash-form").form({
	url:"${path}/mag/paySalarySubmit",
	onSubmit: function(){
		if(!$("#paymentCash-form").form("validate")){
			return false;
		}else{
			return true;
		}
    },
    success:function(data){
    	data=eval("("+data+")");
    	cancel();
    	if(data.status==1){
	    	$.messager.show({
        		title:'我的消息',
        		msg:'操作成功！',
        	});
    	}else{
	    	$.messager.show({
        		title:'我的消息',
        		msg:'操作失败！',
        	});
    	}
    }
});

$("#showInfo").dialog({
	title:"信息确认",
    width:300,    
    height:500,    
    maximizable:false,
    minimizable:false,
    resizable:false,
    cache:false,
    closed:true,
    buttons: [
    {
    	text:"提交",
    	handler:function(){
    		$("#showInfo").dialog("close");
    		//表单提交
    		$("#paymentCash-form").submit();
        }
    },{
    	text:"取消",
    	handler:function(){
    		$("#showInfo").dialog("close");
        }
    }] 
});
</script>
</body>
