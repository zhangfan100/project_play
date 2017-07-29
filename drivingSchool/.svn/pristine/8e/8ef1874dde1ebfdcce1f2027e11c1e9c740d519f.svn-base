<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/TagLib.jsp"%>
<body >
<style>
.lessonPlanTable {
	border-collapse: collapse;
}

.lessonPlanTable th,.lessonPlanTable td {
	border: 1px solid #95B8E7;
	min-width:60px;
	height:28px;
	font-weight: normal;
	font-size:13px;
}
.lessonPlanTable td {
	text-align: center;
}
.form-box{
	margin:20px 20px 0px 20px;
}
.form-box .form-item{
	margin:10px 0px;
}
.form-box .form-btn{
	float:right;
	margin-right:50px;
}
.table-box{
	margin: 20px;
	margin-left: 0px;
	height: 160px;
	width: 647px;
}
.table-box .datagrid-cell {
	padding: 5px 3px 5px 7px;
	font-size: 12px;
}
#list-table{
	margin: 20px 0 0 20px;
}
.disable-Select{
	background-color: #eee;
}
.temp-Selected{
	background: url("${path}/static/images/yx.png") no-repeat center;
}
.temp-disable-Select{
	background-color: #eee;
}
</style>
<div class="easyui-layout" data-options="fit:true" id="addLessonInfo-form">   
    <div data-options="region:'north',border:false" style="height:200px;">
    <div class="easyui-layout" data-options="fit:true" >
    	<div data-options="region:'west',border:false" style="width:520px;" >
    		<div class="form-box" >
		    	<div class="form-item">
					<span>选择学员:</span>
					<input id="stuId" name="stuId" type="text" style="margin:0;width:376px;height:28px;">
				</div>
				<div class="form-item" >
					<span>预约科目:</span>
					<span id="subject" style="margin:0;width: 150px;height:28px;">&nbsp;&nbsp;请选择学生</span>
					&nbsp;&nbsp;&nbsp;
					<span>选择日期:</span> 
					<input id="studyDate" class="easyui-datebox" name="studyDate"  type="text"
						data-options="editable:false,onSelect:selectDate"
						style="margin:0;width: 150px;height:28px;">
				</div>
				<div class="form-item form-btn" style="width: 500px;margin-right: 0px;" >
						<span id="msgTag" style="width:260px;margin-left:20px;">当前未选中学员！</span>
						<a href="javascript:void(0);" onclick="searchData()" class="easyui-linkbutton">搜索教师</a>
						<a href="javascript:void(0);" onclick="saveLessonInfo()" class="easyui-linkbutton">保存预约</a>
				</div>
				<div class="form-item" style="width: 500px;margin-right: 0px;" >
					<span id="infoTag" style="color: red;"></span>
				</div>
			</div>
    	</div>
    	<div data-options="region:'center',border:false">
    		<div class="table-box"><table id="stuLessonPlan"></table></div>
    	</div>
    </div>
    </div>   
    <div data-options="region:'center',border:false">
    	<div id="subject2TimeTag" class="form-item" style="width: 500px;margin-right: 0px;margin-left: 20px;display: none;" >
			<span>约课开始时间:</span>
			<span id="s2BeginTimeTag" style="margin:0;width: 150px;"></span>
			&nbsp;&nbsp;&nbsp;
			<span>约课结束时间:</span> 
			<span id="s2EndTimeTag" style="margin:0;width: 150px;"></span>
		</div>
		<div id="subject3TimeTag" class="form-item" style="width: 500px;margin-right: 0px;margin-left: 20px;display: none;" >
			<span>约课时间:</span>
			<span style="margin:0;width: 150px;"></span>
		</div>
		<div id="list-table">
			<table class="lessonPlanTable" style="width: 1050px;border-collapse: collapse;">
			<thead id="titleHead">
			</thead>
			<tbody id="bodyTag"></tbody>
			</table>
		</div>
    </div>   
