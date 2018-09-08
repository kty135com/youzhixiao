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
<title>预期目标修改</title>
</head>

<body>
	<div class="title">
		<h2>预期目标修改</h2>
	</div>
	<form action="<%=basePath%>task/task_update2" method="post">
		<div class="main">
			<input type="hidden" name="task.id"
				value="<s:property value="task.id"/>">
			<p class="short-input ue-clear">
				<label>预期目标编号:</label> <input type="text" name="task.no"
					value="<s:property value="task.no"/>">
			</p>
			<p class="short-input ue-clear">
				<label>预期目标名称:</label> <input type="text" name="task.name"
					value="<s:property value="task.name"/>">
			</p>
			<p class="short-input ue-clear">
				<label>所属三级项目:</label> <select name="task.pro3_id">
					<option value="">请选择所属三级项目</option>
					<s:iterator value="pro3s" var="p" status="ps">
						<option value="<s:property value="#p.id" />"><s:property value="#p.name" /> </option>
					</s:iterator>
				</select>
			</p>
			<p class="short-input ue-clear">
				<label>预期目标内容:</label>
				<textarea name="task.content"><s:property value="task.content"/></textarea>
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
