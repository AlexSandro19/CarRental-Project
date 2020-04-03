package com.company;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Services {
    static Scanner console = new Scanner(System.in);

    public Services() {
    }

    public void createCar() {
        System.out.println("Enter brand ID:");
        int brand_id=console.nextInt();
        System.out.println("Enter Registration number: ");
        String reg_num=console.next();
        System.out.println("Enter Registration date(YYYY-MM-DD): ");
        String reg_date=console.next();
        System.out.println("Enter mileage: ");
        int mileage=console.nextInt();
        System.out.println("Enter car type: ");
        int car_type_id=console.nextInt();
        DBconnection.executeQuery("insert into cars VALUES\n"+
                "(" + brand_id + "," + reg_num + ",\"" + reg_date + "\", " + mileage + ", " +
                car_type_id + ",");
    }

    public void displayCar() {
        ResultSet rs=DBconnection.sendQuery("SELECT * FROM brandModels");
        try {
            while(rs.next())
            {
                System.out.println("|brand ID: "+rs.getString("brandModel_id")+
                        "|Brand: "+rs.getString("brand")+"|model"+rs.getString("model"));

            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void deleteCar() {

    }

    public void updateCar() {


    }

    public void createCustomer() {


    }

    public void displayCustomer() {

    }

    public void deleteCustomer() {

    }

    public void updateCustomer() {


    }

    public void createRental() {


    }

    public void displayRental() {

    }

    public void deleteRental() {

    }

    public void updateRental() {
    }
}
