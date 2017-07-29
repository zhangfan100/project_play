<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/JSLib.jsp"%>

<body style="overflow:hidden;">
			<div class="op-bar" style=""><span>星期差价</span><i>注:双击价格修改</i>
			</div>
			<div style="height:314px">
				<table id="weektb" class="easyui-datagrid" 
					data-options="singleSelect:true,nowrap:false,fit:true,fitColumns:true,
					rownumbers:true,url:'${path }/mag/queryWeekManage',method:'POST',onDblClickCell:dbClickCell,onClickCell:clickCell">
					<thead>
						 <tr>
			                <th field="weekDay" width="50" data-options="align:'center',formatter:formatterweek">星期</th>
			                <th field="pricePlus" width="50" data-options="align:'center',editor:{type:'numberbox'}">价格参数</th>
			            </tr>
					</thead>
				</table>
			</div>
	<script type="text/javascript">
	function formatterweek(value,row,index){
		var result="星期";
		switch(value){
			case 1:
				result+="天";  
                break;
			case 2:
				result+="一";  
                break;
			case 3:
				result+="二";  
                break;
			case 4:
				result+="三";  
                break;
			case 5:
				result+="四";  
                break;
			case 6:
				result+="五";  
                break;
			case 7:
				result+="六";  
                break;
		}
		return result;
	}
	var editIndex  = undefined;
	var editField = undefined;
	function clickCell(rowIndex, field, value){
		$(this).datagrid("getPanel").find(".selected-cell").removeClass("selected-cell");
		$(this).datagrid("getPanel").find("[datagrid-row-index='"+rowIndex+"']").find("[field='"+field+"']>.datagrid-cell");
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
		param['pricePlus'] = data[editIndex][editField];
		param['id'] = data[editIndex].id;
		//完成修改、保存数据
        $.post("${path}/mag/editWeekManageSubmit",param,function(data){
        	if(data!=1)
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