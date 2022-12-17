package com.applicationentities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class Book implements Serializable {

    private static final long serialversionUID = 1L;

    private String book_id;
    private String book_title;
    private String book_author;
    private float book_price;




    public Book(){
        super();
    }

    public Book(String book_id, String book_title, String book_author, float book_price) {
        this.book_id = book_id;
        this.book_title = book_title;
        this.book_author = book_author;
        this.book_price = book_price;
    }
}
