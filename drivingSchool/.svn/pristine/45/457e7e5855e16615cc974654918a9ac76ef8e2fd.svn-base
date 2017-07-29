<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/TagLib.jsp"%>
<body>
	<div style="margin:4px 0 0 40px;">
	    <li class="form-item">
		 <span class="title">姓名:</span>  
		 <span class="item" id="name1"></span>
		</li>
		<li class="form-item">
		 <span class="title">编号:</span>  
		 <span class="item" id="code1"></span>
		</li>
		<li class="form-item">
		 <span class="title">职务:</span>  
		 <span class="item" id="salaryType1"></span>
		</li>
		<li class="form-item">
		 <span class="title">上次结薪时间:</span>  
		 <span class="item" id="lastPayTime1"></span>
		</li>
		<li class="form-item">
		 <span class="title">计薪开始时间:</span>  
		 <span class="item" id="salaryBeginTime1"></span>
		</li>
		<li class="form-item">
		 <span class="title">计薪结束时间:</span>  
		 <span class="item" id="salaryEndTime1"></span>
		</li>
		<li class="form-item">
		 <span class="title">发放状态:</span>  
		 <span class="item" id="status2"></span>
		</li>
		<li class="form-item">
		 <span class="title">结算方式:</span>  
		 <span class="item" id="payWay1"></span>
		</li>
		<li class="form-item">
		 <span class="title">应该工资:</span>  
		 <span class="item" id="cash1"></span>
		</li>
		<li class="form-item">
		 <span class="title">实发工资:</span>  
		 <span class="item" id="realCash1"></span>
		</li>
	</div>
	<script type="text/javascript">
	 $("#name1").text($("#name").val());
	 $("#code1").text($("#code").val());
	 $("#salaryType1").text($("#salaryType").val()==1?"教练":"管理员");
	 $("#lastPayTime1").text($("#lastPayTime").val());
	 $("#salaryBeginTime1").text($("#salaryBeginTime").datebox('getValue'));
	 $("#salaryEndTime1").text($("#salaryEndTime").datebox('getValue'));
	 $("#status2").text($("#status1").val()==1?"已发放":"未发放");
	 $("#payWay1").text($("#payWay").val()==1?"现金":"银行");
	 $("#cash1").text($("#cash").val());
	 $("#realCash1").text($("#realCash").val());
	</script>
</body>
