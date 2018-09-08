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
<title>提交文件</title>
<script type="text/javascript">
	var maxsize = 20 * 1024 * 1024; //20M
	var errMsg = "上传的单个文件不能超过20M！！！";
	var tipMsg = "您的浏览器暂不支持计算上传文件的大小，请确保上传文件不要超过20M";
	var browserCfg = {};
	var ua = window.navigator.userAgent;
	if (ua.indexOf("MSIE") >= 1) {
		browserCfg.ie = true;
	} else if (ua.indexOf("Firefox") >= 1) {
		browserCfg.firefox = true;
	} else if (ua.indexOf("Chrome") >= 1) {
		browserCfg.chrome = true;
	}
	function checkfile() {
		var obj_file = document.getElementById("file1");
		var filesize1 = 0;
		if (browserCfg.firefox || browserCfg.chrome) {
			if (obj_file.value.length != 0) {
				filesize1 = obj_file.files[0].size;
			}
		} else if (browserCfg.ie) {
			var obj_img = document.getElementById('tempimg');
			obj_img.dynsrc = obj_file.value;
			filesize1 = obj_img.fileSize;
		} else {
			alert(tipMsg);
			return;
		}
		if (filesize1 == -1) {
			alert(tipMsg);
			return;
		} else if (filesize1 > maxsize) {
			alert(errMsg);
			return false;
		} else {
		}
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
		<h2>为文档追加附件</h2>
	</div>
	<div class="main">


		<form action="<%=basePath%>file/file_wjupload" method="post"
			enctype="multipart/form-data">
			<p class="short-input ue-clear">
				<label>所属文档:</label> <select name="wjFile.wenjian_id">
					<option value="">请选择附件所属文档</option>
					<s:iterator value="#request.wjfList" var="wf" status="p2t">
						<option value="<s:property value="#wf.wenjian_id"/>">
							<s:property value="#wf.wenjian_name"/>
						</option>
					</s:iterator>
				</select>
			</p>
			<br> <label style="color: red;">&nbsp;&nbsp;单个文件限制最大为20M，若是文件太多或太大，可以把文件压缩，然后上传压缩包</label><br>
			<p class="short-input ue-clear">
				<label>文件:</label> <input id="file1" type="file" name="uploads" />
			</p>
			<p class="short-input ue-clear">
				<input type="submit" class="button long2 ok"
					onclick="return checkfile()" value="提交" /> <input type="reset"
					class="button long2 normal" value="清空" />
			</p>
		</form>
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
