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
<title>提交材料</title>
<script type="text/javascript">
	function submitit() {
		var a = document.getElementById('a').value;
		if (a != "") {
			alert("提交成功!");
			return true;
		} else {
			alert("请提交内容！");
			return false;
		}
	}
</script>
</head>

<body>
	<div class="title">
		<h2>提交材料</h2>
	</div>
	<form action="<%=basePath%>file/file_cg_Add" method="post"
		enctype="multipart/form-data">
		<div class="main">
			<br> <label style="color: red;">若是文件太多或太大，可以把文件压缩，然后上传压缩包</label>
			<p class="short-input ue-clear">
				<label>文件1:</label> <input type="file" name="uploads" />
			</p>
			<p class="short-input ue-clear">
				<label>文件2:</label> <input type="file" name="uploads" />
			</p>
			<p class="short-input ue-clear">
				<label>文件3:</label> <input type="file" name="uploads" />
			</p>
			<p class="short-input ue-clear">
				<label>文件4:</label> <input type="file" name="uploads" />
			</p>
			<p class="short-input ue-clear">
				<label>文件5:</label> <input type="file" name="uploads" />
			</p>
			<p class="short-input ue-clear">
				<label>文件6:</label> <input type="file" name="uploads" />
			</p>
			<p class="short-input ue-clear">
				<label>文件7:</label> <input type="file" name="uploads" />
			</p>
			<input type="hidden" name="cgFile.cg_id"
				value="<s:property value="id"/>" />
			<p class="short-input ue-clear">
				<input type="submit" class="button long2 ok"
					onclick="return submitit()" value="提交" /> <input type="reset"
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
