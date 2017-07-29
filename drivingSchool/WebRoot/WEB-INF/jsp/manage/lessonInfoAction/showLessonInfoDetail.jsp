<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/TagLib.jsp"%>
<body>
<div id="showLessonInfoDetail">
<style id="styleTag" >	
.detailTable td {
	text-align: center;
	font-size: 12px;
	height:20px;
}
.detailTable {
	border-collapse: collapse;
}
#showLessonInfoDetail #sh .title{
	clear:both;
	font-size: 32px;
	line-height: 45px;
	letter-spacing: 2px;
	font-family: '宋体';
}
#showLessonInfoDetail #sh .time{
	float: left;
	position: relative;
	top:32px
}
#showLessonInfoDetail #sc-right{
	margin-left:305px;
	min-height: 497px;
}
#showLessonInfoDetail #sc-left{
	width:300px;
	float:left;
}
#showLessonInfoDetail #sb{
	text-align:right;
	padding-top:10px;
	clear:both;
	height:40px;
	line-height:40px;
}
.bold{
	font-weight: bold;
}
#showLessonInfoDetail{margin:0px 20px 20px 20px;}
#showLessonInfoDetail #sh{
	height: 75px;
	text-align:center;
	margin-bottom:5px;
}
</style>
	<div id="sh">
		<span class="time">日期：<fmt:formatDate value="${lessonInfo.realBeginTime}" type="date" dateStyle="medium"/></span>
		<h2 class="title">${jx_chineseName }培训</h2>
	</div>
		<div id="sc-left">
			<table class="detailTable" style="width: 100%;" border="2">
				<tr class="bold">
					<td>总计程距离</td>
					<td>总训练时间</td>
				</tr>
				<tr>
					<td>${lessonInfo.lessonDriveLength }km</td>
					<td>${lessonInfo.lessonTimeLength }小时</td>
				</tr>
				<tr class="bold">
					<td colspan="2">学员、讲师信息</td>
				</tr>
				<tr>
					<td>学员姓名</td>
					<td>${lessonInfo.stuName }</td>
				</tr>
				<tr>
					<td>证件后六位</td>
					<td>${lessonInfo.stuLicence }</td>
				</tr>
				<tr>
					<td>讲师姓名</td>
					<td>${lessonInfo.cohName }</td>
				</tr>
				<tr>
					<td>讲师编码</td>
					<td>${lessonInfo.cohLicence }</td>
				</tr>
				<tr class="bold">
					<td colspan="2">当日训练</td>
				</tr>
				<tr class="bold">
					<td>开始时间</td>
					<td>结束时间</td>
				</tr>
				<tr>
					<td><fmt:formatDate value="${lessonInfo.realBeginTime}"
							type="date" dateStyle="medium" /><br>
					<fmt:formatDate value="${lessonInfo.realBeginTime}" type="time"
							pattern="HH:mm:ss" /></td>
					<td><fmt:formatDate value="${lessonInfo.realEndTime}"
							type="date" dateStyle="medium" /><br>
					<fmt:formatDate value="${lessonInfo.realEndTime}" type="time"
							pattern="HH:mm:ss" /></td>
				</tr>
				<tr class="bold">
					<td>签到时间</td>
					<td>签退时间</td>
				</tr>
				<tr>
					<td><fmt:formatDate value="${lessonInfo.signInTime}"
							type="date" dateStyle="medium" /><br>
					<fmt:formatDate value="${lessonInfo.signInTime}" type="time"
							pattern="HH:mm:ss" /></td>
					<td><fmt:formatDate value="${lessonInfo.signOutTime}"
							type="date" dateStyle="medium" /><br>
					<fmt:formatDate value="${lessonInfo.signOutTime}" type="time"
							pattern="HH:mm:ss" /></td>
				</tr>
				<tr class="bold">
					<td colspan="2">预约情况</td>
				</tr>
				<tr class="bold">
					<td>预约次数</td>
					<td>预约方式</td>
				</tr>
				<tr>
					<td>${lessonInfo.orderTimes }</td>
					<td>${lessonInfo.planWay==0?"网站预约":lessonInfo.planWay==1?"手机预约":"驾校后台预约"}</td>
				</tr>
				<tr class="bold">
					<td>迟到次数</td>
					<td>迟到总时间</td>
				</tr>
				<tr>
					<td>${lessonInfo.lateTimes }</td>
					<td>${lessonInfo.lateTotalTime}</td>
				</tr>
				
				<!-- error start -->
				<tr class="bold">
					<td colspan="2">预约情况</td>
				</tr>
				<tr class="bold">
					<td>预约次数</td>
					<td>预约方式</td>
				</tr>
				<tr>
					<td>${lessonInfo.orderTimes }</td>
					<td>${lessonInfo.planWay}</td>
				</tr>
				<tr class="bold">
					<td>迟到次数</td>
					<td>迟到总时间</td>
				</tr>
				<tr>
					<td>${lessonInfo.lateTimes }</td>
					<td>${lessonInfo.lateTotalTime}</td>
				</tr>
				<tr>
					<td>${lessonInfo.lateTimes }</td>
					<td>${lessonInfo.lateTotalTime}</td>
				</tr>
				<tr>
					<td>${lessonInfo.lateTimes }</td>
					<td>${lessonInfo.lateTotalTime}</td>
				</tr>
				<!-- error end -->
			</table>
		</div>
		<div id="sc-right">
			<table class="detailTable" style="width: 100%;" border="2">
				<thead>
					<tr class="bold">
						<td>项目<br>列表
						</td>
						<td>总进入<br>次数
						</td>
						<td>当日<br>进入次数
						</td>
						<td>单总<br>距离(m)
						</td>
						<td>单总<br>进入时间(分钟)
						</td>
						<td>单总<br>通过率
						</td>
						<td>扣分内容</td>
						<td>总扣分<br>次数
						</td>
						<td>当日扣分<br>次数
						</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${lessonDetail }">
						<tr>
							<td rowspan="${fn:length(item.childrenList)}">
								${item.detailType==0?"基础培训":item.detailType==1?"倒车入库":item.detailType==2?"坡道停车":item.detailType==3?"起步":item.detailType==4?"侧方位停车":item.detailType==5?"直角转弯":item.detailType==6?"曲线行驶":"单边桥"}</td>
							<td rowspan="${fn:length(item.childrenList)}">
								${item.detailCount }</td>
							<td rowspan="${fn:length(item.childrenList)}">
								${item.todayInSubTimes }</td>
							<td rowspan="${fn:length(item.childrenList)}">
								${item.drivingLength }</td>
							<td rowspan="${fn:length(item.childrenList)}">
								${item.beginTime }-${item.endTime }</td>
							<td rowspan="${fn:length(item.childrenList)}">
								${item.singlePassingRate }</td>
							<c:forEach begin="0" end="0" var="childrenItem"
								items="${item.childrenList}">
								<td style="text-align:left;">${childrenItem.content }</td>
								<td>${childrenItem.totalMinusTimes }</td>
								<td>${childrenItem.todayMinusTimes }</td>
							</c:forEach>
						</tr>
						<c:forEach begin="1" var="childrenItem"
							items="${item.childrenList}">
							<tr>
								<td style="text-align:left;">${childrenItem.content }</td>
								<td>${childrenItem.totalMinusTimes }</td>
								<td>${childrenItem.todayMinusTimes }</td>
							</tr>
						</c:forEach>
					</c:forEach>
				</tbody>
			</table>
		</div>
	<div id="sb" class="">
		<span style="float:left;font-size:20px;margin-left:20px;">四川慧莘科技有限公司</span><span style="float:right;">打印时间：${printDate }</span>
	</div>
</div>
<div id="printTag" style="display: none;" ></div>
<script type="text/javascript">
function printTable(){
	$("#showLessonInfoDetail").jqprint({debug:true});
}
</script>
</body>
