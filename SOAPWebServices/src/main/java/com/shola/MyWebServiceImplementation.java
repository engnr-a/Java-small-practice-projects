package com.shola;

import jakarta.jws.WebService;

@WebService(endpointInterface = "com.shola.MyWebServiceInterface")
public class MyWebServiceImplementation implements MyWebServiceInterface{

    @Override
    public  String myGreetingMessage(String name){
        return String.format("Hello %s, Welcome to my first web service !. This is an SEI", name);
    }
}
