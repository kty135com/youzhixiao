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
<link rel="stylesheet" href="<%=basePath%>css/info-mgt.css" />
<link rel="stylesheet" href="<%=basePath%>css/WdatePicker.css" />
<title>未完成验收要点列表</title>

<script type="text/javascript">
	function fujian() {
		var msg = "您是否确定将本要点设置为完成？设置后将无法更改，并提交给上级管理员审核!";
		if (confirm(msg) == true) {
			return true;
		} else {
			return false;
		}
	}

	function warning(num) {
		if (num != 0) {
			var msg = "检测到您已上传文件，再次上传将删除之前上传的文件，是否确认？";
			if (confirm(msg) == true) {
				return true;
			} else {
				return false;
			}
		}
	}
</script>

</head>
<body>
	<div class="title">
		<h2>未完成验收要点列表</h2>
	</div>
	<div class="query">
		<div class="table-box">
			<table>
				<thead>
					<tr>
						<th class="num">序号</th>
						<th class="name">验收要点编号</th>
						<th class="process">验收要点名称</th>
						<th class="process">计划完成时间</th>
						<th class="node">验收要点内容</th>
						<th class="operate">操作</th>
					</tr>
				</thead>
				<s:iterator value="watchList" var="w" status="status">
					<tr>
						<td><s:property value="#status.index+1" /></td>
						<td><s:property value="#w.no" /></td>
						<td><s:property value="#w.name" /></td>
						<td><s:property value="#w.plan_time" /></td>
						<td><s:property value="#w.content" /></td>
						<td class="table-operate ue-clear"><a
							href="<%=basePath%>watch/watch_show?watch.id=<s:property value="#w.id"/>&user.id=<s:property value="user.id"/>"
							class="add">查看</a> <a
							href="<%=basePath%>schedule/schedule_add1?watch.id=<s:property value="#w.id"/>"
							class="check">进度</a> <a
							onclick="javascript:return warning('${w.num}');"
							href=" <%=basePath%>
							file/file_add1?watch.id=<s:property value="#w.id"/>
							&user.id=${user.id }"
							class="edit">附件</a><a onclick="javascript:return fujian();"
							href="<%=basePath%>file/file_updateState?watch.id=<s:property value="#w.id"/>"
							class="check">完成</a></td>
					</tr>
				</s:iterator>
			</table>
			<%-- <form action="<%=basePath %>Admin/Market_list"method="post"name="form">
        当前是第<s:property value="cPage"/>页
                   <select name="cPage">
                   <s:iterator value="pages" var="p">
                         <option value="<s:property value="#p"/>">第<s:property value="#p"/>页</option>                   
                   </s:iterator>
                    </select>
                    <input name="submit" type="submit" value="跳转">           
    </form> --%>
		</div>
	</div>
</body>
<script type="text/javascript" src="<%=basePath%>js/jquery.js"></script>
<script type="text/javascript" src="<%=basePath%>js/common.js"></script>
<script type="text/javascript" src="<%=basePath%>js/WdatePicker.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/jquery.pagination.js"></script>
<script type="text/javascript">
	$(".select-title").on("click", function() {
		$(".select-list").hide();
		$(this).siblings($(".select-list")).show();
		return false;
	})
	$(".select-list").on("click", "li", function() {
		var txt = $(this).text();
		$(this).parent($(".select-list")).siblings($(".select-title")).find("span").text(txt);
	})

	$('.pagination').pagination(100, {
		callback : function(page) {
			alert(page);
		},
		display_msg : true,
		setPageNo : true
	});

	$("tbody").find("tr:odd").css("backgroundColor", "#eff6fa");

	showRemind('input[type=text], textarea', 'placeholder');
</script>
</html>
