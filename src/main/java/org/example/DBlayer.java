package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class DBlayer {

    public static void main(String[] args) {
        BusService busService = new BusService();

        Bus kashmereGateToAnandViharGovtBus = new Bus("214A", "TATA", 50, "Ram Kumar", "Manoj Singh");
        Bus AnandViharToShivaDhabaPrivateBus = new Bus("P12", "Eicher", 35, "Ramesh", "Shiv Ram");
        Bus ShastriparkToAnandViharGvotBus = new Bus("GL23", "Mahindra", 45, "Prabhat Singh", "Vishal");
        Bus kolkataStationToHawarah = new Bus("K1","TATA",50,"Kapil Kumar","Ramu");
        Bus howrahStationToSector2 = new Bus("206","TATA",50,"Dharamvir","Rajesh");
        Bus DelhiToNoida = new Bus("S22","TATA",75,"Manish Kumar","Pramod");


//        adding Data in DB
        System.out.println("Adding Buses in DataBase:- ");

        busService.addBus(kashmereGateToAnandViharGovtBus);
        busService.addBus(AnandViharToShivaDhabaPrivateBus);
        busService.addBus(ShastriparkToAnandViharGvotBus);
        busService.addBus(kolkataStationToHawarah);
        busService.addBus(howrahStationToSector2);
        busService.addBus(DelhiToNoida);

//        fetch data from DB
        System.out.println("Select a Specific Bus from the DataBase and Find out all information about the bus:- ");
        System.out.println("Enter the bus serial number=> ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Bus bus = busService.getBusByNumber(n);
        System.out.println("Bus Data : "+bus);

//        updating bus Data
        System.out.println("Update the bus driver name that you specifically selected=> ");
        System.out.println("Enter the new Driver name:- ");
        String driverOld = bus.getDriverName();
        String driverNew = sc.next();
        bus.setDriverName(driverNew);
        System.out.println("Check the updatetion is completed of not:-");
        if(driverOld!=bus.getDriverName()) {
            busService.updateBus(bus);
            System.out.println("Updation completed!");
            System.out.println("Updated truck data : " + busService.getBusByNumber(n));
        }{
            System.out.println("Updation not completed!");
            System.out.println("New Driver name as same as Old Driver");
        }

//        get all bus data
        List<Bus> allBus = busService.getAllBus();
        System.out.println("All bus in DB :");
        for(Bus bus1:allBus){
            System.out.println(bus1);
        }

//        delete bus data
        int rowAffected = busService.deleteBus(2);
        if(rowAffected==0){
            System.out.println("failed to delete data");
        }else{
            System.out.println("successfully deleted data from row: "+rowAffected);
        }

        allBus = busService.getAllBus();
        System.out.println("All bus after all operation: ");
        System.out.println(allBus);
    }
}
