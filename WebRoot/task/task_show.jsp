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
<title>预期目标信息</title>
</head>

<body>
	<div class="title">
		<h2>预期目标信息</h2>
	</div>
	<div class="main">
		<p class="short-input ue-clear newstyle">
			<label>预期目标编号：</label>
			<s:property value="task.no" />
		</p>
		<p class="short-input ue-clear newstyle">
			<label>预期目标阶段：</label>
			<s:if test="task.moment==0">中期(2018)</s:if>
			<s:elseif test="task.moment==1">验收期(2019)</s:elseif>
		</p>
		<p class="short-input ue-clear newstyle">
			<label>预期目标名称：</label>
			<s:property value="task.name" />
		</p>
		<p class="short-input ue-clear newstyle">
			<label>所属三级项目:</label>
			<s:property value="task.pro3_id" />
		</p>
		<p class="short-input ue-clear newstyle">
			<label>预期目标内容：</label>
			<textarea rows="3" cols="5" readonly="readonly"><s:property value="task.content"/></textarea>
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
