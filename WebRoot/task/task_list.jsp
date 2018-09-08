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
<title>预期目标列表</title>
</head>

<body>
	<div class="title">
		<h2>预期目标列表</h2>
	</div>
	<div class="query">
		<div class="table-box">
			<table>
				<thead>
					<tr>
						<th class="num">序号</th>
						<th class="name">预期目标编号</th>
						<th class="name">预期目标阶段</th>
						<th class="process">预期目标名称</th>
						<th class="node">预期目标内容</th>
						<th class="operate">操作</th>
					</tr>
				</thead>
				<s:iterator value="tasks" var="t" status="status">
					<tr>
						<td><s:property value="#status.index+1" /></td>
						<td><s:property value="#t.no" /></td>
						<td><s:if test="#t.moment==0">中期(2018)</s:if> <s:elseif
								test="#t.moment==1">验收期(2019)</s:elseif></td>
						<td><s:property value="#t.name" /></td>
						<td><s:property value="#t.content" /></td>
						<td class="table-operate ue-clear"><a
							href="<%=basePath%>task/task_show?task.id=<s:property value="#t.id"/>"
							class="add">查看</a> <a
							href="<%=basePath%>task/task_update1?task.id=<s:property value="#t.id"/>"
							class="edit">修改</a> <a
							href="<%=basePath%>task/task_delete?task.id=<s:property value="#t.id"/>"
							class="del">删除</a></td>
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
