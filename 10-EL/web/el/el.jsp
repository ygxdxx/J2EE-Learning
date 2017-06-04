<%--
  Created by IntelliJ IDEA.
  User: Cortana
  Date: 2017/6/4
  Time: 21:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.test.el.*" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        Address address = new Address();
        address.setCity("北京");
        address.setStreet("昌平");

        User user = new User();
        user.setName("小明");
        user.setSalary(5000);
        user.setAddress(address);

        request.setAttribute("user", user);
    %>
    <h1>获取域内容</h1>
    ${requestScope.user.address.city}
</body>
</html>
