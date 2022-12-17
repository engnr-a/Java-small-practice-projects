package jsonparsing;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
public class EntryPoint {

    public static void main(String [] args) throws IOException {


        Employee john = new Employee("John Snow", "Male", 24);
        System.out.println(john.toJSONString());//{"name":"John Snow", "age":"24", "gender":"Male", "ID":"868231797"}
        Employee rebeca = new Employee("Rebeca Rabbit", "Female", 19);
        Employee zoe = new Employee("Zoe Zebra", "Female", 18);

        //Because the Employee class implements the JSONAware interface, it is objects are basically JSONObjects.
        //Hence, we don't need to initiate JSONObjects for these employees before adding them to JSONArray
        JSONArray employeeList = new JSONArray();
        employeeList.add(john);
        employeeList.add(rebeca);
        employeeList.add(zoe);

        try(FileWriter writer = new FileWriter("employees.json")){
            employeeList.writeJSONString(writer);
        }
    }
}
