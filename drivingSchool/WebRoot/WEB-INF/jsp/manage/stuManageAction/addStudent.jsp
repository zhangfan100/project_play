<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/TagLib.jsp"%>
  <body>
  	<script type="text/javascript" src="${path }/static/scripts/photo-graph/swfobject.js"></script>
  	
	<!-- 学生管理 -->
	<div id="addStudent" class="easyui-layout" data-options="fit:true,border:false" >
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
    		<button style="width:100px;height:30px;margin:auto;margin-top:10px;" id="readCard">读取身份证</button>
    		<br/>
	    	<div id="stuPhoto">
	    		<img id="pic" title="学员头像" style="height:100%;width:100%;"/>
	    	</div>
	    </div> 
	    <div data-options="region:'center',border:false" style="padding:5px;padding-left:-50px;">
	    	<form method="POST" id="addStu-form">
	    		<input type="hidden" name="token" value="${token }"/>
	    		<input type="hidden" name="imgCode" id="imgCode"/>
	    		<br/>
	    		<li class="form-item">
					<span class="title">学员姓名：</span>
					<span class="item"><input type="text"  name="name" class="easyui-validateBox" required="required"/></span>
				</li>
	    		<li class="form-item">
					<span class="title">身份证号：</span>
					<span class="item"><input type="text" name="licenceCode" class="easyui-validateBox" required="required"/></span>
				</li>
	    		<li class="form-item">
					<span class="title">学员卡号：</span>
					<span class="item"><input type="text" name="stuCode" class="easyui-validateBox" required="required"/></span>
				</li>
	    		<li class="form-item">
					<span class="title">性别：</span>
					<span class="item">
						<input type="radio" value='1' name="sex" checked="checked" id="sex1"/>&nbsp;<label for="sex1">男</label>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" value='0' name="sex" id="sex2"/>&nbsp;<label for="sex2">女</label>
					</span>
				</li>
	    		<li class="form-item">
					<span class="title">出生日期：</span>
					<span class="item"><input type="text" id="birthday" name="birthday" style="width:200px;height:28px;" editable="false" required="required"/></span>
				</li>
	    		<li class="form-item">
					<span class="title">报名日期：</span>
					<span class="item"><input type="text" id="createDate" name="createDate" style="width:200px;height:28px;" editable="false" required="required" /></span>
				</li>
	    		<li class="form-item">
					<span class="title">联系电话：</span>
					<span class="item"><input type="text" name="phone" class="easyui-validateBox" required="required"/></span>
				</li>
	    		<li class="form-item">
					<span class="title">住址：</span>
					<span class="item"><input type="text" name="address" class="easyui-validateBox" style="width:200px;" required="required"/></span>
				</li>
				<br/>
	    		<li class="form-item">
					<span class="title">业务类型：</span>
					<span class="item">
						<select type="text" name="stuType" class="easyui-combobox" editable=false required="required" style="width:200px;height:28px;"  data-options="panelHeight:'auto'">
							<option value="0" id="0">初次申领</option>
							<option value="1" id="0">增驾申领</option>
					</select></span>
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
					<span class="title">所属教员：</span>
					<span class="item">
						<select id="coach" name="coachId" style="width:200px;height:28px;" class="easyui-combogrid" 
						data-options="
						panelWidth:430,   
			            idField:'id',    
			            textField:'name',
			            mode:'remote',
			            rownumbers:true,
			            url:'${path }/mag/queryDriveCoachPage',
			            columns:[[    
			              	{field:'name',title:'姓名',width:200},    
			                {field:'stuTotal',title:'学员数量',width:200},  
			            ]] ,
			            onLoadSuccess:function(data){
			            	$(this).combogrid('grid').datagrid('getPanel').find('.datagrid-cell').css({
			        			padding: '6px 3px 6px 7px'
			        		});
			            } "  />
					</span>
				</li>
	    		<li class="form-item">
					<span class="title">驾照类型：</span>
					<span class="item">
						<input id="licenceId" name="licenceId" class="easyui-combobox" editable=false style="width:200px;height:28px;" class="easyui-combobox" 
						data-options="
						 valueField:'id',
						 textField:'title',
						 url:'${path }/queryCurrLicenceList',
						 panelHeight:'200',
						 onLoadSuccess:function(data){
						 	if(data.length>0){
						 		$(this).combobox('select', data[0].id);
						 	}
						 }" />
					</span>
				</li>
				<br/>
	    		<li class="form-item">
					<span class="title">学员帐号：</span>
					<span class="item"><input type="text" name="username" required="required" class="easyui-validateBox" /></span>
				</li>
	    		<li class="form-item">
					<span class="title">邮箱：</span>
					<span class="item"><input type="text" name="email" required="required" class="easyui-validateBox" /></span>
				</li>
				<li class="form-item">
					<span class="title">权限：</span>
					<span class="item">
						<input id="licenceId" name="roleId" editable=false style="width:200px;height:28px;" class="easyui-combobox" 
						data-options="
						 valueField:'id',
						 textField:'title',
						 url:'${path }/mag/queryRoleByType?roleType=1',
						 panelHeight:'auto',
						 onLoadSuccess:function(data){
						 	if(data.length>0){
						 		$(this).combobox('select', data[0].id);
						 	}
						 }" />
					</span>
				</li>
				<li class="form-item">
					<span class="title">学习进度：</span>
					<span class="item">
						<select type="text" name="lessonStep" class="easyui-combobox" required="required" editable=false style="width:200px;height:28px;"  data-options="panelHeight:'auto'">
							<option value="1" >通过科目一</option>
							<option value="2" >通过科目二</option>
							<option value="3" >通过科目三</option>
							<option value="4" >通过科目四</option>
					</select></span>
				</li>
				</br>
	    		<li class="form-item">
					<span class="title">帐号状态：</span>
					<span class="item">
						<input type="radio" value='1' checked="checked" name="status" id="sta1"/>&nbsp;<label for="sta1">启用</label>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" value='0' name="status" id="sta2"/>&nbsp;<label for="sta2">禁用</label>
					</span>
				</li>
	    	</form>
	    </div>
	    
	    
	</div>
	
	<script type="text/javascript">
		
		
		$("#addStudent #readCard").on("click",function(){ListCard(this)});
		$("#addStudent #createDate").datebox().datebox('setValue', currentDate());
		$("#addStudent #birthday").datebox().datebox('setValue', currentDate(-15));
		
		
		
		function SendPic(byteArray){
			$("#addStudent #imgCode").val(byteArray);
			$("#addStudent #pic").attr("src","data:image/png;base64,"+byteArray);
		}
		
		function ListCard(obj){
			var result=ReadCard(SynCardOcx1);
			
			if(result.status=="error4"){
				AlterMessage("请安装控件！");
				return;
			}
			
			if(result.status!="success"){
				AlterMessage("读取失败！");
				return;
			}
			
			$("#addStu-form input[name='name']").val(result.name);
			$("#addStu-form input[name='licenceCode']").val(result.cardNo);
			$("#addStu-form input[name='sex'][value='"+result.sex+"']").click();
			$("#addStu-form input[name='address']").val(result.address);
			$("#addStu-form #birthday").datebox('setValue',result.born);
		}
	</script>
  </body>
