<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="<%=basePath%>css/base.css" />
<link rel="stylesheet" href="<%=basePath%>css/info-reg.css" />
<title>个人基本信息</title>
</head>

<body>
	<div class="title">
		<h2>个人基本信息</h2>
	</div>
	<div class="main">
		<p class="short-input ue-clear newstyle">
			<label>用户名：</label>${user.name }
		</p>
		<p class="short-input ue-clear newstyle">
			<label>真实姓名：</label>${user.realName }
		</p>
		<p class="short-input ue-clear newstyle">
			<label>权限：</label>
			<s:if test="user.state==0">超级管理员</s:if>
			<s:if test="user.state==1">一级项目管理员</s:if>
			<s:if test="user.state==2">二级管理员</s:if>
			<s:if test="user.state==3">教师</s:if>
		</p>
	</div>

</body>
<script type="text/javascript" src="<%=basePath%>js/jquery.js"></script>
<script type="text/javascript" src="<%=basePath%>js/common.js"></script>
<script type="text/javascript" src="<%=basePath%>js/WdatePicker.js"></script>
<script type="text/javascript">
	$(".select-title").on("click", function() {
		$(".select-list").toggle();
		return false;
	});
	$(".select-list").on("click", "li", function() {
		var txt = $(this).text();
		$(".select-title").find("span").text(txt);
	});

	showRemind('input[type=text], textarea', 'placeholder');
</script>
</html>
