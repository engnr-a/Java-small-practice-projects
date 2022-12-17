package org.example;


import java.sql.*;

/**
 * This class represents different types of SQL queries which can be executed against the SQL database table.
 *
 * @UsedDataBaseTable: delpartners
 * @Author: Shola
 */
public class DeliveryPartnerQueries {

    public ResultSet getAllDelPartners(Connection conn) {
        try {

            //The connection object is used to execute a statement
            Statement stmt = conn.createStatement();
            String query = "select first_name, last_name, hourly_rate, is_fulltime " + "from delpartners";

            //This captures what is returned after the statement executes successfully.
            return stmt.executeQuery(query);

        } catch (SQLException sqlex) {
            sqlex.printStackTrace();
            return null;
        }

    }

    public ResultSet getDelPartnerById(Connection conn, int id){
        try{

            //The '?' serves as a placeholder, which the PreparedStatement will substitute later on. Hence, this is a \
                //parametrized query
                String query = "select first_name, last_name, hourly_rate, is_fulltime " + "from delpartners where id = ?";

            //Use of PreparedStatement
            PreparedStatement ps = conn.prepareStatement(query);
            //we wish to populate the value of the 'id' in the query. 1: the 1st placeholder, id: substitute with id.
            ps.setInt(1, id);
            //
            return ps.executeQuery();

        }catch (SQLException sqlex) {
            sqlex.printStackTrace();
            return null;
        }

    }

    public int addNewDelPartner(Connection conn, String fName, String lName, double hourlyRate, Boolean isFT){
        int status = 0;
        try {
            String query = "insert into delpartners "
                    + "(first_name, last_name, hourly_rate, is_fulltime) "
                    + "values (?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(query);
            //Replacing the placeholders in the query with actual values from the arguments parsed to the method.
            ps.setString(1, fName);
            ps.setString(2, lName);
            ps.setDouble(3, hourlyRate);
            ps.setBoolean(4, isFT);

            //Note that we are using executeUpdate() method instead of executeQuery() method
            //The return value depends on the database being used. In MySQL, the number of rows affected by the operation
                //is returned
            status = ps.executeUpdate();

        }catch (SQLException sqlx){
            sqlx.printStackTrace();
        }
        return status;
    }

    public int applyPayAdjustment(Connection conn, double adjAmount, boolean isFT){
        int status = 0;

        try{
            //Adjust hourly_rate for the specified is_fulltime
            String query = "update delpartners "
                    + "set hourly_rate = hourly_rate + ?"
                    + "where is_fulltime = ?";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setDouble(1, adjAmount);
            ps.setBoolean(2, isFT);

            status = ps.executeUpdate();
        }catch(SQLException sqlx){
            sqlx.printStackTrace();
        }
        return status;
    }

    public int deleteDeliveryPartner(Connection conn, int id){
        int status =0;

        try{
            String query = "delete from delpartners "
                           + "where id = ?";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setDouble(1, id);
            status = ps.executeUpdate();
        }catch(SQLException sqlx){
            sqlx.printStackTrace();
        }

        return status;
    }

}
