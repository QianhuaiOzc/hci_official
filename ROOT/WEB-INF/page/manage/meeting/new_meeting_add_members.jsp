<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>All Members</h1>
	<hr />
	<form action="/meeting/new/members" method="post">
		<table>
			<c:forEach items="${obj.members }" var="member">
				<tr>
					<td><input type="checkbox" name="membersId" value="${member.id }" /></td>
					<td>${member.name }</td>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="完成" />
	</form>
</body>
</html>	