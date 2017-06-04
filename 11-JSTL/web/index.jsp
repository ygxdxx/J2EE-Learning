<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>

    ${value}

    <c:out value="${value}"/>

    <c:set var="key" value="" scope="session"/>

    <c:remove var="key" scope="session"/>

    <c:url value="">
        <c:param name="key" value="value"/>
    </c:url>
</body>
</html>
