<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="<%=basePath%>css/base.css" />
<link rel="stylesheet" href="<%=basePath%>css/info-mgt.css" />
<link rel="stylesheet" href="<%=basePath%>css/WdatePicker.css" />
<title>待审核验收要点列表</title>
</head>

<body>
<div class="title"><h2>待审核验收要点列表</h2></div>
<div class="query">
<div class="table-box">
<form action="<%=basePath%>watch/watch_queryUnpend" method="post">
        <label>三级项目名称：</label>
        <input size="30" type="text" name="pro3.name"/>
        <div class="btn ue-clear">
        <input type="hidden" name="user.id" value="<s:property value="user.id"/>"/>
        <input type="submit" class="button long2 ok" value="查询" /> 
        </div>
</form>
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
           <s:iterator value="watchs" var="w" status="status">
        	<tr>
            	<td><s:property value="#status.index+1"/></td>
                <td ><s:property value="#w.no"/></td>
                <td ><s:property value="#w.name"/></td>
                <td ><s:property value="#w.plan_time"/></td>
                <td ><s:property value="#w.content"/></td>        
                <td class="table-operate ue-clear">          
                <a href="<%=basePath%>watch/watch_show?watch.id=<s:property value="#w.id"/>"class="add">查看</a>
                <a href="<%=basePath%>watch/watch_pend?watch.id=<s:property value="#w.id"/>&user.id=<s:property value="user.id"/>"class="edit">审核</a>       
                </td>
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
<script type="text/javascript" src="<%=basePath%>js/jquery.pagination.js"></script>
<script type="text/javascript">
$(".select-title").on("click",function(){
	$(".select-list").hide();
	$(this).siblings($(".select-list")).show();
	return false;
})
$(".select-list").on("click","li",function(){
	var txt = $(this).text();
	$(this).parent($(".select-list")).siblings($(".select-title")).find("span").text(txt);
})

$('.pagination').pagination(100,{
	callback: function(page){
		alert(page);	
	},
	display_msg: true,
	setPageNo: true
});

$("tbody").find("tr:odd").css("backgroundColor","#eff6fa");

showRemind('input[type=text], textarea','placeholder');
</script>
</html>
