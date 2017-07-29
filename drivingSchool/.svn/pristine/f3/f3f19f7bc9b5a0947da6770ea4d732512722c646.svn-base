<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/TagLib.jsp"%>
<body>
	<form id="stuInfo-form" method="post">
		<input type="hidden" name="id" value="${userInfo.id}">
		<div class="right_content train_statistics">
		<h2>我的信息</h2>
		<div class="right_box_0">
			 <div id="person_image">
				<div id="image">
						<img src="${path }${att.path}" onerror="errorImg(this);"/>
						<input type="hidden" name="oldStuImg" value="${userInfo.photoId}"/>
				</div>
				<a id="uploadBtn" style="display:none;"></a>
			</div> 
			<div id="basic_info">
				<h2>&nbsp;&nbsp;我的信息</h2>
				<br/><br/>
				<span>姓名&nbsp;:&nbsp;</span><span>${userInfo.name }</span>
				<br/><br/>
				<span>身份证号&nbsp;:&nbsp;</span><span>${userInfo.licenceCode }</span>
				<br/><br/>
			 	<span>驾照类型&nbsp;:&nbsp;</span><span>${userInfo.forShort }</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<br/><br/><br/><br/> 
				<span>联系电话&nbsp;:&nbsp;</span><input name="phone" id="stu-phone" value="${userInfo.phone }" class="easyui-validatebox" type="text" style="border-radius:5px;width:301px;height:35px;padding-left:5px;">
				<br/>
				<br/>
				<span>联系地址&nbsp;:&nbsp;</span><input name="address" id="stu-address" value="${userInfo.address }" class="easyui-validatebox" type="text" style="border-radius:5px;width:301px;height:35px;padding-left:5px;">
				<br/>
				<input type="hidden" name="newStuImg" id="newStuImg" >
			</div>
			<div id="btn-groups">
				<input type="button" onclick="submitStuForm()" value="保&nbsp;&nbsp;存" />
				<input type="button" onclick="refreshPanel()" value="取&nbsp;&nbsp;消" />
			</div>
		</div>
	</div>
	</form>
	
	<script type="text/javascript" src="${path }/static/scripts/SWFUpload/swfupload.js"></script>
	<script type="text/javascript" src="${path }/static/scripts/SWFUpload/plugins/swfupload.queue.js"></script> 
	<script type="text/javascript" src="${path }/static/scripts/SWFUpload/js/fileprogress.js"></script>
	<script type="text/javascript" src="${path }/static/scripts/SWFUpload/js/handlers.js"></script>
	<script type="text/javascript">
		
	function errorImg(obj){
		$(obj).attr("src","${path}/static/img/instrctor/info.png").attr("onerror","");
	}
		
		$("#stuInfo-form").form({
			url : "${path}/stu/editStudentInfoSubmit",
			onSubmit : function() {
				$.messager.progress();
				var isValid = $(this).form('validate');
				if (!isValid) {
					$.messager.progress('close');
					alert("请检查所填写信息！");
				}
				return isValid;
			},
			success : function(data) {
				$.messager.progress('close');
				if(data=="1"){
					alert("修改成功！");
				}else{
					alert("修改失败！");
				}
			}
		});
		function submitStuForm() {
			$("#stuInfo-form").submit();
		}
		function refreshPanel(){
			$("#right_panel").panel("open").panel("refresh");
		}
		
		//------------------------------upload
		var swfu;

			var settings = {
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
				button_placeholder_id: "uploadBtn",
				button_image_url : "${path}/static/img/uploadBtn.jpg",
				button_text_style:".uploadBtn { font-size: 14;}",
				button_text_left_padding: 15,
				button_text_top_padding: 10,
				button_cursor:SWFUpload.CURSOR.HAND,
				// The event handler functions are defined in handlers.js
				file_dialog_complete_handler : fileDialogComplete,
				upload_success_handler : uploadSuccess,
			};

			swfu = new SWFUpload(settings);
	    
		function fileDialogComplete(){
			this.startUpload();
		}
	    //上传成功回调
		function uploadSuccess(file,data){
	    	data = $.parseJSON(data);
	    	if(data.error==0){
	    		$("#image img").attr("src","${path}/"+data.url);
	    		$("#newStuImg").val(data.url);
	    	}else{
	    		alert("添加失败!功能维护中..");
	    	}
		}
		//------------------------------upload end
	</script>
</body>
