
var lessonPlanLimited = 0;	//已选预约总数
$(function(){
	
	//加载已选课程
	queryStuLessonPlanInfo();
	
	//加载教师排课
	queryTeacherTimePlan();
	
	//绑定选中事件
	bindSelected();
	
});

/**
 * 加载已选课程
 */
function queryStuLessonPlanInfo(){
	$.post(path+"/stu/queryStuLessonPlanInfo",function(data){
		data = $.parseJSON(data);
		lessonPlanLimited = data.length;
		var _seledClass = $("#seledClass").html("");
		$.each(data,function(index,item){
			var _ul = $("<ul><li></li><li></li><li></li><li></li><li class='price'></li><li>已保存</li></ul>");
			var price = item?item.price?item.price:0:0;
			_seledClass.append(_ul);
			_ul.children("li").eq(0).html(item.lessonCode);
			_ul.children("li").eq(1).html(item.studyDate);
			_ul.children("li").eq(2).html(item.studyTime);
			_ul.children("li").eq(3).html(item.name);
			_ul.children("li").eq(3).attr("coachid",item.coachId);
			_ul.children("li").eq(4).html(price);
			
			//新模式之--没有价格
			if(stuType==1){
				_ul.children("li").eq(4).remove();
			}
		});
		countMoney();
	});
}

/**
 * 选课信息保存
 */
function saveClass(){
	var _seledClass = $("#seledClass").children(".tmpUl");
	var jsonStr = [];
	$.each(_seledClass,function(index,item){
		var _obj = {};
		jsonStr.push(_obj);
		_obj['studyDate'] = $(item).attr("studyDate");
		_obj['coachId'] = $(item).attr("coachId");
		_obj['studyDate'] = $(item).attr("studyDate");
		_obj['studyTime'] = $(item).attr("studyTime");
		_obj['subject'] = $(item).attr("subject");
		_obj['planWay'] = $(item).attr("planWay");
	});
	
	$.post(path+"/stu/addLessonInfoSubmit",{jsonStr:JSON.stringify(jsonStr)},function(data){
		if(data==0){
			searchTeaClass();
		}else if(data==1){
			alert("该课程已被预约 刷新重试!");
			searchTeaClass();
		}else{
			alert("预约失败!");
		}
	});
}


/**
 * 查询教练排课信息事件
 */
function searchTeaClass(){
	var lessonInifDdate = $("#lessonInifo-date").val();
	var dLessonType = $("#dLessonType").val();
	queryTeacherTimePlan(lessonInifDdate,dLessonType);
	
	//加载已选课程
	queryStuLessonPlanInfo();
}


/**
 * 绑定选中事件
 */
function bindSelected(){
	$("#tp-tbody td").die("click").live("click",function(){
		var _this = $(this);
		if(_this.hasClass("disable-Selected")){
			return;
		}
		//已选择的预约框
		var _seledClass = $("#seledClass");
		
		//选中、未选中，切换
		if(_this.hasClass("temp-Selected")){
			_this.removeClass("temp-Selected");
			_seledClass.children("ul[tmpId='"+_this.attr("tmpId")+"']").remove();
			$("#tp-tbody>tr>td:nth-child("+(_this.prevAll("td").length+1)+")").not(_this).removeClass("temp-disable-Selected");
			countMoney();
			return;
		}
		
		//是否大于总预约数
		if($("#seledClass").children().length>=lessonPlanLimit){return;}
		
		//添加唯一标识
		var tmpId = "tmp"+new Date().getTime();
		_this.attr("tmpId",tmpId);
		
		
		var studyDate = $("#lessonInifo-date").val();
		var subject = $("#dLessonType").val();
		var time = _this.attr("timetag");
		var timetag = time+":00-"+((time*1+1)<10?('0'+(time*1+1)):(time*1+1))+":00";
		var coachName = _this.attr("coachName");
		var coachId = _this.attr("coachId");
		
		
		_this.addClass("temp-Selected");
		$("#tp-tbody>tr>td:nth-child("+(_this.prevAll("td").length+1)+")").not(_this).addClass("temp-disable-Selected");
		var _ul = $("<ul><li></li><li></li><li></li><li></li><li class='price'></li><li></li></ul>");
		_seledClass.append(_ul);
		_ul.attr("tmpId",tmpId).addClass("tmpUl");
		_ul.children("li").eq(0).html("未保存");
		_ul.children("li").eq(1).html(studyDate);
		_ul.children("li").eq(2).html(timetag);
		_ul.children("li").eq(3).html(coachName);
		
		_ul.attr("studyDate",studyDate);
		_ul.attr("coachId",coachId);
		_ul.attr("studyDate",studyDate);
		_ul.attr("studyTime",timetag);
		_ul.attr("subject",subject);
		_ul.attr("planWay",1);
		
		if(stuType==0){
			$.post(path+"/stu/queryPlanDateTimePrice",{coachId:coachId,studyDate:studyDate,time:time*1},function(data){
				data = $.parseJSON(data);
				var price = data?data.price?data.price:0:0;
				_ul.children("li").eq(4).html(price);
				countMoney();
			});
		}
		_ul.children("li").eq(5).html("未保存");
		
		if(stuType==1){
			_ul.children("li").eq(4).remove();
		}
	});
}

