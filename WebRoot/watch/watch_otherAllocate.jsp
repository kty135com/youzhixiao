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
<title>验收要点分配</title>
</head>

<body>
	<div class="title">
		<h2>验收要点分配</h2>
	</div>
	<form action="<%=basePath%>watch/watch_allocate2" method="post">
		<div class="main">

			<p class="short-input ue-clear">
				<label>所属责任人:</label> <select name="watch.user_id">
					<option value="">请选择所属责任人</option>
					<s:iterator value="users" var="u" status="status">
						<option value="<s:property value="#u.id" />"><s:property value="#u.name" /> </option>
					</s:iterator>
				</select>
		     </p>   
		     <input type="hidden" name="watch.id" value="<s:property value="watch.id"/>">
			<p class="short-input ue-clear">
				<input type="submit" class="button long2 ok" value="提交" /> 
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
