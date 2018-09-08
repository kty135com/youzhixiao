<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page import="java.text.SimpleDateFormat"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	String s = sdf.format(new Date());
%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="<%=basePath%>css/base.css" />
<link rel="stylesheet" href="<%=basePath%>css/info-reg.css" />
<link rel="stylesheet" href="<%=basePath%>css/page1.css" type="text/css">
<title>一级项目录入</title>
<style>
/* 以修改*/
.fudong {
	float: left;
	padding-left: 2%;
}

/* 以修改*/
.fudong2 {
	float: left;
	padding-left: 0%;
}
</style>
</head>


<body>
	<br />
	<form class="fudong" action="<%=basePath%>/project1/project1_zonglan"
		method="get">
		<input type="submit" class="button long2 ok" value="总体进展" />
	</form>
	<form class="fudong"
		action="<%=basePath%>user/user_getPros?user.id=${user.id }"
		method="get">
		<input type="submit" class="button long2 ok" value="重点专业" />
	</form>
	<form class="fudong"
		action="<%=basePath%>user/user_getProsBy2?user.id=${user.id }"
		method="get">
		<input type="submit" class="button long2 ok" value="公共项目" />
	</form>
	<form class="fudong"
		action="<%=basePath%>user/user_getProsBy3?user.id=${user.id }"
		method="get">
		<input type="submit" class="button long2 ok" value="特色项目" />
	</form>
	<br />
	<br />
	<br />
	<div class="title">
		<h2>项目完成情况总览</h2>
	</div>
	<br>
	<div class="main">
		<p style="color: red;font-size: 20px;">总体进展</p>
	</div>
	<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
	<div id="main" style="height:600px;width: 650px" class="fudong"></div>
	<div class="fudong2"
		style="border: 4px solid #ECF5FA;height: 600px;width:450px;margin-top: -75px ">
		<div
			style="border: 4px solid #E4E4E4;height: 300px;width:450px;box-sizing: border-box;">
			<ul>
				<li><label style="font-size: 20px;font-family:Arial ">通知公告</label>
					<a style="font-size: 20px;font-family:Arial;float: right "
					href="<%=basePath%>cg/cg_wenjianlist?id=404">更多&nbsp;</a></li>
				<hr />
				<s:iterator value="#request.wenjianList" var="wjlist" status="wj">
					<li style="line-height:120%;font-family:宋体;">·<a style="font-size: 15px"
						href="<%=basePath%>cg/cg_wenjianshow?id=<s:property
								value="#wjlist.wenjian_id" />&idd=1"><s:property
								value="#wjlist.wenjian_name" /></a><span style="font-size: 12px">&nbsp;&nbsp;（<s:property value="#wjlist.create_time" />）</span></li><br />
				</s:iterator>
			</ul>
		</div>

		<div
			style="border: 4px solid #E4E4E4;height: 300px;width:450px;box-sizing: border-box;">
			<ul>
				<li><label style="font-size: 20px;font-family:Arial ">文件下载</label>
					<a style="font-size: 20px;font-family:Arial;float: right "
					href="<%=basePath%>cg/cg_wenjianlist?id=405">更多&nbsp;</a></li>
				<hr />
				<s:iterator value="#request.wjFileList" var="wjlist" status="wj">
					<li style="line-height:250%;font-family:宋体;">·<a style="font-size: 15px"
						href="<%=basePath%>cg/cg_wenjianshow?id=<s:property
								value="#wjlist.wenjian_id" />&idd=1"><s:property
								value="#wjlist.wenjian_name" /></a><span style="font-size: 12px">&nbsp;&nbsp;（<s:property value="#wjlist.create_time" />）</span></li>
				</s:iterator>
			</ul>
		</div>
	</div>
	<!-- ECharts单文件引入 -->
	<script src="http://echarts.baidu.com/build/dist/echarts.js">
	</script>
	<script type="text/javascript">
		// 路径配置
		require.config({
			paths : {
				echarts : 'http://echarts.baidu.com/build/dist'
			}
		});
	
		// 使用
		require(
			[
				'echarts',
				'echarts/chart/bar' // 使用柱状图就加载bar模块，按需加载
			],
			function(ec) {
				// 基于准备好的dom，初始化echarts图表
				var myChart = ec.init(document.getElementById('main'));
	
				var option = {
					tooltip : {
						show : true
					},
					legend : {
						data : [ '' ]
					},
					
					grid: {  
						show:true,
						left: '90%',  
						bottom:'95%'
					}, 

					xAxis : [
						{
							type : 'type',
						//	date : ['0%','20%','40%','60%','80%','100%'],
							nameGap:25,
							axisLabel : {
								show : true,
								interval : 'auto',
								formatter :'{value}',
							},
							show : true
						}
					],
					yAxis : [
						{
						axisLabel: {
                                           interval:0,
                                           rotate:60
                                        },
							type : 'category',
							data : [ "${p15.name}", "${p14.name}", "${p13.name}", "${p12.name}", "${p11.name}", "${p10.name}", "${p9.name}", "${p8.name}", "${p7.name}", "${p6.name}", "${p5.name}", "${p4.name}", "${p3.name}", "${p2.name}", "${p1.name}"]
						}
	
					],
					series : [
						{
							name : "完成比",
							type : "bar",
							data : [ ${p15.finishratio}, ${p14.finishratio}, ${p13.finishratio}, ${p12.finishratio}, ${p11.finishratio}, ${p10.finishratio}, ${p9.finishratio}, ${p8.finishratio}, ${p7.finishratio}, ${p6.finishratio}, ${p5.finishratio}, ${p4.finishratio}, ${p3.finishratio}, ${p2.finishratio}, ${p1.finishratio} ],
					//		itemStyle: {  normal: {   label: {   show: true,   position: 'top', formatter: '{b}\n{c}%' }}}
						}
					]
				};
	
				// 为echarts对象加载数据 
				myChart.setOption(option);
			}
		);
	</script>
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
