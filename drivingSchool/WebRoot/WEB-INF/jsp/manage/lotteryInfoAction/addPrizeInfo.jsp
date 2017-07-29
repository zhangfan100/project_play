<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/TagLib.jsp"%>
<body>

<div title="添加奖品" data-options="selected:true">
		<form id="addPrizeInfo-from" method="post">
			<input type="hidden" name="token" value="${token }">
		<div style="margin-top: 30px;" class="form_Table">
		<div class="form_Group_Title">奖品列表</div>
					<div class="form_Table_Row">
						<div class="form_Attr_Title">奖品名称：</div>
						<div class="form_Attr_Input"> 
							<input type="text" class="easyui-validatebox" id="fromAttrInput"
							required="true" name="prizeName"/>
						</div>
						<div class="form_Attr_Title">所属活动 ：</div>
						<div class="form_Attr_Input">
							<input type="text" class="easyui-combobox" editable=false required="true" name="lotteryId"  id="fromdatebox"
							data-options="
								 valueField:'id',
								 textField:'title',
								 multiple:true,
								 panelHeight:'300',
								 url:'${path }/mag/queryLotteryInfo',
								 onLoadSuccess:function(data){
								 if(data.length>0){
									 $(this).combobox('select', data[0].id);
									 }
								 }" />
						</div>
					</div>
					
					<div class="form_Table_Row">
						<div class="form_Attr_Title">类型：</div>
						<div class="form_Attr_Input">
							<input type="text" class="easyui-combobox" id="fromdatebox"
								 required="true" name="type"
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
						
						<div class="form_Attr_Title">份数：</div>
						<div class="form_Attr_Input">
							<input type="text" class="easyui-validatebox" id="fromAttrInput"
								 required="true" name="prizeCount"/>
						</div>
					</div>
					
					
					<div class="form_Table_Row">
						 <div class="form_Attr_Title">兑奖开始日期：</div>
						<div class="form_Attr_Input">
							<input type="text" class="easyui-datetimebox" id="fromdatebox"
								 required="true" name="prizeBeginDate"/>
						</div>
					
						 <div class="form_Attr_Title">兑奖结束日期：</div>
						<div class="form_Attr_Input">
							<input type="text" class="easyui-datetimebox" id="fromdatebox"
								 required="true" name="prizeEndDate"/>
						</div>
					</div>
					
		</div>
	</form>
</div>
		
<script type="text/javascript">

$("#addPrizeInfo-from").form({
			url:'${path }/mag/addPrizeInfoSubmit',
			onSubmit:function(){
				return $("#addPrizeInfo-from").form("validate");
			},
			success:function(data){
				if(data==1){
					ShowMessage("添加成功");
					$("#addPrizeInfo").dialog('close');
					$("#prizeInfoManageTable").datagrid("reload");
				}else{
					AlterMessage("保存异常！");
				}	
			}
		});

</script>
		
</body>