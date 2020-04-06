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
    public void displayOneCar(){services.displayOneCar();}
    public void deleteCar()
    {
        services.deleteCar();
    }
    public void updateCar()
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
    public void displayOneCustomer(){services.displayOneCustomer();}
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
    public void displayOneRental(){services.displayOneRental();}

    public void createZips(){services.createZips();}
    public void  displayZips(){services.displayZips();}
    public void deleteZips(){services.deleteZips();}
    public void updateZips(){services.updateZips();}

    public void createBrands(){services.createBrands();}
    public void displayBrands(){services.displayBrands();}
    public void deleteBrands(){services.deleteBrands();}
    public void updateBrands(){services.updateBrands();}

    public void createTypes(){services.createTypes();}
    public void  displayTypes(){services.displayTypes();}
    public void deleteTypes(){services.deleteTypes();}
    public void updateTypes(){services.updateTypes();}
}
