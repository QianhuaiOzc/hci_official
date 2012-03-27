<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="/WEB-INF/tld/c.tld" %>

<body>


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