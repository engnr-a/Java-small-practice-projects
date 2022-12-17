<%@ page import ="org.shola.model.UserDAO" %>
<%@ page isELIgnored="false" %>
<jsp:useBean id="usr" class="org.shola.model.User"></jsp:useBean>
<jsp:setProperty name="usr" property="*"></jsp:setProperty>


<%
    int i = UserDAO.deleteUser(usr);

    if(!(i>0)){

        out.print("Unable to delete user."+"User with ID: "+usr.getId());
    }else {
        out.print("User with ID: ."+usr.getId()+", has been deleted.");
    }
%>
<a href="${pageContext.request.contextPath}/jsp/viewusers.jsp">View UserS</a>
