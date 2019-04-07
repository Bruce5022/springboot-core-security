<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>登陆页面</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
</head>
<body>
<h1 style="color: blueviolet">登陆页面</h1>
<c:if test="${not empty param.error}">
    <font color="#8b0000">用户名或密码错误!</font>
</c:if>
<form id="loginForm" method="post">
    账号:<input type="text" name="username"/><br/>
    密码:<input type="password" name="password"/><br/>
    验证码:<input type="text" name="imageCode"/><img src="${pageContext.request.contextPath}/imageCode"><br/>
    记住我:<input type="checkbox" name="remember-me" value="true"><br/>
    <input type="button" id="loginBtn" value="登陆"/>
</form>
</body>
<script type="text/javascript">
    $(function(){
        $("#loginBtn").click(function(){
            $.post("${pageContext.request.contextPath}/userlogin",$("#loginForm").serialize(),function (data) {
                if(data.success){
                    window.location.href="${pageContext.request.contextPath}/product/index";
                }else{
                    alert("登录失败："+data.msg);
                }
            },"json");
        }) ;
    });
</script>
</html>
