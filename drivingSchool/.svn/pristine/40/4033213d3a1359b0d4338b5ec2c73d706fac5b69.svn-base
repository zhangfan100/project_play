<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/TagLib.jsp"%>
<body>
	<form id="stu-form" method="post">
		<div class="right_content train_statistics">
			<h2>账号设置</h2>
			<div class="right_box_0">

				<div id="password_edit">
					<span>账&nbsp;&nbsp;&nbsp;&nbsp;号&nbsp;:&nbsp;</span><span>${loginInfo.username}</span>
					<br />
					<br /> <span>旧密码&nbsp;:&nbsp;</span><input name="formerPassword"
						id="formerPassword" class="" type="password" placeholder=""
						style="border-radius:5px;width:301px;height:35px;padding-left:5px;">
					<br />
					<br /> <span>新密码&nbsp;:&nbsp;</span><input name="newPassword"
						id="newPassword" class="" type="password" placeholder=""
						style="border-radius:5px;width:301px;height:35px;padding-left:5px;">
					<br />
					<br /> <span>新密码&nbsp;:&nbsp;</span><input name="confirmPassword"
						id="confirmPassword" class="" type="password" placeholder=""
						style="border-radius:5px;width:301px;height:35px;padding-left:5px;">
					<br />
					<br />
					<div class="wrong" id="msgDiv" hidden="hidden"></div>
					<div id="account_btn-groups">
						<input type="button" onclick="submitForm()" value="保&nbsp;&nbsp;存">
						<input type="reset" value="取&nbsp;&nbsp;消">
					</div>
				</div>

			</div>
		</div>
	</form>
	<script type="text/javascript">
		$("#stu-form").form({
			url : "${path}/stu/editStuPasswordSubmit",
			onSubmit : function() {
				if (!$("#formerPassword").val()) {
					$("#msgDiv").show();
					$("#msgDiv").html('<img src="${path}/static/front/images/wrong.png">&nbsp;&nbsp;请填写<span class="rw" style="color:red">密码</span>');
					return false;
				}
				if (!$("#newPassword").val()) {
					$("#msgDiv").show();
					$("#msgDiv").html('<img src="${path}/static/front/images/wrong.png">&nbsp;&nbsp;请填写<span class="rw" style="color:red">新密码</span>');
					return false;
				}
				if (!$("#confirmPassword").val()) {
					$("#msgDiv").show();
					$("#msgDiv").html('<img src="${path}/static/front/images/wrong.png">&nbsp;&nbsp;请填写<span class="rw" style="color:red">确认密码</span>');
					return false;
				}
				if ($("#newPassword").val() != $("#confirmPassword").val()) {
					$("#msgDiv").html('<img src="${path}/static/front/images/wrong.png">&nbsp;&nbsp;<span class="rw" style="color:red">新密码必须相同</span>');
					return false;
				}
				return true;
			},
			success : function(data) {
				if (data == '1') {
					$("#msgDiv").show();
					$("#msgDiv").html('<img src="${path}/static/front/images/wrong.png"><span class="rw" style="color:red">原密码</span>错误');
				} else {

					$("#msgDiv").show();
					$("#msgDiv").html('<img src="${path }/static/front/images/right1.png"><span class="rw" style="color:red">修改成功</span>');
				}
			}
		});
		function submitForm() {
			$("#stu-form").submit();
		}
	</script>
</body>
