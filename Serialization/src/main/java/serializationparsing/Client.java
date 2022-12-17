//package serializationparsing;
//
//import java.io.BufferedOutputStream;
//import java.io.IOException;
//import java.io.ObjectOutput;
//import java.io.ObjectOutputStream;
//import java.net.Inet4Address;
//import java.net.Socket;
//import java.util.Arrays;
//import java.util.List;
//
//public class Client {
//    public static void main(String[] args) throws IOException{
//
//        Account account1 = new Account(134564, "Trump", 78f, "Amex");
//        Account account2 = new Account(37353, "France", 86f, "Visa");
//        Account account3 = new Account(227799, "England", 85.3f, "MC");
//
//        List<Account> accountList = Arrays.asList(account1, account2, account3);
//
//        ObjectOutputStream objOut = null;
//
//        try{
//
//            //A socket is created by instantiating a socket object. Localhost at 127.0.0.1.
//            Socket socket =  new Socket(Inet4Address.getLocalHost(), 8020);
//
//            //This is similar to writing byte stream out to a file. Instead of file, we are writing to the socket.
//            objOut = new ObjectOutputStream( new BufferedOutputStream(socket.getOutputStream()));
//
//            //For loop to write-out every account in 'accountList' to the instantiated ObjectOutputStream above.
//            for(Account account : accountList){
//                System.out.println("Writing Accounts to socket stream: \n" + account);
//
//                objOut.writeObject(account);
//                objOut.flush();
//                Thread.sleep(5000); //sleeping for 5000 milliseconds before writing next account object
//            }
//        }catch(Exception e){
//            System.out.println(e.getMessage());
//            System.out.println("Error during serialization.");
//            System.exit(1);
//        }finally {
//            objOut.close(); //closing the stream
//        }
//    }
//}
