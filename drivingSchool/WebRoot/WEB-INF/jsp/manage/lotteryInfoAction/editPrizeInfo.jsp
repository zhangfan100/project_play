<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/TagLib.jsp"%>
<body>

<div title="编辑奖品" data-options="selected:true">
		<form id="editPrizeInfo-from" method="post">
			<input type="hidden" name="token" value="${token }">
			<input type="hidden" name="id"  value="${record.id }" />
		<div style="margin-top: 30px;" class="form_Table">
		<div class="form_Group_Title">奖品列表</div>
					<div class="form_Table_Row">
						<div class="form_Attr_Title">奖品名称：</div>
						<div class="form_Attr_Input">
							<input type="text" class="easyui-validatebox" id="fromAttrInput"
								value="${record.prizeName }" required="true" name="prizeName"/>
						</div>
						<div class="form_Attr_Title">份数：</div>
						<div class="form_Attr_Input">
							<input type="text" class="easyui-validatebox" id="fromAttrInput"
								value="${record.prizeCount }" required="true" name="prizeCount"/>
						</div>
					</div>
					
					<div class="form_Table_Row">
						
						<div class="form_Attr_Title">类型：</div>
						<div class="form_Attr_Input">
							<input type="text" class="easyui-combobox" id="fromdatebox"
								value="${record.type }" required="true" name="type"
								data-options="
									valueField: 'value',
									textField: 'text',
									editable:false,
									data: [{
										text: '正常奖品',
										value: '1'
									},{
										text: '轮空奖品',
										value: '2'
									}]"
								/>
						</div>
						
					</div>
					
		</div>
	</form>
</div>
		
<script type="text/javascript">

$("#editPrizeInfo-from").form({
			url:'${path }/mag/editPrizeInfoSubmit',
			onSubmit:function(){
				return $("editPrizeInfo").form("validate");
			},
			success:function(data){
				if(data==1){
					ShowMessage("编辑成功");
					$("#editPrizeInfo").dialog('close');
					$("#prizeInfoManageTable").datagrid("reload");
				}else{
					AlterMessage("保存异常！");
				}	
			}
		});

</script>
		
</body>