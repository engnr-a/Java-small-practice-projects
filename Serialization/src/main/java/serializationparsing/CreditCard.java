package serializationparsing;

import java.io.Serializable;

public class CreditCard implements Serializable {

    private static final long serialVersionUID = 1L;
    private final String creditCardType;

    public CreditCard(String creditCardType){
        this.creditCardType = creditCardType;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "creditCardType='" + creditCardType + '\'' +
                '}';
    }
}
