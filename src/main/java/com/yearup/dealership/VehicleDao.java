package com.yearup.dealership;

import java.awt.*;
import java.sql.*;
import java.util.Scanner;

public class VehicleDao{



    //=========================== FIND VEHICLE BY PRICE RANGE ===============================
    public void findPriceRange(double min, double max){
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

        try {
            PreparedStatement statement = connection.prepareStatement("""
                               SELECT * FROM dealerships
                               JOIN vehicles ON dealerships.dealership_id = vehicles.VIN
                               WHERE price > ? AND price < ?;

                        """);

            statement.setDouble(1, min);
            statement.setDouble(2, max);

            ResultSet results = null;

            results = statement.executeQuery();

            while (results.next()) {
                String vin = results.getString("VIN");
                String make = results.getString("make");
                String model = results.getString("model");
                int year = results.getInt("year");
                double price = results.getDouble("price");
                String color = results.getString("color");
                int mileage = results.getInt("mileage");
                String type = results.getString("type");


                System.out.printf(ColorCodes.ANSI_BLUE + "VIN #: %s" + ColorCodes.ANSI_RESET +
                            ColorCodes.ANSI_YELLOW + "\nMake: %s" + ColorCodes.ANSI_RESET +
                            ColorCodes.PURPLE_BOLD_BRIGHT + "\nModel: %s" + ColorCodes.ANSI_RESET +
                            ColorCodes.CYAN_BOLD_BRIGHT + "\nYear: %d" + ColorCodes.ANSI_RESET +
                            ColorCodes.ANSI_GREEN + "\nPrice: %8.2f" + ColorCodes.ANSI_RESET +
                        ColorCodes.TEXT_PURPLE + "\nColor: %s" + ColorCodes.ANSI_RESET +
                        ColorCodes.CYAN_BOLD_BRIGHT + "\nMileage: %d" + ColorCodes.ANSI_RESET +
                        ColorCodes.ANSI_YELLOW + "\nType: %s\n\n" + ColorCodes.ANSI_RESET, vin, make, model, year, price, color, mileage, type);
            }
            connection.close();
        } catch (SQLException e) {
            System.getLogger("Main").log(System.Logger.Level.ERROR, "Couldn't execute statement");
        } catch (RuntimeException e) {
            System.getLogger("Main").log(System.Logger.Level.ERROR, "RUNTIME EXCEPTION");
        }

    }

    //======================= GET VEHICLES BY MAKES OR MODELS ===================================

    public void findMakeOrModel(int choice, String makeOrModel){
        Scanner scanner = new Scanner(System.in);
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



        if(choice == 1){
            try {
                PreparedStatement statement = connection.prepareStatement("""
                           SELECT * FROM dealerships
                           JOIN vehicles ON dealerships.dealership_id = vehicles.VIN
                           WHERE make = ?;

                    """);

                statement.setString(1, makeOrModel.toString());
                ResultSet results = null;

                results = statement.executeQuery();

                while (results.next()) {
                    String vin = results.getString("VIN");
                    String make = results.getString("make");
                    String model = results.getString("model");
                    int year = results.getInt("year");
                    double price = results.getDouble("price");
                    String color = results.getString("color");
                    int mileage = results.getInt("mileage");
                    String type = results.getString("type");


                    System.out.printf(ColorCodes.ANSI_BLUE + "VIN #: %s" + ColorCodes.ANSI_RESET +
                            ColorCodes.ANSI_YELLOW + "\nMake: %s" + ColorCodes.ANSI_RESET +
                            ColorCodes.PURPLE_BOLD_BRIGHT + "\nModel: %s" + ColorCodes.ANSI_RESET +
                            ColorCodes.CYAN_BOLD_BRIGHT + "\nYear: %d" + ColorCodes.ANSI_RESET +
                            ColorCodes.ANSI_GREEN + "\nPrice: %8.2f" + ColorCodes.ANSI_RESET +
                            ColorCodes.TEXT_PURPLE + "\nColor: %s" + ColorCodes.ANSI_RESET +
                            ColorCodes.CYAN_BOLD_BRIGHT + "\nMileage: %d" + ColorCodes.ANSI_RESET +
                            ColorCodes.ANSI_YELLOW + "\nType: %s\n\n" + ColorCodes.ANSI_RESET, vin, make, model, year, price, color, mileage, type);
                }
                connection.close();
            } catch (SQLException e) {
                System.getLogger("Main").log(System.Logger.Level.ERROR, "Couldn't execute statement");
            } catch (RuntimeException e) {
                System.getLogger("Main").log(System.Logger.Level.ERROR, "RUNTIME EXCEPTION");
            }
        }


        else if (choice == 2){
            try {
                PreparedStatement statement = connection.prepareStatement("""
                           SELECT * FROM dealerships
                           JOIN vehicles ON dealerships.dealership_id = vehicles.VIN
                           WHERE model = ?;

                    """);

                statement.setString(1, makeOrModel.toString());
                ResultSet results = null;

                results = statement.executeQuery();

                while (results.next()) {
                    String vin = results.getString("VIN");
                    String make = results.getString("make");
                    String model = results.getString("model");
                    int year = results.getInt("year");
                    double price = results.getDouble("price");
                    String color = results.getString("color");
                    int mileage = results.getInt("mileage");
                    String type = results.getString("type");


                    System.out.printf(ColorCodes.ANSI_BLUE + "VIN #: %s" + ColorCodes.ANSI_RESET +
                            ColorCodes.ANSI_YELLOW + "\nMake: %s" + ColorCodes.ANSI_RESET +
                            ColorCodes.PURPLE_BOLD_BRIGHT + "\nModel: %s" + ColorCodes.ANSI_RESET +
                            ColorCodes.CYAN_BOLD_BRIGHT + "\nYear: %d" + ColorCodes.ANSI_RESET +
                            ColorCodes.ANSI_GREEN + "\nPrice: %8.2f" + ColorCodes.ANSI_RESET +
                            ColorCodes.TEXT_PURPLE + "\nColor: %s" + ColorCodes.ANSI_RESET +
                            ColorCodes.CYAN_BOLD_BRIGHT + "\nMileage: %d" + ColorCodes.ANSI_RESET +
                            ColorCodes.ANSI_YELLOW + "\nType: %s\n\n" + ColorCodes.ANSI_RESET, vin, make, model, year, price, color, mileage, type);
                }
                connection.close();
            } catch (SQLException e) {
                System.getLogger("Main").log(System.Logger.Level.ERROR, "Couldn't execute statement");
            } catch (RuntimeException e) {
                System.getLogger("Main").log(System.Logger.Level.ERROR, "RUNTIME EXCEPTION");
            }
        }

    }

