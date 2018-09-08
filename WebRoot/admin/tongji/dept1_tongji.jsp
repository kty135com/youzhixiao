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
<link rel="stylesheet" href="<%=basePath%>css/info-mgt.css" />
<link rel="stylesheet" href="<%=basePath%>css/WdatePicker.css" />


<title>统计视图</title>
</head>

<body>
	<div class="title">
		<h2>按部门统计</h2>
	</div>
	<br>
	<form action="<%=basePath%>project1/project1_tongjiByPro1" method="get">
			<input type="submit" class="button long2 ok" value="按项目统计" />
	</form>
	<div class="query">
		<div class="table-box">
			<table>
				<thead>
					<tr>
						<th class="name">部门名称</th>
						<th class="process">承担要点数</th>
						<th class="process">已完成要点数</th>
						<th class="process">完成比例</th>
						<th class="process">按期完成率</th>
					</tr>
				</thead>
				<s:iterator value="#session.tongjideptlist" var="p1" status="p1t">
					<tr>
						<td><s:property value="#p1.name" /></td>
						<td><s:property value="#p1.watchsum" /></td>
						<td><s:property value="#p1.finishsum" /></td>
						<td><s:property value="#p1.finishratio" /></td>
						<td><s:property value="#p1.rate" /></td>
					</tr>
				</s:iterator>
			</table>
			<!--	<form action="<%=basePath%>Admin/Market_list" method="post"
				name="form">
				当前是第
				<s:property value="cPage" />
				页 <select name="cPage">
					<s:iterator value="pages" var="p">
						<option value="<s:property value="#p"/>">
							第
							<s:property value="#p" />
							页
						</option>
					</s:iterator>
				</select> <input name="submit" type="submit" value="跳转">
			</form>-->
		</div>
	</div>
</body>
<script type="text/javascript" src="<%=basePath%>js/jquery.js"></script>
<script type="text/javascript" src="<%=basePath%>js/common.js"></script>
<script type="text/javascript" src="<%=basePath%>js/WdatePicker.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/jquery.pagination.js"></script>
<script type="text/javascript">
	$(".select-title").on("click", function() {
		$(".select-list").hide();
		$(this).siblings($(".select-list")).show();
		return false;
	})
	$(".select-list").on(
		"click",
		"li",
		function() {
			var txt = $(this).text();
			$(this).parent($(".select-list")).siblings($(".select-title"))
				.find("span").text(txt);
		})

	$('.pagination').pagination(100, {
		callback : function(page) {
			alert(page);
		},
		display_msg : true,
		setPageNo : true
	});

	$("tbody").find("tr:odd").css("backgroundColor", "#eff6fa");

	showRemind('input[type=text], textarea', 'placeholder');
</script>
</html>
