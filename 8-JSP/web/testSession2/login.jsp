<%--
  Created by IntelliJ IDEA.
  User: Cortana
  Date: 2017/6/1
  Time: 23:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        String cookieName = "";
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("username".equals(cookie.getName())) {
                    cookieName = cookie.getValue();
                }
            }
        }
    %>
    <%
        String message = "";
        String msg = (String) request.getAttribute("msg");
        if (msg != null) {
            message = msg;
        }
    %>
    <font color="red"><%=message%></font>
    <h1>登录页面</h1>
    <form action="/test8/SessionServlet" method="post">
        <span>用户名：</span><input type="text" name="username" value="<%=cookieName%>"><br/>
        <span>密码：</span><input type="text" name="password" value=""><br/>
        <input type="submit">
    </form>
</body>
</html>
