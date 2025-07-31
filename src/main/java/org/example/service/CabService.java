package org.example.service;

import org.example.model.Cab;
import org.example.model.Location;
import org.example.model.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class CabService {

    List<Cab> cabs=new ArrayList<>();

    public void registerCab(String id, String driverName, VehicleType vehicleType, Location location){
        Cab cab=new Cab(id,driverName,vehicleType,location);
        cabs.add(cab);
    }

    public Cab findCab(Location location, VehicleType type){
        double min=Double.MAX_VALUE;
        Cab finalCab=null;
        for (Cab cab:cabs){
            if(cab.getAvailable() && cab.getType()==type){
                double distance=cab.getLocation().distance(location);
                if(distance<min){
                    min=distance;
                    finalCab=cab;
                }
            }
        }
        return finalCab;
    }
}
