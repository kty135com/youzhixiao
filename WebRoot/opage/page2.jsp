<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Document</title>
<link rel="stylesheet" href="<%=basePath%>css/page2.css" type="text/css">
<link href="<%=basePath%>css/page1.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="<%=basePath%>css/info-reg.css" />
<link rel="stylesheet" href="<%=basePath%>css/base.css" />
</head>
<body>
	<br>
	<form action="javascript:history.back(-1);" method="get">
		<input type="submit" class="button long2 ok" value="返回上一页" />
	</form>
	<br>

	<div>
		<div class="header">
			项目
			<s:property value="project3.no" />
			<s:property value="project3.name" />
		</div>

		<div class="main clearfix">


			<div class="main-left">
				<p class="text-center">项目基本信息</p>
				<p class="font4">当前进度</p>

				<div id="demo" class="jindutiao"
					style="background-position:-${p3s.jindu}px 0px;">
					<s:property value="p3s.bili" />
				</div>

				&nbsp;
				<table class="table">
					<tr>
						<td class="td">
							<p class="font">一级项目:</p>
						</td>
						<td class="td"><s:property value="project1.name" /></td>
					</tr>
					<tr>
						<td class="td">
							<p class="font">二级项目:</p>
						</td>
						<td class="td"><s:property value="project2.name" /></td>
					</tr>
					<tr>
						<td class="td">
							<p class="font">三级项目:</p>
						</td>
						<td class="td"><s:property value="p3s.p3.name" /></td>
					</tr>
					<tr>
						<td class="td">
							<p class="font2">完成数/总数:</p>
						</td>
						<td class="td"><s:property value="p3s.p3Fenzi" /> / <s:property
								value="p3s.p3Fenmu" /></td>
					</tr>
					<tr>
						<td class="td">
							<p class="font2">负责人:</p>
						</td>
						<td class="td"><s:property value="p3s.p3.user" /></td>
					</tr>
					<tr>
						<td class="td">
							<p class="font2">资金预算:</p>
						</td>
						<td class="td"><s:property value="p3s.p3.money" /></td>
					</tr>
					<tr>
						<td class="td">
							<p class="font2">资金完成数:</p>
						</td>
						<td class="td"><s:property value="money" /></td>
					</tr>
				</table>
				<!--以上放到表格中-->

				<p class="font3">建设目标(2018)</p>

				<!--	<d class="box">-->
				<div class="boxs">
					<s:property value="task1.name" />
				</div>

				<!--	</p>-->

				<p class="font3">建设目标(2019)</p>

				<!--	<p class="box">-->

				<div class="boxs">
					<s:property value="task2.name" />
				</div>
				<!--		</p>-->
			</div>


			<s:iterator value="watchList" var="ws" status="p2t">
				<div class="main-right">

					<div class="main-right-item" style="margin-bottom:15px;">
						<div class="item-row">
							<div class="col">
								要点编号：
								<s:property value="#ws.no" />
							</div>
							<div class="col"
								style="text-align: center;border-right: 1px solid #000000;
            border-left:1px solid #000000;">
								<!-- <s:property value="#ws.name" /> -->
							</div>
							<div class="col" style="text-align: right;"
								style="background-color:#CDE3FC">
								是否完成：
								<s:if test="#ws.column2==1"> 是
 </s:if>
								<s:if test="#ws.column2==0">否</s:if>
							</div>
						</div>
						<div class="item-row">
							<div style="float: left" class="font5"
								style="background-color:#DFDFDF">
								计划投入/完成投入:
								<s:if test="#ws.money!=null">
									<s:property value="#ws.money" />
								</s:if>
								<s:if test="#ws.money==null">N</s:if>
								/
								<s:if test="#ws.realMoney!=null">
									<s:property value="#ws.realMoney" />
								</s:if>
								<s:if test="#ws.realMoney==null">N</s:if>
							</div>
							<div style="float: right" class="font5"
								style="background-color:#FFFFBD">
								计划完成时间:
								<s:property value="#ws.plan_time" />
							</div>


						</div>
						<div class="item-row" style="background-color:#C8EAD7">
							要点责任人:
							<s:if test="#ws.column!=null">
								<s:property value="#ws.column" />;</s:if>
							<s:if test="#ws.column3!=null">
								<s:property value="#ws.column3" />;</s:if>
							<s:if test="#ws.column4!=null">
								<s:property value="#ws.column4" />;</s:if>
							<s:if test="#ws.column5!=null">
								<s:property value="#ws.column5" />;</s:if>
							<s:if test="#ws.column6!=null">
								<s:property value="#ws.column6" />;</s:if>
						</div>

						<div class="hezi2" style="background-color:#FFFBEE">
							观测点内容:
							<s:property value="#ws.name" />
						</div>
						<div class="hezi">
							<hr
								style=" height:2px;border:none;border-top:2px dotted #185598;" />
							<div class="doublehezi">
								<ul class="main-item-list">
									<li><s:if
											test="files.name1!=null && !files.name1.isEmpty()">
											<s:property value="files.tname1" />
											<a
												href="<%=basePath%>file/file_down?fileName=<s:property value="files.name1"/>&file.path=<s:property value="files.path1"/>">下载</a>
											<a
												href="<%=basePath%>file/file_look?file.id=<s:property value="files.fileId1"/>&fileName=<s:property value="files.name1"/>">查看</a>
										</s:if></li>
									<li><s:if test="files.name2!=null&&!files.name2.isEmpty()">
											<s:property value="files.tname2" />
											<a
												href="<%=basePath%>file/file_down?fileName=<s:property value="files.name2"/>&file.path=<s:property value="files.path2"/>">下载</a>
											<a
												href="<%=basePath%>file/file_look?file.id=<s:property value="files.fileId2"/>&fileName=<s:property value="files.name2"/>">查看</a>
										</s:if></li>
									<li><s:if test="files.name3!=null&&!files.name3.isEmpty()">
											<s:property value="files.tname3" />
											<a
												href="<%=basePath%>file/file_down?fileName=<s:property value="files.name3"/>&file.path=<s:property value="files.path3"/>">下载</a>
											<a
												href="<%=basePath%>file/file_look?file.id=<s:property value="files.fileId3"/>&fileName=<s:property value="files.name3"/>">查看</a>
										</s:if></li>
									<li><s:if test="files.name4!=null&&!files.name4.isEmpty()">
											<s:property value="files.tname4" />
											<a
												href="<%=basePath%>file/file_down?fileName=<s:property value="files.name4"/>&file.path=<s:property value="files.path4"/>">下载</a>
											<a
												href="<%=basePath%>file/file_look?file.id=<s:property value="files.fileId4"/>&fileName=<s:property value="files.name4"/>">查看</a>
										</s:if></li>
									<li><s:if test="files.name5!=null&&!files.name5.isEmpty()">
											<s:property value="files.tname5" />
											<a
												href="<%=basePath%>file/file_down?fileName=<s:property value="files.name5"/>&file.path=<s:property value="files.path5"/>">下载</a>
											<a
												href="<%=basePath%>file/file_look?file.id=<s:property value="files.fileId5"/>&fileName=<s:property value="files.name5"/>">查看</a>
										</s:if></li>
									<li><s:if test="files.name6!=null&&!files.name6.isEmpty()">
											<s:property value="files.tname6" />
											<a
												href="<%=basePath%>file/file_down?fileName=<s:property value="files.name6"/>&file.path=<s:property value="files.path6"/>"></a>
											<a
												href="<%=basePath%>file/file_look?file.id=<s:property value="files.fileId6"/>&fileName=<s:property value="files.name6"/>">查看</a>
										</s:if></li>
								</ul>
							</div>
							<div class="doublehezi">

								<ul class="main-item-list">
									<li><s:if
											test="files.scheName1!=null && !files.scheName1.isEmpty()">
											<s:property value="files.scheRName1" />
											<a
												href="<%=basePath%>file/file_down?fileName=<s:property value="files.scheName1"/>&file.path=<s:property value="files.schePath1"/>">下载</a>
											<a
												href="<%=basePath%>file/file_look?file.id=<s:property value="files.scheId1"/>&fileName=<s:property value="files.scheName1"/>&warn=9">查看</a>
										</s:if></li>
									<li><s:if
											test="files.scheName2!=null&&!files.scheName2.isEmpty()">
											<s:property value="files.scheRName2" />
											<a
												href="<%=basePath%>file/file_down?fileName=<s:property value="files.scheName2"/>&file.path=<s:property value="files.schePath2"/>">下载</a>
											<a
												href="<%=basePath%>file/file_look?file.id=<s:property value="files.scheId2"/>&fileName=<s:property value="files.scheName2"/>&warn=9">查看</a>
										</s:if></li>
									<li><s:if
											test="files.scheName3!=null&&!files.scheName3.isEmpty()">
											<s:property value="files.scheRName3" />
											<a
												href="<%=basePath%>file/file_down?fileName=<s:property value="files.scheName3"/>&file.path=<s:property value="files.schePath3"/>">下载</a>
											<a
												href="<%=basePath%>file/file_look?file.id=<s:property value="files.scheId3"/>&fileName=<s:property value="files.scheName3"/>&warn=9">查看</a>
										</s:if></li>
									<li><s:if
											test="files.scheName4!=null&&!files.scheName4.isEmpty()">
											<s:property value="files.scheRName4" />
											<a
												href="<%=basePath%>file/file_down?fileName=<s:property value="files.scheName4"/>&file.path=<s:property value="files.schePath4"/>">下载</a>
											<a
												href="<%=basePath%>file/file_look?file.id=<s:property value="files.scheId4"/>&fileName=<s:property value="files.scheName4"/>&warn=9">查看</a>
										</s:if></li>
									<li><s:if
											test="files.scheName5!=null&&!files.scheName5.isEmpty()">
											<s:property value="files.scheRName5" />
											<a
												href="<%=basePath%>file/file_down?fileName=<s:property value="files.scheName5"/>&file.path=<s:property value="files.schePath5"/>">下载</a>
											<a
												href="<%=basePath%>file/file_look?file.id=<s:property value="files.scheId5"/>&fileName=<s:property value="files.scheName5"/>&warn=9">查看</a>
										</s:if></li>
									<li><s:if
											test="files.scheName6!=null&&!files.scheName6.isEmpty()">
											<s:property value="files.scheRName6" />
											<a
												href="<%=basePath%>file/file_down?fileName=<s:property value="files.scheName6"/>&file.path=<s:property value="files.schePath6"/>"></a>
											<a
												href="<%=basePath%>file/file_look?file.id=<s:property value="files.scheId6"/>&fileName=<s:property value="files.scheName6"/>&warn=9">查看</a>
										</s:if></li>
								</ul>

							</div>
						</div>
					</div>
				</div>
			</s:iterator>

		</div>
		</td>
		</tr>
		</table>
	</div>
</body>
</html>