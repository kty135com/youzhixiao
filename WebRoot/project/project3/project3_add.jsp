<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page import="java.text.SimpleDateFormat"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
	String s = sdf.format(new Date());
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
		var c = document.getElementById('c').value;
		var d = document.getElementById('d').value;
		var e = document.getElementById('pro2select').value;
		var f = document.getElementById('f').value;
		if (a != "" && c != "" && d != "" && e != "" && f != "") {
			return true;
		} else {
			alert("输入信息不能为空！");
			return false;
		}
	}
</script>

<title>三级项目录入</title>
</head>

<body>
	<div class="title">
		<h2>三级项目录入</h2>
	</div>

	<form action="<%=basePath%>/project3/project3_add" method="post">
		<div class="main">
			<div style="color: red;">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;* 新建三级项目需提前分配所属二级项目的二级管理员<br>
				<br>
			</div>
			<p class="short-input ue-clear">
				<label>项目名称:</label> <input id="a" type="text" placeholder="请输入项目名称"
					autocomplete="off" name="project3.name" />(必填)
			</p>
			<p class="short-input ue-clear">
				<label>项目编号：</label> <input type="text" id="f" placeholder="请输入项目编号"
					autocomplete="off" name="project3.no" />(必填)
			</p>
			<p class="short-input ue-clear">
				<label>资金总数：</label> <input id="b" type="text"
					placeholder="请输入资金总数   (单位:万元)" autocomplete="off"
					name="project3.money" />
			</p>
			<p class="short-input ue-clear">
				<label>完成日期：</label> <input id="c" type="text" placeholder="计划完成时间"
					onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" autocomplete="off"
					name="project3.plan_time" />(必填)
			</p>
			<p class="short-input ue-clear">
			<div style="margin-left: 30px; font-size: 13px;">
				<label>所属一级项目：</label> <select id="d" name="pro1"
					onchange="getPro2(this.value)">
					<option value="">请选择所属一级项目</option>
					<s:iterator value="list" var="p2" status="p2t">
						<option value="<s:property value="#p2.id"/>">
							<s:property value="#p2.name"></s:property>
						</option>
					</s:iterator>
				</select>(必填) <label>&nbsp;&nbsp;&nbsp;&nbsp;所属二级项目：</label> <select
					id="pro2select" name="project3.pro2_id">
					<option value="">请选择二级项目</option>
				</select>(必填)
			</div>
			<br>
			</p>
			<input type="hidden" name="project3.state" value="1"> <input
				type="hidden" name="project3.schedule" value="0%">
		</div>
		<div class="btn ue-clear">
			<input type="submit" class="button long2 ok"
				onclick="return submitit()" value="提交" /> <input type="reset"
				class="button long2 normal" value="清空" />
		</div>
	</form>
	<form action="<%=basePath%>project3/project3_addExcel" method="post"
		enctype="multipart/form-data">
		<div class="main">
			<p style="color: red;font-size: 20px;">在下面你可以进行三级项目的excel表(xls格式)批量导入</p>
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
