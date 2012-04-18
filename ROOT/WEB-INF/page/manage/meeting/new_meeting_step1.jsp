<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/meeting/new" method="post">
		<label for="title">主题</label>
		<input type="text" name="title" id="title" />
		<label for="date">时间</label>
		<input type="text" name="date" id="date" />
		<input type="submit" value="下一步" />
	</form>
</body>
</html>