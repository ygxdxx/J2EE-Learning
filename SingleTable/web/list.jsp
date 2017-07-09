<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>客户列表</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
</head>

<body>
    <h3 align="center">客户列表</h3>
    <table border="1" width="70%" align="center">
        <tr>
            <th>客户姓名</th>
            <th>性别</th>
            <th>生日</th>
            <th>手机</th>
            <th>邮箱</th>
            <th>描述</th>
            <th>操作</th>
        </tr>

        <c:forEach items="${pageBean.beanList}" var="cstm">
            <tr>
                <td>${cstm.cname }</td>
                <td>${cstm.gender }</td>
                <td>${cstm.birthday }</td>
                <td>${cstm.cellphone }</td>
                <td>${cstm.email }</td>
                <td>${cstm.description }</td>
                <td>
                    <a href="<c:url value='/CustomerServlet?method=preEdit&cid=${cstm.cid }'/>">编辑</a>
                    <a href="<c:url value='/CustomerServlet?method=delete&cid=${cstm.cid }'/>">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>

    <div style="text-align: center;">
        <span>第${pageBean.pc}页/共${pageBean.tp}页</span>
        <a href="${pageBean.url}&pc=1">首页</a>
        <c:if test="${pageBean.pc >1}">
            <a href="<c:url value="${pageBean.url}&pc=${pageBean.pc-1}"/>">上一页</a>
        </c:if>

        <%--页码列表--%>
        <c:choose>
            <%-- 页数小于10 --%>
            <c:when test="${pageBean.tp<=10}">
                <c:set var="begin" value="1"/>
                <c:set var="end" value="${pageBean.tp}"/>
            </c:when>
            <c:otherwise>
                <%-- 页数大于10 --%>
                <c:set var="begin" value="${pageBean.pc-5}"/>
                <c:set var="end" value="${pageBean.pc+4}"/>
                <%--头溢出--%>
                <c:if test="${begin < 1}">
                    <c:set var="begin" value="1"/>
                    <c:set var="end" value="10"/>
                </c:if>
                <%--尾溢出--%>
                <c:if test="${end > pageBean.tp}">
                    <c:set var="begin" value="${pageBean.tp-9}"/>
                    <c:set var="end" value="${pageBean.tp}"/>
                </c:if>
            </c:otherwise>
        </c:choose>

        <c:forEach var="i" begin="${begin}" end="${end}">
            <c:choose>
                <c:when test="${i eq pageBean.pc}">
                    <span>${i}</span>
                </c:when>
                <c:otherwise>
                    <a href="<c:url value='${pageBean.url}&pc=${i}'/>">${i }</a>
                </c:otherwise>
            </c:choose>
        </c:forEach>

        <c:if test="${pageBean.pc < pageBean.tp}">
            <a href="<c:url value="${pageBean.url}&pc=${pageBean.pc+1}"/>">下一页</a>
        </c:if>
        <a href="<c:url value="${pageBean.url}&pc=${pageBean.tp}"/>">尾页</a>
    </div>
</body>
</html>
