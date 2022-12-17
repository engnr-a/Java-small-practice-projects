package jsonparsing;

import org.json.simple.JSONAware;
import java.util.Random;
public class Employee implements JSONAware {
       public Random randomNumberGenerator = new Random();
       public String name;
       public String gender;
       public int age;

       public final int employeeID;

    public Employee(String name, String gender, int age) {
        this.employeeID = Math.abs(randomNumberGenerator.nextInt());
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    @Override
    public String toJSONString() {
        return String.format("{\"name\":\"%s\", \"age\":\"%d\", \"gender\":\"%s\", \"ID\":\"%d\"}",
                            name, age, gender, employeeID);
    }
}
