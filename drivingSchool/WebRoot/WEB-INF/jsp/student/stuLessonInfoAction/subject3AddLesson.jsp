<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/TagLib.jsp"%>
<%@include file="../../TagLib/StuLib.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
<body id="coach">
<style>
.disable-Select{
	background-color: #d9d6c3;
}
.temp-Selected{
	background: url("${path}/static/images/yx.png") no-repeat center;
}
</style>
<!--中间内容-->
<div class="content_2">
    <div class="rightContent clearfix">
        <h2>在线选课</h2>
        <div class="content_4">
            <div class="content_5">
                <p class="reminder">
                    <span style="width:180px;">
                         <span class="title_6">当前科目：</span>
                        <span class="subject">科目三</span>
                    </span>
                    <span class="time">
                        <span class="title_6">选择预约日期</span>
                        <input type="text" readonly id="form_datetime"/>
                    </span>
                </p>
                <p class="title_6">已选预约</p>
                <div style=" height:216px;width:100%;overflow:hidden;border:2px solid #a0a0a0;margin-top: 15px;">
                <table cellspacing="0" cellpadding="0" class="pastC" >
                    <thead>
                        <tr>
                            <td>培训编号 </td>
                            <td>培训日期</td>
                            <td>时间段</td>
                            <td>教练</td>
                            <td>价格</td>
                            <td>状态</td>
                        </tr>
                    </thead>
                    <tbody id="fininshPlan">
                    </tbody>
                </table>
                </div>
                <p class="button">
                    <span style="font-size: 14px;color:#545d6a;margin-left: 5px">
                        注：每位学员一天最多能预约一次培训
                    </span>
                    <input type="button" value="保存预约" onclick="saveLessonInfo()"/>
                </p>
                <p class="order">
                    <span class="title_6">预约选课</span>
                    <span style="margin-left: 50%">
                        <sapn>
                            <span id="noChec"></span>
                            <label class="check" for="noChec">不可选</label>
                        </sapn>
                    <sapn style="margin-left:30px">
                        <span id="Chec"></span>
                        <label class="check" for="Chec">选中科目
                        </label>
                    </sapn>
                    </span>

                </p>
                <table cellpadding="0" cellspacing="0" class="orderT">
                    <thead>
                    <tr class="coach">
                        <td></td>
                        <td>
                            上午 （08:00  ~ 11:00  ）</br>
                            ￥65
                        </td>
                        <td class="lastTd">
                            下午 （13:00  ~ 18:00  ）</br>
                            ￥85
                        </td>
                    </tr>
                    <tr></tr>
                    </thead>
                    <tbody id="bodyTag"></tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<!--中间内容 end-->
