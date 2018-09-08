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
<title>验收要点基本信息</title>
</head>

<body>
<br>
	<form action="javascript:history.back(-1);" method="get">
		<input type="submit" class="button long2 ok" value="返回上一页" />
	</form>
	<br>
	<div class="title">
		<h2>验收要点基本信息</h2>
	</div>
	<div class="main">
		<p class="short-input ue-clear newstyle">
			<label>验收要点编号：</label>
			<s:property value="watch.no" />
		</p>
		<p class="short-input ue-clear newstyle">
			<label>要点资金预算：</label>
			<s:property value="watch.money" />
		</p>
		<p class="short-input ue-clear newstyle">
			<label>要点实际支出：</label>
			<s:property value="watch.realMoney" />
		</p>
		<p class="short-input ue-clear newstyle">
			<label>验收要点名称：</label>
			<s:property value="watch.name" />
		</p>
		<p class="short-input ue-clear newstyle">
			<label>验收要点要求：</label>
			<textarea readonly="readonly"><s:property value="watch.content"/></textarea>
		</p>
		<p class="short-input ue-clear newstyle">
			<label>状态：</label>
			<s:property value="showState" />
		</p>
		<p class="short-input ue-clear newstyle">
			<label>计划完成时间：</label>
			<s:property value="watch.plan_time" />
		</p>
		<p class="short-input ue-clear newstyle">
			<label>实际完成时间：</label>
			<s:property value="watch.finish_time" />
		</p>
		<p class="short-input ue-clear newstyle">
			<label>所属预期目标：</label>
			<s:property value="task.name" />
		</p>
		<p class="short-input ue-clear newstyle">
			<label>所属负责人：</label>
			<s:property value="user.realName" />
		</p>
		<p class="short-input ue-clear newstyle">
			<label>参与人：</label>
			<s:if test="user1.realName != null">
				<s:property value="user1.realName" /> ; </s:if>
			<s:if test="user2.realName != null">
				<s:property value="user2.realName" /> ; </s:if>
			<s:if test="user3.realName != null">
				<s:property value="user3.realName" /> ; </s:if>
			<s:if test="user4.realName != null">
				<s:property value="user4.realName" /> ; </s:if>
			<s:if test="user5.realName != null">
				<s:property value="user5.realName" /> ; </s:if>
		</p>
		<p>
			<a class="button long2 ok" href="<%=basePath%>/schedule/schedule_look?watch.id=${watch.id}&user.id=${user.id}">查看工作进度</a>
		</p>
		<p>
			<a class="button long2 ok" href="<%=basePath%>watch/watch_fujianlook?watch.id=${watch.id}">查看所含附件</a>
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
