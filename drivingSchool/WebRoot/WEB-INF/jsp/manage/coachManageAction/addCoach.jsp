<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/TagLib.jsp"%>
  <body>
  	<script type="text/javascript" src="${path }/static/scripts/photo-graph/swfobject.js"></script>
	<!-- 添加教练 -->
	<div id="addCoach" class="easyui-layout" data-options="fit:true,border:false" >
	    <div data-options="region:'west',border:false" style="width:350px;">
	   <object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" id="camera" align="middle">
					<param name="movie" value="${path }/static/scripts/photo-graph/camera.swf" />
					<param name="quality" value="high" />
					<param name="bgcolor" value="#ffffff" />
					<param name="play" value="true" />
					<param name="loop" value="true" />
					<param name="wmode" value="window" />
					<param name="scale" value="showall" />
					<param name="menu" value="true" />
					<param name="devicefont" value="false" />
					<param name="salign" value="" />
					<param name="allowScriptAccess" value="sameDomain" />
					<!--[if !IE]>-->
					<object type="application/x-shockwave-flash" data="${path }/static/scripts/photo-graph/camera.swf" width="340" height="450" style="margin-left: 13px;margin-top: 10px;">
						<param name="movie" value="${path }/static/scripts/photo-graph/camera.swf" />
						<param name="quality" value="high" />
						<param name="bgcolor" value="#ffffff" />
						<param name="play" value="true" />
						<param name="loop" value="true" />
						<param name="wmode" value="window" />
						<param name="scale" value="showall" />
						<param name="menu" value="true" />
						<param name="devicefont" value="false" />
						<param name="salign" value="" />
						<param name="allowScriptAccess" value="sameDomain" />
					<!--<![endif]-->
						<a href="http://www.adobe.com/go/getflash">
							<img src="http://www.adobe.com/images/shared/download_buttons/get_flash_player.gif" alt="获得 Adobe Flash Player" />
						</a>
					<!--[if !IE]>-->
					</object>
					<!--<![endif]-->
				</object>
	    </div>
	    <div data-options="region:'east',border:false" style="width:180px">
   			<br/>
    		<button style="width:100px;height:30px;margin:auto;margin-top:10px;" onclick="ListCard()">读取身份证</button>
    		<br/>
    		<a id="addCoachImgBtn"></a>
    		<br/>
	    	<div id="stuPhoto">
	    		<img id="pic" title="教练头像" style="height:100%;width:100%;"/>
	    	</div>
	    </div> 
	    <div data-options="region:'center',border:false" style="padding:5px;padding-left:-50px;">
	    	<form method="POST" id="addCoh-form">
	    		<input type="hidden" name="token" value="${token }"/>
	    		<input type="hidden" name="imgCode" id="imgCode"/>
	    		<input type="hidden" name="path" id="path"/>
	    		
	    		<br/>
	    		<li class="form-item">
					<span class="title">教练证号：</span>
					<span class="item"><input type="text"  name="coachCode" class="easyui-validateBox" required="required"/></span>
				</li>
	    		<li class="form-item">
					<span class="title">姓名：</span>
					<span class="item"><input type="text"  name="name" class="easyui-validateBox" required="required"/></span>
				</li>
	    		<li class="form-item">
					<span class="title">车牌号：</span>
					<span class="item">
						<select id="carId" name="carId" style="width:200px;height:28px;" class="easyui-combogrid" 
						data-options="
						required:true,
						panelWidth:200,
						mode:'remote',
			            idField:'id',    
			            textField:'licenceCode',    
			            url:'${path }/mag/queryUndistCar',
			            columns:[[    
			                {field:'licenceCode',title:'车牌号',width:200}
			            ]] ,
			            onLoadSuccess:function(data){
			            	$('#carId').combogrid('grid').datagrid('getPanel').find('.datagrid-cell').css({
			        			padding: '6px 3px 6px 7px'
			        		});
			            } "  />
					</span>
				</li>
	    		<li class="form-item">
					<span class="title">身份证件编号：</span>
					<span class="item"><input type="text"  name="licenceCode" class="easyui-validateBox" required="required"/></span>
				</li>
	    		<li class="form-item">
					<span class="title">证件类型 ：</span>
					<span class="item">
						<select type="text" name="licenceType" class="easyui-combobox" editable=false style="width:200px;height:28px;"  data-options="panelHeight:'auto'">
							<option value="1" >身份证</option>
							<option value="2" >驾驶证</option>
					</select></span>
				</li>
	    		<li class="form-item">
					<span class="title">性别：</span>
					<span class="item">
						<input type="radio" value='1' checked="checked" name="sex" id="ss1"/>&nbsp;<label for="ss1">男</label>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" value='0' name="sex" id="ss2"/>&nbsp;<label for="ss2">女</label>
					</span>
				</li>
	    		<li class="form-item">
					<span class="title">生日：</span>
					<span class="item"><input type="text" id="birthday" name="birthday" style="width:200px;height:28px;" required="required"/></span>
				</li>
	    		<li class="form-item">
					<span class="title">驾驶证档案编号：</span>
					<span class="item"><input type="text"  name="drivingLicenceCode" class="easyui-validateBox" required="required"/></span>
				</li>
	    		<li class="form-item">
					<span class="title">驾驶证发证机关：</span>
					<span class="item"><input type="text"  name="licenceOrgan" class="easyui-validateBox" required="required"/></span>
				</li>
	    		<li class="form-item">
					<span class="title">证件有效期：</span>
					<span class="item"><input type="text" id="licenceLimitTime" name="licenceLimitTime" style="width:200px;height:28px;" editable="false" required="required" /></span>
				</li>
	    		<li class="form-item">
					<span class="title">准驾车型范围：</span>
					<span class="item">
						<input id="licenceId" name="coachAllowCarType" class="easyui-combobox" editable=false style="width:200px;height:28px;" class="easyui-combobox" 
						data-options="
						 valueField:'title',
						 textField:'title',
						 multiple:true,
						 panelHeight:'300',
						 url:'${path }/queryCurrLicenceList',
						 onLoadSuccess:function(data){
						 }" />
					</span>
				</li>
	    		<li class="form-item">
					<span class="title">联系地址：</span>
					<span class="item"><input type="text"  name="address" class="easyui-validateBox" required="required"/></span>
				</li>
	    		<li class="form-item">
					<span class="title">邮政编码：</span>
					<span class="item"><input type="text"  name="zipCode" class="easyui-validateBox" required="required"/></span>
				</li>
	    		<li class="form-item">
					<span class="title">联系电话：</span>
					<span class="item"><input type="text"  name="phone" class="easyui-validateBox" required="required"/></span>
				</li>
	    		<li class="form-item">
					<span class="title">教龄：</span>
					<span class="item"><input type="text"  name="coachAge" class="easyui-validateBox" required="required"/></span>
				</li>
	    		<li class="form-item">
					<span class="title">驾龄：</span>
					<span class="item"><input type="text"  name="drivingAge" class="easyui-validateBox" required="required"/></span>
				</li>
	    		<li class="form-item">
					<span class="title">所属分校：</span>
					<span class="item">
						<input id="campusId" name="campusId" class="easyui-combobox" required="required" editable=false style="width:200px;height:28px;"
						data-options="
						 valueField:'id',
						 textField:'title',
						 url:'${path }/mag/queryCampusInfo',
						 panelHeight:'auto',
						 onLoadSuccess:function(data){
						 	if(data.length>0){
						 		$(this).combobox('select', data[0].id);
						 	}
						 }"/>
					</span>
				</li>
	    		<li class="form-item">
					<span class="title">入职日期：</span>
					<span class="item"><input type="text" id="workDate" name="workDate" style="width:200px;height:28px;" editable="false" required="required" /></span>
				</li>
				
	    		<li class="form-item">
					<span class="title">帐户：</span>
					<span class="item"><input type="text"  name="username" class="easyui-validateBox" required="required"/></span>
				</li>
	    		<li class="form-item">
					<span class="title">邮箱：</span>
					<span class="item"><input type="text"  name="email" class="easyui-validateBox" required="required"/></span>
				</li>
				<li class="form-item">
					<span class="title">权限：</span>
					<span class="item">
						<input id="licenceId" name="roleId" class="easyui-combobox" editable=false style="width:200px;height:28px;" class="easyui-combobox" 
						data-options="
						 valueField:'id',
						 textField:'title',
						 url:'${path }/mag/queryRoleByType?roleType=2',
						 panelHeight:'auto',
						 onLoadSuccess:function(data){
						 	if(data.length>0){
						 		$(this).combobox('select', data[0].id);
						 	}
						 }" />
					</span>
				</li>
				<li class="form-item">
					<span class="title">入职薪资：</span>
					<span class="item">
						<input type="text" name="cash" style="width:200px;height:28px;" />
					</span>
				</li>
				<li class="form-item">
					<span class="title">帐号状态：</span>
					<span class="item">
						<input type="radio" value='1' checked="checked" name="status" id="as1"/>&nbsp;<label for="as1">启用</label>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" value='0' name="status" id="as2"/>&nbsp;<label for="as2">禁用</label>
					</span>
				</li>
	    	</form>
	    </div>
	    
	</div>
	<script type="text/javascript">
		
		
		$("#addCoach #workDate,#addCoach #licenceLimitTime").datebox().datebox('setValue', currentDate());
		$("#addCoach #birthday").datebox().datebox('setValue', currentDate(-15));
		
		
		function SendPic(byteArray){
			$("#addCoach #imgCode").val(byteArray);
			$("#addCoach #pic").attr("src","data:image/png;base64,"+byteArray);
		}
		
		function ListCard(){
			var result=ReadCard(SynCardOcx1);
			if(result.status=="error4"){
				AlterMessage("请安装控件！");
				return;
			}
			
			if(result.status!="success"){
				AlterMessage("读取失败！");
				return;
			}
			
			$("#addCoh-form input[name='name']").val(result.name);
			$("#addCoh-form input[name='licenceCode']").val(result.cardNo);
			$("#addCoh-form input[name='sex'][value='"+result.sex+"']").click();
			$("#addCoh-form input[name='address']").val(result.address);
			$("#addCoh-form #birthday").datebox('setValue',result.born);
		}
		
		

		var settings = {
				flash_url : "${path }/static/scripts/SWFUpload/Flash/swfupload.swf",
				upload_url: "${path }/upload/img",
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
				button_placeholder_id: "addCoachImgBtn",
				button_width: "100",
				button_height: "31",
				button_text:'本地头像上传',
				button_text_style:".theFont { font-size: 12;display:inline-block;height:30px;}",
				button_text_right_padding: 18,
				button_text_top_padding: 15,
				button_cursor:SWFUpload.CURSOR.HAND,
				button_action : SWFUpload.BUTTON_ACTION.SELECT_FILE,
				
				// The event handler functions are defined in handlers.js
				file_dialog_complete_handler : function(){this.startUpload();},
				upload_success_handler :function(file,data){
		    		data = $.parseJSON(data);
		        	if(data.error==0){
		        		$("#addCoach #pic").attr("src","${path}"+data.url);
		        		$("#addCoach #path").val(data.url);
		        		$("#addCoach #imgCode").val("");
		        	}else{
		        		AlterMessage("添加失败!功能维护中..");
		        	}
		    	}
		    	
			};
		
		var swfu = new SWFUpload(settings);
	</script>
  </body>
