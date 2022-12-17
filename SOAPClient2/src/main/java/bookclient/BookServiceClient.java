package bookclient;

import java.util.List;

public class BookServiceClient {
    public static void main(String[] args) {

        try {


            BookServiceImplementationService bookServiceImplementationService = new BookServiceImplementationService();
            BookServiceInterface bookServiceInterface = bookServiceImplementationService.getBookServiceImplementationPort();


            List<Book> listBook = bookServiceInterface.getAllBooks();
            for (Book b : listBook) {
                System.err.println(b.getBookAuthor());
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