<script type="text/javascript">

        refreshData();//加载已经选的课
        
        var selectCount = getSelectCount();//初始化一开始已经预约的个数
        var planlessons = {};//放置计划选择的课程
        var saveCount = 0;//记录已经保存的个数
         
        //得到上面table里面所有的tr个数
        function getSelectCount(){
        	return $("#fininshPlan").find("tr").size();
        }
        
        //初始化变量
        function init(){
        	planlessons = {};
        }
        
        //移除上面没有保存的 每次重新选择时间都得去掉
		function removeUnSave(){
			$("#fininshPlan tr").each(function(){
	        		  if($(this).find("td:eq(0)").text()=="未保存"){
	        			$(this).remove();
	        		  }
	        	});
		}
        
		/**
		 *判断选择的日期是否在一周之内
		 */
		
		function isValidityPeriod(){
			 var date = $("#form_datetime").val();//获取选择的时间
			 date = new Date(date);
			 var currDate = new Date();
			 var startDate=currDate.getTime()+24*60*60*1000;
			 startDate = new Date(startDate);//开始的时间
			 var planDate = currDate.getTime()+8*24*60*60*1000;
			 planDate = new Date(planDate);//开始的时间
			 if((date<currDate)||(date>planDate)){
				 return false;
			 }
			 return true;
		}
        
		/* 日历插件 **/
		$("#form_datetime").datetimepicker({
			weekStart : 1,
			startDate:'${beginDate}',
			endDate:'${endDate}',
			initialDate:'${beginDate}',
			todayBtn : 1,
			autoclose : 1,
			todayHighlight : 1,
			startView : 2,
			minView : 'month',
			format : "yyyy-mm-dd",
			forceParse : 0
		}).change(function(){
			    //判断选择的日期是否合法
			    if(!isValidityPeriod()){
			    	//去掉上面未保存的
	        		removeUnSave();
			    	//去掉下面已经加载的教练
			    	$("#bodyTag").find("tr[coachId]").remove();
			    	$.messager.alert("","预约时间不对");
			    	return;
			    }
			   //每次重新选择了日期 那么上面未保存的都得清理掉
	    	    removeUnSave();
	    	    init();
			   //点击前判断已经预约的是否已经达到了上限3个
			   if(saveCount>=3){
	      			$.messager.alert("","已经预约够了！");
	      			return;
		       }
	    	   var date = $(this).val();//得到选择的时间
	    	   if(date!=null && date !=""){
		    	   var currDate = new Date();//得到当前时间
		    	   date = new Date(date.replace(/-/g,"/"));
		    	   if(date<=currDate){
		    		   $("#form_datetime").val("");
		    		   $.messager.alert("","预约时间不对！");
		    	   }else{//发送ajax请求数据 之前需要把以前bodyTag这下面的数据清除
		    		   $("#bodyTag").find("tr[coachId]").remove();
		    		   var json = date.pattern("yyyy-MM-dd");
		    		   $.ajax({
		   		        type: "post",
		   		        url: "${path}/stu/findLessonInfo",
		   		        data: {
		   		        	studyDate:json
		   		        },
		   		        success: function(data){
		   		        	//var dataObj=$.parseJSON(data);只支持标准的 json格式 就是key和value都是带引号的
		   		     	    var dataObj=eval(data);//用这个可靠
		   		        	initSelectData(dataObj);
		   		        	$(".enable-Select").click(function(){
		   		        		if($(this).hasClass("temp-Selected")){
		   		        			$(this).removeClass("temp-Selected");
		   		        			//去掉上面未保存的
		   		        			removeUnSave();
		   		        			init();//初始化数据变量
		   		        			return;
		   		        		}
		   		        		
		   		        		if(saveCount>=3){//说明已经保存了3个 不能预约了
		   		        			$.messager.alert("","最多预约三个！");
		   		        			return;
		   		        		}
		   		        		
		   		        		//如果已经预约28号这天的 那么就不行再预约这天的了
		   		        		var flag = false;
		   		        		$("#fininshPlan tr").each(function(){
		   		        		  if($(this).find("td:eq(1)").text()==json){//说明上面已经预约的有了这天的课程
			   		        		    flag = true;
		   		        		  }
		   		        		});
		   		        		if(flag){
		   		        			flag = false;
		   		        			//$(this).addClass("temp-Selected");
		   		        			AlterMessage("这天已经预约了！");
		   		        			return;
		   		        		}
		   		        		
		   		        		$(this).addClass("temp-Selected");
		   		        		//走到这里说明要符合选择的条件 那么把数据放入到变量中
		   		        		//{"cohId":"24","lessonCode":"未保存","studyDate":"2015-03-26","subject":2,"studyTime":"aft","name":"杨吉","price":"未保存","status":-1}
		   		        		var coachId = $(this).parent().attr("coachId");
		   		        		var coachName = $(this).parent().attr("coachName");
		   		        		planlessons={
			   		        			"cohId":coachId,
			   		        			"lessonCode":"未保存",
			   		        			"studyDate":json,
			   		        			"subject":"2",
			   		        			"studyTime":$(this).attr("timeSlot")==1?"mor":"aft",
			   		        			"name":coachName,
			   		        			"price":"未保存",
			   		        			"status":"-1"
			   		        	};
		   		        		//把选择的数据显示到上面 转态是未保存，编号也是未保存 
		   		        		//需要的数据是 选择的日期date.pattern("yyyy-MM-dd") 时间段$(this).attr("timeSlot") 教练名字$(this).parent().attr("coachName")
		   		        		// var selectStr = "<tr id='"+$(this).parent().attr("coachName")+"-"+$(this).attr("timeSlot")+"-"+$(this).parent().attr("coachId")+"-"+json+"'><td>未保存</td><td>"+date.pattern("yyyy-MM-dd")+"</td><td>"+($(this).attr("timeSlot")==1?"上午":"下午")+"</td><td>"+$(this).parent().attr("coachName")+"</td><td style='color:#d93d06'>....</td><td style='color:#007947'>未保存</td></tr>";
		   		        		 var selectStr = "<tr id='"+coachName+"-"+$(this).attr("timeSlot")+"-"+coachId+"-"+json+"'><td>未保存</td><td>"+json+"</td><td>"+($(this).attr("timeSlot")==1?"上午":"下午")+"</td><td>"+coachName+"</td><td style='color:#d93d06'>...</td><td style='color:#007947'>未保存</td></tr>";
		   		        		 $("#fininshPlan").append(selectStr);
				    		});
		   		        }
		   		        
		   		    });
		    	   }
	    	   }
	       }); 
		
		//选择日期后把数据放入到对应的表格里
		function initSelectData(dataObj){
			$(dataObj).each(function(index,row){
		        	
        		var rowStr="<tr coachId='"+row.coachId+"' coachName='"+row.name+"' ><td>";
        		rowStr+=row.name+"</td>";
        			//如果mor等于1 ，aft=0标示上午不可选 下午可选 
    			var status = row.mor;
        		var temp = "";
        			//如果mor等于0 ，aft=1标示上午可选 下午不可选 
        	    if(status==0){
    			    temp+="<td class='enable-Select' timeSlot=1></td>";
        	    	
        	    }else{
        	    	temp+="<td class='disable-Select' timeSlot=1></td>";
        	    }
        		status = row.aft;
        		if(status==0){
    			    temp+="<td class='enable-Select' timeSlot=2></td>";
        	    	
        	    }else{
        	    	temp+="<td class='disable-Select' timeSlot=2></td>";
        	    }
    			rowStr+=temp;
        		rowStr+="</tr>";
        		$("#bodyTag").append(rowStr);
            });
		}
		
		//保存预约
		function saveLessonInfo(){
			if(saveCount>=3){//说明已经保存达到了3个 没法保存了
				$.messager.alert("","已经保存够了");
				return;
			}
			//直接点击保存 但是没有选择
			if(getSelectCount()==saveCount){//没选择
				$.messager.alert("","请选择！");
			    return;
			}
			var json = JSON.stringify(planlessons);
			$.ajax({
		        type: "post",
		        url: "${path}/stu/saveLessonInfoPlanSubmit",
		        data: {
		        	jsonStr:"["+json+"]"
		        },
		        success: function(data){
		        	var jsonObject = eval("(" + data + ")");
                    if(jsonObject.status!="-1"){//保存失败返回-1
                    	//直接重新加载上面所有的数据
                    	$("#fininshPlan tr").remove();//先清除所有的数据
                    	refreshData();//重新刷新数据
                        //保存成功后需要把计划选课的变量里的数据情况
                        init();//初始化数据变量
                    	ShowMessage("保存成功！");
                    }else{
                    	//应该清除上面未保存的记录
                    	removeUnSave();
                    	//初始化计划选课的变量里的数据
                    	init();//初始化数据变量
            			AlterMessage("保存异常！");
            		}
		        }
		    });
		}
		
		//初始化上面所有的数据
		function refreshData(){
			$("#fininshPlan").html("");
			$.ajax({
   		        type: "post",
   		        url: "${path}/stu/queryOrderLessionInfo",
   		        success: function(data){
   		            var dataObj=eval(data);
   		            saveCount = dataObj.length;//记录已保存的个数
					$.each(dataObj,function(index,item){
						var innerTag ="<tr>";
						innerTag += "<td>" + item.lessonCode + "</td>";
						innerTag += "<td>" + item.beginTime + "</td>";
						innerTag += "<td>" + (item.timeSlot==1?"上午":"下午") + "</td>";
						innerTag += "<td>" + item.name+ "</td>";
						innerTag += "<td style='color:#d93d06'>..</td>";
						innerTag += "<td style='color:#007947'>已保存</td>";
						innerTag += "</tr>";
						$("#fininshPlan").append(innerTag);
					});
   		        }
			});
		}
		
		//原型上添加一个patten函数 把Date类型直接转化为String类型
		Date.prototype.pattern=function(fmt) {          

		    var o = {          

		    "M+" : this.getMonth()+1, //月份          

		    "d+" : this.getDate(), //日          

		    "h+" : this.getHours()%12 == 0 ? 12 : this.getHours()%12, //小时          

		    "H+" : this.getHours(), //小时          

		    "m+" : this.getMinutes(), //分          

		    "s+" : this.getSeconds(), //秒          

		    "q+" : Math.floor((this.getMonth()+3)/3), //季度          

		    "S" : this.getMilliseconds() //毫秒          

		    };          

		    var week = {          

		    "0" : "\u65e5",          

		    "1" : "\u4e00",          

		    "2" : "\u4e8c",          

		    "3" : "\u4e09",          

		    "4" : "\u56db",          

		    "5" : "\u4e94",          

		    "6" : "\u516d"         

		    };          

		    if(/(y+)/.test(fmt)){          

		        fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));          

		    }          

		    if(/(E+)/.test(fmt)){          

		        fmt=fmt.replace(RegExp.$1, ((RegExp.$1.length>1) ? (RegExp.$1.length>2 ? "\u661f\u671f" : "\u5468") : "")+week[this.getDay()+""]);          

		    }          

		    for(var k in o){          
		    	

		        if(new RegExp("("+ k +")").test(fmt)){          

		            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));          

		        }          

		    }          

		    return fmt;          

		};    
		
		
		
</script>
</body>
</html>
