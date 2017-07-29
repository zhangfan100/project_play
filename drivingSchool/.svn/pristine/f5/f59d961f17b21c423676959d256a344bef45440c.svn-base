<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/TagLib.jsp"%>
  <body>
  	
	<!-- 学生管理 -->
	<div id="stuManage" class="easyui-layout" data-options="fit:true" >

		<div data-options="region:'center',border:false" style="">
			<div id="" class="easyui-layout" data-options="fit:true">
				<div class="center-filter clearfix" data-options="region:'north',border:false">
					<span class="table-title">学员列表</span>
					<button class="filter_button" id="addStuBtn" type="button">新增</button>
					<button class="filter_button" id="editLessonStepBtn" type="button" onclick="editStu(-1)" style="width:140px;">修改学员进度</button>
					<form id="stuSearchForm" class="filter_form" method="post">
						<input class="search_input" name="keyWords" style="width:200px;" type="text" placeholder="卡号/姓名/手机">
						<button class="search_button" type="button" id="doSearchBtn"></button>
					</form>
				</div>
				<div data-options="region:'center',border:false" >
					<table id="stuManage_dg" class="easyui-datagrid"
							data-options="nowrap:false,autoRowHeight:true,fit:true,fitColumns:true,rownumbers:true,singleSelect:true,collapsible:true,pagination:true,
							url:'${path }/mag/queryStudentsByPage',method:'post',onClickCell:clickCell">
						<thead>
							<tr>
								<th data-options="field:'id',checkbox:true"></th>
								<th data-options="field:'stuCode',width:80,align:'center'">学员卡号</th>
								<th data-options="field:'name',width:80,align:'center'">姓名</th>
								<th data-options="field:'sex',width:40,align:'center',formatter:formatSex">性别</th>
								<th data-options="field:'email',width:100,align:'center'">邮箱</th>
								<th data-options="field:'phone',width:80,align:'center'">手机号</th>
								<th data-options="field:'stuType',width:50,align:'center',formatter:formatStuType">学员类型</th>
								<th data-options="field:'status',width:50,align:'center',formatter:formatStatus">帐号状态</th>
								<th data-options="field:'lessonStep',width:50,align:'center',formatter:formatLessonStep">学习进度</th>
								<th data-options="field:'cash',width:50,align:'center',formatter:formatCash">缴费余额</th>
								<th data-options="field:'op',width:150,align:'center',formatter:editordel">操作</th>
							</tr>
						</thead>
					</table>
				</div>
			</div>
		</div>

	
	<div id="add_stu_window" class="easyui-dialog" title="添加学员"  style="color:#5d5c5c;width:1200px;height:550px;" 
				data-options="iconCls:'icon-save',resizable:true,closed:true,maxed:true,modal:true,buttons:[{
						text:'保存',
						handler:saveStudent
					},{
						text:'取消',
						handler:function(){$('.panel-tool-close').click();}
					}]">
			</div>
	<div id="info_stu_window" class="easyui-dialog" title="学员详情"  style="color:#5d5c5c;width:830px;height:350px;" 
				data-options="iconCls:'icon-save',resizable:true,closed:true,maxed:true,modal:true,buttons:[{
						text:'确定',
						handler:function(){$('.panel-tool-close').click();}
					}]">
			</div>
	<div id="edit_stu_window" class="easyui-dialog" title="编辑"  style="color:#5d5c5c;width:1200px;height:550px;" 
				data-options="iconCls:'icon-save',resizable:true,closed:true,maxed:true,modal:true,buttons:[{
						text:'保存',
						handler:editStudent
					},{
						text:'取消',
						handler:function(){$('.panel-tool-close').click();}
					}]">
			</div>
	<div id="edit_lessonStep_window" class="easyui-dialog" title="改变进度"  style="color:#5d5c5c;width:400px;height:160px;" 
				data-options="iconCls:'icon-save',resizable:true,closed:true,maxed:true,modal:true,buttons:[{
						text:'保存',
						handler:editStudent
					},{
						text:'取消',
						handler:function(){$('.panel-tool-close').click();}
					}]">
			</div>
	
	</div>
	<script type="text/javascript">
	function formatCash(value, row, index){
		return value?value:0;
	}
	function formatSex(value, row, index){
		return value?"男":"女";
	}
	
	function formatStuType(value, row, index){
 		return value==0?"初次申领":"增驾申领";
	}
	
	function formatStatus(value, row, index){
		return value==0?"禁用":"启用";
	}
	
	function formatLessonStep(value, row, index){
		return value==1?"通过科目一":value==2?"通过科目二":value==3?"通过科目三":"通过科目四";
	}
	
	$("#doSearchBtn").click(function(){
		$("#stuSearchForm").submit();
	});
	
	
	$("#stuSearchForm input").keyup(function(event){
		  if(event.keyCode ==13){
			  $("#stuSearchForm").submit();
		  }
	});
	
	$("#stuSearchForm").submit(function(){
			var param = formToJson("#stuSearchForm");
			$("#stuManage_dg").datagrid({
				queryParams:param
			});
			return false;
	});
			
	function editordel(value, row, index){
		var txt = row.status==0?"启用帐号":"禁用帐号";
		return	'<a href="javascript:void(0);" class="edit_a_group" onclick="infoStu('+row.id+')">查看</a>'+
				'<a href="javascript:void(0);" class="edit_a_group" onclick="editStu('+row.id+')">编辑</a>'+
				'<a href="javascript:void(0);" class="edit_a_group other" onclick="other(this)">其他</a>'+
				'<div class="fmenu-box"><span class="top"></span><li onclick="reset('+row.loginId+');">重置密码</li><li onclick="enable('+index+')">'+txt+'</li></div>';
    };
    
    
    //启用、禁用帐号
    function enable(index){
    	var row = $("#stuManage_dg").datagrid("getData").rows[index];
    	var txt = row.status==0?'启用成功！':'禁用成功！';
    	$.post("${path}/mag/enableAccount",{id:row.loginId,status:row.status},function(data){
    		if(data==0){
    			ShowMessage(txt);
    			$(".fmenu-box").hide();
    			$("#stuManage_dg").datagrid('updateRow',{
    				index: index,
    				row: {
    					status: row.status==0?1:0
    				}
    			});
    		}else{
    			AlterMessage(txt);
    		}
    	});
    }
    //重置密码
    function reset(id){
    	$.post("${path}/mag/resetPassword",{id:id},function(data){
    		if(data==0){
    			ShowMessage("重置成功！");
    			$(".fmenu-box").hide();
    		}else{
    			AlterMessage("保存异常！");
    		}
    	});
    }
    
  	function clickCell(rowIndex, field, value){
  		if(field!="op"){
  			$(".other").next().hide();
  		}
  	}
    $(document).live("click",function(e){
    	var target = $(e.target);
    	if(target.closest(".other").length == 0){
    		$(".other").next().hide();
    	}
    });
    
    
    //新增
    $("#addStuBtn").click(function(){
	    $("#add_stu_window").dialog('open').dialog('refresh','${path}/mag/addStudent');
    });
    
    //查看
    function infoStu(id){
    	$("#info_stu_window").dialog('open').dialog('refresh','${path}/mag/queryStudentInfo?id='+id);
    }
    //编辑
    function editStu(id){
    	if(id!=-1){
    	  $("#edit_stu_window").dialog('open').dialog('refresh','${path}/mag/editStudentInfo?id='+id);
    	}else{
    		var data = $("#stuManage_dg").datagrid("getSelected");
    		if(data==null){
    			$.messager.alert("","请选择要编辑的记录！");
    		}else{
    			$("#edit_lessonStep_window").dialog('open').dialog('refresh','${path}/mag/editLessonStep?id='+data.id);
    		}
    	}
    }
    
    
    function other(obj){
    	var currObj = $(obj).next();
    	$(".other").next().not(currObj).hide();
    	if(currObj.is(":hidden")){
    		currObj.show();
    	}else{
    		currObj.hide();
    	}
    }
    
    //保存修改
    function editStudent(){
    	if(!$("#editStudent #editStu-form").form("validate")){
    		return;
    	}
    	
    	var param = formToJson("#editStudent #editStu-form");
    	
    	$.post("${path}/mag/editStudentSubmit",param,function(data){
    		if(data==0){
    			$('.panel-tool-close').click();
    			//刷新数据
				$("#stuManage_dg").datagrid("load","${path }/mag/queryStudentsByPage"); 
    			ShowMessage("保存成功！");
    		}else{
    			AlterMessage("保存异常！");
    		}
    	});
    }
    
    //保存
    function saveStudent(){
    	if($("#addStudent #imgCode").val()==""){
    		AlterMessage("无头像！");
    		return;
    	}
    	if(!$("#addStudent #addStu-form").form("validate")){
    		return;
    	}
    	
    	var param = formToJson("#addStudent #addStu-form");
    	
    	$.post("${path}/mag/addStudentSubmit",param,function(data){
    		if(data==0){
    			ShowMessage("保存成功！");
    			$("#add_stu_window").dialog('refresh','${path}/mag/addStudent');
    		}else{
    			AlterMessage("保存异常！");
    		}
    	});
    }
	</script>
  </body>
