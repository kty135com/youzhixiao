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
<title>验收要点基本信息</title>
</head>

<body>
<div class="title"><h2>验收要点基本信息</h2></div>
<div class="main">
    <p class="short-input ue-clear newstyle">
    	<label>验收要点编号：</label><s:property value="watch.no"/>
    </p>
	<p class="short-input ue-clear newstyle">
    	<label>验收要点名称：</label><s:property value="watch.name"/>
    </p>
    <p class="short-input ue-clear newstyle">
    	<label>验收要点要求：</label><textarea readonly="readonly"><s:property value="watch.content"/></textarea>
    </p>
    <p class="short-input ue-clear newstyle">
    	<label>状态：</label><s:property value="showState"/>
    </p>
    <p class="short-input ue-clear newstyle">
    	<label>计划完成时间：</label><s:property value="watch.plan_time"/>
    </p>
    <p class="short-input ue-clear newstyle">
    	<label>实际完成时间：</label><s:property value="watch.finish_time"/>
    </p>
    <p class="short-input ue-clear newstyle">
    	<label>所属预期目标：</label><s:property value="task.name"/>
    </p>
    <p class="short-input ue-clear newstyle">
    	<label>所属负责人：</label><s:property value="user.name"/>
    </p>
    <p class="short-input ue-clear newstyle">
    	<label>参与人：</label><s:property value="user1.name"/>,</label><s:property value="user2.name"/>
    </p>
    <p class="short-input ue-clear newstyle">
    	<label>审核失败意见:</label><textarea readonly="readonly">${audit.opinion }</textarea>
    </p>
    <p>
			<a class="button long2 ok" href="<%=basePath%>/watch/watch_downloadunpassfile?watch.id=${watch.id}&user.id=${user.id}">失败文件下载</a>
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
