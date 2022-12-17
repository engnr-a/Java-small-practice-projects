package com.applicationdao;

import com.applicationentities.Book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {


    private static Connection myDB = null;
    private static final String url = "jdbc:mysql://localhost:3306/BookService";
    private static final String username = "root";
    private static final String password = "Oloyin@@68";


    private BookDAO(){}


    public static Connection getConnection(){
        try{
            if(myDB == null){
                Class.forName("com.mysql.cj.jdbc.Driver");
                myDB = DriverManager.getConnection(url, username, password);
            }
        }catch(Exception e){
            System.err.println(e.getStackTrace());
        }
        return myDB;

    }

    public static Book getBookById(String book_id){
        try{
            Connection myDB = getConnection();
            PreparedStatement ps = myDB.prepareStatement("select * from books where book_id=?");
            ps.setString(1, book_id);
            ResultSet rs = ps.executeQuery();
            rs.next();

            Book bookInstance = new Book();
            bookInstance.setBook_id(rs.getString("book_id"));
            bookInstance.setBook_author(rs.getString("book_author"));
            bookInstance.setBook_title(rs.getString("book_title"));
            bookInstance.setBook_price(rs.getFloat("book_price"));

            return bookInstance;
        }catch(Exception e){
            System.err.println(e.getStackTrace());
        }
        return null;
    }
    public static List<Book> getAllBooks(){
        List<Book> bookList = new ArrayList<>();

        try{
            Connection myDB = getConnection();
            PreparedStatement ps = myDB.prepareStatement("select * from books");
            ResultSet rs = ps.executeQuery();


            while(rs.next()){

                Book bookInstance = new Book();
                bookInstance.setBook_id(rs.getString("book_id"));
                bookInstance.setBook_author(rs.getString("book_author"));
                bookInstance.setBook_title(rs.getString("book_title"));
                bookInstance.setBook_price(rs.getFloat("book_price"));

                bookList.add(bookInstance);
            }

            return bookList;

        }catch(Exception e){
            System.err.println(e.getStackTrace());
        }
        return null;
    }

    public static String addBook(Book book){
        int status =0;
        String responseMessage = "";

        try{
            Connection myDB = getConnection();
            PreparedStatement ps = myDB.prepareStatement(
                    "insert into books (book_id, book_title, book_author, book_price) values(?,?,?,?)");

            ps.setString(1, book.getBook_id());
            ps.setString(2, book.getBook_title());
            ps.setString(3, book.getBook_author());
            ps.setFloat(4, book.getBook_price());

            status = ps.executeUpdate();

            String successMsg = "Book added successfully: "+book.getBook_id();
            String errorMsg = "Error adding book: "+book.getBook_id();

            //Note the conditional assignment of responseMessage below
            responseMessage = (status ==1) ? successMsg : errorMsg;

        }catch(Exception e){
            e.printStackTrace();
        }
        System.err.println("Returning response message: "+responseMessage);
        return responseMessage;
    }


    public static String removeBook(String book_id){
        int status = 0;
        String responseMessage = "";
        try {
            Connection myDB = getConnection();
            PreparedStatement ps = myDB.prepareStatement("delete from books where book_id =?");
            ps.setString(1, book_id);

            status = ps.executeUpdate();

            String successMsg = "Book removed successfully: " + book_id;
            String errorMsg = "Error deleting book: " + book_id;

            responseMessage = (status == 1) ? successMsg : errorMsg;

        }catch(Exception e){
            e.printStackTrace();
        }
        System.err.println("Returning response message: "+responseMessage);
        return responseMessage;
    }


    public static String updateBook(Book book){
        int status = 0;
        String responseMessage = "";
        try{
            Connection myDB = getConnection();
            PreparedStatement ps = myDB.prepareStatement("update books set book_title =?, book_author=?, book_price=? where book_id=?");
            ps.setString(1, book.getBook_title());
            ps.setString(2, book.getBook_author());
            ps.setFloat(3, book.getBook_price());
            ps.setString(4, book.getBook_id());

            status = ps.executeUpdate();

            String successMsg = "Book updated successfully: " + book.getBook_id();
            String errorMsg = "Error updating book: " + book.getBook_id();

            responseMessage = (status == 1) ? successMsg : errorMsg;

        }catch(Exception e){
            e.printStackTrace();
        }

        System.err.println("Returning response message: "+ responseMessage);
        return responseMessage;
    }
}
