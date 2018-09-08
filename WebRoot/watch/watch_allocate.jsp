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
<title>要点分配</title>
</head>

<body>
	<div class="title">
		<h2>要点分配</h2>
	</div>
	<form action="<%=basePath%>watch/watch_allocate2" method="post">
		<div class="main">

		
				<div style="margin-left: 200px; font-size: 18px;">
				<label>所属院部：</label> 
				<select name="dept0" onchange="getUsers0(this.value)">
					<option value="">请选择所属院部</option>
					<s:iterator value="deptss" var="d" status="status">
						<option value="<s:property value="#d.id" />"><s:property value="#d.name" /></option>
					</s:iterator>
				</select>

				<label>&nbsp;&nbsp;&nbsp;&nbsp;所属责任人：</label> <select id="select0" name="watch.user_id">
					<option value="">请选择所属参与人</option>
				</select>
			</div><br>
				
				
			</p>
			<p class="short-input ue-clear"><h3 style="color: red;">如果有别的部门参与该要点，请选择参与人。</h3></p><br>
			<div style="margin-left: 200px; font-size: 18px;">
				<label>所属院部：</label> 
				<select name="dept1" onchange="getUsers1(this.value)" >
					<option value="">请选择所属院部</option>
					<s:iterator value="deptss" var="d" status="status">
						<option value="<s:property value="#d.id" />"><s:property value="#d.name" /></option>
					</s:iterator>
				</select>
				<label>&nbsp;&nbsp;&nbsp;&nbsp;参与人：</label> <select id="select1" name="watch.user1_id">
					<option value="">请选择所属参与人</option>
				</select>
			</div><br>
			<div style="margin-left: 200px; font-size: 18px;">
				<label>所属院部：</label> 
				<select name="dept2" onchange="getUsers2(this.value)">
					<option value="">请选择所属院部</option>
					<s:iterator value="deptss" var="d" status="status">
						<option value="<s:property value="#d.id" />"><s:property value="#d.name" /></option>
					</s:iterator>
				</select>

				<label>&nbsp;&nbsp;&nbsp;&nbsp;参与人：</label> <select id="select2" name="watch.user2_id">
					<option value="">请选择所属参与人</option>
				</select>
			</div><br>
			<input type="hidden" name="watch.id"
				value="<s:property value="watch.id"/>"> <input type="hidden"
				name="user.id" value="<s:property value="user.id"/>">
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

