/**
 * This class is link between the custom class (User) and the database table Customer. The fields of the table represents
 * the parameters/properties of the java class.
 * It provides interconversion and inter-working between the rows of the database table and objects of the custom class('User')
 * @Author Shola
 */


package org.shola.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    public static Connection getConnection() {
        Connection conn = null;
        try {
            String url = "jdbc:mysql://localhost:3306/JSPDatabase";
            String user = "root"; //Connecting through root user is not good practice. A user account should exist for each app.
            String password = "Oloyin@@68";

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            conn.setAutoCommit(true);
        } catch (Exception e) {
            System.err.print(e);
        }
        return conn;
    }

    public static List<User> getAllRecord(){
        //a list to hold the rows of the data from the database
        List<User> userList = new ArrayList<>();
        try{
            Connection conn = getConnection(); //this is a call to the method above
            PreparedStatement ps = conn.prepareStatement("select * from Customers");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                //Instance of the User class and setting of its properties using the ResultSet
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setGender(rs.getString("gender"));
                user.setCountry(rs.getString("country"));
                userList.add(user);
            }
            conn.close();
        }catch(Exception e){
            System.err.println(e.getMessage());
        }

        return userList;
    }

    public static User getRecordById(int id){

        User user = null;
        try{
            Connection conn = getConnection(); //this is a call to the method above
            PreparedStatement ps = conn.prepareStatement("select * from Customers where id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                //Instance of the User class and setting of its properties using the ResultSet
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setGender(rs.getString("gender"));
                user.setCountry(rs.getString("country"));
            }
            conn.close();
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        return user;
    }


    public static int addUser(User u){
        int status = 0;
        try{
            Connection conn = getConnection(); //this is a call to the method above

            PreparedStatement ps = conn.prepareStatement(
                    "insert into Customers (name, email, gender, country) values(?,?,?,?)"
            );
            ps.setString(1, u.getName());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getGender());
            ps.setString(4, u.getCountry());

            status = ps.executeUpdate(); //this returns an integer representing the number of rows affected by the query
        }catch(Exception e){
            System.err.println(e);
        }
        return status;
    }


    public static int updateRecord(User u){

        int status = 0;
        try{
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("update Customers set name=?,email=?,gender=?,country=? where id=?");
            ps.setString(1, u.getName());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getGender());
            ps.setString(4, u.getCountry());
            ps.setInt(5, u.getId());
            status = ps.executeUpdate();
            con.close();

        }catch(Exception e){
            System.out.println(e);
        }
        return status;
    }

    public static int deleteUser(User usr){
        int status = 0;

        try{
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement("delete from Customers where id =?");
            ps.setInt(1, usr.getId());
            status = ps.executeUpdate();
            conn.close();
        }catch(Exception e){
            System.err.println(e);
        }
        return status;
    }

}
