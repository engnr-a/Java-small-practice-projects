<%--
  Created by IntelliJ IDEA.
  User: absuleim
  Date: 9/9/2022
  Time: 3:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page isErrorPage="true"  %>
<%@ page isELIgnored="false" %>
<html>

    <head>
        <title>Title</title>
    </head>

    <body>
        <h2>An Exception has occurred !</h2>

        Exception is: <%= exception.getLocalizedMessage() %>
<%--        The pageContext...constructs a path to the webapp folder (instead of hard coding it)--%>
        <img src="${pageContext.request.contextPath}/img/error.png" alt="Error"><br/>

        Image sourced from
        <a href="https://wwww.pexels.com/photo.man-people-art-sign-4439425">This Location at pexels.com</a>

    </body>

</html>
