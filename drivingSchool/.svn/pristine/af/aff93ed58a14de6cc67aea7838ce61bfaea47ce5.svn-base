<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/TagLib.jsp"%>


<body>
	<div class="center-filter clearfix" data-options="region:'north',border:false" style="overflow: hidden;">
	  <button class="filter_button" type="button" onclick="editSettingClick()" >编辑课程</button>
	</div>
	<table id="dg"></table>  
	<div id="edit_setting_window" class="easyui-dialog" title="编辑"  style="color:#5d5c5c;width:700px;height:330px;" 
				data-options="iconCls:'icon-save',resizable:true,closed:true,maxed:true,modal:true,buttons:[{
						text:'保存',
						handler:saveSetting
					},{
						text:'取消',
						handler:function(){$('.panel-tool-close').click();}
					}]">
	</div>
<script type="text/javascript">
	$("#dg").datagrid({    
	    url:"${path}/coh/queryAllWeekSetting",    
	    columns:[[   
	        {field:'id',checkbox:true},
	        {field:'weekDay',title:"选择的星期",align:"center",width:200,formatter:weekDayFormatter},    
	        {field:'timeSlot',title:"选择的时间",align:"center",width:200,formatter:timeSlotFormatter},    
	        {field:'subject',title:"选择的科目",align:"center",width:200,formatter:subjectFormatter},    
	        {field:'timeSlotType',title:"时段模式",align:"center",width:250,formatter:timeSlotTypeFormatter}, 
	        {field:'op',title:"操作",align:"center",width:300,formatter:opFormatter}   
	    ]],
	    singleSelect:true,
	    fit:true,
	    rownumbers:true,
	    checkOnSelect:true,
		selectOnCheck:true,
		onCheck:function(rowIndex,rowData) {
			if(rowData.timeSlotType=="1"){
				$("#dg").datagrid("uncheckRow", rowIndex);
				$.messager.alert("","驾校分配模式不允许编辑！");
			}
		}
	});  
	
	function weekDayFormatter(value, row, index){
		return	row.weekDay=="0"?"星期天":row.weekDay=="1"?"星期一":
			    row.weekDay=="2"?"星期二":row.weekDay=="3"?"星期三":
				row.weekDay=="4"?"星期四":row.weekDay=="5"?"星期五":"星期六";
    };
    
	function timeSlotFormatter(value, row, index){
		return	row.timeSlot=="1"?"上午":"下午";
    };
    
	function subjectFormatter(value, row, index){
		return	row.subject=="1"?"科目二":row.subject=="2"?"科目三":"重置待分配";
    };
    
    //判断是否应该显示编辑选项
    function timeSlotTypeFormatter(value,row,index){
		return row.timeSlotType=="1"?"驾校分配模式":"教练自主模式";
    }
    
	function opFormatter(value, row, index){
		if (row.timeSlotType=="2"){//教练自主模式
		   return '<a href="javascript:void(0);" class="edit_a_group" onclick="editSetting('+row.id+')">编辑</a>';
		}
    };
    
    //编辑
    function editSetting(id){
    	$("#edit_setting_window").dialog('open').dialog('refresh','${path}/coh/editSettingInfo?id='+id);
    }
    
    //上面的编辑按钮选项
    function editSettingClick(){
		var data = $("#dg").datagrid("getSelected");
		if(data==null){
			$.messager.alert("","请选择要编辑的信息！");
		}else{
			if(data.timeSlotType=="1"){//点击了驾校分配模式  但是选择框没有显示 如果按了编辑 还是选择的驾校分配模式
				return;
			}
			editSetting(data.id);
		}
		
	}
    
    //保存修改
    function saveSetting(){
    	//把表格的数据弄成json格式
    	var param = formToJson("#editStudent #editStu-form");
    	//发送ajax保存数据
    	$.post("${path}/coh/editSettingSubmit",param,function(data){
    		if(data==0){
    			$('.panel-tool-close').click();
    			//刷新数据
				$("#dg").datagrid("load","${path}/coh/queryAllWeekSetting"); 
    			ShowMessage("保存成功！");
    		}else{
    			AlterMessage("保存异常！");
    		}
    	});
    }
</script>
</body>