</div>  
	<script type="text/javascript">
		var lastCount=0;
		var lastCountTemp=0;
		var currSubject = -1;
		var selectCount = 0;
		$("#addLessonInfo-form #stuId").combogrid({    
		    delay: 500,    
		    mode: 'remote',    
		    url: "${path}/mag/queryStudentsByKeyWord",    
		    idField: 'id',    
		    textField: 'name',
		    fitColumns:true,
		    autoRowHeight:true,
		    rownumbers:true,
		    required:true,
		    fit:true,
		    columns: [[
				{field:'name',title:'姓名',width:60},
		        {field:'licenceCode',title:'身份证号',width:200},
		        {field:'title',title:'驾照',width:40},
		        {field:'phone',title:'电话',width:100}
		    ]],
	  	onSelect:function(rowIndex, rowData){
	  		if(rowData.lessonStep==1){
	  			$("#subject").html("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;科目二");
	  			$("#titleHead").html("<tr><th>教师姓名</th>"
	  			<c:forEach var="price" items="${timePriceTitle }" >
	  			+"<th class='timeFlag'>"
	  			<c:if test="${price.beginTime lt 10}">
				+"0${price.beginTime}:00"
	  			</c:if>
				<c:if test="${price.beginTime >= 10}">
				+"${price.beginTime}:00"
				</c:if>
				+"</th>"
	  			</c:forEach>
			  	+"</tr>");
	  		}else{
	  			$("#subject").html("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;科目三");
	  			$("#titleHead").html("<tr><th>教师姓名</th>"
	  			+"<th class='timeFlag'>上午</th>"
	  			+"<th class='timeFlag'>下午</th>"
	  			+"</tr>");
	  		}
	  		currSubject=rowData.lessonStep;
	  		$("#bodyTag").html("");
	    	$("#addLessonInfo-form #stuLessonPlan").datagrid("load",{
	    		stuId:rowData.id
	    	});
	    }
		});
		$("#addLessonInfo-form #stuLessonPlan").datagrid({
			url:"${path}/mag/queryStuLessonPlanInfo",
			nowrap:false,
			autoRowHeight:true,
			fit:true,
			fitColumns:true,
			rownumbers:true,
			singleSelect:true,
			method:'POST',
			columns:[[
				{field:'lessonCode',title:'培训编号',width:100,align:'center'},
				{field:'studyDate',title:'培训日期',width:100,align:'center'},
				{field:'subject',title:'科目',width:100,align:'center',formatter:function(value,row,index){
					switch(value){
					case 1:
						return "科目二";
					case 2:
						return "科目三";
					}
				}},
				{field:'studyTime',title:'时间段',width:100,align:'center',formatter:function(value,row,index){
					if(value=="mor"){
						return "上午";
					}else if(value=="aft"){
						return "下午";
					}else{
						return value;
					}
				}},
				{field:'name',title:'教练姓名 ',width:100,align:'center'},    
				{field:'price',title:'培训价格',width:100,align:'center'}, 
				{field:'status',title:'状态',width:100,align:'center',formatter:function(value,row,index){
					if(value==3){
						return "<span style='color:red;'>状态异常</span>";
					}else if(value==-1){
						return "<span style='color:red;'>未保存</span>";
					}else{
						return "<span style='color:green;'>已预约</span>";
					}
				}}
			]],
			onBeforeLoad:function(param){
				if(!param.stuId){
					return false;
				}
			},
			onLoadSuccess:function(data){
				selectCount = data.rows.length;//保存已经选择的课程
				var planCount = data.rows.length;
				var countLimit = ${lessonPlanLimit};
				lastCount=countLimit-planCount;
				lastCountTemp=lastCount;
				$("#msgTag").html("当前选择的学生为："+$("#addLessonInfo-form #stuId").combogrid("getText"));
				$("#msgTag").append(",还可约课<span style='color:red;'>"+(countLimit-planCount)+"</span>节。");
			}
		});
		function selectDate(date){
			var currDate = new Date(${currDate});
			var startDate=new Date(${currDate}+24*60*60*1000);
			var planDate = new Date(${currDate}+7*24*60*60*1000);
			if((date<currDate)||(date>planDate)){
				$("#infoTag").html("只允许预约从"
						+(currDate.getMonth()+1)+"月"
						+(currDate.getDate())+"日"
						+"到"
						+(planDate.getMonth()+1)+"月"
						+(planDate.getDate())+"日"
						+"的课程！");
				$(this).datebox("clear");
			}else{
				$("#addLessonInfo-form #infoTag").html("");
			}
		}
		function searchData(){
			if($("#addLessonInfo-form #stuId").combogrid("getValue")==""){
				$("#infoTag").html("请选择学生！");
				return;
			}
			if($("#addLessonInfo-form #studyDate").datebox("getValue")==""){
				$("#infoTag").html("请选择日期！");
				return;
			}else{
				$("#infoTag").html("");
			}
			$("#infoTag").html("");
			removeAllTemp();
			lastCount=lastCountTemp;
			$("#bodyTag").html("");
			$.ajax({
		        type: "post",
		        url: "${path}/mag/queryTeacherTimePlan",
		        data: {
		        	stuId:$("#addLessonInfo-form #stuId").combogrid("getValue"),
					studyDate:$("#addLessonInfo-form #studyDate").datebox("getValue")
		        },
		        success: function(data){
		        	$("#bodyTag").html("");
		        	$("#subject2TimeTag").hide();
		        	$("#subject3TimeTag").hide();
		        	var dataObj=eval(data);
		        	$(dataObj).each(function(index,row){
		        		var rowStr="<tr coachId='"+row.coachId+"' coachName='"+row.name+"' ><td>";
		        		rowStr+=row.name+"</td>";
		        		if(currSubject==1){
		        			$(".timeFlag").each(function(index,element){
		        				$("#subject2TimeTag").show();
			        			var status = eval("row.t"+$(element).html().substring(0,2))
			        			var temp="<td coachId='"+row.coachId+"' timeTag='"+$(element).html().substring(0,2)+"' ";
			        			if((status!=0)&&(status!=undefined)){
			        				temp+=" class='disable-Select' ";
			        			}else{
			        				temp+=" class='enable-Select' ";
			        			}
			        			temp+="></td>";
			        			rowStr+=temp;
			        		});
		        		}else{
		        			$("#subject3TimeTag").show();
		        			var mor=row.mor;
		        			var aft=row.aft;
		        			var temp="<td coachId='"+row.coachId+"' timeTag='mor' ";
		        			if((mor!=0)&&(mor!=undefined)){
		        				temp+=" class='disable-Select' ";
		        			}else{
		        				temp+=" class='enable-Select' ";
		        			}	
		        			temp+="></td>";
		        			temp+="<td coachId='"+row.coachId+"' timeTag='aft' ";
		        			if((aft!=0)&&(aft!=undefined)){
		        				temp+=" class='disable-Select' ";
		        			}else{
		        				temp+=" class='enable-Select' ";
		        			}
		        			rowStr+=temp;
		        		}
		        		rowStr+="</tr>";
		        		$("#bodyTag").append(rowStr);
		        	});
		        	$(".enable-Select").unbind().click(selectLesson);
		        }
		    });
		}
		function saveLessonInfo(){
			var rows =$("#addLessonInfo-form #stuLessonPlan").datagrid("getData").rows;
			if(rows.length<=selectCount){
				$("#infoTag").html("请选择！");
			    return;
			}
			var jsonStr="[";
			$(rows).each(function(index,element){
				if(element.status==-1){
					var str = JSON.stringify(element);
					jsonStr+=str+",";
				}
			});
			jsonStr = jsonStr.substr(0, jsonStr.length-2);
			var cohId = $(".enable-Select").attr("coachId");
			jsonStr+=',"cohId":"'+cohId+'"';
			jsonStr+=',"student":"2"';
			jsonStr+="}]";
			$.ajax({
		        type: "post",
		        url: "${path}/mag/addLessonInfoSubmit",
		        data: {
		        	jsonStr:jsonStr
		        },
		        success: function(data){
		        	searchData();
		        	removeAllTemp();
		        	$("#addLessonInfo-form #stuLessonPlan").datagrid("reload");
		        	$("#stuLessonPlan").datagrid("reload");
		        }
		    });
		}
		function removeAllTemp(){
			$("#s2EndTimeTag").html("");
			$("#s2BeginTimeTag").html("");
			var rows =$("#stuLessonPlan").datagrid("getData").rows;
			$(rows).each(function(index,element){
				if(element.status==-1){
					var currIndex =$("#stuLessonPlan").datagrid("getRowIndex",element);
					$("#stuLessonPlan").datagrid("deleteRow",currIndex);
				}
			});
		}
		
		
		function selectLesson(){
			if(lastCount>0){
				$("#infoTag").html("");
				if(currSubject==1){
					//科目二状况
					if($(this).hasClass("temp-Selected")){
						$(this).removeClass("temp-Selected");
						removeAllTemp();
						switch ($(".temp-Selected").length){
						case 0:
							$(".temp-disable-Select").addClass("enable-Select").removeClass("temp-disable-Select");
							$(".enable-Select").unbind().click(selectLesson);
							$("#s2EndTimeTag").html("");
							$("#s2BeginTimeTag").html("");
							break;
						case 1:
							$("#s2EndTimeTag").html("");
							$("#s2BeginTimeTag").html($(".temp-Selected").attr("timeTag")+":00");
							break;
						}
					}else{
						if($(".temp-Selected").length==2){
							$("#infoTag").html("请选择开始时间与结束时间，最多约三小时课程！");
							return;
						}else if($(".temp-Selected").length==0){
							$("#s2BeginTimeTag").html($(this).attr("timeTag")+":00");
						}else if($(".temp-Selected").length==1){
							var beginTimeTag = parseInt($("#s2BeginTimeTag").html().substring(0,2));
							var selectedTimeTag = parseInt($(this).attr("timeTag"));
							if((beginTimeTag-selectedTimeTag>2)||(beginTimeTag-selectedTimeTag<-2)){
								$("#infoTag").html("一天内最多约三小时课程！");
								return;
							}
							if(beginTimeTag>selectedTimeTag){
								$("#s2EndTimeTag").html($("#s2BeginTimeTag").html().substring(0,2)+":59");
								$("#s2BeginTimeTag").html($(this).attr("timeTag")+":00");
							}else{
								$("#s2EndTimeTag").html($(this).attr("timeTag")+":59");
							}
							var coachName = $($(this).parent("tr").children()[0]).html();
							//需要的数据
							var needData = {
									 stuId:$("#addLessonInfo-form #stuId").combogrid("getValue"),
									 cohId:$(this).attr("coachId"),
									 studyDate:$("#addLessonInfo-form #studyDate").datebox("getValue"),
									 studyTime:$("#s2BeginTimeTag").html()+"-"+$("#s2EndTimeTag").html()
							};
							//发送ajax得到price
							$.ajax({
						        type: "post",
						        url: "${path}/mag/getTotalPrice",
						        data:needData,
						        success: function(data){
						        	data = eval("("+data+")")
						        	var price = data.price;
						        	if(price==0){
						        		price="";
						        	}
									var insertData = {
										stuId:$("#addLessonInfo-form #stuId").combogrid("getValue"),
										cohId:$(this).attr("coachId"),
										lessonCode:"未保存",
										studyDate:$("#addLessonInfo-form #studyDate").datebox("getValue"),
										subject:currSubject,
										studyTime:$("#s2BeginTimeTag").html()+"-"+$("#s2EndTimeTag").html(),
										name:coachName,
										price:price,
										status:-1
									};
						        	$("#stuLessonPlan").datagrid("appendRow",insertData);
						        }
						    });
						}
						$(".enable-Select[coachId!="+$(this).attr("coachId")+"]").addClass("temp-disable-Select").removeClass("enable-Select").unbind();
						$(this).addClass("temp-Selected");
						$(".enable-Select").unbind().click(selectLesson);
					}
				}else{
					//科目三状况
					if($(this).hasClass("temp-Selected")){
						$(".temp-disable-Select").addClass("enable-Select").removeClass("temp-disable-Select");
						$(this).removeClass("temp-Selected");
						removeAllTemp();
					}else{
						if($(".temp-Selected").length>0){
							$("#infoTag").html("只允许约一个时段的课程！");
							return;
						}else{
							$(".enable-Select[coachId!="+$(this).attr("coachId")+"]").addClass("temp-disable-Select").removeClass("enable-Select").unbind();
							$(this).addClass("temp-Selected");
							var insertData = {
									stuId:$("#addLessonInfo-form #stuId").combogrid("getValue"),
									cohId:$(this).attr("coachId"),
									lessonCode:"未保存",
									studyDate:$("#addLessonInfo-form #studyDate").datebox("getValue"),
									subject:currSubject,
									studyTime:$(this).attr("timeTag"),
									name:$($(this).parent("tr").children()[0]).html(),
									price:"未保存",
									status:-1
							};
					        $("#stuLessonPlan").datagrid("appendRow",insertData);
						}
					}
				}
			}else{
				$("#infoTag").html("只允许学生约课三节！");
			}
		}
	</script>
</body>
