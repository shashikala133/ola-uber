package org.example.service;

import org.example.model.Cab;
import org.example.model.Location;
import org.example.model.VehicleType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CabService {

    Map<String,Cab> cabs=new HashMap<>();

    public void registerCab(String id, String driverName, VehicleType vehicleType, Location location){
        Cab cab=new Cab(id,driverName,vehicleType,location);
        cabs.put(id,cab);
    }

    public Cab findCab(Location location, VehicleType type){
        double min=Double.MAX_VALUE;
        Cab finalCab=null;
        for (Map.Entry<String,Cab> entry:cabs.entrySet()){
            if(entry.getValue().getAvailable() && entry.getValue().getType()==type){
                double distance=entry.getValue().getLocation().distance(location);
                if(distance<min){
                    min=distance;
                    finalCab=entry.getValue();
                }
            }
        }
        return finalCab;
    }

    public List<VehicleType> vehicleTypes(){
        List<VehicleType> vehicleTypes=new ArrayList<>();
        for(Map.Entry<String,Cab> entry:cabs.entrySet()){
            vehicleTypes.add(entry.getValue().getType());
        }
        return vehicleTypes;
    }
}
