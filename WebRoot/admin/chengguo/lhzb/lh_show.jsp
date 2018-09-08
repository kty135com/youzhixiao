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
<title>量化指标信息</title>
</head>

<body>
	<div class="title">
		<h2>量化指标信息</h2>
	</div>
	<div class="main">
		<p class="short-input ue-clear newstyle">
			<label>序号：</label>
			<s:property value="lhzb.num" />
		</p>
		<p class="short-input ue-clear newstyle">
			<label>指标内容：</label>
			<s:property value="lhzb.content" />
		</p>
		<p class="short-input ue-clear newstyle">
			<label>说明：</label>
			<s:property value="lhzb.desc" />
		</p>
		<p class="short-input ue-clear newstyle">
			<label>基础：</label>
			<s:property value="lhzb.base" />
		</p>
		<p class="short-input ue-clear newstyle">
			<label>标杆院校目前指标值：</label>
			<textarea readonly="readonly"><s:property value="lhzb.zb"/></textarea>
		</p>
		<p class="short-input ue-clear newstyle">
			<label>中期预期目标：</label>
			<s:property value="lhzb.mid" />
		</p>
		<p class="short-input ue-clear newstyle">
			<label>中期完成情况：</label>
			<s:property value="lhzb.midfenshu" />
		</p>
		<form action="cg/cg_update1" method="post">
		<p class="short-input ue-clear newstyle">
			<label style="color: red">*更新中期进度：</label>
			<input  type="text" name="lhzb.midFenZi" placeholder="最大值为<s:property value="lhzb.midFenMu" />">
		</p>
		<input type="hidden" name="lhzb.id" value="<s:property value="lhzb.id" />">
		<span><input type="submit" value="提交"></span>
		</form>
		<p class="short-input ue-clear newstyle">
			<label>验收预期目标：</label>
			<s:property value="lhzb.last" />
		</p>
		<p class="short-input ue-clear newstyle">
			<label>验收完成情况：</label>
			<s:property value="lhzb.lastfenshu" />
		</p>
		<form action="cg/cg_update2" method="post">
		<p class="short-input ue-clear newstyle">
			<label style="color: red">*更新验收进度：</label>
			<input  type="text" name="lhzb.lastFenZi" placeholder="最大值为<s:property value="lhzb.lastFenMu" />">
		</p>
		<input type="hidden" name="lhzb.id" value="<s:property value="lhzb.id" />">
		<span><input type="submit" value="提交"></span>
		</form>
		<p class="short-input ue-clear newstyle">
			<label>牵头部门：</label>
			<s:property value="lhzb.dept" />
		</p>
		
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
