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

<title>二级项目列表</title>
</head>

<body>
	<div class="title">
		<h2>二级项目列表</h2>
	</div>
	<div class="query">
		<div class="table-box">
			<table>
				<thead>
					<tr>
						<th class="num">项目编号</th>
						<th class="name">项目名称</th>
						<th class="process">资金总数(单位:万元)</th>
						<th class="process">计划完成时间</th>
						<th class="process">实际完成时间</th>
						<th class="name" style="color: red">待审核要点数</th>
						<th class="num">项目进度</th>
						<th class="num">状态</th>
						<th class="operate">操作</th>
					</tr>
				</thead>
				<s:iterator value="p2s" var="p2" status="p2t">
					<tr>
						<td><s:property value="#p2.no" /></td>
						<td><s:property value="#p2.name" /></td>
						<td><s:property value="#p2.money" /></td>
						<td><s:property value="#p2.plan_time" /></td>
						<td><s:property value="#p2.finish_time" /></td>
						<s:if test="#p2.num ==0">
							<td>0</td>
						</s:if>
						<s:else>
							<td style="color: red;"><s:property value="#p2.num" /></td>
						</s:else>
						<td><s:property value="#p2.schedule" /></td>
						<td><s:if test="#p2.state==1">建设中</s:if> <s:if
								test="#p2.state==2">已完成</s:if></td>
						<td class="table-operate ue-clear"><s:if test="qqq==2">
								<a
									href="<%=basePath%>project2/project2_pend2Bypro1admin?id=<s:property value="#p2.id"/>"
									class="add">查看</a>
							</s:if>
							<s:else>
								<a
									href="<%=basePath%>project2/project2_pend2?id=<s:property value="#p2.id"/>"
									class="add">查看</a>
							</s:else></td>
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
