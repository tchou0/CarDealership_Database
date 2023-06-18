package com.yearup.dealership;

public class Dealership {
    VehicleDao vd = new VehicleDao();

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

}
