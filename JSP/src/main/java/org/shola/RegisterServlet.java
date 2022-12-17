package org.shola;

import java.io.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;


@WebServlet(name = "register", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {

    //Since HTTPServlet implements the Serializable interface, we explicitly set the serialVersionUID to track any changes
    //to the servlet class after it has been serialized.(see the course on serialization).
    public static long serialVersionUID = 1L;

    protected  void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{

        //Obtaining the data embedded in the request object
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String member = request.getParameter("membership");
        String date = request.getParameter("date");
        //Since checkbox can have multiple parameters, an array of the parameter values will be returned.
        String [] subscription = request.getParameterValues("subs");



        //Using the response object to give a response back
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();

        pw.write("<html><body align=\"center\">");
        pw.write("<h1 align=\"center\">Registration Information</h1>");
        pw.write("<br><b>Name: </b>" + name);
        pw.write("<br><b>Email: </b>" + email);
        pw.write("<br><b>Membership: </b>" + member);
        pw.write("<br><b>Name: </b>" + date);
        pw.write("<br><b>Subscriptions:("+subscription.length+")</b>");
        int count = 0;
        while(count<subscription.length){
                pw.write("<br><b>"+count+ ": </b> " + subscription[count]);
            count++;
        }
        pw.write("</html></body>");

    }
}
