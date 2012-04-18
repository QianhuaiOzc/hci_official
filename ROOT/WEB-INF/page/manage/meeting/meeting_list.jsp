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
	<h1>Meeting List</h1>
	<hr />
	<table>
		<c:forEach items="${obj.meetings }" var="meeting">
			<tr>
				<td>${meeting.title }</td>
				<td>${meeting.date }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>