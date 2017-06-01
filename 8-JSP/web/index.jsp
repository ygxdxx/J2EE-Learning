<%--
  Created by IntelliJ IDEA.
  User: Cortana
  Date: 2017/5/31
  Time: 22:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath(); //name of project
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<html>
<head>
    <base href="<%=basePath%>">
    <title>$Title$</title>
</head>
<body>
   <%-- <%!
        int a = 3;

        public void func() {
            System.out.println("测试");
        }
    %>
    <%
        System.out.println(a++);
        func();
    %>
    <%=a%>--%>
</body>
</html>
