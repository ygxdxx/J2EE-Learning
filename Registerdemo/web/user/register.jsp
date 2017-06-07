<%--
  Created by IntelliJ IDEA.
  User: Cortana
  Date: 2017/6/7
  Time: 12:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
    <h1 color="red">${requestScope.errMsg}</h1>
    <form action="${pageContext.request.contextPath}/RegisterServlet" method="post">
        <span>用户名：</span><input type="text" name="username" value="${requestScope.user.username}"><br>
        <span>密码：</span><input type="text" name="password" value="${requestScope.user.password}"><br>
        <span>验证码：</span><input type="text" name="verifyCode" value="${sessionScope.verifyCode}" size="5">
        <img src="/VerifyCodeServlet" alt="" id="verifyCode" onclick="changeImg()">
        <br>
        <input type="submit" value="注册">
    </form>
</body>
<script>
    function changeImg() {
        var img = document.getElementById("verifyCode");
        img.setAttribute("src", "/VerifyCodeServlet?time=" + new Date().getTime());
    }
</script>
</html>
