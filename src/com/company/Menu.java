package com.company;

    import java.util.Scanner;
    public class Menu {
        static Scanner console=new Scanner(System.in);
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
            System.out.println("|            4.Quit           |");
            System.out.println("|_____________________________|");
            System.out.println("           Enter number...    ");
            int choice = console.nextInt();

            switch (choice)
            {
                case 1:
                    carsMenu();
                    break;
                case 2:
                    customersMenu();
                    break;
                case 3:
                    rentalMenu();
                    break;
                case 4:
                    System.exit(1);
                    break;
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
            int choice =console.nextInt();
            switch (choice)
            {
                case 1:
                    //createCar();
                    carsMenu();
                    break;
                case 2:
                    //displayCar();
                    carsMenu();
                    break;
                case 3:
                    //deleteCar();
                    carsMenu();
                    break;
                case 4:
                    //updateCar
                    carsMenu();
                    break;
                case 5:
                    mainMenu();
                    break;


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
            int choice =console.nextInt();

            switch (choice)
            {
                case 1:
                    //createCustomer();
                    customersMenu();
                    break;
                case 2:
                    //displayCustomer();
                    customersMenu();
                    break;
                case 3:
                    //deleteCustomer();
                    customersMenu();
                    break;
                case 4:
                    //updateCustomer();
                    customersMenu();
                    break;
                case 5:
                    mainMenu();
                    break;


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
            int choice =console.nextInt();
            switch (choice)
            {
                case 1:
                    //createRental();
                    rentalMenu();
                    break;
                case 2:
                    //displayRental();
                    rentalMenu();
                    break;
                case 3:
                    //deleteRental();
                    rentalMenu();
                    break;
                case 4:
                    //updateRental
                    rentalMenu();
                    break;
                case 5:
                    mainMenu();
                    break;


            }

        }

        //Methods for displaying, creating, deleting, updating cars
        public void createCar()
        {


        }
        public void displayCar()
        {

        }
        public void deleteCar()
        {

        }
        public  void updateCar()
        {


        }
        //Methods for displaying, creating, deleting, updating customers
        public void createCustomer()
        {


        }
        public void displayCustomer()
        {

        }
        public void deleteCustomer()
        {

        }
        public  void updateCustomer()
        {


        }

        //Methods for displaying, creating, deleting, updating rentals
        public void createRental()
        {


        }
        public void displayRental()
        {

        }
        public void deleteRental()
        {

        }
        public  void updateRental()
        {


        }
    }


