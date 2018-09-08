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
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>css/jquery.dialog.css" />
<link rel="stylesheet" href="<%=basePath%>css/index.css" />

<title>责任人</title>
<style>
/* 以修改*/
.fudong {
	float: left;
	padding-left: 2%;
}
</style>
</head>

<body>
	<div id="container">
		<div id="hd">
			<div class="hd-wrap ue-clear">
				<div class="top-light"></div>
				<h1 class="logo"></h1>
				<div class="login-info ue-clear">
					<div class="welcome">
						<span>欢迎您,</span>责任人!
					</div>
				</div>
				<div class="toolbar ue-clear">
					<a href="<%=basePath%>/user/user-shouye?user.id=${user.id }"
						class="home-btn">首页</a> <a
						href="<%=basePath%>/user/user-exitlogin" class="quit-btn exit"></a>
				</div>
			</div>
			<!--以下是横向导航栏的代码-->
			<div>
				<nav id="nav">
					<form class="fudong" action="<%=basePath%>user/user-index0_4"
						method="get">
						<input type="hidden" value="2" name="urlNo"><input
							type="hidden" value="${user.id }" name="user.id"> <input
							type="image" src="<%=basePath%>images/button2.png" alt="各级项目进展"
							width="122" height="29" />
					</form>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<form class="fudong" action="<%=basePath%>user/user-index0_4">
						<input type="hidden" value="3" name="urlNo"><input
							type="hidden" value="${user.id }" name="user.id"> <input
							type="image" src="<%=basePath%>images/button3.png" alt="成果展示"
							width="122" height="29" />
					</form class="fudong">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<form class="fudong" action="<%=basePath%>user/user-index0_4">
						<input type="hidden" value="5" name="urlNo"><input
							type="hidden" value="${user.id }" name="user.id"> <input
							type="image" src="<%=basePath%>images/button5.png" alt="汇总统计"
							width="122" height="29" />
					</form>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </nav>
			</div>
		</div>
		<div id="bd">
			<div class="wrap ue-clear">
				<div class="sidebar">
					<h2 class="sidebar-header">
						<p>功能导航</p>
					</h2>
					<ul class="nav">
					<li class="konwledge">
							<div class="nav-header">
								<a href="<%=basePath%>javascript:;" class="ue-clear"><span>账户信息管理</span><i
									class="icon"></i> </a>
							</div>
							<ul class="subnav">
								<li><a href="<%=basePath%>javascript:;"
									date-src="<%=basePath%>user/user_changePassword?user.id=${user.id }">修改密码</a></li>
							</ul>
						</li>
						<li class="konwledge">
							<div class="nav-header">
								<a href="<%=basePath%>javascript:;" class="ue-clear"><span>验收点管理</span><i
									class="icon"></i></a>
							</div>
							<ul class="subnav">
								<li><a href="<%=basePath%>javascript:;"
									date-src="<%=basePath%>watch/watch_unfinishByTeacher?user.id=<s:property value="user.id"/>">未完成验收点</a></li>
								<li><a href="<%=basePath%>javascript:;"
									date-src="<%=basePath%>watch/watch_unpendByTeacher?user.id=<s:property value="user.id"/>">待审核验收点</a></li>
								<li><a href="<%=basePath%>javascript:;"
									date-src="<%=basePath%>watch/watch_pendFail?user.id=<s:property value="user.id"/>">审核失败验收点</a></li>
								<li><a href="<%=basePath%>javascript:;"
									date-src="<%=basePath%>watch/watch_pendSuccess?user.id=<s:property value="user.id"/>">审核成功验收点</a></li>
								<li><a href="<%=basePath%>javascript:;"
									date-src="<%=basePath%>watch/watch_pendSuccess2?user.id=<s:property value="user.id"/>">验收成功验收点</a></li>
								<li><a href="<%=basePath%>javascript:;"
									date-src="<%=basePath%>watch/watch_joinList?user.id=<s:property value="user.id"/>">参与的验收点</a></li>
							</ul>
						</li>
					</ul>
				</div>
				<div class="content">
					<iframe src="<%=basePath%>/project1/project1_zonglan"
						id="iframe" width="100%" height="100%" frameborder="0"></iframe>
				</div>
			</div>
		</div>
		<div id="ft" class="ue-clear"></div>
	</div>
</body>
<script type="text/javascript" src="<%=basePath%>js/jquery.js"></script>
<script type="text/javascript" src="<%=basePath%>js/common.js"></script>
<script type="text/javascript" src="<%=basePath%>js/core.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.dialog.js"></script>
<script type="text/javascript" src="<%=basePath%>js/index.js"></script>

</html>
