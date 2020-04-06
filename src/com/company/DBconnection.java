package com.company;

import java.sql.*;
import java.util.InputMismatchException;

public class DBconnection {
        private static String url = "jdbc:mysql://localhost:3306/carrental?characterEncoding=latin1&useConfigs=maxPerformance\n";
        private static String username = "root";
        private  static String password = "asdfzxcv123";

    public static ResultSet sendQuery(String query) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query); // Query is executed.
            return rs; // The ResultSet is being returned.
        } catch (SQLException | ClassNotFoundException| InputMismatchException e) {
            e.printStackTrace();
            System.out.println("Error in input for SQL functions!! Try again");
            Menu.mainMenu();
        }
        return null;
    }
    public static boolean executeQuery(String query)
    {
 try {
        // Sets up the connection to the DB
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, username, password);
        Statement st = con.createStatement();
        boolean rs = st.execute(query); // Query is executed.
        return rs; // The ResultSet is being returned.
    } catch (SQLException | ClassNotFoundException |InputMismatchException e) {
        e.printStackTrace();
        System.out.println("Error in input for SQL functions!! Try again");
        Menu.mainMenu();
    }
        return false; // Returns null in case of any exception.

    }
}
