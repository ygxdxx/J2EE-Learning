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
    <title>成功页面1</title>
</head>
<body>
    <%
        String username = (String) session.getAttribute("username");
        if (username == null) {
            request.setAttribute("msg", "用户未登录");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/session2/login.jsp");
            dispatcher.forward(request, response);
            return;
        }
    %>
    <span>用户<%=username%>欢迎登录~!</span>
</body>
</html>
