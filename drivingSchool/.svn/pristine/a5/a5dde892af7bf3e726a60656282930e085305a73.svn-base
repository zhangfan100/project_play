<%@page import="com.HuiShengTec.base.entity.PageBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/FroJSLib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author" content="">
	<link href="${path}/static/front/css/coach_detail.css" rel="stylesheet">
	<link href="${path}/static/front/css/jPages.css" rel="stylesheet" >
	<script src="${path}/static/front/js/jPages.js"></script>
	<script type="text/javascript" src="${path}/static/front/js/coach_detail.js"></script>
	<style type="text/css">
		.coach_photo img{max-width:410;max-height:325px;}
		.coach_img img{width:466px;max-height:316px;}
	</style>
	
</head>
<body>
	<%@include file="../../TagLib/Menu.jsp"%>
	
	<div class="wrap_container yahei">
		<div class="top_content">
			<ul class="breadcrumb f16">
				<li>
					<a class="f16" href="${path }">首页</a> <!-- <span class="divider">></span> -->
				</li>
				<li>
					<a class="f16" href="${path }/coachshow/redirectCoachshow">教练风采</a> <!-- <span class="divider">></span> -->
				</li>
				<li class="active">
					教练风采
				</li>
			</ul>
		
		</div>
		<div class="main_content">
			<div class="content_up">
				<div class="coach_photo">
					<img src="${path}${teaImgOne.path}" onerror="photo_error(this);">
				</div>
				<div class="coach_detail">
					<div class="coach_name f24  grey">${data.rows[0].title}—${data.rows[0].name}</div>
					<ul class="f18">
						<li>
							<span class="light_grey">驾龄：</span>（${data.rows[0].drivingAge}年）
						
						</li>
						<li>
							<span class="light_grey">教龄：</span>（ ${data.rows[0].coachAge}年）
						
						</li>
						<%-- <li>
							<span class="light_grey">类型：</span><c:if test="${data.rows[0].teacher_type==0}">培训教员</c:if>
						<c:if test="${data.rows[0].teacher_type==1}">模拟教练</c:if>
						</li> --%>
						<li>
							<span class="light_grey">评分：</span>
							<a href="" target="_blank">
								<%
									PageBean bean = (PageBean)request.getAttribute("data");
									HashMap<String,Object> strs = (HashMap<String,Object>)bean.getRows().get(0);
									String score = String.valueOf(strs.get("coachScore"));
									Float sc = Float.parseFloat(score);
									Integer full = sc.intValue();
									Float half = sc-full;
									for(int i=0;i<full;i++){%>
										<i style="background-image:url(../static/images/home_star_0.png)"></i>
									<%} 
									if(half>0){%>
										<i style="background-image:url(../static/images/home_star_1.png)"></i>
									<%
									}
									%>
                                   
                           	</a>
							&nbsp;${data.rows[0].coachScore}分
						
						</li>
						 <li>
							<span class="light_grey">评价：</span><a class="red">  <c:if test="${empty commentNum[0].total}">0</c:if> <c:if test="${not empty commentNum[0].total}">${commentNum[0].total}</c:if>  </a>条评价
						
						</li>
					</ul>
				
				</div>
				
			
			</div>
			<div class="coach_content">
					<div class="coach_head f16 bold">
						<ul>
							<li class="menuItem active"><a href="#infor">教练信息</a></li>
							<li class="menuItem"><a href="#picture">照片信息</a></li>
							<li class="menuItem"><a href="#value">评价信息</a></li>
						</ul>
					
					</div>
					<div id="infor" class="coach_info f16">
						<ul>
							<li>教　　龄：${data.rows[0].coachAge}年</li>
							<li>驾        龄：${data.rows[0].drivingAge}年</li>
							<li>教练证号：${data.rows[0].coachCode}</li>
							<li>教练介绍：  教练有${data.rows[0].drivingAge}年驾龄、${data.rows[0].coachAge}年教龄，能对每位学员的弱点强化训练,认真负责，
							细心，耐心，深得学员好评。对工作任劳任怨，训练好每位学员，使学车的每位学员乘兴而来，满意而归。</li>
						
						
						</ul>
					
					
					</div>
					<div id="picture" class="coach_img">
						<div class="coach_img_head f20">照片信息</div>
						<ul>
							<c:if test="${fn:length(cohImgTwo)==0}"><span style="color:gray;display:block;margin:10px;">暂无信息...</span></c:if> 
							<c:forEach var="teaImage" items="${cohImgTwo}" varStatus="status">
								<li><img src="${path}${teaImage.path}"></li>
							</c:forEach>
						</ul>
					</div>
					<div id="value" class="coach_value">
						<div class="coach_value_head f20">评价详情</div>
						<div class="coach_value_all">
							<div class="rate-score">
								
								<strong>${data.rows[0].coachScore}</strong>
								<p>
								<span>
									<%
									for(int i=0;i<full;i++){
									%>
										<img src="${path}/static/images/home_star_0.png"/>
									<%}
									if(half>0){%>
										<img src="${path}/static/images/home_star_1.png"/>
									<%}
									%>
								</span>
								</p>
								<h4>总 评 价</h4>
								
							</div>
							<div class="rate_box">
								<ul >	
									<c:forEach items="${commentNum }" var="item" >
										<li>
											<span class="first">${item.score }分</span>
											<span class="tar">
												<c:forEach begin="1" end="${item.score }">
													<img src="${path}/static/images/home_star_0.png"/>
												</c:forEach>
											</span>
											<span class="people">${item.total }人</span>
										</li>
									</c:forEach>
								</ul>
							
							
							</div>
								
						</div>
						<div class="coach_value_list">
							<ul class="rank_content_ul" id="rank_content_ul">
							<%
								List<HashMap<String,Object>> comments = (List<HashMap<String,Object>>)request.getAttribute("commentInfo");
								for(HashMap<String,Object> comment:comments){
									Double d = null;
									if(comment.get("totalScore")==null){
										d=0d;
									}else{
										d = Double.parseDouble(String.valueOf(comment.get("totalScore")));
									}
									Integer c_full = d.intValue();
									Double c_half = d-c_full;%>
									<li>
										<div class="rate_name"><span>
									<%
									for(int i=0;i<c_full;i++){%>
										<img src="${path}/static/front/images/home_star_0.png"/>
								<%}
									if(c_half>0){
								%>
									<img src="${path}/static/front/images/home_star_1.png"/>
									<% }%>
									</span>
									<span class="name">（<%=comment.get("name") %>）</span>	
									<span class="time"><%=comment.get("reviewTime") %></span>
									</div>
									<div class="content"><%=comment.get("content") %></div>
									
									</li>	
							<%
							}
							%>
								
							</ul>
						<div class="holder"></div>
						
						</div>
						
				
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
  
  <script src="${path }/static/front/js/stickUp.min.js"></script>
 <script type="text/javascript">
 $(".topnav .active").removeClass("active");
	$.each($(".topnav a"),function(index,item){
		if($(this).text().trim()=="教练风采"){
			$(this).parents("li").addClass("active");
			return false;
		}
	});
 		function photo_error(obj){
 			$(obj).attr("src","${path}/static/images/no_img.jpg").attr("onerror", "");
 		}
             //initiating jQuery  
             jQuery(function($) {
               $(document).ready( function() {
            	   <%
            	   List<HashMap<String,Object>> lists = (List<HashMap<String,Object>>) request.getAttribute("commentInfo");
            	   if(lists.size()==0){
            	   %>
            	   $("div.holder").removeClass("holder");
            	   <%}%>
                 //为 '.navbar-wrapper' class 启用stickUp插件
               	$('.coach_head').stickUp({
                       parts: {
                         0:'infor',
                         1:'picture',
                         2: 'value'
                       },
                       itemClass: 'menuItem',
                       itemHover: 'active'
                     });
               	
               	$("#teacherFc").addClass("active");
               	$("#indx").removeClass("active");
               });
             });
           
           </script>
</html>
