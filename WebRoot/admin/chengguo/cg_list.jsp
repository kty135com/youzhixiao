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


<title>成果列表</title>
</head>

<body>
	<div class="title">
		<h2>成果列表</h2>
	</div>
	<div class="query">
		<div class="table-box">
			<table>
				<thead>
					<tr>
						<th class="num">序号</th>
						<th class="name">类别</th>
						<th class="process">成果名称</th>
						<th class="node">负责人</th>
						<th class="node">级别</th>
						<th class="node">责任部门</th>
						<th class="operate">完成情况</th>
						<th class="operate">备注</th>
						<th>支撑材料</th>
					</tr>
				</thead>
				<s:iterator value="cgs" var="cg" status="p2t">
					<tr>
						<td><s:property value="#cg.no" />
						</td>
						<td><s:property value="#cg.state" />
						</td>
						<td><s:property value="#cg.name" />
						</td>
						<td><s:property value="#cg.person" />
						</td>
						<td><s:property value="#cg.jibie" />
						</td>
						<td><s:property value="#cg.dept" />
						</td>
						<td><s:property value="#cg.fenshu" />
						</td>
						<td><s:property value="#cg.beizhu" />
						</td>
						<td class="table-operate ue-clear"><a
							href="<%=basePath%>cg/cg_show?id=<s:property value="#cg.id"/>"
							class="add">查看</a> <a
							href="<%=basePath%>cg/cg_upload?id=<s:property value="#cg.id"/>"
							class="edit">上传</a></td>
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
