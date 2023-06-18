package com.yearup.dealership;
import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    Dealership dealership = new Dealership();

    public static void main(String[] args) {


        menu();
    }

    public static void menu() {
        Dealership dealership = new Dealership();
        System.out.println(ColorCodes.TEXT_PURPLE + "\n*=*=*=*=*=*=*=*=*=* Welcome to My Dealership =*=*=**=*=*=*=*=*=*=*=*=\n" + ColorCodes.ANSI_RESET);
        System.out.println("How would you like to find your vehicle?\nSearch By: ");

        System.out.println("\n1) Price Range\n2) Make/Model\n3) Year Range\n4) Color\n5) Mileage Range\n6) Type\n0) Exit");
        int userChoice = scanner.nextInt();


        if (userChoice == 1) {
            System.out.println("\nPlease type a price range for the vehicle you are looking for\n");
            System.out.println("Min: ");
            double minRange = scanner.nextDouble();
            System.out.println("Max: ");
            double maxRange = scanner.nextDouble();
            dealership.vehicle(minRange, maxRange);

            menu();
        }
        else if (userChoice == 2) {
            System.out.println("\nWould you like to search for the vehicle's Make or Model?\n1)Make\n2)Model\n");
            int makeOrModelOption = scanner.nextInt();

            if (makeOrModelOption == 1) {
                System.out.println("Please type the make of the vehicle\n");
                scanner.nextLine();
                String makeOfVehicle = scanner.next();
                dealership.getMakeOrModel(makeOrModelOption, makeOfVehicle);

            } else if (makeOrModelOption == 2) {
                System.out.println("Please type the model of the vehicle\n");
                scanner.nextLine();
                String modelOfVehicle = scanner.next();
                dealership.getMakeOrModel(makeOrModelOption, modelOfVehicle);
            }
            menu();

        }
        else if (userChoice == 3) {
            System.out.println("\nPlease type the year range of the vehicle you're searching for\n");
            System.out.println("Min: ");
            int minYear = scanner.nextInt();
            System.out.println("Max: ");
            int maxYear = scanner.nextInt();
            dealership.getVehicleByYear(minYear, maxYear);
                menu();
            }
        else if (userChoice == 4) {
            System.out.println("Please type the color of the vehicle you would like to see.\n");
            String vehicleColor = scanner.next();
            dealership.getVehicleByColor(vehicleColor);
                menu();
            }
        else if (userChoice == 5) {
            System.out.println("Please type the mileage range of the vehicle you are looking for\n");
            System.out.println("Min: ");
            int minMileage = scanner.nextInt();
            System.out.println("Max: ");
            int maxMileage = scanner.nextInt();
            dealership.getVehicleByMileage(minMileage, maxMileage);
                menu();
            }
        else if (userChoice == 6) {
            System.out.println("Please type the type of vehicle you're searching for");
            String typeOfVehicle = scanner.next();
            dealership.getVehicleByType(typeOfVehicle);
                menu();
            }
        else if (userChoice == 0) {
                System.out.println("Have a nice day! :D");
                System.exit(0);
            }

        else {
                System.out.println("\nPlease type one of the options above\n");
                menu();
            }


        }
    }
