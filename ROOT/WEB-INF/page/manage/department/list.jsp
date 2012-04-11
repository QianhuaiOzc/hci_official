<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="/WEB-INF/tld/c.tld" %>

<body>
<div>
<table border="1" >
	<tr>
		<td>项目名</td>
		<td>详细信息</td>
	</tr>
	 <c:forEach items="${obj.list}" var="department" varStatus="status">
	 <tr>
	 <td>${department.name}</td>
	 <td><a href="/department/edit/${department.id}" >详细信息</a></td>
	 </tr>
	 </c:forEach>

</table>


</div>
</body>
</html>