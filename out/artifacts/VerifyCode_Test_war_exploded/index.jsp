<%--
  Created by IntelliJ IDEA.
  User: Gjl10
  Date: 2020/4/12
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>验证码小项目</title>
</head>
<body>
<%
    String msg = (String) request.getAttribute("msg");
    if (msg != null) {
        out.print(msg);
    }
%>

<form action="${pageContext.request.contextPath}/LoginServlet">
    <table>
        <tr>
            <td>用户名：</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="text" name="password"></td>
        </tr>
        <tr>
            <td>验证码：</td>
            <td><input type="text" name="verifycode" size="5"></td>
            <td><img src="${pageContext.request.contextPath}/VerifyCodeServlet" alt=""></td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="提交">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
