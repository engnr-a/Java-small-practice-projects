package serializationparsing;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String [] args) throws IOException {

        Socket socket = null;
        ObjectInputStream  objIn = null;

        try(
                ServerSocket serverSocket = new ServerSocket(8020); //port for incoming connection to listen to
                ){
            System.out.println("waiting for a connection...");

            /*
             * This will wait for a connection to be made to this socket.
             */
            socket = serverSocket.accept(); //it waits around till there is an incoming connection to accept

            //reading object from the input stream
            objIn = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));

            while(true){ //while loop that reads object from the incoming stream as long as their object to be read

                Account account = (Account) objIn.readObject();
                System.out.println("Received account information: \n"+account);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("Error during deserialization");
            System.exit(1);
        }finally {
            socket.close();
            objIn.close();
        }

    }
}
