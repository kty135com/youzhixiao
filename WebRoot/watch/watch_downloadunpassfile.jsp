<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
	String dateTime = sdf.format(new Date());
%>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="<%=basePath%>css/base.css" />
<link rel="stylesheet" href="<%=basePath%>css/info-reg.css" />
<title>失败要点文件下载</title>
</head>

<body>
	<div class="title">
		<h2>失败要点的文件下载</h2>
	</div>
	<form action="<%=basePath%>watch/watch_unpass" method="post">
		<div class="main">
				<br>
				<p class="short-input ue-clear">
					<label>文件1:</label>
					<s:if test="file.tname1!=null">
						<a
							href="<%=basePath%>file/file_look?file.id=${file.id}&fileName=${file.name1 }">查看</a>&nbsp;&nbsp;&nbsp;<a
							href="<%=basePath%>file/file_down?fileName=${file.name1 }&file.path=${file.path }">下载</a>
						<s:property value="file.tname1" />
					</s:if>
				</p>
				<p class="short-input ue-clear">
					<label>文件1描述:</label>
					<textarea readonly="readonly"><s:property value="file.content1"/></textarea>
				</p>
				<p class="short-input ue-clear">
					<label>文件2:</label>
					<s:if test="file.tname2!=null">
						<a
							href="<%=basePath%>file/file_look?file.id=${file.id}&fileName=${file.name2 }">查看</a>&nbsp;&nbsp;&nbsp;<a
							href="<%=basePath%>file/file_down?fileName=${file.name2 }&file.path=${file.path }">下载</a>
						<s:property value="file.tname2" />
					</s:if>
				</p>
				<p class="short-input ue-clear">
					<label>文件2描述:</label>
					<textarea readonly="readonly"><s:property value="file.content2"/></textarea>
				</p>
				<p class="short-input ue-clear">
					<label>文件3:</label>
					<s:if test="file.tname3!=null">
						<a
							href="<%=basePath%>file/file_look?file.id=${file.id}&fileName=${file.name3 }">查看</a>&nbsp;&nbsp;&nbsp;<a
							href="<%=basePath%>file/file_down?fileName=${file.name3 }&file.path=${file.path }">下载</a>
						<s:property value="file.tname3" />
					</s:if>
				</p>
				<p class="short-input ue-clear">
					<label>文件3描述:</label>
					<textarea readonly="readonly"><s:property value="file.content3"/></textarea>
				</p>
				<p class="short-input ue-clear">
					<label>文件4:</label>
					<s:if test="file.tname4!=null">
						<a
							href="<%=basePath%>file/file_look?file.id=${file.id}&fileName=${file.name4 }">查看</a>&nbsp;&nbsp;&nbsp;<a
							href="<%=basePath%>file/file_down?fileName=${file.name4 }&file.path=${file.path }">下载</a>
						<s:property value="file.tname4" />
					</s:if>
				</p>
				<p class="short-input ue-clear">
					<label>文件4描述:</label>
					<textarea readonly="readonly"><s:property value="file.content4"/></textarea>
				</p>
				<p class="short-input ue-clear">
					<label>文件5:</label>
					<s:if test="file.tname5!=null">
						<a
							href="<%=basePath%>file/file_look?file.id=${file.id}&fileName=${file.name5 }">查看</a>&nbsp;&nbsp;&nbsp;<a
							href="<%=basePath%>file/file_down?fileName=${file.name5 }&file.path=${file.path }">下载</a>
						<s:property value="file.tname5" />
					</s:if>
				</p>
				<p class="short-input ue-clear">
					<label>文件5描述:</label>
					<textarea readonly="readonly"><s:property value="file.content5"/></textarea>
				</p>
				<p class="short-input ue-clear">
					<label>文件6:</label>
					<s:if test="file.tname6!=null">
						<a
							href="<%=basePath%>file/file_look?file.id=${file.id}&fileName=${file.name6 }">查看</a>&nbsp;&nbsp;&nbsp;<a
							href="<%=basePath%>file/file_down?fileName=${file.name6 }&file.path=${file.path }">下载</a>
						<s:property value="file.tname6" />
					</s:if>
				</p>
				<p class="short-input ue-clear">
					<label>文件6描述:</label>
					<textarea readonly="readonly"><s:property value="file.content6"/></textarea>
				</p>
				<p class="short-input ue-clear">
					<label>文件7:</label>
					<s:if test="file.tname7!=null">
						<a
							href="<%=basePath%>file/file_look?file.id=${file.id}&fileName=${file.name7 }">查看</a>&nbsp;&nbsp;&nbsp;<a
							href="<%=basePath%>file/file_down?fileName=${file.name7 }&file.path=${file.path }">下载</a>
						<s:property value="file.tname7" />
					</s:if>
				</p>
				<p class="short-input ue-clear">
					<label>文件7描述:</label>
					<textarea readonly="readonly"><s:property value="file.content7"/></textarea>
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
