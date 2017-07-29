<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/TagLib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<%@include file="../../TagLib/StuLib.jsp"%>

</head>
<body>
	<%@include file="../../TagLib/Menu.jsp"%>
	<script type="text/javascript" src="${path }/static/scripts/highcharts/highcharts.js"></script>
	<div class="wrap_container yahei">
		<div class="main_content">
			<div class="left_content">
				<div class="left_content">
					<h2>个人中心</h2>
					<div class="person_nav">
					<ul>
					<c:forEach items="${stumenu }" var="item" varStatus="status">
				<li class="${item.iconClass }">
					<h3>
					<span <c:if test="${item.url!=null }">url="${path }${item.url }"</c:if> class="person_nav_li">
						 	${item.title }
						 	<c:if test="${fn:length(item.childrens)>0 }"><span class="sub"></span></c:if>
					</span>
					</h3>
				</li>
				<ul><li>
				<c:if test="${fn:length(item.childrens)>0 }"> 
						<ul><li>
							<c:forEach var="item1" items="${item.childrens }" varStatus="status1">
								<li>
							<a href="javascript:void(0);" url="${item1.url }" onclick="jumpPage('${path }${item1.url }',this)">
								${item1.title }
							</a>
								</li>
							</c:forEach>
						</li></ul>
					</c:if>
				</li></ul>
			</c:forEach>
			</ul>
			</div>
		</div>
			</div>
			<div id="right_panel"></div>
			<div id="p"></div>
		</div>
	</div>
	<div class="footer">
		<div class="footer_center">
			<div class="clearfix">
				<div class="col-md-12 column ">
					<div class="footer_one">
						<h3>关于</h3>
						<ul>
							<li><a>版权声明</a></li>
							<li><a>关于隐私</a></li>
							<li><a>免责声明</a></li>
							<li><a>网站地图</a></li>
							<li><a>加入慧莘</a></li>

						</ul>
					</div>
					<div class="footer_two">
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
 								<div style="font-size:24;text-align:center;">${phone1 }</div>
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
				<div id="copyright" style="margin-left: 175px;">
					 &nbsp;  
					&nbsp;&nbsp;&nbsp;  ${filings  } &nbsp;&nbsp;&nbsp; 
					 ${filings_address } 
					 &nbsp;&nbsp;&nbsp;  ${license }   
					 <br/>   &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;
					 ${filings_code }  &nbsp;&nbsp;&nbsp;  ${copyRight_years }
					 <br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					 ${advice}
				</div> 
			</div>
		</div>
	</div>
	<script type="text/javascript">
	$(".topnav .active").removeClass("active");
	$(function(){
		var sign ="${param.sign}";
		if(sign!=""){
			$(".left_content a[url='"+sign+"']").click();
		}else{
			$(".left_content a:contains('培训统计')").click();
		}
	});
</script>
</body>
</html>
