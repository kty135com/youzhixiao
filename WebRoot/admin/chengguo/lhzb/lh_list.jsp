<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="<%=basePath%>css/base.css" />
<link rel="stylesheet" href="<%=basePath%>css/info-mgt.css" />
<link rel="stylesheet" href="<%=basePath%>css/WdatePicker.css" />


<title>量化指标列表</title>
</head>

<body>
	<div class="title">
		<h2>量化指标列表</h2>
	</div>
	<div class="query">
		<div class="table-box">
			<table>
				<thead>
					<tr>
						<th class="num">序号</th>
						<th class="name">指标内容</th>
						<th class="process">说明</th>
						<th class="node">基础</th>
						<th class="node">标杆院校目前指标值</th>
						<th class="node">中期预期目标</th>
						<th class="operate">中期完成情况</th>
						<th class="node">验收预期目标</th>
						<th class="operate">验收期完成情况</th>
						<th class="operate">牵头部门</th>
						<s:if test="#sessionScope.loginInfo!=lingdao"><th class="operate">操作</th></s:if>
					</tr>
				</thead>
				<s:iterator value="lhs" var="lh" status="p2t">
					<tr>
						<td><s:property value="#lh.num" />
						</td>
						<td><s:property value="#lh.content" />
						</td>
						<td><s:property value="#lh.desc" />
						</td>
						<td><s:property value="#lh.base" />
						</td>
						<td><s:property value="#lh.zb" />
						</td>
						<td><s:property value="#lh.mid" />
						</td>
						<td><s:property value="#lh.midfenshu" />
						</td>
						<td><s:property value="#lh.last" />
						</td>
						<td><s:property value="#lh.lastfenshu" />
						</td>
						<td><s:property value="#lh.dept" />
						</td>
						<s:if test="#sessionScope.loginInfo!=lingdao"><td class="table-operate ue-clear"><a
							href="<%=basePath%>cg/cg_update0?id=<s:property value="#lh.id"/>"
							class="add">修改</a></td></s:if>
					</tr>
				</s:iterator>
			</table>
	<!--		<form action="<%=basePath%>Admin/Market_list" method="post"
				name="form">
				当前是第
				<s:property value="cPage" />
				页 <select name="cPage">
					<s:iterator value="pages" var="p">
						<option value="<s:property value="#p"/>">
							第
							<s:property value="#p" />
							页
						</option>
					</s:iterator>
				</select> <input name="submit" type="submit" value="跳转">
			</form>-->
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
	$(".select-list").on(
			"click",
			"li",
			function() {
				var txt = $(this).text();
				$(this).parent($(".select-list")).siblings($(".select-title"))
						.find("span").text(txt);
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
