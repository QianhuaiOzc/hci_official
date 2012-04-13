<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="/WEB-INF/tld/c.tld" %>

<body>
<div>
<table border="1" >
	<tr>
		<td>部门名</td>
		<td>部门成员</td>
		<td>部门项目</td>
		<td>详细信息</td>
		<td>删除</td>
	</tr>
	 <c:forEach items="${obj.list}" var="department" varStatus="status">
	 <tr>
	 <td>${department.name}</td>
	 <td><a href="/department/members/${department.id}" >成员</a></td>
	 <td><a href="/department/projects/${department.id}/1" >项目</a></td>
	 <td><a href="/department/edit/${department.id}" >详细信息</a></td>
	 <td><a href="javascript:void(0);" >删除</a></td>
	 </tr>
	 </c:forEach>

</table>


</div>
</body>
</html>