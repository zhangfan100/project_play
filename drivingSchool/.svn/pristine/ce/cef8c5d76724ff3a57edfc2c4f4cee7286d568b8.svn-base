<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/TagLib.jsp"%>
<body>
	<script type="text/javascript" src="${path }/static/front/js/train_detail.js"></script>
	<div class="right_content train_detail">
		<h2>模考历史</h2>
		<div class="right_box_0">
			<div class="train_detail_1">
				<ul>
					<li></li>
					<li>模考时间</li>
					<li>课程</li>
					<li>模考代码</li>
					<li>金额</li>
					<li>状态</li>
					<li>成绩</li>
				</ul>
				<div class="train_detail_2" id="train_detail_2">
					<c:forEach var="entity" items="${testList}" varStatus="status">
					<ul>
						<li><span>${status.count}.</span></li>
						<li>
							<span>${entity.studyDate}</span>
						</li>
						<li>
							<span><c:if test="${entity.subject eq 1}">科目二</c:if><c:if test="${entity.subject eq 2}">科目三</c:if></span><br><span>${entity.licenceName }</span>
						</li>
						<li>${entity.testCode}</li>
						<li>${entity.cash}</li>
						<li style="line-height: 27px;">
							<c:if test="${entity.status eq 0}">
								<span class="gold">待分配</span> <span><a onclick="cancelPExam('${entity.id}')" class="grey">取消预约</a></span>
							</c:if>
							<c:if test="${entity.status eq 1}">
								<span class="light_green">已分配</span>
							</c:if>
							<c:if test="${entity.status eq 2}">
								<span class="light_green">已完成</span>
							</c:if>
						</li>
						<li>
							<c:if test="${entity.status ne 2}">
								--
							</c:if>
							<c:if test="${entity.status eq 2}">
								${entity.score }
							</c:if>
						</li>
					</ul>
					</c:forEach>
				</div>
			</div>
		</div>
		<div class="holder"></div>
	</div>
	<script type="text/javascript">
	function cancelPExam(id){
		if (confirm("确定取消约考?")){
			$.ajax({
				  type: "POST",
				  url: "${path}/stu/cancelPExam",
				  data: {
					  id:id
				  },
				  success: function(data){
					  if(data=='1'){
						  alert("取消约考成功！");
					  }else{
						  alert("无法取消约考！");
					  }
					  $('#right_panel').panel('refresh');
				  }
				});
		}
	}
	</script>
</body>
