<%--
  Created by IntelliJ IDEA.
  User: Cortana
  Date: 2017/6/1
  Time: 21:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>设置Cookie</h1>
    <%
        Cookie cookie1 = new Cookie("aaa", "AAA");
        cookie1.setMaxAge(0);
        response.addCookie(cookie1);

        Cookie cookie2 = new Cookie("bbb", "BBB");
        cookie2.setMaxAge(60 * 60);
        response.addCookie(cookie2);
    %>

</body>
</html>
