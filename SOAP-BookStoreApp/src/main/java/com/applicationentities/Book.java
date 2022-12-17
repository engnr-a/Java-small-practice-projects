package com.applicationentities;

//This will come handy when communicating book instances between server and client application

//import lombok.Getter;
//import lombok.Setter;
//import lombok.ToString;

import java.io.Serializable;

//@Getter
//@Setter
//@ToString
public class Book implements Serializable {

    //To keep track of the version and changes to the class before and after it has been serialized
    private static final long serialVersionUID = 1L;
    private String book_id;
    private String book_title;
    private String book_author;
    private float book_price;

    public String getBook_id() {
        return book_id;
    }

    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }

    public String getBook_title() {
        return book_title;
    }

    public void setBook_title(String book_title) {
        this.book_title = book_title;
    }

    public String getBook_author() {
        return book_author;
    }

    public void setBook_author(String book_author) {
        this.book_author = book_author;
    }

    public float getBook_price() {
        return book_price;
    }

    public void setBook_price(float book_price) {
        this.book_price = book_price;
    }

    //Default no argument constructor is important for the 'jaxws' library. It will be first used to create a new book instance and then
        // the setter methods will be used to set the value for each book. Check the publisher class.
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