/**
 * 统计分数
 */
function countMoney(){
	var money = 0;
	$("#seledClass>ul>.price").each(function(){
		money += $(this).text().trim()*1;
	});
	$("#totalPriceNumber").text(money);
}

/**
 * 重置trim()方法,解决ie
 * @returns
 */
String.prototype.trim=function(){
    return this.replace(/(^\s*)|(\s*$)/g, "");
 }

/**
 * 加载教师排课
 */
function queryTeacherTimePlan(studyDate,subject){
	$.post(path+"/stu/queryTeacherTimePlan",{studyDate:studyDate,subject:subject},function(data){
		data = $.parseJSON(data);
		var times = $("#tp-head").children("td");
		var _tbody = $("#tp-tbody").html("");
		var _tnamebody = $("#tname-tbody").html("");
		
		$.each(data,function(index,item){
			//教练名
			var _ctr = $("<tr></tr>");
			var _ctd = $("<td></td>");
			_ctr.append(_ctd);
			_tnamebody.append(_ctr);
			_ctd.append("<a href='"+path+"/coachshow/toCoachDetail?id="+item.coachId+"' target='_blank'>"+item.coachName+"</a>");
			
			//所在时间段是否被预约
			var _tr = $("<tr></tr>");
			$.each(times,function(index1,time){
				var _td = $("<td></td>");
				_tr.append(_td);
				var ctime = $(time).text().trim().split(":")[0];
				if(item['t'+ctime]){
					_td.addClass("disable-Selected");
				}
				_td.attr("coachId",item.coachId);
				_td.attr("timetag",ctime);
				_td.attr("coachName",item.coachName);
			});
			_tbody.append(_tr)
		});
		
		//禁用当前时间列
		$("#tp-tbody .disable-Selected").each(function(index,item){
			var _this = $(this);
			var coachid = _this.attr("coachid");
			var time = _this.attr("timetag");
			var date = $("#lessonInifo-date").val();
			$("#seledClass>ul").each(function(index,item){
				var eddate = $(this).children("li:eq(1)").text().trim();
				var edtime = $(this).children("li:eq(2)").text().trim();
				edtime = edtime.substring(0,edtime.indexOf(":"));
				var edcoachid = $(this).children("li:eq(3)").attr("coachid");
				if(coachid==edcoachid && eddate==date && edtime==time){
					$("#tp-tbody>tr>td:nth-child("+(_this.prevAll("td").length+1)+")").not(_this).addClass("disable-Selected");
				}
				
			});
			
		});
		
		//分页
		jpages();
	});
}

/**
 * 分页
 */
function jpages(){
	
	/*jpages2(1);
	
	$("#addLessonInfo>#holder1").jPages({
		containerID : "tp-tbody",
		previous : "",
		next : "",
		perPage : 6,
		delay : 20,
		callback : function(page, itemRange, pageInterval) {
		}
	});*/
	
	
}
/*
function jpages2(page){
	$("#addLessonInfo>#holder2").jPages({
		containerID : "tname-tbody",
		previous : "",
		next : "",
		perPage : 6,
		startPage:page,
		delay : 20
	});
}*/
