package serializationparsing;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class EntryPoint {

    public static void doDeSerialization(String file) throws IOException, ClassNotFoundException{

        try(
                ObjectInputStream objInput = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))
        ){
            System.out.println("-----------------");
            int i = 0;
            while(i<2)
            {
                System.out.println((Account)objInput.readObject());
                i++;
            }
            System.out.println("-----------------");
        }

    }

    public static void doSerialization(String file, Account account1, Account account2)throws IOException, ClassNotFoundException{
        try(
                ObjectOutputStream objOut = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))
        ){
            objOut.writeObject(account1);
            objOut.writeObject(account2);
        }

    }


    public static void main(String[] args) throws IOException, ClassNotFoundException{

        String file = "accountFile2.txt";

        Account account1 = new Account(134564, "Trump",
                                        78f, "Amex", 5,
                "Reliable", "Good");

        Account account2 = new Account(68434, "Biden",
                75f, "Visa", 6,
                "Reliable", "Great", "High Potential");

        //Convert the accounts to list
        List<Account> accountList = Arrays.asList(account1,account2);

        try(ObjectOutputStream objOut = new ObjectOutputStream(
                new BufferedOutputStream(new FileOutputStream(file))
                )
        ){
            for(Account account : accountList){
                System.out.println("Writing: "+account);
                objOut.writeObject(account);
            }

        }catch(NotSerializableException nse){
               nse.printStackTrace();
        }finally{
            System.out.println("***Completed writing objects.***");
        }
    }
}
