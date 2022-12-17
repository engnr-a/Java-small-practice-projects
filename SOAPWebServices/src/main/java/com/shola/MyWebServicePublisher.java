package com.shola;

import jakarta.xml.ws.Endpoint;
public class MyWebServicePublisher {

    public static void main(String[] args){
        Endpoint.publish("http://localhost:9999/webservice/greeting", new MyWebServiceImplementation());
    }

}
