<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
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
<title>验收要点查看</title>
</head>

<body>
	<div class="title">
		<h2>验收要点查看</h2>
	</div>
		<div class="main">
			<p class="short-input ue-clear">
				<label>验收要点名称:</label> <input type="text" placeholder="请输入验收要点名称"
					autocomplete="off" name="watch.name" value="${ watch.name}" />
			</p>
			<p class="short-input ue-clear">
				<label>验收要点编号:</label> <input type="text" placeholder="请输入验收要点编号"
					autocomplete="off" name="watch.no" value="${watch.no }" />
			</p>
			<p class="short-input ue-clear">
				<label>验收要点内容：</label> <input type="text" placeholder="请输入验收要点内容"
					autocomplete="off" name="watch.content" value="${watch.content }" />
			</p>
			<p class="short-input ue-clear">
				<label>计划完成：</label> <input type="text" placeholder="计划完成日期"
					onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" autocomplete="off"
					name="watch.plan_time" value="${watch.plan_time }" />
			</p>
			<p class="short-input ue-clear">
				<label>实际完成：</label> <input type="text" placeholder="实际完成日期"
					onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" autocomplete="off"
					name="watch.finish_time" value="${watch.finish_time }" />
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
