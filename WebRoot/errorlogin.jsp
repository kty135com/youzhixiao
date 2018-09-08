<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>WORNING</title>

</head>
<meta http-equiv="Refresh"
	content="1;url=http://10.6.20.18:8080/project/login.jsp">
<body>

	<script type="text/javascript">
		alert("${error }");
	</script>
</body>
</html>
