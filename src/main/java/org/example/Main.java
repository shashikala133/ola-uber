package org.example;

import org.example.model.*;
import org.example.pricing.PricingStrategy;
import org.example.pricing.PricingStrategyImpl;
import org.example.service.BookingService;
import org.example.service.CabService;
import org.example.service.DriverService;
import org.example.service.RiderService;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RiderService riderService=new RiderService();
        CabService cabService=new CabService();
        DriverService driverService=new DriverService();
        PricingStrategy strategy=new PricingStrategyImpl();
        BookingService bookingService=new BookingService(cabService,strategy);

        Rider rider=riderService.registerRider("R1","lava");
        System.out.println(rider);
        Location pickup=new Location(10,10);
        rider.setCurrentLocation(pickup);

        driverService.registerDriver("d1","driverOne");
        driverService.registerDriver("d2","driverTwo");
        driverService.registerDriver("d3","driverThree");
        driverService.registerDriver("d4","driverFour");
        driverService.registerDriver("d5","driverFive");

        Location dropLocation=new Location(20,20);
        cabService.registerCab("c1",driverService.getDriverById("d1").getName(), VehicleType.AUTO,new Location(13,11));
        cabService.registerCab("c2","driverTwo", VehicleType.AUTO,new Location(20,10));
        cabService.registerCab("c3","driverThree", VehicleType.SUV,new Location(21,11));
        cabService.registerCab("c4","driverFour", VehicleType.BIKE,new Location(15,11));
        cabService.registerCab("c5","driverFive", VehicleType.SEDAN,new Location(10,11));

        System.out.println("fare estimation");
        List<VehicleFare> vehicleFares = bookingService.listAvailableVehicle(pickup, dropLocation);
        for(VehicleFare fare:vehicleFares){
            System.out.println(fare);
        }

        Booking booking;
        try {
            booking=bookingService.booking(rider,VehicleType.AUTO,dropLocation);
            System.out.println("booking succesfull generated otp: "+booking.getOtp());
        }catch (RuntimeException ex){
            System.out.println("Booking failed "+ex.getMessage());
            return;
        }

        Scanner scanner=new Scanner(System.in);
        System.out.println("please enter the otp: ");
        String enteredOtp=scanner.nextLine();

        bookingService.startRide(booking,enteredOtp);
        if(booking.getStatus()!=BookingStatus.STARTED) return;
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("reached to destination ending ride");
        bookingService.endRide(booking);

        System.out.println("final summary");
        System.out.println(booking);
    }
}