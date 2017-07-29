<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/TagLib.jsp"%>

<body>
	<style type="text/css">
		body, html{width: 100%;height: 100%; margin:0;font-family:"微软雅黑";}
		#l-map{height:800px;width:100%;}
		#r-result{width:100%;}
	</style>
	<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=tBePGE7KXOWdXPWpgFlzgm0o"></script>
	
	<script type="text/javascript">
		PL._init();
		PL.joinListen("/gpsPort");
		function onData(event) {
			$("#message").val(event.get("message"));
		}

	</script>

	<div id="l-map"></div>
	<div id="r-result"></div>
	<script type="text/javascript">
	
	jQuery(document).ready(function () {
		setInterval(function(){
	    	var json = $("#message").val();
			var item = jQuery.parseJSON(json);
			var carCode = item.carCode;
			var longitude = item.longitude;
			var latitude = item.latitude;
			$("#carCode").val(carCode);
			$("#longitude").val(longitude);//经度
			$("#latitude").val(latitude);//纬度
			new Date().getTime();
	    },4000);//没4秒执行一次
	});
	
	setTimeout(function(){
		
		
	// 百度地图API功能
	var map = new BMap.Map("l-map");// 创建Map实例
	var long=$("#longitude").val();
	var lat=$("#latitude").val();
	var c=$("#carCode").val();
	if(long==''||lat==''||c==''){
		c = "123";
		long="104.068929";
		lat="30.663543";
	}
	map.centerAndZoom(new BMap.Point(long,lat),15);
	setTimeout(function(){
		map.setZoom(14);   
		map.enableInertialDragging(); // 开启惯性拖拽效果
	}, 5000);  //5秒后放大到14级
	
	/* setTimeout(function(){
		marker.setPath(start);
		map.removeOverlay(marker);
	},4000); */
	map.enableScrollWheelZoom(true); // 启动鼠标滚轮操作
	
	var new_point = new BMap.Point(long,lat);//创建点坐标
	
	var marker = new BMap.Marker(new_point);// 创建标注
	map.addOverlay(marker);// 将标注添加到地图中
	
	var opts = {
			  width : 150,     // 信息窗口宽度
			  height: 70,     // 信息窗口高度
			  title : "车辆信息" , // 信息窗口标题
			  enableMessage:true,//设置允许信息窗发送短息
			};
			var infoWindow = new BMap.InfoWindow("车辆编号:"+c, opts);  // 创建信息窗口对象 
			marker.addEventListener("click", function(){          
				map.openInfoWindow(infoWindow,new_point); //开启信息窗口
			});
	
	/* setTimeout(function(){
		marker.setPath(start);
		
	},4000);	 */
	map.panTo(new_point); 
	marker.setAnimation(BMAP_ANIMATION_BOUNCE); //跳动的动画
	
	var infoWindow = new BMap.InfoWindow(sContent);  // 创建信息窗口对象
	map.openInfoWindow(infoWindow,new_point); //开启信息窗口
	document.getElementById("r-result").innerHTML = "信息窗口的内容是：<br />" + infoWindow.getContent();
	 },2000);//5秒后执行一次
</script>

	<input id="message" type="text" style="width: 500px;">
	<input id="longitude" type="text"><!-- value="104.056353" -->
	<input id="latitude" type="text"><!-- value="30.69693" -->
	<input id="carCode" type="text">
	<div id="allmap"></div>

</body>