    public void findByYear(int min, int max){
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

        try {
            PreparedStatement statement = connection.prepareStatement("""
                               SELECT * FROM dealerships
                               JOIN vehicles ON dealerships.dealership_id = vehicles.VIN
                               WHERE year >= ? AND year <= ?;

                        """);

            statement.setInt(1, min);
            statement.setInt(2, max);

            ResultSet results = null;

            results = statement.executeQuery();

            while (results.next()) {
                String vin = results.getString("VIN");
                String make = results.getString("make");
                String model = results.getString("model");
                int year = results.getInt("year");
                double price = results.getDouble("price");
                String color = results.getString("color");
                int mileage = results.getInt("mileage");
                String type = results.getString("type");


                System.out.printf(ColorCodes.ANSI_BLUE + "VIN #: %s" + ColorCodes.ANSI_RESET +
                        ColorCodes.ANSI_YELLOW + "\nMake: %s" + ColorCodes.ANSI_RESET +
                        ColorCodes.PURPLE_BOLD_BRIGHT + "\nModel: %s" + ColorCodes.ANSI_RESET +
                        ColorCodes.CYAN_BOLD_BRIGHT + "\nYear: %d" + ColorCodes.ANSI_RESET +
                        ColorCodes.ANSI_GREEN + "\nPrice: %8.2f" + ColorCodes.ANSI_RESET +
                        ColorCodes.TEXT_PURPLE + "\nColor: %s" + ColorCodes.ANSI_RESET +
                        ColorCodes.CYAN_BOLD_BRIGHT + "\nMileage: %d" + ColorCodes.ANSI_RESET +
                        ColorCodes.ANSI_YELLOW + "\nType: %s\n\n" + ColorCodes.ANSI_RESET, vin, make, model, year, price, color, mileage, type);
            }
            connection.close();
        } catch (SQLException e) {
            System.getLogger("Main").log(System.Logger.Level.ERROR, "Couldn't execute statement");
        } catch (RuntimeException e) {
            System.getLogger("Main").log(System.Logger.Level.ERROR, "RUNTIME EXCEPTION");
        }

    }

    public void findByColor(String colorOfVehicle){

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

        try {
            PreparedStatement statement = connection.prepareStatement("""
                           SELECT * FROM dealerships\s
                           JOIN vehicles ON dealerships.dealership_id = vehicles.VIN
                           WHERE color = ?;

                    """);

            statement.setString(1, colorOfVehicle);

            ResultSet results = null;

            results = statement.executeQuery();

            while (results.next()) {
                String vin = results.getString("VIN");
                String make = results.getString("make");
                String model = results.getString("model");
                int year = results.getInt("year");
                double price = results.getDouble("price");
                String color = results.getString("color");
                int mileage = results.getInt("mileage");
                String type = results.getString("type");


                System.out.printf(ColorCodes.ANSI_BLUE + "VIN #: %s" + ColorCodes.ANSI_RESET +
                        ColorCodes.ANSI_YELLOW + "\nMake: %s" + ColorCodes.ANSI_RESET +
                        ColorCodes.PURPLE_BOLD_BRIGHT + "\nModel: %s" + ColorCodes.ANSI_RESET +
                        ColorCodes.CYAN_BOLD_BRIGHT + "\nYear: %d" + ColorCodes.ANSI_RESET +
                        ColorCodes.ANSI_GREEN + "\nPrice: %8.2f" + ColorCodes.ANSI_RESET +
                        ColorCodes.TEXT_PURPLE + "\nColor: %s" + ColorCodes.ANSI_RESET +
                        ColorCodes.CYAN_BOLD_BRIGHT + "\nMileage: %d" + ColorCodes.ANSI_RESET +
                        ColorCodes.ANSI_YELLOW + "\nType: %s\n\n" + ColorCodes.ANSI_RESET, vin, make, model, year, price, color, mileage, type);
            }
            connection.close();
        } catch (SQLException e) {
            System.getLogger("Main").log(System.Logger.Level.ERROR, "Couldn't execute statement");
        } catch (RuntimeException e) {
            System.getLogger("Main").log(System.Logger.Level.ERROR, "RUNTIME EXCEPTION");
        }

    }

