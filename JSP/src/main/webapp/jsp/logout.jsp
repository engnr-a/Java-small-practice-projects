<%--
  Created by IntelliJ IDEA.
  User: absuleim
  Date: 9/9/2022
  Time: 3:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" %>--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>GoodBye</title>
</head>
<body align="center">

<h3 align="center">  GoodBye !--logout </h3>
<%--    Invalidating the session--%>
    <% session.invalidate(); %>

    <b>Request level username: </b> <%= request.getAttribute("username") %> <br><br>

    <b>Session level username: </b> <%= request.getSession().getAttribute("username") %> <br><br>

    <b>ServletContext level username: </b> <%= request.getServletContext().getAttribute("username") %> <br><br>

</body>
</html>

