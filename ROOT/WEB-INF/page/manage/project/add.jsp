<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="/WEB-INF/tld/c.tld" %>
<head>

</head>

<body>
<div>
<form action="/project/0" method="post" id="">
<div >
<label>项目名：</label>
<input type="text" name="project.name" >
</div>

<div>
<select name="project.departmentId">
	<option value="0">请选择部门</option>
	<c:forEach items="${departmentList}" var="department">
	<option value="${department.id}">${department.name}</option>
	</c:forEach>
</select>
</div>

<div>
<label>简介：</label>
<textarea rows="4" cols="20" name="project.detail" ></textarea>
</div>

<div>
<input type="hidden" name="" value="" >
<input type="submit" value="提交" >
</div>

</form>

</div>

</body>
</html>