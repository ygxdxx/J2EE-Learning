<%--
  Created by IntelliJ IDEA.
  User: Cortana
  Date: 2017/6/4
  Time: 13:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>成功页面</title>
</head>
<body>
    <%
        String username;
        if (session.getAttribute("username") != null) {
            username = (String) session.getAttribute("username");
        } else {
            request.setAttribute("msg", "请重新登录");
            request.getRequestDispatcher("/login/login.jsp").forward(request, response);
            return;
        }
    %>
    <h1>
        欢迎<%=username%>登录
    </h1>
</body>
</html>
