<%--
  Created by IntelliJ IDEA.
  User: Cortana
  Date: 2017/6/3
  Time: 00:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        String username = "";
        if (session.getAttribute("username") != null) {
            username = (String) session.getAttribute("username");
        } else {
            request.setAttribute("msg", "请重新登录");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/testSession3/login.jsp");
            dispatcher.forward(request, response);
        }
    %>
    <h1>欢迎<%=username%>
    </h1>
</body>
</html>
