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


<title>预期目标列表</title>
</head>

<body>
	<br>
	<form action="javascript:history.back(-1);" method="get">
		<input type="submit" class="button long2 ok" value="返回上一页" />
	</form>
	<br>
	<div class="title">
		<h2>预期目标列表</h2>
	</div>
	<div class="query">
		<div class="table-box">
			<table>
				<thead>
					<tr>
						<th class="num">预期目标编号</th>
						<th class="name">预期目标阶段</th>
						<th class="name">预期目标名称</th>
						<th class="sssss">预期目标内容</th>
						<th class="name" style="color: red">待审核要点数</th>
						<th class="operate">操作</th>
					</tr>
				</thead>
				<s:iterator value="p2s" var="p3" status="p3t">
					<tr>
						<td><s:property value="#p3.no" /></td>
						<td><s:if test="#p3.moment==0">中期(2018)</s:if> <s:elseif
								test="#p3.moment==1">验收期(2019)</s:elseif></td>
						<td><s:property value="#p3.name" /></td>
						<td><s:property value="#p3.content" /></td>
						<s:if test="#p3.num ==0">
							<td>0</td>
						</s:if>
						<s:else>
							<td style="color: red;"><s:property value="#p3.num" /></td>
						</s:else>
						<td class="table-operate ue-clear"><a
							href="<%=basePath%>project2/project2_pend4?id=<s:property value="#p3.id"/>"
							class="add">查看</a>
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
