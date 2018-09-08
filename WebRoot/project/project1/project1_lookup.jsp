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
<title>一级项目修改</title>
</head>

<body>
	<div class="title">
		<h2>一级项目修改</h2>
	</div>
	<form action="<%=basePath%>/project1/project1_updata" method="post">
		<div class="main">
			<p class="short-input ue-clear">
				<label>项目名称:</label> <input type="text" placeholder="请输入项目名称"
					autocomplete="off" name="project1.name" value="${ project1.name}" />
			</p>
			<p class="short-input ue-clear">
				<label>项目编号:</label> <input type="text" placeholder="请输入项目编号"
					autocomplete="off" name="project1.no" value="${project1.no }" />
			</p>
			<p class="short-input ue-clear">
				<label>资金总数：</label> <input type="text" placeholder="请输入资金总数   (单位:万元)"
					autocomplete="off" name="project1.money" value="${project1.money }" />
			</p>
			<p class="short-input ue-clear">
				<label>完成日期：</label> <input type="text" placeholder="计划完成时间" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"
					autocomplete="off" name="project1.plan_time"
					value="${project1.plan_time }" />
			</p>
			<input type="hidden" name="project1.id" value="${project1.id }">
			<input type="hidden" name="project1.state" value="${project1.state }">
			<input type="hidden" name="project1.user_id" value="${project1.user_id }">
			<input type="hidden" name="project1.schedule" value="${project1.schedule }">

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
