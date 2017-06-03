<%--
  Created by IntelliJ IDEA.
  User: Cortana
  Date: 2017/6/2
  Time: 13:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
    <%
        String username = "";
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("username")) {
                username = cookie.getValue();
            }
        }
    %>
    <%
        String message = "";
        if (request.getAttribute("msg") != null) {
            message = (String) request.getAttribute("msg");
        }
    %>
    <font color="red"><%=message%></font>
    <form method="post" action="/test8/LoginServlet">
        <span>用户名:</span><input type="text" name="username" value="<%=username%>"><br/>
        <span>密码:</span><input type="text" name="password"><br/>
        <input type="submit">
    </form>
</body>
</html>
