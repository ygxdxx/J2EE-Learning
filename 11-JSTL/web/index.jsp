<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
    <%--
     ${value}

     <c:out value="${value}"/>

     <c:set var="key" value="" scope="session"/>

     <c:remove var="key" scope="session"/>

     <c:url value="">
         <c:param name="key" value="value"/>
     </c:url>--%>

    <%--<c:set var="username" value="小明"/>
    <c:if test="${not empty pageScope.username}">
        <c:out value="${pageScope.username}"/>
    </c:if>--%>

    <c:set var="score" value="${param.score}"/>
    <c:choose>
        <c:when test="${score>100 || score<0}">分数错误：${score}</c:when>
        <c:when test="${score>90 && score<=100}">分数为优秀：${score}</c:when>
        <c:otherwise>分数不及格：${score}</c:otherwise>
    </c:choose>

    <c:set var="str" value="你的姓名为空"/>
    <c:if test="${empty param.name}">
        <c:out value="${str}"/>
    </c:if>

    <c:choose>
        <c:when test="${empty param.username}">
            <c:out value="${str}"/>
        </c:when>
        <c:otherwise>
            <c:out value="有了名字"/>
        </c:otherwise>
    </c:choose>

    <c:forEach var="i" begin="1" end="10">
        ${i}
    </c:forEach>

    <%
        String[] strings = {"one", "two"};
        request.setAttribute("strings",strings);

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("一");
        arrayList.add("二");
        arrayList.add("三");

        pageContext.setAttribute("list",arrayList);
    %>

    <c:forEach items="${strings}" var="str">
        ${str}<br/>
    </c:forEach>

    <c:forEach items="${list}" var="element" varStatus="status">
        ${element}
        ${status.index}
        ${status.count}
        <br/>
    </c:forEach>

</body>
</html>
