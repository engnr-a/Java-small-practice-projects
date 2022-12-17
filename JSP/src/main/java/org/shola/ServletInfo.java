package org.shola;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Iterator;

@WebServlet(name="info-servlet", urlPatterns = "/servletinfo")
public class ServletInfo extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        PrintWriter out = response.getWriter();
        out.write("Servlet details:");

        ServletConfig cfg = getServletConfig();
        out.write("\nServlet name: "+cfg.getServletName());
        out.write("\nConfig params--: ");
        Enumeration<String> paramIterator = cfg.getInitParameterNames();
        while (paramIterator.hasMoreElements()) {
            String name = paramIterator.nextElement();
            out.write(name);
        }

        ServletContext ctx = getServletContext();
        out.write("\nContext name: "+ctx.getServletContextName()); //This is the name set inside the web.xml file.
        out.write("\nContext path: "+ctx.getContextPath());
        out.write("\nServer info: "+ctx.getServerInfo());

        //Attributes set within the ServletContext applies to and is available to all servlet within the application.
        ctx.setAttribute("rootuseer", "myadmin");

    }

}
