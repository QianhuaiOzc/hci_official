<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="/WEB-INF/tld/c.tld" %>
<html>
<head>
</head>
<body>
<div>

	<form action="/project/member/0" method="post">
		<input type="hidden" value="${projectId }" name="pm.projectId"> 
		<label>成员：</label>
		<select name="pm.memberId" >
			<c:forEach items="${memberList}" var="member" varStatus="status">
				<option value="${member.id }">${member.name }</option>
			</c:forEach>
		</select>
		<label>类型：</label>
		<select name="pm.type" >
			<option value="1" >项目成员</option>
			<option value="2" >项目组长</option>
		</select>
		<label>责职：</label>
		<textarea rows="4" cols="20" name="pm.job" ></textarea>
		<input type="submit" value="提交" >
	</form>

</div>
</body>
</html>