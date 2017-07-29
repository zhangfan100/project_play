<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/JSLib.jsp"%>

<body style="overflow:hidden;">
	<style type="text/css">
		.image_show{text-align:center;}
		.image_show img{margin:auto;}
		.images input[type="checkbox"]{
			margin: -107px 0 0 10px;
			width:15px;
			height:15px;
		}
		.images li{
			width: 209px;
		}
		.item .image_show {
			height: 117px;
			vertical-align: middle;
			line-height: 117px;
			display: table-cell;
			text-align: center;
			width: 209px;
		}
		.item img {
			max-height: 108px;
			max-width: 204px;
		}
		.img_title{width:187px;color: gray;font-size: 13px;}
	</style>
	<div id="center-image_manage"  class="easyui-layout" data-options="fit:true">
				
		<div data-options="region:'north',border:false" style="overflow:hidden;padding-bottom:18px;">		
			<div class="centermenu">
				<div class="center-menu center-menu_active" onclick='javascript:loadData({"kind":"1"});'>
					<div class=""> 
						<span>首页大图 </span>
					</div>
				</div>
				<div class="center-menu" onclick='javascript:loadData({"kind":"2"});'>
					<div class=""> 
						<span>场地图片</span>
					</div>
				</div>		
				<div class="center-menu" onclick='javascript:loadData({"kind":"3"});'>
					<div class=""> 
						<span>荣誉展示</span>
					</div>
				</div>
			</div>
		</div>
		<div data-options="region:'center',border:false" style="" >
			<div id="" class="easyui-layout" data-options="fit:true" >
				<div class="center-filter clearfix" data-options="region:'north',border:false" style="">
					<button id="btn-upload_image" class="filter_button" type="button" onclick="javascript:showUploadBox();">上传照片</button>
					<button class="filter_button" type="button" onclick="javascript:delSelectImg();">删除照片</button>
					
					<form id="image_manage_form" class="filter_form" method="post">
						<span style="">从</span>
						<input class="easyui-datebox" editable="false" name="beginDate"></input>
						<span>至</span>
						<input class="easyui-datebox" editable="false" name="endDate"></input>
						
						<input class="search_button" type="button" id="doSearchBtn"/>
					</form>
				</div>
				<div data-options="region:'center',border:false" >

					<div class="images">
						<ul id="showImgContainer">
							
						</ul>
					</div>
					
				</div>
			</div>
				
			<!-- template -->
			<li id="imgItemTemplate" style="display:none" >
				<div class="item">
					<div class="image_show" onclick="javascript:imagesItemClick(this);">	
						<img src=""/>
					</div>
					<input type="hidden" class="id"/>
					<input type="checkbox" class="imgCheck"/>
					<span class="image_describe"><input type="text" disabled="true" class="img_title"/></span>
					<div class="image_detail">
						<span class="image_date"></span>
						<a href="javascript:void(0);" class="image_delet" onclick="javascript:delItemImg(this);">删除</a>
					</div>
				</div>
			</li>
			
			<!-- imgUpload -->
			<div id="showAddImage" class="easyui-window" title="图片上传" style="width:800px;height:400px;overflow: hidden;"
					data-options="iconCls:'icon-save',collapsible:false,minimizable:false,maximizable:false,modal:true,closed: true,cache:false,href:'${path}/mag/addImage'">
			</div>
			
		</div>
		
	</div>
	<script type="text/javascript">
	var currKind = 1;
	
	function queryExc(){
		var param = formToJson("#image_manage_form");
		$("#image_manage_form").form("reset");
		param['kind'] = currKind;
		loadData(param);
	}
	$("#doSearchBtn").click(function(){
		queryExc();
	});
	
	$("#image_manage_form").form({
		submit:function(){
			queryExc();
			return false;
		}
	});
	
	
		//显示图像上传页
		function showUploadBox(){
			$("#showAddImage").window("open");
		}
		
		//关闭图像上传页
		function closeUploadBox(){
			loadData({"kind":currKind});
			$("#showAddImage").window("close");
		}
		
		function imagesItemClick(obj){
			var _check = $(obj).parents(".item").find(":checkbox");
			if(_check.attr('checked')){
				_check.removeAttr('checked');
			}else{
				_check.attr('checked','checked');
			}
		};
		
		function openImageEditWindow(obj){//显示图片及图片信息到对话框
			var _item = $(obj).parents(".item");
			var imageSrc = _item.find("img").attr("src");
			$("#edit_image_detail > img").attr("src", imageSrc);
			$("#edit_describe").html(_item.find(".image_describe").html());
			$("#edit_image_window").window("open");
		};
		
		//删除单张图像操作
		function delItemImg(obj){
			var param = [{"id":$(obj).parents(".item").find(".id").val(),"path":$(obj).parents(".item").find("img").attr("uri")}];
			delImg(param);
		}
		
		//批量删除图像文件 
		function delSelectImg(){
			var ids = [];
			$("#showImgContainer .imgCheck:checked").each(function(index,item){
				var id = {"id":$(item).parents(".item").find(".id").val(),"path":$(item).parents(".item").find("img").attr("uri")}
				ids.push(id);
			});
			if(ids.length==0)return;
			delImg(ids);
		}
		
		function delImg(param){
			$.messager.confirm(GV.title, '确认删除?', function(r){
				if(r){
					$.post("${path}/mag/deleteImage",{"attsJson":JSON.stringify(param)},function(data){
						if(data==0){
							ShowMessage("删除成功!");
							loadData({"kind":currKind});
						}else{
							AlterMessage("删除失败!");
						}
					});
				}
			});
		}
		
		function loadData(param){
			$($("#center-image_manage .center-menu").removeClass("center-menu_active")[param.kind-1]).addClass("center-menu_active");
			currKind = param.kind;
			$.post("${path}/mag/queryImages",param,function(data){
				data = $.parseJSON(data);
				var container = $("#showImgContainer");
				container.html("");
				$.each(data,function(index,item){
					var clone = $("#imgItemTemplate").clone(true).removeAttr("id").show();
					clone.find("img").attr("src","${path}"+item.path).attr("uri",item.path);
					clone.find(".image_describe input").val(item.title);
					clone.find(".image_date").html(item.createTime);
					clone.find(".id").val(item.id);
					container.append(clone);
				}); 
			});
		}
		$(function(){
			loadData({"kind":1});
			
			$(".image_describe").click(function(){
				$(this).children("input").removeAttr("disabled").focus().select();
				return false;
			});
			$(".image_describe input").blur(function(){
				var _this = $(this).attr("disabled","true");
				var param = {};
				param['id'] = _this.parents(".item").find(".id").val();
				param['title'] = _this.val();
				console.log(param);
				$.post("${path}/mag/editImage",param,function(data){
					console.log(data);
				});
			});
			
		});
	</script>
</body>
