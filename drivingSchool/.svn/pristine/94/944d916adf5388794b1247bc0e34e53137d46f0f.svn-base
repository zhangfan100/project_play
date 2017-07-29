<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/TagLib.jsp"%>

  <body>
  	<style type="text/css">
  		#system_setting_websetting_form .item input{width:300px;}
  	</style>
    <!-- 参数设置 -->
	<div id="center-system_setting_websetting" class="easyui-layout" data-options="fit:true" >

		<div data-options="region:'center',border:false">
			<form id="system_setting_websetting_form" style="margin:20px 0 0 20px;" method="post">
				<li class="form-item">
					<span class="title">驾校logo：</span>
					<span class="item">
						<input name="jxlogo" readonly="readonly" id="jxlogo" class="" type="text" style="width:360px;">
						<a href="javascript:void(0);" id="addImgBtn2" class="upload_button"></a>
					</span>
					
				</li><br/>
				
				<div class="logo" style="width:100px;height:100px;border:1px solid #d6d6d6;padding:5px;margin:10px 0 0 100px;float:none;">
						<img id="img2Box"  style="width:100%;height:100%;">
					</div>
					<br/>
				<li class="form-item">
					<span class="title">驾校中文名称：</span>
					<span class="item">
						<input name="jx_chineseName" id="jx_chineseName" class="" type="text" >
					</span>
				</li><br/>
				<li class="form-item">
					<span class="title">驾校英文名称：</span>
					<span class="item">
						<input name="jx_englishName" id="jx_englishName" class="" type="text">
					</span>
				</li>
				<br/>
				<li class="form-item">
					<span class="title">备案号：</span>
					<span class="item">
						<input name="record_nums" id="record_nums" class="" type="text">
					</span>
				</li>
				<br/>
				<li class="form-item">
					<span class="title">备案许可证：</span>
					<span class="item">
						<input name="record_cards" id="record_cards" class="" type="text">
						<a href="javascript:void(0);" id="addImgBtn1" class="upload_button">上传文件</a>
					</span>
				</li>
				<br/>
				<li class="form-item">
					<span class="title">网站域名：</span>
					<span class="item">
						<input name="site_domain_name" id="site_domain_name" class="" type="text">
					</span>
				</li>
				<br/>
				<li class="form-item" style="margin-top:10px;">
					<span class="title"></span>
					<span class="item">
						<a href="javascript:updateStationInfo();" class="easyui-linkButton">保  存</a>
					</span>
				</li>
			</form>
			
		</div>

	</div>

	<div id="showAddImage" class="easyui-window" title="图片上传" style="width:800px;height:400px;overflow: hidden;"
			data-options="iconCls:'icon-save',resizable:true,modal:true,closed: true,cache:false,href:'${path}/mag/addImage'">
	</div>
	<script type="text/javascript" src="${path }/static/scripts/SWFUpload/swfupload.js"></script>
	<script type="text/javascript" src="${path }/static/scripts/SWFUpload/plugins/swfupload.queue.js"></script> 
	<script type="text/javascript" src="${path }/static/scripts/SWFUpload/js/fileprogress.js"></script>
	<script type="text/javascript" src="${path }/static/scripts/SWFUpload/js/handlers.js"></script>
	<script type="text/javascript">

	
	var settings = {
			flash_url : "${path }/static/scripts/SWFUpload/Flash/swfupload.swf",
			upload_url: "${path }/upload/img",
			file_post_name:"file",
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

			// Button settings
			button_width: "65",
			button_height: "31",
			button_text:'保存',
			button_text_style:".theFont { font-size: 12;}",
			button_text_right_padding: 18,
			button_text_top_padding: 15,
			button_cursor:SWFUpload.CURSOR.HAND,
			button_action : SWFUpload.BUTTON_ACTION.SELECT_FILE,

			
			// The event handler functions are defined in handlers.js
			file_dialog_complete_handler : function(){this.startUpload();},
			upload_success_handler : uploadSuccess
		};
		
		var swfu2 = new SWFUpload($.extend({},settings,{
	    	button_placeholder_id:"addImgBtn2",
	    	file_post_name:"imgFile",
	    	button_text:"<span class='theFont'>上传图片</span>",
	    	upload_success_handler:function(file,data){
	    		data = $.parseJSON(data);
	        	if(data.error==0){
	        		$("#jxlogo").val(data.url);
	        		$("#img2Box").attr('src','');
	        		$("#img2Box").attr('uri','');
	        		$("#img2Box").attr('src','${path}/'+data.url);
					$("#img2Box").attr('uri',data.url);
	        	}else{
	        		AlterMessage("添加失败!功能维护中..");
	        	}
	    	}
	    }));
		var swfu1 = new SWFUpload($.extend({},settings,{
	    	button_placeholder_id: "addImgBtn1",
	    	upload_url: "${path }/upload/file",
	    	file_post_name:"selectedFile",
	    	button_text:"<span class='theFont'>上传文件</span>",
	    	file_types : "*",
	    	upload_success_handler:function(file,data){
	    		data = $.parseJSON(data);
	        	if(data.error==0){
	        		$("#record_cards").val(data.url);
	        	}else{
	        		AlterMessage("添加失败!功能维护中..");
	        	}
	    	}
	    }));
	 
	$(document).ready(function(){
		loadData();
	});
	
	function loadData(){
		$.ajax({
			type:'post',
			url:'${path }/mag/queryWebPropeInfoPage',
			dataType:'json',
			success:function(data){
				$("#jxlogo").val(data.logo);
				$("#img2Box").attr('src','${path}/'+data.logo);
				$("#img2Box").attr('uri',data.logo);
				$("#jx_chineseName").val(data.jx_chineseName);
				$("#jx_englishName").val(data.jx_englishName);
				$("#record_nums").val(data.record_nums);
				$("#record_cards").val(data.record_cards);
				$("#site_domain_name").val(data.site_domain_name);
			}
		});
	}
	$("#system_setting_websetting_form").form({
		url : "${path}/mag/updateSubmitWebPropeInfo",
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

			if (data == '1') {
				ShowMessage('信息修改成功！');
			}else{
				AlterMessage('信息修改异常！');
			}
			
		}
	});
	function updateStationInfo(){
		//alert($("#jxlogo").val());
		$("#system_setting_websetting_form").submit();
	}
	//显示图像上传页
	function showUploadBox(){
		$("#showAddImage").window("open");
	}
	</script>
  </body>
</html>
