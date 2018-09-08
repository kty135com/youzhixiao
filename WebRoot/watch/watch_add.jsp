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
		var d = document.getElementById('d').value;
		var ff = document.getElementById('f').value;
		var e = document.getElementById('pro2select').value;
		var f = document.getElementById('pro3select').value;
		var g = document.getElementById('taskselect').value;

		if (a != "" && b != "" && c != "" && d != "" && e != "" && f != "" && g != "" && ff != "") {
			return true;
		} else {
			alert("输入信息不能为空！");
			return false;
		}
	}
</script>
<title>验收要点录入</title>
</head>

<body>
	<div class="title">
		<h2>验收要点录入</h2>
	</div>
	<form action="<%=basePath%>watch/watch_add2" method="post">

		<div class="main">

			<p class="short-input ue-clear">
				<label>验收要点名称:</label> <input id="a" type="text" name="watch.name"
					placeholder="请输入验收要点名称" />(必填)
			</p>
			<p class="short-input ue-clear">
				<label>要点编号：</label> <input type="text" id="f" placeholder="请输入要点编号"
					autocomplete="off" name="watch.no" />(必填)
			</p>
			<p class="short-input ue-clear">
				<label>计划完成时间:</label> <input id="b" type="text"
					name="watch.plan_time"
					onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"
					placeholder="请输入计划完成时间" />(必填)
			</p>
			<p class="short-input ue-clear">
				<label>要点资金预算:</label> <input id="z" type="text" name="watch.money"
					placeholder="请输入验收要点名称" />(必填)
			</p>
			<p class="short-input ue-clear">
				<label>验收要点内容：</label>
				<textarea placeholder="请输入预期目标要求" id="c" name="watch.content"
					placeholder="请输入验收要点内容"></textarea>
				(必填)
			</p>

			<p class="short-input ue-clear">
			<div style="margin-left: 30px; font-size: 13px;">
				<label>所属一级项目：</label> <select id="d" onchange="getPro2(this.value)">
					<option value="">请选择所属一级项目</option>
					<s:iterator value="list" var="p2" status="p2t">
						<option value="<s:property value="#p2.id"/>">
							<s:property value="#p2.name"></s:property>
						</option>
					</s:iterator>
				</select>(必填) <label>&nbsp;&nbsp;&nbsp;&nbsp;所属二级项目：</label> <select
					id="pro2select" onchange="getPro3(this.value)">
					<option value="">请选择二级项目</option>

				</select>(必填)<label>&nbsp;&nbsp;&nbsp;&nbsp;所属三级项目：</label> <select
					id="pro3select" onchange="getTask(this.value)">
					<option value="">请选择三级项目</option>

				</select>(必填)<label>&nbsp;&nbsp;&nbsp;&nbsp;所属预期目标：</label> <select
					id="taskselect" name="watch.task_id">
					<option value="">请选择预期目标</option>
				</select>(必填)
			</div>
			</p>

			<p class="short-input ue-clear">
				<input type="submit" onclick="return submitit()"
					class="button long2 ok" value="提交" /> <input type="reset"
					class="button long2 normal" value="清空" />
			</p>
		</div>

	</form>
	<form action="<%=basePath%>watch/watch_addExcel" method="post"
		enctype="multipart/form-data">
		<div class="main">
			<p style="color: red;font-size: 20px;">在下面你可以进行要点的excel表(xls格式)批量导入</p>
			<p class="short-input ue-clear">
				<label>要点批量导入:</label> <input type="file" name="upload">
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
