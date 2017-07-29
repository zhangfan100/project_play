<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../TagLib/JSLib.jsp"%>
<html>
	<body>
	<script type="text/javascript">
  		var forward = "${param.forward}";
  		var sign = "${param.sign}";
		if(forward!=""){
			forward = forward+(sign==""?"":"?sign="+sign);
			window.location=forward;
		}else{
			AlterMessage("权限不足");
		}
	</script>
  </body>
</html>
