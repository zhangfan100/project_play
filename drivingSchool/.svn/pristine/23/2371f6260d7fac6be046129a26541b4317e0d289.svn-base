<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/TagLib.jsp"%>
<body>
	<form id="carInfo-Form" method="get" >
		<br/>
		<br/>
		<li class="form-item">
			<span class="title">车辆序号：</span>
			<span class="item"><input id="carCode" name="carCode" type="text" class="easyui-validateBox" /></span>
		</li>
		<li class="form-item">
			<span class="title">车牌号码：</span>
			<span class="item"><input id="licenceCode" name="licenceCode" type="text" class="easyui-validateBox" /></span>
		</li>
		<li class="form-item">
			<span class="title">车辆品牌：</span>
			<span class="item">
			<input class="easyui-combobox" id="carBrandId" name="carBrandId"
				style="width:165px;height:28px;"
				data-options="
					valueField:'id',
					textField:'title',
					editable:false,
					url:'${path}/queryCurrCarBrand'
					" />
			</span>
		</li>
		<li class="form-item">
			<span class="title">发证机关：</span>
			<span class="item"><input id="licenceOrgan" name="licenceOrgan" type="text" class="easyui-validateBox" /></span>
		</li>
		<li class="form-item">
			<span class="title">车辆类型：</span>
			<span class="item">
				<select id="carType" name="carType" class="easyui-combobox" style="width:165px;height:28px;"
					data-options="editable:false"  >
					<option value="-1">请选择</option>
					<option value="0" >教练训练车型</option>
					<option value="1" >场地训练车型</option>
					<option value="2" >场地模拟车型</option>
				</select>
			</span>
		</li>
		<li class="form-item">
			<span class="title">车型范围：</span>
			<span class="item"><input class="easyui-combobox" id="allowLicenceType" name="allowLicenceType"
				style="width:165px;height:28px;"
				data-options="
					multiple:true,
					valueField:'title',
					textField:'title',
					editable:false,
					url:'${path}/queryCurrLicenceList'
					" /></span>
		</li>
		<li class="form-item">
			<span class="title">登记日期：</span>
			<span class="item"><input id="createDate" name="createDate" type="text" class="easyui-dateBox" data-options="editable:false" style="width:165px;height:28px;" /></span>
		</li>
		<li class="form-item">
			<span class="title">报废日期：</span>
			<span class="item"><input id="lifeEndDate" name="lifeEndDate" type="text" class="easyui-dateBox" data-options="editable:false" style="width:165px;height:28px;" /></span>
		</li>
		<li class="form-item">
			<span class="title">车载IP：</span>
			<span class="item"><input type="text" id="carIP" name="carIP" class="easyui-validateBox" /></span>
		</li>
		<li class="form-item">
			<span class="title">车辆状态：</span>
			<span class="item">
				<input type="radio" value='1' name="status" checked="checked" id="car1"/>&nbsp;<label for="car1">启用</label>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" value='0' name="status" id="car2"/>&nbsp;<label for="car2">禁用</label>
			</span>
		</li>
	</form>
	<script type="text/javascript">
	$("#carInfo-Form").form({
		url:"${path}/mag/addCarInfoSubmit",
		onSubmit: function(){
			if(!$("#carInfo-Form").form("validate")){
				return false;
			}else{
				if($("#carType").combobox("getValue")==-1){
					$.messager.alert("","请选择车辆类型！");
					return false;
				}
				return true;
			}
	    },    
	    success:function(data){
	    	$("#carInfoManageGrid").datagrid("reload");
	    	$.messager.confirm("","添加成功<br>是否退出编辑？",function(r){
				if(r){
					$("#editCarInfoWindow").dialog("close");
				}
			});
	    }
	});
	</script>
</body>
