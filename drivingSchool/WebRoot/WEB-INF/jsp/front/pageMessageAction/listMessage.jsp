<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/FroJSLib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>${jx_chineseName }</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="">
  <link href="${path }/static/front/css/jPages.css" rel="stylesheet" >
	<link href="${path }/static/front/css/school_notice.css" rel="stylesheet">
	<script type="text/javascript" src="${path }/static/front/js/jPages.js"></script>
	
	<style>
		.notice_list ul li a .notice_time{width:138px;margin-right:20px;}
		.notice_list ul li a .notice_title{width:492px;}
	</style>
</head>

<body>
	<%@include file="../../TagLib/Menu.jsp"%>
	<div class="wrap_container yahei">
		<div class="top_content">
			<ul class="bread_href f16">
				<li>
					<a class="f16" href="${path }">首页</a> <span class="divider">></span>
				</li>
				<li class="active">
					${kindName}
				</li>
			</ul>
		
		</div>
		<div class="main_content">
			<div class="left_content">
				
				
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
				
			
			</div>
			<div class="right_content">
				<div class="right_list">
					<div class="notice_head">${kindName}</div>
					<div class="notice_list">
						<ul class="notice_ul" id="notice_ul">
							
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
					${copyRight_info } &nbsp;&nbsp;&nbsp;  ${filings }  &nbsp;&nbsp;&nbsp;  ${license } &nbsp;&nbsp;&nbsp;  ${filings_address }  <br/>  ${filings_code }  &nbsp;&nbsp;&nbsp;  ${copyRight_years }
				</div>
			</div>
		</div>
	</div>
</body>

<script type="text/javascript">
	
	var kindKey = "${kindKey}";


	var pagesize = 10;//每页条数
	$(document).ready(function() {
	 	$.ajax({							//获取总页数，设置pagesize
			type:"POST",
			url:"${path}/pageMessage/listMessage",		//后台action，
			data: {rows:pagesize,page:1,kindKey:kindKey},	
			dataType:"json",
			success:function(notice){
				$("#notice_ul").html("");
				
				for(var i=0;i<notice.total;i++){
					$("#notice_ul").append('<li></li>');
				}
				fillCurrPage(notice.rows,1);
				
				if(notice.total<=pagesize)
					return;
				$("div.holder").jPages({
					containerID : "notice_ul",
					previous : "",
					next : "",
					perPage : pagesize,
					delay : 20,
					callback : pageAjax
				});	
			}
	    });
		
	});
	
	function fillCurrPage(rows,currentPage){
		for(var i=0;i<rows.length;i++){
			var content = '<span class="arrow">></span>'
						+ '<a href="${path}/pageMessage/viewInfo?id='+rows[i].id+'">'
						+ 	'<span class="notice_title">' + rows[i].title + '</span>'
						+ 	'<span class="notice_time">' + rows[i].messageDate + '</span>'
						+ '</a>';
		
			//放入内容
			$("#notice_ul").find("li").eq( (currentPage-1)*pagesize+i ).html(content);
		}
	}

	//分页回调
	function pageAjax( pages, items ) { 
		//alert(pages.current);  				//获取被选中的页数
		$.ajax({
			type:"POST",
			url:"${path}/pageMessage/listMessage",			//后台action
			data: {rows:pagesize,page:pages.current,kindKey:kindKey},			//请求 第pages.current页 的公告
			dataType:"json",
			success:function(notice){
				fillCurrPage(notice.rows,pages.current);
			}
		});
	};

	
</script>
</html>
