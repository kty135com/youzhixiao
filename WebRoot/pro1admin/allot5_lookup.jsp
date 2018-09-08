<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
	<%@ taglib prefix="s" uri="/struts-tags"%>
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
<title>二级项目修改</title>
</head>

<body>
	<div class="title">
		<h2>二级项目修改</h2>
	</div>
	<form action="<%=basePath%>/project2/project2_allot6" method="post">
		<div class="main">
			<p class="short-input ue-clear">
				<label>项目名称:</label>${ project2.name}
			</p>
			<p class="short-input ue-clear">
				<label>项目编号:</label>${project2.no }
			</p>
			<p class="short-input ue-clear">
				<label>资金总数(单位:万元)：</label>${project2.money }
			</p>
			<p class="short-input ue-clear">
				<label>完成日期：</label>${project2.plan_time }
			</p>
			<p class="short-input ue-clear">
				<label>部门负责人：</label> <select name="project2.user_id">
					<s:iterator value="p2s" var="p1" status="p1t">
						<option value="<s:property value="#p1.id"/>">
							<s:property value="#p1.realName"></s:property>
						</option>
					</s:iterator>
				</select>
			</p>
			<input type="hidden" name="project2.id" value="${project2.id }">
			<input type="hidden" name="project2.name" value="${ project2.name} ">
			<input type="hidden" name="project2.no" value="${project2.no }">
			<input type="hidden" name="project2.money" value="${project2.money }">
			<input type="hidden" name="project2.plan_time" value="${project2.plan_time }">
			<input type="hidden" name="project2.pro1_id" value="${project2.pro1_id }"> 
			<input type="hidden" name="project2.schedule" value="${project2.schedule }">
			<input type="hidden" name="project2.state" value="${project2.state }">
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
