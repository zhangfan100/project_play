<%@page import="com.HuiShengTec.base.entity.PageBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/FroJSLib.jsp"%>
<body>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author" content="">
	<!--  ie8兼容性 -->
	<link href="${path}/static/front/css/jPages.css" rel="stylesheet" >
	<link href="${path }/static/front/css/check_detail.css" rel="stylesheet">
	<!-- 查看扣分项 -->
	<div class="check_points">
		<div class="points_title">
			<span>查看扣分项</span>
			<a href="javascript:void(0)" class="close_points"></a>
		</div>
		<div class="points_head">
			<ul>
				<li>扣分项目</li>
				<li>扣分代码</li>
				<li style="width:300px;">扣分原因</li>
				<li>扣分值</li>
			</ul>
		</div>
		<div class="points_content" id="decuction_info">
			
		</div>
	</div>
	<div class="right_content">
		<h2>培训明细</h2>
		<div class="right_box_0">
			<div class="check_list">
				<ul>
					<li>培训教练：<span id="tea_name">${info.cohName }</span></li>
					<li>驾照类型：<span id="jz_type">${info.title }</span></li>
					<li>培训科目：<span id="lessonType">${info.subject==1?'课目二':'课目三' }</span></li>
					<li>培训日期：<span id="studyDate">${info.realBeginTime }</span></li>
					<li>培训时段：<span id="period">${info.beginTime }-${info.endTime }</span></li>
					<li>培训车辆：<span id="carId">${info.licenceCode }</span></li>
					<li>培训金额：<span id="cash">${info.cash }</span></li>
					<li>培训状态：<span id="status">${info.lessonStatus==0?'未分配车辆':info.lessonStatus==1?'已分配车辆':info.lessonStatus==2?'完成':info.lessonStatus==3?'异常':'' }</span></li>
				</ul>
			</div>
			<div class="check_detail">
				<div class="check_title">
					<ul>
						<li></li>
						<li>培训项目</li>
						<li>场地编号</li>
						<li>培训次数</li>
						<li>时间</li>
						<li>本次成绩</li>
						<li></li>
					</ul>
				</div>
				<div class="check_content" id="rank_content_ul">
					<c:forEach var="row" items="${data.rows}" varStatus="status">
						<ul>
							<li><span>${status.index+1}</span></li>
							<li>${row.detailType}</li>
							<li>${row.campusCode}</li>
							<li>${row.detailCount}</li>
							<li style="line-height: 37px;">${row.beginTime}</li>
							<li>${row.score}</li>
							<li><a href="javascript:void(0)" class="check_grade" onclick="deduct(${row.id})">查看扣分项</a></li>
						</ul>
					</c:forEach>
				</div>
				<div class="holder"></div>
			</div>
			
		</div>
		
	</div>
	
	<script type="text/javascript">
	var trainDeductionid;
		$(function(){
			<%
				PageBean bean = (PageBean)request.getAttribute("data");
				if(bean.getRows().size()>0){
			%>
			$("div.holder").jPages({
			      containerID : "rank_content_ul",
			      previous : "",
			      next : "",
			      perPage : 4,
			      delay : 20
			 });
			<%}%>
			$(".close_points").click(function(){
				window.onmousewheel=function(){return true;};
				
				$.unblockUI();
			});
		});
		
		var traiItem = ["基础培训","倒车入库","坡道停车和起步","侧方位停车","直角转弯","曲线行驶","单边桥"];

		function deduct(deducted_code){
			$.ajax({
				type: "POST",
				url:"${path}/stu/toDeductionInfo",
				data: {
					deducted_code:deducted_code
				},
				dataType:'json',
				success: function(data){
					var html='';
					for(var i=0;i<data.rows.length;i++){
						html+='<ul><li>'+traiItem[data.rows[i].detailType]+'</li><li>'+data.rows[i].pointCode+'</li><li style="width:300px;text-align: left;">'+data.rows[i].content+'</li><li>'+data.rows[i].pointValue+'</li></ul>';
					}
					$("#decuction_info").html(html);
				},
				
			});
		}
	</script>
</body>