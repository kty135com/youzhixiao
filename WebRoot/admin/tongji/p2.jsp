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
<script type="text/javascript" src="<%=basePath%>js/echarts.js"></script>
<title>二级项目查看</title>

</head>

<body>
	<div class="title">
		<h2>二级项目</h2>
	</div>
	<br>
	<form action="javascript:history.back(-1);" method="get">
		<input type="submit" class="button long2 ok" value="返回上一页" />
	</form>
	<div class="main">
		<p class="short-input ue-clear">
			<label>项目编号:</label>
			<s:property value="project2.no" />
		</p>
		<p class="short-input ue-clear">
			<label>项目名称:</label>
			<s:property value="project2.name" />
		</p>
		<p class="short-input ue-clear">
			<label>要点个数:</label>
			<s:property value="project2.watchsum" />
		</p>
		<p class="short-input ue-clear">
			<label>完成个数:</label>
			<s:property value="project2.finishsum" />
		</p>
		<p class="short-input ue-clear">
			<label>完成比例:</label> <label style="color: red;"><s:property
					value="project2.finishratio" /></label>
		</p>
		<p class="short-input ue-clear">
			<label>按期完成率:</label>
			<s:property value="project2.rate" />
		</p>
		<br>
		<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
		<div id="main" style="width: 1000px;height:600px;"></div>
		<script type="text/javascript">
			// 基于准备好的dom，初始化echarts实例
			var myChart = echarts.init(document.getElementById('main'));
			var unfinishsum = '${project2.watchsum}' - '${project2.finishsum}';
			option = {
				title : {
					text : '${project2.name}',
					subtext : '完成比例',
					x : 'center'
				},
				tooltip : {
					trigger : 'item',
					formatter : "{a} <br/>{b} : {c} ({d}%)"
				},
				legend : {
					orient : 'vertical',
					x : 'left',
					data : [ '已完成', '未完成' ]
				},
				toolbox : {
					show : true,
					feature : {
						mark : {
							show : true
						},
						dataView : {
							show : true,
							readOnly : false
						},
						magicType : {
							show : true,
							type : [ 'pie', 'funnel' ],
							option : {
								funnel : {
									x : '25%',
									width : '50%',
									funnelAlign : 'left',
									max : 1548
								}
							}
						},
						restore : {
							show : true
						},
						saveAsImage : {
							show : true
						}
					}
				},
				calculable : true,
				series : [
					{
						name : '验收要点',
						type : 'pie',
						radius : '55%',
						center : [ '50%', '60%' ],
						data : [
							{
								value : '${project2.finishsum}',
								name : '已完成'
							},
							{
								value : unfinishsum,
								name : '未完成'
							}
						]
					}
				]
			};
		
		
			// 使用刚指定的配置项和数据显示图表。
			myChart.setOption(option);
		</script>
		<br>
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
