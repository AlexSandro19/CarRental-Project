package com.company;

import java.sql.*;

public class Main {

    public static void main(String[] args)  {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/carrental?characterEncoding=latin1&useConfigs=maxPerformance\n";
            String user="root";
            String password="asdfzxcv123";
            Connection myConn = DriverManager.getConnection(url, user, password);
            Statement mySt= myConn.createStatement();
            ResultSet rs= mySt.executeQuery("SELECT * FROM cartypes");
            while (rs.next()) {
                System.out.println(rs.getString("carType_id")+rs.getString("car_type"));
            }
        }
        catch (SQLException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}
