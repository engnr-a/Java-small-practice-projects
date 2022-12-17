<%@ page import="org.shola.model.UserDAO" %>
<%@ page isELIgnored="false" %>

<%--JSP tags userBean and setProperty--%>
<jsp:useBean id="userInstance" class="org.shola.model.User"></jsp:useBean>
<jsp:setProperty name="userInstance" property="*"></jsp:setProperty>

<%
    int i = UserDAO.addUser(userInstance);
    if(i > 0){
        out.print("<h3 align=center> Success! The user has been added. </h3><br><br>");
    }else{
    out.print("<h3 align=center> Oh No...! There was an error when adding the user. </h3><br><br>");
    }
%>
<a href="${pageContext.request.contextPath}/jsp/viewusers.jsp">View Users</a>