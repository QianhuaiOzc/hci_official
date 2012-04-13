<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="/WEB-INF/tld/c.tld" %>
<html>
<head>
</head>
<body>
<div>
<div>
<table border="1" >
	<tr>
		<td>图标</td>
		<td>项目名</td>
		<td>项目成员</td>
		<td>详细信息</td>
		<td>结题</td>
		<td>取消</td>
	</tr>
	 <c:forEach items="${obj.list}" var="project" varStatus="status">
	 <tr>
	 <td><img src="/project/avatar/${project.id }?thumb=true" alt="" ></td>
	 <td>${project.name}</td>
	 <td><a href="javascript:void(0);" >项目成员</a></td>
	 <td><a href="/project/edit/${project.id}" >详细信息</a></td>
	 <td><a href="/project/finish/${project.id}" >结题</a></td>
	 <td><a href="/project/delete/${project.id}" >取消</a></td>
	 </tr>
	 </c:forEach>

</table>


</div>
</div>
</body>
</html>