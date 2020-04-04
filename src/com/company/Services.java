package com.company;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Services {
    //global scanner
    static Scanner console = new Scanner(System.in);

    //empty constructor
    public Services() {
    }

    //Methods to input the SQL Code to DB for retrieving or changing of information for Cars
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
        ResultSet rs=DBconnection.sendQuery("SELECT cars.car_id,brandmodels.brand,brandmodels.model,cars.reg_num,cars.reg_date,cars.mileage, \n" +
                "cartypes.car_type, cartypes.transmission,cartypes.air_con,cartypes.eng_volume,\n" +
                "cartypes.hp,cartypes.seats\n" +
                "FROM cars \n" +
                "join\n" +
                "cartypes on cartypes.carType_id = cars.carType_id\n" +
                "join brandmodels on cars.brandModel_id = brandmodels.brandModel_id\n" +
                "ORDER BY car_id;");
        try {
            while(rs.next())
            {
                System.out.println("|ID: "+rs.getString("car_id")+"|Brand: "+rs.getString("brand")+"|Model: "+rs.getString("model")+
                        "|Reg.Nr: "+rs.getString("reg_num")+"|Reg.Date"+rs.getString("reg_date")+
                        "|Mileage: " +rs.getString("mileage")+"|Car Type: " +rs.getString("car_type")+
                        "|Transmision:  " +rs.getString("transmission")+"|Air condition: " +rs.getString("air_con")+
                        "|Engine Volume: " +rs.getString("eng_volume")+"|Horse Power: " +rs.getString("hp")+
                        "|Seats Nr: " +rs.getString("seats"));
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    public void deleteCar() {
        displayCar();
        System.out.println("Type the ID of the car you want to delete: ");
        int user_input = console.nextInt();
        boolean deleted = DBconnection.executeQuery("DELETE FROM cars WHERE car_id = " + user_input + ";");
        if (deleted){
            System.out.println("Car with ID = " + user_input + " was deleted.");
        }else{
            System.out.println("This Car doesn't exist.");
        }
    }
    public void updateCar() {
        System.out.println("Which car do you want to change (Select ID)");
        displayCar();
        String choice_ID = console.next();
        System.out.println("You Chose To Change "+ choice_ID);

        System.out.println("|_____________________________|");
        System.out.println("|    Which Value To Update    |");
        System.out.println("|_____________________________|");
        System.out.println("|                             |");
        System.out.println("|       1.Brand ID            |");
        System.out.println("|       2.Registration Number |");
        System.out.println("|       3.Registration Date   |");
        System.out.println("|       4.Mileage             |");
        System.out.println("|       5.Car Type            |");
        System.out.println("|_____________________________|");
        System.out.println("           Enter number...    ");
        int choice = console.nextInt();
        System.out.println("Your ID choice was " + choice);

    }

    //Methods to input the SQL Code to DB for retrieving or changing of information for Customers
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
        ResultSet rs=DBconnection.sendQuery("SELECT customers.customer_id,customers.first_name,customers.last_name,customers.st_address,\n" +
                "customers.zip,zip_codes.city,zip_codes.country,\n" +
                "customers.mobile_phone,customers.addit_phone,customers.email,customers.driver_license,customers.driver_since\n" +
                "FROM customers \n" +
                "join\n" +
                "zip_codes\n" +
                "ON customers.zip = zip_codes.zip\n"+
                "ORDER BY customer_id;");
        try {
            while(rs.next())
            {
                System.out.println("|ID: "+rs.getString("customer_id")+"|First name: "+rs.getString("first_name")+
                        "|Last name: "+rs.getString("last_name")+
                        "|Adress: "+rs.getString("st_address")+"|Zip code"+rs.getString("zip")+
                        "|City: " +rs.getString("city")+"|Country: " +rs.getString("country")+
                        "|Phone:  " +rs.getString("mobile_phone")+"|Extra phone: " +rs.getString("addit_phone")+
                        "|E-mail: " +rs.getString("email")+"|Driver licence: " +rs.getString("driver_license")+
                        "|Driver since: " +rs.getString("driver_since"));
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

    }
    public void deleteCustomer() {
        displayCustomer();
        System.out.println("Type the ID of the Customer you want to delete: ");
        int user_input = console.nextInt();
        boolean deleted = DBconnection.executeQuery("DELETE FROM customers WHERE customer_id = " + user_input + ";");
        if (deleted){
            System.out.println("Customer with ID = " + user_input + " was deleted.");
        }else{
            System.out.println("This Customer doesn't exist.");
        }
    }
    public void updateCustomer() {


    }

    //Methods to input the SQL Code to DB for retrieving or changing of information for Rentals
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
        ResultSet rs=DBconnection.sendQuery("SELECT contracts.contract_id,customers.first_name,customers.last_name,customers.driver_license,cars.reg_num,contracts.start_date,\n" +
                "contracts.end_date,contracts.max_km,contracts.start_km\n" +
                "FROM contracts\n" +
                "JOIN\n" +
                "customers ON customers.customer_id = contracts.renter_id\n" +
                "JOIN \n" +
                "cars ON cars.car_id = contracts.car_id\n" +
                "ORDER BY contract_id;\n");
        try {
            while(rs.next())
            {
                System.out.println("|ID: "+rs.getString("contract_id")+"|First name: "+rs.getString("first_name")+
                        "|Last name: "+rs.getString("last_name")+ "|Licence: "+rs.getString("driver_license")+
                        "|Car reg.nr: "+rs.getString("reg_num")+"|From "+rs.getString("start_date")+
                                "|End date: " +rs.getString("end_date")+"|Available for: " +rs.getString("max_km")+ "km"+
                        "|Starting point: " +rs.getString("start_km"));
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }


    }
    public void deleteRental() {
        displayRental();
        System.out.println("Type the ID of the Contract you want to delete: ");
        int user_input = console.nextInt();
        boolean deleted = DBconnection.executeQuery("DELETE FROM contracts WHERE contract_id = " + user_input + ";");
        if (deleted){
            System.out.println("Contract with ID = " + user_input + " was deleted.");
        }else{
            System.out.println("This Contract doesn't exist.");
        }
    }
    public void updateRental() {
    }

    //Methods to input the SQL Code to DB for retrieving or changing of information for Zips
    public void createZips(){}
    public void displayZips(){}
    public void deleteZips(){}
    public void updateZips(){}

    //Methods to input the SQL Code to DB for retrieving or changing of information for brands
    public void createBrands(){}
    public void displayBrands(){}
    public void deleteBrands(){}
    public void updateBrands(){}
}
