<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>All Projects</h1>
	<hr />
	<form action="/meeting/new/projects" method="post">
		<table>
			<c:forEach items="${obj.projects }" var="project">
				<tr>
					<td><input type="checkbox" name="projectsId" value="${project.id }" /></td>
					<td>${project.name }</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="2"><input type="submit" value="下一步" /></td>
			</tr>
		</table>
	</form>
</body>
</html>