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
		<h2>二级项目管理</h2>
	</div>
	<s:if test="#session.loginInfo==5"></s:if><s:else>
	<form action="<%=basePath%>/project2/project2_updata" method="post">
		<div class="query">
			<div class="query-conditions ue-clear">
				<div class="conditions name ue-clear">
					<label>项目名称</label> <input type="text" placeholder="请输入项目名称"
						autocomplete="off" name="project2.name" value="${ project2.name}" />
				</div>
				<div class="conditions name ue-clear">
					<label>项目编号</label> <input type="text" placeholder="请输入项目编号"
						autocomplete="off" name="project2.no" value="${project2.no }" />
				</div>
				<div class="conditions name ue-clear">
					<label>资金总数：</label> <input type="text"
						placeholder="请输入资金总数   (单位:万元)" autocomplete="off"
						name="project2.money" value="${project2.money }" />
				</div>
				<div class="conditions name ue-clear">
					<label>完成日期：</label> <input type="text" placeholder="计划完成时间"
						onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" autocomplete="off"
						name="project2.plan_time" value="${project2.plan_time }" />
				</div>
			</div>
			<input type="hidden" name="project2.id" value="${project2.id }">
			<input type="hidden" name="project2.state" value="${project2.state }">
			<input type="hidden" name="project2.user_id"
				value="${project2.user_id }"> <input type="hidden"
				name="project2.schedule" value="${project2.schedule }">
			<div class="query-btn ue-clear">
				<input type="submit" class="button long2 ok" value="提交" /> <input
					type="reset" class="button long2 normal" value="清空" />
			</div>
		</div>
	</form></s:else>
	<div class="table-box">
		<table>
			<thead>
				<tr>
					<th class="num">项目编号</th>
					<th class="name">项目名称</th>
					<th class="process">资金总数</th>
					<th class="process">计划完成时间</th>
					<th class="process">实际完成时间</th>
					<th class="num">项目进度</th>
					<th class="num">状态</th>
					<th class="operate">操作</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="p2s" var="p3" status="p3t">
					<tr>
						<td><s:property value="#p3.no" /></td>
						<td><s:property value="#p3.name" /></td>
						<td><s:property value="#p3.money" /></td>
						<td><s:property value="#p3.plan_time" /></td>
						<td><s:property value="#p3.finish_time" /></td>
						<td><s:property value="#p3.schedule" /></td>
						<td><s:if test="#p3.state==1">建设中</s:if> <s:if
								test="#p3.state==2">已完成</s:if></td>
						<td class="table-operate ue-clear"><a
							href="<%=basePath%>project3/project3_lookup?id=<s:property value="#p3.id"/>"
							class="add">查看</a><s:if test="#sessionScope.loginInfo!=lingdao"> <a
							href="<%=basePath%>project3/project3_del?id=<s:property value="#p3.id"/>"
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
