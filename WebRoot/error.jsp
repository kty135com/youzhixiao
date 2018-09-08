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

<body>
	<br>
	<br>
	<h3 align="center">
		操作有误，
		<s:if test="#session.logingerror != null">${error }</s:if>
		<s:elseif test="error == null">出现未知错误，请联系管理员</s:elseif>
		<s:else>${error }</s:else>
	</h3>
	<br>
	<form action="javascript:history.back(-1);" method="get">
		<input type="submit" class="button long2 ok" value="返回上一页" />
	</form>
</body>
</html>
