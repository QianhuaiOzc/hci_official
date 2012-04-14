<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="/WEB-INF/tld/c.tld"%>
<html>
<head>
</head>
<body>
	<div>
		<div>
			<table border="1">
				<tr>
					<td>头像</td>
					<td>帐号</td>
					<td>姓名</td>
					<td>项目</td>
					<td>详细信息</td>
					<td>退出</td>
				</tr>
				<c:forEach items="${obj.list}" var="member" varStatus="status">
					<tr>
						<td><img src="/member/avatar/${member.studentId }?thumb=true"
							alt=""></td>
						<td>${member.studentId}</td>
						<td>${member.name}</td>
						<td><a href="javascript:void(0);">项目</a></td>
						<td><a href="/member/edit/${member.id}">详细信息</a></td>
						<td><a href="/member/delete/${member.id}">退出</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>