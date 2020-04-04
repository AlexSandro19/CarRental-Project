package com.company;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Services {
    static Scanner console = new Scanner(System.in);

    public Services() {
    }

    public void createCar() {
        /*Method for creating car elements then adding them to the system
        */
        //User input for creating a car element
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

        //enters the user input into the db
        DBconnection.executeQuery("INSERT INTO cars(brandModel_id,reg_num,reg_date,mileage,carType_id)\n VALUES"+
                "(" + brand_id + ",\"" + reg_num + "\",\"" + reg_date + "\", " + mileage + ", " + car_type_id + ");");

    }

    public void displayCar() {
        //DISPLAT MODELS !!!! JUST FOR SHOW !!!!
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
        /*
           Method for creating a customer elements in the DB then adding them to the system
         */
    System.out.println("Enter first name:");
    String first_name=console.next();
    System.out.println("Enter family name: ");
    String last_name=console.next();
    System.out.println("Enter zip code: ");
    int zip=console.nextInt();
    console.nextLine();
    System.out.println("Enter address: ");
    String address=console.nextLine();
    System.out.println("Enter mobile number: ");
    String number=console.next();
    System.out.println("Enter alt. number: ");
    String alt_number=console.next();
    System.out.println("Enter email: ");
    String email=console.next();
    System.out.println("Enter driver licence number: ");
    String driver_license=console.next();
    System.out.println("Enter driver since date: ");
    String driver_since=console.next();

    //enters the user input into the DB
        DBconnection.executeQuery("INSERT INTO customers(first_name,last_name,st_address,zip,mobile_phone,addit_phone,email,driver_license,driver_since)\n " +
                "VALUES"+"(\""+first_name+"\",\""+last_name+"\",\""+address+"\","+zip+",\""+number+"\",\""+alt_number+"\",\""+
                email+"\",\""+driver_license+"\",\""+driver_since+"\");");
    }

    public void displayCustomer() {

    }

    public void deleteCustomer() {

    }

    public void updateCustomer() {


    }

    public void createRental() {
        System.out.println("Enter renter id: ");
        int renter_id=console.nextInt();
        System.out.println("Enter car id: ");
        int customer_id=console.nextInt();
        console.nextLine();
        System.out.println("Enter start date with hour(YYYY-MM-DD HH-MM-SS): ");
        String start_date=console.nextLine();
        System.out.println("Enter end date with hour(YYYY-MM-DD HH-MM-SS): ");
        String end_date=console.nextLine();
        System.out.println("Enter max km: ");
        int max_km=console.nextInt();
        System.out.println("Enter start_km: ");
        int start_km=console.nextInt();
        DBconnection.executeQuery("INSERT INTO contracts(renter_id,car_id,start_date,end_date,max_km,start_km) \n VALUES "+
                "("+renter_id+","+customer_id+",\""+start_date+"\",\""+end_date+"\","+max_km+","+start_km+");");
    }

    public void displayRental() {

    }

    public void deleteRental() {

    }

    public void updateRental() {
    }
}
