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

<script type="text/javascript">
	function tijiao() {
		alert("提交成功!");
	}
</script>
<title>验收要点列表</title>
</head>

<body>
	<br>
	<form action="javascript:history.back(-1);" method="get">
		<input type="submit" class="button long2 ok" value="返回上一页" />
	</form>
	<br>
	<div class="title">
		<h2>验收要点列表</h2>
	</div>
	<div class="query">
		<div class="table-box">
			<table>
				<thead>
					<tr>
						<th class="num">验收要点编号</th>
						<th class="name">验收要点名称</th>
						<th class="process">验收要点内容</th>
						<th class="process">计划完成时间</th>
						<th class="process">实际完成时间</th>
						<th class="process">状态</th>
						<th class="operate">操作</th>
					</tr>
				</thead>
				<s:iterator value="p2s" var="p3" status="p3t">
					<tr>
						<td><s:property value="#p3.no" /></td>
						<td><s:property value="#p3.name" /></td>
						<td><s:property value="#p3.content" /></td>
						<td><s:property value="#p3.plan_time" /></td>
						<td><s:property value="#p3.finish_time" /></td>
						<td><s:if test="#p3.state==0">未完成</s:if> <s:if
								test="#p3.state==1">待部门审核</s:if> <s:if test="#p3.state==2">待一级管理员验收<font
									color="red">*</font>
							</s:if> <s:if test="#p3.state==3">审核失败</s:if> <s:if test="#p3.state==4">验收通过</s:if>
							<s:if test="#p3.state==5">超管通过</s:if></td>
						<td class="table-operate ue-clear"><a
							href="<%=basePath%>file/file_lookup?id=<s:property value="#p3.id"/>"
							class="add">查看</a> <s:if test="#p3.state==2">
								<a
									href="<%=basePath%>watch/watch_pend5?id=<s:property value="#p3.id"/>"
									class="edit" onclick="tijiao()">通过</a>
								<a
									href="<%=basePath%>watch/watch_pend6?id=<s:property value="#p3.id"/>"
									class="del" onclick="tijiao()">不通过</a>
							</s:if>
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
