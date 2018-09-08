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
	function submitit() {
		var a = document.getElementById('a').value;
		if (a != "") {
			alert("提交成功!");
			return true;
		} else {
			alert("输入信息不能为空！");
			return false;
		}
	}
</script>
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
		var obj_file2 = document.getElementById("file2");
		var obj_file3 = document.getElementById("file3");
		var obj_file4 = document.getElementById("file4");
		var obj_file5 = document.getElementById("file5");
		var obj_file6 = document.getElementById("file6");
		var obj_file7 = document.getElementById("file7");
		var filesize1 = 0;
		var filesize2 = 0;
		var filesize3 = 0;
		var filesize4 = 0;
		var filesize5 = 0;
		var filesize6 = 0;
		var filesize7 = 0;
		if (browserCfg.firefox || browserCfg.chrome) {
			if (obj_file.value.length != 0) {
				filesize1 = obj_file.files[0].size;
			}
			if (obj_file2.value.length != 0) {
				filesize2 = obj_file2.files[0].size;
			}
			if (obj_file3.value.length != 0) {
				filesize3 = obj_file3.files[0].size;
			}
			if (obj_file4.value.length != 0) {
				filesize4 = obj_file4.files[0].size;
			}
			if (obj_file5.value.length != 0) {
				filesize5 = obj_file5.files[0].size;
			}
			if (obj_file6.value.length != 0) {
				filesize6 = obj_file6.files[0].size;
			}
			if (obj_file7.value.length != 0) {
				filesize7 = obj_file7.files[0].size;
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
		} else if (filesize1 > maxsize || filesize2 > maxsize || filesize3 > maxsize || filesize4 > maxsize || filesize5 > maxsize || filesize6 > maxsize || filesize7 > maxsize) {
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
		<h2>提交验收要点</h2>
	</div>
	<div class="main">


		<form action="<%=basePath%>file/file_add2" method="post"
			enctype="multipart/form-data">
			<p class="short-input ue-clear">
				<label>经费预算:</label> ${watch.money }&nbsp;&nbsp;万元
			</p>
			<p class="short-input ue-clear">
				<label>经费支出:</label><input id="a" type="text" name="watch.realMoney"
					placeholder="请输入数字  (单位:万元)" />&nbsp;万元
			</p>
			<br> <label style="color: red;">&nbsp;&nbsp;单个文件限制最大为20M，若是文件太多或太大，可以把文件压缩，然后上传压缩包</label>
			<p class="short-input ue-clear">
				<label>文件1:</label> <input id="file1" type="file" name="uploads" />
			</p>
			<p class="short-input ue-clear">
				<label>文件1描述:</label>
				<textarea placeholder="请输入文件1的描述" name="file.content1"></textarea>
			</p>
			<p class="short-input ue-clear">
				<label>文件2:</label> <input id="file2" type="file" name="uploads" />
			</p>
			<p class="short-input ue-clear">
				<label>文件2描述:</label>
				<textarea placeholder="请输入文件2的描述" name="file.content2"></textarea>
			</p>
			<p class="short-input ue-clear">
				<label>文件3:</label> <input id="file3" type="file" name="uploads" />
			</p>
			<p class="short-input ue-clear">
				<label>文件3描述:</label>
				<textarea placeholder="请输入文件3的描述" name="file.content3"></textarea>
			</p>
			<p class="short-input ue-clear">
				<label>文件4:</label> <input id="file4" type="file" name="uploads" />
			</p>
			<p class="short-input ue-clear">
				<label>文件4描述:</label>
				<textarea placeholder="请输入文件4的描述" name="file.content4"></textarea>
			</p>
			<p class="short-input ue-clear">
				<label>文件5:</label> <input id="file5" type="file" name="uploads" />
			</p>
			<p class="short-input ue-clear">
				<label>文件5描述:</label>
				<textarea placeholder="请输入文件5的描述" name="file.content5"></textarea>
			</p>
			<p class="short-input ue-clear">
				<label>文件6:</label> <input id="file6" type="file" name="uploads" />
			</p>
			<p class="short-input ue-clear">
				<label>文件6描述:</label>
				<textarea placeholder="请输入文件6的描述" name="file.content6"></textarea>
			</p>
			<p class="short-input ue-clear">
				<label>文件7:</label> <input id="file7" type="file" name="uploads" />
			</p>
			<p class="short-input ue-clear">
				<label>文件7描述:</label>
				<textarea placeholder="请输入文件7的描述" name="file.content7"></textarea>
			</p>
			<input type="hidden" name="file.watch_id"
				value="<s:property value="watch.id"/>" /> <input type="hidden"
				name="user.id" value="${user.id }" />
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
