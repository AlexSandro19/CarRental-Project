package com.company;

import java.sql.*;

public class Main {
    private static Controller controller;

    public static void main(String[] args)  {
        controller=new Controller();
        new Menu();

    }
    public static Controller getController(){return controller;}
}
