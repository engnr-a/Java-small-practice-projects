package org.shola;

import java.io.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

//An annotation used to declare a servlet class. It can be used to set a name and also to map a servlet to a url pattern
@WebServlet(name = "my-servlet", urlPatterns = "/my-servlet")
public class MyServlet extends HttpServlet {

    private String message;

    public void init(){
        message = "Hello ! I am a servlet and here to serve.";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{

        response.setContentType("text/html");

        //Writing html into the resonse
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h1>"+message+"</h1>");
        out.println("</html></body>");
    }

    public void destroy(){}
}
