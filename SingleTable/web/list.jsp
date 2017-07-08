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

        <c:forEach items="${requestScope.pageBean.beanList}" var="cstm">
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
        <span>第${requestScope.pageBean.pc}页/共${requestScope.pageBean.tp}页</span>
        <a href="<c:url value="/CustomerServlet?method=findAll&pc=1"/>">首页</a>
        <c:if test="${requestScope.pageBean.pc >1}">
            <a href="<c:url value="/CustomerServlet?method=findAll&pc=${requestScope.pageBean.pc-1}"/>">上一页</a>
        </c:if>
        <c:if test="${requestScope.pageBean.pc < requestScope.pageBean.tp}">
            <a href="<c:url value="/CustomerServlet?method=findAll&pc=${requestScope.pageBean.pc+1}"/>">下一页</a>
        </c:if>
        <a href="<c:url value="/CustomerServlet?method=findAll&pc=${requestScope.pageBean.tp}"/>">尾页</a>
    </div>
</body>
</html>
