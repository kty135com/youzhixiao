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
<title>验收要点查看</title>
</head>

<body>
	<div class="title">
		<h2>验收要点列表</h2>
	</div>
	<br>
	<form action="javascript:history.back(-1);" method="get">
		<input type="submit" class="button long2 ok" value="返回上一页" />
	</form>
	<br>
	<div class="table-box">
		<table>
			<thead>
				<tr>
					<th class="num">验收要点编号</th>
					<th class="name">验收要点名称</th>
					<th class="process">验收要点内容</th>
					<th class="process">计划完成时间</th>
					<th class="process">实际完成时间</th>
					<th class="name">状态</th>
					<th class="operate">操作</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="tasks" var="watch" status="p3t">
					<tr>
						<td><s:property value="#watch.no" /></td>
						<td><s:property value="#watch.name" /></td>
						<td><s:property value="#watch.content" /></td>
						<td><s:property value="#watch.plan_time" /></td>
						<td><s:property value="#watch.finish_time" /></td>
						<td><s:if test="#watch.state==0">未完成</s:if> <s:if
								test="#watch.state==1">待审核</s:if> <s:if test="#watch.state==2">待验收</s:if>
							<s:if test="#watch.state==3">审核失败</s:if> <s:if
								test="#watch.state==4">待超管验收<font
									color="red">*</font></s:if>
								<s:if test="#watch.state==5">超管通过</s:if></td>
						<td class="table-operate ue-clear"><a
							href="<%=basePath%>file/file_lookup?id=<s:property value="#watch.id"/>"
							class="add">查看</a><s:if test="#watch.state==4"><a
							href="<%=basePath%>watch/watch_adminshenhe?watch.id=<s:property value="#watch.id"/>"
							class="edit">通过</a><a
							href="<%=basePath%>watch/watch_admintuihui?watch.id=<s:property value="#watch.id"/>"
							class="del">退回</a></s:if></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
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
