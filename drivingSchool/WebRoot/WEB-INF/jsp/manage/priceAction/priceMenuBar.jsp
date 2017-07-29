<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/JSLib.jsp"%>

<body style="overflow:hidden;">
	<div class="price-manage easyui-layout"">
		<div data-options="region:'north',border:false">
			<div class="top">
				<li style="font-weight:bold;">总价格</li>
				<li>=</li>
				<li><a href="javascript:jumpPage1('${path }/mag/timeManage');" class="selected">时段差价</a></li>
				<li>+</li>
				<li><a href="javascript:jumpPage1('${path }/mag/weekManage');" class="">星期差价</a></li>
				<li>+</li>
				<li><a href="javascript:jumpPage1('${path }/mag/drivingLicenseManage');" class="">驾照差价</a></li>
				<li>+</li>
				<li><a href="javascript:jumpPage1('${path }/mag/vehicleManage');" class="">品牌差价</a></li>
				<li>+</li>
				<li><a href="javascript:jumpPage1('${path }/mag/baseManage');" class="">基础价格</a></li>
			</div>
		</div>
		
		<div id="jumpPage1" data-options="region:'center',border:false, href:'${path}/mag/timeManage'" style="padding:0px 17px 0 23px;">
		</div>
	</div>
	<script type="text/javascript">
		$(".top a").click(function(){
			$(this).addClass("selected").parents(".top").find("a").not(this).removeClass("selected");
		});
		function jumpPage1(url){
			$(".price-manage").layout("panel","center").panel("refresh",url);
		}
	</script>
</body>