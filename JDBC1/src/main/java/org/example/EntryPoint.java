package org.example;

import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JoinRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.Connection;
import java.sql.SQLException;

public class EntryPoint {

    public static void displayRow(String label, RowSet rowSet)throws SQLException{
        String fName = rowSet.getString("first_name");
        String lName = rowSet.getString("last_name");
        double hourlyRate = rowSet.getDouble("hourly_rate");
        boolean isFT = rowSet.getBoolean("is_fulltime");

        String stdData = "\n%s: %s | %s | %.2f | %s \n";
        //The label is just a String to help inform where the current cursor is at. It is not a method, just a String
        System.out.format(stdData, label, fName, lName, hourlyRate, isFT);
    }

    public static void main( String[] args ) {

        //Try with resource
        try (Connection conn = DBUtils.getMysqlConnection("/deliveryservice")) {



            CachedRowSet partnersRS = DBUtils.getCachedRowSet("");
            partnersRS.setCommand("select * from delpartners");
            partnersRS.execute(conn);

            CachedRowSet vehiclesRS = DBUtils.getCachedRowSet("");
            vehiclesRS.setCommand("select * from delvehicles");
            vehiclesRS.execute(conn);

            CachedRowSet deliveriesRS = DBUtils.getCachedRowSet("");
            deliveriesRS.setCommand("select * from deliveries");
            deliveriesRS.execute(conn);


            JoinRowSet joinRSPartnersDelivery = RowSetProvider.newFactory().createJoinRowSet();
            JoinRowSet joinRSVehicleDelivery = RowSetProvider.newFactory().createJoinRowSet();
            JoinRowSet joinRS = RowSetProvider.newFactory().createJoinRowSet();

            //Adding vehicles and deliveries together
            joinRSVehicleDelivery.addRowSet(vehiclesRS, "vid");
            joinRSVehicleDelivery.addRowSet(deliveriesRS, "vid");

            //First add Vehicles to joinRSPartnersDelivery then add the devlieriesRS
            joinRSPartnersDelivery.addRowSet(partnersRS, "pid");
            //A deep copy of deliveriesRS is created because we already used deliveryRs in line 49.
            joinRSPartnersDelivery.addRowSet(deliveriesRS.createCopyNoConstraints(), "pid");

            //Add both joinRSPartnersDelivery and joinRSVehicleDelivery to joinRS
            //Both of them should now have 'did' field since both has been joined with deliveries
            joinRS.addRowSet(joinRSVehicleDelivery, "did");
            joinRS.addRowSet(joinRSPartnersDelivery, "did");


            int rowNum=1;

            while(joinRS.next()){
                String fName = joinRS.getString("first_name");
                String color = joinRS.getString("color");
                String vehicleType = joinRS.getString("vehicle_type");
                String destination = joinRS.getString("destination");

                String stdData = "\nRow #%d: %s | %s | %s | %s";
                System.out.format(stdData, rowNum, fName, color, vehicleType, destination);
                rowNum++;

            }
            /*
            Row #1: Danny | Red | Pickup | London
            Row #2: Gerrard | Orange | Van | Abuja
            Row #3: Zoe | Blue | Truck | Prague
            Row #4: Emily | Purple | Truck | Brno
            Row #5: Rebecca | Yellow | Sedan | Bonn
             */
            //closing the connections
            joinRS.close();
            joinRSPartnersDelivery.close();
            joinRSVehicleDelivery.close();
            partnersRS.close();
            vehiclesRS.close();
            deliveriesRS.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}