    public void findByMileage(int min, int max){
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

        try {
            PreparedStatement statement = connection.prepareStatement("""
                               SELECT * FROM dealerships
                               JOIN vehicles ON dealerships.dealership_id = vehicles.VIN
                               WHERE mileage >= ? AND mileage <= ?;

                        """);

            statement.setInt(1, min);
            statement.setInt(2, max);

            ResultSet results = null;

            results = statement.executeQuery();

            while (results.next()) {
                String vin = results.getString("VIN");
                String make = results.getString("make");
                String model = results.getString("model");
                int year = results.getInt("year");
                double price = results.getDouble("price");
                String color = results.getString("color");
                int mileage = results.getInt("mileage");
                String type = results.getString("type");


                System.out.printf(ColorCodes.ANSI_BLUE + "VIN #: %s" + ColorCodes.ANSI_RESET +
                        ColorCodes.ANSI_YELLOW + "\nMake: %s" + ColorCodes.ANSI_RESET +
                        ColorCodes.PURPLE_BOLD_BRIGHT + "\nModel: %s" + ColorCodes.ANSI_RESET +
                        ColorCodes.CYAN_BOLD_BRIGHT + "\nYear: %d" + ColorCodes.ANSI_RESET +
                        ColorCodes.ANSI_GREEN + "\nPrice: %8.2f" + ColorCodes.ANSI_RESET +
                        ColorCodes.TEXT_PURPLE + "\nColor: %s" + ColorCodes.ANSI_RESET +
                        ColorCodes.CYAN_BOLD_BRIGHT + "\nMileage: %d" + ColorCodes.ANSI_RESET +
                        ColorCodes.ANSI_YELLOW + "\nType: %s\n\n" + ColorCodes.ANSI_RESET, vin, make, model, year, price, color, mileage, type);
            }
            connection.close();
        } catch (SQLException e) {
            System.getLogger("Main").log(System.Logger.Level.ERROR, "Couldn't execute statement");
        } catch (RuntimeException e) {
            System.getLogger("Main").log(System.Logger.Level.ERROR, "RUNTIME EXCEPTION");
        }
    }

    public void findByType(String typeOfVehicle){

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

        try {
            PreparedStatement statement = connection.prepareStatement("""
                           SELECT * FROM dealerships\s
                           JOIN vehicles ON dealerships.dealership_id = vehicles.VIN
                           WHERE type = ?;

                    """);

            statement.setString(1, typeOfVehicle);

            ResultSet results = null;

            results = statement.executeQuery();

            while (results.next()) {
                String vin = results.getString("VIN");
                String make = results.getString("make");
                String model = results.getString("model");
                int year = results.getInt("year");
                double price = results.getDouble("price");
                String color = results.getString("color");
                int mileage = results.getInt("mileage");
                String type = results.getString("type");


                System.out.printf(ColorCodes.ANSI_BLUE + "VIN #: %s" + ColorCodes.ANSI_RESET +
                        ColorCodes.ANSI_YELLOW + "\nMake: %s" + ColorCodes.ANSI_RESET +
                        ColorCodes.PURPLE_BOLD_BRIGHT + "\nModel: %s" + ColorCodes.ANSI_RESET +
                        ColorCodes.CYAN_BOLD_BRIGHT + "\nYear: %d" + ColorCodes.ANSI_RESET +
                        ColorCodes.ANSI_GREEN + "\nPrice: %8.2f" + ColorCodes.ANSI_RESET +
                        ColorCodes.TEXT_PURPLE + "\nColor: %s" + ColorCodes.ANSI_RESET +
                        ColorCodes.CYAN_BOLD_BRIGHT + "\nMileage: %d" + ColorCodes.ANSI_RESET +
                        ColorCodes.ANSI_YELLOW + "\nType: %s\n\n" + ColorCodes.ANSI_RESET, vin, make, model, year, price, color, mileage, type);
            }
            connection.close();
        } catch (SQLException e) {
            System.getLogger("Main").log(System.Logger.Level.ERROR, "Couldn't execute statement");
        } catch (RuntimeException e) {
            System.getLogger("Main").log(System.Logger.Level.ERROR, "RUNTIME EXCEPTION");
        }
    }

}
