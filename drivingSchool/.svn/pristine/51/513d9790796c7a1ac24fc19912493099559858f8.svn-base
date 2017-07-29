<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/TagLib.jsp"%>
<body>
<div class="easyui-tabs" data-options="fit:true">
		<div title="添加抽奖信息" data-options="selected:true">
		<form id="addLottery-from" method="post">
			<input type="hidden" name="token" value="${token }">
		<div style="margin-top: 30px;" class="form_Table">
					<div class="form_Table_Row">
						<div class="form_Attr_Title">抽奖标题：</div>
						<div class="form_Attr_Input">
							<input type="text" class="easyui-validatebox"
								 required="true" name="title" id="fromAttrInput"/>
						</div>
						<div class="form_Attr_Title">状态：</div>
						<div class="form_Attr_Input">
							<input type="text" class="easyui-combobox"
								 required="true" name="status" id="fromdatebox"
								data-options="
									valueField: 'value',
									textField: 'text',
									editable:false,
									data: [{
										text: '启用',
										value: '1'
									},{
										text: '禁用',
										value: '0'
									}]"
								/>
						</div>
					</div>
					
					<div class="form_Table_Row">
						<div class="form_Attr_Title">开始时间：</div>
						<div class="form_Attr_Input">
							<input type="text"  class="easyui-datetimebox" id="fromdatebox"
								 required="true" name="beginTime" />
						</div>
						<div class="form_Attr_Title">结束时间：</div>
						<div class="form_Attr_Input">
							<input type="text" class="easyui-datetimebox" id="fromdatebox"
								required="true" name="endTime" />
						</div>
					</div>
					<div class="form_Table_Row">
					<div class="form_Attr_Title">角色：</div>
						<div class="form_Attr_Input">
							<input type="text" class="easyui-combobox"
								 required="true" name="roleId" id="fromdatebox"
								data-options="
									valueField: 'value',
									textField: 'text',
									editable:false,
									data: [{
										text: '激活学生',
										value: '6'
									},{
										text: '未激活学生',
										value: '1'
									}]"
								/>
						</div>
					</div>
					
			</div>
		</form>
		</div>
	</div>

<div id="editPrizeInfo"></div>
<div id="addPrizeInfo"></div>
<script type="text/javascript">


$("#addLottery-from").form({
			url:'${path }/mag/addLotteryInfoSubmit',
			onSubmit:function(){
				return $("#addLottery-from").form("validate");
			},
			success:function(data){
				if(data==1){
					ShowMessage("添加成功");
					$("#add_Lottery_window").dialog('close');
					$("#LotteryInfo_dg").datagrid("reload");
				}else{
					AlterMessage("保存异常！");
				}	
			}
		});

</script>

</body>