package com.applicationservice;

import jakarta.xml.ws.Endpoint;

public class BookServicePublisher {
    public static void main(String[] args){

        try{
            Endpoint.publish("http://localhost:8899/shola", new BookServiceImplementation());
            System.out.println("........The endpoint has been published successfully!");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
