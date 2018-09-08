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
<script type="text/javascript" src="<%=basePath%>js/ajax.js"></script>
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
		var e = document.getElementById('pro2select').value;
		var f = document.getElementById('pro3select').value;
		var h = document.getElementById('m').value;
		if (a != "" && b != "" && c != "" && e != "" && f != "" && h != "") {
			return true;
		} else {
			alert("输入信息不能为空！");
			return false;
		}
	}
</script>
<title>预期目标录入</title>
</head>

<body>
	<div class="title">
		<h2>预期目标录入</h2>
	</div>
	<form action="<%=basePath%>task/task_add2" method="post">
		<div class="main">
			<div>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; <label>阶段:</label>&nbsp;&nbsp;&nbsp;&nbsp;<input
					id="m" type="radio" name="task.moment" value="0" checked="checked">中期（2018）&nbsp;&nbsp;&nbsp;&nbsp;
				<input id="m" type="radio" name="task.moment" value="1">验收期（2019）
			</div>
			<p class="short-input ue-clear">
				<label>预期目标名称:</label> <input id="a" type="text"
					placeholder="请输入预期目标名称" name="task.name" />(必填)
			</p>
			<p class="short-input ue-clear">
				<label>预期目标内容：</label>
				<textarea placeholder="请输入预期目标要求" id="b" name="task.content"></textarea>
				(必填)
			</p>

			<p class="short-input ue-clear">
			<div style="margin-left: 30px; font-size: 13px;">
				<label>所属一级项目：</label> <select id="c" onchange="getPro2(this.value)">
					<option value="">请选择所属一级项目</option>
					<s:iterator value="list" var="p2" status="p2t">
						<option value="<s:property value="#p2.id"/>">
							<s:property value="#p2.name"></s:property>
						</option>
					</s:iterator>
				</select>(必填)<label>&nbsp;&nbsp;&nbsp;&nbsp;所属二级项目：</label> <select
					id="pro2select" onchange="getPro3(this.value)">
					<option value="">请选择二级项目</option>

				</select>(必填)<label>&nbsp;&nbsp;&nbsp;&nbsp;所属三级项目：</label> <select
					id="pro3select" name="pro3.id">
					<option value="">请选择三级项目</option>
				</select>(必填)
			</div>
			<br>
			</p>

			<p class="short-input ue-clear">
				<input type="submit" onclick="return submitit()"
					class="button long2 ok" value="提交" /> <input type="reset"
					class="button long2 normal" value="清空" />
			</p>
		</div>
	</form>
	<form action="<%=basePath%>task/task_addExcel" method="post"
		enctype="multipart/form-data">
		<div class="main">
			<p style="color: red;font-size: 20px;">在下面你可以进行任务的excel表(xls格式)批量导入</p>
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
