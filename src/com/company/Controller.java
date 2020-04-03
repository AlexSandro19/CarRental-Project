package com.company;

public class Controller {
    private static Services services = new Services();
    public Controller()
    {
    }
    public void createCar()
    {
        services.createCar();
    }
    public void displayCar()
    {
    services.displayCar();
    }
    public void deleteCar()
    {
        services.deleteCar();
    }
    public  void updateCar()
    {
    services.updateCar();
    }

    public void createCustomer()
    {
    services.createCustomer();
    }
    public void displayCustomer()
    {
    services.displayCustomer();
    }
    public void deleteCustomer()
    {
    services.deleteCustomer();
    }
    public  void updateCustomer()
    {
    services.updateCustomer();
    }

    public void createRental() {
        services.createRental();
    }

    public void displayRental() {
        services.displayRental();
    }

    public void deleteRental() {
        services.deleteRental();
    }

    public void updateRental() {
        services.updateRental();
    }
}
