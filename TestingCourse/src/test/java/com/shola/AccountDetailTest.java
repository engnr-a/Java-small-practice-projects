package com.shola;

import org.junit.jupiter.api.*;
import com.shola.AccountDetail.AccountType;

public class AccountDetailTest {
    static AccountDetail accountDetail;

    @BeforeAll
    static void initAlls(){
        System.out.println("---Starting the test class.---");

    }
    @BeforeEach
    //The method below will be run before each test case/method
    public void initEach(){
        accountDetail = new AccountDetail("John Dick", 5555, 22,50_000D, AccountType.COMPANY);
        System.out.println("@BeforeEach block has been executed");
        System.out.println("account balance: "+accountDetail.getBalance());
    }

    @Test
    @Tag("DEVShola")
    void depositTest() throws NullPointerException {
        accountDetail.deposit(50_000D);
        System.out.println("@Test block for deposit has been executed !");
    }

    @Test
    void withdrawalTest() throws NullPointerException{
        accountDetail.withdrawal(20_000D);
        System.out.println("@Test block for withdrawal has been executed !");
    }

    @AfterEach
    void balance(){
        System.out.println("@AfterEach has been executed");
        System.out.println("account balance : "+accountDetail.getBalance());
    }

    @AfterAll
    static void teardownAlls(){;
        System.out.println("---The test class has been completed.---");
        accountDetail = null;
        System.err.println(accountDetail);
    }
    /*
    ---Starting the test class.---
    @BeforeEach block has been executed
    account balance: 50000.0
    @Test block for withdrawal has been executed !
    @AfterEach has been executed
    account balance : 30000.0
    @BeforeEach block has been executed
    account balance: 50000.0
    @Test block for deposit has been executed !
    @AfterEach has been executed
    account balance : 100000.0
    null
    ---The test class has been completed.---
     */
}