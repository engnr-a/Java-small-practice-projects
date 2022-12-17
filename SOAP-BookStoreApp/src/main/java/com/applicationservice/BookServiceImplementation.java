package com.applicationservice;

import com.applicationdao.BookDAO;
import com.applicationentities.Book;
import jakarta.jws.WebService;

import java.util.List;

@WebService(endpointInterface = "com.applicationservice.BookServiceInterface")
public class BookServiceImplementation implements BookServiceInterface{
    @Override
    public List<Book> getAllBooks(){
        return BookDAO.getAllBooks();
    }

    @Override
    public Book getBookById(String book_id ){
        return BookDAO.getBookById(book_id);
    }

    @Override
    public String addBook(Book book){
        return BookDAO.addBook(book);
    }

    @Override
    public String removeBook(String book_id){
        return BookDAO.removeBook(book_id);
    }

    @Override
    public String updateBook(Book book){
        return BookDAO.updateBook(book);
    }
}
