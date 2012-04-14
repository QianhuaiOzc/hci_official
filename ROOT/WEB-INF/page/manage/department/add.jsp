<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="/WEB-INF/tld/c.tld" %>
<head>

</head>

<body>
<div>
<form action="/department/0" method="post" id="">
<div >
<label>部门名：</label>
<input type="text" name="department.name" >
</div>

<div>
<label>部门简介：</label>
<textarea rows="4" cols="20" name="department.detail" ></textarea>
</div>

<div>
<input type="hidden" name="" value="" >
<input type="submit" value="提交" >
</div>

</form>

</div>

</body>
</html>