package org.shola;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name ="bookinfo", urlPatterns ="/bookinfo")
public class BookInfoServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest req, HttpServletResponse resp)throws IOException, ServletException {
        String bookName = req.getParameter("bookname");
        String authorName = req.getParameter("authorname");
        String date =  req.getParameter("date");

        req.setAttribute("updatedBookName", bookName.trim().toLowerCase());
        req.setAttribute("updatedAuthorName", authorName);
        req.setAttribute("updatedDate", date);


        //RequestDispatcher
        RequestDispatcher redis = req.getRequestDispatcher("/jsp/booksubmitconfirm.jsp");
        redis.forward(req, resp);

    }
}
