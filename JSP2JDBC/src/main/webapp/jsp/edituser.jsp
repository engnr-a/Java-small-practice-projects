<%@ page isELIgnored="false" %>
<%@ page import="org.shola.model.UserDAO" %>


<%--NOTE: "usr" in useBean comes from edituserform.jsp--%>
<jsp:useBean id="usr" class="org.shola.model.User"></jsp:useBean>
<jsp:setProperty name="usr" property="*"></jsp:setProperty>


<%
    if(!(i>0)){

        out.print("Unable to update user:"+usr.getName()+", "+usr.getId()+", "+ usr.getEmail()+", "+usr.getGender()+", "+usr.getCountry());
    }else {
        out.print("The following info user has been deleted:"+usr.getName()+", "+usr.getId()+", "+ usr.getEmail()+", "+usr.getGender()+", "+usr.getCountry());
    }
%>

<a href="${pageContext.request.contextPath}/jsp/viewusers.jsp">View UserS</a>