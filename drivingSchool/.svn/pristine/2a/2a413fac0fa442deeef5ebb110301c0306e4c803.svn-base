<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/TagLib.jsp"%>
<body>
	<form id="salaryInfo-Form" method="get" >
		<input type="hidden" id="id" name="id" value="${id}" >
		<input type="hidden" id="userId">
		<input type="hidden" name="token" value="${token }" />
		<br/>
		<br/>
		<li class="form-item">
			<span class="title">人员类型：</span>
			<span class="item">
				<input type="radio" value='1' name="salaryType" id="sta1" />&nbsp;<label for="sta1">教练</label>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" value='2' name="salaryType" id="sta2" />&nbsp;<label for="sta2">管理</label>
			</span>
		</li>
		<li class="form-item">
			<span class="title">姓名：</span>
			<span class="item">
			 <input id="name" type="text" name="name"/>
			</span>
		</li>
		<li class="form-item">
			<span class="title">当前薪资：</span>
			<span class="item">
			  <label id="cash"></label>
			</span>
		</li>
		<br>
		<li class="form-item">
			<span class="title">上次生效日期：</span>
			<span class="item">
			 <label id="inuseTime"></label>
			</span>
		</li>
		<br>
		<li class="form-item">
			<span class="title">新的薪资：</span>
			<span class="item">
				<input id="newCash" name="newCash" type="text" class="easyui-validatebox"  required="required"/> 
			</span>
		</li>
		<li class="form-item">
			<span class="title">此次生效日期：</span>
			<span class="item">
			  <input  name="inuseTime" type="text" class="easyui-datebox" required="required"/> 
			</span>
		</li>
		
	</form>
	<script type="text/javascript">
	$(document).ready(function(){
		selectSalaryType();
	});
	
	var id;//用来记录id的值
	var infoType=${infoType eq null?1:infoType};//用来记载人员类型 默认是教练
	
	$("#newCash").numberbox({    
	    min:0,    
	    precision:2    
	}); 
	
	//类型改变事件
	$("input[name='salaryType']").change(function(){
		initData("", "", this.value==1?true:false, "");
		var type = this.value;
		
		//加载姓名
		$("#name").combogrid({    
		    delay: 500,    
		    mode: 'remote',    
		    url: "${path}/mag/querySalaryInfoPage?infoType="+type,    
		    idField: 'id',    
		    textField: 'name',
		    fitColumns:true,
		    autoRowHeight:true,
		    required:true,
		    fit:true,
		    columns: [[
						{field:'name',title:'姓名',width:200,align:'center'}
		    ]]
		});  
	});
		
	//选择人员类型
	function selectSalaryType(){
		infoType=${infoType eq null?1:infoType};
		$("input[name='salaryType'][value='"+infoType+"']").attr("checked","checked");
	}
	
	//加载姓名
	$("#name").combogrid({    
	    delay: 500,    
	    mode: 'remote',    
	    url: "${path}/mag/querySalaryInfoPage?infoType="+infoType,    
	    idField: 'id',    
	    textField: 'name',
	    fitColumns:true,
	    autoRowHeight:true,
	    required:true,
	    fit:true,
	    columns: [[
					{field:'name',title:'姓名',width:200,align:'center'}
	    ]],
	    onLoadSuccess:function(){
	    	var selectId = $("#id").val();
	    	id = selectId;
	    	$("#id").val("");//清空他的值
	    	if(selectId!=null && selectId !=""){
		        //默认选择的
		    	$("#name").combogrid("grid").datagrid("selectRecord",selectId);
	    	}
	    },
	  	onSelect:function(rowIndex, rowData){
	  		id = rowData.id;
	  		initData(rowData.cash, rowData.inuseTime,rowData.salaryType==1?true:false,rowData.userId);
	    },
	    onChange:function(newVal,oldVal){
	    	if(newVal==null || newVal==""){//意味招没有选择
	    		initData("", "",true,"");	
	    	}else{
	    		id=newVal;
	    	}
	    }
	});
	
	
	//初始化数据  默认选择教练
	function initData(cash,inuseTime,infoType,userId){
		//$("#name").combogrid('setValue', "");
		$("#cash").text(cash);//设置当前薪资
  		$("#inuseTime").text(inuseTime);//设置薪资生活日期
  		var infoType=infoType?1:2;
  		if(infoType==1){//教练
  			$("#userId").attr("name","coachId");
  		}else{
  			$("#userId").attr("name","adminId");
  		}
  		$("#userId").val(userId);
  		//$("#name").combogrid('setValue', "");
		//$("input[name='salaryType'][value='"+infoType+"']").attr("checked","checked");
	}
	
	//表单提交
	$("#salaryInfo-Form").form({
		url:"${path}/mag/editSalaryInfoSubmit",
		onSubmit: function(){
			if(!$("#salaryInfo-Form").form("validate")){
				return false;
			}
			$("#id").val(id);
			return true;
		    },
	    success:function(data){
	    	data=eval("("+data+")");
		    $("#editSalaryInfoWindow").dialog("close");
	    	if(data.status==1){
		    	$("#salaryInfoManage-Grid").datagrid("reload");
		    	$.messager.show({
	        		title:'我的消息',
	        		msg:'修改成功！',
	        	});
	    	}else{
		    	$.messager.show({
	        		title:'我的消息',
	        		msg:'操作失败！',
	        	});
	    	}
	    }
	});
	</script>
</body>
