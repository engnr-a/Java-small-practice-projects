package com.jaxrswebservice;


import com.applicationdao.BookDAO;
import com.applicationentities.Book;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;


@Path("/bookservice")
public class BookService {

    @GET
    @Path("/getbooks")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllBook() {
        List<Book> listOfBooks = BookDAO.getAllBooks();

        return Response.status(Response.Status.OK).entity(listOfBooks).build();

        /*
        http://localhost:7777/JavaRESTAPI/bookservice/getbooks

        [
        {"book_id":"ISBN102","book_title":"Java To Infinity 2","book_author":"Emily Elephant","book_price":1500.0},
        {"book_id":"ISBN103","book_title":"What is this","book_author":"Pedro Pony","book_price":6.1},
        {"book_id":"ISBN104","book_title":"Get Better","book_author":"Suzy Ship","book_price":8.5},
        {"book_id":"ISBN107","book_title":"Animal World","book_author":"Emily Elephant","book_price":38.5},
        {"book_id":"ISBN222","book_title":"Muddy Puddles","book_author":"Pepa Pig","book_price":5.4},
        {"book_id":"ISBNXYZ","book_title":"We Created Java","book_author":"Tomas Jarda","book_price":57575.2}
        ]
         */
    }

    @GET
    @Path("/getbookbyid/{params}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBookById(@PathParam("params") String bookId) {

        //A call to the parameterized method of the BookDAO. The query parameter from then URL is passed to the method
        Book book = BookDAO.getBookById(bookId);
        if(book == null){

            String altResponse = String.format("{ \"message\" : \"Book with ID %s is not found\"}", bookId);

            return Response.status(Response.Status.NOT_FOUND).entity(altResponse).build();

        }
        return Response.status(Response.Status.OK).entity(book).build();

        /*
        http://localhost:7777/JavaRESTAPI/bookservice/getbookbyid/ISBN102
        {"book_id":"ISBN102","book_title":"Java To Infinity 2","book_author":"Emily Elephant","book_price":1500.0}

         http://localhost:7777/JavaRESTAPI/bookservice/getbookbyid/ISBN1099
         { "message" : "Book with ID ISBN105 is not found"}
         */
    }

    @POST
    @Path("/addBook")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addBook(Book book){

        //The String message returned by the method is assigned to addMsg.
        String addMsg = BookDAO.addBook(book);
        //Conditional check of the String object returned by the addBook() method.
        if(addMsg.startsWith("Error")){
            String altResponse = String.format("{ \"error\" : \"Book could not be added....%s\"}", addMsg);

            return Response.status(Response.Status.CONFLICT).entity(altResponse).build();
        }

        return Response.status(Response.Status.CREATED).entity(book).build();

    }

    @PUT
    @Path("/updateBook")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateBook(Book book){

        //The String message returned by the method is assigned to addMsg.
        String addMsg = BookDAO.updateBook(book);
        //Conditional check of the String object returned by the addBook() method.
        if(addMsg.startsWith("Error")){
            String altResponse = String.format("{ \"error\" : \"Book could not be updated....%s\"}", addMsg);
            return Response.status(Response.Status.NOT_FOUND).entity(altResponse).build();
        }
        return Response.status(Response.Status.CREATED).entity(book).build();
    }


    @DELETE
    @Path("/deleteBook/{param}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response deleteBook(@PathParam("param") String book_id){

        //The String message returned by the method is assigned to addMsg.
        String addMsg = BookDAO.removeBook(book_id);
        //Conditional check of the String object returned by the addBook() method.
        if(addMsg.startsWith("Error")){
            String altResponse = String.format("{ \"error\" : \"Book could not be deleted....%s\"}", addMsg);
            return Response.status(Response.Status.NOT_FOUND).entity(altResponse).build();
        }
        return Response.status(Response.Status.CREATED).entity("Book deleted. ID: "+book_id).build();
    }

}
