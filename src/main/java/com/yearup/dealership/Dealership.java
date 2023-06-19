package com.yearup.dealership;

import java.util.Scanner;

public class Dealership {
    VehicleDao vd = new VehicleDao();

    //=================== Methods to get the choices to find a specific vehicle=======================
    void vehicle(double min, double max){

         vd.findPriceRange(min, max);
    }

    void getMakeOrModel(int choice, String makeOrModel){

        vd.findMakeOrModel(choice, makeOrModel);
    }

    void getVehicleByYear(int min, int max){
        vd.findByYear(min, max);
    }

    void getVehicleByColor(String color){
        vd.findByColor(color);
    }

    void getVehicleByMileage(int min, int max){
        vd.findByMileage(min, max);
    }

    void getVehicleByType(String type){
        vd.findByType(type);
    }

    void addOrRemoveVehicle(int choice){
        vd.addingOrRemovingAVehicle(choice);
    }






    //=============== MENU TO SEARCH FOR VEHICLES ==========================

    public void vehicleMenuSearch() {
        Scanner scanner = new Scanner(System.in);
        Dealership dealership = new Dealership();
        System.out.println(ColorCodes.TEXT_PURPLE + "\n*=*=*=*=*=*=*=*=*=* Welcome to My Dealership =*=*=**=*=*=*=*=*=*=*=*=\n" + ColorCodes.ANSI_RESET);
        System.out.println("How would you like to find your vehicle?\nSearch By: ");

        System.out.println("\n1) Price Range\n2) Make/Model\n3) Year Range\n4) Color\n5) Mileage Range\n6) Type\n0) Go Back");
        int userChoice = scanner.nextInt();


        if (userChoice == 1) {
            System.out.println("\nPlease type a price range for the vehicle you are looking for\n");
            System.out.println("Min: ");
            double minRange = scanner.nextDouble();
            System.out.println("Max: ");
            double maxRange = scanner.nextDouble();
            dealership.vehicle(minRange, maxRange);

            vehicleMenuSearch();
        }
        else if (userChoice == 2) {
            System.out.println("\nWould you like to search for the vehicle's Make or Model?\n1) Make\n2) Model\n");
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
            vehicleMenuSearch();

        }
        else if (userChoice == 3) {
            System.out.println("\nPlease type the year range of the vehicle you're searching for\n");
            System.out.println("Min: ");
            int minYear = scanner.nextInt();
            System.out.println("Max: ");
            int maxYear = scanner.nextInt();
            dealership.getVehicleByYear(minYear, maxYear);
            vehicleMenuSearch();
        }
        else if (userChoice == 4) {
            System.out.println("Please type the color of the vehicle you would like to see.\n");
            String vehicleColor = scanner.next();
            dealership.getVehicleByColor(vehicleColor);
            vehicleMenuSearch();
        }
        else if (userChoice == 5) {
            System.out.println("Please type the mileage range of the vehicle you are looking for\n");
            System.out.println("Min: ");
            int minMileage = scanner.nextInt();
            System.out.println("Max: ");
            int maxMileage = scanner.nextInt();
            dealership.getVehicleByMileage(minMileage, maxMileage);
            vehicleMenuSearch();
        }
        else if (userChoice == 6) {
            System.out.println("Please type the type of vehicle you're searching for");
            String typeOfVehicle = scanner.next();
            dealership.getVehicleByType(typeOfVehicle);
            vehicleMenuSearch();
        }
        else if (userChoice == 0) {
            mainMenu();
        }

        else {
            System.out.println("\nPlease type one of the options above\n");
            vehicleMenuSearch();
        }


    }


    //================ ADD A NEW VEHICLE TO THE DATABASE OR REMOVE MENU ==================

    public void addOrRemoveVehicleMenu(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nWelcome! Would you like to register a NEW vehicle or REMOVE?\n1) ADD A NEW VEHICLE\n2) REMOVE A VEHICLE\n0) Main Menu");
        int userChoice = scanner.nextInt();

        switch(userChoice){
            case 1:
                addOrRemoveVehicle(userChoice);
                break;
            case 0:
                mainMenu();
        }


    }


    public void mainMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n================== MAIN MENU ======================\n");
        System.out.println("Would you like to\n1) Search for a vehicle\n2) Add or Remove a vehicle\n3) Find Sales Or lease\n0) Exit Program");
        int userInput = scanner.nextInt();

        switch (userInput){
            case 1:
                vehicleMenuSearch();
                break;
            case 2:
                addOrRemoveVehicleMenu();
                break;
            case 3:
                System.out.println("You chose to find sales or leased vehicles");
                break;
            case 0:
                System.out.println("Have a great day! :D");
                System.exit(0);
            default:
                System.out.println("That is not a valid choice");
                break;
        }

    }


}
