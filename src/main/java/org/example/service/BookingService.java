package org.example.service;

import org.example.model.*;
import org.example.pricing.PricingStrategy;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class BookingService {

    private final CabService cabService;
    private final RiderService riderService;

    private final PricingStrategy pricingStrategy;

    public BookingService(CabService cabService, RiderService riderService, PricingStrategy pricingStrategy){
        this.cabService=cabService;
        this.riderService=riderService;
        this.pricingStrategy = pricingStrategy;
    }

    public List<VehicleFare> listAvailableVehicle(Location from, Location to){
        List<VehicleFare> vehicleFares=new ArrayList<>();
        for(VehicleType type:VehicleType.values()){
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
        Booking booking=new Booking(rider,cab,rider.getCurrentLocation(),dropLocation);
        booking.setStatus(BookingStatus.CREATED);
        return booking;
    }
}
