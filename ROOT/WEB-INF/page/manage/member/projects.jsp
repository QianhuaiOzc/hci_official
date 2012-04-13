<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="/WEB-INF/tld/c.tld" %>
<html>
<head>
</head>
<body>
<div>
<label>已完成项目：</label>
<table border="1">
	<tr>
		<td>项目名</td>
		<td>详细信息</td>
	</tr>
	<c:forEach items="${obj.finishedList}" var="project" varStatus="status">
	<tr>
		<td>${project.name }</td>
		<td><a href="/project/edit/${project.id}" >详细信息</a></td>
    </tr>
	</c:forEach>
</table>
<label>正在开发项目：</label>
<table border="1">
<tr>
		<td>项目名</td>
		<td>详细信息</td>
	</tr>
	<c:forEach items="${obj.developingList}" var="project" varStatus="status">
	<tr>
		<td>${project.name }</td>
		<td><a href="/project/edit/${project.id}" >详细信息</a></td>
    </tr>
	</c:forEach>

</table>


</div>
</body>
</html>