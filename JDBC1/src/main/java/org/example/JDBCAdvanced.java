package org.example;

import java.sql.*;
import java.util.Arrays;

public class JDBCAdvanced {
     public static void main(String [] args) throws SQLException {

         int [] count = {};
         Connection conn = null;
         Savepoint sp = null;

         try{

             conn = DBUtils.getMysqlConnection("/deliveryservice");
             //We set AutoCommit to false
             conn.setAutoCommit(false);

             PreparedStatement prStmnt = DBUtils.getInsertVehiclePS(conn);

             //1st batch
             DBUtils.addToInsertVehicleBatch(prStmnt, 29, "Orange", "Truck", "O29");//valid
             DBUtils.addToInsertVehicleBatch(prStmnt, 30, "Yellowish", "Pickup", "G30");//valid
             count = prStmnt.executeBatch();
             //Savepoint on a batch
             sp = conn.setSavepoint("BatchOne");
             System.out.print("First batch executed: "+ Arrays.toString(count)); //First batch executed: [1, 1]

             //2nd batch
             DBUtils.addToInsertVehicleBatch(prStmnt, 31, "Pink", "Van", "P31");//valid
             DBUtils.addToInsertVehicleBatch(prStmnt, 21, "Green", "Van", "G21");//invalid
             count = prStmnt.executeBatch();
             System.out.print("Second batch executed: "+ Arrays.toString(count));

             conn.commit();

         }catch(SQLException sqlx){
             //if sp contains at least one Savepoint (i.e. if sp is not null)
             if(sp != null ){
                 System.err.println("An exception was thrown. Rolling back back to "+sp.getSavepointName());
                 //An exception was thrown. Rolling back back to BatchOne
                 conn.rollback(sp);
                 conn.commit();
             }else{
                 //if sp contains no Savepoint...(i.e. if sp is null)
                 System.err.println("Errors detected. Rolling back everything");
                 conn.rollback(); //rolling back everything
             }

         }

     }
}
