package com.jaxrswebservice;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.MediaType; //Content-Type is defined in terms of a media type
import jakarta.ws.rs.Produces; //An annotation that allows us to define the Content-Type produced by the HTTP method

@Path("/ws")
public class HelloWorldService {

    @GET
    @Path("/greeting")
    @Produces({MediaType.TEXT_PLAIN})
    //The method now return a Response object. The object have the 'message' incorporated within it.
    public Response myGreeting(){
        System.err.println("Welcome");
        //Unlike the previous implementation, String "Welcome..." is sent as part of a body of response.
        String message= "Welcome to the world of REST APIs in Java--by Shola";
        //Construction of the response object
        return Response.status(200).entity(message).build();
    }

    //The method parameter is obtained from the request parameter that comes from the URL
    @GET
    @Path("/greeting/{param}")
    @Produces(MediaType.TEXT_HTML)
    public Response myGreeting(@PathParam("param") String name){
        String personalizedMessage = String.format("<p>Hello <b>%s </b>!. Welcome to REST APIs in Java.</p> Author: Shola", name);
        //construction of the response obje ct
        return Response.status(200).entity(personalizedMessage).build();
    }

}
