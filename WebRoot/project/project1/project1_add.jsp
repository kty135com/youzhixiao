<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page import="java.text.SimpleDateFormat"%>
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
<script type="text/javascript">
	function submitit() {
		var a = document.getElementById('a').value;
		var b = document.getElementById('b').value;
		var c = document.getElementById('c').value;
		var d = document.getElementById('d').value;
		var f = document.getElementById('f').value;
		if (a != "" && b != "" && c != "" && d != ""&& f != "") {
			return true;
		} else {
			alert("输入信息不能为空！");
			return false;
		}
	}
</script>
<title>一级项目录入</title>

</head>

<body>
	<div class="title">
		<h2>一级项目录入</h2>
	</div>
	<form action="<%=basePath%>/project1/project1_add" method="post">
		<div class="main">
			<p class="short-input ue-clear">
				<label>项目名称:</label> <input id="a" type="text" placeholder="请输入项目名称"
					autocomplete="off" name="project1.name" />(必填)
			</p>
			<p class="short-input ue-clear">
				<label>项目编号：</label> <input type="text" id="f"
					placeholder="请输入项目编号" autocomplete="off"
					name="project1.no" />(必填)
			</p>
			<p class="short-input ue-clear">
				<label>资金总数：</label> <input type="text" id="b"
					placeholder="请输入资金总数       单位：万元" autocomplete="off"
					name="project1.money" />(必填)
			</p>
			<p class="short-input ue-clear">
				<label>完成时间：</label> <input type="text" id="c" placeholder="计划完成时间"
					onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" autocomplete="off"
					name="project1.plan_time" />(必填)
			</p>
			<p class="short-input ue-clear">
				<label>项目管理员：</label> <select id="d" name="project1.user_id">
					<s:iterator value="p1list" var="u1" status="u1t">
						<option value="<s:property value="#u1.id"/>">
							<s:property value="#u1.realName"></s:property>
						</option>
					</s:iterator>
				</select>(必填)
			</p>
			<p class="short-input ue-clear">
				<label>负责人:</label> <input id="e" type="text" placeholder="请输入责任人"
					autocomplete="off" name="project1.user" />
			</p>
			<input type="hidden" name="project1.start_time" value="<%=s%>">
			<input type="hidden" name="project1.state" value="0"> <input
				type="hidden" name="project1.schedule" value="0%">
		</div>
		<div class="btn ue-clear">
			<input type="submit" onclick="return submitit()"
				class="button long2 ok" value="提交" /> <input type="reset"
				class="button long2 normal" value="清空" />
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
