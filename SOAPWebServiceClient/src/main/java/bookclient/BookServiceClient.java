package bookclient;

import java.util.List;

public class BookServiceClient {
    public static void main(String[] args) {
        try {

            BookServiceImplementationService bookServiceImplementationService = new BookServiceImplementationService();
            BookServiceInterface bookServiceInterface = bookServiceImplementationService.getBookServiceImplementationPort();

            //SELECT OPERATION
            List<Book> listBook = bookServiceInterface.getAllBooks();
            for (Book b: listBook) {
                System.err.println("BookId "+b.getBookId()+", Author: "+b.getBookAuthor()+", Title: "+b.getBookTitle());
                /*
                BookId ISBN101, Author: Zoe Zebra, Title: The LameBook
                BookId ISBN102, Author: Emily Elephant, Title: The River
                BookId ISBN103, Author: Pedro Pony, Title: What is this
                BookId ISBN104, Author: Suzy Ship, Title: Get Better
                BookId ISBN107, Author: Emily Elephant, Title: Animal World
                BookId ISBN222, Author: Pepa Pig, Title: Muddy Puddles
                 */
            }

            Book singleBook = bookServiceInterface.getBookById("ISBN101");
            System.out.println("BookId "+singleBook.getBookId()+", Author: "+singleBook.getBookAuthor()+", Title: "+singleBook.getBookTitle());
            //BookId ISBN101, Author: Zoe Zebra, Title: The LameBook


            //INSERT OPERATION
            //Instantiating a new object of the Book class
            Book newBookInstance = new Book();
            newBookInstance.setBookId("ISBNXYZ");
            newBookInstance.setBookAuthor("Tomas Jarda");
            newBookInstance.setBookTitle("We Created Java");
            newBookInstance.setBookPrice(57575.2f);
            //Invoking the add operation from the web service and passing the instantiated book object
            String bookAddOperationMessage = bookServiceInterface.addBook(newBookInstance);
            System.err.println(bookAddOperationMessage); //Book added successfully: ISBNXYZ


           // DELETE OPERATION
            String bookDeleteOperationMessage = bookServiceInterface.removeBook("ISBN101");
            System.err.println(bookDeleteOperationMessage); //Book removed successfully: ISBN101


            //UPDATE OPERATION
            Book singleBook2 = bookServiceInterface.getBookById("ISBN102");
            System.err.println(singleBook2.getBookAuthor());
            singleBook2.setBookTitle("Java To Infinity 2");
            singleBook2.setBookPrice((float) 1500);
            String bookUpdateOperationMessage = bookServiceInterface.updateBook(singleBook2);
            System.err.println(bookUpdateOperationMessage); //Book updated successfully: ISBN102


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
