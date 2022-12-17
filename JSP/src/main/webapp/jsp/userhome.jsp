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
    <title>Sign in successful</title>
        </head>
        <body align="center">

        <h3 align="center">  Welcome--userhome </h3>

        <b>Request level username: </b> <%= request.getAttribute("username") %> <br><br>

        <b>Session level username: </b> <%= request.getSession().getAttribute("username") %> <br><br>

        <b>ServletContext level username: </b> <%= request.getServletContext().getAttribute("username") %> <br><br>

        Click <a href="${pageContext.request.contextPath}/jsp/logout.jsp">Here</a> to go to your home page.

     </body>
</html>

