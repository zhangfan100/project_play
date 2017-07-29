<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/TagLib.jsp"%>
<body>
	<form id="carBrand-Form" method="post" >
	<br/>
	<input type="hidden" name="id" value="${currCarBrand.id}" >
	<li class="form-item">
		<span class="title">品牌名称:</span>  
		<span class="item">
			<input id="title" name="title" class="easyui-validatebox" 
		data-options="required:true" value="${currCarBrand.title}" type="text" value="" style="margin:0;width: 200px;">
		</span>
	</li>
	<li class="form-item" style="margin-top:15px;">
		<span class="title">品牌差价:</span> 
		<span class="item">
			<input id="pricePlus" name="pricePlus"  class="easyui-numberbox" 
		data-options="min:0,prefix:'￥'" type="text" value="${currCarBrand.pricePlus}" style="margin:0;width: 200px;">
		</span>
	</li>
	</form>
	<script type="text/javascript">
	$("#carBrand-Form").form({
		url:"${path}/mag/editCarBrandSubmit",
		onSubmit: function(){
			if(!$("#carBrand-Form").form("validate")){
				return false;
			}else{
				return true;
			}
	    },    
	    success:function(data){
	    	$("#carBrandManageGrid").datagrid("reload");
	    	$.messager.confirm("","修改成功<br>是否退出编辑？",function(r){
				if(r){
					$("#editCarBrandWindow").dialog("close");
				}
			});
	    }
	});
	</script>
</body>
