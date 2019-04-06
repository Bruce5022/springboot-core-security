<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆页面</title>
</head>
<body>
<h1 style="color: blueviolet">登陆页面</h1>
<form action="${pageContext.request.contextPath}/userlogin" method="post">
    用户名:<input type="text" name="username"/><br/>
    姓名:<input type="password" name="password"/>
    <input type="submit" value="登陆"/>
</form>
</body>
</html>
