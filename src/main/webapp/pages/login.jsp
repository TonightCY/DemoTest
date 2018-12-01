<%--
  Created by IntelliJ IDEA.
  User: 85181
  Date: 2018/11/7
  Time: 9:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="/easyui/include.jsp"%>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/login.js"></script>
</head>
<body>
    <div id="login-dialog">
        <form id="login-form" method="post">
            <table style="margin: 20px auto" cellspacing="10px">
                <tr>
                    <td>用户名</td>
                    <td><input type="text" id="username" name="username"></td>
                </tr>
                <tr>
                    <td>密码</td>
                    <td><input type="password" name="password" id="password"></td>
                </tr>
            </table>
        </form>
    </div>

<%--注册--%>
    <div id="register-dialog">

    </div>

</body>
</html>
