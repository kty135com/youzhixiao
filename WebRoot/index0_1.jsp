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

<title>超级管理员</title>
<!--按钮生成器—工具啦 http://www.tool.la-->
<style>
.thisclass {
	background-color: #2A83CF
}
/* 以修改*/
.fudong {
	float: left;
	padding-left: 2%;
}
</style>
<script language="javascript">

	function change(color) {
		var el = event.srcElement
		if (el.tagName == "INPUT" && el.type == "button")
			event.srcElement.style.backgroundColor = color
	}

	function jumpto2(url) {
		window.location = url
	}
</script>
</head>

<body>
	<div id="container">
		<div id="hd">
			<div class="hd-wrap ue-clear">
				<div class="top-light"></div>
				<h1 class="logo"></h1>
				<div class="login-info ue-clear">
					<div class="welcome">
						<span>欢迎您,</span>超级管理员
					</div>
				</div>
				<div class="toolbar ue-clear">
					<a href="<%=basePath%>/user/user-shouye" class="home-btn">首页</a> <a
						href="<%=basePath%>/user/user-exitlogin" class="quit-btn exit"></a>
				</div>
			</div>

			<!--以下是横向导航栏的代码-->
			<div>
				<nav id="nav">
					<form class="fudong" action="<%=basePath%>user/user-index0_1"
						method="get">
						<input type="hidden" value="1" name="urlNo"> <input
							type="hidden" value="${user.id }" name="user.id"><input
							type="image" src="<%=basePath%>images/button1.png" alt="项目基本情况"
							width="122" height="29" />
					</form>

					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<form class="fudong" action="<%=basePath%>user/user-index0_1"
						method="get">
						<input type="hidden" value="2" name="urlNo"> <input
							type="hidden" value="${user.id }" name="user.id"><input
							type="image" src="<%=basePath%>images/button2.png" alt="各级项目进展"
							width="122" height="29" />
					</form>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<form class="fudong" action="<%=basePath%>user/user-index0_1">
						<input type="hidden" value="3" name="urlNo"> <input
							type="hidden" value="${user.id }" name="user.id"><input
							type="image" src="<%=basePath%>images/button3.png" alt="成果展示"
							width="122" height="29" />
					</form class="fudong">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<form class="fudong" action="<%=basePath%>user/user-index0_1">
						<input type="hidden" value="4" name="urlNo"> <input
							type="hidden" value="${user.id }" name="user.id"><input
							type="image" src="<%=basePath%>images/button4.png" alt="量化指标"
							width="122" height="29" />
					</form>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<form class="fudong" action="<%=basePath%>user/user-index0_1">
						<input type="hidden" value="5" name="urlNo"><input
							type="hidden" value="${user.id }" name="user.id"> <input
							type="image" src="<%=basePath%>images/button5.png" alt="汇总统计"
							width="122" height="29" />
					</form>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				</nav>
			</div>

		</div>
		<div id="bd">
			<div class="wrap ue-clear">
				<div class="sidebar">
					<h2 class="sidebar-header">
						<p>功能导航</p>
					</h2>
					<ul class="nav">
						<li class="">
							<div class="nav-header">
								<a href="<%=basePath%>javascript:;" class="ue-clear"><span>账户信息管理</span><i
									class="icon"></i> </a>
							</div>
							<ul class="subnav">
								<li><a href="<%=basePath%>javascript:;"
									date-src="<%=basePath%>user/user_changePassword?user.id=${user.id }">修改密码</a></li>
							</ul>
						</li>
						<li class="">
							<div class="nav-header">
								<a href="<%=basePath%>javascript:;" class="ue-clear"><span>各级项目录入</span><i
									class="icon"></i> </a>
							</div>
							<ul class="subnav">
								<li><a href="<%=basePath%>javascript:;"
									date-src="<%=basePath%>project1/project1_add0?user.id=${user.id }">一级项目录入</a>
								</li>
								<li><a href="<%=basePath%>javascript:;"
									date-src="<%=basePath%>project2/project2_add1">二级项目录入</a></li>
								<li><a href="<%=basePath%>javascript:;"
									date-src="<%=basePath%>project3/project3_add1">三级项目录入</a></li>
							</ul>
						</li>
						<li class="">
							<div class="nav-header">
								<a href="<%=basePath%>javascript:;" class="ue-clear"><span>预期目标录入</span><i
									class="icon"></i> </a>
							</div>
							<ul class="subnav">
								<li><a href="<%=basePath%>javascript:;"
									date-src="<%=basePath%>task/task_add1">添加预期目标</a></li>
							</ul>
						</li>
						<li class="">
							<div class="nav-header">
								<a href="<%=basePath%>javascript:;" class="ue-clear"><span>验收点录入</span><i
									class="icon"></i> </a>
							</div>
							<ul class="subnav">
								<li><a href="<%=basePath%>javascript:;"
									date-src="<%=basePath%>watch/watch_add1">添加验收点</a></li>
							</ul>
						</li>
						<li class="">
							<div class="nav-header">
								<a href="<%=basePath%>javascript:;" class="ue-clear"><span>各级项目管理</span><i
									class="icon"></i> </a>
							</div>
							<ul class="subnav">
								<li><a href="<%=basePath%>javascript:;"
									date-src="<%=basePath%>project1/project1_list">项目管理入口</a></li>
							</ul>
						</li>
						<li class="">
							<div class="nav-header">
								<a href="<%=basePath%>javascript:;" class="ue-clear"><span>审核验收</span><i
									class="icon"></i> </a>
							</div>
							<ul class="subnav">
								<li><a href="<%=basePath%>javascript:;"
									date-src="<%=basePath%>project1/project1_list2">待审核列表</a></li>
							</ul>
						</li>
						<li class="">
							<div class="nav-header">
								<a href="<%=basePath%>javascript:;" class="ue-clear"><span>部门管理</span><i
									class="icon"></i> </a>
							</div>
							<ul class="subnav">
								<li><a href="<%=basePath%>javascript:;"
									date-src="<%=basePath%>dept/dept_list">部门操作</a></li>
							</ul>
						</li>
						<li class="">
							<div class="nav-header">
								<a href="<%=basePath%>javascript:;" class="ue-clear"><span>用户管理</span><i
									class="icon"></i> </a>
							</div>
							<ul class="subnav">
								<li><a href="<%=basePath%>javascript:;"
									date-src="<%=basePath%>user/user_add0">新建用户</a></li>
								<li><a href="<%=basePath%>javascript:;"
									date-src="<%=basePath%>user/user_list">用户列表</a></li>
							</ul>
						</li>
						<li class="">
							<div class="nav-header">
								<a href="<%=basePath%>javascript:;" class="ue-clear"><span>成果展示</span><i
									class="icon"></i> </a>
							</div>
							<ul class="subnav">
								<li><a href="<%=basePath%>javascript:;"
									date-src="<%=basePath%>cg/cg_add">添加成果</a></li>
								<li><a href="<%=basePath%>javascript:;"
									date-src="<%=basePath%>cg/cg_list">成果列表</a></li>
							</ul>
						</li>
						<li class="">
							<div class="nav-header">
								<a href="<%=basePath%>javascript:;" class="ue-clear"><span>主要量化指标</span><i
									class="icon"></i> </a>
							</div>
							<ul class="subnav">
								<li><a href="<%=basePath%>javascript:;"
									date-src="<%=basePath%>cg/cg_addLh">添加指标</a></li>
								<li><a href="<%=basePath%>javascript:;"
									date-src="<%=basePath%>cg/cg_listlh">指标列表</a></li>
							</ul>
						</li>
						<li class="">
							<div class="nav-header">
								<a href="<%=basePath%>javascript:;" class="ue-clear"><span>统计视图</span><i
									class="icon"></i> </a>
							</div>
							<ul class="subnav">
								<li><a href="<%=basePath%>javascript:;"
									date-src="<%=basePath%>project1/project1_tongjiByPro1">按项目统计</a></li>
								<li><a href="<%=basePath%>javascript:;"
									date-src="<%=basePath%>project1/project1_tongjiByDept1">按部门统计</a></li>
							</ul>
						</li>
						<li class="">
							<div class="nav-header">
								<a href="<%=basePath%>javascript:;" class="ue-clear"><span>公告/资料管理</span><i
									class="icon"></i> </a>
							</div>
							<ul class="subnav">
								<li><a href="<%=basePath%>javascript:;"
									date-src="<%=basePath%>cg/cg_wenjianadd0">公告/资料添加</a></li>
								<li><a href="<%=basePath%>javascript:;"
									date-src="<%=basePath%>cg/cg_wenjianlist">公告/资料列表</a></li>
								<li><a href="<%=basePath%>javascript:;"
									date-src="<%=basePath%>cg/cg_wenjianupload">相关文件上传</a></li>
							</ul>
						</li>
					</ul>
				</div>
				<div class="content">
					<iframe src="<%=basePath%>${mubiaoURL }" id="iframe" width="100%"
						height="100%" frameborder="0"></iframe>
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
