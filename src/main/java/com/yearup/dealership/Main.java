package com.yearup.dealership;
import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {


        System.out.println(ColorCodes.TEXT_PURPLE + "\n*=*=*=*=*=*=*=*=*=* Welcome to My Dealership =*=*=**=*=*=*=*=*=*=*=*=\n" + ColorCodes.ANSI_RESET);




        String driverClassname = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/cardealership";

        try {
            Class.forName(driverClassname);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url, "tchou", "QQ112233!");
        } catch (SQLException e) {
            System.getLogger("Main").log(System.Logger.Level.ERROR, "Couldn't open SQL connection");
        }

        System.out.println("How would you like to find your vehicle?\nSearch By: ");

        System.out.println("\n1) Price Range\n2) Make/Model\n3) Year Range\n4) Color\n5) Mileage Range\n6)Type");
        int userChoice = scanner.nextInt();



        if(userChoice == 1){
            System.out.println("You chose 1");

            try {
                PreparedStatement statement = connection.prepareStatement("""
                               SELECT * FROM dealerships
                               JOIN vehicles ON dealerships.dealership_id = vehicles.VIN
                               WHERE price > ? AND price < ?;

                        """);


                ResultSet results = null;

                results = statement.executeQuery();

                while (results.next()) {
                    String vin = results.getString("VIN");
                    String make = results.getString("make");
                    String model = results.getString("model");
                    int year = results.getInt("year");
                    double price = results.getDouble("price");
                }
                connection.close();
            } catch (SQLException e) {
                System.getLogger("Main").log(System.Logger.Level.ERROR, "Couldn't execute statement");
            } catch (RuntimeException e) {
                System.getLogger("Main").log(System.Logger.Level.ERROR, "RUNTIME EXCEPTION");
            }
        }
        else if(userChoice == 2){
            System.out.println("You chose 2");
        }
        else if(userChoice == 3){
            System.out.println("You chose 3");
        }
        else if(userChoice == 4){
            System.out.println("You chose 4");
        }
        else if(userChoice == 5){
            System.out.println("You chose 5");
        }
        else if(userChoice == 6){
            System.out.println("You chose 6");
        }

//        try {
//            PreparedStatement statement = connection.prepareStatement("""
//                            SELECT *
//                            FROM dealerships;
//
//                    """);
//
////            PreparedStatement statement1 = connection.prepareStatement("""
////                            SELECT *
////                            FROM vehicles;
////
////                    """);
//
//
////            statement.setString(1, name.toString());
////            statement.setString(2, address.toString());
//
//            ResultSet results = null;
////            ResultSet results1 = null;
//
//            results = statement.executeQuery();
////            results1 = statement1.executeQuery();
//
//            while (results.next()) {
//                String vin = results.getString("VIN");
//                String make = results.getString("make");
//                String model = results.getString("model");
//                int year = results.getInt("year");
//                double price = results.getDouble("price");
//            }


//            while (results.next() & results1.next()) {
//                String name = results.getString("name");
//                String address = results.getString("address");
//                String phone = results.getString("phone");
//                System.out.printf(ColorCodes.ANSI_BLUE + "Dealership name: %s" + ColorCodes.ANSI_RESET +
//                        ColorCodes.ANSI_YELLOW + "\nAddress: %s" + ColorCodes.ANSI_RESET +
//                        ColorCodes.PURPLE_BOLD_BRIGHT + "\nPhone number: %s \n\n" + ColorCodes.ANSI_RESET, name, address, phone);

//                String make = results1.getString("make");
//                int year = results1.getInt("year");
//                double price = results1.getDouble("price");
//                System.out.printf(ColorCodes.ANSI_BLUE + "Make: %s" + ColorCodes.ANSI_RESET +
//                        ColorCodes.ANSI_YELLOW + "\nYear: %d" + ColorCodes.ANSI_RESET +
//                        ColorCodes.PURPLE_BOLD_BRIGHT + "\nPrice: %.2f \n\n" + ColorCodes.ANSI_RESET, make, year, price);
//            }
//            connection.close();
//        } catch (SQLException e) {
//            System.getLogger("Main").log(System.Logger.Level.ERROR, "Couldn't execute statement");
//        } catch (RuntimeException e) {
//            System.getLogger("Main").log(System.Logger.Level.ERROR, "RUNTIME EXCEPTION");
//        }
        return;
    }


    //methods

    public static void menu(){
        System.out.println("How would you like to find your vehicle?\nSearch By: ");

        System.out.println("\n1) Price Range\n2) Make/Model\n3) Year Range\n4) Color\n5) Mileage Range\n6)Type");
        int userChoice = scanner.nextInt();



        if(userChoice == 1){
            System.out.println("You chose 1");


        }
        else if(userChoice == 2){
            System.out.println("You chose 2");
        }
        else if(userChoice == 3){
            System.out.println("You chose 3");
        }
        else if(userChoice == 4){
            System.out.println("You chose 4");
        }
        else if(userChoice == 5){
            System.out.println("You chose 5");
        }
        else if(userChoice == 6){
            System.out.println("You chose 6");
        }



    }


}