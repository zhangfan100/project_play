<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/FroJSLib.jsp"%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" ></meta>
<link href="${path}/static/front/css/homepage.css" rel="stylesheet">
<script type="text/javascript" src="${path}/static/front/js/homepage.js"></script>

<style>
._timg {
	width: 100%;
	height: 142px;
	cursor:pointer;
}
#focus_0 .focus-bar li img{max-width:100%;}
#focus_1 .focus-bar li img{width:180px;height:151px;}
</style>

</head>
<body>
	<%@include file="../../TagLib/Menu.jsp"%>
		<!-- start 驾校宣传照片 -->
		<div class="img_content">
			<section id="side">
			        <div id="focus">
			            <div class="hd">
			            </div>
			
			            <div class="focus-bar-box" id="focus-bar-box">
			              <div class="tempWrap" style="overflow:hidden; position:relative;">
			              	<ul class="focus-bar">
				              	<c:forEach items="${IndexData.picList }" var="item" >
				              		<c:if test="${item.type==1 }">
				              			 <li style="float: left;" class="bigImg"><a href="#" style="background:url(${path }/${fn:replace(item.path,'thum/TMP_','images/IMG_')}) center no-repeat;background-size:auto 100%;"></a></li>
				              		</c:if>
				              	</c:forEach>
		              		</ul>
		              	 </div>
			            </div>
			
			            <a href="#" class="btn-prev" onclick="return false;" hidefocus="" id="focus-prev" style="display: none;"></a>
			            <a href="#" class="btn-next" onclick="return false;" hidefocus="" id="focus-next" style="display: none;"></a>
			            <div class="ft" id="ft">
			                <div class="ftbg"></div>
			                <div id="focus-num" class="change">
			                      <c:forEach items="${IndexData.picList }" var="item" varStatus="status">
				              		<c:if test="${item.type==1 }">
				              			 <a class="${status.index==0?'on':'' }"></a>
				              		</c:if>
				              	</c:forEach>
                             </div>
			            </div>
			        </div>
					<div class="clear"></div>
				 </section>	 
		</div>
		<!-- end 驾校宣传照片 -->
		<div style="position: fixed;*position: absolute;width: 111px;height: 231px;top: 45%;right:0px;z-index: 99999;  padding-top: 84px;  padding-left: 25px;background:url('${path}/static/images/kf.png') no-repeat left top;">
			<div>
				  <span style="color: #330000;font-size: 13px;margin-left: 22px;">客服1</span>
				  <a target="_blank"  href="http://wpa.qq.com/msgrd?v=3&uin=3137160186&site=qq&menu=yes">
				  	<img border="0" src="http://wpa.qq.com/pa?p=2:3137160186:51" alt="点击我联系客服1" title="点击我联系客服1"/>
				  </a>
			</div>
			<div style="margin-top:15px;">
				  <span style="color: #330000;font-size: 13px;margin-left: 22px;">客服2</span>
				  <a target="_blank"  href="http://wpa.qq.com/msgrd?v=3&uin=1378182833&site=qq&menu=yes">
				    <img border="0" src="http://wpa.qq.com/pa?p=2:1378182833:51" alt="点击我联系客服2" title="点击我联系客服2"/>
				  </a>
			</div>
		</div>
		<div class="clear"></div>
	<div class="wrap_container yahei" id="wrap_container">
		<div id="d-model">
			
		</div>
		<!-- start 报名电话 -->
		<div class="apply_phone">
			<ul>
				<li class="apply_img"><img src="${path}/static/front/images/phone.png"></li>
				<li class="apply_call f16">报名热线：${phone2 } （仅限固话拨打）<br/>客服QQ:2453270882</li>
				<li class="apply_photo"><img
					src="${path}/static/front/images/apply_photo.png"></li>
				<li>
					<span class="f22 grey">网上自主报名</span>
					<div id="apply_go">
						<input type="button" class="white f16" value="立即报名" onclick="javascript:window.location='${path}/stu/registerStu'" />
						<input type="button" class="white f16" value="在线预约" onclick="javascript:window.location='${path}/stu/stuIndex?sign=/stu/addLessonInfo'" />
					</div>
				</li>
			</ul>
		</div>
		<!-- end 报名电话 -->
		<!-- start 左侧部分 -->
		<div class="left_part">

			<!-- start 金牌教练 -->
			<div class="left_part_two" id="gold_coach">
				
			</div>
			<!-- end 金牌教练 -->
			<div style="margin:20px 0px 25px 0px"><img src="${path }/static/img/ad_12.png"/></div>
			<!-- start 优秀学员榜 -->
			<div class="left_part_three">
				<h1>
					优秀学员榜
					<c:forEach varStatus="schoolStatus" var="item"
						items="${IndexData.campusInfo }">
						<c:if test="${schoolStatus.first eq false }">
							<span schoolId="${item.id }" class="f16">${item.title }</span>
						</c:if>
						<c:if test="${schoolStatus.first }">
							<span schoolId="${item.id }" class="f16 selected">${item.title }</span>
						</c:if>
					</c:forEach>
				</h1>
				<div class="left_part_three_box nsxqxy">
					<ul class="xy_head f16">
						<li>排名</li>
						<li>学员</li>
						<li>报名日期</li>
						<li>科目二成绩</li>
					</ul>
				</div>
			</div>
			<!-- end 优秀学员榜 -->
		</div>
		<!-- end 左侧部分 -->
		<!-- start 右侧部分 -->
		<div class="right_part">
			<!-- start 最新报名 -->
			<div class="right_part_one">
				<h1>最新报名</h1>
				<div class="right_box_one">
					<ul class="bm_head f14">
						<li>学员</li>
						<li>驾照</li>
						<li>时间</li>
					</ul>
					<c:forEach varStatus="stuStatus" var="item"
						items="${IndexData.newStudents }">
						<c:if test="${stuStatus.first }">
							<ul style="border-top: none;" class="bm_list f14">
						</c:if>
						<c:if test="${stuStatus.first eq false }">
							<ul class="bm_list f14">
						</c:if>
						<li class="gold">${item.name }</li>
						<li>${item.licenceName }</li>
						<li><fmt:formatDate value="${item.date }" type="date"
								pattern="yyyy-MM-dd" /></li>
						</ul>
					</c:forEach>

				</div>
			</div>
			<!-- end 最新报名 -->
			<div style="margin:20px 0px;"><img src="${path }/static/img/ad_13.png"/></div>
			<!-- start 驾校公告 -->
			<div class="right_part_two">
				<h1 class="pointer" onclick="javascript:window.location='${path}/pageMessage/viewNotice'">驾校公告</h1>
				<div class="right_box_two">
					<div class="jxgg_ul f14" id="jxgg">
					</div>
				</div>
			</div>
			<!-- end 驾校公告 -->
			<!-- start 常见问题 -->
			<div class="right_part_two">
				<h1 class="pointer" onclick="javascript:window.location='${path}/pageMessage/viewQuestion'">常见问题</h1>
				<div class="right_box_two">
					<div class="jxgg_ul f14" id="jxwt">
					</div>
				</div>
			</div>
			<!-- end 常见问题 -->
		</div>

		<!-- end 左侧部分 -->
		<!-- start 场地照片 -->
		<div class="place_pic">
			<h1>场地照片</h1>
			<div class="place_pic_box">
				<section id="side_0">
			        <div id="focus_0">
			            <div class="focus-bar-box" id="focus-bar-box_0">
			              <div class="tempWrap" style="overflow:hidden; position:relative; width:1000px;padding-left:19px;">
			              	<ul id="place_bar" class="focus-bar" style="width: 4020px; left: -3350px; position: relative; overflow: hidden; padding: 0px; margin: 0px;">
			              	
			              	<c:set var="index" value="0"></c:set>
			              	<c:forEach var="item"  items="${IndexData.picList }" varStatus="status" >
			              		<c:if test="${item.type==2 }">
			              		 	<c:if test="${index%4==0 }">
			              		 		<li style="float: left; width: 998px;">
			                      		<ul>
			              		 	</c:if>
			              		 	
			              		 	<li>
										<a href="${path}${fn:replace(item.path,'thum/TMP_','images/IMG_')}" class="group1" title="${item.title}">
										<img src="${path}${item.path}">
										</a>
									</li>
			              		 	<c:if test="${(index+1)%4==0}">
			              		 		</ul></li>
			              		 	</c:if>
			              		 	<c:set var="index" value="${index+1 }"></c:set>
								</c:if>
								<c:if test="${index%4!=0 && status.index==(fn:length(IndexData.picList)-1)}"></ul></li></c:if>
							</c:forEach>
		              		</ul>
		              	 </div>
			            </div>
						
						<div class="ft">
			                <div id="focus-num_0" class="change">
			                	<c:set var="index" value="0"></c:set>
			                	<c:forEach var="item"  items="${IndexData.picList }" >
			                		<c:if test="${item.type==2 }">
			                			<c:if test="${index%4==0 }">
			                				<a class="${index==0?'on':'' }"></a>
			                			</c:if>
			                			<c:set var="index" value="${index+1 }"></c:set>
			                		</c:if>
				              	</c:forEach>
							 </div>
			            </div>

			        </div>
					<div class="clear"></div>
				 </section>	 
			
				
			
			</div>
		</div>
		
		<!-- end 场地照片 -->
		<!-- start 荣誉分享 -->
		<div class="honor_pic">
			<h1>荣誉分享</h1>
			<div class="honor_pic_box">
			<section id="side_1">
			        <div id="focus_1">
			            <div class="focus-bar-box" id="focus-bar-box_1">
			              <div class="tempWrap" style="overflow:hidden; position:relative; width:998px">
			              	<ul id="honor_bar" class="focus-bar" style="width: 4020px; left: -3350px; position: relative; overflow: hidden; padding: 0px; margin: 0px;">
								<c:set var="index" value="0"></c:set>
				              	<c:forEach var="item"  items="${IndexData.picList }" varStatus="status" >
				              		<c:if test="${item.type==3 }">
				              		 	<c:if test="${index%5==0 }">
				              		 		<li style="float: left; width: 998px;">
				                      		<ul>
				              		 	</c:if>
				              		 	
				              		 	<li>
											<a href="${path}${fn:replace(item.path,'thum/TMP_','images/IMG_')}" class="group2" title="${item.title}">
											<img src="${path}${item.path}">
											</a>
										</li>
				              		 	<c:if test="${(index+1)%5==0}">
				              		 		</ul></li>
				              		 	</c:if>
				              		 	<c:set var="index" value="${index+1 }"></c:set>
									</c:if>
									<c:if test="${index%5!=0 && status.index==(fn:length(IndexData.picList)-1)}"></ul></li></c:if>
								</c:forEach>
		              		</ul>
		              	 </div>
			            </div>
			
			            <div class="ft">
			               <!--  <div class="ftbg"></div> -->
			                <div id="focus-num_1" class="change">
				                <c:set var="index" value="0"></c:set>
			                	<c:forEach var="item"  items="${IndexData.picList }" >
			                		<c:if test="${item.type==3 }">
			                			<c:if test="${index%5==0 }">
			                				<a class="${index==0?'on':'' }"></a>
			                			</c:if>
			                			<c:set var="index" value="${index+1 }"></c:set>
			                		</c:if>
			                		
				              	</c:forEach>
                             </div>
			            </div>
			        </div>
					<div class="clear"></div>
				 </section>	 
			</div>
		</div>
		
		<!-- end 荣誉分享 -->
	</div>
	<div class="footer">
		<div class="footer_center">
			<div class="clearfix">
				<div class="col-md-12 column ">
					<div class="footer_one" style=" width: 100px;">
						<h3>关于</h3>
						<ul>
							<li><a>版权声明</a></li>
							<li><a>关于隐私</a></li>
							<li><a>免责声明</a></li>
							<li><a>网站地图</a></li>
							<li><a>加入慧莘</a></li>

						</ul>
					</div>
					<div class="footer_two" style=" width: 100px;">
						<h3>友情链接</h3>
						<ul>
						<c:forEach var="friend_link" items="${friend_links }">
							<li><a href="${friend_link.value }">${friend_link.title }</a></li>
						</c:forEach>
						</ul>

					</div>
					<div class="footer_three">
						<h3>服务热线</h3>
						<ul>
 							<li style="border:1px solid #009AE0;width:205px;">
 								<div style="height:35px;background-color:#009AE0;text-align:center;color:white;line-height:35px;">
 									周一至周五&nbsp;&nbsp;${service_period }
 								</div>
 								<div style="font-size:24px;text-align:center;">${phone1 }</div>
 							</li>
 							<li style="margin-top:15px;">
 								<a><img src="${path }/static/images/b1.gif"/></a>
 								<a><img src="${path }/static/images/b2.gif"/></a>
 							</li>
						</ul>

					</div>
					<div class="footer_four">
						<h3>关注我们</h3>
						<ul>
							<li><img src="${path}/static/images/wx.png"><img style="margin-left:50px;" src="${path}/static/images/qq.png"></li>
						</ul>
					</div>
				</div>
				<div id="copyright">
					 &nbsp;&nbsp;&nbsp;  ${filings }  &nbsp;&nbsp;&nbsp; 
					   ${filings_address }&nbsp;&nbsp;&nbsp;${license }    
					   <br/> &nbsp;&nbsp; ${filings_code }  &nbsp;&nbsp;&nbsp;  ${copyRight_years }
					   <br>
					   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					   ${advice }
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	
	$(".bigImg").width($("#focus").width());

	function teaImg(obj) {
		$(obj).attr("src", "${path}/static/img/defaultPic.jpg").attr("onerror", "");
	}
	
	function jumpPage(url){
		$.get(url,function(data){
			$("#wrap_container").html(data);
		});
	}

	function loadStuData(schoolId) {
		$.ajax({
			type : "POST",
			url : "${path}/querySchoolStudent",
			data : {
				schoolId : schoolId
			},
			success : function(data) {
				fillStuData(data);
			}
		});
	}
	function fillStuData(e) {
		var data = eval(e);
		var text = "";
		for (var i = 0; i < data.length; i++) {
			text = "<ul class='xy f16'><li><span>" + (i + 1)
					+ "</span></li><li class='gold'>" + data[i].name
					+ "</li><li>" + data[i].createDate + "</li><li>"
					+ data[i].score + "</li><li>";
			$(".left_part_three_box").append(text);
		}
	}

	$(function() {
		//获取驾校公告信息
		$.post("${path}/pageMessage/queryMessageByKindKey", {
			"kindKey" : "6"
		}, function(data) {
			var _con = $("#jxgg");
			data = $.parseJSON(data);
			$.each(data, function(index, item) {
				var obj = $('<ul><li><a href="${path}/pageMessage/viewInfo?id='
						+ item.id + '">' + item.title + '</a></li></ul>');
				if (index == 0) {
					obj.css("border-top", "none");
				}
				_con.append(obj);
			});
		});

		//获取常见问题
		$.post("${path}/pageMessage/queryMessageByKindKey", {
			"kindKey" : "7"
		}, function(data) {
			var _con = $("#jxwt");
			data = $.parseJSON(data);
			$.each(data, function(index, item) {
				var obj = $('<ul ><li><a href="${path}/pageMessage/viewInfo?id='
						+ item.id + '">' + item.title + '</a></li></ul>');
				if (index == 0) {
					obj.css("border-top", "none");
				}
				_con.append(obj);
			});
		});
		initGoldCoach();
	});

	
	//初始化金牌教练
	function initGoldCoach(){
		$.post("${path}/coachshow/rankCoachByMonth",null,function(data) {
			data = eval("("+data+")");
			$("#gold_coach").html("");//先清空
			var str = "<h1>金牌教练</h1>";
			for(var i=0; i<data.length; i++){
				var isFirst = true;
				var campusInfo = data[i];
				for(var j=0 ; j<campusInfo.length; j++){
					var coachInfo = campusInfo[j];
					if(isFirst){
						str += ("<div class='left_part_two_box school_"+i+" nsxqjl'>");
						str += ("<div class='top-tea-time'>");     
						str += ("<span class='title'>"+coachInfo.title+"</span>");            
						str += ("<span class='selected' onclick=changeMonth('"+coachInfo.id+"','"+new Date().pattern("yyyy-MM-dd")+"',this)>"+((new Date()).getMonth()+1)+"月榜单</span>");
						str += ("<span onclick=changeMonth('"+coachInfo.id+"','"+getDateOfPre1Month().pattern("yyyy-MM-dd")+"',this)>"+(getDateOfPre1Month().getMonth()+1)+"月榜单</span>");
						str += ("<span onclick=changeMonth('"+coachInfo.id+"','"+getDateOfPre2Month().pattern("yyyy-MM-dd")+"',this)>"+(getDateOfPre2Month().getMonth()+1)+"月榜单</span>");
						str += ("</div>");
						str += ("<div class='top-tea-box' id='school"+coachInfo.id+"'>");
						isFirst = false;
					}
					str += ("<li>");
					str += ("<div class='t-s'>NO."+(j+1)+"</div>");
					str += ("<div class='t-h'><img style='cursor:pointer;' onclick='javascript:window.location=\"${path}/coachshow/toCoachDetail?id="+coachInfo.coachId+"\"' src='${path}"+((coachInfo.path == undefined || coachInfo.path=='')?'/static/img/p1.png':coachInfo.path)+"'></div>");
					str += ("<div class='t-n'>姓名："+coachInfo.name+"</div>");
					str += ("<div class='t-t'>类型："+coachInfo.coachAllowCarType+"</div>");
					str += ("<div>");
					if(coachInfo.serviceScore){//对应教练没有星评  那么就没有这个字段 就是undefined 那么此时就走这里 还有0星评  也是走这里
					    var ystar = parseInt(coachInfo.serviceScore);
					    var nstar = 5 - ystar;
					    for(var k=0 ;k < ystar; k++){
					    	str += ("<img src='${path }/static/images/y-star.png'/>");
					    }
					    for(var k=0 ;k < nstar; k++){
					    	str += ("<img src='${path }/static/images/n-star.png'/>");
					    }
					}else{//没有星评 或者0星评 就给他5个空星
						str += ("<img src='${path }/static/images/n-star.png'/>");
						str += ("<img src='${path }/static/images/n-star.png'/>");
						str += ("<img src='${path }/static/images/n-star.png'/>");
						str += ("<img src='${path }/static/images/n-star.png'/>");
						str += ("<img src='${path }/static/images/n-star.png'/>");
					}
					str += ("</div>");
					str += ("</li>");
					if(j == campusInfo.length-1){
						str += ("</div>");
						str += ("</div>");
					}
				}
			}
			$("#gold_coach").html(str);
		});
	}
	
	//选的月份变了 加载对应的教练排行
	function changeMonth(campusId,date,obj){
	
		$(obj).siblings(".selected").attr("class","");
		$(obj).attr("class","selected");
		var id = "school"+campusId;
		
		var param = {
			date:date,
			campusId:campusId
		};
		$("#"+id).html("");//先清空
		$.post("${path}/coachshow/rankCoachByMonth",param,function(data) {
			data = eval("("+data+")");
			var str = "";
			for(var i=0; i<data.length; i++){
				var campusInfo = data[i];
				for(var j=0 ; j<campusInfo.length; j++){
					var coachInfo = campusInfo[j];
					str += ("<li>");              
					str += ("<div class='t-s'>NO."+(j+1)+"</div>"); 
					str += ("<div class='t-h'><img style='cursor:pointer;' onclick='javascript:window.location=\"${path}/coachshow/toCoachDetail?id="+coachInfo.coachId+"\"' src='${path}"+((coachInfo.path == undefined || coachInfo.path=='')?'/static/img/p1.png':coachInfo.path)+"'></div>");
					str += ("<div class='t-n'>姓名："+coachInfo.name+"</div>");
					str += ("<div class='t-t'>类型："+coachInfo.coachAllowCarType+"</div>");
					str += ("<div>");
					if(coachInfo.serviceScore){//对应教练没有星评  那么就没有这个字段 就是undefined 那么此时就走这里 还有0星评  也是走这里
					    var ystar = parseInt(coachInfo.serviceScore);
					    var nstar = 5 - ystar;
					    for(var k=0 ;k < ystar; k++){
					    	str += ("<img src='${path }/static/images/y-star.png'/>");
					    }
					    for(var k=0 ;k < nstar; k++){
					    	str += ("<img src='${path }/static/images/n-star.png'/>");
					    }
					}else{//没有星评 或者0星评 就给他5个空星
						str += ("<img src='${path }/static/images/n-star.png'/>");
						str += ("<img src='${path }/static/images/n-star.png'/>");
						str += ("<img src='${path }/static/images/n-star.png'/>");
						str += ("<img src='${path }/static/images/n-star.png'/>");
						str += ("<img src='${path }/static/images/n-star.png'/>");
					}
					str += ("</div>");
					str += ("</li>");
				}
		    }
			$("#"+id).html(str);
		});
	}
	
	// 计算当前月一共多少天  
	function getDayOfMonth(y, Mm) {  
	    if (typeof y == 'undefined') { 
	    	y = (new Date()).getFullYear(); 
	    }  
	    if (typeof Mm == 'undefined') { 
	    	Mm = (new Date()).getMonth(); 
	    }  
	    var Feb = ((y>0) && !(y%4) && ((y%100)||!(y%400))) ? 29 : 28;  
	    var aM = new Array(31, Feb, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);  
	    return  aM[Mm];  
	}; 
	
	// 返回上一月的日期  
	function getDateOfPre1Month(dt) {  
	    if (typeof dt == 'undefined') { 
	    	dt = (new Date()); 
	    }  
	    var y = (dt.getMonth() == 0) ? (dt.getFullYear() - 1) : dt.getFullYear();  
	    var m = (dt.getMonth() == 0) ? 11 : dt.getMonth() - 1;  
	    var preM = getDayOfMonth(y, m); 
	    var d = (preM < dt.getDate()) ? preM : dt.getDate();  
	    return new Date(y, m, d);  
	};  
	
	// 返回上上月的日期  
	function getDateOfPre2Month(dt) {  
	    if (typeof dt == 'undefined') { 
	    	dt = (new Date()); 
	    }  
	    var y = (dt.getMonth() == 0) ? (dt.getFullYear() - 1) : dt.getFullYear();  
	    var m = (dt.getMonth() == 1) ? 11 : ((dt.getMonth() == 0) ? 10 : (dt.getMonth() - 2));  
	    var preM = getDayOfMonth(y, m); 
	    var d = (preM < dt.getDate()) ? preM : dt.getDate();  
	    return new Date(y, m, d);  
	}; 
	
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
</html>
