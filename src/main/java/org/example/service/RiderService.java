package org.example.service;

import org.example.model.Rider;

import java.util.HashMap;
import java.util.Map;

public class RiderService {

    private Map<String, Rider> riderMap=new HashMap<>();

    public Rider registerRider(String id, String name){
        Rider rider=new Rider(id,name);
        riderMap.put(id,rider);
        return rider;
    }

    public Rider getRider(String id){
        return riderMap.get(id);
    }
}
