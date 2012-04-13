<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="/WEB-INF/tld/c.tld" %>
<html>
<head>
</head>
<body>
<div>

<div>
	<p>项目组长</p>
	<table border="1">
	<tr>
		<td>姓名</td>
		<td>责职</td>
		<td>编辑</td>
		<td>删除</td>
	</tr>
	<c:forEach items="${obj.leaderList}" var="pm" varStatus="status">
	<tr>
		<td>${pm.member.name }</td>
		<td>${pm.job }</td>
		<td><a href="/project/member/edit/${pm.id}" >编辑</a></td>
		<td><a href="/project/member/remove/${pm.id}" >删除</a></td>
	</tr>
	</c:forEach>
	</table>
	<p>项目成员</p>
	<table border="1">
	<tr>
		<td>姓名</td>
		<td>责职</td>
		<td>编辑</td>
		<td>删除</td>
	</tr>
	<c:forEach items="${obj.memberList}" var="pm" varStatus="status">
	<tr>
		<td>${pm.member.name }</td>
		<td>${pm.job }</td>
		<td><a href="/project/member/edit/${pm.id}" >编辑</a></td>
		<td><a href="/project/member/remove/${pm.id}" >删除</a></td>
	</tr>
	</c:forEach>
	</table>
	
	<a href="/project/member/add/${obj.projectId }" >添加</a>
	
</div>



</div>
</body>
</html>