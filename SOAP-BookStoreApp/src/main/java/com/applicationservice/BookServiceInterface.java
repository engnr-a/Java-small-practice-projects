package com.applicationservice;

import com.applicationentities.Book;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public interface BookServiceInterface {

    @WebMethod
    public List<Book> getAllBooks(); //The only contract is to return a List object containing the Book class.

    @WebMethod
    public Book getBookById(@WebParam(name="book_id") String book_id);

    @WebMethod
    public String addBook(@WebParam(name="book") Book book);

    @WebMethod
    public String removeBook(@WebParam(name="book_id") String book_id);

    @WebMethod
    public String updateBook(@WebParam(name="book") Book book);
}

