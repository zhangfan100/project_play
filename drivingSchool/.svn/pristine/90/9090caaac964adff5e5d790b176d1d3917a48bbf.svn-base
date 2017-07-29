<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/TagLib.jsp"%>
<script type="text/javascript" src="${path}/static/front/js/train_detail.js"></script>
<div class="right_content train_detail">
	<h2>我的预约</h2>
	<div class="right_box_0">
		<div class="train_detail_1 person_order_2">
			<ul>
				<li>培训科目</li>
				<li>培训时间</li>
				<li>教练</li>
				<li>培训代码</li>
				<li>操作</li>
			</ul>
			<div class="train_detail_2 person_order_2" id="train_detail_2">
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
$(function(){
	//一打开页面就执行
	ajaxLessonPlanList();
});
//ajax加载预约课程
function ajaxLessonPlanList(){
        	$.ajax({
        		  type: "POST",
        		  url: "${path}/stu/queryStuLessonInfoPlanList",
        		  success: function(data){
        			 var dataObj=eval(data);
        			 for(var i = 0 ; i<dataObj.length;i++){
        				 if(dataObj[i].lessonStatus==3){
        					 continue;
        				 }
	        			 var subject = dataObj[i].subject==1?"科目二":"科目三";
	        			 var beginTime = (new Date(dataObj[i].beginTime)).pattern("yyyy-MM-dd HH:mm");
	        			 var endTime = (new Date(dataObj[i].endTime)).pattern("HH:mm");
	        			 var time = beginTime+"-"+endTime;
	        			 var cohName = dataObj[i].cohName;
	        			 var lessonCode = dataObj[i].lessonCode;
	        			 var status = dataObj[i].lessonStatus==0?"未分配车辆":dataObj[i].lessonStatus==1?"已分配车辆":"培训完成";
	        			 var id = dataObj[i].id;
	        			 $("#train_detail_2").append('<ul><li><span>'+subject+'</span></li><li style="line-height: 27px;"><span>'+time+'</span></li><li>'+cohName+'</li><li>'+lessonCode+'</li><li style="line-height: 27px;">'+"<span class='green'>"+status+"</span><span><a class='grey' onclick='cancelLessonPlan("+id+")'>取消预约</a></span></li></ul>");
        			 }
        		  }
        		});
	
	
}
function cancelLessonPlan(id){
	 $.messager.confirm("操作提示", "您确定取消预约吗?", function (data1) {
         if (data1) {//点了确定
        	 $.ajax({
       		  type: "POST",
       		  url: "${path}/stu/cancelLessonPlan",
       		  data: {
       			  idStr:id
       		  },
       		  success: function(data2){
       			  if(data2=='1'){
       				  //刷新上面的表格之前把以前的数据清除
       				  $("#train_detail_2").html("");
       				  ajaxLessonPlanList();
       				  ShowMessage("取消课程成功！");
       			  }else{
       				  AlterMessage("保存异常！");
       			  }
       		  }
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
