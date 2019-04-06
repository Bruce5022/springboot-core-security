<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>登陆页面</title>
</head>
<body>
<h1 style="color: blueviolet">登陆页面</h1>
<c:if test="${not empty param.error}">
    <font color="#8b0000">用户名或密码错误!</font>
</c:if>
<form action="${pageContext.request.contextPath}/userlogin" method="post">
    用户名:<input type="text" name="username"/><br/>
    姓名:<input type="password" name="password"/>
    <input type="submit" value="登陆"/>
</form>
</body>
</html>
