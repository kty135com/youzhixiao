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
<title>项目查看</title>
</head>

<body>
<br>
	<form action="javascript:history.back(-1);" method="get">
		<input type="submit" class="button long2 ok" value="返回上一页" />
	</form>
	<br>
	<div class="title">
		<h2>一级信息管理</h2>
	</div>
	 <s:if test="#session.loginInfo==5"></s:if><s:else>
	<form action="<%=basePath%>/project1/project1_updata" method="post">
	<div class="query">
		<div class="query-conditions ue-clear">
			<div class="conditions name ue-clear">
				<label>项目名称</label> <input type="text" placeholder="请输入项目名称"
					autocomplete="off" name="project1.name" value="${ project1.name}" />
			</div>
			<div class="conditions name ue-clear">
				<label>项目编号</label> <input type="text" placeholder="请输入项目编号"
					autocomplete="off" name="project1.no" value="${project1.no }" />
			</div>
			<div class="conditions name ue-clear">
				<label>资金总数：</label> <input type="text" placeholder="请输入资金总数   (单位:万元)"
					autocomplete="off" name="project1.money" value="${project1.money }" />
			</div>
			<div class="conditions name ue-clear">
				<label>计划完成：</label> <input type="text" placeholder="计划完成时间"
					onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" autocomplete="off"
					name="project1.plan_time" value="${project1.plan_time }" />
			</div>
			<div class="conditions name ue-clear">
				<label>实际完成：</label> <input type="text" placeholder="计划完成时间"
					onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" autocomplete="off"
					name="project1.finish_time" value="${project1.finish_time }" />
			</div>
			<div class="conditions name ue-clear">
				<label>开始时间：</label> <input type="text" placeholder="项目开始时间"
					onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" autocomplete="off"
					name="project1.start_time" value="${project1.start_time }" />
			</div>
		</div>
			<input type="hidden" name="project1.id" value="${project1.id }">
			<input type="hidden" name="project1.state" value="${project1.state }">
			<input type="hidden" name="project1.user_id" value="${project1.user_id }">
			<input type="hidden" name="project1.schedule" value="${project1.schedule }">
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
				<s:iterator value="list" var="p2" status="p2t">
					<tr>
						<td><s:property value="#p2.no" /></td>
						<td><s:property value="#p2.name" /></td>
						<td><s:property value="#p2.money" /></td>
						<td><s:property value="#p2.plan_time" /></td>
						<td><s:property value="#p2.finish_time" /></td>
						<td><s:property value="#p2.schedule" /></td>
						<td><s:if test="#p2.state==1">建设中</s:if> <s:if
								test="#p2.state==2">已完成</s:if>
						</td>
						<td class="table-operate ue-clear"><a
							href="<%=basePath%>project2/project2_lookup?id=<s:property value="#p2.id"/>"
							class="add">查看</a><s:if test="#sessionScope.loginInfo!=lingdao"> <a
							href="<%=basePath%>project2/project2_del?id=<s:property value="#p2.id"/>"
							class="del">删除</a></s:if>
						</td>
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
