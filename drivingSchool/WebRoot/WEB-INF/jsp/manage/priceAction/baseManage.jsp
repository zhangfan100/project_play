<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/JSLib.jsp"%>

<body style="overflow:hidden;">
	
		<div class="content">
			<div class="op-bar" style=""><span>基础价格</span></div>
			<div style="height:170px;line-height:170px;border:1px solid #6E8ACC;text-align:center;font-size:15px;">
				<input type="hidden" id="id" value="${basicPrice.id }">
				基础价格：<input type="text" id="value" class="easyui-numberbox" value="${basicPrice.value }" maxlength="4" id="priceInput" style="height:40px;line-height:40px;padding:0px 10px;width:320px;"/>&nbsp;&nbsp;元&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a id="btn" href="javascript:submit();" class="easyui-linkbutton" data-options="iconCls:'icon-save',disabled:true">保存</a>
			</div>
		</div>
	<script type="text/javascript">
		$("#value").numberbox({
			onChange:function(newValue,oldValue){
				$("#btn").linkbutton("enable");
			}
		});
		
		//保存修改
		function submit(){
			var param = {};
			param["id"] = $("#id").val();
			param["value"] = $("#value").val();
			$("#btn").linkbutton("disable");
			$.post("${path}/mag/updateSbmitBasicPropeInfo",param,function(data){
				if(data=="1"){
					ShowMessage("保存成功!");
				}else{
					AlterMessage("保存异常!");
				}
			});
		}
	</script>
</body>