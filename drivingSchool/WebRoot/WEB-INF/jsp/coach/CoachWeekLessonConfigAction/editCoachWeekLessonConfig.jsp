<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/TagLib.jsp"%>
  <body>
	<!-- 学生管理 -->
	<div id="editStudent" class="easyui-layout" data-options="fit:true,border:false" >
	    <div data-options="region:'center',border:false" style="padding:5px;padding-left:-50px;">
	    	<form method="POST" id="editStu-form" >
	    		<input type="hidden" name="subject" value="${record.subject}"/>
	    		<input type="hidden" name="id" value="${record.id}"/>
	    		<li class="form-item">
					<span class="title">日期：</span>
					<span class="item"><input type="text"  name="weekDay" class="easyui-validateBox" value="${record.weekDay=='0'?'星期天':record.weekDay=='1'?'星期一':record.weekDay=='2'?'星期二':record.weekDay=='3'?'星期三':record.weekDay=='4'?'星期四':record.weekDay=='5'?'星期五':'星期六'}" required="required" disabled="disabled"/></span>
				</li>
				<br>
	    		<li class="form-item">
					<span class="title">时间：</span>
					<span class="item"><input type="text" name="timeSlot" value="${record.timeSlot=='1'?'上午':'下午'}" class="easyui-validateBox" required="required" disabled="disabled"/></span>
				</li>
				<br>
	    		<li class="form-item">
					<span class="title">科目：</span>
						<span class="item">
							<select type="text" name="subject" class="easyui-combobox" required="required" style="width:200px;height:28px;"  data-options="panelHeight:'auto'">
								<option value="1" id="0" ${record.subject=='1'?'selected=selected':'' }>科目二</option>
								<option value="2" id="0" ${record.subject=='2'?'selected=selected':'' }>科目三</option>
						</select>
					</span>
				</li>
				<br>
	    		<li class="form-item">
					<span class="title">时段模式：</span>
					<span class="item"><input type="text" id="timeSlotType" value="${record.timeSlotType=='1'?'驾校分配模式':'教练自主模式'}" style="width:200px;height:28px;" disabled="disabled" required="required" /></span>
				</li>
	    	</form>
	    </div>
	   
	</div>
  </body>
