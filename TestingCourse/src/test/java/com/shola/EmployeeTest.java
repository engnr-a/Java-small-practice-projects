package com.shola;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


public class EmployeeTest {
    static Employee employee1;
    static ArrayList<String> employeeProjectHolder = new ArrayList<String>();
    static GregorianCalendar gc;

    static double salary;

    static double defaultSalary;

    @BeforeAll
    static void initEmployee() throws InterruptedException {

        salary =100_000d;
        employee1 = new Employee("Jarda", "Ondrej$", 1234, 'M',
                "Very Senior Engineer", salary, "Founder", employeeProjectHolder);

       Collections.addAll(employee1.projects, "Springboot", "Spring security");

       gc = new GregorianCalendar();

    }



//    @ParameterizedTest
//    @DisplayName("Salary Update")
//    @ValueSource(doubles = {500d, 1000d, 2000d, 5500d}) //the test case will execute 4 times(i.e. length of this array)
//    void salaryUpdateTest(double salaryIncrement) throws InterruptedException {
//        employee1.adjustSalary(salaryIncrement);
//        salary += salaryIncrement;
//        assertEquals(salary, employee1.getSalary(), "Test salary updates!");
//    }

    @ParameterizedTest
    @DisplayName("Salary Update2")
    @NullSource
    void salaryUpdateTest2(String nullName) throws InterruptedException {
        Employee nullEmployee = new Employee ();
        //even though the parameter type is String when parsed into the test, the type is changed to null
        nullEmployee.setLastName(nullName);
        assertNull(nullEmployee.getLastName()); //pass because the

    }


    @ParameterizedTest
    @DisplayName("Hard coded CSV values")
    @CsvSource({"Brian, Jarda, Lukas, Robert"})//hardcoded csv valyes
    void salaryUpdateTest4(String fName, String lName) throws InterruptedException {
        Employee NonnullEmployee = new Employee (fName.trim(), lName.trim(), 1011,
                'M', "Special OPS",  salary, "Founder", employeeProjectHolder );
        //even though the parameter type is String when parsed into the test, the type is changed to null

        assertEquals(lName.trim(), NonnullEmployee.getLastName());
        assertEquals(fName.trim(), NonnullEmployee.getFirstName());


    }


    @ParameterizedTest
    @DisplayName("Parameterized test using values from external CSV file as parameters")
    @CsvFileSource(resources = "/empnames.csv", numLinesToSkip = 1) //path to the CSV file
    void salaryUpdateTest5(String fName, String lName) throws InterruptedException {
        Employee NonnullEmployee = new Employee (fName.trim(), lName.trim(), 1011,
                'M', "Special OPS",  salary, "Founder", employeeProjectHolder );
        //even though the parameter type is String when parsed into the test, the type is changed to null

        assertEquals(lName.trim(), NonnullEmployee.getLastName());
        assertEquals(fName.trim(), NonnullEmployee.getFirstName());
    }



    @RepeatedTest(3)//The test will run 5 times.
    @DisplayName("salary Update")
    void salaryUpdateTest() throws InterruptedException {

        Double salaryIncrement = 20000D;
        employee1.adjustSalary(salaryIncrement);
        defaultSalary += salaryIncrement;
        System.out.println(defaultSalary);
        assertNotEquals(defaultSalary, employee1.getSalary(), "Test salary updates");

    }


//    @Test
//    void  assumptionTestExample() throws InterruptedException {
//        System.out.println("Current hour: " + gc.get(Calendar.HOUR_OF_DAY));
//
//        Assumptions.assumingThat(
//                //This is condition
//               (gc.get(Calendar.HOUR_OF_DAY) < 20),
//                //The block of code to be run or skipped depending on the condition above
//                () ->{
//                    employee1.adjustSalary(50_000D);
//                    assertEquals(150_000, employee1.getSalary());
//                    System.out.println("The assumption about the time of the day was satisfied and the test was run");
//                }
//        );
//
//        //This block of code will run regardless of the result of the condition
//        System.out.println("This test case uses assumingThat to check the time of the day before running the test.");
//    }

    static Stream<String> getLastName(){
        return Stream.of("Ald4", "8Jagd", "$mith");
    }

    @ParameterizedTest(name ="Test #{index} - Last name: {0}")
    @MethodSource("getLastName") //The parameters to be passed to the test will come from the method 'getLastName'
    @DisplayName("Name Check from a method souce")
    void nameTest(String lName){
        Employee employee2 = new Employee();
        employee2.setLastName(lName);

        assertThrows(RuntimeException.class,
                () -> {employee2.validateLastName();},
                "Throws Exception test"
        );
    }

}
