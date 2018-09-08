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
<title>通知公告</title>
<style type="text/css">
/* 以修改*/
.fudong {
	float: left;
}</style>
</head>

<body>
	<div class="title">
		<h2>通知公告详细信息</h2>
	</div>
	<br>
	<form action="javascript:history.back(-1);" method="get" class="fudong">
		<input type="submit" class="button long2 ok" value="返回上一页" />&nbsp;&nbsp;&nbsp;
	</form>
	<form action="<%=basePath%>cg/cg_wjlist" method="get" class="fudong">
		<input type="hidden" name="id"
			value="<s:property value="#request.wenjian.wenjian_id" />">
			<s:if test="#request.idd != null"><input type="hidden" name="idd"
			value="<s:property value="#request.idd" />"></s:if>
			 <input
			type="submit" class="button long2 ok" value="附件查看" />
	</form>
	<div class="main">
	<br />
		<p class="short-input ue-clear newstyle">
			<label>公告名称：</label>
			<s:property value="#request.wenjian.wenjian_name" />
		</p>
		<p class="short-input ue-clear newstyle">
			<label>发布时间：</label>
			<s:property value="#request.wenjian.create_time" />
		</p>
		<p class="short-input ue-clear newstyle">
			<label>公告正文：</label>
			<%=request.getAttribute("desc")%>
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
