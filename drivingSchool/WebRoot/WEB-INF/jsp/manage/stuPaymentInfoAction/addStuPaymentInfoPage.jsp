<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/TagLib.jsp"%>
<body>
	<!-- 添加学生缴费信息 -->
	<div id="addStuPayment" class="easyui-layout"
		data-options="fit:true,border:false">
		<div data-options="region:'center',border:false"
			style="padding:5px;padding-left:-50px;">
			<form method="POST" id="addStuPayment-form">
				<input type="hidden" name="token" value="${token }" />
				 <input type="hidden" name="stuId" id="stuId"/> 

				<li class="form-item">
				   <span class="title">姓名：</span> 
				   <span class="item"> 
				       <input type="text" id="stuName" name="stuName" style="width:500px;height:28px;"/>
				   </span>
				</li>
                 <br>

				<li class="form-item">
				   <span class="title">缴费类型：</span> 
				   <span class="item"> 
				       <input id="paymentType" name="paymentType" class="easyui-combobox"
					data-options="    
				        valueField: 'id',    
				        textField: 'item', 
				        mode:'local',   
				        data: [{
								id: '1',
								item: '学费项目',
								selected:true   
							},{
								id: '2',
								item: '其他项目'
							}],
				        onSelect: function(data){ 
				            if(data.id==1){
				               $('#pay2').attr('style','display:none');
				               $('#pay1').attr('style','');
				               $('#paymentItem_lessonInfo').combogrid('clear');
				               $('#paymentItem_lessonInfo').combogrid('setValue', '');
				               $('#paymentItem_itemInfo').combobox('setValue', '');
				            }else{
				               $('#pay1').attr('style','display:none');
				               $('#pay2').attr('style','');
				               initIncomeItemInfo();
				               $('#paymentItem_lessonInfo').combogrid('setValue', '');
				               $('#paymentItem_itemInfo').combobox('setValue', '');
				            }
				        }" />
				   </span>
				</li>
				 <br>
				<li class="form-item" id="pay1">
				   <span class="title">项目信息：</span> 
				   <span class="item"> 
				       <input id="paymentItem_lessonInfo" name="paymentItem" type="text" style="width:500px;height:28px;"/>
				   </span>
				</li>
				
				<li class="form-item" id="pay2" style="display:none">
				   <span class="title">项目信息：</span> 
				   <span class="item"> 
				       <input id="paymentItem_itemInfo" name="paymentItem" type="text"/>
				   </span>
				</li>
				 <br>	
				 <li class="form-item">
					<span class="title">自填项目信息：</span>
					<span class="item">
					  <input id="paymentItem_self" name="paymentItem" type="text" style="margin:0;width:200px;height:28px;" placeholder="项目信息任选一栏填写">
					</span>
				</li>
				<br>
				 <li class="form-item">
				   <span class="title">应缴金额：</span> 
				   <span class="item"> 
				      678
				   </span>
				</li>
				<br>	
				 <li class="form-item">
				   <span class="title">实缴金额：</span> 
				   <span class="item"> 
				       <input id="realCash" name="realCash" type="text" class="easyui-validatebox"  required="required"/>
				   </span>
				</li>
				<br>
				<li class="form-item">
					<span class="title">支付方式：</span>
					<span class="item">
					  <select type="text" name="payType" class="easyui-combobox" required="required" editable=false style="width:200px;height:28px;"  data-options="panelHeight:'auto'">
							<option value="1" >现金</option>
							<option value="2" >刷卡</option>
							<option value="3" >余额扣额</option>
					 </select>
					</span>
				</li>
				<br>
			</form>
		</div>

	</div>
	<script type="text/javascript">
	
		$("#realCash").numberbox({    
		    min:0,    
		    precision:2    
		}); 
	
		//搜索学生
		$("#stuName").combogrid({
			delay : 500,
			mode : 'remote',
			url : "${path}/mag/queryStudentsByKeyWord",
			idField : 'name',
			textField : 'name',
			fitColumns : true,
			pagination:true,
			autoRowHeight : true,
			rownumbers : true,
			required : true,
			fit : true,
			columns : [ [ 
			              {field : 'name',title : '姓名',width : 60}, 
			              {field : 'sex',title : '性别',width : 40,formatter:sexFormatter} 
			          ] ],
			onSelect : function(rowIndex, rowData) {
				$("#stuId").val(rowData.id);
				initLessonInfo(rowData.id);//加载学生对应的预约课程
				$("#paymentItem_lessonInfo").combogrid('setValue', '');
			}
		});
		
		function sexFormatter(value, row, index){
             return value?"男":"女";
		 }
		//初始化收入项目
		function initIncomeItemInfo(){
			$("#paymentItem_itemInfo").combobox({   
				delay : 500,
				mode : 'remote',
				url : "${path}/mag/queryItemByKeyWord",
				textField : 'itemTag',
				valueField : 'itemTag',
				fitColumns : true,
				autoRowHeight : true,
				rownumbers : true,
				fit : true,
				columns : [ [ 
				              {field : 'itemTag',title : '收入项目',width : 100} 
				          ] ],
	            onSelect : function(rowIndex, rowData) {
	            	$("#paymentItem_lessonInfo").attr("name","p");
	            	$("#paymentItem_itemInfo").attr("name","paymentItem");
	            	$("#paymentItem_lessonInfo").combogrid('setValue', '');
				}
			}); 
		 }
		
		//初始化对于学生的选课
		function initLessonInfo(id){
			$("#paymentItem_lessonInfo").combogrid({   
				delay : 500,
				mode : 'remote',
				url : "${path}/mag/queryLessonInfoByStuId?stuId="+id,
				textField : 'lessonCode',
				idField : 'lessonCode',
				fitColumns : true,
				autoRowHeight : true,
				rownumbers : true,
				multiple:true,
				fit : true,
				columns : [ [ 
				              {field : 'lessonCode',title : '课程编码',width : 100}, 
				              {field : 'subject',title : '科目',width : 60,formatter:subjectFormatter},
				              {field : 'studyDate',title : '日期',width : 100},
				              {field : 'studyTime',title : '时间',width : 100},
				              {field : 'cash',title : '费用',width : 60} 
				          ] ],
	            onSelect : function(rowIndex, rowData) {
	            	$("#paymentItem_lessonInfo").attr("name","paymentItem");
	            	$("#paymentItem_itemInfo").attr("name","a");
	            	$("#paymentItem_itemInfo").combobox('setValue', '');
				}
			}); 
		}
		
		function subjectFormatter(value, row, index){
			return value==1?"科目二":"科目三";
		}
		
		//表单提交
		$("#addStuPayment-form").form({
			url:"${path}/mag/confirmAddStuPayment",
			onSubmit: function(){
				if(!$("#addStuPayment-form").form("validate")){
					return false;
				}else{
					var count = 0;
					$("input[name='paymentItem']").each(function(i){
						   if(this.value!=""){
							   count++;
						   }
					});
					if(count==0){
						$.messager.alert("","请至少填写一个项目信息框");
						return false;
					}
					if(count>1){
						$("#paymentItem_self").val("");
					}
					return true;
				}
		    },
		    success:function(data){
		    	data=eval("("+data+")");
			    $("#add_stuPaymentInfo_Window").dialog("close");
		    	if(data.status==1){
			    	$("#stuPaymentInfo-Grid").datagrid("reload");
			    	$.messager.show({
		        		title:'我的消息',
		        		msg:'添加成功！',
		        	});
		    	}else{
			    	$.messager.show({
		        		title:'我的消息',
		        		msg:'操作失败！',
		        	});
		    	}
		    }
		});
	</script>
</body>
