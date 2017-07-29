<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/TagLib.jsp"%>
<body>
	<form id="testInfo-Form" method="post">
		<input type="hidden" name="cash" value="${price }">
		<div class="right_content train_statistics">
			<h2>预约模考</h2>
			<div class="right_box_0">
				<div id="test_book_info">
					<div>
						<div class="info_item_left">
							<span>预约学员&nbsp;:&nbsp;</span><span>${userInfo.name }</span>
						</div>
						<div class="info_item_right">
							<span>身份证号&nbsp;:&nbsp;</span><span>${userInfo.licenceCode }</span>
						</div>
					</div>
					<div>
						<div class="info_item_left">
							<span>本次费用&nbsp;:&nbsp;</span><span>${price }元</span>
						</div>
					</div>
				</div>
				<ul id="test_book_options">
					<li>
						<h4>预约日期</h4>
						<div class="input_box">
							<input size="16" type="text" data-options="required:true"
								id="studyDate" name="studyDate"
								style="background-color: #ffffff;" readonly
								class="form-control form_datetime order_time easyui-validatebox " value="${beginDate}"> <span
								class="ca_img add-on"><img src="${path}/static/front/images/calendar.png"></span>
						</div>

					</li>
					<li>
						<h4>培训科目</h4>
						<div class="input_box">
							<select id="subject" name="subject" class="course_select">
								<option value="1">科目二</option>
								<option value="2">科目三</option>
							</select>
						</div>
					</li>
					<li>
						<h4>联系电话</h4>
						<div class="input_box">
							<input size="16" id="stuPhone" name="stuPhone" type="text" data-options="required:true,validType:'length[0,18]'" class="easyui-validatebox" value="${stuInfo.phone }">
						</div>
					</li>
				</ul>
				<div id="account_btn-groups">
					<input type="button" onclick="submitForm()" value="保&nbsp;&nbsp;存" /> 
					<input type="reset" value="取&nbsp;&nbsp;消" />
				</div>
			</div>
		</div>
	</form>
	<script type="text/javascript">
		$("#studyDate").datetimepicker({
			weekStart : 1,
			startDate:'${beginDate}',
			endDate:'${endDate}',
			initialDate:'${beginDate}',
			todayBtn : 1,
			autoclose : 1,
			todayHighlight : 1,
			startView : 2,
			minView : 'month',
			format : "yyyy-mm-dd",
			forceParse : 0
		});
		$("#testInfo-Form").form({
			url : "${path}/stu/addTestInfoSubmit",
			onSubmit : function() {
				$.messager.progress();
				var isValid = $(this).form('validate');
				if($("#subject").val()=="0"){
					isValid=false;
				}
				if (!isValid) {
					$.messager.progress('close');
					alert("请检查所填写信息！");
				}
				return isValid;
			},
			success : function(data) {
				$.messager.progress('close');
				if(data=="0"){
					alert("预约成功！");
					var random= Math.random();
					$('#right_panel').panel('refresh',"${path}/stu/testInfoManage?random="+random);
				}else if(data=="1"){
					alert("须提前一天预约！");
				}else if(data=="2"){
					alert("预约已满 请模考后再预约！");
					var random= Math.random();
					$('#right_panel').panel('refresh',"${path}/stu/testInfoManage?random="+random);
				}else{
					alert("当日考试预约名额已满，无法预约！请尝试其他日期！");
				}
			}
		});
		function submitForm() {
			$("#testInfo-Form").submit();
		}
	</script>
</body>
