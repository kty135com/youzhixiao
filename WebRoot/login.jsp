<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%=basePath%>css/base.css" />
<link rel="stylesheet" href="<%=basePath%>css/login.css" />
<script type="text/javascript">
	function login() {
		var name = document.getElementById('name').value;
		var pwd = document.getElementById('pwd').value;
		if (name != "" && pwd != "") {
			return true;
		} else {
			alert("用户名密码不能为空！");
			return false;
		}
	}
</script>

<title>日照职业技术学院创优办</title>
</head>
<body>
	<div id="container">
		<div id="bd">
			<div class="login">
				<form action="<%=basePath%>/user/user-login" method="post">
					<div class="login-top">
						<h1 class="logo"></h1>
					</div>
					<div class="login-input">
						<p class="user ue-clear">
							<label>用户名</label> <input id="name" type="text" name="user.name"
								placeholder="请输入用户名" style="ime-mode:disabled" />
						</p>
						<p class="password ue-clear">
							<label>密&nbsp;&nbsp;&nbsp;码</label> <input id="pwd"
								type="password" name="user.pwd" placeholder="请输入密码"
								style="ime-mode:disabled" />
						</p>
					</div>
					<div class="login-btn ue-clear">
						<input type="submit" class="btn" onclick="return login()"
							value="登录">
					</div>
				</form>
			</div>
		</div>
	</div>
	<div id="ft">
		<a href="http://10.6.20.18:8080/project">优质校项目建设管理系统v2.0&nbsp;&nbsp;&nbsp;&nbsp;技术问题反馈qq:915519331</a>
	</div>
</body>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript">
	var height = $(window).height();
	$("#container").height(height);
	$("#bd").css("padding-top", height / 2 - $("#bd").height() / 2);

	$(window).resize(
		function() {
			var height = $(window).height();
			$("#bd").css("padding-top",
				$(window).height() / 2 - $("#bd").height() / 2);
			$("#container").height(height);

		});

	$('#remember').focus(function() {
		$(this).blur();
	});

	$('#remember').click(function(e) {
		checkRemember($(this));
	});

	function checkRemember($this) {
		if (!-[ 1, ]) {
			if ($this.prop("checked")) {
				$this.parent().addClass('checked');
			} else {
				$this.parent().removeClass('checked');
			}
		}
	}
</script>
</html>