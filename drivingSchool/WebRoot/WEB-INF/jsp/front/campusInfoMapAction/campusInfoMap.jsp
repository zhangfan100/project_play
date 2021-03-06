<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/FroJSLib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link href="${path}/static/front/css/map.css" rel="stylesheet">

 <script type="text/javascript" src="${path}/static/front/js/api.js"></script> 
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=vGHC5il6oKkfMm9hFq2FOVoc"></script>
<script type="text/javascript" src="${path }/static/front/js/SearchInfoWindow.js"></script>
<link rel="stylesheet" href="${path }/static/front/css/SearchInfoWindow_min.css" />

<body id="body">
	<%@include file="../../TagLib/Menu.jsp"%>
	<div class="wrap_container yahei">
		<div class="top_content">
			<ul class="breadcrumb f16">
				<li><a class="f16" href="${path }/froIndex">首页</a> <!-- <span class="divider">></span> -->
				</li>
				<li><a class="f16" href="${path }/queryCampus">驾校地图</a> <!--  <span class="divider">></span> --></li>
				<li class="active" id="currItem">驾校地图</li>
			</ul>

		</div>

		<div class="main_content">
			<div class="left_content">

				<div class="left_content_one">
					<div class="company_profile">驾校地图</div>

					<ul id="company_separateSchool_list">
					</ul>

				</div>


			</div>
			<div class="right_content" id="right_content">
				<div class="title f18 gold bold">驾校名称</div>
				<div class="rtop">
					<div class="mleft">
						<img src="${path}/static/front/images/map_bg.png">
					</div>

					<div class="mright" data-options="region:'center',title:'驾校信息地图'" style="width: 305px;">
						<h3 class="mrights" id="mrights"></h3>
						<ul>
							地址：<li class="mrights1" id="mrights1"></li>
							<li><a href="http://map.baidu.com/">查看地图公交</a><span>/</span><a
								href="http://map.baidu.com/">驾车去这里</a></li>
							电话：<li class="mrights2" id="mrights2"></li>
						</ul>
					</div>
					
				</div>

				<div id="l-map"></div>
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
	var module = "驾校地图";

	$(".topnav .active").removeClass("active");
	$.each($(".topnav a"),function(index,item){
		if($(this).text().trim()==module){
			$(this).parents("li").addClass("active");
			return false;
		}
	});

	//查询指定模块
	function forwardItem(id) {
		$.post("${path}/queryCampusInfoId", {
			"id" : id
		}, function(data) {
			data = $.parseJSON(data);
			var _content = $("#right_content");
			_content.find(".title").html(data.title);
			_content.find(".article").html(data.address);
			$("#currItem").html(data.title);
			$("#mrights").html(data.title);
			$("#mrights1").html(data.address);
			$("#mrights2").html(data.phone);
			searchByStationName(data.GPSAddress,data.title,data);
		});
		
	}

	// 加载所有公司简介模块下子模块
	$.post("${path}/queryCampusInfo", function(data) {
		var _content = $("#company_separateSchool_list").html("");
		data = $.parseJSON(data);
		$.each(data, function(index, item) {
			var obj = '<li class="forwardItem" onclick="forwardItem(' + item.id
					+ ')"><a>' + item.title + '</a></li>';
			_content.append(obj);
		});
		$($(".forwardItem")[0]).click();
	});

	//function jumpPage(url) {
	//	$(".right_content").panel("refresh", url);
	//}

	var map = new BMap.Map("l-map");
	/* map.centerAndZoom("104.071947,30.664785", 13);
	map.enableDoubleClickZoom();//启用鼠标双击放大，默认启用(可不写)
	map.enableKeyboard();//启用键盘上下左右键移动地图

	map.enableScrollWheelZoom(); //启用滚轮放大缩小，默认禁用
	map.enableContinuousZoom(); //启用地图惯性拖拽，默认禁用

	map.addControl(new BMap.NavigationControl()); //添加默认缩放平移控件
	map.addControl(new BMap.OverviewMapControl()); //添加默认缩略地图控件

	var localSearch = new BMap.LocalSearch(map);
	//向地图中添加比例尺控件
	var ctrl_sca = new BMap.ScaleControl({
		anchor : BMAP_ANCHOR_BOTTOM_LEFT
	});
	map.addControl(new BMap.ScaleControl()); */

	//向地图中添加缩放控件
	//var ctrl_nav = new BMap.NavigationControl({
	//	anchor : BMAP_ANCHOR_TOP_LEFT,
	//	type : BMAP_NAVIGATION_CONTROL_LARGE
	//});

	//localSearch.enableAutoViewport(); //允许自动调节窗体大小
	
	function searchByStationName(gps,xl_name,data) {
			map.clearOverlays();//清空原来的标注
			var gpss = gps.split(",");
			var poi = new BMap.Point(gpss[0],gpss[1]);
			map.centerAndZoom(poi, 16);
			map.enableScrollWheelZoom();
			
			var content = '<div style="margin:0;line-height:20px;padding:2px;">'+
			'<img src="${path}/static/front/images/jx_map.jpg" style="float:right;zoom:1;overflow:hidden;width:150px;height:100px;margin-left:3px;"/>'+
			'分校简称：'+data.title+
			'<br/>地址：'+data.address+
          	'</div>';
         	//创建检索信息窗口对象
            var searchInfoWindow = null;
        	searchInfoWindow = new BMapLib.SearchInfoWindow(map, content, {
        			title  : xl_name,      //标题
        			width  : 290,             //宽度
        			height : 105,              //高度
        			//panel  : "panel",         //检索结果面板
        			enableAutoPan : true,     //自动平移
        			searchTypes   :[
        				BMAPLIB_TAB_SEARCH,   //周边检索
        				BMAPLIB_TAB_TO_HERE,  //到这里去
        				BMAPLIB_TAB_FROM_HERE //从这里出发
        			]
        		});
        	var marker = new BMap.Marker(poi); // 创建标注，为要查询的地方对应的经纬度
        	
			//var infoWindow = new BMap.InfoWindow(content);
			
			marker.addEventListener("click", function(e) {
				searchInfoWindow.open(marker);
				//this.openInfoWindow(infoWindow);
			});
			map.addOverlay(marker);
			marker.setAnimation(BMAP_ANIMATION_BOUNCE);
			searchInfoWindow.open(marker);
			$("close").onclick = function(){
		        searchInfoWindow.close();
		    };
	};
	
	
</script>


</html>
