package com.company;

    import java.util.Scanner;
    public class Menu {
        static Scanner console=new Scanner(System.in);
        public Menu()
            {
                mainMenu();
            }
        //Main UI methods
        public static void mainMenu()
        {
            System.out.println("|_____________________________|");
            System.out.println("|    Killua Car Dealership    |");
            System.out.println("|_____________________________|");
            System.out.println("|                             |");
            System.out.println("|            1.Cars           |");
            System.out.println("|            2.Customer       |");
            System.out.println("|            3.Rentals        |");
            System.out.println("|            4.Others         |");
            System.out.println("|            5.Quit           |");
            System.out.println("|_____________________________|");
            System.out.println("           Enter number...    ");
            String choice = console.next();

            switch (choice)
            {
                case "1":
                    carsMenu();
                    break;
                case "2":
                    customersMenu();
                    break;
                case "3":
                    rentalMenu();
                    break;
                case "4":
                    othersMenu();
                    break;
                case "5":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid user input try again pls");
                    mainMenu();
            }


        }
        //UI for cars
        public static void carsMenu()
        {
            System.out.println("|_____________________________|");
            System.out.println("|    Killua Car Dealership    |");
            System.out.println("|_____________________________|");
            System.out.println("|                             |");
            System.out.println("|           Cars Menu         |");
            System.out.println("|           1.Create          |");
            System.out.println("|           2.Display         |");
            System.out.println("|           3.Delete          |");
            System.out.println("|           4.Update          |");
            System.out.println("|           5.Back            |");
            System.out.println("|_____________________________|");
            System.out.println("           Enter number...    ");
            String choice =console.next();
            switch (choice)
            {
                case "1":
                    createCar();
                    carsMenu();
                    break;
                case "2":
                    System.out.println("Do you want to display (1)specific entry or (2)all");
                    String display=console.next();
                    if(display.equalsIgnoreCase("1"))
                    {
                        displayOneCar();
                    }
                    else if(display.equalsIgnoreCase("2")) {
                        displayCar();

                    }
                    else{
                        System.out.println("Wrong input!");
                    }
                    carsMenu();
                    break;
                case "3":
                    deleteCar();
                    carsMenu();
                    break;
                case "4":
                    updateCar();
                    carsMenu();
                    break;
                case "5":
                    mainMenu();
                    break;
                default:
                    System.out.println("Invalid user input try again pls");
                    carsMenu();

            }

        }
        //UI for customers
        public static void customersMenu()
        {
            System.out.println("|_____________________________|");
            System.out.println("|    Killua Car Dealership    |");
            System.out.println("|_____________________________|");
            System.out.println("|                             |");
            System.out.println("|        Customers Menu       |");
            System.out.println("|           1.Create          |");
            System.out.println("|           2.Display         |");
            System.out.println("|           3.Delete          |");
            System.out.println("|           4.Update          |");
            System.out.println("|           5.Back            |");
            System.out.println("|_____________________________|");
            System.out.println("           Enter number...    ");
            String choice =console.next();

            switch (choice)
            {
                case "1":
                    createCustomer();
                    customersMenu();
                    break;
                case "2":    System.out.println("Do you want to display (1)specific entry or (2)all");
                    String display=console.next();
                    if(display.equalsIgnoreCase("1"))
                    {
                        displayOneCustomer();
                    }
                    else if(display.equalsIgnoreCase("2")) {
                        displayCustomer();
                    }
                    else{
                        System.out.println("Wrong input!");
                    }
                    customersMenu();
                    break;
                case "3":
                    deleteCustomer();
                    customersMenu();
                    break;
                case "4":
                    updateCustomer();
                    customersMenu();
                    break;
                case "5":
                    mainMenu();
                    break;
                default:
                    System.out.println("Invalid user input try again pls");
                    customersMenu();


            }

        }

        //UI for rentals
        public static void rentalMenu()
        {
            System.out.println("|_____________________________|");
            System.out.println("|    Killua Car Dealership    |");
            System.out.println("|_____________________________|");
            System.out.println("|                             |");
            System.out.println("|         Rentals Menu        |");
            System.out.println("|           1.Create          |");
            System.out.println("|           2.Display         |");
            System.out.println("|           3.Delete          |");
            System.out.println("|           4.Update          |");
            System.out.println("|           5.Back            |");
            System.out.println("|_____________________________|");
            System.out.println("           Enter number...    ");
            String choice =console.next();
            switch (choice)
            {
                case "1":
                    createRental();
                    rentalMenu();
                    break;
                case "2":
                    System.out.println("Do you want to display (1)specific entry or (2)all");
                    String display=console.next();
                    if(display.equalsIgnoreCase("1"))
                    {
                        displayOneRental();
                    }
                        else if(display.equalsIgnoreCase("2")) {
                    displayRental();
                }
                        else{
                            System.out.println("Wrong input!");
                    }
                    rentalMenu();
                    break;
                case "3":
                    deleteRental();
                    rentalMenu();
                    break;
                case "4":
                    updateRental();
                    rentalMenu();
                    break;
                case "5":
                    mainMenu();
                    break;
                default:
                    System.out.println("Invalid user input try again pls");
                    rentalMenu();

            }

        }
        //UI other smaller needs of the system(Zips, Brands)
        public static void othersMenu()
        {
            System.out.println("|_____________________________|");
            System.out.println("|    Killua Car Dealership    |");
            System.out.println("|_____________________________|");
            System.out.println("|           Others Menu       |");
            System.out.println("|            1.Zips           |");
            System.out.println("|            2.Brands         |");
            System.out.println("|            3.Car Types      |");
            System.out.println("|            4.Back           |");
            System.out.println("|_____________________________|");
            System.out.println("           Enter number...    ");
            String choice= console.next();
            switch (choice)
            {
                case "1":
                    zipsMenu();
                    break;
                case "2":
                    brandsMenu();
                    break;
                case "3":
                    typesMenu();
                    break;
                case "4":
                    mainMenu();
                    break;
                default:
                    System.out.println("Invalid user input try again pls");
                    othersMenu();
            }

        }
        //UI for zips
        public static void zipsMenu()
        {
            System.out.println("|_____________________________|");
            System.out.println("|    Killua Car Dealership    |");
            System.out.println("|_____________________________|");
            System.out.println("|           Zips Menu         |");
            System.out.println("|            1.Create         |");
            System.out.println("|            2.Display        |");
            System.out.println("|            3.Delete         |");
            System.out.println("|            4.Update         |");
            System.out.println("|            5.Back           |");
            System.out.println("|_____________________________|");
            System.out.println("           Enter number...    ");
            String choice= console.next();
            switch (choice)
            {
                case "1":
                    createZips();
                    zipsMenu();
                    break;
                case "2":
                    displayZips();
                    zipsMenu();
                    break;
                case "3":
                    deleteZips();
                    zipsMenu();
                    break;
                case "4":
                    updateZips();
                    zipsMenu();
                    break;
                case "5":
                    othersMenu();
                    break;
                default:
                    System.out.println("Invalid user input try again pls");
                    zipsMenu();
            }
        }
        public static void brandsMenu()
        {
            System.out.println("|_____________________________|");
            System.out.println("|    Killua Car Dealership    |");
            System.out.println("|_____________________________|");
            System.out.println("|           Brands Menu       |");
            System.out.println("|            1.Create         |");
            System.out.println("|            2.Display        |");
            System.out.println("|            3.Delete         |");
            System.out.println("|            4.Update         |");
            System.out.println("|            5.Back           |");
            System.out.println("|_____________________________|");
            System.out.println("           Enter number...    ");
            String choice= console.next();
            switch (choice)
            {
                case "1":
                    createBrands();
                    brandsMenu();
                    break;
                case "2":
                    displayBrands();
                    brandsMenu();
                    break;
                case "3":
                    deleteBrands();
                    brandsMenu();
                    break;
                case "4":
                    updateBrands();
                    brandsMenu();
                    break;
                case "5":
                    othersMenu();
                    break;
                default:
                    System.out.println("Invalid user input try again pls");
                    brandsMenu();
            }

        }

        public static void typesMenu(){
            System.out.println("|_____________________________|");
            System.out.println("|    Killua Car Dealership    |");
            System.out.println("|_____________________________|");
            System.out.println("|           Car Types Menu    |");
            System.out.println("|            1.Create         |");
            System.out.println("|            2.Display        |");
            System.out.println("|            3.Delete         |");
            System.out.println("|            4.Update         |");
            System.out.println("|            5.Back           |");
            System.out.println("|_____________________________|");
            System.out.println("           Enter number...    ");
            String choice= console.next();
            switch (choice){
                case "1":
                    createTypes();
                    typesMenu();
                    break;
                case "2":
                    displayTypes();
                    typesMenu();
                    break;
                case "3":
                    deleteTypes();
                    typesMenu();
                    break;
                case "4":
                    updateTypes();
                    typesMenu();
                    break;
                case "5":
                    othersMenu();
                    break;
                default:
                    System.out.println("Invalid user input try again pls");
                    typesMenu();

            }

        }


        //Methods for displaying, creating, deleting, updating cars
        public static void createCar()
        { Main.getController().createCar();
        }
        public static void displayCar()
        { Main.getController().displayCar();
        }
        public static void displayOneCar()
        {Main.getController().displayOneCar();}
        public static void deleteCar()
        {
            System.out.println();
            Main.getController().deleteCar();
        }
        public static void updateCar()
        { Main.getController().updateCar();
        }

        //Methods for displaying, creating, deleting, updating customers
        public static void createCustomer()
        { Main.getController().createCustomer();
        }
        public static void displayCustomer()
        { Main.getController().displayCustomer();
        }
        public static void displayOneCustomer()
        {Main.getController().displayOneCustomer();}
        public static void deleteCustomer()
        {
            System.out.println();
            Main.getController().deleteCustomer();
        }
        public  static void updateCustomer()
        { Main.getController().updateCustomer();
        }


        //Methods for displaying, creating, deleting, updating rentals
        public static void createRental()
        {
            Main.getController().createRental();
        }
        public static  void displayRental()
        {
            Main.getController().displayRental();
        }
        public static void displayOneRental()
        {Main.getController().displayOneRental();}
        public static void deleteRental()
        {
            System.out.println();
            Main.getController().deleteRental();
        }
        public  static void updateRental()
        {
            Main.getController().updateRental();
        }
        //Methods for displaying, creating, deleting, updating zips
        public static void createZips()
        {
            Main.getController().createZips();
        }
        public static void displayZips()
        {
            Main.getController().displayZips();
        }
        public static void deleteZips()
        {
            Main.getController().deleteZips();
        }
        public static void updateZips()
        {
            Main.getController().updateZips();
        }
        //Methods for displaying, creating, deleting, updating brands
        public static void createBrands(){Main.getController().createBrands();}
        public static void  displayBrands(){Main.getController().displayBrands();}
        public  static void deleteBrands(){Main.getController().deleteBrands();}
        public  static void updateBrands(){Main.getController().updateBrands();}

        //Methods for displaying, creating, deleting, updating car types
        public static void createTypes(){Main.getController().createTypes();}
        public static void displayTypes(){Main.getController().displayTypes();}
        public static void deleteTypes(){Main.getController().deleteTypes();}
        public static void updateTypes(){Main.getController().updateTypes();}
    }


