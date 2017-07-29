<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/TagLib.jsp"%>



<body style="overflow:hidden;">

	<!-- 培训记录 -->
	<div id="editCohInfo" class="easyui-layout" data-options="fit:true">
		<div data-options="region:'center',border:false" style="font-size:16px;">
			<form id="instrctor_profile_basic_form" class="" method="post">

				<div class="profile_info">
					<div class="cannot_edit_info">
						<input type="hidden" name="picId" value="${userInfo.picId }"/>
						 <input type="hidden" name="newCoachImg" id="newCoachImg" />
						<input type="hidden" name="id" value="${userInfo.id }">
						<span>姓名:</span><span>${userInfo.name}</span>
						<span>性别:</span><span>${userInfo.sex==0?'女':'男'}</span>
						<br/><br/><br/>
						<span>身份证号:</span><span>${userInfo.licenceCode}</span>
						<br/><br/><br/>
						<span>出生日期:</span><span><fmt:formatDate value="${userInfo.birthday}"/></span>
						<br/><br/><br/>
					</div>
					<span>邮箱:</span><span>${logindata.email}</span>
					<br/><br/>
					 <span style="margin-right:4px;">邮 &nbsp; &nbsp;&nbsp;&nbsp; 编:</span><input name="zipCode" class="easyui-validatebox" required="required" value="${userInfo.zipCode}" type="text" style="border-radius:5px;width:180px;height:25px;">
				</div>
				<div class="profile_info" style="width:330px;">
					<div class="cannot_edit_info">
						<span>教练证号:</span><span>${userInfo.coachCode}</span>
						<br/><br/><br/>
						<span>教练证有效期至:</span><span><fmt:formatDate value="${userInfo.licenceLimitTime}"/></span>
						<br/><br/><br/>
					 
					</div>
					<span>联系电话:</span><input name="phone" class="easyui-validatebox" required="required" value="${userInfo.phone}" type="text" style="border-radius:5px;width:180px;height:25px;">
					<br/><br/><br/>
					<span>联系地址:</span><input name="address" class="easyui-validatebox" required="required" value="${userInfo.address}" type="text" placeholder="" style="border-radius:5px;width:230px;height:25px;">
					<br/><br/>
				</div>

				 <div class="profile_info">
					<div id="img_pic">
						<img src="${path }${att.path }" onerror="teaImg(this)"  id="timg"/>
						<input type="hidden" name="oldCoachImg" value="${att.path }"/>
					</div>
					<button id="editCohInfoUploadBtn">上传图片</button>
				</div> 
				
				
				<div style="margin-left:20px;clear:both;float:left;"><span >个人简介:</span></div>
				<div style="float:left;"><textarea name="content" placeholder="最多250个字符..." class="easyui-validatebox" maxlength="250" required="required" type="text" style="width:717px;height:138px;border-radius:5px;">${userInfo.content }</textarea></div>
				<div style="margin:40px 0 0 190px;clear:both;">
					<button id="user_center_button" class="" name="" type="button" value="" onclick="$('#instrctor_profile_basic_form').submit();">保  存</button>
				</div>
			</form>
		</div>
	</div>
	<script type="text/javascript">
		function teaImg(obj){
			$(obj).attr("src","${path}/static/img/instrctor/info.png").attr("onerror","");
		}
		
		$("#instrctor_profile_basic_form").form({
			url : "${path}/coh/editCoachInfoSubmit",
			onSubmit : function() {
				return $(this).form('validate');
			},
			success : function(data) {

				if (data == '1') {
					ShowMessage('信息修改成功！');
					$("#instrctor_profile_basic").click();
				}else{
					AlterMessage('信息修改失败！');
				}
				
			}
		});
		function TeacherloginInfoUpda() {
			$("#TeacherUpdaForm").submit();
		}
		
		//------------------------------upload
		var swfu_editCohInfo;

			var settings_editCohInfo = {
				flash_url : "${path }/static/scripts/SWFUpload/Flash/swfupload.swf",
				upload_url: "${path }/upload/img",//?thumFlag=true",
				file_post_name:"imgFile",
				file_size_limit : "100 MB",
				file_types : "*.jpg;*.png;*.gif",
				file_types_description : "All Files",
				file_upload_limit : 100,
				file_queue_limit : 0,
				custom_settings : {
					progressTarget : "fsUploadProgress",
					cancelButtonId : "btnCancel"
				},
				debug: false,
				button_action:SWFUpload.BUTTON_ACTION.SELECT_FILE,	//只能选择单个文件
				// Button settings
				button_width: "95",
				button_height: "39",
				button_text:"<span class='uploadBtn'>上传图片</span>",
				button_placeholder_id: "editCohInfoUploadBtn",
				button_image_url : "${path}/static/img/uploadBtn.jpg",
				button_text_style:".uploadBtn { font-size: 14;}",
				button_text_left_padding: 15,
				button_text_top_padding: 10,
				button_cursor:SWFUpload.CURSOR.HAND,
	
				
				// The event handler functions are defined in handlers.js
				file_dialog_complete_handler : function(){
					this.startUpload();
				},
				upload_success_handler : function(file,data){
			    	data = $.parseJSON(data);
			    	if(data.error==0){
			    		$("#timg").attr("src","${path}"+data.url).attr("uri",data.url);
			    		$("#newCoachImg").val(data.url);
			    	}else{
			    		AlterMessage("添加失败!功能维护中..");
			    	}
				}
			};

			swfu_editCohInfo = new SWFUpload(settings_editCohInfo);
		
		//------------------------------upload end
	</script>
	
</body>
