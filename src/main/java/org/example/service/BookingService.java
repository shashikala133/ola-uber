package org.example.service;

import org.example.model.*;
import org.example.pricing.PricingStrategy;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BookingService {

    private final CabService cabService;


    private final PricingStrategy pricingStrategy;

    public BookingService(CabService cabService, PricingStrategy pricingStrategy){
        this.cabService=cabService;
        this.pricingStrategy = pricingStrategy;
    }

    public List<VehicleFare> listAvailableVehicle(Location from, Location to){
        List<VehicleFare> vehicleFares=new ArrayList<>();
        for(VehicleType type:cabService.vehicleTypes()){
            double pricePerVehicleType = pricingStrategy.calculatePricePerVehicleType(type, from, to);
            double value = BigDecimal.valueOf(pricePerVehicleType).setScale(2, RoundingMode.HALF_UP).doubleValue();
            vehicleFares.add(new VehicleFare(type,value));
        }
        return vehicleFares;
    }

    public Booking booking(Rider rider,VehicleType type,Location dropLocation){
        Cab cab=cabService.findCab(rider.getCurrentLocation(),type);
        if(cab==null) throw new RuntimeException("no cab available");
        cab.availble();
        double fare= pricingStrategy.calculatePricePerVehicleType(type,rider.getCurrentLocation(),dropLocation);
        Booking booking=new Booking(rider,cab,rider.getCurrentLocation(),dropLocation,fare);
        booking.setStatus(BookingStatus.CREATED);
        return booking;
    }

    public void startRide(Booking booking, String otp){
        if(!booking.getOtp().equals(otp)){
            System.out.println("ride cannot be started otp is invalid");
            return;
        }
       booking.setStatus(BookingStatus.STARTED);
       booking.setRideStartTime(LocalDateTime.now());
        System.out.println("ride started");
    }

    public void endRide(Booking booking){
        if(booking.getStatus()!=BookingStatus.STARTED){
            System.out.println("ride hasnt started yet");
            return;
        }
        booking.setRideEndTime(LocalDateTime.now());
        booking.setStatus(BookingStatus.ENDED);
        double finalFare= pricingStrategy.calculatePricePerVehicleType(booking.getCab().getType(),booking.getPickUpLocation(),booking.getDropLocation());
        booking.setFare(finalFare);
        System.out.println("ride ended");
    }
}
