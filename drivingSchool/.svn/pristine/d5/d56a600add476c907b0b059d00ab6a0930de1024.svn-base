<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/TagLib.jsp"%>
<body>
	<form id="sysAdmin-Form" method="post" >
	<div style="margin:40px 0 0 61px;">
	<input hidden="hidden" name="sysId" value="${sysAdminInfo.userId}" >
	<input hidden="hidden" name="lId" value="${sysAdminInfo.id}" >
	<li class="form-item">
		 <span class="title">姓名:</span>  
		 <span class="item"><input   name="name" class="easyui-validatebox" 
		data-options="required:true" validtype="CHS" value="${sysAdminInfo.name}" type="text" style="margin:0;width: 200px;"></span>
		</li>
		<li class="form-item">
		 <span class="title">电话:</span>  
		 <span class="item"><input   name="phone" class="easyui-numberbox"
		data-options="required:true" value="${sysAdminInfo.phone}"  invalidMessage="电话号码已存在" type="text" style="margin:0;width: 200px;"></span>
		</li>
		<li class="form-item">
		 <span class="title">邮箱:</span>  
		 <span class="item"><input   name="email" class="easyui-validatebox" 
		data-options="required:true,validType:['email','length[0,20]']" invalidMessage="邮箱格局不正确"  value="${sysAdminInfo.email}" type="text"  style="margin:0;width: 200px;"></span>
		</li>
		<li class="form-item">
		 <span class="title">用户名:</span>  
		 <span class="item"><input   name="username" class="easyui-validatebox" 
		data-options="required:true" value="${sysAdminInfo.username}" disabled="disabled" type="text" style="margin:0;width: 200px;"></span>
		</li>
		<li class="form-item">
		 <span class="title">生日:</span>  
		 <span class="item"><input id="birthday" name="birthday" class="easyui-validatebox" 
		 id="createDate" data-options="editable:false" value="${sysAdminInfo.birthday}" type="text"  style="margin:0;width: 200px;"></span>
		</li>
		<li class="form-item">
		 <span class="title">地址:</span>  
		 <span class="item"><input validtype="CHS"  name="address" class="easyui-validatebox" 
		data-options="required:true" value="${sysAdminInfo.address}" type="text" style="margin:0;width: 200px;">
		</li>
		
		<li class="form-item">
				  <span class="title">账户类型:</span>
				  <span class="item">
				    <input name="roleId"  editable=false  class="easyui-combobox"  style="width:200px;height:28px;"
						data-options="
						 valueField:'id',
						 textField:'title',
						 url:'${path }/mag/queryRoleByType?roleType=3',
						 panelHeight:'auto',
						 onLoadSuccess:function(data){
						 	if(data.length>0){
						 		$(this).combobox('select', '${sysAdminInfo.roleId }');
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
	<script type="text/javascript">
	$("#sysAdmin-Form").form({
		url:"${path}/mag/editSysAdminSubmit",
		onSubmit: function(){
			if(!$("#sysAdmin-Form").form("validate")){
				return false;
			}else{
				return true;
			}
	    },    
	    success:function(data){
	    	$("#sysAdminManagedg").datagrid("reload");
	    	$.messager.confirm("","修改成功<br>是否退出编辑？",function(r){
				if(r){
					$("#editSysAdminWindow").dialog("close");
				}
			});
	    }
	});
	$("#birthday").datebox().datebox("setValue",currentDate(-15));
	
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
