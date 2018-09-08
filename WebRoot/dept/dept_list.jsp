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
<title>部门录入</title>
</head>

<body>
	<div class="title">
		<h2>部门录入</h2>
	</div>
	<div class="query">
		<div class="table-box">
			<form action="<%=basePath%>dept/dept_add" method="post">
				<label>部门名称：</label> <input size="30" type="text" name="dept.name" />
				<div class="btn ue-clear">
					<input type="submit" class="button long2 ok" value="添加" />
				</div>
			</form>
			<form action="<%=basePath%>dept/dept_addExcel" method="post"
				enctype="multipart/form-data">
				<div class="main">
					<p style="color: red;font-size: 20px;">在下面你可以进行部门的excel表(xls格式)批量导入</p>
					<p class="short-input ue-clear">
						<label>批量导入:</label> <input type="file" name="upload">
					</p>
					<p class="short-input ue-clear">
						<input type="submit" class="button long2 ok" value="提交" />
					</p>
				</div>
			</form>
			<table>
				<thead>
					<tr>
						<th class="num">序号</th>
						<th class="name">部门名称</th>
						<th class="operate">操作</th>
					</tr>
				</thead>
				<s:iterator value="depts" var="d" status="status">
					<tr>
						<td><s:property value="#status.index+1" /></td>
						<td><s:property value="#d.name" /></td>
						<td class="table-operate ue-clear"><a
							href="<%=basePath%>dept/dept_update1?dept.id=<s:property value="#d.id"/>"
							class="edit">修改</a> <a
							href="<%=basePath%>dept/dept_delete?dept.id=<s:property value="#d.id"/>"
							class="del">删除</a></td>
					</tr>
				</s:iterator>
			</table>
		</div>
	</div>
</body>
<script type="text/javascript" src="<%=basePath%>js/jquery.js"></script>
<script type="text/javascript" src="<%=basePath%>js/common.js"></script>
<script type="text/javascript" src="<%=basePath%>js/WdatePicker.js"></script>
<script type="text/javascript">
	$(".select-title").on("click", function() {
		$(".select-list").toggle();
		return false;
	});
	$(".select-list").on("click", "li", function() {
		var txt = $(this).text();
		$(".select-title").find("span").text(txt);
	});


	showRemind('input[type=text], textarea', 'placeholder');
</script>
</html>
