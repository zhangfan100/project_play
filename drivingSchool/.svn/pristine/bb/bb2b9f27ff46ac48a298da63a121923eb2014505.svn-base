<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/TagLib.jsp"%>
<body>
	<div class="easyui-layout" data-options="fit:true">
	     
	    <div data-options="region:'west'" style="width:500px;">
	    	<div class="easyui-layout" data-options="fit:true">
	    		<div data-options="region:'north'">
	    			<div class="center-filter clearfix">
				    	<span class="table-title">空闲教练</span>
					</div>
	    		</div>
	    		<div data-options="region:'center'">
	    			<table id="noGroupCoh" style="width:500px;"
					        data-options="fit:true,rownumbers:true,fitColumns:true,singleSelect:false,pagination:true">   
					    <thead>   
					        <tr>   
					            <th data-options="field:'id',checkbox:true,align:'center',width:10"></th>   
					            <th data-options="field:'name',align:'center',width:100">姓名</th>   
					            <th data-options="field:'coachCode',align:'center',width:100">教练证号</th>   
					        </tr>   
					    </thead>   
					</table> 
	    		</div>
	    	</div>
	    	
	    	 
	    </div>
	    <div data-options="region:'east'" style="width:500px;">
	    	<div class="easyui-layout" data-options="fit:true">
	    		<div data-options="region:'north'">
	    			<div class="center-filter clearfix">
				    	<span class="table-title">已分组教练</span>
				    	<span style="float:right;margin-right: 50px;">
				    		组别：
					    	<select id="week"   name="week" style="width:70px;" editable=false data-options="panelHeight:'auto'">  
					    		<option value="0">星期天</option>
					    		<option value="1">星期一</option>
					    		<option value="2">星期二</option>
					    		<option value="3">星期三</option>
					    		<option value="4">星期四</option>
					    		<option value="5">星期五</option>
					    		<option value="6">星期六</option>
							</select>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					    	<select id="timeSlot" name="timeSlot" style="width:70px;" editable=false data-options="panelHeight:'auto'">  
					    		<option value="1">上午</option>
					    		<option value="2">下午</option>
							</select>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					    	<select id="subject"  name="subject" style="width:70px;" editable=false data-options="panelHeight:'auto'">  
					    		<option value="1">科目二</option>
					    		<option value="2">科目三</option>
							</select>
						</span>
					</div>
	    		</div>
	    		<div data-options="region:'center'">
	    		<table id="groupCoh"   style="width:500px;" 
			        data-options="fit:true,rownumbers:true,fitColumns:true,singleSelect:false,pagination:true">   
				    <thead>
				        <tr>   
				            <th data-options="field:'id',checkbox:true,align:'center',width:10"></th>   
				            <th data-options="field:'name',align:'center',width:100">姓名</th>   
				            <th data-options="field:'coachCode',align:'center',width:100">教练证号</th>     
				        </tr>   
				    </thead>   
				</table> 
				</div>
	    	</div>
	    	
	    </div>  
	    <div data-options="region:'center'">
	    	<div style="text-align:center;">
		    	<br/><br/><br/><br/><br/>
		    	<a class="easyui-linkbutton" onclick="javascript:joinGroup();">加入&gt;&gt;</a>
		    	<br/><br/>
		    	<a class="easyui-linkbutton" onclick="javascript:removeGroup();">移除&lt;&lt;</a>
		    	<br/><br/>
		    	<a class="easyui-linkbutton" onclick="javascript:rebuildCurrLessonPlan();">检查数据</a>
	    	</div>
	    </div>   
	</div>
	<script type="text/javascript">
		
	    //拿到参数需要的参数
		function getParam(){
			var subject = $("#subject").combobox("getValue");
			var weekDay = $("#week").combobox("getValue");
			var timeSlot = $("#timeSlot").combobox("getValue");
			return {subject:subject,weekDay:weekDay,timeSlot:timeSlot};
		}
		
	    //加入组的函数
		function joinGroup(){
	    	var seled = $("#noGroupCoh").datagrid("getSelections");
	    	
	    	//如果还没选择数据 给出提示
	    	if(seled.length==0){
	    		AlterMessage("请选择");
				return;
	    	}
			var cohIds = [];
			
			$.each(seled,function(index,item){
				cohIds.push(item.id);//把对应的ID放入到cohIDs数组中
			});
			var param = getParam();
			param['cohIds'] = cohIds.join(",");//还是拼成json格式的参数
			$.post("${path}/mag/joinCoachGroup",param,function(data){
				if(data==0){
				  $("#groupCoh,#noGroupCoh").datagrid("reload");
				}else{
					AlterMessage("加入异常");
				}
			});
		}
		
	    //移除组的函数
		function removeGroup(){
	    	
			var seled = $("#groupCoh").datagrid("getSelections");
			
			if(seled.length==0){
				AlterMessage("请选择");
				return;
			}
			var groupIds = [];
			$.each(seled,function(index,item){
				groupIds.push(item.id);
			});
			
			var param = getParam();
			param['groupIds'] = groupIds.join(",");
			$.post("${path}/mag/removeCoachGroup",param,function(data){
				if(data==0){
					  $("#groupCoh,#noGroupCoh").datagrid("reload");
					}else{
						AlterMessage("移除异常");
					}
			});
		}
		
		//刷新未分组的
		function refreshNoGroupCoh(){
			$("#noGroupCoh").datagrid({
				url:'${path }/mag/queryUnusedCoachPage',
				queryParams:getParam()
			});
		}
		
		//刷新已分组的
		function refreshGroupCoh(){
			$("#groupCoh").datagrid({
				url:'${path }/mag/queryUsedCoachPage',
				queryParams:getParam()
			});
		}
		
		//当用户选择了下拉列表时就触发
		$("#week,#subject,#timeSlot").combobox({onSelect:function(){
			refreshGroupCoh();
			refreshNoGroupCoh();
		}});
		
		refreshGroupCoh();
		refreshNoGroupCoh();
		
		function rebuildCurrLessonPlan(){
			$.post("${path}/mag/rebuildCurrLessonPlan",null,function(data){
				$.messager.alert(null,"检查完成，并已填补数据！");
			});
		}
	</script>
</body>