package com.company;

import java.sql.*;

public class DBconnection {
        private static String url = "jdbc:mysql://localhost:3306/carrental?characterEncoding=latin1&useConfigs=maxPerformance\n";
        private static String username = "";
        private  static String password = "";
        private static String schema="";

    public static ResultSet sendQuery(String query) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);
            Statement st = con.createStatement();
            st.execute("USE " + schema + ";");
            ResultSet rs = st.executeQuery(query); // Query is executed.
            return rs; // The ResultSet is being returned.
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    public  static boolean executeQuery(String query)
    {
 try {
        // Sets up the connection to the DB
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, username, password);
        Statement st = con.createStatement();
        st.execute("USE " + schema + ";");
        boolean rs = st.execute(query); // Query is executed.
        return rs; // The ResultSet is being returned.
    } catch (SQLException | ClassNotFoundException e) {
        e.printStackTrace();
    }
        return false; // Returns null in case of any exception.

    }
}
