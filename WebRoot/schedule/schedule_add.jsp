<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<%
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	String s = sdf.format(new Date());
%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="<%=basePath%>css/base.css" />
<link rel="stylesheet" href="<%=basePath%>css/info-reg.css" />
<title>进度提交</title>
<script type="text/javascript">
	function tijiao(){
		alert("提交成功!");
	}
</script>
</head>

<body>
<br>
	<form action="javascript:history.back(-1);" method="get">
		<input type="submit" class="button long2 ok" value="返回上一页" />
	</form>
	<br>
	<div class="title">
		<h2>进度提交</h2>
	</div>
	<form action="<%=basePath%>schedule/schedule_add2" method="post"  enctype="multipart/form-data">
		<div class="main">
		<label style="color: red;">若是文件太多或太大，可以把文件压缩，然后上传压缩包</label>
			<p class="short-input ue-clear">
				<label>文件：</label> <input type="file" name="upload" />
			</p>
			<p class="short-input ue-clear">
				<label>提交内容：</label>
				<textarea class="textarea" placeholder="请输入相关描述" name="schedule.content"></textarea>
			</p>
			
			<input type="hidden" name="watch.id" value="${watch.id }"/>
			<input type="hidden" name="user.id" value="<s:property value="user.id"/>"/>
			<div class="btn ue-clear">
				<input type="submit" class="button long2 ok" onclick="tijiao()" value="提交" /> <input
					type="reset" class="button long2 normal" value="清空" />
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
