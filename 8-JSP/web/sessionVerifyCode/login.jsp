<%--
  Created by IntelliJ IDEA.
  User: Cortana
  Date: 2017/6/3
  Time: 21:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
    <form action="/test8/LoginServlet" method="post">
        <span>用户名：</span><input type="text" name="username"><br/>
        <span>密码：</span><input type="password" name="password"><br/>
        <span>验证码：</span><input type="text" name="verifyCode"><br/>
        <img src="/test8/VerifyCodeServlet" alt=""><br/>
        <input type="submit">
    </form>
</body>
</html>
