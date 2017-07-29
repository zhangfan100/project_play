<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/TagLib.jsp"%>
  <body>
  <form id="updateSbmitBasicPropeInfo" method="post">
	<input type="hidden" name="id">
		<table border="1" style="width: 100%; height: 90%">
			
			<tr>
				<td>键:</td>
				<td><input type="text" class="easyui-validatebox"
					name="key" style="width: 100%;height: 100%"></td>
			</tr>
			<tr>
				<td>标题:</td>
				<td>
				<input type="text" class="easyui-validatebox"
					name="title" style="width: 100%;height: 100%"></td>
			</tr>
			<tr>
				<td>值:</td>
				<td><input type="text" class="easyui-validatebox"
					name="value" style="width: 100%;height: 100%"></td>
			</tr>
			
			<tr>
				<td>类型:</td>
				<td><span id="type"></span>
					<input type="hidden" name="type"/>
				</td>
			</tr>
			

			<tr>
				<td><input type="button" value="确认修改"
					onclick="updateSbmitBasicPropeInfo()"></td>
			</tr>
		</table>

	</form>
   <script type="text/javascript">
	   function fillData(){
			console.log(editData);
			if(editData!=null){
				$("input[name='id']").val(editData.id);
				$("input[name='key']").val(editData.key);
				$("input[name='title']").val(editData.title);
				$("input[name='value']").val(editData.value);
				$("input[name='type']").val(editData.type);
				$("#type").text(editData.type);
			}
		}
		$(function(){
			fillData();
		});
		$("#updateSbmitBasicPropeInfo").form({
			url : "${path}/teacher/updateSbmitBasicPropeInfo",
			onSubmit : function() {
				var isValid = $(this).form('validate');
				if (!isValid) {
					$.messager.progress('close');
					$.messager.show({
						title : '提示',
						msg : '请检查所填写信息！',
						timeout : 5000,
						showType : 'slide'
					});
				}
				return isValid;
			},
			success : function(data) {
				if(data==1){
				alert('修改成功!');
				}else{
				alert('修改失败!');
				}
			}
		});
		function updateSbmitBasicPropeInfo() {
			$("#updateSbmitBasicPropeInfo").submit();
		}
	</script>
  </body>
