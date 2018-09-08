<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="<%=basePath%>css/base.css" />
<link rel="stylesheet" href="<%=basePath%>css/info-reg.css" />
<title>部门修改</title>
</head>

<body>
	<div class="title">
		<h2>部门修改</h2>
	</div>
	<form action="<%=basePath%>dept/dept_update2" method="post" >
		<div class="main">
			<p class="short-input ue-clear">
				<label>部门名称:</label> <input type="text" name="dept.name" value="<s:property value="dept.name"/>"/>
				<input type="hidden" name="dept.id" value="<s:property value="dept.id"/>"/>
			</p>
			
			<p class="short-input ue-clear">
				<input type="submit" class="button long2 ok" value="提交" /> <input
					type="reset" class="button long2 normal" value="清空" />
			</p>
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
