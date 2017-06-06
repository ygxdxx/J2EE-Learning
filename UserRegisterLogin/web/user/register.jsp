<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
    <%-- <c:url value="/RegisterServlet"/> --%>
    <h1>${requestScope.errMsg}</h1>

    <form action="${pageContext.request.contextPath}/RegisterServlet" method="post">
        <span>用户名：</span><input type="text" name="username"><br/>
        <span>密码：</span><input type="password" name="password"><br/>
        <input type="submit" value="注册">
    </form>
</body>
</html>
