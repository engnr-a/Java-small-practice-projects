package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class DBUtils {

    private static final String dbURL = "jdbc:mysql://localhost:3306";
    private static final String username = "root";
    private static final String password = "Oloyin@@68";




    public static Connection getMysqlConnection(String schemaName){

        //Note that a database schema has not been created. Will be done in subsequent section

        MysqlDataSource mysqlDS = null;
        Connection conn = null;

        try{
            mysqlDS = new MysqlDataSource();
            mysqlDS.setURL(dbURL + schemaName);
            mysqlDS.setUser(username);
            mysqlDS.setPassword(password);

            conn = mysqlDS.getConnection();

        }catch(SQLException e){
          e.printStackTrace();
        }
        return conn;
    }

    public static  JdbcRowSet getJdbcRowSet(String schemaName){

        JdbcRowSet jdbcRS = null;

        try{
            //We use the RowSetProvider class(which has implemented the methods defined within JdbcRowSet) to object JdbcRowSet
            jdbcRS = RowSetProvider.newFactory().createJdbcRowSet();
            jdbcRS.setUrl(dbURL + schemaName);
            jdbcRS.setUsername(username);
            jdbcRS.setPassword(password);

        }catch(SQLException sqlx){
            sqlx.printStackTrace();
        }

        return jdbcRS;

    }

    public static CachedRowSet getCachedRowSet(String schemaName){
        CachedRowSet cachedRS = null;
        try{
            cachedRS = RowSetProvider.newFactory().createCachedRowSet();
            cachedRS.setUrl(dbURL + schemaName);
            cachedRS.setUsername(username);
            cachedRS.setPassword(password);
        } catch (SQLException sqlx) {
            sqlx.printStackTrace();
        }
        return cachedRS;
    }


    //This method will return PreparedStatement object from Connect object
    public static PreparedStatement getInsertVehiclePS(Connection conn){
        try{
            return conn.prepareStatement("insert into delvehicles value(?, ?, ?, ?)");
        }catch(SQLException sqlx){
            sqlx.printStackTrace();
        }
        return null;
    }

    public static boolean addToInsertVehicleBatch(PreparedStatement ps, int id,
                                                  String color, String vehicle_type, String licence_plate){

        boolean addedQuery = false;
        try{
            ps.setInt(1, id);
            ps.setString(2, color);
            ps.setString(3, vehicle_type );
            ps.setString(4, licence_plate );
            ps.addBatch();
            addedQuery = true;

        }catch(SQLException sqlx){
            sqlx.printStackTrace();
        }

        return addedQuery;
    }
}
