<%@ page isELIgnored="false" %>
<%@ page import="org.shola.model.UserDAO" %>


<%--NOTE: "usr" in useBean comes from edituserform.jsp--%>
<jsp:useBean id="usr" class="org.shola.model.User"></jsp:useBean>
<jsp:setProperty name="usr" property="*"></jsp:setProperty>


<%--<%--%>
<%--    int i = UserDAO.updateRecord(usr);--%>
<%--    if(i > 0){--%>
<%--        out.print("<h3 align=center> The user update has been sent. Check the user list to confirm </h3><br><br>");--%>
<%--    }else{--%>
<%--        out.print("<h3 align=center> Oh No...! There was an error when modifying the user</h3><br><br>");--%>
<%--    }--%>
<%--%>--%>

<%
    if(!(i>0)){

        out.print("Unable to update user:"+usr.getName()+", "+usr.getId()+", "+ usr.getEmail()+", "+usr.getGender()+", "+usr.getCountry());
    }else {
        out.print("The following info user has been deleted:"+usr.getName()+", "+usr.getId()+", "+ usr.getEmail()+", "+usr.getGender()+", "+usr.getCountry());
    }
%>

<%--<h3>Unable to update user: ${usr.getName()}</h3>--%>
<%--<h3>The user update has been sent. Check the user list to confirm</h3><br>--%>
<a href="${pageContext.request.contextPath}/jsp/viewusers.jsp">View UserS</a>