<%--
  Created by IntelliJ IDEA.
  User: Cortana
  Date: 2017/6/1
  Time: 23:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>获取Session数据</h1>
    <%
        String str = (String) session.getAttribute("aaa");
    %>
    <%=str%>
</body>
</html>
