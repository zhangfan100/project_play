<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/TagLib.jsp"%>
  <body>
	<!-- 学生管理 -->
	<div id="editStudent" class="easyui-layout" data-options="fit:true,border:false" >
	    <div data-options="region:'center',border:false" style="padding:5px;padding-left:-50px;">
	    	<form method="POST" id="editStu-form">
	    		<input type="hidden" name="token" value="${token }"/>
	    		<input type="hidden" name="imgCode" id="imgCode" value="${record.photoId }"/>
	    		<input type="hidden" name="photoId" id="photoId" value="${record.photoId }"/>
	    		<input type="hidden" name="loginId" value="${record.loginId }"/>
	    		<input type="hidden" name="infoId" value="${record.id }"/>
	    		<input type="hidden" name="path" value="${record.path }"/>
	    		<input type="hidden" name="lessonStep" value="${record.lessonStep }"/>
	    		<br/>
				<li class="form-item">
					<span class="title">学习进度：</span>
					<span class="item">
						<select type="text" name="lessonStep" class="easyui-combobox" required="required" editable=false style="width:200px;height:28px;"  data-options="panelHeight:'auto'">
							<option value="1" id="0" ${record.lessonStep==1?'selected=selected':'' }>通过科目一</option>
							<option value="2" id="0" ${record.lessonStep==2?'selected=selected':'' }>通过科目二</option>
							<option value="3" id="0" ${record.lessonStep==3?'selected=selected':'' }>通过科目三</option>
							<option value="4" id="0" ${record.lessonStep==4?'selected=selected':'' }>通过科目四</option>
					</select></span>
				</li>
	    	</form>
	    </div>
	   
	</div>
  </body>
