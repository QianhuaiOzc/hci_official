<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="/WEB-INF/tld/c.tld" %>

<body>
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
	 <td><img src="/member/avatar/${member.studentId }?thumb=true" alt="" ></td>
	 <td>${member.studentId}</td>
	 <td>${member.name}</td>
	 <td><a href="/member/projects/${member.id}" >项目</a></td>
	 <td><a href="/member/edit/${member.id}" >详细信息</a></td>
	 <td><a href="/member/delete/${member.id}" >退出</a></td>
	 </tr>
	 </c:forEach>

</table>


</div>

<div class="last-menu">
        <span >共${obj.count}条纪录，当前第${obj.page}页，每页${obj.size}条纪录</span>
        <c:if test="${obj.page!=1}">
            <span>首页</span>
        </c:if>
        <c:if test="${obj.page>1}">
                <input type="hidden" value="${obj.page-1}">
                <span>上一页</span>
        </c:if>
        <c:if test="${obj.count/obj.size>obj.page}">
                <input type="hidden" value="${obj.page+1}">
                <span>下一页</span>
        </c:if>
        <c:if test="${obj.pager.count/obj.size>=1}">
            <input type="hidden" value="${obj.pager.count/obj.size+1}">
            <span>尾页</span>
        </c:if>
        <span>转到第</span>
        <span><input id="go_page" name="page" type="text" size="5" /></span>页
        <input id="go_page_button" type="button" size="5" value="跳转" />
 </div>
</body>
</html>