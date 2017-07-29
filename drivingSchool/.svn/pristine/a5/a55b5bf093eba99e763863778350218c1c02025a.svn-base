<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/JSLib.jsp"%>

<body style="overflow:hidden;">
		
			<div class="op-bar" style=""><span>驾照差价</span><a href="javascript:void(0);" class="edit" id="edit">编&nbsp;辑</a>
			</div>
			<table id="dg" class="easyui-datagrid" 
				data-options="
					singleSelect:true,
					nowrap:false,
					fit:true,
					fitColumns:true,
					rownumbers:true,
					url:'${path }/mag/queryAllDrivingLicence',
					method:'POST',
					onClickRow: function(rowIndex, rowData){
						index = rowIndex;
					}">
				<thead>
					 <tr>
		                <th field="title" width="50" data-options="align:'center'">驾照类型</th>
		                <th field="pricePlus" width="50" data-options="align:'center'">价格参数</th>
		                <th field="status" width="50" data-options="align:'center',formatter:formatter">操作</th>
		            </tr>
				</thead>
			</table>
	
	<div id="edit_DrivingLicence_window" class="easyui-dialog" title="价格编辑"  style="width:400px;height:200px;color:#5d5c5c;" 
		data-options="iconCls:'icon-save',resizable:true,closed:true,modal:true,buttons:[{
				text:'保存',
				handler:saveDrivingLicence
			},{
				text:'取消',
				handler:function(){$('.panel-tool-close').click();}
			}]">
			<div id="edit_DL_form">
					<input type="hidden"  id="drivId">
					<div style="margin:30px 0 0 51px;">
						<span class="dialog-key">驾照类型：</span>
						<a id="title" style="font-weight:normal;"></a>
					</div>
					<div style="margin:20px 0 0 51px;">
						<span class="dialog-key" >价格参数：</span>
						<input maxlength="4" id="pricePlus" type="text" style="margin:0;">
					</div>
			</div>
	</div>
	<script type="text/javascript">
		function formatter(value,row,index){
			var text = row.status==1?'<span style="color: red">禁用</span>':'启用';
			var onoff = "<a class='comment_a_reply' rindex='"+index+"' href='javascript:void(0);' onclick='hideComment(this)'>"+text+"</a>";
			return onoff;
		}
		function hideComment(obj){
			var _this = $(obj);
			var index = _this.attr("rindex");
			var data = $("#dg").datagrid("getRows");
			var row = data[index*1];
			row.status = row.status==1?0:1;
			var param = {"ids":row.id,"status":row.status};
			$.post("${path}/mag/editDrivingLicenceStatus",param,function(data){
				$("#dg").datagrid();
			});
		}
		
		var index = null;
		$("#edit").click(function(){
			if(index==null)return;
			editItem(index);
		});
		 function editItem(index){		 
				var rows = $('#dg').datagrid('getRows');
				var row = rows[index];
				if (row){
					$("#edit_DL_form #title").text(row.title);
					$("#edit_DL_form #pricePlus").val(row.pricePlus);
					$("#edit_DL_form #drivId").val(row.id);
				}
					
				$('#edit_DrivingLicence_window').window('open');
		    };
		    
		    function saveDrivingLicence(){
		    	$.ajax({
		    		type:'post',
		    		url:'${path}/mag/editDrivingLicenceSubmit',
		    		data:{
		    			pricePlus:$("#pricePlus").val(),
		    			id:$("#drivId").val()
		    		},
		    		dataType:'json',
		    		success:function(data){
		    			if(data==1){
		    				ShowMessage("修改成功！");
		    				$('#edit_DrivingLicence_window').window('close');
	        				$('#dg').datagrid("reload");
		    			}else{
		    				AlterMessage("操作异常！");
		    			}
		    		}
		    	});
		    }
	</script>
</body>