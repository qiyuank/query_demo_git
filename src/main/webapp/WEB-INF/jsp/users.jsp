<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>用户列表</title>
    <style>
        body { margin: 0; background: #f4f6fa; color: #203047; font-family: system-ui, sans-serif; }
        main { max-width: 48rem; margin: 3rem auto; padding: 0 1rem; }
        table { width: 100%; border-collapse: collapse; background: white; }
        th, td { text-align: left; padding: .8rem 1rem; border-bottom: 1px solid #dae1eb; overflow-wrap: anywhere; }
        th { background: #e6edf6; }
    </style>
</head>
<body>
<main>
    <h1>用户列表</h1>
    <c:choose>
        <c:when test="${empty users}"><p>暂无用户。</p></c:when>
        <c:otherwise>
            <table aria-label="用户列表">
                <thead><tr><th scope="col">用户 ID</th><th scope="col">姓名</th></tr></thead>
                <tbody>
                <c:forEach items="${users}" var="user">
                    <tr><td><c:out value="${user.id}"/></td><td><c:out value="${user.name}"/></td></tr>
                </c:forEach>
                </tbody>
            </table>
            <nav aria-label="用户列表分页">
                <p>共 ${userPage.total} 位用户 · 第 ${userPage.current} / ${userPage.pages} 页</p>
                <c:if test="${userPage.current gt 1}">
                    <c:url var="prevUrl" value="/users"><c:param name="page" value="${userPage.current - 1}"/></c:url>
                    <a href="${prevUrl}" rel="prev">上一页</a>
                </c:if>
                <c:if test="${userPage.current lt userPage.pages}">
                    <c:url var="nextUrl" value="/users"><c:param name="page" value="${userPage.current + 1}"/></c:url>
                    <a href="${nextUrl}" rel="next">下一页</a>
                </c:if>
            </nav>
        </c:otherwise>
    </c:choose>
</main>
</body>
</html>
