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
<link rel="stylesheet" href="<%=basePath%>css/info-reg.css" />
<script type="text/javascript">


	function submitit() {
		var a = document.getElementById('newpwd1').value;
		var b = document.getElementById('newpwd2').value;
		if (a == b) {
			return true;
		} else {
			alert("两次输入新密码不相同，请重新输入");
			return false;
		}
	}
</script>
<title>密码修改</title>
</head>

<body>
	<div class="title">
		<h2>密码修改</h2>
	</div>
	<form action="<%=basePath%>user/user_changepwd2" method="post">

		<div class="main">

			<p class="short-input ue-clear">
				<label>原密码:</label> <input id="a" type="password" name="user.pwd"
					placeholder="请输入原来的密码" />(必填)
			</p>
			<p class="short-input ue-clear">
				<label>新密码：</label> <input type="password" id="newpwd1"
					placeholder="请输入新密码" autocomplete="off" name="newpwd" />(必填)
			</p>
			<p class="short-input ue-clear">
				<label>再次输入新密码:</label> <input id="newpwd2" type="password"
					placeholder="请再次输入新密码" />(必填)
			</p>
			<input type="hidden" name="user.id" value="${user.id }">
			<p class="short-input ">
				<input type="submit" onclick="return submitit()"
					class="button long2 ok" value="提交" /> <input type="reset"
					class="button long2 normal" value="清空" />
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
