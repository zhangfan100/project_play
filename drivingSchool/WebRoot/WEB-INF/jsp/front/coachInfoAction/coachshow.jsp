<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/FroJSLib.jsp"%>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="">
  <link href="${path}/static/front/css/jPages.css" rel="stylesheet">
  <link href="${path}/static/front/css/coachshow.css" rel="stylesheet">
  <script type="text/javascript" src="${path}/static/front/js/coach_show.js"></script>
	<style type="text/css">
		 .left_content_one{
		 	min-height:225px;
		 	height:auto;
		 }
		 .right_content .rank_photo img{
		 	width: 90px;
			height: 125px;
		 }
	</style>
</head>
<body>
	<%@include file="../../TagLib/Menu.jsp"%>	
	<div class="wrap_container yahei">
		<div class="top_content">
			<ul class="breadcrumb f16">
				<li>
					<a class="f16" href="javascript:void(0);">首页</a> 
				</li>
				
				<li class="active">
					教练风采
				</li>
			</ul>
		
		</div>
		<div class="main_content">
			<div class="left_content">
				
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
							<li><a class=""  href="${path}/stu/onlinebooking"><img src="${path }/static/front/images/zxyy_1.png">在线预约</a></li>
							<li><a class=""  href="${path}/stu/login"><img src="${path }/static/front/images/tjpx_1.png">培训统计</a></li>
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
			<div class="right_content">
				<h1>筛选条件</h1>
				<div class="sx_list">
					<ul class="f16 gold">
						<li>
							<span class="sx_title">校 区 ：</span>
							<span class="no_request back" onclick="queryTeacherInfo()"><a>全 部</a></span>
							<c:forEach var="x" items="${xq}">
							<span onclick="queryTeacherInfo()"><a>${x.title}</a></span>
							</c:forEach>
						</li>
						<li>
							<span class="sx_title">驾 龄 ：</span>
							<span class="no_request back" onclick="queryTeacherInfo()"><a>不 限</a></span>
							<span onclick="queryTeacherInfo()"><a>五 年 以 下</a></span>
							<span onclick="queryTeacherInfo()"><a>5 - 10 年</a></span>
							<span onclick="queryTeacherInfo()"><a>十 年 以 上</a></span>
						</li>
						<li>
							<span class="sx_title">性 别 ：</span>
							<span class="no_request back" onclick="queryTeacherInfo()"><a>不 限</a></span>
							<span onclick="queryTeacherInfo()"><a>男</a></span>
							<span onclick="queryTeacherInfo()"><a>女</a></span>
						</li>
					</ul>
				
				
				</div>
				<div class="ranking_div">
					<div class="rank_head f14 bold">
						<ul>
							<li class="first active" onclick="queryTeacherInfo()">好评率</li>
							<li onclick="queryTeacherInfo()">教龄</li>
							<li onclick="queryTeacherInfo()">驾龄</li>
							<!-- <li onclick="queryTeacherInfo()">通过率</li> -->
						</ul>
					
					</div>
					<div class="rank_content">
						<ul class="rank_content_ul" id="rank_content_ul">
							
						</ul>
					</div>
				</div>
				<div class="holder"></div>
				
			
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
	<script type="text/javascript">
		var name = '<%=request.getAttribute("name")%>';
		var signs = '<%=request.getAttribute("signs")%>';
		$(function(){
			queryTeacherInfo();
			$("#query1").click(function(){
				queryTeacherInfo();
			});
		});
		
		function teaImg(obj) {
			$(obj).attr("src", "${path}/static/img/defaultPic.jpg").attr("onerror", "");
		}
		
		function queryTeacherInfo(){
			if(signs==1){
				$("#name").val(name);
				signs=0;
			}
			$(".sx_list ul li span:hover").siblings().removeClass("back");
			$(".sx_list ul li span:hover").addClass("back");
			$(".rank_head ul li:hover").siblings().removeClass("active");
			$(".rank_head ul li:hover").addClass("active");
			var title = $(".sx_list ul li:eq(0) .back a").text();
			var drivingAge = $(".sx_list ul li:eq(1) .back a").text();
			var sex = $(".sx_list ul li:eq(2) .back a").text();
			var name=$("#name").val();
			var sortType = $(".ranking_div div:eq(0) .active").text();
			$.ajax({
				type:'POST',
				url:'${path}/coachshow/queryCoachshowInfo',
				data:{
					title:title,
					drivingAge:drivingAge,
					sex:sex,
					name:name,
					sortType:sortType
				},
				dataType:'json',
				success:function(data){
					$("#rank_content_ul li").remove();
					if(data.rows){
						var html='';
						for(var i=0;i<data.rows.length;i++){
							var row = data.rows[i];
							if(row.pass_rate==undefined){
								row.pass_rate=null;
							}
							if(row.teacher_score==undefined){
								row.teacher_score=null;
							}
							if(row.path==undefined){
								row.path='${path}/static/img/defaultPic.jpg';
							}
							var text_star = "";
							if(row.coachScore!=null){
								var integer = parseInt(row.coachScore);
								var decimals = row.coachScore - integer;
								for (var j = 0; j < integer; j++) {
									text_star += '<img src="${path}/static/front/images/home_star_0.png"/>';
								}
								if (decimals > 0) {
									text_star += '<img src="${path}/static/front/images/home_star_1.png"/>';
								}
							}
							html+='<li class="rank_content_li"><div class="rank_photo"><a href="${path }/coachshow/toCoachDetail?id='+row.id+'"><img src="${path}'+row.path+'" onerror="teaImg(this)"/></a></div>'+
							'<div class="rank_detail"><span class="f18 bold"><a href="${path }/coachshow/toCoachDetail?id='+row.id+'">'+row.name+'</a></span><span class="f18 gold bold"> （金牌教练）</span>'+
							'<ul class="f16"><li>驾龄：'+row.drivingAge+'</li><li>教龄：'+row.coachAge+'</li><li>通过率：'+(row.pass_rate==null?'无':row.pass_rate)+'</li></ul></div>'+
							'<div class="rank_score"><span class="bold f40">'+row.coachScore+'<span class="bold f20">分</span><br/></span><span>'+text_star+'</span></div></li>';
						}
						$("#rank_content_ul").html(html);
						$("div.holder").jPages({
						      containerID : "rank_content_ul",
						      previous : "",
						      next : "",
						      perPage : 6,
						      delay : 20
						 });
					}
				}
			});
		}
		
		$(".topnav .active").removeClass("active");
		$.each($(".topnav a"),function(index,item){
			if($(this).text().trim()=="教练风采"){
				$(this).parents("li").addClass("active");
				return;
			}
		});
		
		
		$(function() {
			//获取驾校公告信息
			$.post("${path}/pageMessage/queryMessageByKindKey", {
				"kindKey" : "6"
			}, function(data) {
				var _con = $("#jxgg");
				data = $.parseJSON(data);
				$.each(data, function(index, item) {
					var obj = $('<li><a href="${path}/pageMessage/viewInfo?id='
							+ item.id + '">' + item.title + '</a></li>');
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
					var obj = $('<li><a href="${path}/pageMessage/viewInfo?id='
							+ item.id + '">' + item.title + '</a></li>');
					if (index == 0) {
						obj.css("border-top", "none");
					}
					_con.append(obj);
				});
			});
		});
	</script>
</body>

