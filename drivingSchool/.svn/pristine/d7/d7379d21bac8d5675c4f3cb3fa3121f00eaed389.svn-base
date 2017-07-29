<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/JSLib.jsp"%>

<body style="overflow:hidden;">
	<div class="price-manage">
		
		<div class="content">
			<div class="op-bar" style="">
				<span>七天价格管理</span><i>注：双击编辑</i>
				<r style="float:right;height:20px;">
					<span style="margin-right:0px;">驾照类型：</span>
					<select id="dl" style="width:200px;height:28px;line-height:28px;margin-right:20px;" class="easyui-combobox" editable=false 
						data-options="onSelect:dlSelect">
					 	<c:forEach items="${drivingLicence }" var="item" varStatus="status">
							<option value="${item.id }">${item.title}</option>
						</c:forEach>
					</select>
				</r>
				<r style="float:right;height:20px;">
					<span style="margin-right:0px;">车辆品牌：</span>
					<select id="dl2" style="width:200px;height:28px;line-height:28px;margin-right:20px;" class="easyui-combobox" editable=false 
						data-options="onSelect:dl2Select,onLoadSuccess:function(data){
							if(data.length>0){
								$(this).combobox('select',data[0].value);
							}
						}">
					 	<c:forEach items="${carBrands }" var="item" varStatus="status">
							<option value="${item.id }">${item.title}</option>
						</c:forEach>
					</select>
				</r>
			</div>
			<div style="height:394px;clear:both;" class="seven-table line-bg">
				<table id="weektb" 
					data-options="singleSelect:true,nowrap:false,fit:true,fitColumns:true,onDblClickCell:dbClickCell,onClickCell:clickCell,
					method:'POST'">
					<thead>
						 <tr>
			                <th field="date" width="100" data-options="align:'center'">&nbsp;&nbsp;</th>
			                <c:forEach items="${timePrice }" var="item" >
			                	<th field="t${item.beginTime }" width="50" data-options="align:'left',formatter:formatter,
			                	editor:{type:'numberbox',options:{max:999,default:0,min:0,required:true}}">${item.beginTime }:00</th>
			                </c:forEach>
			            </tr>
					</thead>
				</table>
			</div>
			<div class="paging" style="margin-top:11px;">
				<c:forEach items="${drivingLicence }" var="item" varStatus="status">
					<li id="${item.id }" <c:if test='${status.index==0 }'>class="selected"</c:if>>${item.title}</li>
				</c:forEach>
			</div>
		</div>
	</div>
	<script type="text/javascript">
	
		function formatter(value,row,index){
			return "￥"+value;
		}
		
		var carBrandId = null;
		function refreshTable(){
			var licenceId = $(".paging .selected").attr("id");
			$('#weektb').datagrid({
				url:'${path }/mag/querySevenPrice',
				queryParams: {
					licenceId: licenceId,
					carBrandId: carBrandId
				}
			})
			
		}
		
		
		$(".paging li").click(function(){
			$(this).addClass("selected").parent().children("li").not(this).removeClass("selected");
			$("#dl").combobox("select",$(this).attr("id"));
			refreshTable();
		});
		
		function dlSelect(record){
			var lied = $(".paging [id='"+record.value+"']");
			lied.addClass("selected").parent().children("li").not(lied).removeClass("selected");
			refreshTable();
		}
		function dl2Select(record){
			carBrandId = record.value;
			refreshTable();
		}
		
		
		
		var editIndex  = undefined;
		var editField = undefined;
		function clickCell(rowIndex, field, value){
			$(this).datagrid("getPanel").find(".selected-cell").removeClass("selected-cell");
			$(this).datagrid("getPanel").find("[datagrid-row-index='"+rowIndex+"']").find("[field='"+field+"']>.datagrid-cell").addClass("selected-cell");
			endEditing();
		}
		
		function endEditing(){
            if (editIndex == undefined){return true}
            if ($('#weektb').datagrid('validateRow', editIndex)){
                $('#weektb').datagrid('endEdit', editIndex);
                save(editIndex,editField);
                
                editIndex = undefined;
                return true;
            } else {
                return false;
            }
        }
		
		function save(editIndex,editField){
			
			var data = $("#weektb").datagrid("getData").rows;
			var param = {};
			param['licenceId'] = $(".paging .selected").attr("id");
			param['carBrandId'] = carBrandId;
			param['price'] = data[editIndex][editField];
			param['date'] = data[editIndex].date;
			param['time'] = editField.replace("t","");
			//完成修改、保存数据
            $.post("${path}/mag/updateSevenDaySubmit",param,function(data){
            	if(data==1)
            		AlterMessage("修改异常!");
            });
		}
		
		function dbClickCell(index,field,value){
			if(field == 'day')return;
			if (endEditing()){
                $('#weektb').datagrid('selectRow', index).datagrid('editCell', {index:index,field:field});
                
                $(this).datagrid("getPanel").find("[datagrid-row-index='"+index+"']").find("[field='"+field+"']>.datagrid-cell input").focus().select();
                editIndex = index;
                editField = field;
            }
			$(this).datagrid("getPanel").find(".selected-cell").removeClass("selected-cell");
		}
		
		
		 $.extend($.fn.datagrid.methods, {
	            editCell: function(jq,param){
	                return jq.each(function(){
	                    var opts = $(this).datagrid('options');
	                    var fields = $(this).datagrid('getColumnFields',true).concat($(this).datagrid('getColumnFields'));
	                    for(var i=0; i<fields.length; i++){
	                        var col = $(this).datagrid('getColumnOption', fields[i]);
	                        col.editor1 = col.editor;
	                        if (fields[i] != param.field){
	                            col.editor = null;
	                        }
	                    }
	                    $(this).datagrid('beginEdit', param.index);
	                    for(var i=0; i<fields.length; i++){
	                        var col = $(this).datagrid('getColumnOption', fields[i]);
	                        col.editor = col.editor1;
	                    }
	                });
	            }
	        });
		
	</script>
</body>