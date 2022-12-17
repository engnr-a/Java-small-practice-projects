package org;

import org.json.CDL;
import org.json.JSONArray;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class EntryPoint {

    public static void main(String[] args) throws  IOException, NullPointerException{

        String commaDelimitedLoans = new String(Files.readAllBytes(Paths.get("loans_with_header.csv")));

        System.out.println(commaDelimitedLoans);

        //One argument version of the CDL.toJSONArray
        JSONArray loansArray = CDL.toJSONArray(commaDelimitedLoans);

        System.out.println(loansArray.toString(1));
        /*
        [
         {
          "Loan Status": "FullPaid",
          "Annual Income": "4545633",
          "ID": "353537",
          "Loan Amount": "ShortTerm",
          "Term": "716",
          "Credit Balance": "42748254",
          "Home": "Home Mortgage"
         },
         {
          "Loan Status": "FullPaid",
          "Annual Income": "36473",
          "ID": "98373",
          "Loan Amount": "ShortTerm",
          "Term": "342",
          "Credit Balance": "25344",
          "Home": "Rent"
         },
         {
          "Loan Status": "Charged off",
          "Annual Income": "632",
          "ID": "383633",
          "Loan Amount": "Long Term",
          "Term": "342",
          "Credit Balance": "1234",
          "Home": "Car Loan"
         }
        ]
       */

    }
}
