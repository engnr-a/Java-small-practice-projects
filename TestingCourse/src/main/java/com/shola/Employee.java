package com.shola;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    String firstName;
    String lastName;
    Integer id;
    Character gender;
    String role;
    Double salary;
    String type;

    ArrayList<String> projects;

    public void adjustSalary(Double adjAmount)throws InterruptedException{

        if(adjAmount >5000){
            System.err.println("The adjustment amount is greater than upper limit of 5000. Applying 5k...");
            adjAmount = 5000D;
        }
        System.err.println("Updating salary from "+salary+ " to "+(salary+adjAmount));
        salary += adjAmount;
        Thread.sleep(60);
    }

    //This method throws a custom runtime exception if the lastname doesn't contain only alphabet(@NotNull @NotString regex)
    public void validateLastName() throws Exception{
        if(!this.lastName.matches("^[a-zA-Z]*$")){
            throw new RuntimeException("The last name can only contain alphabets");
        }

    }

}
