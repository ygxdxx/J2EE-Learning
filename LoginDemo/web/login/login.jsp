<%--
  Created by IntelliJ IDEA.
  User: Cortana
  Date: 2017/6/4
  Time: 13:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
    <%
        String sessionName = "";
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("usr")) {
                sessionName = cookie.getValue();
            }
        }
    %>
    <%
        String message = "";
        if (request.getAttribute("msg") != null) {
            message = (String) request.getAttribute("msg");
        }
    %>
    <font color="red">
        <%=message%>
    </font>
    <form action="/loginDemo/LoginServlet" method="post">
        <span>用户名：</span><input type="text" name="username" value="<%=sessionName%>"><br/>
        <span>密码：</span><input type="password" name="password"><br/>
        <span>验证码：</span><input type="text" name="verify_code">
        <img src="/loginDemo/VerifyServlet" alt="" id="verifyPic" onclick="changeVerifyPic()">
        <br/>
        <input type="submit">
    </form>
</body>
<script>
    function changeVerifyPic() {
        var picElement = document.getElementById("verifyPic");
        picElement.setAttribute("src", "/loginDemo/VerifyServlet?a=" + new Date().getTime());
    }
</script>
</html>
