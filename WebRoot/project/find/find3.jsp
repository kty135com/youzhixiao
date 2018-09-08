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
		<h2>信息管理</h2>
	</div>
	<s:if test="#session.loginInfo==5"></s:if><s:else>
	<form action="<%=basePath%>/project3/project3_updata" method="post">
		<div class="query">
			<div class="query-conditions ue-clear">
				<div class="conditions name ue-clear">
					<label>项目名称</label> <input type="text" placeholder="请输入项目名称"
						autocomplete="off" name="project3.name" value="${ project3.name}" />
				</div>
				<div class="conditions name ue-clear">
					<label>项目编号</label> <input type="text" placeholder="请输入项目编号"
						autocomplete="off" name="project3.no" value="${project3.no }" />
				</div>
				<div class="conditions name ue-clear">
					<label>资金总数(单位:万元)：</label> <input type="text" placeholder="请输入资金总数"
						autocomplete="off" name="project3.money"
						value="${project3.money }" />
				</div>
				<div class="conditions name ue-clear">
					<label>完成日期：</label> <input type="text" placeholder="计划完成时间"
						onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" autocomplete="off"
						name="project3.plan_time" value="${project3.plan_time }" />
				</div>
			</div>
			<input type="hidden" name="project3.id" value="${project3.id }">
			<input type="hidden" name="project3.state" value="${project3.state }">
			<input type="hidden" name="project3.user_id"
				value="${project3.user_id }"> <input type="hidden"
				name="project3.schedule" value="${project3.schedule }">
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
					<th class="num">预期目标编号</th>
					<th class="name">预期目标阶段</th>
					<th class="name">预期目标名称</th>
					<th class="sssss">预期目标内容</th>
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
							href="<%=basePath%>task/task_lookup?id=<s:property value="#task.id"/>"
							class="add">查看</a><s:if test="#sessionScope.loginInfo!=lingdao"> <a
							href="<%=basePath%>task/task_del?id=<s:property value="#task.id"/>"
							class="del">删除</a></s:if></td>
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
