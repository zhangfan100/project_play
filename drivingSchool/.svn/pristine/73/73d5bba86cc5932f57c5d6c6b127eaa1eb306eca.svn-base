<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/JSLib.jsp"%>

<body style="overflow:hidden;">
		
			<div class="op-bar" style=""><span>时段差价</span><a href="javascript:void(0);" id="edit" class="edit">编&nbsp;辑</a>
			</div>
			<div style="height:350px">
				<table id="dg" class="easyui-datagrid" 
				data-options="
					singleSelect:true,
					nowrap:false,
					fit:true,
					fitColumns:true,
					rownumbers:true,
					url:'${path }/mag/queryAllTimePriceList',
					method:'POST',
					onClickRow:function(rowIndex, rowData){index = rowIndex;}">
					<thead>
						 <tr>
			                <th field="beginTime" width="50" data-options="align:'center',formatter:formatterdate">时间段</th>
			                <th field="pricePlus" width="50" data-options="align:'center'">价格参数</th>
			                <th id="fount" field="status" width="50" data-options="align:'center',formatter:formatter">操作</th>
			            </tr>
					</thead>
				</table>
			</div>
	
	<div id="edit_time_window" class="easyui-dialog" title="价格编辑"  style="width:400px;height:200px;color:#5d5c5c;" 
		data-options="iconCls:'icon-save',resizable:true,closed:true,modal:true,buttons:[{
				text:'保存',
				handler:saveTimeManage
			},{
				text:'取消',
				handler:function(){$('.panel-tool-close').click();}
			}]">
					<input type="hidden"  id="timeId">
					<div style="margin:30px 0 0 30px;">
						<span class="dialog-key">时间段：</span>
						<a id="beginTime" style="font-weight:normal;"></a>
					</div>
					<div style="margin:20px 0 0 30px;">
						<span class="dialog-key">价格参数：</span>
						<input maxlength="4" id="price" type="text" style="margin:0;">
					</div>
	</div>
	<script type="text/javascript">
	function formatterdate(value,row,index){
		return (value<10?"0"+value:value)+":00-"+ ((value+1)<10?"0"+(value+1):(value+1))+":00";
	}
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
			$.post("${path}/mag/editTimePriceStatus",param,function(data){
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
					var time = ((row.beginTime<10?"0"+row.beginTime:row.beginTime)+":00-")+
							   ((row.beginTime+1<10?"0"+(row.beginTime+1):(row.beginTime+1))+":00");
					$("#beginTime").text(time);
					$("#price").val(row.pricePlus*1);
					$("#timeId").val(row.id);
				}
					
				$('#edit_time_window').window('open');
		    };
		    
		    function saveTimeManage(){
		    	$.ajax({
		    		type:'post',
		    		url:"${path}/mag/editTimePriceSubmit",
		    		data:{
		    			pricePlus:$("#price").val(),
		    			id:$("#timeId").val()
		    		},
		    		dataType:'json',
		    		success:function(data){
		    			if(data==1){
		    				ShowMessage("修改成功！");
		    				$('#edit_time_window').window('close');
	        				$('#dg').datagrid("reload");
		    			}else{
		    				AlterMessage("操作异常！");
		    			}
		    		}
		    	});
		    }
	</script>
	
</body>