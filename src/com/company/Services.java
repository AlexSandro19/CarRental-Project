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
                System.out.printf("%5s%-3s%-7s%-15s%-10s%-10s%8s%-10s%-11s%-12s%9s%-6s%10s%-10s%13s%10s%15s%2s%10s%4s%12s%4s%12s%2s\n","|ID: ",rs.getString("car_id"),"|Brand: ",rs.getString("brand"),"|Model: ",rs.getString("model"),
                        "|Reg.Nr: ",rs.getString("reg_num"),"|Reg.Date: ",rs.getString("reg_date"),
                        "|Mileage: " ,rs.getString("mileage"),"|Car Type: " ,rs.getString("car_type"),
                        "|Transmision:  " ,rs.getString("transmission"),"|Air condition: " ,rs.getString("air_con"),
                        "|Engine Volume: " ,rs.getString("eng_volume"),"|Horse Power: " ,rs.getString("hp"),
                        "|Seats Nr: " ,rs.getString("seats"));
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
        System.out.println("Choose The ID of the car you want to update");
        displayCar();
        String choice_ID = console.next();
        System.out.println("You Chose To Change "+ choice_ID);
        System.out.println("|_____________________________|");
        System.out.println("|    Which Value To Update    |");
        System.out.println("|_____________________________|");
        System.out.println("|                             |");
        System.out.println("|    1.Registration Number    |");
        System.out.println("|    2.Registration Date      |");
        System.out.println("|    3.Mileage                |");
        System.out.println("|    0.Cancel                 |");
        System.out.println("|_____________________________|");
        System.out.println("           Enter number...    ");
        String choice = console.next();
        System.out.println("Your choice was " + choice);

        switch (choice)
        {
            case "1":
                //Registration Number
                System.out.println("Type The New Registration Number");
                String newRegNumber = console.next();
                DBconnection.executeQuery("UPDATE cars SET reg_num = '" + newRegNumber +"' WHERE car_id = " + choice_ID + ";");
                System.out.println("The Car with the id " + choice_ID + " reg_number was updated" );
                break;
            case "2":
                //Registration Date
                System.out.println("Type The New Registration Date YYYY-MM-DD");
                String newRegDate = console.next();
                DBconnection.executeQuery("UPDATE cars SET reg_date = '" + newRegDate +"' WHERE car_id = " + choice_ID + ";");
                System.out.println("The Car with the id " + choice_ID + " reg_date was updated" );
                break;
            case "3":
                //Mileage
                System.out.println("Type The New Mileage ");
                int newMileage = console.nextInt();
                DBconnection.executeQuery("UPDATE cars SET mileage = '" + newMileage +"' WHERE car_id = " + choice_ID + ";");
                System.out.println("The Car with the id " + choice_ID + " mileage was updated" );
                break;
            case "0":
                System.out.println("No Action Has Been Done");
                break;
            default:
                System.out.println("Invalid User Input ");
                updateCar();
            //I'll add the foreign keys later
        }

    }

    //Methods to input the SQL Code to DB for retrieving or changing of information for Customers
    public void createCustomer() {
        /*
           Method for creating a customer elements in the DB then adding them to the system
         */
        System.out.println("Enter first name:");
        String first_name=console.nextLine();
        System.out.println("Enter family name: ");
        String last_name=console.nextLine();
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
        System.out.println("Enter driver since date(YYYY-MM-DD): ");
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
                System.out.printf(" %5s%-3s%-15s%-10s%15s%-10s%8s%-25s%9s%-5s%6s%-15s%9s%-15s%7s%10s%15s%10s%8s%20s%16s%9s%13s%15s\n","|ID: ",rs.getString("customer_id"),"|First name: ",rs.getString("first_name"),
                        "|Last name: ",rs.getString("last_name"),
                        "|Adress: ",rs.getString("st_address"),"|Zip code ",rs.getString("zip"),
                        "|City: " ,rs.getString("city"),"|Country: " ,rs.getString("country"),
                        "|Phone:  ",rs.getString("mobile_phone"),"|Extra phone: ",rs.getString("addit_phone"),
                        "|E-mail: ",rs.getString("email"),"|Driver licence: " ,rs.getString("driver_license"),
                        "|Driver since: ",rs.getString("driver_since"));
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
        System.out.println("Choose The ID of the customer you want to update");
        displayCustomer();
        String choice_ID = console.next();
        System.out.println("You Chose To Change "+ choice_ID);
        System.out.println("|_____________________________|");
        System.out.println("|    Which Value To Update    |");
        System.out.println("|_____________________________|");
        System.out.println("|                             |");
        System.out.println("|    1.First Name             |");
        System.out.println("|    2.Last Name              |");
        System.out.println("|    3.Street Address         |");
        System.out.println("|    4.ZIP Code               |");
        System.out.println("|    5.Mobile Phone           |");
        System.out.println("|    6.Additional Phone       |");
        System.out.println("|    7.Email                  |");
        System.out.println("|    8.Driver License         |");
        System.out.println("|    9.Driver Since           |");
        System.out.println("|    0.Cancel                 |");
        System.out.println("|_____________________________|");
        System.out.println("           Enter number...    ");
        String choice = console.next();
        System.out.println("Your choice was " + choice);

        switch (choice) {
            case "1":
                //Update First Name
                System.out.println("Type The New First Name");
                String newTemp = console.nextLine();
                DBconnection.executeQuery("UPDATE customers SET first_name = '" + newTemp +"' WHERE customer_id = " + choice_ID + ";");
                System.out.println("The Customer with the id " + choice_ID + " First Name has been updated" );
                break;
            case "2":
                //Update Last Name
                System.out.println("Type The New Last Name");
                newTemp = console.nextLine();
                DBconnection.executeQuery("UPDATE customers SET last_name = '" + newTemp +"' WHERE customer_id = " + choice_ID + ";");
                System.out.println("The Customer with the id " + choice_ID + " Last Name has been updated" );
                break;
            case "3":
                //Update Street Address
                System.out.println("Type The New Street Address");
                newTemp = console.nextLine();
                DBconnection.executeQuery("UPDATE customers SET st_address = '" + newTemp +"' WHERE customer_id = " + choice_ID + ";");
                System.out.println("The Customer with the id " + choice_ID + " Street Address has been updated" );
                break;
            case "4":
                //Update Zip Code
                System.out.println("Type The ZIP Code");
                int Temp = console.nextInt();
                DBconnection.executeQuery("UPDATE customers SET zip = '" + Temp +"' WHERE customer_id = " + choice_ID + ";");
                System.out.println("The Customer with the id " + choice_ID + " ZIP has been updated" );
                break;
            case "5":
                //Update Mobile Phone
                System.out.println("Type The New Mobile Phone");
                newTemp = console.next();
                DBconnection.executeQuery("UPDATE customers SET mobile_phone = '" + newTemp +"' WHERE customer_id = " + choice_ID + ";");
                System.out.println("The Customer with the id " + choice_ID + " Mobile Phone has been updated" );
                break;
            case "6":
                //Update Addit Phone
                System.out.println("Type The New Additional Phone");
                newTemp = console.next();
                DBconnection.executeQuery("UPDATE customers SET addit_phone = '" + newTemp +"' WHERE customer_id = " + choice_ID + ";");
                System.out.println("The Customer with the id " + choice_ID + " Additional Phone has been updated" );
                break;
            case "7":
                //Update Email
                System.out.println("Type The New Customer Email");
                newTemp = console.next();
                DBconnection.executeQuery("UPDATE customers SET email = '" + newTemp +"' WHERE customer_id = " + choice_ID + ";");
                System.out.println("The Customer with the id " + choice_ID + " Email has been updated" );
                break;
            case "8":
                //Update Driver License
                System.out.println("Type The New Customer Driver License ID");
                newTemp = console.next();
                DBconnection.executeQuery("UPDATE customers SET license = '" + newTemp +"' WHERE customer_id = " + choice_ID + ";");
                System.out.println("The Customer with the id " + choice_ID + " Driver License ID has been updated" );
                break;
            case "9":
                System.out.println("Type The New Customer Driver Since Date (YYYY-MM-DD): ");
                newTemp = console.next();
                DBconnection.executeQuery("UPDATE customers SET driver_since = '" + newTemp +"' WHERE customer_id = " + choice_ID + ";");
                System.out.println("The Customer with the id " + choice_ID + " Driver Since date has been updated" );
                break;
            case "0":
                System.out.println("No Action Has Been Performed");
                break;
            default:
                System.out.println("Invalid User Input ");
                updateCustomer();

        }

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
        System.out.println("Enter start km before use: ");
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
                System.out.printf(" %5s%-3s%15s%-10s%15s%10s%10s%-15s%9s%10s%15s%5s%5s%5s%5s%5s%5s%5s%5s\n","|ID: ",rs.getString("contract_id"),"|First name: ", rs.getString("first_name"),
                        "|Last name: ",rs.getString("last_name"), "|Licence: ",rs.getString("driver_license"),
                        "|Car reg.nr: ",rs.getString("reg_num"),"|From ",rs.getString("start_date"),
                        "|End date: " ,rs.getString("end_date"),"|Available for: " ,rs.getString("max_km"), "km",
                        "|Starting point: " ,rs.getString("start_km"));
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
        System.out.println("Choose The ID of the Rental Contract you want to update");
        displayRental();
        String choice_ID = console.next();
        System.out.println("You Chose To Change "+ choice_ID);
        System.out.println("|_____________________________|");
        System.out.println("|    Which Value To Update    |");
        System.out.println("|_____________________________|");
        System.out.println("|                             |");
        System.out.println("|    1.Start Date             |");
        System.out.println("|    2.End Date               |");
        System.out.println("|    3.Max km                 |");
        System.out.println("|    4.Start km               |");
        System.out.println("|    0.Cancel                 |");
        System.out.println("|_____________________________|");
        System.out.println("           Enter number...    ");
        String choice = console.next();
        System.out.println("Your choice was " + choice);

        switch (choice) {
            case "1":
                System.out.println("Type The New Start Date yyyy-mm-dd hh:mm:ss");
                String newTemp = console.nextLine();
                DBconnection.executeQuery("UPDATE contracts SET start_date = '" + newTemp +"' WHERE contract_id = " + choice_ID + ";");
                System.out.println("The Contract with the id " + choice_ID + " Start Date has been updated" );
                break;
            case "2":
                System.out.println("Type The New End Date yyyy-mm-dd hh:mm:ss");
                newTemp = console.nextLine();
                DBconnection.executeQuery("UPDATE contracts SET end_date = '" + newTemp +"' WHERE contract_id = " + choice_ID + ";");
                System.out.println("The Contract with the id " + choice_ID + " End Date has been updated" );
                break;
            case "3":
                System.out.println("Type The New Max km");
                int temp = console.nextInt();
                DBconnection.executeQuery("UPDATE contracts SET max_km = '" + temp +"' WHERE contract_id = " + choice_ID + ";");
                System.out.println("The Contract with the id " + choice_ID + " Max kilometers has been updated" );
                break;
            case "4":
                System.out.println("Type The New Start km before use: ");
                temp = console.nextInt();
                DBconnection.executeQuery("UPDATE contracts SET start_km = '" + temp +"' WHERE contract_id = " + choice_ID + ";");
                System.out.println("The Contract with the id " + choice_ID + " Start kilometers has been updated" );
                break;
            case "0":
                System.out.println("No Action Has Been Performed");
                break;
            default:
                System.out.println("Invalid User Input ");
                updateRental();
        }
    }

    //Methods to input the SQL Code to DB for retrieving or changing of information for Zips
    public void createZips(){
        boolean already_exists;
        boolean created = false;
        System.out.println("Type the new Zip-Code: ");
        String zip = console.next();
        System.out.println("Type the new City: ");
        String city = console.next();
        System.out.println("Type the new Country: ");
        String country = console.next();
       // already_exists = DBconnection.executeQuery("SELECT * FROM zip_codes WHERE zip = " + zip + ";");
       // if (already_exists){
        //    System.out.println("This Zip-Code already exists.");
        //}else {
            created = DBconnection.executeQuery("INSERT INTO zip_codes(zip,city,country) VALUES (" + zip + ",\" " + city + "\", \"" + country + "\");");
       // }
        if (created){
            System.out.println("New Zip-Code was added to the table.");
        }


    }
    public void displayZips(){
        ResultSet rs = DBconnection.sendQuery("SELECT * FROM zip_codes;");
        try{
           while(rs.next()){
               System.out.println("|ID: " + rs.getString("zip") + "|City: " + rs.getString("city") + "|Country: " +
                       rs.getString("country"));
           }
        }catch(SQLException e){
            e.printStackTrace();
        }

    }
    public void deleteZips(){
        displayZips();
        System.out.println("Type the Zip-Code you want to delete: ");
        int user_input = console.nextInt();
        DBconnection.executeQuery("DELETE FROM contracts WHERE zip = " + user_input + ";");

        System.out.println("Zip-Code = " + user_input + " was deleted.");
    }
    public void updateZips(){
        boolean updated = false;
        String city;
        String country;
        displayZips();
        System.out.println("Type the Zip-Code you want to update: ");
        int toUpdate = console.nextInt();
        System.out.println("|_____________________________|");
        System.out.println("|    Which Value To Update    |");
        System.out.println("|_____________________________|");
        System.out.println("|                             |");
        System.out.println("|       1. City               |");
        System.out.println("|       2. Country            |");
        System.out.println("|       3. City & Country     |");
        System.out.println("|       4. Cancel             |");
        System.out.println("|_____________________________|");
        System.out.println("        Enter number...    ");
        String choice = console.next();
        switch (choice){
            case "1":
                System.out.println( "Type the new City: ");
                city = console.nextLine();
                DBconnection.executeQuery("UPDATE zip_codes " + "SET city = \"" + city + "\" WHERE zip = " + toUpdate + ";");
                break;
            case "2":
                System.out.println( "Type the new Country: ");
                country = console.nextLine();
                DBconnection.executeQuery("UPDATE zip_codes " + "SET country = \"" + country + "\" WHERE zip = " + toUpdate + ";");
                break;
            case "3":
                System.out.println( "Type the new City: ");
                city = console.nextLine();
                System.out.println( "Type the new Country: ");
                country = console.nextLine();
                DBconnection.executeQuery("UPDATE zip_codes " + "SET city = \"" + city + "\", country = \"" + country +
                                                    "\" WHERE zip = " + toUpdate + ";");
                break;
            case "4":
                System.out.println("No Action Has Been Performed");
                break;
            default:
                System.out.println("Wrong input.");
        }

        System.out.println("Zip-Code = " + toUpdate + ", was updated.");
        ResultSet rs = DBconnection.sendQuery("SELECT * FROM zip_codes WHERE zip = " + toUpdate + ";");
        try{
            while(rs.next()){
                System.out.println("|ID: " + rs.getString("zip") + "|City: " + rs.getString("city") + "|Country: " +
                        rs.getString("country"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }


    }

    //Methods to input the SQL Code to DB for retrieving or changing of information for brands
    public void createBrands(){
        System.out.println("Enter brand:");
        String brand=console.next();
        System.out.println("Enter model: ");
        String model=console.nextLine();

        DBconnection.executeQuery("INSERT INTO brandModels(brand,model)\nVALUES (\""+brand+"\",\""+model+"\");");
        System.out.println("New brand has been added!");
    }
    public void displayBrands(){
        ResultSet rs=DBconnection.sendQuery("SELECT * FROM brandModels;");
        try{
            while(rs.next())
            {
                System.out.println("|ID: "+rs.getString("brandModel_id")+"|Brand: "+rs.getString("brand")+
                        "|Model: "+rs.getString("model"));
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

    }
    public void deleteBrands(){
    displayBrands();
    System.out.println("Enter ID for which brand do you want to delete: ");
    int brand_id=console.nextInt();
    boolean deleted=DBconnection.executeQuery("DELETE FROM brandModels WHERE brandModel_id="+brand_id);
    if(deleted)
    {
        System.out.println("Brand with "+brand_id+" id has been deleted.");
    }
    else {
        System.out.println("The brand does not exist");
    }
    }
    public void updateBrands()
    {
        //updates the information in brands through user input and choices
        String temp;
        displayBrands();
        System.out.println("Choose The ID of the Brand you want to update");
        String choice_ID = console.next();

        System.out.println("You Chose To Change "+ choice_ID);
        System.out.println("|_____________________________|");
        System.out.println("|    Which Value To Update    |");
        System.out.println("|_____________________________|");
        System.out.println("|                             |");
        System.out.println("|          1. Brand           |");
        System.out.println("|          2. Model           |");
        System.out.println("|          3. Cancel          |");
        System.out.println("|_____________________________|");
        String choice_update=console.next();
        switch (choice_update)
        {
            case "1":
                System.out.println("Enter new brand name: ");
                temp=console.nextLine();
                DBconnection.executeQuery("UPDATE brandModels SET brand = \"" + temp + "\" WHERE brandModel_id = "+choice_ID+";");
                break;
            case "2":
                System.out.println("Enter new model name: ");
                temp=console.nextLine();
                DBconnection.executeQuery("UPDATE brandModels SET model = \"" + temp + "\" WHERE brandModel_id = "+choice_ID+";");
                break;
            case "3":
                System.out.println("No action has been performed!");
                break;
            default:
                System.out.println("Wrong input try again!");
                updateBrands();
        }

    }

    //Methods to input the SQL Code to DB for retrieving or changing of information for car Types
    public void createTypes(){
        System.out.println("Type in the Car Type:");
        String car_type = console.next();
        System.out.println("Type in the Transmission Type:");
        String transmission = console.next();
        System.out.println("Type in the Engine Volume:");
        String eng_volume = console.next();
        System.out.println("Type in if the car has Air Conditioner (1 for Yes // 0 for No):");
        String air_con = console.next();
        System.out.println("Type in if the car has Cruise Control (1 for Yes // 0 for No):");
        String cruise_control = console.next();
        System.out.println("Type in info about seats (number or material): ");
        String seats = console.next();
        System.out.println("Type in how much Horse Power the car has: ");
        String hp = console.next();
        DBconnection.executeQuery("INSERT INTO cartypes (car_type, transmission, eng_volume, air_con, cruise_control, seats, hp)\n" +
                                                    "VALUES (\"" + car_type + "\", \"" + transmission + "\", " + eng_volume + ", " + air_con + ", " +
                                                    cruise_control + ", \"" + seats + "\", " + hp + ");");
        System.out.println("New Car Type was added to the table.");

    }
    public void displayTypes(){
        ResultSet rs = DBconnection.sendQuery("SELECT * FROM cartypes;");
        try{
            while(rs.next()){
                String  str = "|ID: " + rs.getString("carType_id") + "|Car Type: " + rs.getString("car_type") +
                                   "|Transmission: " + rs.getString("transmission") + "|Engine Volume:" + rs.getString("eng_volume");
                String air_con = rs.getString("air_con");
                if (air_con.equals("1")){
                    str = str + "|Air Conditioner: Yes";
                }else {
                    str = str + "|Air Conditioner: No";
                }
                String cruise_control = rs.getString("cruise_control");
                if (cruise_control.equals("1")){
                    str = str + "|Cruise Control: Yes";
                }else {
                    str = str + "|Cruise Control: No";
                }
                str = str + "|Seats: " + rs.getString("seats") + "|Horse Power: " + rs.getString("hp");
                System.out.println(str);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }

    }
    public void deleteTypes(){
        displayTypes();
        System.out.println("Write the ID of Car Type you want to delete: ");
        String user_input = console.next();
        DBconnection.executeQuery("DELETE FROM cartypes WHERE carType_id = " + user_input + ";");
        System.out.println("Car Type with ID = " + user_input + " was deleted.");
    }
    public void updateTypes(){
        String temp;
        System.out.println("Choose The ID of the Car Type you want to update");
        displayTypes();
        String choice_ID = console.next();
        System.out.println("You Chose To Change "+ choice_ID);
        System.out.println("|_____________________________|");
        System.out.println("|    Which Value To Update    |");
        System.out.println("|_____________________________|");
        System.out.println("|                             |");
        System.out.println("|    1. Type                  |");
        System.out.println("|    2. Transmission Type     |");
        System.out.println("|    3. Engine Volume         |");
        System.out.println("|    4. Air Conditioner       |");
        System.out.println("|    5. Cruise Control        |");
        System.out.println("|    6. Seats Specifications  |");
        System.out.println("|    7. Horsepower            |");
        System.out.println("|    0. Cancel                |");
        System.out.println("|_____________________________|");
        System.out.println("           Enter number...    ");
        String choice = console.next();
        System.out.println("Your choice was " + choice);

        switch(choice){
            case "1":
                System.out.println("Enter new Type: ");
                temp = console.next();
                DBconnection.executeQuery("UPDATE cartypes SET car_type = \"" + temp + "\" WHERE carType_id = " + choice_ID + ";");
                break;
            case "2":
                System.out.println("Enter new Transmission Type: ");
                temp = console.next();
                DBconnection.executeQuery("UPDATE cartypes SET transmission = \"" + temp + "\" WHERE carType_id = " + choice_ID + ";");
                break;
            case "3":
                System.out.println("Enter new Engine Volume (in cc): ");
                temp = console.next();
                DBconnection.executeQuery("UPDATE cartypes SET eng_volume = " + temp + " WHERE carType_id = " + choice_ID + ";");
                break;
            case "4":
                System.out.println("Enter if Air Conditioner is present (1 for Yes // 0 for No): ");
                temp= console.next();
                DBconnection.executeQuery("UPDATE cartypes SET air_con = " + temp + " WHERE carType_id = " + choice_ID + ";");
                break;
            case "5":
                System.out.println("Enter if Cruise Control is present (1 for Yes // 0 for No): ");
                temp= console.next();
                DBconnection.executeQuery("UPDATE cartypes SET cruise_control = " + temp + " WHERE carType_id = " + choice_ID + ";");
                break;
            case "6":
                System.out.println("Enter new Seats Specifications (number of seats or material): ");
                temp= console.next();
                DBconnection.executeQuery("UPDATE cartypes SET seats = \"" + temp + "\" WHERE carType_id = " + choice_ID + ";");
                break;
            case "7":
                System.out.println("Enter new Horsepower: ");
                temp= console.next();
                DBconnection.executeQuery("UPDATE cartypes SET hp = " + temp + " WHERE carType_id = " + choice_ID + ";");
                break;
            case "0":
                System.out.println("No Action Has Been Performed");
                break;
            default:
                System.out.println("Wrong input.");
        }

        System.out.println("Car Type with ID  = " + choice_ID + ", was updated.");
        ResultSet rs = DBconnection.sendQuery("SELECT * FROM cartypes WHERE carType_id = " + choice_ID + ";");

        try{
            while(rs.next()){
                String  str = "|ID: " + rs.getString("carType_id") + "|Car Type: " + rs.getString("car_type") +
                        "|Transmission: " + rs.getString("transmission") + "|Engine Volume:" + rs.getString("eng_volume");
                String air_con = rs.getString("air_con");
                if (air_con.equals("1")){
                    str = str + "|Air Conditioner: Yes";
                }else {
                    str = str + "|Air Conditioner: No";
                }
                String cruise_control = rs.getString("cruise_control");
                if (cruise_control.equals("1")){
                    str = str + "|Cruise Control: Yes";
                }else {
                    str = str + "|Cruise Control: No";
                }
                str = str + "|Seats: " + rs.getString("seats") + "|Horse Power: " + rs.getString("hp");
                System.out.println(str);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void displayOneCar() {
        //displays one specific car which the user choose through console input
        int choice = 0;
        System.out.println("Choose the ID of the car you want to search ");
        choice = console.nextInt();
        ResultSet rs = DBconnection.sendQuery("SELECT cars.car_id,brandmodels.brand,\n" +
                "brandmodels.model,cars.reg_num,cars.reg_date,cars.mileage,\n" +
                "cartypes.car_type, cartypes.transmission,cartypes.air_con,cartypes.eng_volume,\n" +
                "cartypes.hp,cartypes.seats\n" +
                "FROM cars \n" +
                "join\n" +
                "cartypes on cartypes.carType_id = cars.carType_id\n" +
                "join brandmodels on cars.brandModel_id = brandmodels.brandModel_id\n" +
                "where cars.car_id = " + choice);
        try {
            while (rs.next()) {
                System.out.println("|ID: " + rs.getString("car_id") + "|Brand: " + rs.getString("brand") + "|Model: " + rs.getString("model") +
                        "|Reg.Nr: " + rs.getString("reg_num") + "|Reg.Date" + rs.getString("reg_date") +
                        "|Mileage: " + rs.getString("mileage") + "|Car Type: " + rs.getString("car_type") +
                        "|Transmision:  " + rs.getString("transmission") + "|Air condition: " + rs.getString("air_con") +
                        "|Engine Volume: " + rs.getString("eng_volume") + "|Horse Power: " + rs.getString("hp") +
                        "|Seats Nr: " + rs.getString("seats"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void displayOneCustomer(){
        //displays one specific customer which the user choose through console input
        System.out.println("Choose the driver licence of the customer you want to search ");
        int choice = console.nextInt();
        ResultSet rs=DBconnection.sendQuery("SELECT customers.customer_id,customers.first_name,customers.last_name,customers.st_address,\n" +
                "customers.zip,zip_codes.city,zip_codes.country,\n" +
                "customers.mobile_phone,customers.addit_phone,customers.email,customers.driver_license,customers.driver_since\n" +
                "FROM customers \n" +
                "join\n" +
                "zip_codes\n" +
                "ON customers.zip = zip_codes.zip\n"+
                "Where customers.driver_licence = " + choice);
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
    public void displayOneRental() {
        //displays one specific rental which the user choose through console input
        System.out.println("Choose the contract ID you want to search ");
        int choice = console.nextInt();
        ResultSet rs=DBconnection.sendQuery("SELECT contracts.contract_id,customers.first_name,customers.last_name,customers.driver_license,cars.reg_num,contracts.start_date,\n" +
                "contracts.end_date,contracts.max_km,contracts.start_km\n" +
                "FROM contracts\n" +
                "JOIN\n" +
                "customers ON customers.customer_id = contracts.renter_id\n" +
                "JOIN \n" +
                "cars ON cars.car_id = contracts.car_id\n" +
                "Where contracts.contract_id = " + choice);
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
}

