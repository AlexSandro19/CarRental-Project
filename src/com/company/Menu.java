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
                    createCar();
                    carsMenu();
                    break;
                case 2:
                    displayCar();
                    carsMenu();
                    break;
                case 3:
                    deleteCar();
                    carsMenu();
                    break;
                case 4:
                    updateCar();
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
                    createCustomer();
                    customersMenu();
                    break;
                case 2:
                    displayCustomer();
                    customersMenu();
                    break;
                case 3:
                    deleteCustomer();
                    customersMenu();
                    break;
                case 4:
                    updateCustomer();
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
                    createRental();
                    rentalMenu();
                    break;
                case 2:
                    displayRental();
                    rentalMenu();
                    break;
                case 3:
                    deleteRental();
                    rentalMenu();
                    break;
                case 4:
                    updateRental();
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
            Main.getController().createCar();

        }
        public void displayCar()
        {
        Main.getController().displayCar();
        }
        public void deleteCar()
        {
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
            Main.getController().deleteRental();
        }
        public  void updateRental()
        {
            Main.getController().updateRental();
        }
    }


