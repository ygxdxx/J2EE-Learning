<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Cortana
  Date: 2017/6/1
  Time: 21:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>获取Cookie</h1>
    <%
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                out.print(cookie.getName() + "=" + cookie.getValue() + "<br/>");
            }
        }
    %>
</body>
</html>
