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
<title>文档列表</title>
</head>

<body>
	<div class="title">
		<h2>文档列表</h2>
	</div>
	<div class="query">
		<div class="table-box">
			<br>
			<form action="javascript:history.back(-1);" method="get">
				<input type="submit" class="button long2 ok" value="返回上一页" />
			</form>
			<br>
			<table>
				<thead>
					<tr>
						<th class="num">序号</th>
						<th class="name">文档名</th>
						<th class="process">文档创建时间</th>
						<th class="node">文档状态</th>
						<th class="operate">操作</th>
					</tr>
				</thead>
				<s:iterator value="#request.list" var="t" status="status">
					<tr>
						<td><s:property value="#status.index+1" /></td>
						<td><s:property value="#t.wenjian_name" /></td>
						<td><s:property value="#t.create_time" /></td>
						<td><s:if test="#t.state==0">通知公告</s:if> <s:elseif
								test="#t.state==1">文件资料</s:elseif></td>
						<td class="table-operate ue-clear"><s:if test="#request.idd==404">
								<a
									href="<%=basePath%>cg/cg_wenjianshow?id=<s:property value="#t.wenjian_id"/>&idd=404"
									class="add">查看</a>
							</s:if>
							<s:else>
								<a
									href="<%=basePath%>cg/cg_wenjianshow?id=<s:property value="#t.wenjian_id"/>"
									class="add">查看</a>
							</s:else> <s:if test="#request.page == null">
								<a
									href="<%=basePath%>cg/cg_wenjiandel?wenjian.wenjian_id=<s:property value="#t.wenjian_id"/>"
									class="del">删除</a>
							</s:if></td>
					</tr>
				</s:iterator>
			</table>
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
	$(".select-list").on("click", "li", function() {
		var txt = $(this).text();
		$(this).parent($(".select-list")).siblings($(".select-title")).find("span").text(txt);
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
