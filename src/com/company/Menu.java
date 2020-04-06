package com.company;

    import java.util.Scanner;
    public class Menu {
        static Scanner console=new Scanner(System.in);
        public Menu()
            {
                mainMenu();
            }
        //Main UI methods
        public void mainMenu()
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
        public void carsMenu()
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
                    displayCar();
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

        public void customersMenu()
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
                case "2":
                    displayCustomer();
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


        public void rentalMenu()
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
                    displayRental();
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
        public void othersMenu()
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
                case 3:
                    typesMenu();
                    break;
                case 4:
                    mainMenu();
                    break;
                default:
                    System.out.println("Invalid user input try again pls");
                    othersMenu();
            }

        }
        public void zipsMenu()
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

        public void brandsMenu()
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

        public void typesMenu(){
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
        public void createCar()
        {
            Main.getController().createCar();
        }
        public void displayCar()
        {
        Main.getController().displayCar();
        }
        public void deleteCar()
        {
            System.out.println();
            Main.getController().deleteCar();
        }
        public  void updateCar()
        {
            Main.getController().updateCar();
        }
        //Methods for displaying, creating, deleting, updating customers
        public void createCustomer()
        {
        Main.getController().createCustomer();
        }
        public void displayCustomer()
        {
        Main.getController().displayCustomer();
        }
        public void deleteCustomer()
        {
            System.out.println();
            Main.getController().deleteCustomer();
        }
        public  void updateCustomer()
        {
            Main.getController().updateCustomer();
        }

        //Methods for displaying, creating, deleting, updating rentals
        public void createRental()
        {
            Main.getController().createRental();
        }
        public void displayRental()
        {
            Main.getController().displayRental();
        }
        public void deleteRental()
        {
            System.out.println();
            Main.getController().deleteRental();
        }
        public  void updateRental()
        {
            Main.getController().updateRental();
        }
        //Methods for displaying, creating, deleting, updating zips
        public void createZips()
        {
            Main.getController().createZips();
        }
        public void displayZips()
        {
            Main.getController().displayZips();
        }
        public void deleteZips()
        {
            Main.getController().deleteZips();
        }
        public void updateZips()
        {
            Main.getController().updateZips();
        }
        //Methods for displaying, creating, deleting, updating brands
        public void createBrands(){Main.getController().createBrands();}
        public void  displayBrands(){Main.getController().displayBrands();}
        public  void deleteBrands(){Main.getController().deleteBrands();}
        public void updateBrands(){Main.getController().updateBrands();}
        //Methods for displaying, creating, deleting, updating car types
        public void createTypes(){Main.getController().createTypes();}
        public void  displayTypes(){Main.getController().displayTypes();}
        public  void deleteTypes(){Main.getController().deleteTypes();}
        public void updateTypes(){Main.getController().updateTypes();}
    }


