<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
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
<br>
	<form action="javascript:history.back(-1);" method="get">
		<input type="submit" class="button long2 ok" value="返回上一页" />
	</form>
	<br>
	<div class="title">
		<h2>信息管理</h2>
	</div>
	<s:if test="#session.loginInfo==5"></s:if><s:else>
	<form action="<%=basePath%>/task/task_updata" method="post">
		<div class="query">
			<div class="query-conditions ue-clear">
				<div class="conditions name ue-clear">
					<label>预期目标名称</label> <input type="text" placeholder="请输入项目名称"
						autocomplete="off" name="task.name" value="${ task.name}" />
				</div>
				<div class="conditions name ue-clear">
					<label>预期目标编号</label> <input type="text" placeholder="请输入项目编号"
						autocomplete="off" name="task.no" value="${task.no }" />
				</div>
				<div class="conditions name ue-clear">
					<label>预期目标内容：</label> <input type="text" placeholder="请输入资金总数"
						autocomplete="off" name="task.content" value="${task.content }" />
				</div>

				<input type="hidden" name="task.id" value="${task.id }"> <input
					type="hidden" name="task.pro3_id" value="${task.pro3_id }">
				<div class="query-btn ue-clear">
					<input type="submit" class="button long2 ok" value="提交" /> <input
						type="reset" class="button long2 normal" value="清空" />
				</div>
			</div>
	</form>
	</s:else>
	<div class="table-box">
		<table>
			<thead>
				<tr>
					<th class="num">验收要点编号</th>
					<th class="name">验收要点名称</th>
					<th class="process">验收要点内容</th>
					<th class="process">计划完成时间</th>
					<th class="process">实际完成时间</th>
					<th class="operate">操作</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="tasks" var="watch" status="p3t">
					<tr>
						<td><s:property value="#watch.no" />
						</td>
						<td><s:property value="#watch.name" />
						</td>
						<td><s:property value="#watch.content" />
						</td>
						<td><s:property value="#watch.plan_time" />
						</td>
						<td><s:property value="#watch.finish_time" />
						</td>
						<td class="table-operate ue-clear"><a
							href="<%=basePath%>file/file_lookup?id=<s:property value="#watch.id"/>"
							class="add">查看</a> </td>
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
