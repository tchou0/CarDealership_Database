package com.yearup.dealership;

import java.awt.*;
import java.sql.*;
import java.util.Scanner;

public class VehicleDao{
Scanner scanner = new Scanner(System.in);


    //=========================== FIND VEHICLE BY PRICE RANGE ===============================
    public void findPriceRange(double min, double max){
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


    //ADDING OR REMOVING a vehicle from the database

    public void addingOrRemovingAVehicle(int usersChoice){

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


        if(usersChoice == 1){
            try {
                PreparedStatement statement = connection.prepareStatement("""
                               INSERT INTO vehicles (VIN, make, model, year, price, color, mileage, type)
                               VALUES ('?', '?', '?', ?, ?, '?', ?, '?');

                        """);

                System.out.println("\nPlease type the vehicle's VIN: ");
                String addVIN = scanner.next();
                System.out.println("\nPlease type the vehicles make: ");
                String addMake = scanner.next();
                System.out.println("\nPlease type the vehicle's model: ");
                String addModel = scanner.next();
                System.out.println("\nPlease type the vehicle's year: ");
                int addYear = scanner.nextInt();
                System.out.println("\nPlease type the vehicle's price: ");
                double addPrice = scanner.nextDouble();
                System.out.println("\nPlease type the vehicle's color: ");
                scanner.nextLine();
                String addColor = scanner.next();
                System.out.println("\nPlease type the vehicle's mileage: ");
                int addMileage = scanner.nextInt();
                System.out.println("Please type the type of vehicle: ");
                scanner.nextLine();

                String addType = scanner.next();

                statement.setString(1, addVIN);
                statement.setString(2, addMake);
                statement.setString(3, addModel);
                statement.setInt(4, addYear);
                statement.setDouble(5, addPrice);
                statement.setString(6, addColor);
                statement.setInt(7, addMileage);
                statement.setString(8, addType);
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


        else if (usersChoice == 2){
            try {
                PreparedStatement statement = connection.prepareStatement("""
                           SELECT * FROM dealerships
                           JOIN vehicles ON dealerships.dealership_id = vehicles.VIN
                           WHERE model = ?;

                    """);

                System.out.println("Please type the VIN of the vehicle you want to remove: ");
                String removeVIN = scanner.next();

                statement.setString(1, removeVIN);
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
    }



