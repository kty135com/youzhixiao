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


<title>用户列表</title>
</head>

<body>

	<div class="title">
		<h2>用户列表</h2>
	</div>
	<div class="query">
		<div class="table-box">
			<form action="<%=basePath%>user/user_find" method="post">
				<label>按权限查看：</label> <input type="radio" name="user.state"
					value="0" />超级管理员 <input type="radio" name="user.state" value="1" />一级管理员
				<input type="radio" name="user.state" value="2" />二级管理员 <input
					type="radio" name="user.state" value="3" />责任人
				<div class="btn ue-clear">
					<input type="submit" class="button long2 ok" value="查找" />
				</div>
			</form>
			<table>
				<thead>
					<tr>
						<th class="num">用户名</th>
						<th class="name">密码</th>
						<th class="name">真实姓名</th>
						<th class="name">权限</th>
						<th class="name">部门</th>
						<th class="name">操作</th>
					</tr>
				</thead>
				<s:iterator value="list" var="p1" status="p1t">
					<tr>
						<td><s:property value="#p1.name" /></td>
						<td><s:property value="#p1.pwd" /></td>
						<td><s:property value="#p1.realName" /></td>
						<td><s:if test="#p1.state==0">超级管理员</s:if> <s:if
								test="#p1.state==1">一级管理员</s:if> <s:if test="#p1.state==2">二级管理员</s:if>
							<s:if test="#p1.state==3">责任人</s:if></td>
						<td><s:property value="#p1.dept" /></td>
						<td class="table-operate ue-clear"><a
							href="<%=basePath%>user/user_lookup?id=<s:property value="#p1.id"/>"
							class="add">修改</a> <a
							href="<%=basePath%>user/user_del?id=<s:property value="#p1.id"/>"
							class="del">删除</a></td>
					</tr>
				</s:iterator>
			</table>
			<!-- 	<form action="<%=basePath%>Admin/Market_list" method="post"
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
			</form> -->
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
