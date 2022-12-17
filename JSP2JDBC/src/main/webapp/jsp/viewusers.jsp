<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
    <head>
        <title>View Users</title>
        <meta http-equiv="Content-Type" content="text/html" charset="ISO-8859-1">
    </head>

    <body>
        <%--importing necesary custom classes--%>
        <%@ page import="org.shola.model.User,
                        org.shola.model.UserDAO,
                        java.util.*"
        %>

        <%--import of the standard tag library--%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <h2 style ="text-align: center">User Details</h2>


        <%
            List<User> us = UserDAO.getAllRecord();
            request.setAttribute("us", us);
        %>

        <table border="2" align="center"  class="center" style="background-color: #FEF9E7; width: 90%">
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Email</th>
                <th>Gender</th>
                <th>Country</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>

            <%--iterating over the list created above using c:forEach tag--%>
            <c:forEach items="${us}" var="us">

                <tr>
                    <td>${us.getId()}</td>
                    <td>${us.getName()}</td>
                    <td>${us.getEmail()}</td>
                    <td>${us.getGender()}</td>
                    <td>${us.getCountry()}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/jsp/edituserform.jsp?id=${us.getId()}">Edit</a>
                    </td>
                    <td>
                        <a href="${pageContext.request.contextPath}/jsp/deleteuser.jsp?id=${us.getId()}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
                <br/>
                <div>
<%--                    Note: 'window.location; refers to current location of the current file.--%>
                    <button class="btn info" onclick="window.location.href='adduserform.jsp'">
                        Add UserS
                    </button>
                </div>
        </table>

    </body>


</html>