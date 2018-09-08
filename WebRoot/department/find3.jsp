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
<title>项目查看</title>
</head>

<body>
	<br>
	<form action="javascript:history.back(-1);" method="get">
		<input type="submit" class="button long2 ok" value="返回上一页" />
	</form>
	<br>
	<div class="title">
		<h2>预期目标列表</h2>
	</div>
	<div class="table-box">
		<table>
			<thead>
				<tr>
					<th class="num">预期目标编号</th>
					<th class="name">预期目标阶段</th>
					<th class="name">预期目标名称</th>
					<th class="process">预期目标内容</th>
					<th class="operate">操作</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="list" var="task" status="p3t">
					<tr>
						<td><s:property value="#task.no" /></td>
						<td><s:if test="#task.moment==0">中期(2018)</s:if> <s:elseif
								test="#task.moment==1">验收期(2019)</s:elseif></td>
						<td><s:property value="#task.name" /></td>
						<td><s:property value="#task.content" /></td>
						<td class="table-operate ue-clear"><a
							href="<%=basePath%>/project2/project2_dmlook4?id=<s:property value="#task.id"/>"
							class="add">查看</a></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</div>
	<div class="pagination ue-clear"></div>
</body>
<script type="text/javascript" src="<%=basePath%>js/jquery.js"></script>
<script type="text/javascript" src="<%=basePath%>js/common.js"></script>
<script type="text/javascript" src="<%=basePath%>js/WdatePicker.js"></script>

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
