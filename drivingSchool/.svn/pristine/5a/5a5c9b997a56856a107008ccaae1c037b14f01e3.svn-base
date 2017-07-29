<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/JSLib.jsp"%>

<body id="addImgBox">
	<link href="${path }/static/scripts/SWFUpload/default.css" rel="stylesheet" type="text/css" />
	
	<style>
		#imgContiner .imgItem{
			margin:8px;
			float: left;
			text-align: center;
		}
		#imgContiner .imgItem .turmImg{
			height:100px;
			width:120px;
		}
		#imgContiner .imgItem .turmImg img{width:100%;height:100%;}
		#imgContiner .imgItem .input{
			margin-top: 3px;
			height: 20px;
		}
		#imgContiner .imgItem .input input{
			height: 24px;
			border:1px solid gray;
			width:120px;
			font-size: 13px;
		}
	</style>
	
	
	 <div class="easyui-layout" data-options="fit:true">
	 	 <div id="imgContiner" data-options="region:'center'" style="border-left:none;border-right:none;">
	 	 	
	 	 </div>
	 	 <div data-options="region:'south',split:false,border:false" style="height:40px;text-align:right;padding:5px;">
	 	 		<span id="spanButtonPlaceHolder"></span>
	 	 	 <a class="easyui-linkbutton" id="uploadbtn" href="javascript:startUpload()">开始上传</a>
        	 <a class="easyui-linkbutton" id="addImgBtn" href="javascript:void(0)">继续添加</a>
	 	 </div>
	 </div>
	 
	 <div id="addItemTemplate" class="imgItem" style="display:none">
	 	<div class="turmImg"><img src=""/></div>
	 </div>
    
	 <script type="text/javascript">
	 	//开始上传
	 	function startUpload(){
	 		var param = [];
	 		$("#imgContiner .imgItem").each(function(){
	 			var _this = $(this);
	 			var item = {};
	 			item['path'] = _this.find(".turmImg img").attr("uri");
	 			param.push(item);
	 		});
	 		
	 		//如果无数据，提示
	 		if(param.length==0){
	 			AlterMessage("请添加上传文件!");
	 			return;
	 		}
	 		
	 		$.ajax({
	 			url : "${path}/coh/saveImages",
	            type : "POST",
	            data : {"attsJson":JSON.stringify(param)},
	            success : function(data, stats) {
	            	if(data==0){
		 				closeUploadBox();
		 				ShowMessage("上传成功!");
		 			}
	            }
	 		});
	 		
	 	}
	 	
	 	
	 	var swfu;

			var settings = {
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

				// Button settings
				button_width: "65",
				button_height: "29",
				button_text:"继续添加",
				button_placeholder_id: "addImgBtn",
				button_text_style:".theFont { font-size: 16;background:blue; }",
				button_text_right_padding: 18,
				button_text_top_padding: 5,
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
	    		var clone = $("#addItemTemplate").clone(true).show().removeAttr("id");
	    		clone.find("img").attr("src","${path}/"+data.url).attr("uri",data.url);
	    		$("#imgContiner").append(clone);
	    	}else{
	    		AlterMessage("添加失败!功能维护中..");
	    	}
		}
	 </script>
</body>
