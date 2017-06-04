<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.test.el.*" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        Address address = new Address();
        address.setCity("beijing");
        address.setStreet("street");

        User user = new User();
        user.setName("小明");
        user.setSalary(5000);
        user.setAddress(address);
    %>

    ${ requestScope.user.address.city }

    <c:out value="${value}"/>

    <c:set var="" value="" scope="session"/>

    <c:remove var="" scope="session"/>

    <c:url value="el.jsp">
        <c:param name="key" value="value"/>
    </c:url>
</body>
</html>
