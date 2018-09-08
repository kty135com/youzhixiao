<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="<%=basePath%>css/base.css" />
<link rel="stylesheet" href="<%=basePath%>css/info-reg.css" />
<title>部门基本信息</title>
</head>

<body>
<div class="title"><h2>部门基本信息</h2></div>
<div class="main">
	<p class="short-input ue-clear newstyle">
    	<label>部门名称：</label><%-- <s:property value="dept.name"/> --%>
    </p>
    <p class="short-input ue-clear newstyle">
    	<label>承担项目数：</label><%-- <s:property value="dept.pro3_cnt"/> --%>
    </p>
    <p class="short-input ue-clear newstyle">
    	<label>已完成项目数：</label><%-- <s:property value="dept.pro3_success_cnt"/> --%>
    </p>
    <p class="short-input ue-clear newstyle">
    	<label>承担预期目标数：</label><%-- <s:property value="dept.task_cnt"/> --%>
    </p>
    <p class="short-input ue-clear newstyle">
    	<label>已完成预期目标数：</label><%-- <s:property value="dept.task_success_cnt"/> --%>
    </p>
    <p class="short-input ue-clear newstyle">
    	<label>部门管理员：</label><%-- <s:property value="dept.u_leader"/> --%>
    </p>
</div>

</body>
<script type="text/javascript" src="<%=basePath%>js/jquery.js"></script>
<script type="text/javascript" src="<%=basePath%>js/common.js"></script>
<script type="text/javascript" src="<%=basePath%>js/WdatePicker.js"></script>
<script type="text/javascript">
$(".select-title").on("click",function(){
	$(".select-list").toggle();
	return false;
});
$(".select-list").on("click","li",function(){
	var txt = $(this).text();
	$(".select-title").find("span").text(txt);
});


showRemind('input[type=text], textarea','placeholder');
</script>
</html>
