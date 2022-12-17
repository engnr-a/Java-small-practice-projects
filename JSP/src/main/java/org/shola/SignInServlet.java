package org.shola;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(urlPatterns = "/signin")
public class SignInServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        //Setting request attribute..request level access is accessible only within the scope of http request.
        //A request level attribute will no longer be accessible when the request has been processed.
        request.setAttribute("username", "request_"+username);

        //HttpSession object. False--> if a session doesnt exist, it shouldn't be created and null should be returned.
        HttpSession session = request.getSession(false);
        //Setting session attribute. Session level attribute is persists longer than the request level.
        //Hence when a request level is no longer accessible, the session level attribute can be used
        session.setAttribute("username", "session_"+username);

        ServletContext ctx = getServletContext();
        //Setting servlet context attribute. The context level(application-wide level) is the most persistent, and it is accessible
            //for as long as the application is up and running
        ctx.setAttribute("username", "servletcontext_"+username);

        try{
            //Dispatching the request to the JSP page 'signinconfirm.jsp
            RequestDispatcher rd = request.getRequestDispatcher("/jsp/signinconfirm.jsp");
            rd.forward(request, response);
        }catch(ServletException svx){
            svx.printStackTrace();
        }

    }
}
