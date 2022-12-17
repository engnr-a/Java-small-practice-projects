package serializationparsing;


import lombok.Getter;
import lombok.Setter;

import java.io.*;
import java.util.Arrays;


@Getter @Setter
public class Account implements Externalizable {

    public static final long serialVersionUID = 1L;
    public static String accountType = "LOAN";

    private long accountNumber;
    private String customerName;
    private transient double loanBalance; //a 'transient' field

    private int creditCardScore;
    private CreditCard creditCard;

    private String[] tags;


    //The constructor that java will use to construct the object before reading-in the object during serialization.
    public Account(){}

    public Account(long accountNumber, String customerName, double loanBalance,
                   String cardType, int creditCardScore, String... tags) {
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.loanBalance = loanBalance;
        this.creditCard = new CreditCard(cardType);
        this.creditCardScore = creditCardScore;
        this.tags = tags;

    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber=" + accountNumber +
                ", customerName='" + customerName + '\'' +
                ", loanBalance=" + loanBalance +
                ", credit card =" + creditCard +
                ", tags" + Arrays.toString(tags) +
                '}';
    }



    @Override
    public void writeExternal(ObjectOutput out) throws IOException {

        out.writeLong(accountNumber);
        out.writeUTF(customerName);
        out.writeDouble(loanBalance);
        out.writeUTF(Arrays.toString(tags));

    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.accountNumber = in.readLong();
        this.customerName = in.readUTF();
        this.loanBalance = in.readDouble();

        //Granular control over how the byte stream objects
        String tagString = in.readUTF(); //instance of readUTF
        //To get rid of the opening and closing bracket in an array...see line 75
        //accessing a substring of the tag from character at index 1 to the character at index-1(to get rid of the
        tagString = tagString.substring(1, tagString.length() -1);
        this.tags = tagString.split(", ");
    }
}
