<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/FroJSLib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="">
	<link href="${path}/static/front/css/profile.css" rel="stylesheet">
	<style type="text/css">
		 .left_content_one{
		 	min-height:225px;
		 	height:auto;
		 }
		 .right_content{overflow-x:hidden;}
		 .right_content img{max-width:100%;}
		 .article{width:650px;margin-top:15px;margin-bottom:15px;}
	</style>
</head>

<body>
	<%@include file="../../TagLib/Menu.jsp"%>
	<div class="wrap_container yahei">
		<div class="top_content">
			<ul class="breadcrumb f16">
				<li>
					<a class="f16" href="${path }">首页</a>
				</li>
				<li>
					<c:choose>
						<c:when test="${record.kindKey=='6'}">
							<a class="f16" href="javascript:window.location='${path}/pageMessage/viewNotice'">
						</c:when>
						<c:when test="${record.kindKey=='7'}">
							<a class="f16" href="javascript:window.location='${path}/pageMessage/viewQuestion'">
						</c:when>
						<c:otherwise>
							<a class="f16" href="javascript:void(0);">
						</c:otherwise>
					</c:choose>
						${record.kindName }
					</a>
					
				</li>
				<li class="active" id="currItem">
					${record.title }
				</li>
			</ul>
		
		</div>
		<div class="main_content">
			<div class="left_content">
				<div class="left_content_one">
					<div class="company_profile">${record.kindName }</div>
					<div class="content">
						<ul class="menu-one">
							<c:forEach items="${record.leftMenu }" var="item" varStatus="status">
								<li >
									<c:if test="${item.children==null }">
										<div class="header" id="msg${item.item.id}" onclick="javascript:forwardItem(${item.item.id});">
											<span class="txt">${item.item.title }</span>
										</div>
									</c:if>
									
									<c:if test="${item.children!=null }">
										<div class="header">
											<span class="txt">${item.item }</span>
											<span class="arrow"></span>
										</div>
										<ul class="menu-two">
											<c:forEach var="item2" items="${item.children }" varStatus="status2">
												<li >
													<a href="javascript:void(0);" id="msg${item2.id}" onclick="javascript:forwardItem(${item2.id })">${item2.title }</a>
												</li>
											</c:forEach>
										</ul>
									</c:if>
								</li>
							</c:forEach>
						</ul>
					</div>
				</div>
				<div class="left_content_two">
					<h1 class="pointer" onclick="javascript:window.location='${path}/pageMessage/viewNotice'">驾校公告</h1>
					<div class="jxgg_ul left_box_two">
						<ul class=" f14" id="jxgg">
						</ul>
					</div>
				
				
				</div>
				<!-- start 便捷服务 -->
				<div class="left_part_one">
					<h1>便捷服务</h1>
					<div class="left_box_three">
						<ul class="left_box_three_ul">
							<li><a class=""  href="${path}/stu/stuIndex?sign=/stu/addLessonInfo"><img src="${path }/static/front/images/zxyy_1.png">在线预约</a></li>
							<li><a class=""  href="${path}/stu/stuIndex?sign=/stu/studentStatistics"><img src="${path }/static/front/images/tjpx_1.png">培训统计</a></li>
							<li><a class=""  href="javascript:void(0);"><img src="${path }/static/front/images/fycx_1.png">费用查询</a></li>
							<li><a class=""  href="${path }/stu/registerStu"><img src="${path }/static/front/images/zxbm_1.png">在线报名</a></li>
						</ul>
					</div>
				</div>	
			<!-- end 便捷服务 -->
				<div class="left_content_two">
					<h1 class="pointer" onclick="javascript:window.location='${path}/pageMessage/viewQuestion'">常见问题</h1>
					<div class="jxgg_ul left_box_two">
						<ul class=" f14" id="jxwt">
						</ul>
					</div>
				</div>
			</div>
			<div class="right_content" id="right_content">
				<div class="title f18 gold bold">${record.title }</div>
				<div class="article" >
					${record.content}
				</div>
			
			
			</div>
		
		</div>
		

	
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
	var module = "${record.kindName }";
	var id = "${param.id}";
	var flag = "${flag}";
	//为驾校公告或常见问题时隐藏
	if(flag*1==1){$(".left_content_one").hide();}
	
	$(".topnav .active").removeClass("active");
	$.each($(".topnav a"),function(index,item){
		if($(this).text().trim()==module){
			$(this).parents("li").addClass("active");
			return false;
		}
	});
	
	
	$(function(){
		//获取驾校公告信息
		$.post("${path}/pageMessage/queryMessageByKindKey",{"kindKey":"6"},function(data){
			var _con = $("#jxgg");
			data = $.parseJSON(data);
			$.each(data,function(index,item){
				var obj = $('<li><a href="${path}/pageMessage/viewInfo?id='+item.id+'">'+item.title+'</a></li>');
				if(index==0){
					obj.css("border-top","none");
				}
				_con.append(obj);
			});
		});
		
		//获取常见问题
		$.post("${path}/pageMessage/queryMessageByKindKey",{"kindKey":"7"},function(data){
			var _con = $("#jxwt");
			data = $.parseJSON(data);
			$.each(data,function(index,item){
				var obj = $('<li><a href="${path}/pageMessage/viewInfo?id='+item.id+'">'+item.title+'</a></li>');
				if(index==0){
					obj.css("border-top","none");
				}
				_con.append(obj);
			});
		});
	});
	
	
	
	//查询指定模块
	function forwardItem(id){
		$.post("${path}/pageMessage/queryCompayMessageByID",{"id":id},function(data){
			data = $.parseJSON(data);
			var _content = $("#right_content");
			_content.find(".title").html(data.title);
			_content.find(".article").html(data.content);
			$("#currItem").html(data.title);
		});
	}
	
	$(document).ready(function () {
		var aMenuOneLi = $(".menu-one > li");
		var aMenuTwo = $(".menu-two");
		$(".menu-one > li > .header").each(function (i) {
			var _this = $(this);
			_this.click(function () {
				
				$(".menuTwo-current").removeClass("menuTwo-current");
				$(".menu-show").removeClass("menu-show");
				_this.next(".menu-two").addClass("menuTwo-current");
				aMenuTwo.not(".menuTwo-current").slideUp(300);
				var _mt = _this.next(".menu-two");
				if(_mt.length>0){
					_mt.slideDown(300);
					_mt.find("a:eq(0)").click();
					_this.parent().addClass("menu-show");
				}
			
			});
		});
		
		$(".menu-two > li").each(function (i) {
			$(this).click(function () {
				$(".menu-two > li").removeClass("menuTwo-current");
				$(this).addClass("menuTwo-current");
			});
		});
		if(flag*1!=1){
			if(id==""){
				aMenuOneLi.children(".header").eq(0).click();
			}else{
				var _cPM = $("#msg"+id);
				if(!_cPM.hasClass("header")){
					_cPM.parents(".menu-two").slideDown(300);
				}
				_cPM.click();
			}
		}
	});
</script>
</html>
