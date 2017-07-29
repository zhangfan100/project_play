<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/TagLib.jsp"%>
<body>
	<form id="carInfo-Form" method="get" >
	<input type="hidden" name="id" value="${currCarInfo.id }" >
		<br/>
		<br/>
		<li class="form-item">
			<span class="title">车辆序号：</span>
			<span class="item"><input id="carCode" name="carCode" value="${currCarInfo.carCode}" type="text" class="easyui-validateBox" /></span>
		</li>
		<li class="form-item">
			<span class="title">车牌号码：</span>
			<span class="item"><input id="licenceCode" name="licenceCode" value="${currCarInfo.licenceCode}" type="text" class="easyui-validateBox" /></span>
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
					url:'${path}/queryCurrCarBrand',
					onLoadSuccess:loadCarBrand
					" />
			</span>
		</li>
		<li class="form-item">
			<span class="title">发证机关：</span>
			<span class="item"><input id="licenceOrgan" name="licenceOrgan" value="${currCarInfo.licenceOrgan }" type="text" class="easyui-validateBox" /></span>
		</li>
		<li class="form-item">
			<span class="title">车辆类型：</span>
			<span class="item">
				<select id="carType" name="carType" class="easyui-combobox" style="width:165px;height:28px;"
					data-options="panelHeight:'auto',editable:false,onLoadSuccess:loadCarType"  >
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
					url:'${path}/queryCurrLicenceList',
					onLoadSuccess:loadAllowLicenceType
					" /></span>
		</li>
		<li class="form-item">
			<span class="title">登记日期：</span>
			<span class="item"><input id="createDate" data-options="editable:false" name="createDate" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${currCarInfo.createDate }"/>" type="text" class="easyui-dateBox" style="width:165px;height:28px;" /></span>
		</li>
		<li class="form-item">
			<span class="title">报废日期：</span>
			<span class="item"><input id="lifeEndDate" name="lifeEndDate" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${currCarInfo.lifeEndDate }"/>" type="text" class="easyui-dateBox" data-options="editable:false" style="width:165px;height:28px;" /></span>
		</li>
		<li class="form-item">
			<span class="title">车载IP：</span>
			<span class="item"><input type="text" id="carIP" value="${currCarInfo.carIP }" name="carIP" class="easyui-validateBox" /></span>
		</li>
		<li class="form-item">
			<span class="title">车辆状态：</span>
			<span class="item">
				<input type="radio" value='1' name="status" id="car11"/>&nbsp;<label for="car11">启用</label>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" value='0' name="status" id="car22"/>&nbsp;<label for="car22">禁用</label>
			</span>
		</li>
	</form>
	<script type="text/javascript">
	$("#carInfo-Form").form({
		url:"${path}/mag/editCarInfoSubmit",
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
			$("#editCarInfoWindow").dialog("close");
	    	ShowMessage("保存成功！");
	    }
	});
	function loadCarBrand(){
		$(this).combobox('setValue', '${currCarInfo.carBrandId}');
	}
	function loadCarType(){
		$(this).combobox('setValue', '${currCarInfo.carType }');
	}
	function loadAllowLicenceType(){
		$(this).combobox('setValues', [${currCarInfo.allowLicenceType }]);
	}
	$(document).ready(function(){
		$("input:radio[name='status'][value='${currCarInfo.status}']").attr("checked","checked"); 
	});
	</script>
</body>
