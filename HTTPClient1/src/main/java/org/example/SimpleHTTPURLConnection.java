package org.example;

import java.io.*;
import java.net.*;
public class SimpleHTTPURLConnection {

    public static void main(String[] args) throws MalformedURLException {

        BufferedReader read;
        String text;
        StringBuffer content = new StringBuffer();

        try {

            //NOTE that parameter delay=5(second) is set in order to simulate the exception.
            URL url = new URL("https://reqres.in/api/users?delay=5");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            //Set the method type
            conn.setRequestMethod("HEAD");

            //the connection will wait for 2000 millisecond or 2seconds
            conn.setReadTimeout(2000);


            int statusCode = conn.getResponseCode();

            System.out.println(statusCode);

            //Accessing the information that comes with HEAD request method
            System.out.println("Headers: \n" + conn.getHeaderFields().toString());

        } catch(Exception e){
            System.out.println(e.getMessage());}
    }}