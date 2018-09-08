<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<%
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	String s = sdf.format(new Date());
%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="<%=basePath%>css/base.css" />
<link rel="stylesheet" href="<%=basePath%>css/info-reg.css" />
<title>工作日志</title>
</head>

<body>
<br>
	<form action="javascript:history.back(-1);" method="get">
		<input type="submit" class="button long2 ok" value="返回上一页" />
	</form>
	<br>
	<div class="title">
		<h2>进度简述</h2>
	</div>
	<s:iterator value="list" var="l" status="status">

		<div class="main">

			<p>
				<label>提交时间:</label>${l.time}
			</p>
			<p class="short-input ue-clear">
				<label>文件:</label><a
					href="<%=basePath%>/file/file_down?fileName=${l.name }&file.path=${l.path }">查看</a> ${l.name2 }&nbsp;&nbsp;&nbsp;<a href="schedule/schedule_delScheduleById?schedule.id=${l.id }">删除</a>
			</p>
			<p class="short-input ue-clear">
				<label>进度描述:</label>
				<textarea readonly="readonly">${l.content }</textarea>
			</p>
		</div>
		<hr style="background-color:#66BCFF ;height:2px; border: none;">
	</s:iterator>
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
