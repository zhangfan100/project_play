<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/TagLib.jsp"%>
<body >
	<div class="easyui-layout" data-options="fit:true">
		<div data-options="region:'center',border:false" style="">
			<div id="" class="easyui-layout" data-options="fit:true">
				<div class="center-filter clearfix" data-options="region:'north',border:false" style="">
					<button class="filter_button" type="button" onclick="javascript:addSysAdmininfo();">新增管理员</button>
				</div>
				<div data-options="region:'center',border:false" >
					<table id="sysAdminManagedg" class="easyui-datagrid" title="" 
							data-options="
							nowrap:false,
							autoRowHeight:true,
							fit:true,
							fitColumns:true,
							rownumbers:true,
							singleSelect:true,
							checkOnSelect:true,
							selectOnCheck:true,
							pagination:true,
							url:'${path}/mag/querySysAdminByPage',method:'post'">
						<thead>
							<tr>
								<th data-options="field:'ck',checkbox:true"></th>
								<th data-options="field:'name',width:50,align:'center'">姓名</th>
								<th data-options="field:'sex',width:40,align:'center',formatter:formatSex">性别</th>
								<th data-options="field:'email',width:80,align:'center'">邮箱</th>
								<th data-options="field:'birthday',width:80,align:'center'">生日</th>
								<th data-options="field:'address',width:80,align:'center'">地址</th>
								<th data-options="field:'phone',width:50,align:'center'">电话</th>
								<th data-options="field:'status',width:50,align:'center',formatter:formatStatus">账号状态</th>
								<th data-options="field:'createTime',width:80,align:'center'">修改时间</th>
								<th data-options="field:'xx',width:50,align:'center',formatter:operationFormatter">操作</th>
							</tr>
						</thead>
					</table>
				</div>
			</div>
		</div>
	</div>
	<div id="showaddSysAdminInfo" class="easyui-dialog" title="添加账号"  style="width:550px;height:530px;color:#5d5c5c;" 
				data-options="iconCls:'icon-save',resizable:true,closed:true,modal:true,buttons:[{
						text:'保存',
						handler:addSysadmin
					},{
						text:'取消',
						handler:function(){$('.panel-tool-close').click();}
					}]">
			<form id="addSysAdminInfo" method="post">
			 <div id="para_kv">
			    <input type="hidden" name="roleId" value="4"> 
			    <input type="hidden" name="roleType" value="3">
			    <input type="hidden" name="loginCount" value="0">
			    <li class="form-item">
			   	  <span class="title">账号: </span>
				  <span class="item"><input type="text" class="easyui-validateBox" name="username" validtype="remote['${path}/mag/validateUserName']" data-options="required:true"/></span>
			    </li>
				<li class="form-item">
				  <span class="title">姓名:</span> 
				  <span class="item"><input type="text" name="name" class="easyui-validateBox"   data-options="required:true" />
				  </span>
			
				</li>
				<li class="form-item">
				  <span class="title">性别: </span>
				  <span class="item">
				<select name="sex" class="easyui-combobox" data-options="editable:false"  style="width:300px;height:28px;">
					<option value="1">男</option>
					<option value="2">女</option>
				</select></span>
				</li>
				<li class="form-item">
				  <span class="title">邮箱:</span>
				  <span class="item"><input  class="easyui-validatebox" data-options="required:true,validType:['email','length[0,20]']"  validtype="remote['${path}/mag/validateEmail']"  type="text" name="email"/></span>
				</li>
				<li class="form-item">
			      <span class="title" >生日: </span>
			      <span class="item"><input id="birthday" name="birthday" type="text" style="width:300px;height:28px;" editable=false/></span>
			    </li> 
			    <li class="form-item">
				  <span class="title">地址: </span>
				  <span class="item"><input type="text" class="easyui-validateBox" validtype="CHS" data-options="required:true" name="address"/></span>
				</li>
				<li class="form-item">
				  <span class="title">电话: </span>
				  <span class="item"><input type="text"class="easyui-numberbox" validtype="remote['${path}/mag/validatePhone']"  data-options="required:true" name="phone" /> </span>
				</li>
				<li class="form-item">
				  <span class="title">入职薪资: </span>
				  <span class="item"><input type="text"  name="cash" /> </span>
				</li>
				<li class="form-item">
				  <span class="title">账户类型:</span>
				  <span class="item">
				    <input name="type"  editable=false  class="easyui-combobox"  style="width:200px;height:28px;"
						data-options="
						 valueField:'id',
						 textField:'title',
						 url:'${path }/mag/queryRoleByType?roleType=3',
						 panelHeight:'auto',
						 onLoadSuccess:function(data){
						 	if(data.length>0){
						 		$(this).combobox('select', data[0].id);
						 	}
						 }" />
				  </span>
				</li>
				<li class="form-item">
					<span class="title">帐号状态：</span>
					<span class="item">
						<input type="radio" value='1' checked="checked" name="status" id="sta1"/>&nbsp;<label for="sta1">激活</label>
						<input type="radio" value='0' name="status" id="sta2"/>&nbsp;<label for="sta2">未激活</label>
					</span>
				</li>
			 </div>
		</form>
			</div>
	<div id="editSysAdminWindow"></div>
	<script type="text/javascript">
	$.extend($.fn.validatebox.defaults.rules, {    
		remote: {    
	        validator: function(value,param){
	        	$.ajax({
	        		url:param[0],
	        		async : false,
	        		data:{info:value},
	        		success:function(data){
	        			if(data==0){
	        				flag = true;
	        	            $.data(document.body,"flag",flag);
	 	                }else{
	 	                    flag = false;
	 	                    $.data(document.body,"flag",flag);
	 	                }
	        		}
	        	});
	        	return  $.data(document.body,"flag");
	         },
	        message: '已存在'   
	    }    
	});  
	
	//添加
	function addSysAdmininfo(){
		$("#showaddSysAdminInfo").window("open");
	}
	function formatStatus(value, row, index){
		if(value==0){
			return '禁用';
		}else{
			return '启用';
		}
	}
	function editstatus(id){
		$.ajax({
			url : '${path}/mag/editStatus?id='+id,
			type : 'post',
			success : function() {
				$('#sysAdminManagedg').datagrid("reload");
				},
			  });
			}
	function updstatus(id){
		$.ajax({
			url : '${path}/mag/updStatus?id='+id,
			type : 'post',
			success : function() {
				$('#sysAdminManagedg').datagrid("reload");
				},
			  });
			}
	
	function formatSex(value, row, index){
		return value?"男":"女";
	}
	
	$("#birthday").datebox().datebox("setValue",currentDate(-15));
	
	function operationFormatter(value,row,index){
		var returnStr=
			"<a class='edit_a_group' onclick='carBrandInfoEdit("
			+row.id
			+")'  href='javascript:void(0)'>编辑</a>"
		return returnStr;
	}
	function carBrandInfoEdit(id){
		$("#editSysAdminWindow").dialog('open').dialog('refresh','${path}/mag/querySysAdminInfoId?sysAdminId='+id);

	}
	$("#editSysAdminWindow").dialog({
		title:"管理员编辑",
	    width:800,    
	    height:300,    
	    modal:true,
	    maximizable:false,
	    minimizable:false,
	    collapsible:false,
	    draggable:false,
	    resizable:false,
	    cache:false,
	    closed:true,
	    buttons: [
	    {
	    	text:"保存",
	    	handler:function(){
	    		$("#sysAdmin-Form").submit();
	        }
	    },{
	    	text:"关闭",
	    	handler:function(){
	    		$("#editSysAdminWindow").dialog("close");
	        }
	    }] 
	});
	function carBrandInfoEditClick(){
		var data = $("#sysAdminManagedg").datagrid("getSelected");
		if(data==null){
			$.messager.alert("","请选择要编辑的信息！");
		}else{
			carBrandInfoEdit(data.id);
		}
		
	}
	$("#addSysAdminInfo").form({
		 type: "post",
		dataType: "json", 
		url : "${path}/mag/addSysAdminInfo",
		onSubmit: function(){
			if(!$("#addSysAdminInfo").form("validate")){
				return false;
			}else{
				return true;
			}
	    },
		success : function(data) {
			data = eval("("+data+")");
			if (data.status == 1) {
				ShowMessage('添加成功!');
				$('#showaddSysAdminInfo').window('close');
				$('#sysAdminManagedg').datagrid("reload");
			} else {
				ShowMessage('添加失败!');
			}
		}
	});

	function addSysadmin() {
		$("#addSysAdminInfo").submit();
	}
	
	/* $.fn.datebox.defaults.formatter = function(date){
		var y = date.getFullYear();
		var m = date.getMonth()+1;
		var d = date.getDate();
		return y+'-'+m+'-'+d;
	} */
	//扩展easyui表单的验证
	$.extend($.fn.validatebox.defaults.rules, {
	    //验证汉子
	    CHS: {
	        validator: function (value) {
	            return /^[\u0391-\uFFE5]+$/.test(value);
	        },
	        message: '只能输入汉字'
	    },
	    //移动手机号码验证
	    mobile: {//value值为文本框中的值
	        validator: function (value) {
	            var reg = /^1[3|4|5|8|9]\d{9}$/;
	            return reg.test(value);
	        },
	        message: '输入手机号码格式不准确.'
	    },
	    //用户账号验证(只能包括 _ 数字 字母) 
	    account: {//param的值为[]中值
	        validator: function (value, param) {
	            if (value.length < param[0] || value.length > param[1]) {
	                $.fn.validatebox.defaults.rules.account.message = '用户名长度必须在' + param[0] + '至' + param[1] + '范围';
	                return false;
	            } else {
	                if (!/^[\w]+$/.test(value)) {
	                    $.fn.validatebox.defaults.rules.account.message = '用户名只能数字、字母、下划线组成.';
	                    return false;
	                } else {
	                    return true;
	                }
	            }
	        }, message: ''
	    }
	})
	</script>
</body>
