<!--


优质校项目管理系统呈现界面模板
1.文件清单：
page1.html——HTML模板文件
page1.css —— CSS样式文件
bg.gif ——进度条所用图片素材


2.使用说明
使用三层循环可将全部项目循环列出。

第一层循环遍历显示一级项目，一级项目对应的最外层表格样式为 table_main

第二层循环遍历显示二级项目，对应表格样式为 rightmain


第三层循环遍历显示三级项目，应表格样式为 rightsub


三层表格的具体位置见代码中的注释。
-->

<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>优质校项目管理系统</title>
<link href="<%=basePath%>css/page1.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="<%=basePath%>css/info-reg.css" />
<link rel="stylesheet" href="<%=basePath%>css/base.css" />
<style>
/* 以修改*/
.fudong {
	float: left;
	padding-left: 2%;
}

.font1 {
	font-family: 微软雅黑;
	font-size: 22px;
	line-height: 24px;
}
</style>
</head>

<body>
	<div class="header">
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
	</div>
	<br />
	<br />
	<br />
	<h2 class="font1">项目完成情况总览(一、二、三级项目)</h2>
	<br />
	<s:if test="page == 1"><s:iterator value="#session.pr1sList" var="p1s" status="p2t">
	<!-- 一级项目循环从此处开始 ---->
		<table width="800" border="1" cellpadding="0" cellspacing="0"
			bordercolor="#0099FF" class="table_main" style="margin-bottom:30px;">
			<tr>
				<!--以下是责任人盒子以及黄颜色-->
				<td width="200" height="" align="center" valign="top"
					bgcolor="#EEF9BB">
					<!--height="63"-->
					<div class="main_left1">
						<font style="font-size:22px"><s:property
								value="#p1s.pro1.no" /></font> <br />
						<s:property value="#p1s.pro1.name" />
						<br /> 责任人：
						<s:property value="#p1s.pro1.user" />
						<br />
						<s:property value="#p1s.p1Fenzi" />
						/
						<s:property value="#p1s.p1Fenmu" />
						<div id="demo" class="jindutiao"
							style="background-position:-${p1s.jindu}px 0px;">
							<s:property value="#p1s.bili" />
						</div>
					</div>
				</td>
				<td align="center" valign="top" bgcolor="#FFFFFF"
					style="padding-bottom:10px;">
					<!--    对应的二级项目循环从此处   开始 --> <s:iterator value="pro2List"
						var="p2s" status="p2t">
						<table width="98%" border="1" cellpadding="0" cellspacing="0"
							bordercolor="#0099FF" class="rightmain">
							<tr>
								<td width="180" align="center" valign="top" bgcolor="#BFE7EA">
									<div class="main_left2">
										<s:property value="#p2s.pro2.no" />
										<s:property value="#p2s.pro2.name" />
										<br /> 责任人:
										<s:property value="#p2s.pro2.user" />
										<br /> <span class="main_left1"><s:property
												value="#p2s.p2fenzi" />/<s:property value="#p2s.p2fenmu" /></span>
										<div class="jindutiao"
											style="background-position:-${p2s.jindu}px 0px;">
											<s:property value="#p2s.bili" />
										</div>
									</div>
								</td>
								<td align="center" bgcolor="#FFFFFF" style="padding-bottom:5px;">
									<s:iterator value="pro3List" var="p3s" status="p2t">
										<!--  三级项目循环开始 --->
										<table width="98%" border="1" cellpadding="0" cellspacing="0"
											class="rightsub">
											<tr>
												<td width="50" height="52" align="center" valign="middle"
													class="subtag"><s:property value="#p3s.p3.no" /><br />
													<span><s:property value="#p3s.p3Fenzi" />/<s:property
															value="#p3s.p3Fenmu" /></span></td>
												<td bgcolor="#FFFFFF"><div class="content_01">
														<!-- 已完成content_01，进行中是content_02，未启动content_03 -->
														<a
															href="<%=basePath%>project3/project3_pro3Show?id=<s:property value="#p3s.p3.id"/>">
															<s:property value="#p3s.p3.name" />
														</a>
													</div></td>
											</tr>
										</table>
										<!--  三级项目循环结束 -->
									</s:iterator>
								</td>
							</tr>
						</table>
						<!--    二级项目循环结束  -->
					</s:iterator>
				</td>
			</tr>
		</table>
	</s:iterator>
	<!-- 一级项目循环结束 --></s:if>
	
	<s:if test="page == 2"><s:iterator value="#session.pr2sList" var="p1s" status="p2t">
	<!-- 一级项目循环从此处开始 ---->
		<table width="800" border="1" cellpadding="0" cellspacing="0"
			bordercolor="#0099FF" class="table_main" style="margin-bottom:30px;">
			<tr>
				<!--以下是责任人盒子以及黄颜色-->
				<td width="200" height="" align="center" valign="top"
					bgcolor="#EEF9BB">
					<!--height="63"-->
					<div class="main_left1">
						<font style="font-size:22px"><s:property
								value="#p1s.pro1.no" /></font> <br />
						<s:property value="#p1s.pro1.name" />
						<br /> 责任人：
						<s:property value="#p1s.pro1.user" />
						<br />
						<s:property value="#p1s.p1Fenzi" />
						/
						<s:property value="#p1s.p1Fenmu" />
						<div id="demo" class="jindutiao"
							style="background-position:-${p1s.jindu}px 0px;">
							<s:property value="#p1s.bili" />
						</div>
					</div>
				</td>
				<td align="center" valign="top" bgcolor="#FFFFFF"
					style="padding-bottom:10px;">
					<!--    对应的二级项目循环从此处   开始 --> <s:iterator value="pro2List"
						var="p2s" status="p2t">
						<table width="98%" border="1" cellpadding="0" cellspacing="0"
							bordercolor="#0099FF" class="rightmain">
							<tr>
								<td width="180" align="center" valign="top" bgcolor="#BFE7EA">
									<div class="main_left2">
										<s:property value="#p2s.pro2.no" />
										<s:property value="#p2s.pro2.name" />
										<br /> 责任人:
										<s:property value="#p2s.pro2.user" />
										<br /> <span class="main_left1"><s:property
												value="#p2s.p2fenzi" />/<s:property value="#p2s.p2fenmu" /></span>
										<div class="jindutiao"
											style="background-position:-${p2s.jindu}px 0px;">
											<s:property value="#p2s.bili" />
										</div>
									</div>
								</td>
								<td align="center" bgcolor="#FFFFFF" style="padding-bottom:5px;">
									<s:iterator value="pro3List" var="p3s" status="p2t">
										<!--  三级项目循环开始 --->
										<table width="98%" border="1" cellpadding="0" cellspacing="0"
											class="rightsub">
											<tr>
												<td width="50" height="52" align="center" valign="middle"
													class="subtag"><s:property value="#p3s.p3.no" /><br />
													<span><s:property value="#p3s.p3Fenzi" />/<s:property
															value="#p3s.p3Fenmu" /></span></td>
												<td bgcolor="#FFFFFF"><div class="content_01">
														<!-- 已完成content_01，进行中是content_02，未启动content_03 -->
														<a
															href="<%=basePath%>project3/project3_pro3Show?id=<s:property value="#p3s.p3.id"/>">
															<s:property value="#p3s.p3.name" />
														</a>
													</div></td>
											</tr>
										</table>
										<!--  三级项目循环结束 -->
									</s:iterator>
								</td>
							</tr>
						</table>
						<!--    二级项目循环结束  -->
					</s:iterator>
				</td>
			</tr>
		</table>
	</s:iterator>
	<!-- 一级项目循环结束 --></s:if>
	
	<s:if test="page == 3"><s:iterator value="#session.pr3sList" var="p1s" status="p2t">
	<!-- 一级项目循环从此处开始 ---->
		<table width="800" border="1" cellpadding="0" cellspacing="0"
			bordercolor="#0099FF" class="table_main" style="margin-bottom:30px;">
			<tr>
				<!--以下是责任人盒子以及黄颜色-->
				<td width="200" height="" align="center" valign="top"
					bgcolor="#EEF9BB">
					<!--height="63"-->
					<div class="main_left1">
						<font style="font-size:22px"><s:property
								value="#p1s.pro1.no" /></font> <br />
						<s:property value="#p1s.pro1.name" />
						<br /> 责任人：
						<s:property value="#p1s.pro1.user" />
						<br />
						<s:property value="#p1s.p1Fenzi" />
						/
						<s:property value="#p1s.p1Fenmu" />
						<div id="demo" class="jindutiao"
							style="background-position:-${p1s.jindu}px 0px;">
							<s:property value="#p1s.bili" />
						</div>
					</div>
				</td>
				<td align="center" valign="top" bgcolor="#FFFFFF"
					style="padding-bottom:10px;">
					<!--    对应的二级项目循环从此处   开始 --> <s:iterator value="pro2List"
						var="p2s" status="p2t">
						<table width="98%" border="1" cellpadding="0" cellspacing="0"
							bordercolor="#0099FF" class="rightmain">
							<tr>
								<td width="180" align="center" valign="top" bgcolor="#BFE7EA">
									<div class="main_left2">
										<s:property value="#p2s.pro2.no" />
										<s:property value="#p2s.pro2.name" />
										<br /> 责任人:
										<s:property value="#p2s.pro2.user" />
										<br /> <span class="main_left1"><s:property
												value="#p2s.p2fenzi" />/<s:property value="#p2s.p2fenmu" /></span>
										<div class="jindutiao"
											style="background-position:-${p2s.jindu}px 0px;">
											<s:property value="#p2s.bili" />
										</div>
									</div>
								</td>
								<td align="center" bgcolor="#FFFFFF" style="padding-bottom:5px;">
									<s:iterator value="pro3List" var="p3s" status="p2t">
										<!--  三级项目循环开始 --->
										<table width="98%" border="1" cellpadding="0" cellspacing="0"
											class="rightsub">
											<tr>
												<td width="50" height="52" align="center" valign="middle"
													class="subtag"><s:property value="#p3s.p3.no" /><br />
													<span><s:property value="#p3s.p3Fenzi" />/<s:property
															value="#p3s.p3Fenmu" /></span></td>
												<td bgcolor="#FFFFFF"><div class="content_01">
														<!-- 已完成content_01，进行中是content_02，未启动content_03 -->
														<a
															href="<%=basePath%>project3/project3_pro3Show?id=<s:property value="#p3s.p3.id"/>">
															<s:property value="#p3s.p3.name" />
														</a>
													</div></td>
											</tr>
										</table>
										<!--  三级项目循环结束 -->
									</s:iterator>
								</td>
							</tr>
						</table>
						<!--    二级项目循环结束  -->
					</s:iterator>
				</td>
			</tr>
		</table>
	</s:iterator>
	<!-- 一级项目循环结束 --></s:if>
	

	<!-- <p>已完成的三级项目为淡绿色底色，正在进行的为淡蓝色，0进度的为淡红色。对应的DIV样式表分别为 content_01
		、content_02、content_03</p> -->
</body>
</html>