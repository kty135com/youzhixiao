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


<title>三级项目列表</title>
</head>

<body>
	<div class="title">
		<h2>三级项目列表</h2>
	</div>
	<h4><div align="center" style="color: red; ">*如出现无法删除现象请先删除其子预期目标</div></h4>
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
						<th class="num">项目进度</th>
						<th class="num">状态</th>
						<th class="operate">操作</th>
					</tr>
				</thead>
				<s:iterator value="list" var="p3" status="p3t">
					<tr>
						<td><s:property value="#p3.no" />
						</td>
						<td><s:property value="#p3.name" />
						</td>
						<td><s:property value="#p3.money" />
						</td>
						<td><s:property value="#p3.plan_time" />
						</td>
						<td><s:property value="#p3.finish_time" />
						</td>
						<td><s:property value="#p3.schedule" />
						</td>
						<td><s:if test="#p3.state==1">建设中</s:if> <s:if
								test="#p3.state==2">已完成</s:if></td>
						<td class="table-operate ue-clear"><a
							href="<%=basePath%>project3/project3_lookup?id=<s:property value="#p3.id"/>"
							class="add">查看</a> <a
							href="<%=basePath%>project3/project3_del?id=<s:property value="#p3.id"/>"
							class="del">删除</a></td>
					</tr>
				</s:iterator>
			</table>
	<!--		<form action="<%=basePath%>Admin/Market_list" method="post"
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
