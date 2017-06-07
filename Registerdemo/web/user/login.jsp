<%--
  Created by IntelliJ IDEA.
  User: Cortana
  Date: 2017/6/7
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}+/LoginServlet" method="post">
        <span>用户名：</span><input type="text" name="username">
        <span>密码：</span><input type="password" name="password">
        <input type="submit" value="提交">
    </form>
</body>
</html>
