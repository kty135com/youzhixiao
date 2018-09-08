<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page import="java.text.SimpleDateFormat"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
	String s = sdf.format(new Date());
%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="<%=basePath%>css/base.css" />
<link rel="stylesheet" href="<%=basePath%>css/info-reg.css" />
<script type="text/javascript">
	var q=	${qqq};
	if(q==1){
		alert("操作成功!");
	}
</script>

<script type="text/javascript">
	function submitit() {
		var a = document.getElementById('a').value;
		var b = document.getElementById('b').value;
		var c = document.getElementById('c').value;
		var d = document.getElementById('d').value;
		var e = document.getElementById('e').value;
		if (a != "" && b != "" && c != "" && d != "" && e != "") {
			return true;
		} else {
			alert("输入信息不能为空！");
			return false;
		}
	}
</script>
<title>新建用户</title>
</script>
</head>

<body>
	<div class="title">
		<h2>新建用户</h2>
	</div>
	<form action="<%=basePath%>user/user_add" method="post">
		<div class="main">
			<p class="short-input ue-clear">
				<label>用户名:</label> <input id="a" type="text" placeholder="请输入用户名"
					autocomplete="off" name="user.name" />
			</p>
			<p class="password ue-clear">
				<label>密码:</label> <input id="e" required="required" size="38"
					style="border-color: #aa00000;padding: 5px" type="password"
					placeholder="请输入密码" autocomplete="off" name="user.pwd" />
			</p>
			<p class="short-input ue-clear">
				<label>真实姓名：</label> <input id="b" type="text" placeholder="请输入真实姓名"
					autocomplete="off" name="user.realName" />
			</p>
			<p class="short-input ue-clear">
				<label>院部：</label> <select id="c" name="user.dept_id">
					<s:iterator value="list" var="u1" status="u1t">
						<option value="<s:property value="#u1.id"/>">
							<s:property value="#u1.name"></s:property>
						</option>
					</s:iterator>
				</select>
			</p>
			<p class="short-input ue-clear">
				<label>权限：</label> <label><input id="d" name="user.state"
					type="radio" value="0">超级管理员</label> <label><input
					name="user.state" type="radio" value="1">一级管理员</label> <label><input
					name="user.state" type="radio" value="2">二级管理员</label> <label><input
					name="user.state" type="radio" value="3">责任人</label>
			</p>
		</div>
		<div class="btn ue-clear">
			<input type="submit" onclick="return submitit()"
				class="button long2 ok" value="提交" /> <input type="reset"
				class="button long2 normal" value="清空" />
		</div>
	</form>
	<form action="<%=basePath%>user/user_addExcel" method="post"
		enctype="multipart/form-data">
		<div class="main">
			<p style="color: red;font-size: 20px;">在下面你可以进行用户的excel表(xls格式)批量导入</p>
			<p class="short-input ue-clear">
				<label>批量导入:</label> <input type="file" name="upload">
			</p>
			<p class="short-input ue-clear">
				<input type="submit" class="button long2 ok" value="提交" />
			</p>
		</div>
	</form>
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
