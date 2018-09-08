<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
	<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page import="java.text.SimpleDateFormat"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
	String s = sdf.format(new Date());
%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="<%=basePath%>css/base.css" />
<link rel="stylesheet" href="<%=basePath%>css/info-reg.css" />
<title>用户修改</title>
</head>

<body>
	<div class="title">
		<h2>用户修改</h2>
	</div>
	<form action="<%=basePath%>/user/user_update" method="post">
		<div class="main">
			<p class="short-input ue-clear">
				<label>用户名:</label> <input type="text" placeholder="请输入用户名"
					autocomplete="off" name="user.name" value="${ user.name}" />
			</p>
			<p class="short-input ue-clear">
				<label>密码:</label> <input type="password" placeholder="请输入密码"
					autocomplete="off" name="user.pwd" value="${user.pwd }" />
			</p>
			<p class="short-input ue-clear">
				<label>真实姓名：</label> <input type="text" placeholder="请输入真实姓名"
					autocomplete="off" name="user.realName" value="${user.realName }" />
			</p>
			<p class="short-input ue-clear">
				<label>权限：</label> 
				<label><input name="user.state" type="radio" value="0">超级管理员</label>
				<label><input name="user.state" type="radio" value="1">一级管理员</label>
				<label><input name="user.state" type="radio" value="2">二级管理员</label>
				<label><input name="user.state" type="radio" value="3">责任人</label>
			</p>
			<p class="short-input ue-clear">
				<label>院部：</label> <select name="user.dept_id">
					<s:iterator value="list" var="u1" status="u1t">
						<option value="<s:property value="#u1.id"/>">
							<s:property value="#u1.name"></s:property>
						</option>
					</s:iterator>
				</select>
			</p>
			<input type="hidden" name="user.id" value="${user.id }"> 
		</div>
		<div class="btn ue-clear">
			<input type="submit" class="button long2 ok" value="提交" /> <input
				type="reset" class="button long2 normal" value="清空" />
		</div>
	</form>
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
