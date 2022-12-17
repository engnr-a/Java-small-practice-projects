package com.shola;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDetail {
    private String name;
    private Integer accountNumber;
    private Integer customerID;
    private Double balance;
    public enum AccountType{PERSONAL, COMPANY, GOVERNMENT, NGO}
    public AccountType accountType;

    public void deposit(Double depositAmount){
        balance = balance + depositAmount;
    }

    public boolean withdrawal(Double withdrawalAmount) {
        if(balance > withdrawalAmount){
            balance = balance - withdrawalAmount;
            return true;
        }else{
            System.err.println("Insufficient Funds.");
            return false;
        }
    }

}

