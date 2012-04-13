<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="/WEB-INF/tld/c.tld" %>
<html>
<head>
</head>
<body>
<div>

	<form action="/project/member/${projectMember.id }" method="post">
		<input type="hidden" value="${projectMember.id }" name="pm.id"> 
		<input type="hidden" value="${projectMember.projectId }" name="pm.projectId"> 
		<label>成员：</label>
		<select name="pm.memberId" >
			<c:forEach items="${memberList}" var="member" varStatus="status">
				<option value="${member.id }" ${member.id== projectMember.memberId ?"selected=\"selected\"":"" }  >${member.name }</option>
			</c:forEach>
		</select>
		<label>类型：</label>
		<select name="pm.type" >
			<option value="1" ${projectMember.type==1 ?"selected=\"selected\"":"" }>项目成员</option>
			<option value="2" ${projectMember.type==2 ?"selected=\"selected\"":"" }>项目组长</option>
		</select>
		<label>责职：</label>
		<textarea rows="4" cols="20" name="pm.job" >${projectMember.job }</textarea>
		<input type="submit" value="提交" >
	</form>


</div>
</body>
</html>