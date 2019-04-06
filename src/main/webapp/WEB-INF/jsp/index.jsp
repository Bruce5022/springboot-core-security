<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
欢迎用户，${username}<br/>
以下是网站的功能：<br/>
<security:authorize access="hasAuthority('PER_ADD_PRODUCT')">
<a href="${pageContext.request.contextPath}/product/add">商品添加</a><br/>
</security:authorize>
<security:authorize access="hasAuthority('PER_UPDATE_PRODUCT')">
    <a href="${pageContext.request.contextPath}/product/update">商品修改</a><br/>
</security:authorize>
<security:authorize access="hasAuthority('PER_LIST_PRODUCT')">
    <a href="${pageContext.request.contextPath}/product/list">商品查询</a><br/>
</security:authorize>
<security:authorize access="hasAuthority('PER_DELETE_PRODUCT')">
    <a href="${pageContext.request.contextPath}/product/delete">商品删除</a><br/>
</security:authorize>
</body>
</html>
