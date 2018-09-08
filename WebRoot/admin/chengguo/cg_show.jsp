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
<title>文件查看</title>
</head>

<body>
	<div class="title">
		<h2>文件查看</h2>
	</div>
	<div class="main">
		<p class="short-input ue-clear">
			<label>文件1:</label><a
				href="<%=basePath%>file/file_cgdown?fileName=<s:property value="cgFile.tname1"/>&cgFile.path=<s:property value="cgFile.path"/>">查看</a>
			<s:property value="cgFile.name1" />
		</p>
		<p class="short-input ue-clear">
			<label>文件2:</label><a
				href="<%=basePath%>file/file_cgdown?fileName=<s:property value="cgFile.tname2"/>&cgFile.path=<s:property value="cgFile.path"/>">查看</a>
			<s:property value="cgFile.name2" />
		</p>
		<p class="short-input ue-clear">
			<label>文件3:</label><a
				href="<%=basePath%>file/file_cgdown?fileName=<s:property value="cgFile.tname3"/>&cgFile.path=<s:property value="cgFile.path"/>">查看</a>
			<s:property value="cgFile.name3" />
		</p>
		<p class="short-input ue-clear">
			<label>文件4:</label><a
				href="<%=basePath%>file/file_cgdown?fileName=<s:property value="cgFile.tname4"/>&cgFile.path=<s:property value="cgFile.path"/>">查看</a>
			<s:property value="cgFile.name4" />
		</p>
		<p class="short-input ue-clear">
			<label>文件5:</label><a
				href="<%=basePath%>file/file_cgdown?fileName=<s:property value="cgFile.tname5"/>&cgFile.path=<s:property value="cgFile.path"/>">查看</a>
			<s:property value="cgFile.name5" />
		</p>
		<p class="short-input ue-clear">
			<label>文件6:</label><a
				href="<%=basePath%>file/file_cgdown?fileName=<s:property value="cgFile.tname6"/>&cgFile.path=<s:property value="cgFile.path"/>">查看</a>
			<s:property value="cgFile.name6" />
		</p>
		<p class="short-input ue-clear">
			<label>文件7:</label><a
				href="<%=basePath%>file/file_cgdown?fileName=<s:property value="cgFile.tname7"/>&cgFile.path=<s:property value="cgFile.path"/>">查看</a>
			<s:property value="cgFile.name7" />
		</p>
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
