<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/TagLib.jsp"%>
<body >
	<div class="easyui-layout" data-options="fit:true">
		<div data-options="region:'center',border:false" style="">
			<div id="" class="easyui-layout" data-options="fit:true">
				<div class="center-filter clearfix" data-options="region:'north',border:false" style="">
					<button class="filter_button" type="button" onclick="lessonInfoAdd()" >预约选课</button>
					<button class="filter_button" type="button" onclick="cancelSelectLessonInfo()" >取消预约</button>
				</div>
				<div data-options="region:'center',border:false" >
					<table id="lessonInfoManageGrid" class="easyui-datagrid" title="" 
							data-options="
							nowrap:false,
							autoRowHeight:true,
							fit:true,
							fitColumns:true,
							rownumbers:true,
							pagination:true,
							url:'${path }/mag/queryLessonInfoPage',method:'POST'">
						<thead>
							<tr>
								<th data-options="field:'id',checkbox:true"></th>
								<th data-options="field:'lessonCode',width:80,align:'center'">课程编号</th>
								<th data-options="field:'stuName',width:80,align:'center'">学生姓名</th>
								<th data-options="field:'subject',width:80,align:'center',formatter:subjectFormatter">上课科目</th>
								<th data-options="field:'beginTime',width:100,align:'center',formatter:dateFormatter">上课日期</th>
								<th data-options="field:'title',width:100,align:'center',formatter:timeFormatter">上课时段</th>
								<th data-options="field:'planWay',width:100,align:'center',formatter:planWayFormatter">预约方式</th>
								<th data-options="field:'lessonStatus',width:100,align:'center',formatter:statusFormatter">状态</th>
								<th data-options="field:'cashStatus',width:100,align:'center',formatter:cashStatusFormatter">付款状态</th>
								<th data-options="field:'operation',width:120,align:'center',formatter:operationFormatter">操作</th>
							</tr>
						</thead>
					</table>
				</div>
			</div>
		</div>
		
		<div id="payment_window" class="easyui-dialog" title="缴费"  style="color:#5d5c5c;width:600px;height:450px;" 
				data-options="iconCls:'icon-save',resizable:true,closed:true,maxed:true,modal:true,buttons:[{
						text:'保存',
						handler:function(){
						 $('#infoLesson-Form').submit();
						}
					},{
						text:'取消',
						handler:function(){$('.panel-tool-close').click();}
					}]">
			</div>
		
	</div>
	<div id="showLessonInfoWindow"></div>
	
	<div id="showPaymentInfo_window"></div>
	
	<div id="editLessonInfoWindow" style=""></div>
	<script type="text/javascript">
	function operationFormatter(value,row,index){
		var returnStr;
		if(row.lessonStatus==1 && row.coachId==undefined){
			returnStr="<a class='edit_a_group' onclick='cancelLessonPlan("
				+row.id
				+")'  href='javascript:void(0)'>取消</a>";
		}
		if(row.lessonStatus==2){
			returnStr=
				"<a class='edit_a_group' onclick='showLessonInfoDetail("
				+row.id
				+")'  href='javascript:void(0)'>查看详情</a>";
		}
		if(row.cashStatus==0 && row.coachId==undefined && row.lessonStatus==2){
			returnStr += '<a href="javascript:void(0);" class="edit_a_group" onclick="getPaymentInfo('+row.id+','+row.cash+')">缴费</a>';
		}
		if(row.cashStatus==1 && row.coachId==undefined && row.lessonStatus==2){
			returnStr += '<a href="javascript:void(0);" class="edit_a_group" onclick="showPaymentInfo('+row.id+')">缴费详情</a>';
		}
		return returnStr;
	}
	
	function timeFormatter(value,row,index){
		return row.beginTime.substring(11,16)+"-"+row.endTime.substring(11,16);
	}
	function subjectFormatter(value,row,index){
		switch (value) {
		case 1:
			return "科目二";
		case 2:
			return "科目三";
		}
	}
	function dateFormatter(value,row,index){
		return value.substring(0,10);
	}
	function planWayFormatter(value,row,index){
		switch (value) {
		case 1:
			return "手机预约";
		case 0:
			return "网站预约";
		case 2:
			return "驾校后台预约";
		}
	}
	function cashStatusFormatter(value,row,index){
		if(row.coachId!=undefined){
			return "<span style='color:green;'>已支付</span>";
		}
		return value=="0"?"<span style='color:red;'>未支付</span>":"<span style='color:green;'>已支付</span>";
	}
	function statusFormatter(value,row,index){
		switch (value) {
		case 0:
			return "<span style='color:red;'>未分配车辆</span>";
		case 1:
			return "<span style='color:green;'>已分配车辆</span>";
		case 2:
			return "<span style='color:green;'>已完成培训</span>";
		case 3:
			return "<span style='color:red;'>培训异常</span>";
		}
		return null;
	}
	function lessonInfoAdd(){
		$("#editLessonInfoWindow").dialog('open').dialog('refresh','${path}/mag/addLessonInfo');
	}
	$("#editLessonInfoWindow").dialog({
		title:"预约选课",
	    width:1200,    
	    height:600,    
	    modal:true,
	    maximizable:false,
	    minimizable:false,
	    collapsible:false,
	    draggable:false,
	    resizable:false,
	    cache:false,
	    closed:true
	});
	function cancelLessonPlan(idStr){
		$.messager.confirm('确认消息框','您确认取消预约吗？',function(r){
			if(r){
				$.ajax({
			        type: "post",
			        url: "${path}/mag/cancelLessonPlan",
			        data: {
			        	idStr:idStr
			        },
			        success: function(data){
			        	$.messager.show({
			        		title:'我的消息',
			        		msg:'取消预约成功！',
			        	});
			        	$("#lessonInfoManageGrid").datagrid("reload");
			        }
			    });
			}
		});
	}
	
	$("#showPaymentInfo_window").dialog({
		title:"缴费详情",
	    width:600,    
	    height:450,    
	    modal:true,
	    maximizable:false,
	    minimizable:false,
	    collapsible:false,
	    draggable:false,
	    resizable:false,
	    cache:false,
	    closed:true,
	    buttons: [
       	      	    {
     	      	    	text:"确认",
     	      	    	handler:function(){
     	      	    		$("#showPaymentInfo_window").dialog("close");
     	      	       
     	      	    	}
      	      	    }] 
	 });
	
	//显示缴费详情
	function showPaymentInfo(id){
    	$("#showPaymentInfo_window").dialog("open").dialog("refresh","${path}/mag/showPaymentInfo?id="+id);
	}
	
	
	//显示缴费界面
	function getPaymentInfo(id,cash){
    	$("#payment_window").dialog("open").dialog("refresh","${path}/mag/getPaymentInfo?id="+id);
	}
	
	function cancelSelectLessonInfo(){
		var idStr="";
		var flag = false;
		var count = 0;//用来记录选择的个数
		$($("#lessonInfoManageGrid").datagrid("getChecked")).each(function(index,element){
			idStr+=element.id+",";
			count++;
			if(element.lessonStatus==2||element.lessonStatus==3){
				flag = true;
			}
		});
		if(flag){
			$.messager.alert("","请勿选择已完成或者异常的课程！");
			$("#lessonInfoManageGrid").datagrid("reload");
			return;
		}
		if(count>5){
			$.messager.alert("","一次性最多选择5个！");
			return;
		}
		if(idStr==""){
			$.messager.alert("","请选择需要取消的课程！");
		}else{
		    cancelLessonPlan(idStr.substring(0,idStr.length-1));
		}
	}
	
	$("#showLessonInfoWindow").dialog({
		title:"课程信息详情",
	    width:1200,    
	    height:600,    
	    modal:true,
	    maximizable:false,
	    minimizable:false,
	    collapsible:false,
	    draggable:false,
	    resizable:false,
	    cache:false,
	    closed:true,
	    buttons: [
	      	    {
	      	    	text:"打印",
	      	    	handler:function(){
	      	    		printTable();
	      	        }
	      	    },{
	      	    	text:"关闭",
	      	    	handler:function(){
	      	    		$("#showLessonInfoWindow").dialog("close");
	      	        }
	      	    }] 
	});
	function showLessonInfoDetail(id){
		$("#showLessonInfoWindow").dialog("open").dialog("refresh","${path}/mag/showLessonInfoDetail?lessonInfoId="+id);
	}
	
	</script>
</body>
