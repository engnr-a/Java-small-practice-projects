<!DOCTYPE html>
<html>
<head>
    <title>Edit User</title>
    <meta http-equiv="Content-Type" content="text/html" charset="ISO-8859-1">
</head>

<body>

<%@ page import="org.shola.model.User, org.shola.model.UserDAO" %>


<h2 style ="text-align: center">Edit User</h2>


<%
    String id = request.getParameter("id");
    User usr = UserDAO.getRecordById(Integer.parseInt(id));
%>

<h3>Edit Form</h3>
<form action="edituser.jsp" method="post">
    <input type="hidden" name="id" value="<%=usr.getId()%>" />
    <table>
        <tr>
            <td>Name: </td>
            <td><input type="text" name="name" value="<%= usr.getName()%>" />  </td>
        </tr>

        <tr>
            <td>Name: </td>
            <td><input type="text" name="email" value="<%= usr.getEmail()%>" />  </td>
        </tr>

        <tr>
            <td>Sex: </td>
            <td>
                <input type="radio" name="gender" value="M">Male
                <input type="radio" name="gender" value="F">Female
                <input type="radio" name="gender" value="NB">Non-binary
            </td>
        </tr>

        <tr>
            <td>Country: </td>
            <td>
                <select name="country" style="width: 155px">
                    <option>Nigeria</option>
                    <option>Czechia</option>
                    <option>Germany</option>
                    <option>Poland</option>
                    <option>Other</option>
                </select>
            </td>
        </tr>

        <tr>
            <td colspan="2"><input type="submit"  align="center" value="Edit User" /></td>
        </tr>
    </table>

</form>

</body>




</html>