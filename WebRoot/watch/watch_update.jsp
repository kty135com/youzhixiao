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
<title>验收要点修改</title>
</head>

<body>
	<div class="title">
		<h2>验收要点修改</h2>
	</div>
	<form action="<%=basePath%>watch/watch_update2" method="post">
		<div class="main">
			<p class="short-input ue-clear">
				<label>验收要点编号:</label> <input type="text" name="watch.no" value="<s:property value="watch.no"/>"/>
			</p>
			<p class="short-input ue-clear">
				<label>验收要点名称:</label> <input type="text" name="watch.name"value="<s:property value="watch.name"/>"/>
			</p>
			<p class="short-input ue-clear">
				<label>计划完成时间:</label> <input type="date" name="watch.plan_time" value="<s:property value="watch.plan_time"/>"/>
			</p>
			<p class="short-input ue-clear">
				<label>验收要点内容：</label>
				<textarea name="watch.content"><s:property value="watch.content"/></textarea>
			</p>

			<p class="short-input ue-clear">
				<label>所属预期目标:</label> <select name="watch.task_id">
					<option value="">请选择所属预期目标</option>
					<s:iterator value="tasks" var="t" status="status">
						<option value="<s:property value="#t.id" />"><s:property value="#t.name" /> </option>
					</s:iterator>
				</select>
		     </p>
		     <input type="hidden" name="watch.id" value="<s:property value="watch.id"/>"/>
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
